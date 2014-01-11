package edu.kit.sfm.requirementsfilterweighted.view;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import edu.kit.sfm.requirementsfilterweighted.controller.WeightedRequirementsExtracter;
import edu.kit.sfm.requirementsfilterweighted.model.AttributeTypeRequirement;
import edu.kit.sfm.requirementsfilterweighted.model.FeatureRequirement;
import edu.kit.sfm.servicefeaturemodel.Service;

public class WeightedRequirementsActionDelegate extends ActionDelegate implements IActionDelegate  {
	
	protected EClass eClass;
	
	public WeightedRequirementsActionDelegate() {
		super();
	}
	
	/**
	 * run(IAction action)
	 * Performed when menu entry "Weighted requirements filter..." is selected by user.
	 */
	@Override
	public void run(IAction action) {
		// Get current model's service:
		ResourceSet resourceSet = new ResourceSetImpl();
		URI resourceURI = EditUIUtil.getURI(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput());
		Resource resource = resourceSet.getResource(resourceURI, true);
		Service service = (Service) resource.getContents().get(0);
		
		// Extract requirements from SFM:
		WeightedRequirementsExtracter ext = new WeightedRequirementsExtracter();
		List<FeatureRequirement> featureReqList = ext.extractFeatureRequirements(service);
		List<AttributeTypeRequirement> attReqList = ext.extractAttributeTypeRequirements(service);
		
		// Initiate wizard:
		WeightedRequirementsFilterWizard wizard = new WeightedRequirementsFilterWizard(service, featureReqList, attReqList);
		WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
		dialog.setPageSize(620, 600);
		dialog.open();
	}
}
