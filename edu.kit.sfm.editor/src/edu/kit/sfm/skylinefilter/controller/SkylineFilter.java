package edu.kit.sfm.skylinefilter.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
//		System.out.println("Original configuration list contains " + confList.size() + " configurations.");
		
		for(Configuration p : confList){
			List<Configuration> toDelete = new ArrayList<Configuration>();
			window.add(p);
			for(Configuration q : window){
				if(!p.equals(q) && isDominatedBy(p, q)){
					toDelete.add(p);
					break;
				} else if (isDominatedBy(q, p)){
					toDelete.add(q);
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
//		System.out.println("Original configuration list contains " + confList.size() + " configurations.");
		for(Configuration conf : confList){
			for(Configuration conf2 : confList){
				if(isDominatedBy(conf, conf2)){
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
	 * Determines whether conf is dominated by conf2
	 * @param conf
	 * @param conf2
	 * @return true, if conf is completely dominated by conf2
	 */
	private boolean isDominatedBy(Configuration conf, Configuration conf2) {
		boolean isDominated = true;
		for(int i = 0; i < conf.getAttributes().size(); i++){
			if(conf.getAttributes().get(i).getAttributeType().getScaleOrder() == ScaleOrders.LOWER_IS_BETTER){
				if(Double.parseDouble(conf.getAttributes().get(i).getInstantiationValue()) 
						<= 
						Double.parseDouble(conf2.getAttributes().get(i).getInstantiationValue())){
					isDominated = false;
					break;
				}
			} else if(conf.getAttributes().get(i).getAttributeType().getScaleOrder() == ScaleOrders.HIGHER_IS_BETTER){
				if(Double.parseDouble(conf.getAttributes().get(i).getInstantiationValue()) 
						>= 
						Double.parseDouble(conf2.getAttributes().get(i).getInstantiationValue())){
					isDominated = false;
					break;
				}
			} else if(conf.getAttributes().get(i).getAttributeType().getScaleOrder() == ScaleOrders.EXISTENCE_IS_BETTER) {
				if(Integer.parseInt(conf.getAttributes().get(i).getInstantiationValue()) == 1 && 
						Integer.parseInt(conf2.getAttributes().get(i).getInstantiationValue()) == 0){
					isDominated = false;
					break;
				}
			}
		}
//		if(isDominated){
//			System.out.println("  Configuration " + conf.getName() + " is dominated by " + conf2.getName());
//		}
		numComp++;
		return isDominated;
	}
}
