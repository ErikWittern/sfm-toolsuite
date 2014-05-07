/*
 * Project: 
 * 	Cockpit Valuation Server
 *
 * Author:  
 *	Christian Zirpins
 *
 * Last Change: 
 *	by:   $$Author: $$
 *	date: $$Date:   $$
 *
 * Copyright (c):
 * 	2011 Karlsruhe Institute of Technology (KIT)
 * 
 * License:
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you
 * 	may not use this file except in compliance with the License. You may
 * 	obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * 	Unless required by applicable law or agreed to in writing, software
 * 	distributed under the License is distributed on an "AS IS" BASIS,
 * 	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * 	implied. See the License for the specific language governing
 * 	permissions and limitations under the License.
 */

package edu.kit.cockpit.valuationserver.rest.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.dao.EvaluationVoteDao;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.helpers.StreamHandler;
import edu.kit.cockpit.valuationserver.lifecycle.Automaton;
import edu.kit.cockpit.valuationserver.lifecycle.LifecycleException;
import edu.kit.cockpit.valuationserver.lifecycle.Transition;
import edu.kit.cockpit.valuationserver.lifecycle.Transition.Action;
import edu.kit.cockpit.valuationserver.mappers.EvaluationMapper;
import edu.kit.cockpit.valuationserver.mappers.SingleVoteMapper;
import edu.kit.cockpit.valuationserver.rest.clients.DPInteractionException;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluations;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;

@Path("/evaluations")
public class EvaluationRS {

	private Log log = LogFactory.getLog(EvaluationRS.class);

