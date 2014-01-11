package edu.kit.sfm.requirementsfilter.model;

import java.util.HashMap;
import java.util.Map;

import edu.kit.sfm.servicefeaturemodel.Configuration;

/**
 * Stores for one configuration how well requirements are fulfilled.
 * @author erikwittern
 *
 */
public class RequirementFulfillment {
	Configuration configuration;
	Map<FeatureRequirement, Double> featureReqGapMap;
	Map<AttributeTypeRequirement, Double> attReqGapMap;
	double degOfFulfillment;
	
	public RequirementFulfillment(Configuration configuration){
		this.configuration = configuration;
		this.featureReqGapMap = new HashMap<FeatureRequirement, Double>();
		this.attReqGapMap = new HashMap<AttributeTypeRequirement, Double>();
		this.degOfFulfillment = 0.0;
	}
	
	/**
	 * Getters and setters
	 */
	public Configuration getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	public Map<FeatureRequirement, Double> getFeatureReqGapList() {
		return featureReqGapMap;
	}
	
	public void setFeatureReqGapList(
			Map<FeatureRequirement, Double> featureReqGapList) {
		this.featureReqGapMap = featureReqGapList;
	}
	
	public void addFeatureReqGap(FeatureRequirement req, Double gap){
		this.featureReqGapMap.put(req, gap);
	}
	
	public Map<AttributeTypeRequirement, Double> getAttReqGapList() {
		return attReqGapMap;
	}
	
	public void setAttReqGapList(Map<AttributeTypeRequirement, Double> attReqGapList) {
		this.attReqGapMap = attReqGapList;
	}
	
	public void addAttReqGap(AttributeTypeRequirement req, Double gap){
		this.attReqGapMap.put(req, gap);
	}
	
	public double getDegOfFulfillment() {
		return degOfFulfillment;
	}
	
	public void setDegOfFulfillment(double degOfFulfillment) {
		this.degOfFulfillment = degOfFulfillment;
	}
	
	public double calcFulfillment(){
		double gap = 0.0;
		for(Double value : featureReqGapMap.values()){
			if(value.equals(1.0)){
				return 0.0;
			}
			gap += value;
		}
		for(Map.Entry<AttributeTypeRequirement, Double> entry : this.attReqGapMap.entrySet()){
			gap += entry.getValue() * entry.getKey().getWeight();
		}
		this.degOfFulfillment = 1.0 - ((1.0/(featureReqGapMap.size() + attReqGapMap.size())) * gap);
		return this.degOfFulfillment;
	}
	
	public String getSummary(){
		String result = "------------------------------------------------------\n";
		result  += "Configuration " + this.configuration.getName() + " fulfills feature requirements:\n";
		for(Map.Entry<FeatureRequirement, Double> entry : this.featureReqGapMap.entrySet()){
			result += "  \"" + entry.getKey().getFeatureName() + "\" has gap: " + entry.getValue() + "\n";
		}
		result += "Configuration " + this.configuration.getName() + " fulfills attribute type requirements:\n";
		for(Map.Entry<AttributeTypeRequirement, Double> entry : this.attReqGapMap.entrySet()){
			result += "  \"" + entry.getKey().getAttName() + "\" has gap: " + entry.getValue() + "\n";
		}
		result += "Overall fulfillment: " + this.degOfFulfillment + "\n";
		result += "------------------------------------------------------\n";
		return result;
	}
	
	public String getFeatureReqSummary(){
		String result = "";
		for(Map.Entry<FeatureRequirement, Double> entry : this.featureReqGapMap.entrySet()){
			result += "\"" + entry.getKey().getFeatureName() + "\": " + entry.getValue() + " | ";
		}
		return result;
	}
	
	public String getAttributeReqSummary(){
		String result = "";
		for(Map.Entry<AttributeTypeRequirement, Double> entry : this.attReqGapMap.entrySet()){
			result += "\"" + entry.getKey().getAttName() + "\": " + entry.getValue() + " | ";
		}
		return result;
	}
}
