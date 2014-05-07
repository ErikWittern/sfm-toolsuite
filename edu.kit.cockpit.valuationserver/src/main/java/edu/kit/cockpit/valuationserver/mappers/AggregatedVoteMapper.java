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

package edu.kit.cockpit.valuationserver.mappers;

import java.util.List;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.entities.AggregatedVoteE;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.rest.messages.Votes;

public class AggregatedVoteMapper extends VoteMapper {

	/**
	 * @param aggregatedVoteE
	 * @return
	 */
	public static Vote aggregatedVoteEntityToVoteMessage(
			AggregatedVoteE aggregatedVoteE) {

		// basic mapping for general vote entities
		Vote vote = voteEntityToVoteMessage(aggregatedVoteE);

		// map additional specific base attributes
		vote.setAggregation(true);

		if (aggregatedVoteE.getAggregationType() != null) {
			vote.setAggregationType(aggregatedVoteE.getAggregationType());
		} else {
			log.error("Required attribute 'aggregationType' missing");
			return null;
		}

		if (aggregatedVoteE.getClusterId() != null) {
			vote.setClusterId(aggregatedVoteE.getClusterId());
		} else {
			log.error("Required attribute 'clusterId' missing");
			return null;
		}

		// generate url links
		vote.setConfigurationUrl(genConfigUrl(aggregatedVoteE));
		vote.setVoteUrl(genUrl(aggregatedVoteE));
		vote.setEvaluationUrl(EvaluationMapper.genUrl(aggregatedVoteE
				.getAggregatorEvaluation()));

		return vote;
	}

	/**
	 * @param voteEList
	 * @return
	 */
	public static Votes aggregatedVoteEntitiesToVotes(
			List<AggregatedVoteE> voteEList) {

		if (voteEList == null) {
			log.error("Mapping request FOR null object");
			return null;
		}

		Votes votes = new Votes();

		for (AggregatedVoteE aggregatedVoteE : voteEList) {
			Votes.VoteEntry voteEntry = new Votes.VoteEntry();
			voteEntry.setVoteId(String.valueOf(aggregatedVoteE.getId()));
			voteEntry.setVoteUrl(genUrl(aggregatedVoteE));
			votes.getVoteEntry().add(voteEntry);
		}

		return votes;
	}

	/**
	 * @param singleVoteE
	 *            is an single vote entity
	 * @return the url of the single vote resource
	 */
	public static String genUrl(AggregatedVoteE aggregatedVote) {
		String url = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.VOTE_BASE_URL_PREFIX
				+ CVSrvContext.AGGREGATED_VOTE_URL_PREFIX
				+ String.valueOf(aggregatedVote.getAggregatorEvaluation()
						.getId()) + "/"
				+ String.valueOf(aggregatedVote.getId());
		return url;
	}

	/**
	 * @param aggregatedVote
	 * @return
	 */
	public static String genConfigUrl(AggregatedVoteE aggregatedVote) {
		String url = genUrl(aggregatedVote) + "/"
				+ CVSrvContext.CONFIGURATION_URL_PREFIX;
		return url;
	}

}
