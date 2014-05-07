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

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Represents an evaluation run with individual as well as aggregated votes.
 */
@Entity
@Table(name = "EVALUATION")
@NamedQueries({
		@NamedQuery(name = EvaluationE.QUERY_BY_SERVICE_ID, query = "Select a from EvaluationE a where a.serviceId = :serviceId"),
		@NamedQuery(name = EvaluationE.QUERY_BY_STAKEHOLDER_GROUP, query = "Select a from EvaluationE a where a.stakeholderGroup = :stakeholderGroup") })
public class EvaluationE implements Serializable {

	private static final long serialVersionUID = 132986658011639467L;

	public static final String QUERY_BY_SERVICE_ID = "EvaluationE.QUERY_BY_SERVICE_ID";
	public static final String QUERY_BY_STAKEHOLDER_GROUP = "EvaluationE.QUERY_BY_STAKEHOLDER_GROUP_GROUP";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Timestamp lastUpdate;

	@Column(nullable = false)
	private String serviceId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String version;

	@Column(nullable = false, length = 2000)
	private String description;

	@Column(nullable = false)
	private String stakeholderGroup;

	@Column(nullable = true)
	private Date pollDeadline;

	@Column(nullable = true)
	private String pollId;
		
	public enum EvaluationState {
		CREATED, RUNNING, ABORTED, FINISHED
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EvaluationState state;

	@OneToMany(mappedBy = "containerEvaluation", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Set<SingleVoteE> singleVotes = new HashSet<SingleVoteE>();

	public boolean addSingleVote(SingleVoteE vote) {
		vote.setContainerEvaluation(this);
		return singleVotes.add(vote);
	}

	public boolean removeSingleVote(SingleVoteE vote) {
		boolean b = singleVotes.remove(vote);
		if (b)
			vote.setContainerEvaluation(null);
		return b;
	}

	@OneToMany(mappedBy = "aggregatorEvaluation", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Set<AggregatedVoteE> aggregatedVotes = new HashSet<AggregatedVoteE>();

	public boolean addAggregatedVote(AggregatedVoteE vote) {
		vote.setAggregatorEvaluation(this);
		return aggregatedVotes.add(vote);
	}

	public boolean removeAggregatedVote(AggregatedVoteE vote) {
		boolean b = aggregatedVotes.remove(vote);
		if (b)
			vote.setAggregatorEvaluation(null);
		return b;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lastUpdate
	 */
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate
	 *            the lastUpdate to set
	 */
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId
	 *            the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the stakeholderGroup
	 */
	public String getStakeholderGroup() {
		return stakeholderGroup;
	}

	/**
	 * @param stakeholderGroup
	 *            the stakeholderGroup to set
	 */
	public void setStakeholderGroup(String stakeholderGroup) {
		this.stakeholderGroup = stakeholderGroup;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the state
	 */
	public EvaluationState getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(EvaluationState state) {
		this.state = state;
	}

	/**
	 * @return the singleVotes
	 */
	public Set<SingleVoteE> getSingleVotes() {
		return singleVotes;
	}

	/**
	 * @param singleVotes
	 *            the singleVotes to set
	 */
	public void setSingleVotes(Set<SingleVoteE> singleVotes) {
		this.singleVotes = singleVotes;
	}

	/**
	 * @return the aggregatedVotes
	 */
	public Set<AggregatedVoteE> getAggregatedVotes() {
		return aggregatedVotes;
	}

	/**
	 * @param aggregatedVotes
	 *            the aggregatedVotes to set
	 */
	public void setAggregatedVotes(Set<AggregatedVoteE> aggregatedVotes) {
		this.aggregatedVotes = aggregatedVotes;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the pollDeadline
	 */
	public Date getPollDeadline() {
		return pollDeadline;
	}

	/**
	 * @param pollDeadline
	 *            the pollDeadline to set
	 */
	public void setPollDeadline(Date pollDeadline) {
		this.pollDeadline = pollDeadline;
	}

	/**
	 * @return the pollId
	 */
	public String getPollId() {
		return pollId;
	}

	/**
	 * @param pollId the pollId to set
	 */
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}
}