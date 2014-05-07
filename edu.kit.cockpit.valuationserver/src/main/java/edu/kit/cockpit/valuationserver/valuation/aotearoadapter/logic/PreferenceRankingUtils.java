package edu.kit.cockpit.valuationserver.valuation.aotearoadapter.logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import edu.kit.cockpit.sfmdesigner.preferenceranking.model.PreferenceRankingHashMapDataType;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeType;




public class PreferenceRankingUtils {

	
	
/*print*/	
	public static void printMatrix (double[][] matrix){
	
		//headline - description - elements
		System.out.print("    ");
		for(Integer i=0;i <matrix.length;i++){
			 System.out.print(i+ ":   " );
		}
		
		System.out.println("");
		for(Integer i=0;i <matrix.length;i++){
			//description element
			 System.out.print(i+ ": " );
			 
			//values 
			for(Integer j=0;j <matrix[i].length;j++){
				  System.out.print( matrix[i][j] + ", " );
			}
			 System.out.println("");
		}
		
	}
	
	public static void printPreferenceList(List<String> list){
		
		for(Integer j=0;j < list.size();j++){
			  System.out.println(j+": "+ list.get(j));
		}
		
		
	}
	
	
	public static void savePreferenceMatrixToFile(double[][] matrix, String fileName){
		
	    try {
	    	
	    	FileOutputStream fos = new FileOutputStream(fileName);
	    	ObjectOutputStream out = new ObjectOutputStream(fos);
	      
	    	out.writeObject(matrix);
	    	out.flush();
	    	out.close();
	    	
	      } catch( IOException ex ) {
	        System.out.println( ex );
	      }
	
}
	public static double[][] loadPreferenceMatrix(String fileName) throws IOException{
		double[][] matrix = null;
		
		try {
	        FileInputStream fis = new FileInputStream(fileName);
	        ObjectInputStream in = new ObjectInputStream(fis);
	        matrix = (double[][])in.readObject();
	        in.close();
	      }
	      catch (Exception e) {
	          System.out.println(e);
	      }
		
		if(matrix==null){
			throw new IOException("Empty preference matrix.");
		}
		
		return matrix;
		
	}
	
	
	static double[][] initializeMatrix(double[][] matrix){
		
		for(Integer i=0;i <matrix.length;i++){
			for(Integer j=0;j <matrix[i].length;j++){	
				matrix[i][j] = 1D;
			}
		}
		
		return matrix;
		
	}
	
	
/*extract - convert values*/
	public static List<String> extractAttributeTypeNames(List<AttributeType> list){
		//variable 
		List<String> returnList = new ArrayList<String>();
		
		for(AttributeType a : list){
			returnList.add(a.getName());
		}
		
		return returnList;
		
	}
	
/*mapping*/
	
	public static double convertComparisonValue(double val){
		
		/*hashmap desclaration*/
		HashMap<Double, Double> comparison = new HashMap<Double, Double>();
		comparison.put(1D / 9D,-8D);
		comparison.put(1D / 5D,-4D);
		comparison.put(1D / 3D,-2D);
		comparison.put(1D, 0D);
		comparison.put(3D,2D);
		comparison.put(5D,4D);
		comparison.put(9D, 8D);
		
		/**/
		if (comparison.containsKey(val)) {
			val = comparison.get(val);
			}
		
		return val;
		
	}
	
	
	public static List<PreferenceRankingHashMapDataType> getSortedList(HashMap<String, Double> map){
		
		//variables initialization
		List<PreferenceRankingHashMapDataType> list = new ArrayList<PreferenceRankingHashMapDataType>(map.size());
			
		//transformation  hashMap to list
        for (String key : map.keySet()) {
            list.add(new PreferenceRankingHashMapDataType(key, map.get(key)));
        }
 
        //sort
        Collections.sort(list, new Comparator<PreferenceRankingHashMapDataType>() {
 
            @Override
            public int compare(PreferenceRankingHashMapDataType o1, PreferenceRankingHashMapDataType o2) {
                return o1.DOUBLE < o2.DOUBLE ? 1 : o1.DOUBLE > o2.DOUBLE ? -1 : 0;
            }
        });
        
    	
		return list;
		
}

	
	// 0.3333  -> 33,33%
	public static String convertDoubleToPercentage(double val){	
		DecimalFormat f = new DecimalFormat("##.## %");
		return f.format(val);

	}
	
	
}
