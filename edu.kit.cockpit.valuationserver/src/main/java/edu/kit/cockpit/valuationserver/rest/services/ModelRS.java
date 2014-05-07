/*
 * Project: 
 * 	Cockpit Valuation Server
 *
 * Author:  
 *	Benjamin Bolland
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.dao.EvaluationVoteDao;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.helpers.StreamHandler;
import edu.kit.cockpit.valuationserver.lifecycle.Automaton;
import edu.kit.cockpit.valuationserver.lifecycle.LifecycleException;
import edu.kit.cockpit.valuationserver.lifecycle.Transition;
import edu.kit.cockpit.valuationserver.lifecycle.Transition.Action;
import edu.kit.cockpit.valuationserver.rest.clients.DPInteractionException;
import edu.kit.cockpit.valuationserver.rest.messages.ModelList;
import edu.kit.cockpit.valuationserver.rest.messages.ModelList.Models;
import edu.kit.cockpit.valuationserver.rest.messages.ObjectFactory;
import edu.kit.cockpit.valuationserver.sfmpersistency.FileUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;

@Path(CVSrvContext.MODEL_URL_PREFIX)
public class ModelRS {

	private Log log = LogFactory.getLog(EvaluationRS.class);
	private SFMPersistency sfmpersistency = new SFMPersistency();

	/**
	 * Produces a XML file with all saved ServiceFeatureModels and their
	 * Resource URI
	 * 
	 * @return
	 */
	@GET
	@Produces(CVSrvContext.MODELS_MIME_TYPE)
	public Response getModels() {

		log.info("GET " + CVSrvContext.MODEL_URL_PREFIX + " call received. "
				+ "Query parameters: none");

		File dir = new File(CVSrvContext.getInstance()
				.getSfmPersistencyDirectory());
		File[] fileList = dir.listFiles();

		if (fileList == null) {
			log.error("Error reading SFM persistence directory");
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		ModelList modellist = new ObjectFactory().createModelList();
		Models models = new Models();
		modellist.setModels(models);

		if (fileList.length != 0) {
			for (int i = 0; i < fileList.length; i++) {
				// View only .sfm files
				if (fileList[i].getName().endsWith(
						CVSrvContext.SFM_FILE_EXTENSION)) {
					String modelId = FileUtil
							.deleteExtensionFromFilename(fileList[i].getName());
					// create Model
					Models.Model model = new Models.Model();
					model.setModelId(modelId);
					model.setModelState(1);
					model.setModelUrl(SFMPersistency.getModelURL(modelId));
					models.getModel().add(model);
				}
			}
		}

		return Response.ok(modellist).type(CVSrvContext.MODELS_MIME_TYPE)
				.build();
	}

	/**
	 * Returns single ServiceFeatureModel
	 * 
	 **/
	@GET
	@Path("/{modelId}")
	@Produces(CVSrvContext.MODEL_MIME_TYPE)
	public Response getModel(@PathParam("modelId") String modelId) {
		log.info("GET " + CVSrvContext.MODEL_URL_PREFIX + modelId
				+ " call received. " + "Query parameters: none");

		String result = null;

		try {
			result = sfmpersistency.loadSFMModelToString(modelId);
		} catch (IOException e) {
			log.error(e);
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		if (result == null)
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);

		return Response.ok(result).type(CVSrvContext.MODEL_MIME_TYPE).build();
	}

	@PUT
	@Path("/{modelId}")
	@Consumes(CVSrvContext.MODEL_MIME_TYPE)
	/**
	 * Updates a SFM Model on the server filesystem
	 * 
	 **/
	public Response putModel(@PathParam("modelId") String modelId,
			InputStream is) {
		log.info("PUT " + CVSrvContext.MODEL_URL_PREFIX + modelId
				+ " call received. " + "Query parameters: none");

		byte[] bytes = null;

		try {
			StreamHandler streamhandler = new StreamHandler();
			bytes = streamhandler.readFromStream(is);
		} catch (IOException e) {
			log.info(e);
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}

		String input = new String(bytes);

		// Check if operation is allowed in current state of
		// associated evaluation
		try {
			EvaluationVoteDao evalDao = new EvaluationVoteDao();
			EvaluationE evalE = evalDao.readEntity(EvaluationE.class,
					SFMPersistency.getEvaluationId(modelId));
			if (evalE != null) {
				Transition transition = new Transition(evalE, evalE,
						Action.CHANGE_MODEL);
				Automaton.doTransition(transition, true);
			} else
				log.warn("Requested Model has no associated evaluation");
		} catch (LifecycleException e) {
			log.error(e);
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		} catch (DPInteractionException e) {
			log.error(e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		} catch (NamingException e) {
			log.error(e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		// call SFMPersistency
		try {
			sfmpersistency.updateSFMModel(modelId, input);
		} catch (IOException e) {
			log.error(e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		return Response
				.created(URI.create(SFMPersistency.getModelURL(modelId)))
				.build();
	}

	@DELETE
	@Path("/{modelId}")
	/**
	 * Deletes a SFM Model on the server file system
	 * 
	 **/
	public Response deleteModel(@PathParam("modelId") String modelId) {
		log.info("DELETE " + CVSrvContext.MODEL_URL_PREFIX + modelId
				+ " call received. " + "Query parameters: none");

		// Check if operation is allowed in current state of
		// associated evaluation
		try {
			EvaluationVoteDao evalDao = new EvaluationVoteDao();
			EvaluationE evalE = evalDao.readEntity(EvaluationE.class,
					SFMPersistency.getEvaluationId(modelId));
			if (evalE != null) {
				Transition transition = new Transition(evalE, evalE,
						Action.CHANGE_MODEL);
				Automaton.doTransition(transition, true);
			} else
				log.warn("Requested Model has no associated evaluation");
		} catch (LifecycleException e) {
			log.error(e);
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		} catch (DPInteractionException e) {
			log.error(e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		} catch (NamingException e) {
			log.error(e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		try {
			sfmpersistency.deleteSFMModel(modelId);
		} catch (IOException e) {
			log.error(e);
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		return Response.ok().build();
	}

}