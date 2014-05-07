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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URI;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse.Status;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.rest.messages.Votes;
import edu.kit.cockpit.valuationserver.sfmpersistency.FileUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;

public class VoteServiceTest extends ServiceTestBase {

	public VoteServiceTest() {
		super();
	}

	private String model1;

	@Before
	public void setUp() throws Exception {
		File testModelFile1 = new File(getClass().getClassLoader()
				.getResource(CVSrvContext.GR01_SFM_FILENAME).getFile());
		model1 = FileUtil.readFile(testModelFile1);
	}

	@Test
	public void testGetSingleVotes() {
		// list & search for single votes
		Votes votes1 = getSingleVotes(null, null);
		assertNotNull(votes1);
		Votes votes2 = getSingleVotes("0", null);
		assertNull(votes2);
		Votes votes3 = getSingleVotes(null, "Bergbauern");
		assertNull(votes3);
	}

	@Test
	public void testPostSingleVote() {
		// list & search for single votes
		Votes votes1 = getSingleVotes(null, null);
		assertNotNull(votes1);
		int numOfVotes = votes1.getVoteEntry().size();
		// add single vote
		Evaluation eval1 = postEvaluation(getEvalMsg1());
		Vote vote1 = postSingleVote(eval1.getEvaluationUrl(), getVoteMsg1());
		assertNotNull(vote1);
		Votes votes4 = getSingleVotes(null, null);
		assertNotNull(votes4);
		assertTrue(votes4.getVoteEntry().size() == numOfVotes + 1);
		Status delState = deleteSingleVote(vote1.getVoteUrl());
		assertEquals(delState, Status.OK);
	}

	@Test
	public void testGetSingleVote() {
		// add single vote
		Evaluation eval1 = postEvaluation(getEvalMsg1());
		Vote vote1 = postSingleVote(eval1.getEvaluationUrl(), getVoteMsg1());
		// get single Vote
		Vote vote2 = getSingleVote(vote1.getVoteUrl());
		assertNotNull(vote2);
		assertEquals(vote1.getVoteId(), vote2.getVoteId());
		Status delState = deleteSingleVote(vote1.getVoteUrl());
		assertEquals(delState, Status.OK);
	}

	@Test
	public void testPutSingleVote() {
		// add single vote
		Evaluation eval1 = postEvaluation(getEvalMsg1());
		Vote vote1 = postSingleVote(eval1.getEvaluationUrl(), getVoteMsg1());
		// change single vote
		Vote vote3 = putSingleVote(vote1.getVoteUrl(), getVoteMsg2());
		assertNotNull(vote3);
		assertEquals(vote3.getVoteId(), vote1.getVoteId());
		assertTrue(vote3.getStakeholderGroup().equals(
				vote1.getStakeholderGroup()));
		Status delState = deleteSingleVote(vote3.getVoteUrl());
		assertEquals(delState, Status.OK);
	}

	@Test
	public void testDeleteSingleVote() {
		// add single votes
		Evaluation eval1 = postEvaluation(getEvalMsg1());
		Vote vote1 = postSingleVote(eval1.getEvaluationUrl(), getVoteMsg1());
		Vote vote2 = postSingleVote(eval1.getEvaluationUrl(), getVoteMsg2());
		// delete single vote
		Status delState = deleteSingleVote(vote1.getVoteUrl());
		assertEquals(delState, Status.OK);
		assertNull(getSingleVote(vote1.getVoteUrl()));
		assertNotNull(getSingleVote(vote2.getVoteUrl()));
	}

//	@Test
	public void testAggregatedVoteServices() {
		// start posting an evaluation
		Evaluation evaluation = postEvaluation(getEvalMsg1());
		assertNotNull(evaluation);
		assertNotNull(evaluation.getEvaluationId());

		// then post the associated model
		URI location = postModel(evaluation.getEvaluationUrl(), model1);
		String expectedUrl = SFMPersistency.getModelURL(evaluation
				.getEvaluationId());
		assertEquals(location.toString(), expectedUrl);

		// then post some votes
		Vote vote1 = postSingleVote(evaluation.getEvaluationUrl(),
				getVoteMsg1());
		assertNotNull(vote1);
		Vote vote2 = postSingleVote(evaluation.getEvaluationUrl(),
				getVoteMsg2());
		assertNotNull(vote2);

		// list & search for single votes
		Votes votes1 = getSingleVotes(null, null);
		assertNotNull(votes1);

		// now trigger simple votes aggregation via post 
		Votes simpleAggregatedVotes = postSimpleAggregatedVote(String
				.valueOf(evaluation.getEvaluationId()));
		assertNotNull(simpleAggregatedVotes);
		assertEquals(simpleAggregatedVotes.getVoteEntry().size(), 1);
		assertNotNull(simpleAggregatedVotes.getVoteEntry().get(0).getVoteUrl());

		// now get the simple aggregated votes
		simpleAggregatedVotes = getSimpleAggregatedVotes(String
				.valueOf(evaluation.getEvaluationId()));
		assertNotNull(simpleAggregatedVotes);
		assertEquals(simpleAggregatedVotes.getVoteEntry().size(), 1);
		assertNotNull(simpleAggregatedVotes.getVoteEntry().get(0).getVoteUrl());

		// now trigger simple votes re-aggregation via post 
		simpleAggregatedVotes = postSimpleAggregatedVote(String
				.valueOf(evaluation.getEvaluationId()));
		assertNotNull(simpleAggregatedVotes);
		assertEquals(simpleAggregatedVotes.getVoteEntry().size(), 1);
		assertNotNull(simpleAggregatedVotes.getVoteEntry().get(0).getVoteUrl());

		// and get simple aggregated vote
		Vote simpleAggregatedVote = getSimpleAggregatedVote(simpleAggregatedVotes
				.getVoteEntry().get(0).getVoteUrl());
		assertNotNull(simpleAggregatedVote);

		// finally delete votes
		Status delState1 = deleteSingleVote(vote1.getVoteUrl());
		assertEquals(delState1, Status.OK);
		Status delState2 = deleteSingleVote(vote2.getVoteUrl());
		assertEquals(delState2, Status.OK);
		// and delete model
		deleteModel(location.toString());
	}
}
