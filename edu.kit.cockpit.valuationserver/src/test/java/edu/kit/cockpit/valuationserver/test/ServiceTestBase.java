/*
 * Project: Cockpit Valuation Server
 * $Header: $
 * Author:  Christian Zirpins
 * Last Change: 
 *    by:   $Author: $
 *    date: $Date:   $
 * Copyright (c): KIT, 2011
 */

package edu.kit.cockpit.valuationserver.test;

import java.io.IOException;
import java.net.URI;
import java.util.GregorianCalendar;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.helpers.DateUtil;
import edu.kit.cockpit.valuationserver.mappers.EvaluationMapper;
import edu.kit.cockpit.valuationserver.rest.EmbeddedValuationServer;
import edu.kit.cockpit.valuationserver.rest.messages.Configuration;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluations;
import edu.kit.cockpit.valuationserver.rest.messages.ModelList;
import edu.kit.cockpit.valuationserver.rest.messages.ObjectFactory;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.rest.messages.Vote.Preference;
import edu.kit.cockpit.valuationserver.rest.messages.Votes;

/**
 * Provides basic REST service requests and dummy messages. Use these as
 * examples for accessing the valuation server REST API.
 */
public abstract class ServiceTestBase {

	protected static final String DPI_SERVICE_ID = "1";

	protected Log log = LogFactory.getLog(this.getClass());
	ObjectFactory of = new ObjectFactory();

	private Evaluation evalMsgDPI1;
	private Evaluation evalMsgDPI2;
	private Evaluation evalMsgDPI3;

	private Evaluation evalMsg1;
	private Evaluation evalMsg2;

	private Vote voteMsg1;
	private Vote voteMsg2;

	protected ServiceTestBase() {
		createMessages();
	}

