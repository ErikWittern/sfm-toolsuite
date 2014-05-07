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

package edu.kit.cockpit.valuationserver.sfmpersistency;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.Resource;

import edu.kit.cockpit.valuationserver.CVSrvContext;

/**
 * Handle sfm persistency based on file system
 * 
 */
public class SFMPersistency {

	private static Log log = LogFactory.getLog(SFMPersistency.class);

	/**
	 * @param modelId
	 * @return modelFile
	 */
	private static File getModelFile(String modelId) {
		return new File(getModelFileName(modelId));
	}

	/**
	 * @param modelId
	 * @return modelFile
	 */
	private static String getModelFileName(String modelId) {
		return CVSrvContext.getInstance().getSfmPersistencyDirectory()
				+ java.io.File.separator + modelId + ".sfm";
	}

	/**
	 * @param evaluationId
	 * @param serviceId
	 * @return modelId
	 */
	public static String getModelId(long evaluationId) {
		return String.valueOf(evaluationId);
	}

	/**
	 * @param evaluationId
	 * @param serviceId
	 * @return modelUrl
	 */
	public static String getModelURL(long evaluationId) {
		return getModelURL(getModelId(evaluationId));
	}

	/**
	 * @param evaluationId
	 * @param serviceId
	 * @return modelUrl
	 */
	public static String getModelURL(String modelId) {
		if (!getModelFile(modelId).exists()) {
			log.warn("Requested file " + getModelFile(modelId)
					+ " does not exist.");
			return null;
		}
		return CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.MODEL_URL_PREFIX + modelId;
	}

	/**
	 * Delete SFM file
	 * 
	 * @param modelId
	 */
	public void deleteSFMModel(String modelId) throws IOException {
		File modelFile = getModelFile(modelId);
		if (!modelFile.delete()) {
			throw new IOException("File '" + getModelFileName(modelId)
					+ "' could not be deleted");
		}
	}

	/**
	 * Loads SFM Model and returns it as an EMF Resource
	 * 
	 * @param modelId
	 * @return model EMF resource
	 */
	public Resource loadSFMModelToResource(String modelId) throws IOException {
		return EMFUtil.loadSFMModelToResource(getModelFileName(modelId),
				CVSrvContext.SFM_NAMESPACE, CVSrvContext.SFM_PACKAGE);
	}

	/**
	 * Loads SFM Model and returns it as a String
	 * 
	 * @param modelId
	 * @return string representation of sfm model
	 * @throws IOException
	 */
	public String loadSFMModelToString(String modelId) throws IOException {
		return FileUtil.readFile(getModelFile(modelId));
	}

	/**
	 * Writes SFM model to file
	 * 
	 * @param evaluationId
	 * @param serviceId
	 * @param modelContent
	 *            sfm string representation
	 * @throws IOException
	 */
	public void saveSFMModel(String modelId, String modelContent)
			throws IOException {
		// FileWriter fstream = new FileWriter(getModelFileName(modelId));
		// BufferedWriter bw = new BufferedWriter(fstream);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getModelFileName(modelId)),"ISO-8859-7"));
		
		bw.write(modelContent);
		bw.close();
	}

	/**
	 * Update SFM file
	 * 
	 * @param modelId
	 * @param modelContent
	 * @throws IOException
	 */
	public void updateSFMModel(String modelId, String modelContent)
			throws IOException {
		// File modelFile = getModelFile(modelId);
		// BufferedWriter out = new BufferedWriter(new FileWriter(modelFile));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getModelFileName(modelId)),"ISO-8859-7"));
		
		bw.write(modelContent);
		bw.close();
	}

	/**
	 * @param modelId
	 * @return
	 */
	public static long getEvaluationId(String modelId) {
		return Long.parseLong(modelId);
	}

}
