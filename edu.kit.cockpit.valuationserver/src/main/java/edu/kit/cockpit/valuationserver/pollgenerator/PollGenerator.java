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

package edu.kit.cockpit.valuationserver.pollgenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.Resource;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeType;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.helpers.DateUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.EMFUtil;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;
import eu.cockpit_project.PollType;

public class PollGenerator {

	private static Log log = LogFactory.getLog(PollGenerator.class);

	private static final String POLL_TYPE_ASPECT_COMPARISON = "Aspect Comparison";

	/**
	 * Extract service attributes from evaluation's SFM model resource
	 * 
	 * @param eval
	 * @return array of attribute names
	 */
	public static List<AttributeType> getComparableSFMAttributes(
			EvaluationE eval) {

		// Extract service object from associated SFM model
		Service service = null;
		try {
			SFMPersistency sfmpersistency = new SFMPersistency();
			Resource resource = sfmpersistency
					.loadSFMModelToResource(SFMPersistency.getModelId(eval
							.getId()));
			service = EMFUtil.getService(resource);
		} catch (IOException e1) {
			log.error(e1);
			return null;
		}

		// construct list of comparable service attribute types
		List<AttributeType> attributeList = service.getAttributeTypes().getAttributeTypes();
		List<AttributeType> compareList = new LinkedList<AttributeType>();
		for (Iterator<AttributeType> iter = attributeList.listIterator(); iter
				.hasNext();) {
			AttributeType tempAT = (AttributeType) iter.next();
			if (tempAT != null && tempAT.isToBeEvaluated() == true) {
				compareList.add(tempAT);
			}
		}
		return compareList;
	}

	/**
	 * Generate a poll message based on an evaluation
	 * 
	 * @param attribTypeList
	 * @param eval
	 * @param isVisible
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	public static PollType createPoll(EvaluationE eval, boolean isVisible)
			throws DatatypeConfigurationException {

		// List<AttributeType> attribTypeList =
		// getComparableSFMAttributes(eval);

		PollType poll = new PollType();

		poll.setType(POLL_TYPE_ASPECT_COMPARISON);

		assert (eval.getId() != null);
		poll.setEvaluationId(String.valueOf(eval.getId()));

		poll.setVisible(isVisible);

		if (eval.getPollDeadline() != null)
			poll.setEndDate(DateUtil.getXmlGregCal(eval.getPollDeadline()));

		if (eval.getName() != null)
			poll.setTitle(eval.getName());

		if (eval.getDescription() != null)
			poll.setSubtitle(eval.getDescription());

		if (eval.getServiceId() != null)
			poll.setServiceId(eval.getServiceId());

		if (eval.getPollId() != null)
			poll.setPollId(eval.getPollId());

		// generate aspects from exclusive pairs of attribute types
		poll.setAspects(new PollType.Aspects());
		String[][] attribArray = getAttributePairings(eval);
		for (int i = 0; i < attribArray.length; i++) {
			PollType.Aspects.Aspect aspect = new PollType.Aspects.Aspect();
			aspect.setFeature1(attribArray[i][0]);
			aspect.setFeature2(attribArray[i][1]);
			poll.getAspects().getAspect().add(aspect);
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JAXB.marshal(poll, baos);
		log.info("Poll generated: " + System.getProperty("line.separator")
				+ baos.toString());

		return poll;
	}

	public static String[][] getAttributePairings(EvaluationE eval) {
		List<AttributeType> attribTypeList = getComparableSFMAttributes(eval);

		int n = attribTypeList.size();
		// number of pairs as per
		String[][] result = new String[n * (n - 1) / 2][2];
		int c = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				result[c][0] = attribTypeList.get(i).getName();
				result[c][1] = attribTypeList.get(j).getName();
				c += 1;
			}
		}

		return result;
	}

}
