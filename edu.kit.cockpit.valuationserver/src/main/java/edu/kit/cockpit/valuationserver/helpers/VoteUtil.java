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

package edu.kit.cockpit.valuationserver.helpers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.pollgenerator.PollGenerator;

public class VoteUtil {

	private static Log log = LogFactory.getLog(VoteUtil.class);

	/**
	 * Check conformance of vote preferences with default attribute pairings.
	 * TODO: Needs to be optimized
	 * 
	 * @param singleVoteE
	 * @return
	 */
	public static boolean isConformant(EvaluationE evalE,
			SingleVoteE singleVoteE) {

		// retrieve attribute pairings
		String[][] attribPairs = PollGenerator.getAttributePairings(evalE);

		// check number of preferences
		if (attribPairs.length != singleVoteE.getPreferences().size()) {
			log.error("Single vote entity contains no preferences");
			return false;
		}

		// Create null value map of preference keys
		PrefMap prefMap = new PrefMap(attribPairs);

		// Check for existence of singleVoteE preference keys
		for (PreferenceE prefE : singleVoteE.getPreferences()) {
			if (!prefMap.containsPref(prefE)) {
				log.error("Single vote entity contains invalid preference for attribute pairing ["
						+ prefE.getAttributeTypeA()
						+ ","
						+ prefE.getAttributeTypeB() + "]");
				return false;
			}
		}

		return true;
	}

}
