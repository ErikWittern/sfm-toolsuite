package edu.kit.sfm.requirementsfilterweighted.model;

import edu.kit.sfm.servicefeaturemodel.FeatureTypes;

/**
 * Holds a requirements for a feature
 * @author erikwittern
 */
public class FeatureRequirement {

	String featureId;
	String featureName;
	double weight;
	FeatureTypes featureType;

	public FeatureRequirement(String featureId, String featureName, double weight, FeatureTypes featureType){
		this.featureId = featureId;
		this.featureName = featureName;
		this.weight = weight;
		this.featureType = featureType;
	}
	
	/**
	 * Getters and setters
	 */
	public String getFeatureId() {
		return featureId;
	}
	
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}
	
	public String getFeatureName() {
		return featureName;
	}
	
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public FeatureTypes getFeatureType() {
		return featureType;
	}
	
	public void setFeatureType(FeatureTypes featureType) {
		this.featureType = featureType;
	}
	
	public String getSummary(){
		return "Feature " + this.featureName + " (ID: " + this.featureId + ", type: " + this.featureType + ") is required with weight " + this.weight;
	}
	
}
