package edu.kit.sfm.configuration_set_determination.view;

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

import edu.kit.sfm.configuration_set_determination.controller.ConfiugrationSetDeterminatorPerformance;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.utils.TimeTracker;

public class ConfigurationDeterminationActionDelegatePerformance extends ActionDelegate{
	
	protected EClass eClass;
	
	public ConfigurationDeterminationActionDelegatePerformance() {
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
				
				System.out.println("Java Analyzer Performance: " + service.getName());
				
				// Initialize analyzer:
				ConfiugrationSetDeterminatorPerformance a = new ConfiugrationSetDeterminatorPerformance();
				for(int i = 0; i < runs ; i++){
					TimeTracker ttracker;
					try {
						ttracker = a.getConfigurations(service);
						System.out.println(ttracker.toStringDataRow());
					} catch (IllegalArgumentException e) {
						System.out.println(e);
					}
				}
				
			}catch(NumberFormatException e){
				MessageDialog.openError(shell, "Error", "The provided number is not an integer. Please try again.");
			}
		}
	}
}
