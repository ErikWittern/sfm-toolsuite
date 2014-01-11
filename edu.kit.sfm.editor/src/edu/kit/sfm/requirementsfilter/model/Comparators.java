package edu.kit.sfm.requirementsfilter.model;

public enum Comparators {
	
	SMALLER(0),SMALLER_EQUAL(1),EQUAL(2),LARGER_EQUAL(3),LARGER(4);
	
	private int statusCode;
	 
	private Comparators(int i) {
		statusCode = i;
	}
 
	public int getStatusCode() {
		return statusCode;
	}
}
