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

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.rest.messages.Configuration;
import edu.kit.cockpit.valuationserver.rest.messages.Configuration.ConfigurationAttributes.FeatureAttribute;
import edu.kit.cockpit.valuationserver.rest.messages.Configuration.ConfigurationRanking.RankedConfiguration;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.rest.messages.Votes;
import edu.kit.cockpit.valuationserver.sfmpersistency.FileUtil;

public class ConfigServiceTest extends ServiceTestBase {

	Log log = LogFactory.getLog(this.getClass());

	public ConfigServiceTest() {
		super();
	}

	private String model;
	private Vote voteMsg1;
	private Vote voteMsg2;
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
		voteMsg2 = getVoteMsg2();
	}

//	@Test
	public void testGetSingleVoteConfig() {
		// create evaluation, model and vote
		Evaluation eval = postEvaluation(evalMsg);
		postModel(eval.getEvaluationUrl(), model);
		Vote vote = postSingleVote(eval.getEvaluationUrl(), voteMsg1);

		// get single vote config
		Configuration config = getVoteConfig(vote.getConfigurationUrl());

		// analyse config
		assertNotNull(config);
		assertEquals(configInfo(config), null);

		// clean up
		deleteSingleVote(vote.getVoteUrl());
		deleteEvaluation(eval.getEvaluationUrl());
	}

//	@Test
	public void testGetAggregatedVoteConfig() {
		// create evaluation, model and 2 votes
		Evaluation eval = postEvaluation(evalMsg);
		postModel(eval.getEvaluationUrl(), model);
		Vote vote1 = postSingleVote(eval.getEvaluationUrl(), voteMsg1);
		Vote vote2 = postSingleVote(eval.getEvaluationUrl(), voteMsg2);

		// get simple aggregated votes
		Votes simpleAggregatedVotes = postSimpleAggregatedVote(String
				.valueOf(eval.getEvaluationId()));
		assertNotNull(simpleAggregatedVotes);
		assertEquals(simpleAggregatedVotes.getVoteEntry().size(), 1);
		assertNotNull(simpleAggregatedVotes.getVoteEntry().get(0).getVoteUrl());

		// get simple aggregated vote
		Vote aVote = getSimpleAggregatedVote(simpleAggregatedVotes
				.getVoteEntry().get(0).getVoteUrl());
		assertNotNull(aVote);

		// get config
		Configuration aConfig = getVoteConfig(aVote.getConfigurationUrl());

		// analyse config
		assertNotNull(aConfig);
		assertEquals(configInfo(aConfig), null);

		// clean up
		deleteSingleVote(vote1.getVoteUrl());
		deleteSingleVote(vote2.getVoteUrl());
		deleteEvaluation(eval.getEvaluationUrl());
	}

	/**
	 * @param config
	 * @return id of winning config
	 */
	private String configInfo(Configuration config) {
		
		List<FeatureAttribute> attribList = config.getConfigurationAttributes()
				.getFeatureAttribute();

		List<RankedConfiguration> configList = config.getConfigurationRanking()
				.getRankedConfiguration();

		String features = "";

		for (Iterator<FeatureAttribute> iterator = attribList.iterator(); iterator
				.hasNext();) {
			FeatureAttribute featureAttribute = iterator.next();
			features = features + " "
					+ featureAttribute.getFeatureAttributeType() + "="
					+ featureAttribute.getFeatureAttributeValue();
		}

		String configs = "";

		for (Iterator<RankedConfiguration> iterator = configList.iterator(); iterator
				.hasNext();) {
			RankedConfiguration rankedConfig = iterator.next();
			configs = configs + " " + rankedConfig.getConfigurationId() + "="
					+ rankedConfig.getPreferenceValue();
		}

		log.info("Winning configuration: " + config.getConfigName() + "("
				+ config.getConfigId() + "):" + config.getConfigDescription()
				+ " [" + features + " ]; Configuration Preference Vector: "
				+ " [" + configs + " ] ");

		return config.getConfigId();
	}

}
