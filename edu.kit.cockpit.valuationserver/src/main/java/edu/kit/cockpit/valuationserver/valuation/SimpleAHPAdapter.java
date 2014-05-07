package edu.kit.cockpit.valuationserver.valuation;

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

public class SimpleAHPAdapter {
	
	
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
		float[][] matrix = new float[attrListSize][attrListSize];
		matrix = createMatrixFromVotes(attrList, prefList);
		Vector<Float> attRanking = calcEigenvector(matrix);
		
//		for(int i = 0; i < attRanking.size() ; i++){
//			System.out.println(" " + attrList.get(i).getName() + ": " + attRanking.get(i).toString());
//		}
		
		// 2. Calculate ranking of configurations per attribute type:
		Map<String, Vector<Float>> attTypeRankingMap = new LinkedHashMap<String, Vector<Float>>();
		int x = 0;
		for(AttributeType att : attrList){
			// 2.1 Create Matrix for each configuration regarding attribute type:
			float[][] attMatrix = new float[confList.size()][confList.size()];
			
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
			Vector<Float> eigenvector = calcEigenvector(attMatrix);
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
		// System.out.println("=====Overall result=====");
		for(int conf = 0 ; conf < confList.size() ; conf++){
			for(int att = 0 ; att < attRanking.size() ; att++){
				result[conf] += attRanking.get(att) * attTypeRankingMap.get(attrList.get(att).getName()).get(conf);
			}
			//System.out.println(" Configuration " + conf + ": " + result[conf]);
		}	
		return result;
	}

	
	/**
	 * createMatrixFromVotes
	 * @param attrList
	 * @param prefList
	 * @return matrix in which preferences are for the attribute types are contained:
	 */
	public static float[][] createMatrixFromVotes(List<AttributeType> attrList,
			List<PreferenceE> prefList) {

		int attrListSize = attrList.size();
		Float[][] matrix = new Float[attrListSize][attrListSize];

		
		// OrderingMap assigns each attribute type to an integer:
		HashMap<String, Integer> orderingMap = new HashMap<String, Integer>();
		for (int x = 0; x < attrListSize; x++) {
			orderingMap.put(attrList.get(x).getName(), x);
		}

		// Go through each preference and fill up matrix:
		for (PreferenceE pref : prefList) {
			float value = pref.getPreferenceAoverB().floatValue();
			if (value < 0.0) {
				value = 1f / (-1f * value);
			}
			if (value == 0.0) {
				value = 1f;
			}
			matrix[orderingMap.get(pref.getAttributeTypeA())][orderingMap
					.get(pref.getAttributeTypeB())] = (float) value;
		}

		for (int x = 0; x < attrListSize; x++) {
			matrix[x][x] = 1f;
		}

		for (int x = 0; x < attrListSize; x++) {
			for (int y = 0; y < attrListSize; y++) {
				if (matrix[x][y] == null) {
					if(matrix[y][x] != null){
						matrix[x][y] = 1f / matrix[y][x];
					} else {
//						System.out.println("	DEBUG: matrix[y][x] was null...");
						matrix[x][y] = 1f; //TODO: FIX!!!
					}
				}
			}
		}
		
		float[][] matrix2 = new float[attrListSize][attrListSize];

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
	private static Vector<Float> calcEigenvector(float[][] matrix){
		
		// Compute column total
		float[] columnTotal = new float[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				columnTotal[j] += matrix[i][j];
			}
		}
		
		// Divide each cell by its column total
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				float value = matrix[i][j] / columnTotal[j];
				matrix[i][j] = (float) value;
			}
		}
		
		// Compute each rows average
		float[] rowAverage = new float[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			int numColumns = 0;
			for(int j = 0; j < matrix[i].length; j++){
				rowAverage[i] += matrix[i][j];
				numColumns++;
			}
			float value = rowAverage[i] / numColumns;
			rowAverage[i] = value;
		}
		
		// Print it:
		Vector<Float> result = new Vector<Float>();
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
	public static float[][] createMatrixForBoolean(List<String> values,
			int priority) {
		float[][] matrix = new float[values.size()][values.size()];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size(); j++) {
				if ( ( (values.get(i).equals("true") || values.get(i).equals("1")) && 
					   (values.get(j).equals("true") || values.get(j).equals("1")) )
						|| 
					 ( (values.get(i).equals("false") || values.get(i).equals("0")) && 
						(values.get(j).equals("false") || values.get(j).equals("0")) ) ) {
					matrix[i][j] = 1f;
				} else if ( (values.get(i).equals("true") || values.get(i).equals("1")) && 
						(values.get(j).equals("false") || values.get(j).equals("0") ) ) {
					matrix[i][j] = priority;
				} else if ( (values.get(i).equals("false") || values.get(i).equals("0")) && 
						(values.get(j).equals("true") || values.get(j).equals("1") ) ) {
					matrix[i][j] = 1f / priority;
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
	public static float[][] createMatrixForNumeric(List<String> values,
			String scaleOrder) {
		float[][] matrix = new float[values.size()][values.size()];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size(); j++) {
				if(scaleOrder.equals("LowerIsBetter")){
					if( Float.valueOf(values.get(i)) != 0.0 && Float.valueOf(values.get(j)) != 0.0 ){
						matrix[i][j] = (1f / Float.valueOf(values.get(i))) / (1f / Float.valueOf(values.get(j)));
					} else if (Float.valueOf(values.get(i)) == 0.0 && Float.valueOf(values.get(j)) != 0.0){
						matrix[i][j] = 1000f;
					} else if (Float.valueOf(values.get(i)) != 0.0 && Float.valueOf(values.get(j)) == 0.0){
						matrix[i][j] = 0.0001f;
					}
					
					
				} else {
					if( Double.valueOf(values.get(j)) != 0.0){
						matrix[i][j] = Float.valueOf(values.get(i)) / Float.valueOf(values.get(j));
					} else {
						matrix[i][j] = 1000f; // TODO: This is just an approximation!
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
	public static void printMatrix(float[][] matrix){
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