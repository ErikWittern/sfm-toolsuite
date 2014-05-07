/*
 * Project: Cockpit Valuation Server
 * $Header: $
 * Author:  Christian Zirpins
 * Last Change: 
 *    by:   $Author: $
 *    date: $Date:   $
 * Copyright (c): KIT, 2011
 */

package edu.kit.cockpit.valuationserver.test;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.entities.VoteE;
import edu.kit.cockpit.valuationserver.sfmpersistency.EMFUtil;
import edu.kit.cockpit.valuationserver.valuation.SimpleAHPAdapter;

public class ValuationTest {

	Log log = LogFactory.getLog(this.getClass());

	Service service;
	VoteE vote;

	@Before
	public void setUp() throws Exception {

		URL url = getClass().getClassLoader().getResource(
				CVSrvContext.GR01_SFM_FILENAME);
		log.info("Loading test model file: " + url.getFile());

		Resource resource = EMFUtil.loadSFMModelToResource(url.getFile(),
				CVSrvContext.SFM_NAMESPACE, CVSrvContext.SFM_PACKAGE);
		service = EMFUtil.getService(resource);
		log.info("SFM service loaded: " + service.getName() + " : "
				+ service.getDescription());

		vote = constructVote();
		log.info("Vote constructed: " + vote);
	}

//	@Test
	public void testComputeConfigurationPreferenceVector() {
		//AotearoaAdapter.computeConfigurationPreferenceVector(service, vote);
		SimpleAHPAdapter.computeConfigurationPreferenceVector(service, vote);
	}

	/**
	 * Construct a single vote with preferences matching the test model
	 * 
	 * @return the vote
	 */
	protected static VoteE constructVote() {
		VoteE vote = new SingleVoteE();
		vote.setId((long) 123);
		vote.setLastUpdate(new Timestamp(new Date().getTime()));
		vote.setStakeholderGroup("Citizens");

		// <contains name="Cost" scaleOrder="LowerIsBetter" toBeEvaluated="true"
		// description="The cost of a feature."/>
		// <contains name="Throughput" toBeEvaluated="true"
		// description="The throughput of a feature."/>
		PreferenceE pref1 = new PreferenceE();
		pref1.setId((long) 1);
		pref1.setLastUpdate(new Timestamp(new Date().getTime()));
		pref1.setAttributeTypeA("Cost");
		pref1.setAttributeTypeB("Throughput");
		pref1.setPreferenceAoverB(-9);
		vote.getPreferences().add(pref1);

		// <contains name="Cost" scaleOrder="LowerIsBetter" toBeEvaluated="true"
		// description="The cost of a feature."/>
		// <contains name="Sends mail" domain="Boolean"
		// aggregationRule="AtLeastOnce" scaleOrder="ExistenceIsBetter"
		// toBeEvaluated="true" description="" customAttributeTypePriority="5"/>
		PreferenceE pref2 = new PreferenceE();
		pref2.setId((long) 2);
		pref2.setLastUpdate(new Timestamp(new Date().getTime()));
		pref2.setAttributeTypeA("Cost");
		pref2.setAttributeTypeB("Sends mail");
		pref2.setPreferenceAoverB(-9);
		vote.getPreferences().add(pref2);

		// <contains name="Cost" scaleOrder="LowerIsBetter" toBeEvaluated="true"
		// description="The cost of a feature."/>
		// <contains name="Processing time" scaleOrder="LowerIsBetter"
		// toBeEvaluated="true" description=""/>
		PreferenceE pref3 = new PreferenceE();
		pref3.setId((long) 3);
		pref3.setLastUpdate(new Timestamp(new Date().getTime()));
		pref3.setAttributeTypeA("Cost");
		pref3.setAttributeTypeB("Processing time");
		pref3.setPreferenceAoverB(-9);
		vote.getPreferences().add(pref3);

		// <contains name="Throughput" toBeEvaluated="true"
		// description="The throughput of a feature."/>
		// <contains name="Sends mail" domain="Boolean"
		// aggregationRule="AtLeastOnce" scaleOrder="ExistenceIsBetter"
		// toBeEvaluated="true" description="" customAttributeTypePriority="5"/>
		PreferenceE pref4 = new PreferenceE();
		pref4.setId((long) 4);
		pref4.setLastUpdate(new Timestamp(new Date().getTime()));
		pref4.setAttributeTypeA("Throughput");
		pref4.setAttributeTypeB("Sends mail");
		pref4.setPreferenceAoverB(-9);
		vote.getPreferences().add(pref4);

		// <contains name="Throughput" toBeEvaluated="true"
		// description="The throughput of a feature."/>
		// <contains name="Processing time" scaleOrder="LowerIsBetter"
		// toBeEvaluated="true" description=""/>
		PreferenceE pref5 = new PreferenceE();
		pref5.setId((long) 5);
		pref5.setLastUpdate(new Timestamp(new Date().getTime()));
		pref5.setAttributeTypeA("Throughput");
		pref5.setAttributeTypeB("Processing time");
		pref5.setPreferenceAoverB(-9);
		vote.getPreferences().add(pref5);

		// <contains name="Sends mail" domain="Boolean"
		// aggregationRule="AtLeastOnce" scaleOrder="ExistenceIsBetter"
		// toBeEvaluated="true" description="" customAttributeTypePriority="5"/>
		// <contains name="Processing time" scaleOrder="LowerIsBetter"
		// toBeEvaluated="true" description=""/>
		PreferenceE pref6 = new PreferenceE();
		pref6.setId((long) 6);
		pref6.setLastUpdate(new Timestamp(new Date().getTime()));
		pref6.setAttributeTypeA("Sends mail");
		pref6.setAttributeTypeB("Processing time");
		pref6.setPreferenceAoverB(9);
		vote.getPreferences().add(pref6);

		return vote;
	}
}
