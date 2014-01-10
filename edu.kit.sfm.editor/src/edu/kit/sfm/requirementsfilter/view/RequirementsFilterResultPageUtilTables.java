package edu.kit.sfm.requirementsfilter.view;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import edu.kit.sfm.requirementsfilter.model.ReqFilterConfigurationDataType;

public class RequirementsFilterResultPageUtilTables {

	
/*TABLE ConfigurationsNotFulfillingRequirements */		

	public static void createConfigurationsNotFulfillingReqTable (Composite composite){
		

		
		//new table
	 	RequirementsFilterResultPage.configurationsNotFulfillingReqTableViewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	 	
	 	//create columns
	 	createConfigurationsNotFulfillingReqTablecolumns(RequirementsFilterResultPage.configurationsNotFulfillingReqTableViewer);
	 			 	
	    final Table table = RequirementsFilterResultPage.configurationsNotFulfillingReqTableViewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    RequirementsFilterResultPage.configurationsNotFulfillingReqTableViewer.setContentProvider(new ArrayContentProvider());
	    
	    // Layout the viewer
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 3;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.heightHint = 85;
	   RequirementsFilterResultPage.configurationsNotFulfillingReqTableViewer.getControl().setLayoutData(gridData);
	}
	
	 private static void createConfigurationsNotFulfillingReqTablecolumns( TableViewer viewer) {
		    String[] titles = { "Conf.", "Service Features", "Attributes","FulfillsReq ?","Not fulfilled SF","Not fulfilled ATTS"};
		    int[] bounds = { 50, 150, 100,80,100,100 };

		    // First column
		    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0,viewer);	   
		    col.setLabelProvider(new ColumnLabelProvider() {
		        @Override
		        public String getText(Object element) {
		          ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
		          return obj.getConfiguration().getName();
		        }
		      });
		    
		    // Second column
		    TableViewerColumn col1 = createTableViewerColumn(titles[1], bounds[1], 0,viewer);
		    col1.setLabelProvider(new ColumnLabelProvider() {
		        @Override
		        public String getText(Object element) {
		          ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
		          return RequirementsFilterResultPageUtil.convertServiceFeatureListToString(obj.getConfiguration().getServiceFeatures());
		        }
		      });
		    
		    // Third column
		    TableViewerColumn col2 = createTableViewerColumn(titles[2], bounds[2], 0,viewer);
		    col2.setLabelProvider(new ColumnLabelProvider() {
		        @Override
		        public String getText(Object element) {
		          ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
		          return RequirementsFilterResultPageUtil.convertAttributeTypeListToString(obj.getConfiguration().getAttributes());
		        }
		      });
		    // Fourth column
		    TableViewerColumn col3 = createTableViewerColumn(titles[3], bounds[3], 0,viewer);
		    col3.setLabelProvider(new ColumnLabelProvider() {
		        @Override
		        public String getText(Object element) {
		          ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
		          	if(obj.getFulfillsReq()){
		        	  return "YES";
		          	} else {
		        	  return "NO";
		          	}
		        }
		    });
		    // Fifth column
		    TableViewerColumn col4 = createTableViewerColumn(titles[4], bounds[4], 0,viewer);
		    col4.setLabelProvider(new ColumnLabelProvider() {
		        @Override
		        public String getText(Object element) {
		        	ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
			          return obj.getNotFullfilledServiceFeatureReq().toString();
		        }
		    });
		    // Sixth column
		    TableViewerColumn col5 = createTableViewerColumn(titles[5], bounds[5], 0,viewer);
		    col5.setLabelProvider(new ColumnLabelProvider() {
		        @Override
		        public String getText(Object element) {
		        	ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
			          return obj.getNotFulfilledAttributeTypeReq().toString();
		        }
		    });
		    
	 }
	
	
	
	
	
/*TABLE ConfigurationsFulfillingRequirements */	
	
	public static void createConfigurationsFulfillingReqTable (Composite composite){
		
		//new table
		 RequirementsFilterResultPage.configurationsFulfillingReqTableViewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
 
		 
	 	//create columns
	 	createConfigurationsFulfillingReqTablecolumns(RequirementsFilterResultPage.configurationsFulfillingReqTableViewer);
	 			 	
	    final Table table = RequirementsFilterResultPage.configurationsFulfillingReqTableViewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    RequirementsFilterResultPage.configurationsFulfillingReqTableViewer.setContentProvider(new ArrayContentProvider());
	    
	    // Layout the viewer
	    GridData gridData = new GridData();
	   gridData.verticalAlignment = GridData.FILL;
	   gridData.horizontalSpan = 3;
	   gridData.grabExcessHorizontalSpace = true;
	   gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.heightHint = 85;
	    RequirementsFilterResultPage.configurationsFulfillingReqTableViewer.getControl().setLayoutData(gridData); 
	    
}

	
	private static void createConfigurationsFulfillingReqTablecolumns(TableViewer myTableViewer){
		
		//settings
	 	String[] titles = { "Conf.", "Service Features", "Attributes","FulfillsReq ?"};
	    int[] bounds = { 50, 150, 100,80 };
		
		/*columns*/
 		// [1]
 		TableViewerColumn firstColumn = createTableViewerColumn(titles[0], bounds[0], 0,myTableViewer);	   
 		firstColumn.setLabelProvider(new ColumnLabelProvider() {
 			@Override
 			public String getText(Object element) {
 				ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
 			return obj.getConfiguration().getName();
 			}
 		});
	    // [2]
	    TableViewerColumn secondColumn = createTableViewerColumn(titles[1], bounds[1], 1,myTableViewer);
	    secondColumn.setLabelProvider(new ColumnLabelProvider() {
	        @Override
	        public String getText(Object element) {
	          ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
	          return RequirementsFilterResultPageUtil.convertServiceFeatureListToString(obj.getConfiguration().getServiceFeatures());
	        }
	      });
	    
	    // [3]
	    TableViewerColumn thirdColumn = createTableViewerColumn(titles[2], bounds[2], 2,myTableViewer);
	    thirdColumn.setLabelProvider(new ColumnLabelProvider() {
	        @Override
	        public String getText(Object element) {
	          ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
	          return RequirementsFilterResultPageUtil.convertAttributeTypeListToString(obj.getConfiguration().getAttributes());
	        }
	      });
	    // [4]
	    TableViewerColumn fourthColumn = createTableViewerColumn(titles[3], bounds[3], 3,myTableViewer);
	    fourthColumn.setLabelProvider(new ColumnLabelProvider() {
	        @Override
	        public String getText(Object element) {
	          ReqFilterConfigurationDataType obj = (ReqFilterConfigurationDataType) element;
	          	if(obj.getFulfillsReq()){
	        	  return "YES";
	          	} else {
	        	  return "NO";
	          	}
	        }
	    });
	}
	

	
	
/*procedures to construct tables*/	
	
	  private static TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber, TableViewer myViewer) {
		    final TableViewerColumn viewerColumn = new TableViewerColumn(myViewer,
		        SWT.NONE);
		    final TableColumn column = viewerColumn.getColumn();
		    column.setText(title);
		    column.setWidth(bound);
		    column.setResizable(true);
		    column.setMoveable(true);
		    return viewerColumn;
		  }
	
	
}
