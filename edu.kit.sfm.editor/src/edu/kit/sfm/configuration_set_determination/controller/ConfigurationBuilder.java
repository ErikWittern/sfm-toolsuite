package edu.kit.sfm.configuration_set_determination.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import choco.kernel.solver.Solution;
import choco.kernel.solver.Solver;
import choco.kernel.solver.search.ISolutionPool;
import edu.kit.sfm.servicefeaturemodel.AggregationRules;
import edu.kit.sfm.servicefeaturemodel.Attribute;
import edu.kit.sfm.servicefeaturemodel.AttributeType;
import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelFactory;

public class ConfigurationBuilder {

	private long processingTime;
	ServicefeaturemodelFactory sfm = ServicefeaturemodelFactory.eINSTANCE;
	
	public ConfigurationBuilder(){
		processingTime = 0;
	}
	
	public List<Configuration> getConfigurations(Service service, Solver s){
		
		long startTime = System.currentTimeMillis();
		
		List<Configuration> confs = new ArrayList<Configuration>();
						
		List<Map<String, Double>> values = new ArrayList<Map<String, Double>>();
		HashMap<String, Integer> attIndex = new HashMap<String, Integer>();
		int x = 0;
		for(AttributeType att : service.getAttributeTypes().getAttributeTypes()){
			attIndex.put(att.getName(), x);
			values.add(new HashMap<String, Double>());
			x++;
		}
		
		HashMap<Integer, ServiceFeature> features = new HashMap<Integer, ServiceFeature>();
		TreeIterator<EObject> tree = service.getServiceFeatureDiagram().eAllContents();
		int numFeature = 0;
		while(tree.hasNext()){
			EObject e = tree.next();
			if(e instanceof ServiceFeature){
				ServiceFeature sf = (ServiceFeature) e;
				features.put(numFeature, sf);
				numFeature++;
			} else if (e instanceof Attribute){
				Attribute at = (Attribute) e;
				ServiceFeature parent = (ServiceFeature) at.eContainer();
				values.get(
					attIndex.get(at.getAttributeType().getName())
				).put(parent.getId(), Double.parseDouble(at.getInstantiationValue()));
			}
		}
		
		
		// Iterate solutions
		ISolutionPool pool = s.getSearchStrategy().getSolutionPool();
		int numConf = 1;
		for(Solution sol : pool.asList()){
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
			
			
			confs.add(c);
			numConf++;
		}
		
		long endTime = System.currentTimeMillis();
		processingTime = (endTime - startTime);
		
		return confs;
	}
	
	public long getProcessingTime(){
		return processingTime;
	}
	
}