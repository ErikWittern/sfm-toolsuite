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

package edu.kit.cockpit.valuationserver.rest.clients;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.pollgenerator.PollGenerator;
import eu.cockpit_project.ArrayOfPoll;
import eu.cockpit_project.ObjectFactory;
import eu.cockpit_project.PollType;

public class DeliberationPlatformClient {

	private static final Log log = LogFactory
			.getLog(DeliberationPlatformClient.class);

	private static final String DP_POLL_URL = "http://paris.atc.gr/cockpit-services/Services.mvc/Poll";
	private static final String DP_POLLS_URL = "http://paris.atc.gr/cockpit-services/Services.mvc/Polls";

	public static final String POLL_MIME_TYPE = "text/xml";
	public static final String POLLS_MIME_TYPE = "text/xml";
	public static final String POLLS_SERVICE_ID_PARAMETER = "serviceReference";

	/**
	 * Publish an Evaluation as a new poll
	 * 
	 * @param newEval
	 *            evaluation entity for which to create the poll
	 * @return success status
	 */
	public static void publishEvaluationPoll(EvaluationE newEval)
			throws DPInteractionException {
		// create new poll
		// return false if erroneous
		PollType newPoll;
		try {
			newPoll = PollGenerator.createPoll(newEval, true);
			if (newPoll == null) {
				throw new DPInteractionException(
						"Problem during poll generation");
			}
		} catch (DatatypeConfigurationException e) {
			throw new DPInteractionException("Problem during poll generation");
		}
		// try to POST updated poll to DP
		PollType resultPoll;
		resultPoll = postPoll(newPoll);

		// check if a proper poll was returned
		if (resultPoll == null)
			throw new DPInteractionException(
					"DP returned empty poll afer posting");
		else if (resultPoll.getPollId() == null)
			throw new DPInteractionException(
					"DP returned poll without id afer posting");

		log.info("Poll was successfully created on the DP: " + newPoll.toString());
		
		// write poll id to evaluation entity
		newEval.setPollId(resultPoll.getPollId());

		// if we made it up to here all is fine
	}

	/**
	 * First make sure that the poll is deployed, then replace it with an update
	 * 
	 * @param isVisible
	 *            determines visibility of the new poll on the DP
	 * @param newEval
	 *            evaluation entity containing the update
	 * @return success status
	 * @throws DPInteractionException
	 */
	public static void updateEvaluationPoll(boolean isVisible,
			EvaluationE newEval) throws DPInteractionException {
		// GET poll list for associated service from DP
		// return false if that fails
		ArrayOfPoll polls = getPolls(newEval.getServiceId());
		if (polls == null)
			throw new DPInteractionException("Reading poll list from DP failed");
		// retrieve specific poll
		// return false if not found
		PollType currentPoll = null;
		List<PollType> pollTypeList = polls.getPoll();
		for (Iterator<PollType> iterator = pollTypeList.iterator(); iterator
				.hasNext();) {
			PollType pollType = (PollType) iterator.next();
			if (pollType.getPollId().equals(newEval.getPollId()))
				currentPoll = pollType;
		}
		if (currentPoll == null)
			throw new DPInteractionException(
					"Inconsistent state detected: aborted poll not deployed on DP");
		// create new poll
		// return false if erroneous
		PollType updatedPoll;
		try {
			updatedPoll = PollGenerator.createPoll(newEval, isVisible);
			if (updatedPoll == null)
				throw new DPInteractionException(
						"Problem during poll generation");
		} catch (DatatypeConfigurationException e) {
			throw new DPInteractionException("Problem during poll generation",
					e);
		}
		// try to PUT updated poll to DP
		putPoll(updatedPoll);
		// if we made it up to here all is fine
	}

	public static ArrayOfPoll getPolls(String serviceId)
			throws DPInteractionException {

		assert (serviceId != null);

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add(POLLS_SERVICE_ID_PARAMETER, serviceId);

		log.info("Issuing GET '" + DP_POLLS_URL + "?"
				+ POLLS_SERVICE_ID_PARAMETER + "=" + serviceId + "' ("
				+ POLL_MIME_TYPE + ")");

		WebResource wrs = Client.create().resource(DP_POLLS_URL);
		ClientResponse response = wrs.queryParams(queryParams)
				.accept(POLLS_MIME_TYPE).get(ClientResponse.class);

		log.info("GET polls request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			throw new DPInteractionException(
					"Deliberation platform returned inapproprite state ("
							+ response.getClientResponseStatus() + ")");

		return response.getEntity(ArrayOfPoll.class);
	}

	public static PollType postPoll(PollType poll)
			throws DPInteractionException {
		log.info("Issuing POST '" + DP_POLL_URL + "' (" + POLL_MIME_TYPE + ")");

		assert (poll != null);

		WebResource wrs = Client.create().resource(DP_POLL_URL);
		ClientResponse response = wrs.type(POLL_MIME_TYPE)
				.accept(POLL_MIME_TYPE)
				.post(ClientResponse.class, packagePollType(poll));

		log.info("POST poll request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			throw new DPInteractionException(
					"Deliberation platform returned inapproprite state ("
							+ response.getClientResponseStatus() + ")");

		return response.getEntity(PollType.class);
	}

	public static PollType putPoll(PollType poll) throws DPInteractionException {
		log.info("Issuing PUT '" + DP_POLL_URL + "' (" + POLL_MIME_TYPE + ")");

		assert (poll != null);

		WebResource wrs = Client.create().resource(DP_POLL_URL);
		ClientResponse response = wrs.type(POLL_MIME_TYPE)
				.accept(POLL_MIME_TYPE)
				.put(ClientResponse.class, packagePollType(poll));

		log.info("PUT poll request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			throw new DPInteractionException(
					"Deliberation platform returned inapproprite state ("
							+ response.getClientResponseStatus() + ")");

		return response.getEntity(PollType.class);
	}

	private static JAXBElement<PollType> packagePollType(PollType poll) {
		ObjectFactory of = new ObjectFactory();
		return of.createPoll(poll);
	}
}
