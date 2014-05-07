package edu.kit.cockpit.valuationserver.valuation.aotearoadapter.model;

import java.util.ArrayList;
import java.util.List;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeType;


/*DATA TYPE DESCRIPTION
 * 
 *   consists of two elements:
 *      - preferenceList, a list of ATTS (derived from service model)
 *      - preferenceMatrix, contains pairwise comparisons of ATTS
 *           
 *             			 ATTS1  ...  ATTSn
 *              ATTS1     1  
 *               ..			    ... 
 * 
 *              ATTSn                   1
 *              
 *              
 *              
 *              ATTS1,ATTS1 = 1
 *              ATTSa,ATTSb = value
 *              ATTSb,ATTSa = 1/value
 * 			
 * 
 * 
 * 
 * */


/*CUSTOM DATA TYPE*/
public class PreferenceRankingInputDataType {

	//attributes
	private List<AttributeType> preferenceList;
	private double[][] preferenceMatrix;

	//constructor
	public PreferenceRankingInputDataType(Integer numberOfPreferences){
		this.preferenceList = new ArrayList<AttributeType>();
		this.preferenceMatrix = new double[numberOfPreferences][numberOfPreferences];
		initializeMatrix();
	}

	public PreferenceRankingInputDataType(Integer numberOfPreferences, List<AttributeType> preferenceList){
		this.preferenceList = preferenceList;
		this.preferenceMatrix = new double[numberOfPreferences][numberOfPreferences];
		initializeMatrix();
	}


	//methods  get/set  - access attributes   
	public List<AttributeType> getPreferenceList() {
		return this.preferenceList;
	}

	public double[][] getPreferenceMatrix() {
		return this.preferenceMatrix;
	}

	public void setPreferenceMatrix(double[][] matrix) {
		this.preferenceMatrix = matrix;
	}

	public void setPreferenceList(List<AttributeType> inList){
		this.preferenceList = inList;
	}

	//add a value to preferenceMatrix
	public void addValueToPreferenceMatrix(Integer rowIndex, Integer columnIndex, Double value){
		this.preferenceMatrix[rowIndex][columnIndex] = value;

	}

	public void initializeMatrix(){

		for(Integer i=0;i <this.preferenceMatrix.length;i++){

			for(Integer j=0;j <this.preferenceMatrix[i].length;j++){

				this.preferenceMatrix[i][j] = 1;
			}

		}
	}

}
