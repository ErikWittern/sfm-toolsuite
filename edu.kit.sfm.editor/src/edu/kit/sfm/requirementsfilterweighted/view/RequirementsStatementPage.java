package edu.kit.sfm.requirementsfilterweighted.view;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class RequirementsStatementPage extends WizardPage {
	
	/**
	 * Constructor
	 * @param pageName
	 */
	protected RequirementsStatementPage(String pageName) {
		super(pageName);
		setTitle("Requirements statement");
		setMessage("Please state your requirements below");
	} 
	
	
	/**
	 * Creates the layout for the page
	 * @param parent
	 */
	public void createControl(Composite parent) {
		
		setPageComplete(false);
		
		// Create composite to hold the widgets:
		Composite composite = new Composite(parent, SWT.NONE);
		
		// Create layout for wizard-page
		GridLayout grid = new GridLayout(1, false);
		composite.setLayout(grid);
		
		// Create Table Viewer for feature requirements:
		TableViewer featureReqTableViewer = new TableViewer(parent, SWT.NONE);
		Table featureReqTable = featureReqTableViewer.getTable();
		// Make column headers and lines between rows visible:
		featureReqTable.setHeaderVisible(true);
		featureReqTable.setLinesVisible(true);
		
		// Set content provider:		
		//featureReqTableViewer.setContentProvider(provider);
			
		// Set TableViewerColumn per column:
		TableViewerColumn featureNameViewerColumn = new TableViewerColumn(featureReqTableViewer, SWT.NONE);
		featureNameViewerColumn.getColumn().setText("Feature name");
		featureNameViewerColumn.getColumn().setWidth(100);
			
		/*UI complete*/		
		setControl(composite);
	
	}

	
	/**
	 * Deactivates the finish button
	 * @return
	 */
	public boolean canFinish(){
		return false;
	}
	
	
	/**
	 * Determines whether page is validated
	 * @return boolean
	 */
	private boolean validatePage() {
		return false;
	}
}