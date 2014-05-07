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

public class GR01DemoValuationTest {

	Log log = LogFactory.getLog(this.getClass());

	Service service;
	VoteE vote;

	@Before
	public void setUp() throws Exception {

		URL url = getClass().getClassLoader().getResource(
				CVSrvContext.SFM_GR01DEMO_FILENAME);
		log.info("Loading test model file: " + url.getFile());

		Resource resource = EMFUtil.loadSFMModelToResource(url.getFile(),
				CVSrvContext.SFM_NAMESPACE, CVSrvContext.SFM_PACKAGE);
		service = EMFUtil.getService(resource);
		log.info("SFM service loaded: " + service.getName() + " : "
				+ service.getDescription());

		vote = constructVote();
		log.info("Vote constructed: " + vote);
	}

	@Test
	public void testComputeConfigurationPreferenceVector() {
		//AotearoaAdapter.computeConfigurationPreferenceVector(service, vote);
		//Erik:
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
		
	    // <contains name="AttLowerBetter" scaleOrder="LowerIsBetter" toBeEvaluated="true"/>
	    // <contains name="AttStandard" aggregationRule="Product" toBeEvaluated="true"/>
		PreferenceE pref = new PreferenceE();
		pref.setId((long) 1);
		pref.setLastUpdate(new Timestamp(new Date().getTime()));
		pref.setAttributeTypeA("Cost");
		pref.setAttributeTypeB("Personal assistance");
		pref.setPreferenceAoverB(-3);
		vote.getPreferences().add(pref);

		pref = new PreferenceE();
		pref.setId((long) 2);
		pref.setLastUpdate(new Timestamp(new Date().getTime()));
		pref.setAttributeTypeA("Home access");
		pref.setAttributeTypeB("Personal assistance");
		pref.setPreferenceAoverB(5);
		vote.getPreferences().add(pref);

		pref = new PreferenceE();
		pref.setId((long) 3);
		pref.setLastUpdate(new Timestamp(new Date().getTime()));
		pref.setAttributeTypeA("Cost");
		pref.setAttributeTypeB("Throughput");
		pref.setPreferenceAoverB(-3);
		vote.getPreferences().add(pref);

		pref = new PreferenceE();
		pref.setId((long) 4);
		pref.setLastUpdate(new Timestamp(new Date().getTime()));
		pref.setAttributeTypeA("Throughput");
		pref.setAttributeTypeB("Home access");
		pref.setPreferenceAoverB(-7);
		vote.getPreferences().add(pref);
		
		pref = new PreferenceE();
		pref.setId((long) 5);
		pref.setLastUpdate(new Timestamp(new Date().getTime()));
		pref.setAttributeTypeA("Throughput");
		pref.setAttributeTypeB("Personal assistance");
		pref.setPreferenceAoverB(-3);
		vote.getPreferences().add(pref);

		pref = new PreferenceE();
		pref.setId((long) 6);
		pref.setLastUpdate(new Timestamp(new Date().getTime()));
		pref.setAttributeTypeA("Cost");
		pref.setAttributeTypeB("Home access");
		pref.setPreferenceAoverB(-7);
		vote.getPreferences().add(pref);

		return vote;
	}
}
