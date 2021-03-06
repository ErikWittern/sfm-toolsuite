package edu.kit.sfm.skylinefilter.view;

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

import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.skylinefilter.controller.SkylineFilter;
import edu.kit.sfm.utils.NumberOfPerformanceRunsDialog;

public class SkylineFilterActionDelegatePerformanceBNL extends ActionDelegate{
	protected EClass eClass;
	
	public SkylineFilterActionDelegatePerformanceBNL() {
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
				// Get current model's service:
				ResourceSet resourceSet = new ResourceSetImpl();
				URI resourceURI = EditUIUtil.getURI(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
						.getEditorInput());
				Resource resource = resourceSet.getResource(resourceURI, true);
				Service service = (Service) resource.getContents().get(0);
				
				System.out.println("Skyline (BNL) performance for service: " + service.getName());
				
				for(int i = 0; i < runs ; i++){
					long startTime = System.currentTimeMillis();
					SkylineFilter skylineFilter = new SkylineFilter();
					skylineFilter.getSkylineConfigurationsBNL(service);
					long endTime = System.currentTimeMillis();
					System.out.println(endTime - startTime);
				}
				
			}catch(NumberFormatException e){
				MessageDialog.openError(shell, "Error", "The provided number is not an integer. Please try again.");
			}
		}
		
	}
}
