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

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.kit.cockpit.valuationserver.dao.EvaluationVoteDao;
import edu.kit.cockpit.valuationserver.entities.AggregatedVoteE;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;

public abstract class AbstractAggregator implements VoteAggregator {

	public static final String DEFAULT_CLUSTER_ID = "1";

	public static final String DEFAULT_STAKEHOLDER_GROUP = "undefined";
	
	public static class AggregationType {
		public static final String GEOMETRIC_MEANS = "GEOMETRIC_MEANS";
	}

	Log log = LogFactory.getLog(this.getClass());

	EvaluationVoteDao evalVoteDao = null;

	public AbstractAggregator() {
		try {
			evalVoteDao = new EvaluationVoteDao();
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * @param eval
	 * @param aggregationType
	 * @return
	 */
	public List<AggregatedVoteE> getAggregatedVotes(EvaluationE eval,
			String aggregationType) {

		if (eval == null) {
			log.error("Evaluation entity is null");
			return null;
		}

		List<AggregatedVoteE> results = new LinkedList<AggregatedVoteE>();

		if (!eval.getAggregatedVotes().isEmpty())
			for (AggregatedVoteE ave : eval.getAggregatedVotes()) {
				if (ave.getAggregationType().equals(aggregationType)) {
					results.add(ave);
				}
			}

		return results;
	}

}