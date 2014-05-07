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
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;
import edu.kit.cockpit.valuationserver.rest.messages.Votes;

public class SingleVoteMapper extends VoteMapper {

	/**
	 * @param vote
	 * @param singleVoteE
	 * @return
	 */
	public static SingleVoteE voteMessageToSingleVoteEntity(Vote vote,
			SingleVoteE singleVoteE) {

		// do generic vote mapping

		singleVoteE = (SingleVoteE) voteMessageToVoteEntity(vote, singleVoteE);

		if (singleVoteE == null) {
			log.error("Generic voteMessageToVoteEntity mapping failed");
			return null;
		}

		// map single vote attributes
		vote.setAggregation(false);

		if (vote.getVoterId() != null)
			singleVoteE.setVoterId(vote.getVoterId());
		else {
			log.error("Required attribute 'voterId' is missing");
			return null;
		}

		return singleVoteE;
	}

	/**
	 * @param voteE
	 * @return
	 */
	public static Vote singleVoteEntityToVoteMessage(SingleVoteE singleVoteE) {

		// basic mapping for general vote entities
		Vote vote = voteEntityToVoteMessage(singleVoteE);

		// map additional specific base attributes
		if (singleVoteE.getVoterId() != null) {
			vote.setVoterId(singleVoteE.getVoterId());
		} else {
			log.error("Required attribute 'voterId' missing");
			return null;
		}

		// generate url links
		vote.setConfigurationUrl(genConfigUrl(singleVoteE));
		vote.setVoteUrl(genUrl(singleVoteE));
		vote.setEvaluationUrl(EvaluationMapper.genUrl(singleVoteE
				.getContainerEvaluation()));

		return vote;
	}

	/**
	 * @param results
	 * @return
	 */
	public static Votes singleVoteEntitiesToVotes(List<SingleVoteE> voteEList) {

		if (voteEList == null) {
			log.error("Mapping request FOR null object");
			return null;
		}

		Votes votes = new Votes();

		for (SingleVoteE singleVoteE : voteEList) {
			Votes.VoteEntry voteEntry = new Votes.VoteEntry();
			voteEntry.setVoteId(String.valueOf(singleVoteE.getId()));
			voteEntry.setVoteUrl(genUrl(singleVoteE));
			votes.getVoteEntry().add(voteEntry);
		}

		return votes;
	}

	/**
	 * @param singleVoteE
	 *            is a single vote entity
	 * @return the url of the single vote resource
	 */
	public static String genUrl(SingleVoteE singleVote) {
		String url = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.VOTE_BASE_URL_PREFIX
				+ CVSrvContext.SINGLE_VOTE_URL_PREFIX
				+ String.valueOf(singleVote.getId());
		return url;
	}

	/**
	 * @param singleVoteE
	 *            is a single vote entity
	 * @return the url of the single vote's configuration resource
	 */
	public static String genConfigUrl(SingleVoteE singleVote) {
		String url = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.VOTE_BASE_URL_PREFIX
				+ CVSrvContext.SINGLE_VOTE_URL_PREFIX
				+ String.valueOf(singleVote.getId() + "/"
						+ CVSrvContext.CONFIGURATION_URL_PREFIX);
		return url;
	}

}
