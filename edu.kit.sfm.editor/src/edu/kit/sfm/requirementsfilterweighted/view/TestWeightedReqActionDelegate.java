package edu.kit.sfm.requirementsfilterweighted.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import edu.kit.sfm.requirementsfilterweighted.controller.WeightedRequirementsExtracter;
import edu.kit.sfm.requirementsfilterweighted.controller.WeightedRequirementsFilter;
import edu.kit.sfm.requirementsfilterweighted.model.AttributeTypeRequirement;
import edu.kit.sfm.requirementsfilterweighted.model.FeatureRequirement;
import edu.kit.sfm.requirementsfilterweighted.model.RequirementFulfillment;
import edu.kit.sfm.servicefeaturemodel.Service;

public class TestWeightedReqActionDelegate extends ActionDelegate {
	
	protected EClass eClass;
	
	public TestWeightedReqActionDelegate() {
		super();
	}
	
	@Override
	public void run(IAction action) {
		// Get current model's service:
		ResourceSet resourceSet = new ResourceSetImpl();
		URI resourceURI = EditUIUtil.getURI(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput());
		Resource resource = resourceSet.getResource(resourceURI, true);
		Service service = (Service) resource.getContents().get(0);
		
		// Extract feature requirements:
		WeightedRequirementsExtracter ext = new WeightedRequirementsExtracter();
		List<FeatureRequirement> featureReqList = ext.extractFeatureRequirements(service);
		for(FeatureRequirement req : featureReqList){
			System.out.println(req.getSummary());
		}
		List<AttributeTypeRequirement> attReqList = ext.extractAttributeTypeRequirements(service);
		for(AttributeTypeRequirement req : attReqList){
			System.out.println(req.getSummary());
		}
		
		// Calculate requirements:
		WeightedRequirementsFilter filter = new WeightedRequirementsFilter();
		ArrayList<RequirementFulfillment> results = filter.filterWeightedRequirements(service, featureReqList, attReqList);
		
		// Sort results:
		Collections.sort(results, new Comparator<RequirementFulfillment>() {
			@Override
			public int compare(RequirementFulfillment rf1, RequirementFulfillment rf2){
				return Double.compare(rf2.getDegOfFulfillment(), rf1.getDegOfFulfillment());
			}
		});
		
		for(RequirementFulfillment ful : results){
			System.out.println(ful.getSummary());
		}
	
	}

}