	@GET
	@Produces(CVSrvContext.EVALUATIONS_MIME_TYPE)
	public Response getEvaluations(
			@QueryParam("evaluationId") String evaluationId,
			@QueryParam("serviceId") String serviceId,
			@QueryParam("stakeholderGroup") String stakeholderGroup) {

		log.info("GET /evaluations call received. "
				+ "Query parameters: evaluationId='" + evaluationId
				+ "', serviceId='" + serviceId + "', stakeholderGroup='"
				+ stakeholderGroup + "'");

		List<EvaluationE> results = null;

		try {
			EvaluationVoteDao evalDao = new EvaluationVoteDao();

			if (evaluationId != null && evaluationId != "") {
				// read result without query as evaluationId is primary key
				EvaluationE evalE = evalDao.readEntity(EvaluationE.class,
						Long.valueOf(evaluationId));
				if (evalE != null) {
					results = new LinkedList<EvaluationE>();
					results.add(evalE);
				} else
					return Response.status(Response.Status.NOT_FOUND).build();
			} else if (serviceId != null && serviceId != "") {
				results = evalDao
						.queryEntities(EvaluationE.QUERY_BY_SERVICE_ID,
								"serviceId", serviceId);
				if (results.isEmpty())
					return Response.status(Response.Status.NOT_FOUND).build();
			} else if (stakeholderGroup != null && stakeholderGroup != "") {
				results = evalDao.queryEntities(
						EvaluationE.QUERY_BY_STAKEHOLDER_GROUP,
						"stakeholderGroup", stakeholderGroup);
				if (results.isEmpty())
					return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				results = evalDao.readAllEntities(EvaluationE.class);
			}

		} catch (Exception e) {
			log.error("Error retrieving evaluations", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		Evaluations evaluations = EvaluationMapper
				.mapToEvaluationsMessage(results);

		if (evaluations == null) {
			log.error("Error creating response message");
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		} else
			return Response.ok(evaluations)
					.type(CVSrvContext.EVALUATIONS_MIME_TYPE).build();
	}

	@POST
	@Consumes(CVSrvContext.EVALUATION_MIME_TYPE)
	@Produces(CVSrvContext.EVALUATION_MIME_TYPE)
	public Response postEvaluation(Evaluation evaluation) {

		log.info("POST /evaluations (" + CVSrvContext.EVALUATION_MIME_TYPE
				+ ") call received. " + " Query parameters: none");

		EvaluationE result = null;

		try {
			EvaluationVoteDao evalDao = new EvaluationVoteDao();
			result = evalDao.createAndReturnEntity(EvaluationMapper
					.mapToEvaluationEntity(evaluation, new EvaluationE()));
		} catch (Exception e) {
			log.error("Error creating evaluation", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		Evaluation reply = EvaluationMapper.mapToEvaluationMessage(result);

		if (reply == null) {
			log.error("Error creating response message");
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		} else {
			log.info("Returning response message for evaluation id:"
					+ reply.getEvaluationId() + ", name:" + reply.getName());
			return Response.ok(reply).type(CVSrvContext.EVALUATION_MIME_TYPE)
					.build();
		}
	}

	@GET
	@Path("{evaluationId}")
	@Produces(CVSrvContext.EVALUATION_MIME_TYPE)
	public Response getEvaluation(@PathParam("evaluationId") String evaluationId) {

		log.info("GET /evaluations/" + evaluationId + " call received. "
				+ "Query parameters: none");

		EvaluationE evalE;

		try {
			EvaluationVoteDao evalDao = new EvaluationVoteDao();
			// read result without query as evaluationId is primary key
			evalE = evalDao.readEntity(EvaluationE.class,
					Long.valueOf(evaluationId));
		} catch (Exception e) {
			log.error("Error retrieving evaluation", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		if (evalE == null) {
			log.error("Requested evaluation could not be found");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		// Create reply from retrieved entity
		Evaluation reply = EvaluationMapper.mapToEvaluationMessage(evalE);

		if (reply == null) {
			log.error("Error creating response message");
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		} else
			return Response.ok(reply).type(CVSrvContext.EVALUATION_MIME_TYPE)
					.build();
	}

	@PUT
	@Path("{evaluationId}")
	@Consumes(CVSrvContext.EVALUATION_MIME_TYPE)
	@Produces(CVSrvContext.EVALUATION_MIME_TYPE)
	public Response putEvaluation(
			@PathParam("evaluationId") String evaluationId,
			Evaluation evaluation) {
		log.info("PUT /evaluations/" + evaluationId + " ("
				+ CVSrvContext.EVALUATION_MIME_TYPE + ") call received. "
				+ " Query parameters: none");

		EvaluationVoteDao evalDao = null;
		try {
			evalDao = new EvaluationVoteDao();
		} catch (Exception e) {
			log.error("Error on database access", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		// read result without query as evaluationId is primary key
		EvaluationE evalE = evalDao.readEntity(EvaluationE.class,
				Long.valueOf(evaluationId));
		if (evalE == null) {
			log.error("Requested evaluation could not be found");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		// make a copy of the original entity
		EvaluationE oldEvalE = EvaluationMapper.cloneEvaluationEntity(evalE);

		// change the original entity based on evaluation data
		EvaluationE newEvalE = EvaluationMapper.mapToEvaluationEntity(
				evaluation, evalE);
		if (newEvalE == null) {
			log.error("Problem while updating evaluation entity");
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}

		// map changed entity to reply message
		Evaluation reply = EvaluationMapper.mapToEvaluationMessage(newEvalE);
		if (reply == null) {
			log.error("Problem while creating evaluation message");
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Trigger evaluation lifecycle change. This causes an exceptions if not
		// allowed or things go wrong during DP interaction. If the new
		// evaluation is published for the first time, the poll id will be set
		// in the evaluation entity passed through the Transition object
		try {
			Transition t = new Transition(oldEvalE, newEvalE,
					Action.CHANGE_EVAL);
			Automaton.doTransition(t, false);
		} catch (LifecycleException e) {
			log.error(
					"Error in lifecycle management: requested operation not allowed in current state",
					e);
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		} catch (DPInteractionException e) {
			log.error("Error in DP interaction", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		// finally update changed entity in db
		evalDao.mergeEntity(newEvalE);

		return Response.ok(reply).type(CVSrvContext.EVALUATION_MIME_TYPE)
				.build();
	}

	@DELETE
	@Path("{evaluationId}")
	public Response deleteEvaluation(
			@PathParam("evaluationId") String evaluationId) {

		log.info("DELETE /evaluations/" + evaluationId + " call received. "
				+ " Query parameters: none");

		EvaluationVoteDao evalDao = null;

		try {
			evalDao = new EvaluationVoteDao();
		} catch (Exception e) {
			log.error("Error on database access", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		// read result without query as evaluationId is primary key
		EvaluationE evalE = evalDao.readEntity(EvaluationE.class,
				Long.valueOf(evaluationId));

		if (evalE == null) {
			log.error("Requested evaluation could not be found");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		// delete sfm model if one exists

		SFMPersistency sfmp = new SFMPersistency();

		try {
			sfmp.deleteSFMModel(SFMPersistency.getModelId(evalE.getId()));
		} catch (IOException e) {
			log.info("Model file not deleted (there probably has non been uploaded yet)");
		}

		// delete entity in db (includes votes)
		evalDao.deleteEntity(evalE);

		return Response.ok().build();
	}

	@POST
	@Path("{evaluationId}")
	@Consumes(CVSrvContext.MODEL_MIME_TYPE)
	public Response postModel(@PathParam("evaluationId") String evaluationId,
			InputStream is) {
		log.info("POST /evaluations/" + evaluationId + " ("
				+ CVSrvContext.MODEL_MIME_TYPE + ") call received. "
				+ "Query parameters: none");

		// retrieve evaluation entity and read out service id
		EvaluationE evalE;

		try {
			EvaluationVoteDao evalDao = new EvaluationVoteDao();
			// read result without query as evaluationId is primary key
			evalE = evalDao.readEntity(EvaluationE.class,
					Long.valueOf(evaluationId));
		} catch (Exception e) {
			log.error("Error while retrieving evaluation", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		if (evalE == null) {
			log.info("Evaluation entity not found");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		// read model content
		String input = null;
		try {
			StreamHandler streamhandler = new StreamHandler();
			byte[] bytes = streamhandler.readFromStream(is);
			input = new String(bytes);
		} catch (IOException e) {
			log.error("Error reading servce feature model from request", e);
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}

		// invoke SFMPersistency
		SFMPersistency sfmpersistency = new SFMPersistency();
		String modelId = SFMPersistency.getModelId(evalE.getId());
		try {
			sfmpersistency.saveSFMModel(modelId, input);
		} catch (IOException e) {
			log.error("Error persisting model", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		return Response
				.created(URI.create(SFMPersistency.getModelURL(modelId)))
				.build();
	}

	@POST
	@Path("{evaluationId}")
	@Consumes(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
	@Produces(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
	public Response postSingleVote(
			@PathParam("evaluationId") String evaluationId, Vote vote) {

		log.info("POST /evaluations/" + evaluationId + " ("
				+ CVSrvContext.SINGLE_VOTE_MIME_TYPE
				+ ") call received. No query parameters.");

		EvaluationVoteDao evalVoteDao = null;

		try {
			evalVoteDao = new EvaluationVoteDao();
		} catch (Exception e) {
			log.error("Error during database access", e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		// retrieve fundamental evaluation entity
		// //////////////////////////////////////

		// read result without query as evaluationId is primary key
		EvaluationE evalE = evalVoteDao.readEntity(EvaluationE.class,
				Long.valueOf(evaluationId));

		if (evalE == null) {
			log.info("Evaluation entity not found");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		// map message to new vote and preference entities
		// ///////////////////////////////////////////////

		// map message to entity
		SingleVoteE mappedSingleVoteE = SingleVoteMapper
				.voteMessageToSingleVoteEntity(vote, new SingleVoteE());

		// if mapping has failed this is the end
		if (mappedSingleVoteE == null) {
			log.info("There is something wrong with the vote");
			throw new WebApplicationException(Response.Status.BAD_REQUEST);

		}

		// persist all entities involved in the mapping
		// ////////////////////////////////////////////

		// persist vote entity
		SingleVoteE persistedSingleVoteE = evalVoteDao
				.createAndReturnEntity(mappedSingleVoteE);

		// persist preference entities
		for (PreferenceE prefE : persistedSingleVoteE.getPreferences()) {
			evalVoteDao.createEntity(prefE);
		}

		// link vote and evaluation entities
		mappedSingleVoteE.setContainerEvaluation(evalE);
		evalE.addSingleVote(mappedSingleVoteE);

		// update database tables
		evalVoteDao.mergeEntity(evalE);
		evalVoteDao.mergeEntity(mappedSingleVoteE);

		// generate and send back reply message
		// ////////////////////////////////////

		Vote reply = SingleVoteMapper
				.singleVoteEntityToVoteMessage(mappedSingleVoteE);

		if (reply == null) {
			log.error("Error creating response message");
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		} else
			return Response.ok(reply).type(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
					.build();

	}// postVote

}// EvaluatioRS
