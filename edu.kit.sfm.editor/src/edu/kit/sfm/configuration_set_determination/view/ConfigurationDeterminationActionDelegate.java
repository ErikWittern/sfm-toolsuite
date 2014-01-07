package edu.kit.sfm.configuration_set_determination.view;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import edu.kit.sfm.configuration_set_determination.controller.ConfigurationSetDeterminator;
import edu.kit.sfm.servicefeaturemodel.Service;

public class ConfigurationDeterminationActionDelegate extends ActionDelegate{
	
	protected EClass eClass;
	
	public ConfigurationDeterminationActionDelegate() {
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
		
		// Initialize ConfigurationSetDeterminator:
		ConfigurationSetDeterminator a = new ConfigurationSetDeterminator();
		int numSolutions = 0;
		try {
			numSolutions = a.getConfigurations(service);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		String message = "Please confirm that you want to save the " + numSolutions + " found configurations.";
		if (numSolutions > 1000){
			message += " WARNING: saving over 1000 solutions impacts performance of the SFM designer.";
		}
		
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		boolean result = MessageDialog.openConfirm(
			shell,
			"Confirm saving configurations",
			message
		);
		if (result){
			 // OK Button selected do something
			System.out.println("OK - Save...");
			try {
				service.eResource().save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			 // Cancel Button selected do something
			System.out.println("Configurations have NOT been saved.");
		}
	}
}
