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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.sfmpersistency.EMFUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.FileUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;

public class SFMPersistencyTest {

	Log log = LogFactory.getLog(this.getClass());

	SFMPersistency sfmp = new SFMPersistency();

	// constants
	private final long evalId = 1;
	private final String serviceId = "4710ff47-4fc4-461a-bccd-6a45bd4974f4";
	private final String modelId = "1";
	// initialized fields
	private String modelUrl;
	private File modelFile;
	private String model;

	@Before
	public void setUp() throws Exception {
		model = loadModelFile();
		modelFile = new File(CVSrvContext.getInstance()
				.getSfmPersistencyDirectory()
				+ java.io.File.separator
				+ modelId + CVSrvContext.SFM_FILE_EXTENSION);
		modelUrl = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.MODEL_URL_PREFIX + modelId;
	}

	@After
	public void tearDown() throws Exception {
		model = null;
		modelFile = null;
	}

	@Test
	public void testGetModelId() throws IOException {
		String newModelId = SFMPersistency.getModelId(evalId);
		assertEquals(newModelId, this.modelId);
	}

	@Test
	public void testSaveAndDeleteSFMModel() throws IOException {
		// save
		sfmp.saveSFMModel(modelId, model);
		assertTrue(modelFile.exists());
		// delete
		sfmp.deleteSFMModel(modelId);
		assertFalse(modelFile.exists());
	}

	@Test
	public void testGetModelURL() throws IOException {
		assertEquals(SFMPersistency.getModelURL(evalId), null);
		sfmp.saveSFMModel(modelId, model);
		assertEquals(SFMPersistency.getModelURL(evalId), modelUrl);
		sfmp.deleteSFMModel(modelId);
	}

	@Test
	public void testLoadSFMModelToString() throws IOException {
		sfmp.saveSFMModel(modelId, model);
		String testModelString = sfmp.loadSFMModelToString(modelId);
		assertEquals(model, testModelString);
		sfmp.deleteSFMModel(modelId);
	}

//	@Test
	public void testLoadSFMModelToResource() throws IOException {
		sfmp.saveSFMModel(modelId, model);
		Resource resource = sfmp.loadSFMModelToResource(modelId);
		assertEquals(EMFUtil.getService(resource).getId(), serviceId);
		sfmp.deleteSFMModel(modelId);
	}

	@Test
	public void testUpdateSFMModel() throws IOException {
		sfmp.saveSFMModel(modelId, model);
		sfmp.updateSFMModel(modelId, model);
		String testModelString = sfmp.loadSFMModelToString(modelId);
		assertEquals(model, testModelString);
		sfmp.deleteSFMModel(modelId);
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public String loadModelFile() throws IOException {
		// load model file
		File testModelFile = new File(getClass().getClassLoader()
				.getResource(CVSrvContext.GR01_SFM_FILENAME).getFile());
		String model = FileUtil.readFile(testModelFile);
		return model;
	}

}
