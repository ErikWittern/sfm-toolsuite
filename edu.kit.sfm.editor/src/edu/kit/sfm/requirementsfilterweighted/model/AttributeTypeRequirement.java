package edu.kit.sfm.requirementsfilterweighted.model;

/**
 * Holds a requirement for an attribute type.
 * @author erikwittern
 */
public class AttributeTypeRequirement {

	String attName;
	Comparators comparator;
	double value;
	double weight;
	
	public AttributeTypeRequirement(String attName, Comparators comparator, double value, double weight){
		this.attName = attName;
		this.comparator = comparator;
		this.value = value;
		this.weight = weight;
	}
	
	/**
	 * Getters and setters
	 */
	public String getAttName() {
		return attName;
	}
	
	public void setAttName(String attName) {
		this.attName = attName;
	}
	
	public Comparators getComparator() {
		return comparator;
	}
	
	public void setComparator(Comparators comparator) {
		this.comparator = comparator;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getSummary(){
		return "AttributeType " + this.attName + " is required to be " + this.comparator + " " + this.value + ", with weight " + this.weight;
	}
}
