/*
 * Project: 
 * 	Cockpit Valuation Server
 *
 * Author:  
 *	Sven Frauen
 *
 * Last Change: 
 *	by:   $$Author: $$
 *	date: $$Date:   $$
 *
 * Copyright (c): 
 * 	2011 Karlsruhe Institute of Technology
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

package edu.kit.cockpit.valuationserver.valuation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.eorg.aotearoa.lib.jama.Matrix;
import de.eorg.aotearoa.lib.logic.ahp.AnalyticHierarchyProcess;
import de.eorg.aotearoa.lib.model.ahp.configuration.Alternative;
import de.eorg.aotearoa.lib.model.ahp.configuration.Criterion;
import de.eorg.aotearoa.lib.model.ahp.configuration.CriterionType;
import de.eorg.aotearoa.lib.model.ahp.configuration.Decision;
import de.eorg.aotearoa.lib.model.ahp.configuration.Goal;
import de.eorg.aotearoa.lib.model.ahp.values.Evaluation;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeType;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Configuration;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.VoteE;


public class AotearoaAdapter {

	Log log = LogFactory.getLog(this.getClass());

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static float[] computeConfigurationPreferenceVector(Service service,
			VoteE vote) {

		Decision decision = new Decision("Cockpit Decision");
		Goal goal = new Goal("Goal");
		decision.addGoal(goal);

		List<Configuration> confList = service.getConfigurations().getConfigurations();
		List<AttributeType> attrList = service.getAttributeTypes().getAttributeTypes();

		List<PreferenceE> prefList = vote.getPreferences();

		// HashMap with id or name as key and float as value would be possible
		// too
		float[] result = new float[confList.size()];

		System.out.println("Configurations as Alternatives:");
		for (Configuration conf : confList) {
			Alternative alt = new Alternative(conf.getName());
			alt.setDescription(conf.getDescription());
			decision.addAlternative(alt);
			System.out.println("Alternative: " + alt.getName());
		}

		System.out.println();
		System.out.println("AttributeTypes as Criteria:");
		for (AttributeType attr : attrList) {
			Criterion crit = new Criterion(attr.getName());
			crit.setDescription(attr.getDescription());
			crit.setType(CriterionType.QUALITATIVE);
			goal.addChild(crit);
			System.out.println("Criterion: " + crit.toString());
		}

		System.out.println();
		System.out.println("Preferences:");
		for (PreferenceE pref : prefList) {
			System.out.println("Preference: Attriut1: "
					+ pref.getAttributeTypeA() + "/ Attribute2: "
					+ pref.getAttributeTypeB() + "/ value PreferenceAoverB: "
					+ pref.getPreferenceAoverB());
		}
		System.out.println();

		AnalyticHierarchyProcess ahp = new AnalyticHierarchyProcess(decision);
		Evaluation ev = new Evaluation();

		ahp.setChildrenCriteriaWeights(goal, createMatrixFromVotes(attrList, prefList),
				15);

		// ist die Reihenfolge der Attribute unter den Praeferenzen immer gleich
		// der AttributeType Liste?
		// ansonsten muesste mit Namensvergleich oder etwas anderem gearbeitet
		// werden
		for (int x = 0; x < attrList.size(); x++) {
			List<String> values = new ArrayList<String>();
			for (Configuration conf : confList) {
				values.add(conf.getAttributes().get(x).getInstantiationValue());
				
			}
			if (attrList.get(x).getDomain().getLiteral().equals("Boolean")) {
				ev.getEvaluations().add(
						createMatrixFromBoolean(values, attrList.get(x)
								.getCustomAttributeTypePriority()));
			} else {
				ev.getEvaluations().add(
						createMatrixFromConfiguration(values, attrList.get(x)
								.getScaleOrder().getLiteral()));
			}
		}
		
		try {
//			Map<Alternative, Double> results = ahp.evaluate(ev);
			
//			System.out.println("Resultmap: " + results.toString());
			System.out.println("Order of Configurations:");
//			int i = 0;
//			for (Alternative alt : decision.getAlternatives()) {
//				System.out.println("Name: " + alt.getName());
//				System.out.println("Result from Map: " + results.get(alt));
//				result[i] = results.get(alt).floatValue();
//				i++;
//			}
			
			
			
//			int i = 0;
//			for (Double resultValue : results.values()) {
//				result[i] = resultValue.floatValue();
//				System.out.println("result " + i + ": " + result[i]);
//				i++;
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public static Matrix createMatrixFromBoolean(List<String> values,
			int priority) {
		double[][] matrix = new double[values.size()][values.size()];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size(); j++) {
				if ( ( (values.get(i).equals("true") || values.get(i).equals("1")) && 
					   (values.get(j).equals("true") || values.get(j).equals("1")) )
						|| 
					 ( (values.get(i).equals("false") || values.get(i).equals("0")) && 
						(values.get(j).equals("false") || values.get(j).equals("0")) ) ) {
					matrix[i][j] = 1D;
				} else if ( (values.get(i).equals("true") || values.get(i).equals("1")) && 
						(values.get(j).equals("false") || values.get(j).equals("0") ) ) {
					matrix[i][j] = priority;
				} else if ( (values.get(i).equals("false") || values.get(i).equals("0")) && 
						(values.get(j).equals("true") || values.get(j).equals("1") ) ) {
					matrix[i][j] = 1D / priority;
				}
			}
		}

		return new Matrix(matrix);
	}

	public static Matrix createMatrixFromConfiguration(List<String> values,
			String scaleOrder) {
		double[][] matrix = new double[values.size()][values.size()];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size(); j++) {
				if(scaleOrder.equals("LowerIsBetter")){
					matrix[i][j] = (1D / Double.valueOf(values.get(i)))
						/ (1D / Double.valueOf(values.get(j)));
				} else {
					matrix[i][j] = Double.valueOf(values.get(i))
						/ Double.valueOf(values.get(j));
				
				}
				
				
//				if (scaleOrder.equals("HigherIsBetter")) {
//					matrix[i][j] = Double.valueOf(values.get(i))
//							/ Double.valueOf(values.get(j));
//				} else if (scaleOrder.equals("LowerIsBetter")) {
//					matrix[i][j] = (1D / Double.valueOf(values.get(i)))
//							/ (1D / Double.valueOf(values.get(j)));
//				} else {
//					return null;
//				}
				// System.out.print(matrix[i][j] + ", ");
			}
			// System.out.println();
		}
		return new Matrix(matrix);
	}

	public static Matrix createMatrixFromVotes(List<AttributeType> attrList,
			List<PreferenceE> prefList) {

		int attrListSize = attrList.size();
		Double[][] matrix = new Double[attrListSize][attrListSize];

		HashMap<String, Integer> orderingMap = new HashMap<String, Integer>();
		for (int x = 0; x < attrListSize; x++) {
			orderingMap.put(attrList.get(x).getName(), x);
			// System.out.println(attrList.get(x).getName() +", x: " + x);
		}

		for (PreferenceE pref : prefList) {
			double value = pref.getPreferenceAoverB().doubleValue();
			if (value < 0) {
				value = 1D / (-1D * value);
			}
			if (value == 0) {
				value = 1D;
			}
			matrix[orderingMap.get(pref.getAttributeTypeA())][orderingMap
					.get(pref.getAttributeTypeB())] = value;
		}

		for (int x = 0; x < attrListSize; x++) {
			matrix[x][x] = 1D;
		}

		for (int x = 0; x < attrListSize; x++) {
			for (int y = 0; y < attrListSize; y++) {
				if (matrix[x][y] == null) {
					matrix[x][y] = 1D / matrix[y][x];
				}
			}
		}

		double[][] matrix2 = new double[attrListSize][attrListSize];

		for (int x = 0; x < attrListSize; x++) {
			for (int y = 0; y < attrListSize; y++) {
				matrix2[x][y] = matrix[x][y];
			}
		}

		Matrix m = new Matrix(matrix2);

		return m;
	}

}
