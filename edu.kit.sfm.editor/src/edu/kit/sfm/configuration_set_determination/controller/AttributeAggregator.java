package edu.kit.sfm.configuration_set_determination.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import choco.kernel.solver.Solution;
import choco.kernel.solver.Solver;
import edu.kit.sfm.servicefeaturemodel.AggregationRules;
import edu.kit.sfm.servicefeaturemodel.Attribute;
import edu.kit.sfm.servicefeaturemodel.AttributeType;
import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelFactory;

public class AttributeAggregator implements Callable<List<Configuration>>{

	private List<Solution> sList;
	private Solver s;
	private int numConf;
	private HashMap<Integer, ServiceFeature> features;
	private Service service;
	private List<Map<String, Double>> values;
	private HashMap<String, Integer> attIndex;
	
	ServicefeaturemodelFactory sfm = ServicefeaturemodelFactory.eINSTANCE;
	
	
	/**
	 * Constructor
	 * @param sol
	 * @param s
	 * @param numConf
	 * @param features
	 * @param service
	 * @param values
	 * @param attIndex
	 */
	public AttributeAggregator(
			List<Solution> sList, 
			Solver s, 
			int numConf, 
			HashMap<Integer, 
			ServiceFeature> features,
			Service service,
			List<Map<String, Double>> values,
			HashMap<String, Integer> attIndex){
		
		this.sList = sList;
		this.s = s;
		this.numConf = numConf;
		this.features = features;
		this.service = service;
		this.values = values;
		this.attIndex = attIndex;
	}

	@Override
	public List<Configuration> call() throws Exception {
//		System.out.println("AttributeAggregator for list with size: " + sList.size());
		List<Configuration> confList = new ArrayList<Configuration>();
		for(Solution sol : sList){
			// helpers:
			List<String> featureIds = new ArrayList<String>();

			// Create configuration object:
			Configuration c = sfm.createConfiguration();
			c.setName("Configuration " + numConf);

			// Determine features:
			for(int i = 0; i < s.getNbIntVars(); i++){
				if(sol.getIntValue(i) == 1){
					c.getServiceFeatures().add(features.get(i));
					featureIds.add(features.get(i).getId());
				}
			}

			// Add attributes:
			for(AttributeType att : service.getAttributeTypes().getAttributeTypes()){
				Attribute a = sfm.createAttribute();
				a.setAttributeType(att);
				if(att.getAggregationRule() == AggregationRules.SUM){
					double v = 0.0;
					for(String id : featureIds){
						if(values.get(attIndex.get(att.getName())).containsKey(id)){
							v = v + values.get(attIndex.get(att.getName())).get(id);
						}
					}
					a.setInstantiationValue(""+v);
				} else if(att.getAggregationRule() == AggregationRules.PRODUCT){
					double v = 0.0;
					for(String id : featureIds){
						if(values.get(attIndex.get(att.getName())).containsKey(id)){
							v = v * values.get(attIndex.get(att.getName())).get(id);
						}
					}
					a.setInstantiationValue(""+v);
				} else if (att.getAggregationRule() == AggregationRules.AT_LEAST_ONCE){
					Double v = 0.0;
					for(String id : featureIds){
						if(values.get(attIndex.get(att.getName())).containsKey(id)){
							if(values.get(attIndex.get(att.getName())).get(id) == 1){
								v = 1.0;
								break;
							}
						}
					}
					a.setInstantiationValue(""+v.intValue());
				} else if (att.getAggregationRule() == AggregationRules.MAXIMUM){
					double v = 0.0;
					for(String id : featureIds){
						if(values.get(attIndex.get(att.getName())).containsKey(id)){
							if(values.get(attIndex.get(att.getName())).get(id) > v){
								v = values.get(attIndex.get(att.getName())).get(id);
							}
						}
					}
					a.setInstantiationValue(""+v);
				} else if (att.getAggregationRule() == AggregationRules.MINIMUM){
					double v = Double.MAX_VALUE;
					for(String id : featureIds){
						if(values.get(attIndex.get(att.getName())).containsKey(id)){
							if(values.get(attIndex.get(att.getName())).get(id) < v){
								v = values.get(attIndex.get(att.getName())).get(id);
							}
						}
					}
					a.setInstantiationValue(""+v);
				}
				c.getAttributes().add(a);
			}
			confList.add(c);
			numConf++;
		}
		return confList;
	}

}
