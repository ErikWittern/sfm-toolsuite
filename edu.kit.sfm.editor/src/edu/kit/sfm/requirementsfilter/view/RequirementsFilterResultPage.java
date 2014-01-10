package edu.kit.sfm.requirementsfilter.view;

import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;

import edu.kit.sfm.requirementsfilter.controller.RequirementsFilter;
import edu.kit.sfm.requirementsfilter.model.ReqFilterDataType;
import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.utils.SFMConfigurationsOperations;
import edu.kit.sfm.utils.SFMPersistencyOperations;

public class RequirementsFilterResultPage extends WizardPage {
	
	//private variables
		//common data type of all wizard pages
		private ReqFilterDataType reqFilterData;
		
		//output text
		public static TableViewer configurationsFulfillingReqTableViewer;
		public static TableViewer configurationsNotFulfillingReqTableViewer;
		public static  Label confMatchReq_data;
		public static  Label confNotMatchReq_data;
		public static Label requiredSF_data;
		public static Label requiredATTS_data;
	
	/*Constructor*/
	public RequirementsFilterResultPage(String pageName, ReqFilterDataType reqFilterData) {
		super(pageName);
		setTitle("Requirementsfiltering - Results");
		setMessage("");	
		this.reqFilterData = reqFilterData;
	
	}

	
	//create UI
	public void createControl(Composite parent) {
		
		setPageComplete(false);
		
		/*Create UI template*/
			// Create composite to hold the widgets:
			Composite composite = new Composite(parent, SWT.NONE);
		
			// Create layout for wizard-page
			GridLayout grid = new GridLayout(1, false);
			composite.setLayout(grid);
						
			//create UI components
			createRequirementsGroupUI(composite);
			createResultsGroupUI(composite);
	
		/*UI complete*/	
						
			setControl(composite);
		
		
	}
	
	private void createRequirementsGroupUI(Composite composite){
		
		//create group element
		Group groupRequirements = new Group(composite, SWT.SHADOW_ETCHED_OUT);
		groupRequirements.setLayout(new GridLayout(2, false));
		groupRequirements.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		groupRequirements.setBackground(groupRequirements.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		groupRequirements.setText("Requirements");
		groupRequirements.setFont(new Font(groupRequirements.getDisplay(), "Tahoma", 10, SWT.BOLD));
		
	//required service feature
		Label requiredSF_text = new Label(groupRequirements, SWT.NONE);
		requiredSF_text.setText(" Required Service Features: ");
		requiredSF_text.setBackground(requiredSF_text.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		requiredSF_data = new Label(groupRequirements, SWT.NONE);
		requiredSF_data.setText(" [1] ");
		requiredSF_data.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	
	//required ATTS
		Label requiredATTS_text = new Label(groupRequirements, SWT.NONE);
		requiredATTS_text.setText(" Required Attributes: ");
		requiredATTS_text.setBackground(requiredATTS_text.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		requiredATTS_data = new Label(groupRequirements, SWT.NONE);
		requiredATTS_data.setText(" [cost <= 10] ");
		requiredATTS_data.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	}
	
	private void createResultsGroupUI(Composite composite){
		
		/*create RESULT group UI*/

				//group element
				final Group groupResults = new Group(composite, SWT.SHADOW_ETCHED_IN);
				groupResults.setLayout(new GridLayout(3, false));
				groupResults.setText("Results");
				groupResults.setBackground(groupResults.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
				groupResults.setFont(new Font(groupResults.getDisplay(), "Tahoma", 10, SWT.BOLD));

				
				//configurations matching requirements
				
					Label greenBoxLabel = new Label(groupResults, SWT.NONE);
					greenBoxLabel.setText("     ");
					greenBoxLabel.setBackground(greenBoxLabel.getDisplay().getSystemColor(SWT.COLOR_GREEN));
					
					Label confMatchReq_text = new Label(groupResults, SWT.NONE);
					confMatchReq_text.setText(" Configurations matching requirements: ");
					confMatchReq_text.setBackground(confMatchReq_text.getDisplay().getSystemColor(SWT.COLOR_WHITE));
					
					confMatchReq_data = new Label(groupResults, SWT.NONE);	
					confMatchReq_data.setText("....X out of X configurations ");
					confMatchReq_data.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
					
					
					//table
					RequirementsFilterResultPageUtilTables.createConfigurationsFulfillingReqTable(groupResults);
					
				//configurations NOT matching requirements
				
					Label redBoxLabel = new Label(groupResults, SWT.NONE);
					redBoxLabel.setText("     ");
					redBoxLabel.setBackground(redBoxLabel.getDisplay().getSystemColor(SWT.COLOR_RED)); 
		
					Label confNotMatchReq_text = new Label(groupResults, SWT.NONE);
					confNotMatchReq_text.setText(" Configurations not matching requirements: ");
					confNotMatchReq_text.setBackground(confNotMatchReq_text.getDisplay().getSystemColor(SWT.COLOR_WHITE));
	
					confNotMatchReq_data = new Label(groupResults, SWT.NONE);					
					confNotMatchReq_data.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	
					//table
					RequirementsFilterResultPageUtilTables.createConfigurationsNotFulfillingReqTable(groupResults);
		
					//create button 'delete configurations '
						Button button = new Button(groupResults, SWT.PUSH);
						GridData myGridData = new GridData();
						myGridData.horizontalSpan = 3;
						button.setLayoutData(myGridData);
						button.setBounds(40, 50, 50, 20);
						button.setText("Delete configurations not matching requirements");
				    
						//listener
						Listener deleteConfigurationsListener = new Listener() {
							public void handleEvent(Event event) {
								//button pressed
								
								MessageBox messageBox = new MessageBox(groupResults.getDisplay().getActiveShell(), SWT.ICON_WARNING |SWT.YES| SWT.NO );
						        
						        messageBox.setText("Warning");
						        messageBox.setMessage("Do you really want to delete all configurations not matching requirements?");
						        int buttonID = messageBox.open();
						        switch(buttonID) {
						          case SWT.YES:
						        	  Service serviceModel = SFMPersistencyOperations.loadModelFromWorkspace(reqFilterData.getServiceModelName());
						        	  @SuppressWarnings("unchecked")
									List<Configuration> configurationsToDelete = (List<Configuration>) reqFilterData.getConfigurations(false, "PLAIN");
						        	  Integer deletedConfigurations = SFMConfigurationsOperations.deleteConfigurations(serviceModel,configurationsToDelete);
										
										MessageBox messageInfoBox = new MessageBox(groupResults.getDisplay().getActiveShell(),SWT.ICON_INFORMATION | SWT.OK);
										messageInfoBox.setText("Deletion complete.");
										messageInfoBox.setMessage(deletedConfigurations+  "   configurations were sucessfully deleted!");
										messageInfoBox.open();
										
								
						          case SWT.NO:
						            // does nothing ...
						        }
								
							}
						};
						button.addListener(SWT.Selection,deleteConfigurationsListener);
	}
	
	 
	 @Override
	    public void setVisible(boolean visible) {
	        super.setVisible(visible);
	        if (visible) {
	        	
	        	//load dynamic values into UI (textbox)
	        	reqFilterData.clearFilteringResults();
	        	reqFilterData = RequirementsFilter.filterRequirements(reqFilterData);
	        	RequirementsFilterResultPageUtil.printReqFilterResults(reqFilterData);
	        	setPageComplete(true);
	        }
	    }
	


}