	/**
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EmbeddedValuationServer.getInstance().start();
	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EmbeddedValuationServer.getInstance().stop();
	}

	/**
	 * @param evaluationId
	 * @param serviceId
	 * @param stakeholderGroup
	 * @return
	 */
	public Evaluations getEvaluations(String evaluationId, String serviceId,
			String stakeholderGroup) {

		String urlClnt = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.EVALUATION_URL_PREFIX;

		log.info("Issuing GET '" + urlClnt + "' ("
				+ CVSrvContext.EVALUATIONS_MIME_TYPE + ") "
				+ "Query parameters: evaluationId='" + evaluationId
				+ "', serviceId='" + serviceId + "', stakeholderGroup='"
				+ stakeholderGroup + "'");

		WebResource wrs = Client.create().resource(urlClnt);

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("evaluationId", evaluationId);
		queryParams.add("serviceId", serviceId);
		queryParams.add("stakeholderGroup", stakeholderGroup);

		ClientResponse response = wrs.queryParams(queryParams)
				.accept(CVSrvContext.EVALUATIONS_MIME_TYPE)
				.get(ClientResponse.class);

		log.info("GET evaluations request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Evaluations.class);
	}

	/**
	 * @param evaluation
	 * @return
	 */
	public Evaluation postEvaluation(Evaluation evaluation) {

		String urlClnt = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.EVALUATION_URL_PREFIX;

		log.info("Issuing POST '" + urlClnt + "' ("
				+ CVSrvContext.EVALUATION_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(urlClnt);

		ClientResponse response = wrs.type(CVSrvContext.EVALUATION_MIME_TYPE)
				.accept(CVSrvContext.EVALUATION_MIME_TYPE)
				.post(ClientResponse.class, evaluation);

		log.info("POST evaluations request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Evaluation.class);
	}

	/**
	 * @param url
	 * @return
	 */
	public Evaluation getEvaluation(String url) {

		log.info("Issuing GET '" + url + "' ("
				+ CVSrvContext.EVALUATION_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs.accept(CVSrvContext.EVALUATION_MIME_TYPE)
				.get(ClientResponse.class);

		log.info("GET evaluation request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Evaluation.class);
	}

	/**
	 * @param url
	 * @param newEval
	 * @return
	 */
	public Evaluation putEvaluation(String url, Evaluation newEval) {

		log.info("Issuing PUT '" + url + "' ("
				+ CVSrvContext.EVALUATION_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs.type(CVSrvContext.EVALUATION_MIME_TYPE)
				.accept(CVSrvContext.EVALUATION_MIME_TYPE)
				.put(ClientResponse.class, newEval);

		log.info("PUT evaluation request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Evaluation.class);
	}

	/**
	 * @param url
	 * @return
	 */
	public Status deleteEvaluation(String url) {

		log.info("Issuing DELETE '" + url + "' ("
				+ CVSrvContext.EVALUATION_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs.accept(CVSrvContext.EVALUATION_MIME_TYPE)
				.delete(ClientResponse.class);

		log.info("DELETE evaluation request returned status '"
				+ response.getClientResponseStatus() + "'");

		return response.getClientResponseStatus();
	}

	/**
	 * @param voteId
	 * @param voterId
	 * @return
	 */
	public Votes getSingleVotes(String voteId, String voterId) {

		String urlClnt = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.VOTE_BASE_URL_PREFIX
				+ CVSrvContext.SINGLE_VOTE_URL_PREFIX;

		log.info("Issuing GET '" + urlClnt + "' ("
				+ CVSrvContext.SINGLE_VOTES_MIME_TYPE + ") "
				+ "Query parameters: voteId='" + voteId + "', voterId='"
				+ voterId + "'");

		WebResource wrs = Client.create().resource(urlClnt);

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("voteId", voteId);
		queryParams.add("voterId", voterId);

		ClientResponse response = wrs.queryParams(queryParams)
				.accept(CVSrvContext.SINGLE_VOTES_MIME_TYPE)
				.get(ClientResponse.class);

		log.info("GET single votes request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Votes.class);
	}

	/**
	 * @param evalUrl
	 * @param voteMsg
	 * @return
	 */
	public Vote postSingleVote(String evalUrl, Vote voteMsg) {

		log.info("Issuing POST '" + evalUrl + "' ("
				+ CVSrvContext.SINGLE_VOTE_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(evalUrl);

		ClientResponse response = wrs.type(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
				.accept(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
				.post(ClientResponse.class, voteMsg);

		log.info("POST single vote request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Vote.class);
	}

	/**
	 * @param url
	 * @return
	 */
	public Vote getSingleVote(String url) {

		log.info("Issuing GET '" + url + "' ("
				+ CVSrvContext.SINGLE_VOTE_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs
				.accept(CVSrvContext.SINGLE_VOTE_MIME_TYPE).get(
						ClientResponse.class);

		log.info("GET single vote request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Vote.class);
	}

	/**
	 * @param url
	 * @return
	 */
	public Configuration getVoteConfig(String url) {

		log.info("Issuing GET '" + url + "' ("
				+ CVSrvContext.CONFIGURATION_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs.accept(
				CVSrvContext.CONFIGURATION_MIME_TYPE).get(ClientResponse.class);

		log.info("GET single vote config request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Configuration.class);
	}

	/**
	 * @param url
	 * @param newVote
	 * @return
	 */
	public Vote putSingleVote(String url, Vote newVote) {

		log.info("Issuing PUT '" + url + "' ("
				+ CVSrvContext.SINGLE_VOTE_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs.type(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
				.accept(CVSrvContext.SINGLE_VOTE_MIME_TYPE)
				.put(ClientResponse.class, newVote);

		log.info("PUT single vote request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Vote.class);
	}

	public Status deleteSingleVote(String url) {

		log.info("Issuing DELETE '" + url + "' (no mime type)");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs.delete(ClientResponse.class);

		log.info("DELETE single vote request returned status '"
				+ response.getClientResponseStatus() + "'");

		return response.getClientResponseStatus();
	}

	public Votes postSimpleAggregatedVote(String evaluationId) {

		String urlClnt = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.VOTE_BASE_URL_PREFIX
				+ CVSrvContext.AGGREGATED_VOTE_URL_PREFIX;

		log.info("Issuing POST '" + urlClnt + "' ("
				+ CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE + ") "
				+ "Query parameters: evaluationId='" + evaluationId + "'");

		WebResource wrs = Client.create().resource(urlClnt);

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("evaluationId", evaluationId);

		ClientResponse response = wrs.queryParams(queryParams)
				.accept(CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE)
				.post(ClientResponse.class);

		log.info("POST simple aggregated votes request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Votes.class);
	}

	public Votes getSimpleAggregatedVotes(String evaluationId) {

		String urlClnt = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.VOTE_BASE_URL_PREFIX
				+ CVSrvContext.AGGREGATED_VOTE_URL_PREFIX;

		log.info("Issuing GET '" + urlClnt + "' ("
				+ CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE + ") "
				+ "Query parameters: evaluationId='" + evaluationId + "'");

		WebResource wrs = Client.create().resource(urlClnt);

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("evaluationId", evaluationId);

		ClientResponse response = wrs.queryParams(queryParams)
				.accept(CVSrvContext.SIMPLE_AGGREGATED_VOTES_MIME_TYPE)
				.get(ClientResponse.class);

		log.info("GET simple aggregated votes request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Votes.class);
	}

	public Vote getSimpleAggregatedVote(String url) {

		log.info("Issuing GET '" + url + "' ("
				+ CVSrvContext.SIMPLE_AGGREGATED_VOTE_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(url);

		ClientResponse response = wrs.accept(
				CVSrvContext.SIMPLE_AGGREGATED_VOTE_MIME_TYPE).get(
				ClientResponse.class);

		log.info("GET simple aggregated vote request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(Vote.class);
	}

	public URI postModel(String evalUrl, String modelSource) {
		log.info("Issuing POST '" + evalUrl + "' ("
				+ CVSrvContext.MODEL_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(evalUrl);
		ClientResponse response = wrs.type(CVSrvContext.MODEL_MIME_TYPE).post(
				ClientResponse.class, modelSource);

		URI location = response.getLocation();

		log.info("POST model request returned status '"
				+ response.getClientResponseStatus() + "' and location is '"
				+ location + "'");

		if (!response.getClientResponseStatus().equals(
				ClientResponse.Status.CREATED))
			return null;

		return location;
	}

	public ModelList getModels() {
		String modelsUrl = CVSrvContext.getInstance()
				.getValuationServerUrlBase() + CVSrvContext.MODEL_URL_PREFIX;

		log.info("Issuing GET '" + modelsUrl + "' ("
				+ CVSrvContext.MODELS_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(modelsUrl);
		ClientResponse response = wrs.accept(CVSrvContext.MODELS_MIME_TYPE)
				.get(ClientResponse.class);

		log.info("GET models request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(ModelList.class);
	}

	public String getModel(String modelUrl) {
		log.info("Issuing GET '" + modelUrl + "' ("
				+ CVSrvContext.MODEL_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(modelUrl);
		ClientResponse response = wrs.accept(CVSrvContext.MODEL_MIME_TYPE).get(
				ClientResponse.class);

		log.info("GET model request returned status '"
				+ response.getClientResponseStatus() + "'");

		if (!response.getClientResponseStatus()
				.equals(ClientResponse.Status.OK))
			return null;

		return response.getEntity(String.class);
	}

	public URI putModel(String modelUrl, String modelSource) throws IOException {
		log.info("Issuing PUT '" + modelUrl + "' ("
				+ CVSrvContext.MODEL_MIME_TYPE + ") ");

		WebResource wrs = Client.create().resource(modelUrl);
		ClientResponse response = wrs.type(CVSrvContext.MODEL_MIME_TYPE).put(
				ClientResponse.class, modelSource);

		URI location = response.getLocation();

		log.info("PUT model request returned status '"
				+ response.getClientResponseStatus() + "' and location is '"
				+ location + "'");

		if (!response.getClientResponseStatus().equals(
				ClientResponse.Status.CREATED))
			return null;

		return location;
	}

	public Status deleteModel(String modelUrl) {
		log.info("Issuing DELETE '" + modelUrl + "'");

		WebResource wrs = Client.create().resource(modelUrl);
		ClientResponse response = wrs.delete(ClientResponse.class);

		log.info("DELETE model request returned status '"
				+ response.getClientResponseStatus() + "'");

		return response.getClientResponseStatus();
	}

	/**
	 * Generates dummy messages
	 */
	private void createMessages() {

		evalMsgDPI1 = new Evaluation();
		evalMsgDPI1.setServiceId(DPI_SERVICE_ID);
		evalMsgDPI1.setName("GR01");
		evalMsgDPI1.setVersion("v1");
		evalMsgDPI1
				.setDescription("GR01 is the best service around - isn't it?");
		evalMsgDPI1.setStakeholderGroup("Citizens");
		evalMsgDPI1.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.CREATED));

		try {
			evalMsgDPI1
					.setPollDeadline(DateUtil
							.getXmlGregCal(new GregorianCalendar(2020, 1, 1)
									.getTime()));
		} catch (DatatypeConfigurationException e) {
			log.error(e);
		}

		evalMsgDPI2 = new Evaluation();
		evalMsgDPI2.setServiceId(DPI_SERVICE_ID);
		evalMsgDPI2.setName("GR01");
		evalMsgDPI2.setVersion("v1");
		evalMsgDPI2
				.setDescription("GR01 is the best service around - isn't it?");
		evalMsgDPI2.setStakeholderGroup("Citizens");
		evalMsgDPI2.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.RUNNING));

		try {
			evalMsgDPI2
					.setPollDeadline(DateUtil
							.getXmlGregCal(new GregorianCalendar(2020, 1, 1)
									.getTime()));
		} catch (DatatypeConfigurationException e) {
			log.error(e);
		}

		evalMsgDPI3 = new Evaluation();
		evalMsgDPI3.setServiceId(DPI_SERVICE_ID);
		evalMsgDPI3.setName("GR01");
		evalMsgDPI3.setVersion("v1");
		evalMsgDPI3
				.setDescription("This evaluation assesses the new service GR01. Cost denotes the cost per invocation for the public administration. Throughput denotes the number of citizens that can be processed per hour. Home access allows citizens to access the service from home. Personal assistance denotes that the citizen can contact public service employees if needed.");
		evalMsgDPI3.setStakeholderGroup("Citizens");
		evalMsgDPI3.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.ABORTED));

		try {
			evalMsgDPI3
					.setPollDeadline(DateUtil
							.getXmlGregCal(new GregorianCalendar(2020, 1, 1)
									.getTime()));
		} catch (DatatypeConfigurationException e) {
			log.error(e);
		}

		evalMsg1 = new Evaluation();
		evalMsg1.setServiceId("4710ff47-4fc4-461a-bccd-6a45bd4974f4");
		evalMsg1.setName("GR01");
		evalMsg1.setVersion("v1");
		evalMsg1.setDescription("GR01 is the best service around - isn't it?");
		evalMsg1.setStakeholderGroup("Citizens");
		evalMsg1.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.CREATED));

		try {
			evalMsg1.setPollDeadline(DateUtil
					.getXmlGregCal(new GregorianCalendar(2020, 1, 1).getTime()));
		} catch (DatatypeConfigurationException e) {
			log.error(e);
		}

		evalMsg2 = new Evaluation();
		evalMsg2.setServiceId("4710ff47-4fc4-461a-bccd-6a45bd4974f4");
		evalMsg2.setName("GR01");
		evalMsg2.setVersion("v1");
		evalMsg2.setDescription("GR01 is still the best service around - isn't it?");
		evalMsg2.setStakeholderGroup("Citizens");
		// state is not changed in order not to trigger DP interaction
		evalMsg2.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.CREATED));

		try {
			evalMsg2.setPollDeadline(DateUtil
					.getXmlGregCal(new GregorianCalendar(2020, 1, 2).getTime()));
		} catch (DatatypeConfigurationException e) {
			log.error(e);
		}

		voteMsg1 = new Vote();
		voteMsg1.setAggregation(false);
		voteMsg1.setStakeholderGroup("Citizens");
		voteMsg1.setDescription("This is a vote for testing purpose.");
		voteMsg1.setVoterId("1");
		Preference pref1 = new Preference();
		pref1.setFeatureAttributeType1("Cost");
		pref1.setFeatureAttributeType2("Throughput");
		pref1.setPref1Over2(-9);
		voteMsg1.getPreference().add(pref1);
		Preference pref2 = new Preference();
		pref2.setFeatureAttributeType1("Cost");
		pref2.setFeatureAttributeType2("Sends mail");
		pref2.setPref1Over2(-9);
		voteMsg1.getPreference().add(pref2);
		Preference pref3 = new Preference();
		pref3.setFeatureAttributeType1("Cost");
		pref3.setFeatureAttributeType2("Processing time");
		pref3.setPref1Over2(-9);
		voteMsg1.getPreference().add(pref3);
		Preference pref4 = new Preference();
		pref4.setFeatureAttributeType1("Throughput");
		pref4.setFeatureAttributeType2("Sends mail");
		pref4.setPref1Over2(-9);
		voteMsg1.getPreference().add(pref4);
		Preference pref5 = new Preference();
		pref5.setFeatureAttributeType1("Throughput");
		pref5.setFeatureAttributeType2("Processing time");
		pref5.setPref1Over2(-9);
		voteMsg1.getPreference().add(pref5);
		Preference pref6 = new Preference();
		pref6.setFeatureAttributeType1("Sends mail");
		pref6.setFeatureAttributeType2("Processing time");
		pref6.setPref1Over2(9);
		voteMsg1.getPreference().add(pref6);

		voteMsg2 = new Vote();
		voteMsg2.setAggregation(false);
		voteMsg2.setStakeholderGroup("Citizens");
		voteMsg2.setDescription("This is another vote for testing purpose.");
		voteMsg2.setVoterId("2");
		pref1 = new Preference();
		pref1.setFeatureAttributeType1("Cost");
		pref1.setFeatureAttributeType2("Throughput");
		pref1.setPref1Over2(-9);
		voteMsg2.getPreference().add(pref1);
		pref2 = new Preference();
		pref2.setFeatureAttributeType1("Cost");
		pref2.setFeatureAttributeType2("Sends mail");
		pref2.setPref1Over2(-9);
		voteMsg2.getPreference().add(pref2);
		pref3 = new Preference();
		pref3.setFeatureAttributeType1("Cost");
		pref3.setFeatureAttributeType2("Processing time");
		pref3.setPref1Over2(-9);
		voteMsg2.getPreference().add(pref3);
		pref4 = new Preference();
		pref4.setFeatureAttributeType1("Throughput");
		pref4.setFeatureAttributeType2("Sends mail");
		pref4.setPref1Over2(9);
		voteMsg2.getPreference().add(pref4);
		pref5 = new Preference();
		pref5.setFeatureAttributeType1("Throughput");
		pref5.setFeatureAttributeType2("Processing time");
		pref5.setPref1Over2(9);
		voteMsg2.getPreference().add(pref5);
		pref6 = new Preference();
		pref6.setFeatureAttributeType1("Sends mail");
		pref6.setFeatureAttributeType2("Processing time");
		pref6.setPref1Over2(-9);
		voteMsg2.getPreference().add(pref6);

		// ///////////////////////////////////////////////////////////////////
		// Dummy votes alternative
		// ///////////////////////////////////////////////////////////////////

		// voteMsg1 = new Vote();
		// voteMsg1.setAggregation(false);
		// voteMsg1.setStakeholderGroup("sample stakeholder group");
		// voteMsg1.setVoterId("456");
		// pref = new Preference();
		// pref.setFeatureAttributeType1("AttributeType1");
		// pref.setFeatureAttributeType2("AttributeType2");
		// pref.setPref1Over2(2);
		// voteMsg1.getPreference().add(pref);
		// pref = new Preference();
		// pref.setFeatureAttributeType1("AttributeType1");
		// pref.setFeatureAttributeType2("AttributeType3");
		// pref.setPref1Over2(2);
		// voteMsg1.getPreference().add(pref);
		// pref = new Preference();
		// pref.setFeatureAttributeType1("AttributeType2");
		// pref.setFeatureAttributeType2("AttributeType3");
		// pref.setPref1Over2(2);
		// voteMsg1.getPreference().add(pref);

		// voteMsg2 = new Vote();
		// voteMsg2.setAggregation(false);
		// voteMsg2.setStakeholderGroup("changed sample stakeholder group");
		// voteMsg2.setVoterId("456");
		// pref = new Preference();
		// pref.setFeatureAttributeType1("AttributeType1");
		// pref.setFeatureAttributeType2("AttributeType2");
		// pref.setPref1Over2(3);
		// voteMsg2.getPreference().add(pref);
		// pref = new Preference();
		// pref.setFeatureAttributeType1("AttributeType1");
		// pref.setFeatureAttributeType2("AttributeType3");
		// pref.setPref1Over2(3);
		// voteMsg2.getPreference().add(pref);
		// pref = new Preference();
		// pref.setFeatureAttributeType1("AttributeType2");
		// pref.setFeatureAttributeType2("AttributeType3");
		// pref.setPref1Over2(3);
		// voteMsg2.getPreference().add(pref);

		// ///////////////////////////////////////////////////////////////////
	}

	/**
	 * @return the evalMsgDPI1
	 */
	public Evaluation getEvalMsgDPI1() {
		return evalMsgDPI1;
	}

	/**
	 * @return the evalMsgDPI2
	 */
	public Evaluation getEvalMsgDPI2() {
		return evalMsgDPI2;
	}

	/**
	 * @return the evalMsgDPI3
	 */
	public Evaluation getEvalMsgDPI3() {
		return evalMsgDPI3;
	}

	/**
	 * @return the evalMsg1
	 */
	public Evaluation getEvalMsg1() {
		return evalMsg1;
	}

	/**
	 * @return the evalMsg2
	 */
	public Evaluation getEvalMsg2() {
		return evalMsg2;
	}

	/**
	 * @return the voteMsg1
	 */
	public Vote getVoteMsg1() {
		return voteMsg1;
	}

	/**
	 * @return the voteMsg2
	 */
	public Vote getVoteMsg2() {
		return voteMsg2;
	}

}
