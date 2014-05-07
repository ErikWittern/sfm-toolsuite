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

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.entities.EvaluationE.EvaluationState;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.helpers.DateUtil;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluations;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluations.EvaluationEntry;
import edu.kit.cockpit.valuationserver.rest.messages.ObjectFactory;
import edu.kit.cockpit.valuationserver.sfmpersistency.SFMPersistency;

public class EvaluationMapper {

	private static Log log = LogFactory.getLog(EvaluationMapper.class);

	public static EvaluationE cloneEvaluationEntity(EvaluationE source) {

		if (source == null)
			return null;

		EvaluationE target = new EvaluationE();

		// ServiceId is required
		if (source.getServiceId() == null)
			return null;
		target.setServiceId(source.getServiceId());

		// name is required
		if (source.getName() == null)
			return null;
		target.setName(source.getName());

		// version is required
		if (source.getVersion() == null)
			return null;
		target.setVersion(source.getVersion());

		// State is required
		if (source.getState() == null)
			return null;
		else
			target.setState(source.getState());

		// Description is optional
		if (source.getDescription() != null)
			target.setDescription(source.getDescription());

		// StakeholderGroup is optional
		if (source.getStakeholderGroup() != null)
			target.setStakeholderGroup(source.getStakeholderGroup());

		// pollDeadline is optional
		if (source.getPollDeadline() != null)
			target.setPollDeadline(source.getPollDeadline());

		return target;
	}

	public static EvaluationE mapToEvaluationEntity(Evaluation source,
			EvaluationE target) {

		if (source == null)
			return null;

		if (target == null)
			target = new EvaluationE();

		// ServiceId is required
		if (source.getServiceId() == null)
			return null;
		target.setServiceId(source.getServiceId());

		// name is required
		if (source.getName() == null)
			return null;
		target.setName(source.getName());

		// version is required
		if (source.getVersion() == null)
			return null;
		target.setVersion(source.getVersion());

		// State is required
		int state = source.getState();
		if (state < 0 || state > 3)
			return null;
		else
			target.setState(mapEvaluationState(state));

		// Description is optional
		if (source.getDescription() != null)
			target.setDescription(source.getDescription());

		// StakeholderGroup is optional
		if (source.getStakeholderGroup() != null)
			target.setStakeholderGroup(source.getStakeholderGroup());

		// pollDeadline is optional
		if (source.getPollDeadline() != null)
			target.setPollDeadline(DateUtil.getDate(source.getPollDeadline()));

		return target;
	}

	public static Evaluation mapToEvaluationMessage(EvaluationE evalE) {

		ObjectFactory of = new ObjectFactory();
		Evaluation result = of.createEvaluation();

		// set static data
		// ///////////////////////////

		// evaluation id
		if (evalE.getId() != null)
			result.setEvaluationId(evalE.getId());

		// name
		if (evalE.getName() != null)
			result.setName(evalE.getName());

		// version
		if (evalE.getVersion() != null)
			result.setVersion(evalE.getVersion());

		// description
		if (evalE.getDescription() != null)
			result.setDescription(evalE.getDescription());

		// service id
		if (evalE.getServiceId() != null)
			result.setServiceId(evalE.getServiceId());

		// pollDeadline
		if (evalE.getPollDeadline() != null)
			try {
				result.setPollDeadline(DateUtil.getXmlGregCal(evalE
						.getPollDeadline()));
			} catch (DatatypeConfigurationException e) {
				log.error(e);
			}

		// stakeholder group
		if (evalE.getStakeholderGroup() != null)
			result.setStakeholderGroup(evalE.getStakeholderGroup());

		// state
		if (evalE.getState() == null)
			return null;
		else
			result.setState(mapEvaluationState(evalE.getState()));

		// generate resource URLs
		// ///////////////////////////

		// 1 evaluation (this)
		if (evalE.getId() != null)
			result.setEvaluationUrl(EvaluationMapper.genUrl(evalE));

		// 1 model (null if it does not exist)
		String mUrl = SFMPersistency.getModelURL(evalE.getId());
		if (mUrl != null)
			result.setModelUrl(mUrl);

		// n single votes (if exist)
		for (SingleVoteE singleVote : evalE.getSingleVotes()) {
			if (singleVote.getId() != null)
				result.getSingleVoteUrl().add(
						SingleVoteMapper.genUrl(singleVote));
		}

		// aggregation vote list changed to aggregation votes container
		// (see above)
		//
		// n aggregated votes (if exist)
		// for (AggregatedVoteE aggregatedVote : evalE.getAggregatedVotes()) {
		// if (aggregatedVote.getId() != null)
		// result.getAggregatedVoteUrl().add(
		// AggregatedVoteMapper.getUrl(aggregatedVote));
		// }

		return result;
	}

	/**
	 * @param results
	 * @return
	 */
	public static Evaluations mapToEvaluationsMessage(List<EvaluationE> results) {

		if (results == null)
			return null;

		ObjectFactory of = new ObjectFactory();

		Evaluations evaluations = of.createEvaluations();

		for (EvaluationE evaluationE : results) {
			EvaluationEntry evaluationEntry = new EvaluationEntry();
			if (evaluationE.getId() != null)
				evaluationEntry.setEvaluationId(String.valueOf(evaluationE
						.getId()));
			evaluationEntry.setEvaluationUrl(EvaluationMapper
					.genUrl(evaluationE));
			evaluations.getEvaluationEntry().add(evaluationEntry);
		}

		return evaluations;
	}

	public static EvaluationState mapEvaluationState(int state) {
		switch (state) {
		case 0:
			return EvaluationState.CREATED;
		case 1:
			return EvaluationState.RUNNING;
		case 2:
			return EvaluationState.ABORTED;
		case 3:
			return EvaluationState.FINISHED;
		default:
			return null;
		}
	}

	public static int mapEvaluationState(EvaluationState state) {
		switch (state) {
		case CREATED:
			return 0;
		case RUNNING:
			return 1;
		case ABORTED:
			return 2;
		case FINISHED:
			return 3;
		default:
			return -1;
		}
	}

	/**
	 * @param evaluationE
	 *            is an evaluation entity
	 * @return the url of the evaluation resource
	 */
	static String genUrl(EvaluationE evaluationE) {

		String url = CVSrvContext.getInstance().getValuationServerUrlBase()
				+ CVSrvContext.EVALUATION_URL_PREFIX
				+ String.valueOf(evaluationE.getId());

		return url;
	}

}
