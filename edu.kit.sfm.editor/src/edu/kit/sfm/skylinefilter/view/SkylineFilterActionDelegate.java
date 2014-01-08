package edu.kit.sfm.skylinefilter.view;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import choco.kernel.solver.variables.set.SetSubDomain;
import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.skylinefilter.controller.SkylineFilter;

public class SkylineFilterActionDelegate extends ActionDelegate{
	protected EClass eClass;
	
	public SkylineFilterActionDelegate() {
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
		
		int oldCount = service.getConfigurations().getConfigurations().size();
		
		SkylineFilter skylineFilter = new SkylineFilter();
		List<Configuration> skyline = skylineFilter.getSkylineConfigurations(service);
		
		String message = "Please confirm that you want to set the " + skyline.size() + 
				" skyline configurations to 'selected' and the other " + (oldCount - skyline.size()) + 
				" configurations to 'not selected'.";
				
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		boolean result = MessageDialog.openConfirm(
			shell,
			"Confirm selecting configurations",
			message
		);
		if (result){
			 // OK Button selected do something
			System.out.println("OK - Save...");
			for(Configuration conf : service.getConfigurations().getConfigurations()){
				if(!skyline.contains(conf)){
					conf.setSelected(false);
				} else {
					conf.setSelected(true);
				}
			}
			try {
				service.eResource().save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			 // Cancel Button selected do something
			System.out.println("Configurations have NOT been selected.");
		}
	}
}
