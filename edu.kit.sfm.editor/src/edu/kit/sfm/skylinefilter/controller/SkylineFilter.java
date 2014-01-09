package edu.kit.sfm.skylinefilter.controller;

import java.util.ArrayList;
import java.util.List;

import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.ScaleOrders;
import edu.kit.sfm.servicefeaturemodel.Service;

public class SkylineFilter {

	static int numComp = 0;
	
	/**
	 * Returns list of configurations that contains only not completely dominated configurations.
	 * @param service
	 * @return
	 */
	public List<Configuration> getSkylineConfigurationsBNL(Service service){
		numComp = 0;
		List<Configuration> confList = service.getConfigurations().getConfigurations();
		List<Configuration> window = new ArrayList<Configuration>();
//		System.out.println("SKYLINE BNL==================================");
//		System.out.println("Original configuration list contains " + confList.size() + " configurations.");
		
		for(Configuration p : confList){
			List<Configuration> toDelete = new ArrayList<Configuration>();
			window.add(p);
			for(Configuration q : window){
				if(!p.equals(q)){
					if(dominates(q, p)){
						toDelete.add(p);
						break;
					} else if (dominates(p, q)){
						toDelete.add(q);
					}
				}
			}
			window.removeAll(toDelete);
		}	
//		System.out.println("Skyline BNL - Adapted configuration list contains " + window.size() + " configurations (" + (confList.size() - window.size()) + " removed).");
//		System.out.println("Number of comparisons: " + numComp);
		return window;
	}
	
	
	/**
	 * Returns list of configurations that contains only not completely dominated configurations.
	 * @param service
	 * @return
	 */
	public List<Configuration> getSkylineConfigurations(Service service){
		numComp = 0;
		List<Configuration> confList = service.getConfigurations().getConfigurations();
		List<Configuration> dominatedConfs = new ArrayList<Configuration>();
//		System.out.println("SKYLINE==================================");
//		System.out.println("Original configuration list contains " + confList.size() + " configurations.");
		for(Configuration conf : confList){
			for(Configuration conf2 : confList){
				if(dominates(conf2, conf)){
					dominatedConfs.add(conf);
					break;
				}
			}
		}
		List<Configuration> result = new ArrayList<Configuration>(confList);
		result.removeAll(dominatedConfs);
//		System.out.println("Skyline - Adapted configuration list contains " + confList.size() + " configurations (" + dominatedConfs.size() + " removed).");
//		System.out.println("Number of comparisons: " + numComp);
		return result;
	}

	
	/**
	 * Determines whether c1 dominates c2.
	 * To dominate, c1 needs to be equal or better than c2 in any attribute.
	 * To NOT be dominated, conf needs to be better in any of the attributes.
	 * 
	 * @param conf
	 * @param conf2
	 * @return true, if conf is completely dominated by conf2
	 */
	private boolean dominates(Configuration c1, Configuration c2) {
//		System.out.println("Does " + c1.getName() + " dominate " + c2.getName() + "?");
		numComp++;
		boolean betterInAtLeastOne = false;
		for(int i = 0; i < c1.getAttributes().size(); i++){
			if(c1.getAttributes().get(i).getAttributeType().getScaleOrder() == ScaleOrders.LOWER_IS_BETTER){
				if(Double.parseDouble(c2.getAttributes().get(i).getInstantiationValue()) 
						<
						Double.parseDouble(c1.getAttributes().get(i).getInstantiationValue())){
//					System.out.println("  " + c1.getName() + " is worse (= bigger value) than " + c2.getName() + " in: " + c1.getAttributes().get(i).getAttributeType().getName());
					return false;
				} else if (Double.parseDouble(c1.getAttributes().get(i).getInstantiationValue()) 
						<
						Double.parseDouble(c2.getAttributes().get(i).getInstantiationValue())){
					betterInAtLeastOne = true;
				}
			} else {
				if(Double.parseDouble(c2.getAttributes().get(i).getInstantiationValue()) 
						>
						Double.parseDouble(c1.getAttributes().get(i).getInstantiationValue())){
//					System.out.println("  " + c1.getName() + " is worse (= smaller value) than " + c2.getName() + " in: " + c1.getAttributes().get(i).getAttributeType().getName());
					return false;
				} else if (Double.parseDouble(c1.getAttributes().get(i).getInstantiationValue()) 
						>
						Double.parseDouble(c2.getAttributes().get(i).getInstantiationValue())){
					betterInAtLeastOne = true;
				}
			}
		}
//		if(betterInAtLeastOne){
//			System.out.println(c1.getName() + " does indeed dominate " + c2.getName());
//		}
		return betterInAtLeastOne;
	}
}
