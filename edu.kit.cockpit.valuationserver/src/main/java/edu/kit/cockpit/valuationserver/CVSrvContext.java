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
 * 	2011 Karlsruhe Institute of Technology
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

package edu.kit.cockpit.valuationserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CVSrvContext {

	// Service URLs
	public static final String VALUATION_SERVER_CONTEXT = "valuation-server";
	public static final String DELIBERATION_PLATFORM_CONTEXT = "Poll";

	public static final String EVALUATION_URL_PREFIX = "evaluations/";
	public static final String VOTE_BASE_URL_PREFIX = "votes/";
	public static final String SINGLE_VOTE_URL_PREFIX = "single/";
	public static final String AGGREGATED_VOTE_URL_PREFIX = "aggregated/";
	public static final String CONFIGURATION_URL_PREFIX = "config/";
	public static final String MODEL_URL_PREFIX = "models/";

	// Service mime types
	public static final String EVALUATIONS_MIME_TYPE = "cockpit/evaluations+xml";
	public static final String EVALUATION_MIME_TYPE = "cockpit/evaluation+xml";
	public static final String SINGLE_VOTES_MIME_TYPE = "cockpit/single-votes+xml";
	public static final String SINGLE_VOTE_MIME_TYPE = "cockpit/single-vote+xml";
	public static final String SIMPLE_AGGREGATED_VOTES_MIME_TYPE = "cockpit/simple-aggregated-votes+xml";
	public static final String SIMPLE_AGGREGATED_VOTE_MIME_TYPE = "cockpit/simple-aggregated-vote+xml";
	public static final String CONFIGURATION_MIME_TYPE = "cockpit/configuration+xml";
	public static final String MODELS_MIME_TYPE = "cockpit/sfms+xml";
	public static final String MODEL_MIME_TYPE = "cockpit/sfm+xml";

	// Persistency
	public static final String COCKPIT_DIRECTORY_SUFFIX = "cockpit";
	public static final String SFM_DIRECTORY_SUFFIX = "sfm";
	public static final String SFM_FILE_EXTENSION = ".sfm";
	public static final String SFM_NAMESPACE = "http://servicefeaturemodel/1.0";
	public static final String SFM_PACKAGE = "servicefeaturemodel";
	public static final String FILE_SEPARATOR = java.io.File.separator;
	public static final String GR01_SFM_FILENAME = "GR01_with_configs_and_attributes.sfm";
	public static final String GR01_SFM_CHANGED_FILENAME = "GR01_with_configs_and_attributes_changed.sfm";
	public static final String SFM_ANALYZER_TEST_FILENAME = "20110922AnalyzerTest.sfm";
	public static final String SFM_CUSTOM_PRIORITY_TEST_FILENAME = "20110922CustomPriorityTest.sfm";
	public static final String SFM_GR01DEMO_FILENAME = "GR01Demo.sfm";

	// Dynamic part

	private Log log = LogFactory.getLog(CVSrvContext.class);

	private String DELIBERATION_PLATFORM_BASE_URL = null;
	private String VALUATION_SERVER_BASE_URL = null;

	private Properties serverProps;
	private String SYSTEM_TMPDIR;
	private String COCKPIT_DIRECTORY;
	private String SFM_PERSISTENCY_DIRECTORY;

	private static class SingletonHolder {
		private static final CVSrvContext instance = new CVSrvContext();
	}

	public static CVSrvContext getInstance() {
		return SingletonHolder.instance;
	}

	private CVSrvContext() {
		// read adapter properties file
		this.serverProps = new Properties();

		InputStream in;

		try {
			in = getClass().getResourceAsStream("/server.properties");
			serverProps.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

		// read validation server url property
		VALUATION_SERVER_BASE_URL = serverProps
				.getProperty("valuationserver.base.url");

		// read deployment platform url property
		DELIBERATION_PLATFORM_BASE_URL = serverProps
				.getProperty("deliberationplatform.base.url");

		// read user home dir property
		SYSTEM_TMPDIR = serverProps.getProperty("system.tmp.dir");

		// define cockpit dir
		COCKPIT_DIRECTORY = SYSTEM_TMPDIR + FILE_SEPARATOR
				+ COCKPIT_DIRECTORY_SUFFIX;

		// define sfm dir
		SFM_PERSISTENCY_DIRECTORY = COCKPIT_DIRECTORY + FILE_SEPARATOR
				+ SFM_DIRECTORY_SUFFIX;

		createDirs();

		if (VALUATION_SERVER_BASE_URL == null
				|| DELIBERATION_PLATFORM_BASE_URL == null
				|| SYSTEM_TMPDIR == null)
			log.error("Could not read url properties");
		else {
			log.info("Server base URLs set: " + VALUATION_SERVER_BASE_URL
					+ " (Valuation Server), " + DELIBERATION_PLATFORM_BASE_URL
					+ " (Deliberation Platform)");
			log.info("SFM persistency directory set: "
					+ SFM_PERSISTENCY_DIRECTORY);
			log.info("Interaction with DP isdisabled: "
					+ serverProps.getProperty("skip.dp.interaction"));
		}
	}

	/**
	 * Create cockpit dir and sfm dir if they don't exist
	 */
	private void createDirs() {
		File dir = new File(COCKPIT_DIRECTORY);
		if (!dir.exists())
			if (dir.mkdir())
				log.info("cockpit directory created:" + dir.getAbsolutePath());
			else
				log.error("Could not create cockpit directory");
		dir = new File(SFM_PERSISTENCY_DIRECTORY);
		if (!dir.exists())
			if (dir.mkdir())
				log.info("sfm persistence directory created:"
						+ dir.getAbsolutePath());
			else
				log.error("Could not create sfm persistence directory");
	}

	/**
	 * @return the serverProps
	 */
	public final Properties getServerProps() {
		return serverProps;
	}

	/**
	 * @return the valuationServerUrlBase
	 */
	public final String getValuationServerUrlBase() {
		return VALUATION_SERVER_BASE_URL + "/" + VALUATION_SERVER_CONTEXT + "/";
	}

	/**
	 * @return the deliberationPlatformUrlBase
	 */
	public final String getDeliberationPlatformUrlBase() {
		return DELIBERATION_PLATFORM_BASE_URL + "/"
				+ DELIBERATION_PLATFORM_CONTEXT + "/";
	}

	/**
	 * @return the sfmPersistencyDirectory
	 */
	public String getSfmPersistencyDirectory() {
		return SFM_PERSISTENCY_DIRECTORY;
	}

}
