package edu.kit.sfm.requirementsfilterweighted.view;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import edu.kit.sfm.requirementsfilterweighted.model.AttributeTypeRequirement;
import edu.kit.sfm.requirementsfilterweighted.model.FeatureRequirement;

public class ReviewRequirementsPage extends WizardPage {
	
	/**
	 * Constructor
	 * @param pageName
	 */
	protected ReviewRequirementsPage(String pageName) {
		super(pageName);
		setTitle("Review requirements");
		setMessage("Please review the requirements extracted from the SFM below.");
	} 
	
	
	/**
	 * Creates the layout for the page
	 * @param parent
	 */
	public void createControl(Composite parent) {
		
		// Create composite to hold the widgets:
		Composite composite = new Composite(parent, SWT.NONE);
		
		// Set layout:
		GridLayout gridLayout = new GridLayout(1, true);
		composite.setLayout(gridLayout);
		
		/**
		 * Feature requirements:
		 */
		Label featureReqLabel = new Label(composite, SWT.NONE);
		featureReqLabel.setText("Feature requirements:");
		GridData featureLabelGridData = new GridData(SWT.LEFT, SWT.TOP, true, false);
		featureReqLabel.setLayoutData(featureLabelGridData);
		
		// Create Table Viewer for feature requirements:
		TableViewer featureReqTableViewer = new TableViewer(composite, SWT.NONE);
		Table featureReqTable = featureReqTableViewer.getTable();
		// Make column headers and lines between rows visible:
		featureReqTable.setHeaderVisible(true);
		featureReqTable.setLinesVisible(true);
		// Align with GridData:
		GridData featureGridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		featureReqTable.setLayoutData(featureGridData);
		
		// Create columns:
		createFeatureReqColumns(composite, featureReqTableViewer);
		
		// Set content provider:		
		featureReqTableViewer.setContentProvider(new ArrayContentProvider());
		
		featureReqTableViewer.setInput(((WeightedRequirementsFilterWizard)getWizard()).getFeatureReqList());
		
		/**
		 * Attribute type requirements:
		 */
		Label attReqLabel = new Label(composite, SWT.NONE);
		attReqLabel.setText("Attribute type requirements:");
		GridData attReqLabelGridData = new GridData(SWT.LEFT, SWT.TOP, true, false);
		attReqLabel.setLayoutData(attReqLabelGridData);
		
		// Create Table Viewer for feature requirements:
		TableViewer attReqTableViewer = new TableViewer(composite, SWT.NONE);
		Table attReqTable = attReqTableViewer.getTable();
		// Make column headers and lines between rows visible:
		attReqTable.setHeaderVisible(true);
		attReqTable.setLinesVisible(true);
		// Align with GridData:
		GridData attGridData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
		attReqTable.setLayoutData(attGridData);
				
		// Create columns:
		createAttReqColums(composite, attReqTableViewer);
				
		// Set content provider:		
		attReqTableViewer.setContentProvider(new ArrayContentProvider());
				
		attReqTableViewer.setInput(((WeightedRequirementsFilterWizard)getWizard()).getAttReqList());
		
		
		// Set control of the wizard page:
		setControl(composite);
	
	}

	
	/**
	 * Creates the columns for the table illustrating the feature requirements.
	 * @param parent
	 * @param tableViewer
	 */
	private void createFeatureReqColumns(Composite parent, TableViewer tableViewer) {
		// title and size of columns:
		String[] titles = { "Feature name", "Type", "Requirement weight" };
		int[] bounds = { 200, 200, 200 };
		
		TableViewerColumn viewerNameColumn = createTableViewerColumn(tableViewer, titles[0], bounds[0], 0);
		viewerNameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				FeatureRequirement req = (FeatureRequirement) element;
				return req.getFeatureName();
			}
		});
				
		
		TableViewerColumn viewerTypeColumn = createTableViewerColumn(tableViewer, titles[1], bounds[1], 1);
		viewerTypeColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				FeatureRequirement req = (FeatureRequirement) element;
				return req.getFeatureType().toString();
			}
		});
		
		
		TableViewerColumn viewerWeightColumn = createTableViewerColumn(tableViewer, titles[2], bounds[2], 2);
		viewerWeightColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				FeatureRequirement req = (FeatureRequirement) element;
				return Double.toString(req.getWeight());
			}			
		});
	}
	
	
	/**
	 * Creates the columns for the table illustrating the attribute type requirements.
	 * @param parent
	 * @param tableViewer
	 */
	private void createAttReqColums(Composite parent, TableViewer tableViewer) {
		// title and size of columns:
		String[] titles = { "Attribute type", "Comparator", "Required value", "Requirement weight" };
		int[] bounds = { 150, 150, 150, 150 };
		
		TableViewerColumn viewerNameColumn = createTableViewerColumn(tableViewer, titles[0], bounds[0], 0);
		viewerNameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				AttributeTypeRequirement req = (AttributeTypeRequirement) element;
				return req.getAttName();
			}
		});
		
		TableViewerColumn viewerComparatorColumn = createTableViewerColumn(tableViewer, titles[1], bounds[1], 1);
		viewerComparatorColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				AttributeTypeRequirement req = (AttributeTypeRequirement) element;
				return req.getComparator().toString();
			}
		});
		
		TableViewerColumn viewerValueColumn = createTableViewerColumn(tableViewer, titles[2], bounds[2], 2);
		viewerValueColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				AttributeTypeRequirement req = (AttributeTypeRequirement) element;
				return Double.toString(req.getValue());
			}			
		});
		
		TableViewerColumn viewerWeightColumn = createTableViewerColumn(tableViewer, titles[3], bounds[3], 3);
		viewerWeightColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				AttributeTypeRequirement req = (AttributeTypeRequirement) element;
				return Double.toString(req.getWeight());
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
}