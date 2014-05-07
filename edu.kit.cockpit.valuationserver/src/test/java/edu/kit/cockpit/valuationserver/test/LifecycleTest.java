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

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URI;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.helpers.DateUtil;
import edu.kit.cockpit.valuationserver.mappers.EvaluationMapper;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.sfmpersistency.FileUtil;

public class LifecycleTest extends ServiceTestBase {

	Log log = LogFactory.getLog(this.getClass());

	public LifecycleTest() {
		super();
	}

	private String model;
	private Vote voteMsg1;
	private Evaluation evalMsg;

	@Before
	public void setUp() throws Exception {
		// create GR01 conformant evaluation
		evalMsg = getEvalMsg1();
		// load GR01 model
		File testModelFile1 = new File(getClass().getClassLoader()
				.getResource(CVSrvContext.GR01_SFM_FILENAME).getFile());
		model = FileUtil.readFile(testModelFile1);
		// create GR01 conformant votes
		voteMsg1 = getVoteMsg1();
	}

	@Test
	public void testCreated2Deleted() {
		// create evaluation, model and vote
		Evaluation eval = postEvaluation(evalMsg);
		URI modelUri = postModel(eval.getEvaluationUrl(), model);
		assertNotNull(eval);

		// clean up
		deleteModel(modelUri.toString());
		deleteEvaluation(eval.getEvaluationUrl());
	}

	@Test
	public void testCreated2Running2Aborted2Deleted() {
		// create evaluation, model and vote
		Evaluation eval = postEvaluation(evalMsg);
		postModel(eval.getEvaluationUrl(), model);
		assertNotNull(eval);

		// change to running state
		evalMsg.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.RUNNING));
		eval = putEvaluation(eval.getEvaluationUrl(), evalMsg);
		assertNotNull(eval);

		Vote vote = postSingleVote(eval.getEvaluationUrl(), voteMsg1);

		// change to aborted state
		evalMsg.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.ABORTED));
		eval = putEvaluation(eval.getEvaluationUrl(), evalMsg);
		assertNotNull(eval);

		// clean up
		deleteSingleVote(vote.getVoteUrl());
		deleteEvaluation(eval.getEvaluationUrl());
	}

	@Test
	public void testCreated2Running2Aborted2Finished2Deleted() {
		// create evaluation, model and vote
		Evaluation eval = postEvaluation(evalMsg);
		postModel(eval.getEvaluationUrl(), model);
		assertNotNull(eval);

		// change to running state
		evalMsg.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.RUNNING));
		eval = putEvaluation(eval.getEvaluationUrl(), evalMsg);
		assertNotNull(eval);

		Vote vote = postSingleVote(eval.getEvaluationUrl(), voteMsg1);

		// change to aborted state
		evalMsg.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.ABORTED));
		eval = putEvaluation(eval.getEvaluationUrl(), evalMsg);
		assertNotNull(eval);

		// change to aborted state with past date
		evalMsg.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.ABORTED));

		try {
			evalMsg.setPollDeadline(DateUtil
					.getXmlGregCal(new GregorianCalendar(2000, 1, 1).getTime()));
		} catch (DatatypeConfigurationException e) {
			log.error(e);
		}
		
		eval = putEvaluation(eval.getEvaluationUrl(), evalMsg);
		assertNotNull(eval);

		// change to aborted state
		evalMsg.setState(EvaluationMapper
				.mapEvaluationState(EvaluationE.EvaluationState.FINISHED));
		eval = putEvaluation(eval.getEvaluationUrl(), evalMsg);
		assertNotNull(eval);

		// clean up
		deleteSingleVote(vote.getVoteUrl());
		deleteEvaluation(eval.getEvaluationUrl());
	}

}
