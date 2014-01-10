package edu.kit.sfm.requirementsfilterweighted.view;

import org.eclipse.jface.wizard.Wizard;

public class WeightedRequirementsFilterWizard extends Wizard {
	
	/**
	 * Variables to be used throughout the wizard:
	 */
	private RequirementsStatementPage statementPage;
	
	/**
	 * Constructor
	 */
	public WeightedRequirementsFilterWizard() {
		setWindowTitle("Weighted requirements filter");
	}

	
	/**
	 * performFinish
	 */
	public boolean performFinish() {	
		return true;
	}

	/**
	 * performCancel
	 */
	public boolean performCancel() {
		return true;
	}

	/**
	 * addPages
	 */
	public void addPages() {
		statementPage = new RequirementsStatementPage("Configure requirements filter");
		addPage(statementPage);
	}
}
