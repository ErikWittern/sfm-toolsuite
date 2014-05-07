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

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.junit.Before;
import org.junit.Test;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.ModelList;
import edu.kit.cockpit.valuationserver.sfmpersistency.FileUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;

public class ModelServiceTest extends ServiceTestBase {

	public ModelServiceTest() {
		super();
	}

	private String model1;
	private String model2;

	@Before
	public void setUp() throws Exception {
		File testModelFile1 = new File(getClass().getClassLoader()
				.getResource(CVSrvContext.GR01_SFM_FILENAME).getFile());
		model1 = FileUtil.readFile(testModelFile1);

		File testModelFile2 = new File(getClass().getClassLoader()
				.getResource(CVSrvContext.GR01_SFM_CHANGED_FILENAME).getFile());
		model2 = FileUtil.readFile(testModelFile2);
	}

	@Test
	public void testPostModel() throws IOException {
		Evaluation eval = postEvaluation(getEvalMsg1());
		URI location = postModel(eval.getEvaluationUrl(), model1);
		String expectedUrl = SFMPersistency.getModelURL(eval.getEvaluationId());
		log.info("Model posted resulting in location '" + location
				+ "' (expected '" + expectedUrl + "')");
		assertEquals(location.toString(), expectedUrl);
		deleteModel(location.toString());
	}

	@Test
	public void testGetModel() throws IOException {
		Evaluation eval = postEvaluation(getEvalMsg1());
		URI location = postModel(eval.getEvaluationUrl(), model1);
		String gotModel = getModel(location.toString());
		assertEquals(model1, gotModel);
		deleteModel(location.toString());
	}

	@Test
	public void testPutModel() throws IOException {
		Evaluation eval = postEvaluation(getEvalMsg1());
		URI location1 = postModel(eval.getEvaluationUrl(), model1);
		URI location2 = putModel(location1.toString(), model2);
		String gotModel = getModel(location2.toString());
		assertEquals(model2, gotModel);
		deleteModel(location2.toString());
	}

	@Test(expected = IOException.class)
	public void testDeleteModel() throws IOException {
		Evaluation eval = postEvaluation(getEvalMsg1());
		URI location = postModel(eval.getEvaluationUrl(), model1);
		deleteModel(location.toString());
		new SFMPersistency().loadSFMModelToString(SFMPersistency
				.getModelId(eval.getEvaluationId()));
	}

	@Test
	public void testGetModels() {
		Evaluation eval = postEvaluation(getEvalMsg1());
		URI location = postModel(eval.getEvaluationUrl(), model1);
		ModelList modelsList = getModels();
		log.info("Model List loaded containing "
				+ modelsList.getModels().getModel().size() + " model(s)");
		assertFalse(modelsList.getModels().getModel().isEmpty());
		deleteModel(location.toString());
	}
}
