package edu.kit.sfm.requirementsfilter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.kit.sfm.requirementsfilter.model.ReqFilterConfigurationDataType;
import edu.kit.sfm.requirementsfilter.model.ReqFilterDataType;
import edu.kit.sfm.servicefeaturemodel.Attribute;
import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature;
import edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;
import edu.kit.sfm.utils.SFMPersistencyOperations;

public class RequirementsFilter {
	
	
	
	/*REQUIREMENTS FILTERING - MAIN PROCEDURE*/
	public static ReqFilterDataType filterRequirements(ReqFilterDataType reqFilterData){
	
		/*LOAD DATA*/
			// Get requirements:
			reqFilterData.setRequiredATTS(RequirementsExtracter.extractAttributeTypeRequirements(reqFilterData.getRequirementsModelName()));
			reqFilterData.setRequiredSF(RequirementsExtracter.extractFeatureRequirements(reqFilterData.getRequirementsModelName()));
			
			// Get service model:
			Service serviceModel = SFMPersistencyOperations.loadModel(reqFilterData.getServiceModelName());
		
		/*Check service model configs against requirements*/
			// Iterate all configs and check whether they match the requirements:
				List<Configuration> confList = serviceModel.getConfigurations().getConfigurations();
				
				if(confList != null && confList.size() != 0){
					for(Configuration conf : confList){
						
						//add new data obj for this configuration
						ReqFilterConfigurationDataType selectedConf = new ReqFilterConfigurationDataType(conf);		
						
						//check service feature req and attributeType req
						boolean meetsAtt = meetsAttributeTypeRequirements(reqFilterData.getRequiredATTS(), selectedConf);
						boolean meetsFeat = meetsFeatureRequirements(reqFilterData.getRequiredSF(), selectedConf);
						
						if(meetsAtt && meetsFeat){ 
							//meets requirements
								selectedConf.setFulfillsReq(true);
								//add config to designated list
								reqFilterData.getConfigurations(true).add(selectedConf);
							
							
						} else {
							//meets NOT requirements
								selectedConf.setFulfillsReq(false);
								//add config to designated list
								reqFilterData.getConfigurations(false).add(selectedConf);
						
						}
					
					}
					
				} else {
					//no configurations
					System.out.println("No configurations in service model: " + reqFilterData.getServiceModelName());
				}
			
		return reqFilterData;
	}

	
	
	
	
	public static boolean meetsFeatureRequirements(List<String> list, ReqFilterConfigurationDataType selectedConf){
		boolean meetsReq = true;
		boolean sfExists = false;
		
		for(String req : list){
			
			//set exist to false
			sfExists = false;
			
			//iterate through service features 
			for(ServiceFeature sf : selectedConf.getConfiguration().getServiceFeatures()){
				
					//optional feature
					if (sf instanceof OptionalServiceFeature) {
						
					
						//optional features are instance features
						if(sf.getName().equals(req)){
							sfExists = true;	
						} 
					}	
				
					//mandatory feature
					if(sf instanceof MandatoryServiceFeature) { {
						
						MandatoryServiceFeature msf = (MandatoryServiceFeature) sf;
						switch (msf.getFeatureTypes()) {
						case INSTANCE_FEATURE: // Check whether this instance feature is required.
							
							if(sf.getName().equals(req)){
								sfExists = true;
							} 
							break;
							
						case ABSTRACT_FEATURE: 
							if(sf.getName().equals(req)){
								// Check whether any instance feature is contained in this conf:
								List<ServiceFeature> instanceFeature = new ArrayList<ServiceFeature>();
								
								if(sf.getServiceFeatures() != null && sf.getServiceFeatures().size() != 0){
									instanceFeature.addAll(sf.getServiceFeatures());
								}
								
								if(sf.getGroupRelationship() != null && sf.getGroupRelationship().getOptionalServiceFeatures() != null && 
									sf.getGroupRelationship().getOptionalServiceFeatures().size() != 0){
									instanceFeature.addAll(sf.getGroupRelationship().getOptionalServiceFeatures());
								}
								
								for(ServiceFeature isf : instanceFeature){
									for(ServiceFeature confsf : selectedConf.getConfiguration().getServiceFeatures()){
										if(isf.getName().equals(confsf.getName())){
											sfExists = true;
										}
									}
								}	
							}
							break;
							
						default:
							break;
						}
						} // end switch
					
					}//end mandatory
					
					
				
					
				}	// end for - sf
				
					if(sfExists==false){
						meetsReq = false;
						selectedConf.getNotFullfilledServiceFeatureReq().add(req);
					}
			
			} // end for - req
		
		return meetsReq;
	}


	public static boolean meetsAttributeTypeRequirements(HashMap<String, String[]> reqMap, ReqFilterConfigurationDataType selectedConf){
		boolean meetsReq = true;
		
		for(Attribute att : selectedConf.getConfiguration().getAttributes()){
			if(reqMap.containsKey(att.getAttributeType().getName())){
				String[] req = reqMap.get(att.getAttributeType().getName());
				if(req[0].equals("<")){
					if( !( Double.parseDouble(att.getInstantiationValue()) < Double.parseDouble(req[1]) ) ){ 
						meetsReq = false; 
						selectedConf.getNotFulfilledAttributeTypeReq().add(att.getAttributeType().getName()+req[0]+req[1]);
					}
				} else if (req[0].equals("=")){
					if( !( Double.parseDouble(req[1]) == Double.parseDouble(att.getInstantiationValue()) ) ){ 
						meetsReq = false; 
						selectedConf.getNotFulfilledAttributeTypeReq().add(att.getAttributeType().getName()+req[0]+req[1]);
					}
				} else if (req[0].equals(">")){
					if( !( Double.parseDouble(att.getInstantiationValue()) > Double.parseDouble(req[1]) ) ){ 
						meetsReq = false;
						selectedConf.getNotFulfilledAttributeTypeReq().add(att.getAttributeType().getName()+req[0]+req[1]);
					}
				} else if (req[0].equals(">=")){
					if( !( Double.parseDouble(att.getInstantiationValue()) >= Double.parseDouble(req[1]) ) ){ 
						meetsReq = false;
						selectedConf.getNotFulfilledAttributeTypeReq().add(att.getAttributeType().getName()+req[0]+req[1]);
					}
				} else if (req[0].equals("<=")){
					if( !( Double.parseDouble(att.getInstantiationValue()) <= Double.parseDouble(req[1]) ) ){ 
						meetsReq = false;
						selectedConf.getNotFulfilledAttributeTypeReq().add(att.getAttributeType().getName()+req[0]+req[1]);
					}
				} else {
					meetsReq = false;
				}
				
			
			}
		}
		return meetsReq;
	}


	
	
}
