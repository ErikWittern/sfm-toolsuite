package edu.kit.sfm.requirementsfilter.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import edu.kit.sfm.requirementsfilter.model.AttributeTypeRequirement;
import edu.kit.sfm.requirementsfilter.model.Comparators;
import edu.kit.sfm.requirementsfilter.model.FeatureRequirement;
import edu.kit.sfm.servicefeaturemodel.AttributeType;
import edu.kit.sfm.servicefeaturemodel.FeatureTypes;
import edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature;
import edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;

public class RequirementsExtracter {
	
	/**
	 * Extract attribute type requirements from given SFM
	 * @param reqModelName
	 * @return
	 */
	public List<AttributeTypeRequirement> extractAttributeTypeRequirements(Service service){
		
		List<AttributeTypeRequirement> reqList = new ArrayList<AttributeTypeRequirement>();
		
		for(AttributeType at : service.getAttributeTypes().getAttributeTypes()){
			String req = at.getRequirement();
			if(req != null && !req.equals("")){
				String[] reqSplit = req.split(" ", 2);
				Comparators comp = Comparators.EQUAL;
				if(reqSplit[0].equals("<")){
					comp = Comparators.SMALLER;
				}else if(reqSplit[0].equals("<=")){
					comp = Comparators.SMALLER_EQUAL;
				}else if(reqSplit[0].equals("=")){
					comp = Comparators.EQUAL;
				}else if(reqSplit[0].equals(">=")){
					comp = Comparators.LARGER_EQUAL;
				}else if(reqSplit[0].equals(">")){
					comp = Comparators.LARGER;
				}				
				reqList.add(new AttributeTypeRequirement(at.getName(), 
						comp, 
						Double.parseDouble(reqSplit[1]), 
						1.0)); // TODO: Use real weight instead!!!
			}
		}
		return reqList;
	}


	/**
	 * Extract feature requirements from given SFM
	 * @param reqModelName
	 * @return
	 */
	public List<FeatureRequirement> extractFeatureRequirements(Service service){
		
		List<FeatureRequirement> reqList = new ArrayList<FeatureRequirement>();
		
		for(org.eclipse.emf.common.util.TreeIterator<EObject> it = service.eAllContents() ; it.hasNext();){
			EObject ob = it.next();
			if (ob instanceof ServiceFeature) {
				ServiceFeature sf = (ServiceFeature) ob;
				if (sf instanceof OptionalServiceFeature) {
					if(sf.isRequired()){
						reqList.add(new FeatureRequirement(sf.getId(), sf.getName(), 1.0, FeatureTypes.INSTANCE_FEATURE)); // TODO: replace with actual value
					}
				} else {
					MandatoryServiceFeature msf = (MandatoryServiceFeature) sf;
					switch (msf.getFeatureTypes()) {
					case INSTANCE_FEATURE:
						if(sf.isRequired()){
							reqList.add(new FeatureRequirement(sf.getId(), sf.getName(), 1.0, FeatureTypes.INSTANCE_FEATURE)); // TODO: replace with actual value
						}
						break;
					case ABSTRACT_FEATURE:
						if(sf.isRequired()){
							reqList.add(new FeatureRequirement(sf.getId(), sf.getName(), 1.0, FeatureTypes.ABSTRACT_FEATURE)); // TODO: replace with actual value
						}
						break;
					case GROUPING_FEATURE:
						break;
					default:
						break;
					}
				}
			
			}
		}
		return reqList;
	}
	
}