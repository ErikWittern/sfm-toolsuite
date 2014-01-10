package edu.kit.sfm.requirementsfilter.model;

import java.util.ArrayList;
import java.util.List;

import edu.kit.sfm.servicefeaturemodel.Configuration;


/*CUSTOM DATA TYPE*/


public class ReqFilterConfigurationDataType {

	//attributes
	private Configuration configuration;
    private boolean fulfillsReq;
    private List<String> notFulfilledServiceFeatureReq;
	private List<String> notFulfilledAttributeTypeReq;
    
    //constructor
	public   ReqFilterConfigurationDataType(){
    	
    	this.configuration = null;
    	this.fulfillsReq = false;
    	this.notFulfilledServiceFeatureReq = new ArrayList<String>();
    	this.notFulfilledAttributeTypeReq = new ArrayList<String>();
    	
    }
   public ReqFilterConfigurationDataType(Configuration configuration){
    	
    	this.configuration = configuration;
    	this.fulfillsReq = false;
    	this.notFulfilledServiceFeatureReq  = new ArrayList<String>();
    	this.notFulfilledAttributeTypeReq = new ArrayList<String>();
    	
    }
	
	//methods  get/set  - access attributes
    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration value) {
        this.configuration = value;
    }
    
    public boolean getFulfillsReq() {
        return fulfillsReq;
    }

    public void setFulfillsReq(boolean value) {
        this.fulfillsReq = value;
    }
    
    public List<String> getNotFullfilledServiceFeatureReq() {
        return notFulfilledServiceFeatureReq;
    }

    public void setNotFullfilledServiceFeatureReq(List<String> value) {
        this.notFulfilledServiceFeatureReq = value;
    }
    
    public List<String> getNotFulfilledAttributeTypeReq() {
        return notFulfilledAttributeTypeReq;
    }

    public void setNotFulfilledAttributeTypeReq(List<String> value) {
        this.notFulfilledAttributeTypeReq = value;
    }
    
}
