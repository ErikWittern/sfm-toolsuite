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

package edu.kit.cockpit.valuationserver.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * Represents an aggregation of multiple single votes.
 */
@Entity
@DiscriminatorValue("A")
@NamedQuery(name = AggregatedVoteE.QUERY_BY_AGGREGATION_TYPE, query = "Select a from AggregatedVoteE a where a.aggregationType = :aggregationType")
public class AggregatedVoteE extends VoteE {

	private static final long serialVersionUID = 1L;

	public static final String QUERY_BY_AGGREGATION_TYPE = "AggregatedVoteE.QUERY_BY_AGGREGATION_TYPE";

	@ManyToOne(fetch=FetchType.EAGER)
	private EvaluationE aggregatorEvaluation;

	/**
	 * Information on the way the aggregation was done
	 */
	@Column(nullable = true, length = 200)
	private String aggregationType;

	/**
	 * Identification of the aggregation cluster
	 */
	@Column(nullable = true, length = 200)
	private String clusterId;

	/**
	 * @param aggregatorEvaluation
	 *            the aggregatorEvaluation to set
	 */
	public void setAggregatorEvaluation(EvaluationE aggregatorEvaluation) {
		this.aggregatorEvaluation = aggregatorEvaluation;
	}

	/**
	 * @return the aggregatorEvaluation
	 */
	public EvaluationE getAggregatorEvaluation() {
		return aggregatorEvaluation;
	}

	/**
	 * @return the aggregationType
	 */
	public String getAggregationType() {
		return aggregationType;
	}

	/**
	 * @param aggregationType
	 *            the aggregationType to set
	 */
	public void setAggregationType(String aggregationType) {
		this.aggregationType = aggregationType;
	}

	/**
	 * @return the clusterId
	 */
	public String getClusterId() {
		return clusterId;
	}

	/**
	 * @param clusterId
	 *            the clusterId to set
	 */
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
}
