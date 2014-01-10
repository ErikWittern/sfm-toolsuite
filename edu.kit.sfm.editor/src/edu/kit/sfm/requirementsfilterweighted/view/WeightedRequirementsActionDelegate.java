package edu.kit.sfm.requirementsfilterweighted.view;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

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
		WeightedRequirementsFilterWizard wizard = new WeightedRequirementsFilterWizard();
		WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
		dialog.open();
	}
}
