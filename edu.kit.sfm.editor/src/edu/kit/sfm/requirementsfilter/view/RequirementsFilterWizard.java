package edu.kit.sfm.requirementsfilter.view;

import org.eclipse.jface.wizard.Wizard;

import edu.kit.sfm.requirementsfilter.model.ReqFilterDataType;

public class RequirementsFilterWizard extends Wizard {
	
	//variables
	private RequirementsFilterConfigurationPage configPage;
	private RequirementsFilterResultPage resultPage;
    private ReqFilterDataType reqFilterData = new ReqFilterDataType();
	
	/**
	 * Constructor
	 */
	public RequirementsFilterWizard() {
		setWindowTitle("Configure requriements filter");
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
		configPage = new RequirementsFilterConfigurationPage("Configure requirements filter",reqFilterData);
		resultPage = new RequirementsFilterResultPage("Requirementsfiltering - Results",reqFilterData);
		addPage(configPage);	
		addPage(resultPage);
	}
}
