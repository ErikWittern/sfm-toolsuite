package edu.kit.sfm.requirementsfilterweighted.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import edu.kit.sfm.requirementsfilterweighted.controller.WeightedRequirementsFilter;
import edu.kit.sfm.requirementsfilterweighted.model.RequirementFulfillment;

public class ResultsRequirementsPage extends WizardPage {
	
	ArrayList<RequirementFulfillment> fulfillments;
	int fulfillCompletely = 0;
	int fulfillPartly = 0;
	int fulfillNot = 0;
	
	/**
	 * Constructor
	 * @param pageName
	 */
	protected ResultsRequirementsPage(String pageName) {
		super(pageName);
		setTitle("Results of requirements filtering");
		setMessage("");
	} 
	
	
	/**
	 * Creates the layout for the page
	 * @param parent
	 */
	public void createControl(Composite parent) {
		
		filterRequirements();
		getFulfillmentNumbers();
		
		// Create composite to hold the widgets:
		Composite composite = new Composite(parent, SWT.NONE);
		
		// Set layout:
		GridLayout gridLayout = new GridLayout(1, true);
		composite.setLayout(gridLayout);
		
		/**
		 * Results table
		 */
		setMessage(fulfillCompletely + " configurations fulfill requirements completely.\n" 
				+ fulfillPartly + " configurations fulfill requirements partly.\n" 
				+ fulfillNot + " configurations do not fulfill requirements.");
		
		// Create Table Viewer:
		TableViewer resultsTableViewer = new TableViewer(composite, SWT.NONE);
		Table resultsTable = resultsTableViewer.getTable();
		// Make column headers and lines between rows visible:
		resultsTable.setHeaderVisible(true);
		resultsTable.setLinesVisible(true);
		// Align with GridData:
		GridData resultsGridData = new GridData(SWT.FILL, SWT.TOP, true, true);
		resultsTable.setLayoutData(resultsGridData);
		
		// Create columns:
		createResultsColumns(composite, resultsTableViewer);
		
		// Set content provider:		
		resultsTableViewer.setContentProvider(new ArrayContentProvider());
		
		resultsTableViewer.setInput(fulfillments);

		
		// Set control of the wizard page:
		setControl(composite);
	
	}

	
	/**
	 * Creates the columns for the table illustrating the feature requirements.
	 * @param parent
	 * @param tableViewer
	 */
	private void createResultsColumns(Composite parent, TableViewer tableViewer) {
		// title and size of columns:
		String[] titles = { "Configuration", "Fulfillment", "Feature requirements gaps", "Attribute type requirements gaps" };
		int[] bounds = { 120, 80, 200, 200 };
		
		TableViewerColumn confColumn = createTableViewerColumn(tableViewer, titles[0], bounds[0], 0);
		confColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				RequirementFulfillment ful = (RequirementFulfillment) element;
				return ful.getConfiguration().getName();
			}
		});	
		
		TableViewerColumn fulfillmentColumn = createTableViewerColumn(tableViewer, titles[1], bounds[1], 1);
		fulfillmentColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				RequirementFulfillment ful = (RequirementFulfillment) element;
				return Double.toString(ful.getDegOfFulfillment());
			}
		});
		
		TableViewerColumn featureReqColumn = createTableViewerColumn(tableViewer, titles[2], bounds[2], 2);
		featureReqColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				RequirementFulfillment ful = (RequirementFulfillment) element;
				return ful.getFeatureReqSummary();
			}			
		});
		
		TableViewerColumn attReqColumn = createTableViewerColumn(tableViewer, titles[3], bounds[3], 3);
		attReqColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				RequirementFulfillment ful = (RequirementFulfillment) element;
				return ful.getAttributeReqSummary();
			}			
		});
	}
	
	
	/**
	 * Helper method to create a column for the given information
	 * @param viewer
	 * @param title
	 * @param bound
	 * @param colNumber
	 * @return
	 */
	private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}
	
	
	/**
	 * Deactivates the finish button
	 * @return
	 */
	public boolean canFinish(){
		return false;
	}
	
	
	/**
	 * Perform the actual fulfillment
	 */
	public void filterRequirements(){
		// Create and apply requirements filter:
		WeightedRequirementsFilter filter = new WeightedRequirementsFilter();
		fulfillments = filter.filterWeightedRequirements(
				((WeightedRequirementsFilterWizard)getWizard()).getService(), 
				((WeightedRequirementsFilterWizard)getWizard()).getFeatureReqList(), 
				((WeightedRequirementsFilterWizard)getWizard()).getAttReqList());
		// Sort results:
		Collections.sort(fulfillments, new Comparator<RequirementFulfillment>() {
			@Override
			public int compare(RequirementFulfillment rf1, RequirementFulfillment rf2){
				return Double.compare(rf2.getDegOfFulfillment(), rf1.getDegOfFulfillment());
			}
		});
	}
	
	
	/**
	 * Determine numbers of fulfillment
	 */
	public void getFulfillmentNumbers(){
		for(RequirementFulfillment ful : fulfillments){
			if(ful.getDegOfFulfillment() == 1.0){
				fulfillCompletely++;
			} else if (1.0 > ful.getDegOfFulfillment() && ful.getDegOfFulfillment() > 0.0){
				fulfillPartly++;
			} else if (ful.getDegOfFulfillment() == 0.0){
				fulfillNot++;
			}
		}
	}
}