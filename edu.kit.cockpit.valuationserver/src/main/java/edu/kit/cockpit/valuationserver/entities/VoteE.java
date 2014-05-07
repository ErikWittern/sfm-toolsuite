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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Represents a vote containing sets of preferences (pairwise comparisons of
 * valuation criteria).
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "VOTE_TYPE")
@Table(name = "VOTE")
public abstract class VoteE implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Timestamp lastUpdate;

	@Column(nullable = true)
	private String stakeholderGroup;
	
	@Column(nullable = true, length = 2000)
	private String description;

	@OneToMany(mappedBy = "vote", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<PreferenceE> preferences = new ArrayList<PreferenceE>();

	public boolean addPreference(PreferenceE preference) {
		preference.setVote(this);
		return preferences.add(preference);
	}

	public boolean removePreference(PreferenceE preference) {
		boolean b = preferences.remove(preference);
		if (b)
			preference.setVote(null);
		return b;
	}

	public String getStakeholderGroup() {
		return stakeholderGroup;
	}

	public void setStakeholderGroup(String stakeholderGroup) {
		this.stakeholderGroup = stakeholderGroup;
	}

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

	public List<PreferenceE> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<PreferenceE> preferences) {
		this.preferences = preferences;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
