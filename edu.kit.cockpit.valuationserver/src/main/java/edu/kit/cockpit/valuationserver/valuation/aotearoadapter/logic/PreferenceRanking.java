package edu.kit.cockpit.valuationserver.valuation.aotearoadapter.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.eorg.aotearoa.lib.jama.Matrix;
import de.eorg.aotearoa.lib.logic.ahp.AnalyticHierarchyProcess;
import de.eorg.aotearoa.lib.model.ahp.configuration.Alternative;
import de.eorg.aotearoa.lib.model.ahp.configuration.Decision;
import de.eorg.aotearoa.lib.model.ahp.configuration.Goal;
import de.eorg.aotearoa.lib.model.ahp.configuration.GoalType;
import de.eorg.aotearoa.lib.model.ahp.values.Evaluation;
import de.eorg.aotearoa.lib.model.ahp.values.EvaluationResult;
import de.eorg.aotearoa.lib.model.ahp.values.GoalImportance;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeType;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Configuration;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ScaleOrders;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.valuation.aotearoadapter.model.PreferenceRankingInputDataType;
import edu.kit.cockpit.valuationserver.valuation.aotearoadapter.model.PreferenceRankingResultsDataType;

public class PreferenceRanking {
	public static 	PreferenceRankingInputDataType preferenceRankingData;



	private static double[][] getAlternativeMatrixForAttributeType(Service serviceModel, Integer attributeTypeID){
		
		/*variables declaration*/
		List<Configuration> configurationList;
		Configuration configurationOne, configrationTwo;
		double configurationOneValue, configurationTwoValue;
		double matrixElementValue;
		double maxValue;
		double[][] matrix;
		Integer numberOfConfigurations;


		/*initialize variables*/
		configurationList = serviceModel.getConfigurations().getConfigurations();
		numberOfConfigurations = configurationList.size();
		configurationOne = null;
		configrationTwo = null;
		configurationOneValue = 1D;
		configurationTwoValue = 1D;
		matrixElementValue = 1D;
		matrix = new double[numberOfConfigurations][numberOfConfigurations];
		PreferenceRankingUtils.initializeMatrix(matrix);
		maxValue = 1D;

		/*generate matrix*/	

		for(int i=0; i < numberOfConfigurations;i++){

			configurationOne = configurationList.get(i);
			configurationOneValue = Double.parseDouble(configurationOne.getAttributes().get(attributeTypeID).getInstantiationValue());		

			for(int j=i+1; j < numberOfConfigurations;j++){

				configrationTwo = configurationList.get(j);
				configurationTwoValue = Double.parseDouble(configrationTwo.getAttributes().get(attributeTypeID).getInstantiationValue());	

				if(configurationOne.getAttributes().get(attributeTypeID).getAttributeType().getScaleOrder() == ScaleOrders.LOWER_IS_BETTER){
					matrixElementValue =  (configurationTwoValue / configurationOneValue);
//					System.out.println("For AttributeType "+configurationOne.getAttributes().get(attributeTypeID).getAttributeType().getName()+ ": Lower is better");
				} else{
					matrixElementValue =  (configurationOneValue / configurationTwoValue);
//					System.out.println("For AttributeType "+configurationOne.getAttributes().get(attributeTypeID).getAttributeType().getName()+ ": Higher is better");

				}

				//matrixElementValue =  (configurationOneValue / configurationTwoValue);
				matrix[i][j] = matrixElementValue;
				matrix[j][i] = 1D / matrixElementValue;

				if(matrixElementValue > maxValue){
					maxValue = matrixElementValue;
				}
			}
		}	

		/*normalize*/
		for(int i=0; i < numberOfConfigurations;i++){
			for(int j=i+1; j < numberOfConfigurations;j++){
				matrix[i][j] = matrix[i][j] / maxValue;
				matrix[j][i] = matrix[j][i] / maxValue;
			}
		}

		/*results*/
		return matrix;

	}


