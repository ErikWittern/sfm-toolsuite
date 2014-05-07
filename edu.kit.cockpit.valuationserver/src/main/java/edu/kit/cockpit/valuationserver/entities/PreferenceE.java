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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Represents a single preference w.r.t. a pair of service evaluation criteria
 * (i.e. value relevant feature attributes)
 */
@Entity
@Table(name="PREFERENCE")
public class PreferenceE implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Timestamp lastUpdate;

	@ManyToOne(fetch=FetchType.EAGER)
	private VoteE vote;

	@Column(nullable = false)
	private String featureAttributeType1;

	@Column(nullable = false)
	private String featureAttributeType2;

	@Column(nullable = false)
	private Integer preference1over2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public VoteE getVote() {
		return vote;
	}

	public void setVote(VoteE vote) {
		this.vote = vote;
	}

	public String getAttributeTypeA() {
		return featureAttributeType1;
	}

	public void setAttributeTypeA(String attributeTypeA) {
		this.featureAttributeType1 = attributeTypeA;
	}

	public String getAttributeTypeB() {
		return featureAttributeType2;
	}

	public void setAttributeTypeB(String attributeTypeB) {
		this.featureAttributeType2 = attributeTypeB;
	}

	public Integer getPreferenceAoverB() {
		return preference1over2;
	}

	public void setPreferenceAoverB(Integer preferenceAoverB) {
		this.preference1over2 = preferenceAoverB;
	}
}
