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

import java.util.Date;

import edu.kit.cockpit.valuationserver.entities.EvaluationE;
import edu.kit.cockpit.valuationserver.entities.EvaluationE.EvaluationState;
import edu.kit.cockpit.valuationserver.helpers.DateUtil;
import edu.kit.cockpit.valuationserver.lifecycle.Automaton.LifecycleState;

public class Transition {

	public enum Action {
		DELETE_EVAL, CHANGE_EVAL, CREATE_MODEL, DELETE_MODEL, CHANGE_MODEL, CREATE_SVOTE, DELETE_SVOTE, CHANGE_SVOTE,
	}

	Automaton.LifecycleState from;
	Automaton.LifecycleState to;
	Action action;
	EvaluationE oldEval;
	EvaluationE newEval;

	public Transition(EvaluationE oldEval, EvaluationE newEval, Action a) {
		action = a;
		from = getState(oldEval.getState(), oldEval.getPollDeadline());
		to = getNewState(oldEval, newEval, a);
		this.oldEval = oldEval;
		this.newEval = newEval;
	}

	/**
	 * @param oldEval
	 * @param newEval
	 * @param a
	 * @return
	 */
	private LifecycleState getNewState(EvaluationE oldEval,
			EvaluationE newEval, Action a) {
		// case of deletion
		if (a.equals(Action.DELETE_EVAL))
			return LifecycleState.DELETED;
		EvaluationState estate = null;
		Date pDeadline = null;
		// case of no eval change
		if (!a.equals(Action.CHANGE_EVAL)) {
			estate = oldEval.getState();
			pDeadline = oldEval.getPollDeadline();
		}
		// case of eval change
		if (a.equals(Action.CHANGE_EVAL)) {
			// case of state change
			if (newEval.getState() != null)
				estate = newEval.getState();
			// case of no state change
			else
				estate = oldEval.getState();
			// case of deadline change
			if (newEval.getPollDeadline() != null)
				pDeadline = newEval.getPollDeadline();
			// case of no deadline change
			else
				pDeadline = oldEval.getPollDeadline();
		}
		return getState(estate, pDeadline);
	}

	/**
	 * @param eval
	 * @return
	 */
	private LifecycleState getState(EvaluationState evaluationState,
			Date deadline) {
		switch (evaluationState) {
		case CREATED:
			if (deadline == null)
				return LifecycleState.CREATED_NO_DEADLINE;
			else if (DateUtil.futureDate(deadline))
				return LifecycleState.CREATED_FURURE_DEADLINE;
			else
				return LifecycleState.CREATED_NO_DEADLINE;
		case RUNNING:
			if (DateUtil.futureDate(deadline))
				return LifecycleState.RUNNING_FUTURE_DEADLINE;
			else
				return LifecycleState.RUNNING_PAST_DEADLINE;
		case ABORTED:
			if (DateUtil.futureDate(deadline))
				return LifecycleState.ABORTED_FUTURE_DEADLINE;
			else
				return LifecycleState.ABORTED_PAST_DEADLINE;
		case FINISHED:
			return LifecycleState.FINISHED;
		}
		return null;
	}
}
