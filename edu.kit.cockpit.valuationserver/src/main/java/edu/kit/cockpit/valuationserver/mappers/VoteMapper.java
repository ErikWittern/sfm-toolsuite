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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.entities.VoteE;
import edu.kit.cockpit.valuationserver.rest.messages.Vote;

public abstract class VoteMapper {

	private static final int PREFERENCE_VALUE_UPPER_BOUND = 9;
	private static final int PREFERENCE_VALUE_LOWER_BOUND = -9;

	static Log log = LogFactory.getLog(VoteMapper.class);

	/**
	 * @param vote
	 *            message to be mapped
	 * @param voteE
	 *            entity to map to
	 * @return mapped vote entity
	 */
	protected static VoteE voteMessageToVoteEntity(Vote vote, VoteE voteE) {

		if (vote == null) {
			log.error("Mapping request FOR null object");
			return null;
		}

		if (voteE == null) {
			log.warn("Mapping request TO null object");
			voteE = new SingleVoteE();
		}

		// start mapping

		// map generic attributes

		// stakeholder group
		if (vote.getStakeholderGroup() != null)
			voteE.setStakeholderGroup(vote.getStakeholderGroup());
		else
			log.warn("Optional attribute 'StakeholderGroup' is missing");

		// description
		if (vote.getDescription() != null)
			voteE.setDescription(vote.getDescription());
		else
			log.warn("Optional attribute 'Description' is missing");

		// map preferences
		// possible situations
		// 1) POST vote with prefs: create new prefEs
		// 2) POST vote w/o prefs: error
		// 3) PUT vote w/o prefs: error
		// 4) PUT vote with prefs: replace ALL old prefs

		// An alternative would be to just allow changes (PUT) to the vote
		// entity and keep original preferences until delete.

		if (vote.getPreference().isEmpty()) {
			log.error("Cannot map from vote without preferences");
			return null;
		}

		for (Vote.Preference pref : vote.getPreference()) {
			// create pref entity
			log.info("Next preference value :"
					+ pref.getFeatureAttributeType1() + " over "
					+ pref.getFeatureAttributeType2() + " = "
					+ pref.getPref1Over2());
			PreferenceE prefE = new PreferenceE();
			if (pref.getFeatureAttributeType1() != null
					&& pref.getFeatureAttributeType2() != null
					&& checkPrefRange(pref.getPref1Over2())) {
				// map pref message part to pref entity
				prefE.setAttributeTypeA(pref.getFeatureAttributeType1());
				prefE.setAttributeTypeB(pref.getFeatureAttributeType2());
				prefE.setPreferenceAoverB(pref.getPref1Over2());
				// link pref entity with vote entity
				prefE.setVote(voteE);
				voteE.addPreference(prefE);
			} else {
				log.error("Mapping request for vote with inconsistent preference data ()");
				return null;
			}
		}

		return voteE;
	}

	/**
	 * @param singleVoteE
	 * @return
	 */
	protected static Vote voteEntityToVoteMessage(VoteE voteE) {

		if (voteE == null) {
			log.error("Mapping request for null object");
			return null;
		}

		Vote vote = new Vote();

		// map base attributes

		// vote id
		if (voteE.getId() != 0)
			vote.setVoteId(String.valueOf(voteE.getId()));
		else {
			log.error("Required attribute 'id' missing");
			return null;
		}

		// stakeholder group
		if (voteE.getStakeholderGroup() != null)
			vote.setStakeholderGroup(voteE.getStakeholderGroup());
		else
			log.warn("Optional attribute 'stakeholderGroup' missing");

		// description
		if (voteE.getDescription() != null)
			vote.setDescription(voteE.getDescription());
		else
			log.warn("Optional attribute 'description' missing");

		// map preferences

		for (PreferenceE prefE : voteE.getPreferences()) {
			Vote.Preference pref = new Vote.Preference();
			if (prefE.getAttributeTypeA() != null
					&& prefE.getAttributeTypeB() != null
					&& checkPrefRange(prefE.getPreferenceAoverB())) {
				pref.setFeatureAttributeType1(prefE.getAttributeTypeA());
				pref.setFeatureAttributeType2(prefE.getAttributeTypeB());
				pref.setPref1Over2(prefE.getPreferenceAoverB());
				vote.getPreference().add(pref);
			} else {
				log.error("Mapping request with inconsistent preference data");
				return null;
			}
		}

		return vote;
	}

	/**
	 * Checks if preference value is in required range
	 * 
	 * @param pref1Over2
	 * @return boolean result of plausibility check
	 */
	static boolean checkPrefRange(int pref1Over2) {
		return PREFERENCE_VALUE_LOWER_BOUND <= pref1Over2
				&& pref1Over2 <= PREFERENCE_VALUE_UPPER_BOUND;
	}
}
