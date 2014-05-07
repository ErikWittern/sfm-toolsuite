package edu.kit.cockpit.valuationserver.valuation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.eorg.aotearoa.lib.jama.Matrix;
import de.eorg.aotearoa.lib.logic.ahp.AnalyticHierarchyProcess;
import de.eorg.aotearoa.lib.model.ahp.configuration.Alternative;
import de.eorg.aotearoa.lib.model.ahp.configuration.Criterion;
import de.eorg.aotearoa.lib.model.ahp.configuration.Decision;
import de.eorg.aotearoa.lib.model.ahp.configuration.Goal;
import de.eorg.aotearoa.lib.model.ahp.configuration.GoalType;
import de.eorg.aotearoa.lib.model.ahp.values.Evaluation;
import de.eorg.aotearoa.lib.model.ahp.values.EvaluationResult;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeType;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Configuration;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.VoteE;

public class AotearoaAdapterNew {

	static Log log = LogFactory.getLog(AotearoaAdapterNew.class);
	
	
	/**
	 * Returns the ranking for the configurations contained in the provided service
	 * and the preferences stated in the provided vote.
	 * 
	 * @param service
	 * @param vote
	 */
	public static String getConfigurationRanking(Service service, VoteE vote){
		
		long startDate = System.currentTimeMillis();
				
		List<AttributeType> attrList = service.getAttributeTypes().getAttributeTypes();
		List<PreferenceE> prefList = vote.getPreferences();
		List<Configuration> confList = service.getConfigurations().getConfigurations();
		
		Decision<Alternative> decision = new Decision<Alternative>();
		decision.setName("Cloud Computing Provider Selection");
		
		Goal goal = new Goal("Generic goal");
		goal.setGoalType(GoalType.POSITIVE);
		
		// Create criteria:
		for(AttributeType att : attrList){
			Criterion crit = new Criterion(att.getName());
			goal.addChild(crit);
//			System.out.println("Added criteria: " + crit.getName());
		}
		decision.addGoal(goal);		
		
		// Create alternatives:
		for(Configuration conf : confList){
			Alternative alt = new Alternative(conf.getName());
			decision.addAlternative(alt);
//			System.out.println("Added alternative: " + alt.getName());
		}
		
		// Create alternative ranking:
		List<Evaluation> evals = new ArrayList<Evaluation>();
		Evaluation ev = new Evaluation();
		int x = 0;
		for(AttributeType att : attrList){
			// 2.1 Create Matrix for each configuration regarding attribute type:
			double[][] attMatrix = new double[confList.size()][confList.size()];
			List<String> values = new ArrayList<String>();
			for (Configuration conf : confList) {
				values.add(conf.getAttributes().get(x).getInstantiationValue());
			}
			
			if (att.getDomain().getLiteral().equals("Boolean")) {
				attMatrix = createMatrixForBoolean(values, att.getCustomAttributeTypePriority());
			} else {
				attMatrix = createMatrixForNumeric(values, att.getScaleOrder().getLiteral());
			}
//			printMatrix(attMatrix);
			
			Matrix crit = new Matrix(attMatrix);
			ev.getEvaluations().add(crit);
			x++;
		}
		evals.add(ev);
		
		AnalyticHierarchyProcess ahp = new AnalyticHierarchyProcess(decision);
		
		// Define ranking of criteria:
		int attrListSize = attrList.size();
		double[][] matrix = new double[attrListSize][attrListSize];
		matrix = createMatrixFromVotes(attrList, prefList);
		Matrix critMatix = new Matrix(matrix);
		ahp.setChildrenCriteriaWeights(goal, critMatix, 5); // TODO: Adjust, if too slow!
		
		long transferDate = System.currentTimeMillis();
		
		try {
						
			@SuppressWarnings("unused")
			EvaluationResult results = ahp.evaluateFull(evals, 5, false);
					
		} catch (Exception e) {
			e.printStackTrace();
		}

		long endDate = System.currentTimeMillis();

		return (transferDate - startDate) + "," + (endDate - transferDate) + "\n";
	}
	
	
	
