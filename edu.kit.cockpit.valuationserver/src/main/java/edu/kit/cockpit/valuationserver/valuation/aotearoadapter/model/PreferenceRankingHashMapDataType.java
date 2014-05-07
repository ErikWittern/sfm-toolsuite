package edu.kit.cockpit.valuationserver.valuation.aotearoadapter.model;

public class PreferenceRankingHashMapDataType {

	 
        public final String STR;
        public final double DOUBLE;
 
        public PreferenceRankingHashMapDataType(String s, double i) {
            STR = s;
            DOUBLE = i;
        }
 
        @Override
        public String toString() {
            return "(" + STR + ", " + DOUBLE + ")";
        }
        
}

