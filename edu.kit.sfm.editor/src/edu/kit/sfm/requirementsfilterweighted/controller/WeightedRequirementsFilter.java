package edu.kit.sfm.requirementsfilterweighted.controller;

import java.util.ArrayList;
import java.util.List;

import edu.kit.sfm.requirementsfilterweighted.model.AttributeTypeRequirement;
import edu.kit.sfm.requirementsfilterweighted.model.FeatureRequirement;
import edu.kit.sfm.requirementsfilterweighted.model.RequirementFulfillment;
import edu.kit.sfm.servicefeaturemodel.Attribute;
import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.FeatureTypes;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;

public class WeightedRequirementsFilter {
	
	public ArrayList<RequirementFulfillment> filterWeightedRequirements(
			Service service, 
			List<FeatureRequirement> featureReqList, 
			List<AttributeTypeRequirement> attReqList){
		
		ArrayList<RequirementFulfillment> result = new ArrayList<RequirementFulfillment>();
		
		for(Configuration conf : service.getConfigurations().getConfigurations()){
			RequirementFulfillment fulfillment = new RequirementFulfillment(conf);
			
			// Feature requirements:
			for(FeatureRequirement req : featureReqList){
				fulfillment.addFeatureReqGap(req, getFeatureRequirementGap(conf, req));
			}
			
			// Attribute type requirements:
			for(AttributeTypeRequirement req : attReqList){
				fulfillment.addAttReqGap(req, getAttributeTypeRequirementGap(conf, req));
			}
			fulfillment.calcFulfillment();
			result.add(fulfillment);
		}
		
		return result;
	}
	
	
	/**
	 * Determine the gap w.r.t. how well the given configuration fulfills the given requirement.
	 * @param conf
	 * @param req
	 * @return
	 */
	private double getAttributeTypeRequirementGap(Configuration conf, AttributeTypeRequirement req) {
		double confValue = 0.0;
		for(Attribute at : conf.getAttributes()){
			if(at.getAttributeType().getName().equals(req.getAttName())){
				confValue = Double.parseDouble(at.getInstantiationValue());
				break;
			}
		}
		
		switch (req.getComparator()) {
		case SMALLER:
			if(confValue < req.getValue()){
				return 0.0;
			}
			break;
		case SMALLER_EQUAL:
			if(confValue <= req.getValue()){
				return 0.0;
			}
			break;
		case EQUAL:
			if(confValue == req.getValue()){
				return 0.0;
			}
			break;
		case LARGER_EQUAL:
			if(confValue >= req.getValue()){
				return 0.0;
			}
			break;
		case LARGER:
			if(confValue > req.getValue()){
				return 0.0;
			}
			break;
			
		default:
			break;
		}
		return Math.abs((req.getValue() - confValue) / req.getValue());
	}


	/**
	 * Determine whether the given configuration fulfills the given feature requirement (and to what degree) 
	 * @param conf
	 * @param req
	 * @return '0.0' if the requirement is fulfilled by the configuration and 'weight' if not
	 */
	private double getFeatureRequirementGap(Configuration conf, FeatureRequirement req){
		
		if(req.getFeatureType().equals(FeatureTypes.INSTANCE_FEATURE)){
			for(ServiceFeature sf : conf.getServiceFeatures()){
				if(sf.getName().equals(req.getFeatureName())){
//					System.out.println("Required instance feature \"" + sf.getName() + "\" is contained - return 0.0");
					return 0.0;
				}
			}
			
		} else if (req.getFeatureType().equals(FeatureTypes.ABSTRACT_FEATURE)){
			for(ServiceFeature sf : conf.getServiceFeatures()){
				if(sf.getName().equals(req.getFeatureName())){
					// List to hold child features:
					List<ServiceFeature> instanceFeatures = new ArrayList<ServiceFeature>();
					
					// Add (optional) child features:
					if(sf.getServiceFeatures() != null && sf.getServiceFeatures().size() != 0){
						instanceFeatures.addAll(sf.getServiceFeatures());
					}
					
					// Add child features in group relationship
					if(sf.getGroupRelationship() != null && 
							sf.getGroupRelationship().getOptionalServiceFeatures() != null && 
							sf.getGroupRelationship().getOptionalServiceFeatures().size() != 0){
						instanceFeatures.addAll(sf.getGroupRelationship().getOptionalServiceFeatures());
					}
					
					// Check whether configuration contains one of these:
					for(ServiceFeature isf : instanceFeatures){
						for(ServiceFeature confsf : conf.getServiceFeatures()){
							if(isf.getName().equals(confsf.getName())){
//								System.out.println("Required abstract feature \"" + sf.getName() + "\" is instantiated by \"" + confsf.getName() + "\" - return 0.0");
								return 0.0;
							}
						}
					}
//					System.out.println("Required abstract feature \"" + sf.getName() + "\" is not instantiated - return " + req.getWeight());
				}
			}
		}
		return req.getWeight();
	}
}
