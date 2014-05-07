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

package edu.kit.cockpit.valuationserver.aggregator;

import java.util.Iterator;
import java.util.List;

import edu.kit.cockpit.valuationserver.entities.AggregatedVoteE;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.helpers.PrefMap;
import edu.kit.cockpit.valuationserver.helpers.VoteUtil;
import edu.kit.cockpit.valuationserver.pollgenerator.PollGenerator;

/**
 * Calculates the geometric means of the preferences in an evaluation. Das
 * geometrische Mittel der n Zahlen ist gegeben durch die n-te Wurzel des
 * Produkts der n Zahlen.
 */
public class SimpleAggregator extends AbstractAggregator {

	// public static final String SIMPLE_AGGREGATION_ID = "simple";

	/**
	 * The preference map holds the preference values for attributeType
	 * combinations during aggregation. The key is a combination of attribute
	 * type names.
	 */
	private PrefMap prefMap;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.kit.cockpit.valuationserver.aggregator.VoteAggregator#addAggregation
	 * (edu.kit.cockpit.valuationserver.entities.EvaluationE)
	 */
	@Override
	public boolean addAggregation(EvaluationE eval) {

		// Sanity check
		if (eval == null) {
			log.error("Evaluation is null object");
			return false;
		}

		// Check for existing aggregation
		List<AggregatedVoteE> aggVoteList = getAggregatedVotes(eval,
				AggregationType.GEOMETRIC_MEANS);
		if (aggVoteList == null) {
			log.error("Evaluation analysis failed");
			return false;
		}
		if (!aggVoteList.isEmpty()) {
			log.error("An aggreggation of type "
					+ AggregationType.GEOMETRIC_MEANS
					+ " does already exist. Please delete it first.");
			return false;
		}

		// check for existing single votes
		if (eval.getSingleVotes().isEmpty()) {
			log.error("No single votes exist");
			return false;
		}

		// initialize result
		AggregatedVoteE aggregatedVote = new AggregatedVoteE();
		aggregatedVote.setAggregatorEvaluation(eval);
		aggregatedVote.setClusterId(DEFAULT_CLUSTER_ID);
		aggregatedVote.setAggregationType(AggregationType.GEOMETRIC_MEANS);
		aggregatedVote.setStakeholderGroup(DEFAULT_STAKEHOLDER_GROUP);

		// create entity
		evalVoteDao.createEntity(aggregatedVote);

		// Create null-value preference map from attribute pairs
		String[][] attribPairs = PollGenerator.getAttributePairings(eval);
		prefMap = new PrefMap(attribPairs);

		// Multiply all related single values

		// counter for single values
		int n = 0;

		// loop over votes
		for (SingleVoteE singleVoteE : eval.getSingleVotes()) {
			// do conformance check of singleVoteE preferences
			if (VoteUtil.isConformant(eval, singleVoteE)) {
				// increase counter for single values
				n += 1;
				// loop over preferences
				for (PreferenceE prefE : singleVoteE.getPreferences()) {
					// multiply preference value with associated aggregation
					// map value
					Double oldValue = prefMap.getPref(prefE);
					Double factor;
					if (prefE.getPreferenceAoverB() < 0) {
						factor = -1.0
								/ Double.valueOf(prefE.getPreferenceAoverB());
					} else {
						factor = Double.valueOf(prefE.getPreferenceAoverB());
					}

					Double newValue = oldValue * factor;

					prefMap.changePref(prefE, newValue);
				}
			} else {
				log.error("Evaluation contains single votes with inconsistent preferences");
				return false;
			}
		}

		// Do compute nth square roots of all aggregated values

		// Loop over aggregation map values
		for (String key : prefMap.keySet()) {
			Double aggVal = prefMap.get(key);
			Double sqrVal = Math.pow(aggVal, 1D / n);
			Double resVal;
			if (sqrVal < 1.0) {
				resVal = -1.0 / sqrVal;
				if (-9.0 <= resVal && resVal < -8.0) {
					resVal = -9.0;
				} else if (-8.0 <= resVal && resVal < -6.0) {
					resVal = -7.0;
				} else if (-6.0 <= resVal && resVal < -4.0) {
					resVal = -5.0;
				} else if (-4.0 <= resVal && resVal < -2.0) {
					resVal = -3.0;
				} else if (-2.0 <= resVal && resVal < -0.0) {
					resVal = 1.0;
				}
			} else {
				resVal = sqrVal;
				if (0.0 <= resVal && resVal < 2.0) {
					resVal = 1.0;
				} else if (2.0 <= resVal && resVal < 4.0) {
					resVal = 3.0;
				} else if (4.0 <= resVal && resVal < 6.0) {
					resVal = 5.0;
				} else if (6.0 <= resVal && resVal < 8.0) {
					resVal = 7.0;
				} else if (8.0 <= resVal && resVal <= 9.0) {
					resVal = 9.0;
				}
			}

			prefMap.put(key, resVal);
		}

		// Create and persist aggregatedVoteE and its preferences

		// loop over attribute pairs
		for (int i = 0; i < attribPairs.length; i++) {
			// for (PreferenceE prefE : nullVote.getPreferences()) {

			// create new preference to be linked to aggregated vote
			PreferenceE newPrefE = new PreferenceE();

			// copy attribute types
			newPrefE.setAttributeTypeA(attribPairs[i][0]);
			newPrefE.setAttributeTypeB(attribPairs[i][1]);
			newPrefE.setPreferenceAoverB(prefMap.getPref(attribPairs[i][0],
					attribPairs[i][1]).intValue());

			log.info("attrib a:" + newPrefE.getAttributeTypeA() + ", attrib b:"
					+ newPrefE.getAttributeTypeB() + ", preference a over b:"
					+ newPrefE.getPreferenceAoverB());

			// link aggregated vote to preference
			newPrefE.setVote(aggregatedVote);

			// create preference entity
			evalVoteDao.createEntity(newPrefE);

			// link preference to aggregated vote
			aggregatedVote.addPreference(newPrefE);

			// update aggregatedVote
			evalVoteDao.mergeEntity(aggregatedVote);
		}

		eval.addAggregatedVote(aggregatedVote);
		evalVoteDao.mergeEntity(eval);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.kit.cockpit.valuationserver.aggregator.VoteAggregator#removeAggregation
	 * (edu.kit.cockpit.valuationserver.entities.EvaluationE)
	 */
	@Override
	public boolean removeAggregation(EvaluationE eval) {

		// Sanity check
		if (eval == null) {
			log.error("Evaluation is null object");
			return false;
		}

		// Check for existing aggregation
		List<AggregatedVoteE> aggVoteList = getAggregatedVotes(eval,
				AggregationType.GEOMETRIC_MEANS);

		if (aggVoteList == null) {
			log.error("Evaluation analysis failed");
			return false;
		}

		if (aggVoteList.isEmpty()) {
			log.warn("An aggreggation of type "
					+ AggregationType.GEOMETRIC_MEANS + " does not exist.");
			return true;
		}

		// detach and delete aggregations

		for (Iterator<AggregatedVoteE> iterator = aggVoteList.iterator(); iterator
				.hasNext();) {
			AggregatedVoteE aggregatedVoteE = (AggregatedVoteE) iterator.next();
			eval.removeAggregatedVote(aggregatedVoteE);
			evalVoteDao.deleteEntity(aggregatedVoteE);
		}

		return true;
	}

}
