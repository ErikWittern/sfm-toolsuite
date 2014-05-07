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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.kit.cockpit.valuationserver.entities.PreferenceE;

public class PrefMap {

	private Map<String, Double> prefMap = new HashMap<String, Double>();

	private final Double nullPref = new Double(1);

	/**
	 * @param attribPairs
	 */
	public PrefMap(String[][] attribPairs) {
		for (int i = 0; i < attribPairs.length; i++) {
			put(genKey(attribPairs[i][0], attribPairs[i][1]), nullPref);
		}
	}

	/**
	 * @param prefE
	 * @return
	 */
	public Double putPref(PreferenceE prefE) {
		return prefMap.put(genKey(prefE), (double) prefE.getPreferenceAoverB());
	}

	/**
	 * @param prefE
	 * @return
	 */
	public Double changePref(PreferenceE prefE, Double newValue) {
		if (containsPref(prefE))
			removePref(prefE);
		return prefMap.put(genKey(prefE), newValue);
	}

	/**
	 * @param prefE
	 * @return
	 */
	public Double getPref(PreferenceE prefE) {
		return prefMap.get(genKey(prefE));
	}

	/**
	 * @param prefE
	 * @return
	 */
	public Double getPref(String attributeTypeA, String attributeTypeB) {
		return prefMap.get(genKey(attributeTypeA, attributeTypeB));
	}

	/**
	 * @param prefE
	 * @return
	 */
	public Double removePref(PreferenceE prefE) {
		return prefMap.remove(genKey(prefE));
	}

	/**
	 * @param prefE
	 * @return
	 */
	public boolean containsPref(PreferenceE prefE) {
		return prefMap.containsKey(genKey(prefE));
	}

	/**
	 * @return the prefMap
	 */
	public Map<String, Double> getPrefMap() {
		return prefMap;
	}

	/**
	 * @param prefMap
	 *            the prefMap to set
	 */
	public void setPrefMap(Map<String, Double> prefMap) {
		this.prefMap = prefMap;
	}

	/**
	 * Generates key for prefE in vote map
	 * 
	 * @param prefE
	 * @return key
	 */
	private String genKey(PreferenceE prefE) {
		return prefE.getAttributeTypeA() + prefE.getAttributeTypeB();
	}

	/**
	 * Generates key for prefE in vote map
	 * 
	 * @param prefE
	 * @return key
	 */
	private String genKey(String attributeTypeA, String attributeTypeB) {
		return attributeTypeA + attributeTypeB;
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Double get(Object key) {
		return prefMap.get(key);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public Double remove(Object key) {
		return prefMap.remove(key);
	}

	/**
	 * @return
	 * @see java.util.Map#keySet()
	 */
	public Set<String> keySet() {
		return prefMap.keySet();
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Double put(String key, Double value) {
		return prefMap.put(key, value);
	}

}
