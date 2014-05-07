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

import java.util.Iterator;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Attribute;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.entities.AggregatedVoteE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.entities.VoteE;
import edu.kit.cockpit.valuationserver.rest.messages.Configuration;
import edu.kit.cockpit.valuationserver.rest.messages.ObjectFactory;

public class ConfigurationMapper {

	public static Configuration mapToConfigurationMessage(VoteE vote,
			float[] preferenceVecor, Service service) {

		ObjectFactory of = new ObjectFactory();
		Configuration result = of.createConfiguration();

		// initiate two lists (attributes of winning configuration, all
		// configurations)
		// ///////////////////////////

		result.setConfigurationAttributes(new Configuration.ConfigurationAttributes());
		result.setConfigurationRanking(new Configuration.ConfigurationRanking());

		// generate resource URLs
		// ///////////////////////////

		if (vote instanceof SingleVoteE)
			result.setVoteUrl(SingleVoteMapper.genUrl((SingleVoteE) vote));
		else if (vote instanceof AggregatedVoteE)
			result.setVoteUrl(AggregatedVoteMapper
					.genUrl((AggregatedVoteE) vote));

		// generate configuration attributes
		// ///////////////////////////

		// get index of preferred configuration
		int prefIndex = getIndexOfPreferredConfiguration(preferenceVecor);

		// retrieve preferred configuration
		edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Configuration config = service.getConfigurations().getConfigurations().get(prefIndex);

		// map description
		if (config.getDescription() != null)
			result.setConfigDescription(config.getDescription());

		// map id
		if (config.getId() != null)
			result.setConfigId(config.getId());

		// map name
		if (config.getName() != null)
			result.setConfigName(config.getName());

		// iterate over attributes and map them to result message
		for (Iterator<Attribute> iterator = config.getAttributes().iterator(); iterator
				.hasNext();) {
			Attribute attribute = (Attribute) iterator.next();
			Configuration.ConfigurationAttributes.FeatureAttribute msgAttrib = new Configuration.ConfigurationAttributes.FeatureAttribute();
			if (attribute.getAttributeType() != null)
				if (attribute.getAttributeType().getName() != null)
					msgAttrib.setFeatureAttributeType(attribute
							.getAttributeType().getName());
			if (attribute.getInstantiationValue() != null)
				msgAttrib.setFeatureAttributeValue(attribute
						.getInstantiationValue());
			result.getConfigurationAttributes().getFeatureAttribute()
					.add(msgAttrib);
		} // for

		// iterate over preferenceVecor and map configuration IDs to result
		// message
		for (int i = 0; i < preferenceVecor.length; i++) {
			edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Configuration nextConfig = service
					.getConfigurations().getConfigurations().get(i);
			Configuration.ConfigurationRanking.RankedConfiguration msgConfig = new Configuration.ConfigurationRanking.RankedConfiguration();
			if (nextConfig.getId() != null)
				msgConfig.setConfigurationId(nextConfig.getId());
			msgConfig.setPreferenceValue(preferenceVecor[i]);
			result.getConfigurationRanking().getRankedConfiguration()
					.add(msgConfig);
		}

		return result;
	}

	/**
	 * @param preferenceVecor
	 * @return index of preferred configuration
	 */
	private static int getIndexOfPreferredConfiguration(float[] preferenceVecor) {
		int indexOfHighestValue = 0;
		float highestValueSoFar = 0;
		for (int i = 0; i < preferenceVecor.length; i++)
			if (preferenceVecor[i] > highestValueSoFar) {
				indexOfHighestValue = i;
				highestValueSoFar = preferenceVecor[i];
			}
		return indexOfHighestValue;
	}
}
