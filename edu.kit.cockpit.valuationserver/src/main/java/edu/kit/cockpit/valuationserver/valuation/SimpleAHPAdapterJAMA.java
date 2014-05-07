package edu.kit.cockpit.valuationserver.valuation;

import jama.Matrix;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeType;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Configuration;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.VoteE;

public class SimpleAHPAdapterJAMA {
	
	
	/**
	 * computeConfigurationPreferenceVector
	 * @param service
	 * @param vote
	 * @return the preference vector for the given service's configurations and given vote.
	 */
	public static float[] computeConfigurationPreferenceVector(Service service,
			VoteE vote) {

		List<Configuration> confList = service.getConfigurations().getConfigurations();
		List<AttributeType> attrList = service.getAttributeTypes().getAttributeTypes();
		List<PreferenceE> prefList = vote.getPreferences();

//		System.out.println("=====Received vote=====");
//		for(PreferenceE pref : prefList){
//			System.out.println(" " + pref.getAttributeTypeA() + " vs. " + pref.getAttributeTypeB() + " : " + pref.getPreferenceAoverB());
//		}
		
		float[] result = new float[confList.size()];
		
		// 1. Calculate ranking of attribute types:
//		System.out.println("=====Attribute Type ranking=====");
		int attrListSize = attrList.size();
		double[][] temp = new double[attrListSize][attrListSize];
		temp = createMatrixFromVotes(attrList, prefList);
		Matrix matrix = new Matrix(temp);
		//Matrix atRank = matrix.eig();
		
		Vector<Double> attRanking = calcEigenvector(temp);
		
//		for(int i = 0; i < attRanking.size() ; i++){
//			System.out.println(" " + attrList.get(i).getName() + ": " + attRanking.get(i).toString());
//		}
		
		// 2. Calculate ranking of configurations per attribute type:
		Map<String, Vector<Double>> attTypeRankingMap = new LinkedHashMap<String, Vector<Double>>();
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
			
			// 2.2. Calculate Eigenvector:
//			System.out.println("=====Ranking of configurations regarding " + att.getName() + "=====");
			Vector<Double> eigenvector = calcEigenvector(attMatrix);
//			for(int i = 0; i < confList.size() ; i++){
//				System.out.println(" " + confList.get(i).getName() + ": " + eigenvector.get(i).toString());
//			}
			
			
			attTypeRankingMap.put(att.getName(), eigenvector);
			
			x++;
		}
		
		//for (Map.Entry<String, Vector<Double>> entry : attTypeRankingMap.entrySet()) {
		//    System.out.println(" Attribute " + entry.getKey() + ": " + entry.getValue().toString());   
		//}
		
		// 3. Create weighted sum:
		System.out.println("=====Overall result=====");
		for(int conf = 0 ; conf < confList.size() ; conf++){
			for(int att = 0 ; att < attRanking.size() ; att++){
				result[conf] += attRanking.get(att) * attTypeRankingMap.get(attrList.get(att).getName()).get(conf);
			}
			System.out.println(" Configuration " + conf + ": " + result[conf]);
		}	
		return result;
	}

	
	/**
	 * createMatrixFromVotes
	 * @param attrList
	 * @param prefList
	 * @return matrix in which preferences are for the attribute types are contained:
	 */
	public static double[][] createMatrixFromVotes(List<AttributeType> attrList,
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
				value = 1D / (-1D * value);
			}
			if (value == 0.0) {
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
					if(matrix[y][x] != null){
						matrix[x][y] = 1D / matrix[y][x];
					} else {
//						System.out.println("	DEBUG: matrix[y][x] was null...");
						matrix[x][y] = 1D; //TODO: FIX!!!
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
	 * calcEigenvector
	 * @param m
	 * @return Eigenvector for given Matrix - method is straight forward
	 * 			from paper "The Analytic Hierarchy Process - Test run".
	 */
	private static Vector<Double> calcEigenvector(double[][] matrix){
		
		// Compute column total
		double[] columnTotal = new double[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				columnTotal[j] += matrix[i][j];
			}
		}
		
		// Divide each cell by its column total
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				double value = matrix[i][j] / columnTotal[j];
				matrix[i][j] = value;
			}
		}
		
		// Compute each rows average
		double[] rowAverage = new double[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			int numColumns = 0;
			for(int j = 0; j < matrix[i].length; j++){
				rowAverage[i] += matrix[i][j];
				numColumns++;
			}
			double value = rowAverage[i] / numColumns;
			rowAverage[i] = value;
		}
		
		// Print it:
		Vector<Double> result = new Vector<Double>();
		for(int i = 0; i < rowAverage.length ; i++){
			result.add(i, rowAverage[i]);
		}
		return result;
		
	}
		
	
	/**
	 * createMatrixForBoolean
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
		return matrix;
	}

	
	/**
	 * createMatrixForNumeric
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
						matrix[i][j] = (1D / Double.valueOf(values.get(i))) / (1D / Double.valueOf(values.get(j)));
					} else if (Double.valueOf(values.get(i)) == 0.0 && Double.valueOf(values.get(j)) != 0.0){
						matrix[i][j] = 1000D;
					} else if (Double.valueOf(values.get(i)) != 0.0 && Double.valueOf(values.get(j)) == 0.0){
						matrix[i][j] = 0.0001D;
					}
					
					
				} else {
					if( Double.valueOf(values.get(j)) != 0.0){
						matrix[i][j] = Double.valueOf(values.get(i)) / Double.valueOf(values.get(j));
					} else {
						matrix[i][j] = 1000D; // TODO: This is just an approximation!
					}
					
				}
			}
		}
		return matrix;
	}

	
	/**
	 * printMatrix
	 * @param matrix
	 * Prints the given matrix:
	 */
	public static void printMatrix(double[][] matrix){
		DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(" " + df.format(matrix[i][j]) );
			}
		}
		System.out.println();
	}

}