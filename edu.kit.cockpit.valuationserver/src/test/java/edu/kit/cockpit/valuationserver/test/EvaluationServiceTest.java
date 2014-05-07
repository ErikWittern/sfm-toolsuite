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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse.Status;

import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluations;

public class EvaluationServiceTest extends ServiceTestBase {

	public EvaluationServiceTest() {
		super();
	}

	@Test
	public void testGetEvaluations() {
		// list evaluations
		Evaluations results1 = getEvaluations(null, null, null);
		assertNotNull(results1);
	}

	@Test
	public void testPostEvaluation() {
		// list evaluations
		Evaluations results1 = getEvaluations(null, null, null);
		int numOfEvalusations = results1.getEvaluationEntry().size();
		// add evaluation
		Evaluation result1 = postEvaluation(getEvalMsg1());
		assertNotNull(result1);
		Evaluations results2 = getEvaluations(null, null, null);
		assertNotNull(results2);
		assertTrue(results2.getEvaluationEntry().size() == numOfEvalusations + 1);
		numOfEvalusations = results2.getEvaluationEntry().size();
	}

	@Test
	public void testPutEvaluation() {
		// add evaluation
		Evaluation result1 = postEvaluation(getEvalMsg1());
		// change & get evaluation (note, that there is no URL guessing)
		Evaluation result2 = putEvaluation(result1.getEvaluationUrl(),
				getEvalMsg2());
		assertNotNull(result2);
		assertEquals(result1.getEvaluationUrl(), result2.getEvaluationUrl());
		Evaluation result3 = getEvaluation(result1.getEvaluationUrl());
		assertNotNull(result3);
		assertFalse(result1.getDescription().equals(result3.getDescription()));
		assertTrue(result1.getStakeholderGroup().equals(
				result3.getStakeholderGroup()));
	}

	@Test
	public void testDeleteEvaluation() {
		// add evaluation
		Evaluation result1 = postEvaluation(getEvalMsg1());
		// list evaluations
		Evaluations results1 = getEvaluations(null, null, null);
		int numOfEvalusations = results1.getEvaluationEntry().size();
		// delete evaluation
		Status delState = deleteEvaluation(result1.getEvaluationUrl());
		assertEquals(delState, Status.OK);
		Evaluations results3 = getEvaluations(null, null, null);
		assertNotNull(results3);
		assertTrue(results3.getEvaluationEntry().size() == numOfEvalusations - 1);
		numOfEvalusations = results3.getEvaluationEntry().size();
	}
}
