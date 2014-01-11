package edu.kit.sfm.requirementsfilter.view;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import edu.kit.sfm.requirementsfilter.controller.RequirementsExtracter;
import edu.kit.sfm.requirementsfilter.controller.RequirementsFilter;
import edu.kit.sfm.requirementsfilter.model.AttributeTypeRequirement;
import edu.kit.sfm.requirementsfilter.model.FeatureRequirement;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.utils.NumberOfPerformanceRunsDialog;

public class RequirementsFilterPerformanceActionDelegate extends ActionDelegate {
	
	protected EClass eClass;
	
	public RequirementsFilterPerformanceActionDelegate() {
		super();
	}
	
	@Override
	public void run(IAction action) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		NumberOfPerformanceRunsDialog dialog = new NumberOfPerformanceRunsDialog(shell);
		dialog.create();
		if (dialog.open() == Window.OK) {
			try{
				int runs = Integer.parseInt(dialog.getNumberOfPerformanceRuns());
				
				System.out.println("Load model...");
				// Get current model's service:
				ResourceSet resourceSet = new ResourceSetImpl();
				URI resourceURI = EditUIUtil.getURI(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
						.getEditorInput());
				Resource resource = resourceSet.getResource(resourceURI, true);
				Service service = (Service) resource.getContents().get(0);
						
				// Extract feature requirements:
				System.out.println("Extract requirements...");
				RequirementsExtracter ext = new RequirementsExtracter();
				List<FeatureRequirement> featureReqList = ext.extractFeatureRequirements(service);
				for(FeatureRequirement req : featureReqList){
					System.out.println(req.getSummary());
				}
				List<AttributeTypeRequirement> attReqList = ext.extractAttributeTypeRequirements(service);
				for(AttributeTypeRequirement req : attReqList){
					System.out.println(req.getSummary());
				}
				
				// Calculate requirements:
				for(int i = 0; i < runs; i++){
					long start = System.currentTimeMillis();
					RequirementsFilter filter = new RequirementsFilter();
					filter.filterWeightedRequirements(service, featureReqList, attReqList);
					System.out.println(System.currentTimeMillis() - start);
				}
				
				
			}catch(NumberFormatException e){
				MessageDialog.openError(shell, "Error", "The provided number is not an integer. Please try again.");
			}
		}	
	}

}
