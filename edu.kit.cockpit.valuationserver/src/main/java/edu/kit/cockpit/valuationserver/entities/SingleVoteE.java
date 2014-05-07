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
 * Represents a single vote.
 */
@Entity
@DiscriminatorValue("S")
@NamedQuery(name = SingleVoteE.QUERY_BY_VOTER_ID, query = "Select a from SingleVoteE a where a.voterId = :voterId")
public class SingleVoteE extends VoteE {

	public static final String QUERY_BY_VOTER_ID = "SingleVoteE.QUERY_BY_VOTER_ID";

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.EAGER)
	private EvaluationE containerEvaluation;

	/**
	 * Identification of the voter
	 */
	@Column(nullable = true)
	private String voterId;

	/**
	 * @param containerEvaluation
	 *            the containerEvaluation to set
	 */
	public void setContainerEvaluation(EvaluationE containerEvaluation) {
		this.containerEvaluation = containerEvaluation;
	}

	/**
	 * @return the containerEvaluation
	 */
	public EvaluationE getContainerEvaluation() {
		return containerEvaluation;
	}

	/**
	 * @return the voterId
	 */
	public String getVoterId() {
		return voterId;
	}

	/**
	 * @param voterId
	 *            the voterId to set
	 */
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
}