	public static HashMap<String, Double> getATTSRanking(PreferenceRankingInputDataType preferenceRankingData){

		/*variables*/
		HashMap<String, Double> attsRankingMap = new HashMap<String, Double>();

		/*CREATE NEW EVALUATION - DATA INPUT*/
		Decision<Alternative> decision = new Decision<Alternative>("PreferenceRanking Decision");
		System.out.println("\n**Start new AHP evaluation.**");

		for(AttributeType a : preferenceRankingData.getPreferenceList()){
			Goal goal = new Goal(a.getName());	
			decision.addGoal(goal);
		}


		/*calculate results*/
		AnalyticHierarchyProcess ahp = new AnalyticHierarchyProcess(decision);	

		for(Integer i=0;i <preferenceRankingData.getPreferenceMatrix().length;i++){
			for(Integer j=i+1;j <preferenceRankingData.getPreferenceMatrix().length;j++){
				double value = preferenceRankingData.getPreferenceMatrix()[i][j];
//				System.out.println("goal "+i+" to "+j+" value "+value +"convert"+PreferenceRankingUtils.convertComparisonValue(value));
				decision.getImportanceGoals(GoalType.POSITIVE).add(new GoalImportance(i, j, PreferenceRankingUtils.convertComparisonValue(value), null));
			}
		}


		ahp.calculateWeights();
		for (Goal g : ahp.getDecision().getGoals()){
//			System.out.print("  "+g.getName()+" "+g.getGlobalWeight());
			attsRankingMap.put(g.getName(), g.getGlobalWeight());
		}


		System.out.println("**AHP evaluation completed.**");
		return attsRankingMap;

	}


	public static PreferenceRankingResultsDataType getAHPEvaluation(
			PreferenceRankingInputDataType preferenceRankingData, 
			Service serviceModel){

		/*variables*/
		HashMap<String, Double> attsRankingMap = new HashMap<String, Double>();
		HashMap<String, Double> configurationRanking = new HashMap<String, Double>();
		PreferenceRankingResultsDataType outputResult = null;


		/*CREATE NEW EVALUATION - DATA INPUT*/
		Decision<Alternative> decision = new Decision<Alternative>("PreferenceRanking Decision");
		System.out.println("\n**Start new AHP evaluation.**");

		/*Alternatives = Configurations*/

		List<Configuration> configurationList = serviceModel.getConfigurations().getConfigurations();
		for(Configuration selectedConf : configurationList){
			Alternative a = new Alternative();
			a.setName(selectedConf.getName());
			decision.addAlternative(a);
		}


		/*Goals = AttributeTypes */
		for(AttributeType a : preferenceRankingData.getPreferenceList()){
			Goal goal = new Goal(a.getName());	
			//String scaleOrder = a.getScaleOrder().toString();
			goal.setGoalType(GoalType.POSITIVE);
//			System.out.println("Goal: "+goal.getName()+"   "+goal.getGoalType());
			decision.addGoal(goal);
		}


		/*EVALUATION*/

		AnalyticHierarchyProcess ahp = new AnalyticHierarchyProcess(decision);	
		// (1) Weight of goals - calculate EV  -input preferenceMatrix
		System.out.println("Step (1) - Weight of goals");

		for(Integer i=0;i <preferenceRankingData.getPreferenceMatrix().length;i++){
			for(Integer j=i+1;j <preferenceRankingData.getPreferenceMatrix().length;j++){
				double value = preferenceRankingData.getPreferenceMatrix()[i][j];
				decision.getImportanceGoals(GoalType.POSITIVE).add(new GoalImportance(i, j, PreferenceRankingUtils.convertComparisonValue(value), null));
			}
		}

		// (2) Create Evaluation for each Goal, fill out matrices
		System.out.println("Step (2) - AlternatixMatrixPreferences for each goal");
		List<Evaluation> evals = new ArrayList<Evaluation>();

		for(Integer i=0;i <preferenceRankingData.getPreferenceMatrix().length;i++){
			Evaluation ev = new Evaluation();
			double[][] matrix = getAlternativeMatrixForAttributeType(serviceModel,i);	
//			PreferenceRankingUtils.printMatrix(matrix);
			Matrix evMatrix = new Matrix(matrix);
			ev.getEvaluations().add(evMatrix);
			evals.add(ev);
		}

		try {
			//get ahp result
			EvaluationResult results = ahp.evaluateFull(evals, false);

			//get ATTS Ranking
			for (Goal g : ahp.getDecision().getGoals()){
				attsRankingMap.put(g.getName(), g.getGlobalWeight());
			}

			//configuration results
			for (Alternative key : results.getResultPositiveGoalsMap().keySet()){
				configurationRanking.put(key.getName(), results.getResultPositiveGoalsMap().get(key));
			}
			outputResult = new PreferenceRankingResultsDataType(attsRankingMap,configurationRanking);
//			System.out.println("Positive: "+ results.getResultPositiveGoalsMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("**AHP evaluation completed.**");
		return outputResult;
	}


}
