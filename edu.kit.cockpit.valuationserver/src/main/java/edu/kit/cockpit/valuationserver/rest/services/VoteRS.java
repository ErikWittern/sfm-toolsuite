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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.Resource;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.aggregator.AbstractAggregator;
import edu.kit.cockpit.valuationserver.aggregator.SimpleAggregator;
import edu.kit.cockpit.valuationserver.dao.EvaluationVoteDao;
import edu.kit.cockpit.valuationserver.entities.AggregatedVoteE;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.entities.VoteE;
import edu.kit.cockpit.valuationserver.mappers.AggregatedVoteMapper;
import edu.kit.cockpit.valuationserver.mappers.ConfigurationMapper;
import edu.kit.cockpit.valuationserver.mappers.SingleVoteMapper;
import edu.kit.cockpit.valuationserver.rest.messages.Configuration;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.rest.messages.Votes;
import edu.kit.cockpit.valuationserver.sfmpersistency.EMFUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;
import edu.kit.cockpit.valuationserver.valuation.SimpleAHPAdapter;

@Path("/votes")
public class VoteRS {

	private Log log = LogFactory.getLog(VoteRS.class);

	/**
	 * Retrieves list of single votes
	 * 
	 * @param voteId
	 *            to search for
	 * @param citizenId
	 *            to search for
	 * @return list of single votes
	 */
	@GET
	@Path("single")
	@Produces(CVSrvContext.SINGLE_VOTES_MIME_TYPE)
	public Response getSingleVotes(@QueryParam("voteId") String voteId,
			@QueryParam("voterId") String voterId) {

		log.info("GET /votes/single (" + CVSrvContext.SINGLE_VOTES_MIME_TYPE
				+ "). Query parameters voteId=" + voteId + ", voterId="
				+ voterId + ".");

		List<SingleVoteE> results = null;

		try {
			EvaluationVoteDao evalDao = new EvaluationVoteDao();

			if (voteId != null && voteId != "") {
				// read result without query as voteId is primary key
				SingleVoteE voteE = evalDao.readEntity(SingleVoteE.class,
						Long.valueOf(voteId));
				if (voteE != null) {
					results = new LinkedList<SingleVoteE>();
					results.add(voteE);
				} else
					return Response.status(Response.Status.NOT_FOUND).build();
			} else if (voterId != null && voterId != "") {
				results = evalDao.queryEntities(SingleVoteE.QUERY_BY_VOTER_ID,
						"voterId", voterId);
				if (results.isEmpty())
					return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				results = evalDao.readAllEntities(SingleVoteE.class);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		Votes votes = SingleVoteMapper.singleVoteEntitiesToVotes(results);

		if (votes == null)
			return Response.serverError().build();
		else
			return Response.ok(votes).type(CVSrvContext.SINGLE_VOTES_MIME_TYPE)
					.build();
	}

	/**
	 * Retrieves single vote
	 * 
	 * @param voteId
	 *            of single vote
	 * @returnrep resentation of single vote
	 */
	@GET
	@Path("single/{voteId}")
	@Produces(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
	public Response getSingleVote(@PathParam("voteId") String voteId) {

		log.info("GET /votes/single/" + voteId + " ("
				+ CVSrvContext.SINGLE_VOTE_MIME_TYPE
				+ "). Path parameter voteId=" + voteId + ".");

		SingleVoteE voteE;

		try {
			EvaluationVoteDao evalVoteDao = new EvaluationVoteDao();
			// read result without query as evaluationId is primary key
			voteE = evalVoteDao.readEntity(SingleVoteE.class,
					Long.valueOf(voteId));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		if (voteE == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		// Create reply from retrieved entity
		Vote reply = SingleVoteMapper.singleVoteEntityToVoteMessage(voteE);

		if (reply == null)
			return Response.serverError().build();
		else
			return Response.ok(reply).type(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
					.build();
	}

	/**
	 * Replaces single vote. The new vote needs to specify preferences. All
	 * former preferences will be deleted.
	 * 
	 * @param voteId
	 *            of single vote
	 * @param vote
	 *            to replace the current one with
	 * @return representation of changed single vote
	 */
	@PUT
	@Path("single/{voteId}")
	@Produces(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
	@Consumes(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
	public Response putSingleVote(@PathParam("voteId") String voteId, Vote vote) {

		log.info("PUT /votes/single/" + voteId + " ("
				+ CVSrvContext.SINGLE_VOTE_MIME_TYPE
				+ "). Path parameter voteId=" + voteId + ".");

		EvaluationVoteDao evalVoteDao = null;

		try {
			evalVoteDao = new EvaluationVoteDao();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		// read result without query as evaluationId is primary key
		SingleVoteE oldSingleVoteE = evalVoteDao.readEntity(SingleVoteE.class,
				Long.valueOf(voteId));

		if (oldSingleVoteE == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		// remember old preferences

		Set<PreferenceE> oldPrefSet = new HashSet<PreferenceE>();
		for (PreferenceE preferenceE : oldSingleVoteE.getPreferences()) {
			oldPrefSet.add(preferenceE);
		}

		// change retrieved entity based on evaluation data
		SingleVoteE newSingleVoteE = SingleVoteMapper
				.voteMessageToSingleVoteEntity(vote, oldSingleVoteE);

		if (newSingleVoteE == null)
			return Response.status(Response.Status.BAD_REQUEST).build();

		// map changed entity to reply message
		Vote reply = SingleVoteMapper
				.singleVoteEntityToVoteMessage(newSingleVoteE);

		if (reply == null)
			return Response.serverError().build();

		// delete old prefs
		for (PreferenceE preferenceE : oldPrefSet) {
			preferenceE.getVote().removePreference(preferenceE);
			evalVoteDao.deleteEntity(preferenceE);
		}

		// persist new prefs
		for (PreferenceE preferenceE : newSingleVoteE.getPreferences()) {
			evalVoteDao.createEntity(preferenceE);
		}

		// update vote
		evalVoteDao.mergeEntity(newSingleVoteE);

		return Response.ok(reply).type(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
				.build();
	}

	/**
	 * Deletes single vote
	 * 
	 * @param voteId
	 *            of single vote
	 * @return status
	 */
	@DELETE
	@Path("single/{voteId}")
	public Response deleteSingleVote(@PathParam("voteId") String voteId) {

		log.info("DELETE /votes/single/" + voteId
				+ " (no mime type). Path parameter voteId=" + voteId + ".");

		EvaluationVoteDao evalVoteDao = null;

		try {
			evalVoteDao = new EvaluationVoteDao();
		} catch (Exception e) {
			log.error(e);
			return Response.serverError().build();
		}

		// read result without query as evaluationId is primary key
		SingleVoteE singleVoteE = evalVoteDao.readEntity(SingleVoteE.class,
				Long.valueOf(voteId));

		if (singleVoteE == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		// delete entity in db
		evalVoteDao.deleteEntity(singleVoteE);

		return Response.ok().build();
	}

	/**
	 * Triggers configuration for associated single vote
	 * 
	 * @param voteId
	 *            of single vote
	 * @return optimum configuration for associated vote
	 */
	@GET
	@Path("single/{voteId}/config")
	@Produces(CVSrvContext.CONFIGURATION_MIME_TYPE)
	public Response getSingleVoteConfig(@PathParam("voteId") String voteId) {

		log.info("GET /votes/single/" + voteId + "/config ("
				+ CVSrvContext.CONFIGURATION_MIME_TYPE
				+ "). Path parameter voteId=" + voteId + ".");

		SingleVoteE voteE;

		try {
			EvaluationVoteDao evalVoteDao = new EvaluationVoteDao();
			// read result without query as evaluationId is primary key
			voteE = evalVoteDao.readEntity(SingleVoteE.class,
					Long.valueOf(voteId));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		if (voteE == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		Configuration config = null;

		try {
			config = configure(voteE, voteE.getContainerEvaluation());
		} catch (IOException e) {
			log.error(e);
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		if (config == null)
			return Response.serverError().build();
		else
			return Response.ok(config)
					.type(CVSrvContext.CONFIGURATION_MIME_TYPE).build();
	}

	/**
	 * Returns aggregated votes according to the mime type (simple aggregation).
	 * Vote aggregation must have been triggered before by PUT.
	 * 
	 * @return list of aggregated votes (exactly one in case of simple
	 *         aggregation)
	 */
	@GET
	@Path("aggregated")
	@Produces(CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE)
	public Response getSimpleAggregatedVotes(
			@QueryParam("evaluationId") String evaluationId) {

		log.info("GET /votes/aggregated" + " ("
				+ CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE
				+ "). Query parameter evaluationId='" + evaluationId + "'");

		EvaluationVoteDao evalDao;

		try {
			evalDao = new EvaluationVoteDao();
		} catch (Exception e) {
			log.error(e);
			return Response.serverError().build();
		}

		// read result without query as evaluationId is primary key
		EvaluationE evalE = evalDao.readEntity(EvaluationE.class,
				Long.valueOf(evaluationId));

		if (evalE == null) {
			log.error("Evaluation entity not found");
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		AbstractAggregator sa = new SimpleAggregator();

		List<AggregatedVoteE> simpleAggregatedVoteEList = sa
				.getAggregatedVotes(evalE,
						AbstractAggregator.AggregationType.GEOMETRIC_MEANS);

		if (simpleAggregatedVoteEList.isEmpty()) {
			log.error("Aggregated votes do not exist");
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		Votes votes = AggregatedVoteMapper
				.aggregatedVoteEntitiesToVotes(simpleAggregatedVoteEList);

		if (votes == null)
			return Response.serverError().build();
		else
			return Response.ok(votes)
					.type(CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE)
					.build();
	}

	/**
	 * Triggers vote aggregation according to the mime type (simple
	 * aggregation).
	 * 
	 * @return list of aggregated votes (exactly one in case of simple
	 *         aggregation)
	 */
	@POST
	@Path("aggregated")
	@Produces(CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE)
	public Response postSimpleAggregatedVote(
			@QueryParam("evaluationId") String evaluationId) {

		log.info("POST /votes/aggregated" + " ("
				+ CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE
				+ "). Query parameter evaluationId='" + evaluationId + "'");

		EvaluationVoteDao evalDao;

		try {
			evalDao = new EvaluationVoteDao();
		} catch (Exception e) {
			log.error(e);
			return Response.serverError().build();
		}

		// read result without query as evaluationId is primary key
		EvaluationE evalE = evalDao.readEntity(EvaluationE.class,
				Long.valueOf(evaluationId));

		if (evalE == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		// create SimpleAggregator
		AbstractAggregator sa = new SimpleAggregator();

		// get list of simple aggregated votes (max one)
		List<AggregatedVoteE> simpleAggregatedVoteEList = sa
				.getAggregatedVotes(evalE,
						AbstractAggregator.AggregationType.GEOMETRIC_MEANS);

		// if there are aggregated votes then delete them
		if (!simpleAggregatedVoteEList.isEmpty())
			sa.removeAggregation(evalE);

		// try to create the simple aggregated vote
		if (!sa.addAggregation(evalE)) {
			log.error("Simple aggragtion failed");
			return Response.serverError().build();
		}

		// again get list of simple aggregated votes (max one)
		simpleAggregatedVoteEList = sa.getAggregatedVotes(evalE,
				AbstractAggregator.AggregationType.GEOMETRIC_MEANS);

		Votes votes = AggregatedVoteMapper
				.aggregatedVoteEntitiesToVotes(simpleAggregatedVoteEList);

		if (votes == null)
			return Response.serverError().build();
		else
			return Response.ok(votes)
					.type(CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE)
					.build();
	}

	/**
	 * Returns simple vote aggregation results
	 * 
	 * @param voteId
	 *            of simple aggregated vote
	 * @return vote representation
	 */
	@GET
	@Path("aggregated/{evaluationId}/{voteId}")
	@Produces(CVSrvContext.SIMPLE_AGGREGATED_VOTE_MIME_TYPE)
	public Response getSimpleAggregatedVote(
			@PathParam("evaluationId") String evaluationId,
			@PathParam("voteId") String voteId) {

		log.info("GET /votes/aggregated/" + evaluationId + "/" + voteId + " ("
				+ CVSrvContext.SIMPLE_AGGREGATED_VOTE_MIME_TYPE
				+ "). Path parameter voteId=" + voteId + ".");

		AggregatedVoteE aggregatedVoteE;

		try {
			EvaluationVoteDao evalVoteDao = new EvaluationVoteDao();
			// read result without query as evaluationId is primary key
			aggregatedVoteE = evalVoteDao.readEntity(AggregatedVoteE.class,
					Long.valueOf(voteId));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		if (aggregatedVoteE == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		Vote reply = AggregatedVoteMapper
				.aggregatedVoteEntityToVoteMessage(aggregatedVoteE);

		if (reply == null)
			return Response.serverError().build();
		else
			return Response.ok(reply)
					.type(CVSrvContext.SIMPLE_AGGREGATED_VOTE_MIME_TYPE)
					.build();
	}

	/**
	 * Triggers configuration for associated aggregated vote
	 * 
	 * @param voteId
	 *            of aggregated vote
	 * @return optimum configuration for associated vote
	 */
	@GET
	@Path("aggregated/{evaluationId}/{voteId}/config")
	@Produces(CVSrvContext.CONFIGURATION_MIME_TYPE)
	public Response getAggregatedVoteConfig(
			@PathParam("evaluationId") String evaluationId,
			@PathParam("voteId") String voteId) {

		log.info("GET /votes/aggregated/" + voteId + "/config ("
				+ CVSrvContext.CONFIGURATION_MIME_TYPE
				+ "). Path parameter voteId=" + voteId + ".");

		AggregatedVoteE aggregatedVoteE;

		try {
			EvaluationVoteDao evalVoteDao = new EvaluationVoteDao();
			// read result without query as evaluationId is primary key
			aggregatedVoteE = evalVoteDao.readEntity(AggregatedVoteE.class,
					Long.valueOf(voteId));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		if (aggregatedVoteE == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		Configuration config = null;

		try {
			config = configure(aggregatedVoteE,
					aggregatedVoteE.getAggregatorEvaluation());
		} catch (IOException e) {
			log.error(e);
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		if (config == null)
			return Response.serverError().build();
		else
			return Response.ok(config)
					.type(CVSrvContext.CONFIGURATION_MIME_TYPE).build();
	}

	/**
	 * @param voteE
	 * @return
	 * @throws IOException
	 */
	private Configuration configure(VoteE voteE, EvaluationE evalE)
			throws IOException {

		// retrieve EMF resource and service object of the associated sfm
		SFMPersistency sfmp = new SFMPersistency();
		Resource resource = sfmp.loadSFMModelToResource(SFMPersistency
				.getModelId(evalE.getId()));
		Service service = EMFUtil.getService(resource);

		// compute preference vector via aotearoa
		//float[] preferenceVector = AotearoaAdapter
		//		.computeConfigurationPreferenceVector(service, voteE);

		// By erik:
		float[] preferenceVector = SimpleAHPAdapter.computeConfigurationPreferenceVector(service, voteE);
		
		
		
		// create configuration message from preference vector
		Configuration config = ConfigurationMapper.mapToConfigurationMessage(
				voteE, preferenceVector, service);

		return config;
	}

}
