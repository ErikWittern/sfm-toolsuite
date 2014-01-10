package edu.kit.sfm.requirementsfilter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import edu.kit.sfm.servicefeaturemodel.Configuration;

/*CUSTOM DATA TYPE*/


public class ReqFilterDataType {
	  
		//attributes
		private String requirementsModelName;
		private String serviceModelName;
		private List<String> requiredSF;
		private HashMap<String, String[]> requiredATTS;
	    private List<ReqFilterConfigurationDataType> configurationsFulfillingReq;
	    private List<ReqFilterConfigurationDataType> configurationsNotFulfillingReq;
	    
	    //constructor
	    public ReqFilterDataType(){
	    	this.requirementsModelName = "";
	    	this.serviceModelName = "";
	    	this.requiredSF =  new ArrayList<String>() ;
	    	this.requiredATTS =  new HashMap<String, String[]>() ;
	    	this.configurationsFulfillingReq =  new ArrayList<ReqFilterConfigurationDataType>() ;
	    	this.configurationsNotFulfillingReq =  new ArrayList<ReqFilterConfigurationDataType>() ;
	    }
		
		
	    //init
	    public void clearFilteringResults(){
	    	
	    	this.requiredSF.clear(); 
	    	this.requiredATTS.clear(); 
	    	this.configurationsFulfillingReq.clear();
	    	this.configurationsNotFulfillingReq.clear();
	    	
	    }
	    
	    
	    //methods - get/set properties - access attributes
	    

	    public String getServiceModelName() {
	        return serviceModelName;
	    }

	    public void setServiceModelName(String value) {
	        this.serviceModelName = value;
	    }

	    public String getRequirementsModelName() {
	        return requirementsModelName;
	    }

	    public void setRequirementsModelName(String value) {
	        this.requirementsModelName = value;
	    }
	    
	    public List<String> getRequiredSF() {
	        return requiredSF;
	    }

	    public void setRequiredATTS(HashMap<String, String[]> value) {
	        this.requiredATTS = value;
	    }
	    public HashMap<String, String[]> getRequiredATTS() {
	        return requiredATTS;
	    }

	    public void setRequiredSF(List<String> value) {
	        this.requiredSF = value;
	    }
	
	    /*configurations*/
	    
  
	    private List<Configuration> getConfigurationsNotFulfillingReqPLAIN(){	
	    	//Initialize local variable
	    		List<Configuration> configurationsOutput = new ArrayList<Configuration>();
	    		List<ReqFilterConfigurationDataType> configurationsInput = this.configurationsNotFulfillingReq;
	    	
	    	//extract configurations from 'configurationsInput' list into  new 'configurationsOutput' list
	    	
	    		Iterator<ReqFilterConfigurationDataType> configurationsInputIterator = configurationsInput.iterator();
	    		while(configurationsInputIterator.hasNext()){
	    			//select configuration
	    			Configuration selectedConf= configurationsInputIterator.next().getConfiguration();
	    			
	    			//add to list
	    			configurationsOutput.add(selectedConf);
	    			
	    		}
	    		
	    		
	    	return configurationsOutput;
	    	
	    }
	  
	 //public  
	/**	
	 *  Returns a list of configurations, which either are fulfilling or not fulfilling requirements.
	 * 
		@param   FullfillingReq
					<br>[true]  - returns a list of configurations fulfilling requirements
					<br>[false] - returns a list of configurations NOT fulfilling requirements
		@return  A list of configurations. Format List  &lt;ReqFilterConfigurationDataType&gt;
	*/
	public List<ReqFilterConfigurationDataType> getConfigurations(Boolean FullfillingReq){
	    	
	    	if(FullfillingReq){
	    		return configurationsFulfillingReq;
	    	}else{
	    	     return configurationsNotFulfillingReq;	
	    	}
	    	
	    }
	
	/**	
	 *  Returns a list of configurations, which either are fulfilling or not fulfilling requirements.
	 * 
		@param   FullfillingReq
					<br>[true]  - returns a list of configurations fulfilling requirements
					<br>[false] - returns a list of configurations NOT fulfilling requirements<br><br>
					
		@param		Format 
					Specifies the return format.
					<br> "PLAIN" 						 - return format:  List &lt;Configuration&gt;
					<br> every string apart from "PLAIN" - return format:  List &lt;ReqFilterConfigurationDataType&gt;
		@return  A list of configurations. Specified format.
	*/
    public List<?> getConfigurations(Boolean FullfillingReq,String Format){
	    	
	    	if(FullfillingReq){
	    		return configurationsFulfillingReq;
	    	}else{
	    		
	    		if(Format == "PLAIN"){
	    			return getConfigurationsNotFulfillingReqPLAIN();
	    		}else{
	    			   return configurationsNotFulfillingReq;	
	    		}
	    	  
	    	}
	    	
	    }
	    
    public void setConfigurations(Boolean FullfillingReq,List<ReqFilterConfigurationDataType> value){
    	
     	if(FullfillingReq){
     	   this.configurationsFulfillingReq = value;
     	}else{
     	   this.configurationsNotFulfillingReq = value;
     	}
    	
    }
    
	    
}





