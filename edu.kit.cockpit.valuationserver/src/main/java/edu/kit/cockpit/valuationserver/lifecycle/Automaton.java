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

package edu.kit.cockpit.valuationserver.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.rest.clients.DPInteractionException;
import edu.kit.cockpit.valuationserver.rest.clients.DeliberationPlatformClient;

public class Automaton {

	private static Log log = LogFactory.getLog(Automaton.class);

	public enum LifecycleState {
		CREATED_NO_DEADLINE, CREATED_FURURE_DEADLINE, RUNNING_FUTURE_DEADLINE, RUNNING_PAST_DEADLINE, ABORTED_FUTURE_DEADLINE, ABORTED_PAST_DEADLINE, FINISHED, DELETED,
	}

	@SuppressWarnings("incomplete-switch")
	public static void doTransition(Transition t, boolean skipDpInteraction)
			throws LifecycleException, DPInteractionException {

		// set switch for doing DP interactions
		boolean doIt = !(skipDpInteraction || CVSrvContext.getInstance()
				.getServerProps().getProperty("skip.dp.interaction")
				.equals("true"));

		switch (t.from) {

		// ////////////////////////////////////////////////////////////

		case CREATED_NO_DEADLINE:
			switch (t.to) {
			case CREATED_NO_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					return;
				case CHANGE_MODEL:
					logStateChange(t);
					return;
				case CREATE_MODEL:
					logStateChange(t);
					return;
				case DELETE_MODEL:
					logStateChange(t);
					return;
				}// switch:action
			case CREATED_FURURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					return;
				}// switch:action
			case RUNNING_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// publish evaluation poll
					if (doIt)
						DeliberationPlatformClient
								.publishEvaluationPoll((EvaluationE) t.newEval);
					return;
				}// switch:action
			case DELETED:
				switch (t.action) {
				case DELETE_EVAL:
					logStateChange(t);
					return;
				}// switch:action
			}// switch:to

			// ////////////////////////////////////////////////////////////

		case CREATED_FURURE_DEADLINE:

			switch (t.to) {
			case CREATED_FURURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					return;
				case CHANGE_MODEL:
					logStateChange(t);
					return;
				case CREATE_MODEL:
					logStateChange(t);
					return;
				case DELETE_MODEL:
					logStateChange(t);
					return;
				}// switch:action
			case RUNNING_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// publish evaluation poll
					if (doIt)
						DeliberationPlatformClient
								.publishEvaluationPoll((EvaluationE) t.newEval);
					return;
				}// switch:action
			case DELETED:
				switch (t.action) {
				case DELETE_EVAL:
					logStateChange(t);
					return;
				}// switch:action
			}// switch:to

			// ////////////////////////////////////////////////////////////

		case RUNNING_FUTURE_DEADLINE:

			switch (t.to) {
			case RUNNING_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(true,
								(EvaluationE) t.newEval);
					return;
				case CHANGE_SVOTE:
					logStateChange(t);
					return;
				case CREATE_SVOTE:
					logStateChange(t);
					return;
				case DELETE_SVOTE:
					logStateChange(t);
					return;
				}// switch:action
			case ABORTED_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(false,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			}// switch:to

			// ////////////////////////////////////////////////////////////

		case RUNNING_PAST_DEADLINE:

			switch (t.to) {
			case RUNNING_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(true,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			case RUNNING_PAST_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(true,
								(EvaluationE) t.newEval);
					return;
				case CHANGE_SVOTE:
					logStateChange(t);
					return;
				case DELETE_SVOTE:
					logStateChange(t);
					return;
				}// switch:action
			case ABORTED_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(false,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			case ABORTED_PAST_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(false,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			case FINISHED:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					return;
				}// switch:action
			}// switch:to

			// ////////////////////////////////////////////////////////////

		case ABORTED_FUTURE_DEADLINE:

			switch (t.to) {
			case RUNNING_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(true,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			case ABORTED_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(false,
								(EvaluationE) t.newEval);
					return;
				case CHANGE_SVOTE:
					logStateChange(t);
					return;
				case DELETE_SVOTE:
					logStateChange(t);
					return;
				}// switch:action
			case DELETED:
				switch (t.action) {
				case DELETE_EVAL:
					logStateChange(t);
					return;
				}// switch:action
			}// switch:to

			// ////////////////////////////////////////////////////////////

		case ABORTED_PAST_DEADLINE:

			switch (t.to) {
			case RUNNING_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(true,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			case ABORTED_FUTURE_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(false,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			case ABORTED_PAST_DEADLINE:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(false,
								(EvaluationE) t.newEval);
					return;
				case CHANGE_SVOTE:
					logStateChange(t);
					return;
				case DELETE_SVOTE:
					logStateChange(t);
					return;
				}// switch:action
			case FINISHED:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(true,
								(EvaluationE) t.newEval);
					return;
				}// switch:action
			case DELETED:
				switch (t.action) {
				case DELETE_EVAL:
					logStateChange(t);
					return;
				}// switch:action
			}// switch:to

			// ////////////////////////////////////////////////////////////

		case FINISHED:

			switch (t.to) {
			case FINISHED:
				switch (t.action) {
				case CHANGE_EVAL:
					logStateChange(t);
					// update evaluation poll
					if (doIt)
						DeliberationPlatformClient.updateEvaluationPoll(true,
								(EvaluationE) t.newEval);
					return;
				case CHANGE_SVOTE:
					logStateChange(t);
					return;
				case DELETE_SVOTE:
					logStateChange(t);
					return;
				}// switch:action
			case DELETED:
				switch (t.action) {
				case DELETE_EVAL:
					logStateChange(t);
					return;
				}// switch:action
			}// switch:to

			// ////////////////////////////////////////////////////////////

		}// switch:from

		// if we get here this means that the transition is not explicitly
		// allowed and thus it is forbidden. So let's throw an exception.
		throw new LifecycleException(t);
	}

	/**
	 * @param finished
	 * @param finished2
	 * @param t
	 */
	private static void logStateChange(Transition t) {
		log.info("Evaluation '" + t.newEval.getName() + "' changing from '"
				+ t.from.name() + "' to '" + t.to.name() + "' doing '"
				+ t.action.name());
	}
}