	private static void printMatrix(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++){
			String line = "";
			for(int j = 0; j < matrix[i].length; j++){
				line += matrix[i][j] + "   ";
			}
			System.out.println(line);
		}
	}



	/**
	 * Creates a matrix that compares each attribute type with each other
	 * based on the preferences stated in the provided list.
	 * 
	 * @param attrList
	 * @param prefList
	 * @return matrix in which preferences are for the attribute types are contained:
	 */
	public static double[][] createMatrixFromVotes(
			List<AttributeType> attrList,
			List<PreferenceE> prefList) {

		int attrListSize = attrList.size();
		Double[][] matrix = new Double[attrListSize][attrListSize];

		
		// OrderingMap assigns each attribute type to an integer:
		HashMap<String, Integer> orderingMap = new HashMap<String, Integer>();
		for (int x = 0; x < attrListSize; x++) {
			orderingMap.put(attrList.get(x).getName(), x);
		}

		// Go through each preference and fill up matrix:
		for (PreferenceE pref : prefList) {
			double value = pref.getPreferenceAoverB().doubleValue();
			if (value < 0.0) {
				value = 1d / (-1d * value);
			}
			if (value == 0.0) {
				value = 1d;
			}
			matrix[orderingMap.get(pref.getAttributeTypeA())][orderingMap
					.get(pref.getAttributeTypeB())] = (double) value;
		}

		for (int x = 0; x < attrListSize; x++) {
			matrix[x][x] = 1d;
		}

		for (int x = 0; x < attrListSize; x++) {
			for (int y = 0; y < attrListSize; y++) {
				if (matrix[x][y] == null) {
					if(matrix[y][x] != null){
						matrix[x][y] = 1d / matrix[y][x];
					} else {
//						System.out.println("	DEBUG: matrix[y][x] was null...");
						matrix[x][y] = 1d; //TODO: FIX!!!
					}
				}
			}
		}
		
		double[][] matrix2 = new double[attrListSize][attrListSize];

		for (int x = 0; x < attrListSize; x++) {
			for (int y = 0; y < attrListSize; y++) {
				matrix2[x][y] = matrix[x][y];
			}
		}
//		printMatrix(matrix2);
		return matrix2;
	}
	
	
	/**
	 * createMatrixForBoolean
	 * 
	 * @param values
	 * @param priority
	 * @return matrix for given boolean values.
	 */
	public static double[][] createMatrixForBoolean(List<String> values,
			int priority) {
		double[][] matrix = new double[values.size()][values.size()];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size(); j++) {
				if ( ( (values.get(i).equals("true") || values.get(i).equals("1")) && 
					   (values.get(j).equals("true") || values.get(j).equals("1")) )
						|| 
					 ( (values.get(i).equals("false") || values.get(i).equals("0")) && 
						(values.get(j).equals("false") || values.get(j).equals("0")) ) ) {
					matrix[i][j] = 1d;
				} else if ( (values.get(i).equals("true") || values.get(i).equals("1")) && 
						(values.get(j).equals("false") || values.get(j).equals("0") ) ) {
					matrix[i][j] = priority;
				} else if ( (values.get(i).equals("false") || values.get(i).equals("0")) && 
						(values.get(j).equals("true") || values.get(j).equals("1") ) ) {
					matrix[i][j] = 1d / priority;
				}
			}
		}
		return matrix;
	}

	
	/**
	 * createMatrixForNumeric
	 * 
	 * @param values
	 * @param scaleOrder
	 * @return double[][] which is the matrix for the given attribute type
	 */
	public static double[][] createMatrixForNumeric(List<String> values,
			String scaleOrder) {
		double[][] matrix = new double[values.size()][values.size()];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size(); j++) {
				if(scaleOrder.equals("LowerIsBetter")){
					if( Double.valueOf(values.get(i)) != 0.0 && Double.valueOf(values.get(j)) != 0.0 ){
						matrix[i][j] = (1d / Double.valueOf(values.get(i))) / (1d / Double.valueOf(values.get(j)));
					} else if (Double.valueOf(values.get(i)) == 0.0 && Double.valueOf(values.get(j)) != 0.0){
						matrix[i][j] = 1000f;
					} else if (Double.valueOf(values.get(i)) != 0.0 && Double.valueOf(values.get(j)) == 0.0){
						matrix[i][j] = 0.0001d;
					}
					
					
				} else {
					if( Double.valueOf(values.get(j)) != 0.0){
						matrix[i][j] = Double.valueOf(values.get(i)) / Double.valueOf(values.get(j));
					} else {
						matrix[i][j] = 1000d; // TODO: This is just an approximation!
					}
					
				}
			}
		}
		return matrix;
	}
}
