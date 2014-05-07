package edu.kit.cockpit.valuationserver.valuation.aotearoadapter.model;

import java.util.HashMap;


/*CUSTOM DATA TYPE*/
public class PreferenceRankingResultsDataType {


	//attributes
	public final HashMap<String, Double> attsRanking;
	public final HashMap<String, Double> configurationRanking;
	
    //constructor
    public PreferenceRankingResultsDataType(HashMap<String, Double> attsRanking, HashMap<String, Double> configurationRanking){
    	this.attsRanking = attsRanking;
    	this.configurationRanking = configurationRanking;
    }
	
	
	
}
