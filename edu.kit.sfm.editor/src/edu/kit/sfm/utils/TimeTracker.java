package edu.kit.sfm.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class TimeTracker {

	Map<String, Long> eventMap = new LinkedHashMap<String, Long>();
	
	public void start(){
		eventMap.put("Start", System.currentTimeMillis());
	}
	
	public void stop(){
		eventMap.put("Stop", System.currentTimeMillis());
	}
	
	public void markTime(String eventId){
		eventMap.put(eventId, System.currentTimeMillis());
	}
	
	public String toString(){
		String result = "";
		for (Map.Entry<String, Long> cursor : eventMap.entrySet()) {
			result += "\"" + cursor.getKey() + "\" finished at: " + cursor.getValue() + " milliseconds\n";
		}
		return result;
	}
	
	public String toStringInterpreted(){
		String result = "";
		// Get first row for names:
		for(Map.Entry<String, Long> cursor : eventMap.entrySet()){
			result += cursor.getKey() + ",";
		}
		result = result.substring(0, result.length()-1);
		result += ";\n";
		
		// Get second row for entries:
		Long lastValue = eventMap.get("Start");
		Long overall = 0l;
		for (Map.Entry<String, Long> cursor : eventMap.entrySet()) {
			result += (cursor.getValue() - lastValue) + ",";
			overall += (cursor.getValue() - lastValue);
			lastValue = cursor.getValue();
		}
		result = result.substring(0, result.length()-1);
		result += "\n";
		return result;
	}
	
	public String toStringDataRow(){
		String result = "";
		Long lastValue = eventMap.get("Start");
		Long overall = 0l;
		for (Map.Entry<String, Long> cursor : eventMap.entrySet()) {
			result += (cursor.getValue() - lastValue) + ",";
			overall += (cursor.getValue() - lastValue);
			lastValue = cursor.getValue();
		}
		result = result.substring(0, result.length()-1);
		return result;
	}
	
//	public boolean saveResultsToFile(String fileName){
//		String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
//		String completePath = path+"/preferenceMatrix/"+fileName;
//		try {
//			FileOutputStream fos = new FileOutputStream(completePath);
//			ObjectOutputStream out = new ObjectOutputStream(fos);
//			out.writeObject(toStringInterpreted());
//			out.flush();
//			out.close();
//			return true;
//		} catch( IOException ex ) {
//			System.out.println( ex );
//		}
//		return false;
//	}
}