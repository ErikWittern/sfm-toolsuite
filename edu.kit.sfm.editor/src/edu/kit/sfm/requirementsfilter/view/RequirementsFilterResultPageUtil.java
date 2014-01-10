package edu.kit.sfm.requirementsfilter.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import edu.kit.sfm.requirementsfilter.model.ReqFilterConfigurationDataType;
import edu.kit.sfm.requirementsfilter.model.ReqFilterDataType;
import edu.kit.sfm.servicefeaturemodel.Attribute;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;


public class RequirementsFilterResultPageUtil {	
	
	public static  void printReqFilterResults(ReqFilterDataType reqFilterData){
		
		
		/*load results*/
			List<ReqFilterConfigurationDataType> confList = reqFilterData.getConfigurations(true);
			List<ReqFilterConfigurationDataType> confListNOT = reqFilterData.getConfigurations(false); 
			
			int confSize = confListNOT.size() + confList.size();
			
		/*display results*/
			
		RequirementsFilterResultPage.requiredSF_data.setText(reqFilterData.getRequiredSF().toString());			
		RequirementsFilterResultPage.requiredATTS_data.setText(getStringFromHashMap(reqFilterData.getRequiredATTS()));
		
			
		RequirementsFilterResultPage.confMatchReq_data.setText("    "+confList.size()+" out of "+confSize+" configurations");
		RequirementsFilterResultPage.confNotMatchReq_data.setText("    "+confListNOT.size()+" out of "+confSize+" configurations");
	 
		RequirementsFilterResultPage.configurationsFulfillingReqTableViewer.setInput(confList);
		RequirementsFilterResultPage.configurationsNotFulfillingReqTableViewer.setInput(confListNOT);

		
	}
	
	public static String getStringFromHashMap( HashMap<String, String[]> hashMap){
		String output ="";
		output="[";
		
		Iterator<String> hashMapIterator = hashMap.keySet().iterator();
		while(hashMapIterator.hasNext()){
			String hashMapID = hashMapIterator.next();
			output+=hashMapID;
			for(String s: hashMap.get(hashMapID)){
				output+=s;
			}
			if(hashMapIterator.hasNext()){
				output+=",";
			}
		}
		output+="]";
		
	return output;
	}
	
	
	/*conversion procedures to produce output in the correct cell format (string)*/
	
	 public static String convertAttributeTypeListToString(List<Attribute> attributeTypeList){
		 String output = "";
		
			if(attributeTypeList != null && attributeTypeList.size() != 0){
					
				Iterator<Attribute> attsListIterator = attributeTypeList.iterator();
				while(attsListIterator.hasNext()){
					Attribute at = attsListIterator.next();
					output += at.getAttributeType().getName()+": "+ at.getInstantiationValue();
					if(attsListIterator.hasNext()){
						output +=" ,";
					}
					
				}
			}
			
		return output;
		 
	 }
	 
	 public static String convertServiceFeatureListToString(List<ServiceFeature> serviceFeatureList){
		 String output = "";
		
			if(serviceFeatureList != null && serviceFeatureList.size() != 0){
				
				Iterator<ServiceFeature> sfListIterator = serviceFeatureList.iterator();
				while(sfListIterator.hasNext()){
					ServiceFeature sf = sfListIterator.next();
					output += sf.getName();
					if(sfListIterator.hasNext()){
						output +=" ,";
					}
					
				}
			}
			
		return output;
		 
	 }
	
}
