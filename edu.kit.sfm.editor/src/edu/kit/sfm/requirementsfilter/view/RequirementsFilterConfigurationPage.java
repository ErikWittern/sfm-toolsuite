/*
 * Project: Cockpit Service Feature Model designer
 * Author:  Erik Wittern
 * Copyright (c): KIT, 2011
 */
package edu.kit.sfm.requirementsfilter.view;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

import edu.kit.sfm.requirementsfilter.model.ReqFilterDataType;
import edu.kit.sfm.utils.SFMConfigurationsOperations;

public class RequirementsFilterConfigurationPage extends WizardPage {
		
	/*private variables*/
	private ReqFilterDataType reqFilterData;	

	
	/**
	 * Constructor
	 * @param pageName
	 */
	protected RequirementsFilterConfigurationPage(String pageName,ReqFilterDataType reqFilterData) {
		super(pageName);
		setTitle("Configure requirements filter");
		setMessage("Use this page to configure the requirements filtering");
		this.reqFilterData = reqFilterData;
	} 
	

	
	public void createControl(Composite parent) {
		
		setPageComplete(false);
		
		/*Create UI template*/
		
			// Create composite to hold the widgets:
			Composite composite = new Composite(parent, SWT.NONE);
		
			// Create layout for wizard-page
			GridLayout grid = new GridLayout(1, false);
			composite.setLayout(grid);
		
			// Requirements selection elements:
			final Label requirementsSelectionLabel = new Label(composite, SWT.LEFT);
			requirementsSelectionLabel.setText("Select the Requirements Model here:");
			GridData reqLabelData = new GridData();
			reqLabelData.horizontalAlignment = GridData.FILL;
			requirementsSelectionLabel.setLayoutData(reqLabelData);
		
			final org.eclipse.swt.widgets.List requirementsModelList = new org.eclipse.swt.widgets.List(
					composite, SWT.MULTI | SWT.SINGLE | SWT.BORDER
							| SWT.V_SCROLL | SWT.H_SCROLL);
			GridData reqListData = new GridData();
			reqListData.horizontalAlignment = GridData.FILL;
			reqListData.grabExcessHorizontalSpace = true;
			requirementsModelList.setLayoutData(reqListData);
		
			// Service selection elements:
			final Label serviceSelectionLabel = new Label(composite, SWT.LEFT);
			serviceSelectionLabel.setText("Select the Service Model here:");
			GridData serLabelData = new GridData();
			serLabelData.horizontalAlignment = GridData.FILL;
			serviceSelectionLabel.setLayoutData(serLabelData);
		
			final org.eclipse.swt.widgets.List serviceModelList = new org.eclipse.swt.widgets.List(
					composite, SWT.MULTI | SWT.SINGLE | SWT.BORDER
							| SWT.V_SCROLL | SWT.H_SCROLL);		
			GridData serListData = new GridData();
			serListData.horizontalAlignment = GridData.FILL;
			serListData.grabExcessHorizontalSpace = true;
			serviceModelList.setLayoutData(serListData);
		
		/*fill UI with data()*/
		
			// Get list of all files in the "template" folder:
			String projectName = "";
			IEditorPart editorPart = (IEditorPart)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if (editorPart != null) {
				IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
				IFile file = input.getFile();
				IProject activeProject = file.getProject();
				projectName = activeProject.getName();
			}
			
			String path = Platform.getLocation().toString() + "/" + projectName;
		
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
		
			if (listOfFiles != null && listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					// Get each file's extension:
					String fileExtension = listOfFiles[i].toString().substring(
							listOfFiles[i].toString().lastIndexOf("."));
					// Add to service model and requirements model list:
					if (fileExtension.equals(".sfm")) {
						Integer numberOfconfigurations = SFMConfigurationsOperations.getNumberOfConfigurations((listOfFiles[i].getName()));
						serviceModelList.add(listOfFiles[i].getName()+"  -  "+numberOfconfigurations + "  configurations");
						requirementsModelList.add(listOfFiles[i].getName()+"  -  "+numberOfconfigurations + "  configurations");
					}
				}

		/*handle/trigger events upon selecting a list item*/
				
			// Add listener to the lists:
				
			//serviceModel list
				Listener serviceModelListListener = new Listener() {
					public void handleEvent(Event event) {
						String[] items = serviceModelList.getSelection();
						if(items.length != 0 && items[0] != null && !items[0].equals("")){
							
							//extract file name
								//string is a substring of the current selected string
								//starting from first character (0) to the position of file extension + length of file extension
							String serviceModel = items[0].toString().substring(0,items[0].toString().lastIndexOf(".")+4);
							
							serviceSelectionLabel.setText("You selected Service Model: " + serviceModel);
							reqFilterData.setServiceModelName(serviceModel);
						
						} else {
							serviceSelectionLabel.setText("Select the Service Model here:");
							reqFilterData.setServiceModelName("");
						}
						validatePage();
						
					}
				};
			serviceModelList.addListener(SWT.Selection, serviceModelListListener);
			
			//requirementsModel list
				Listener requirementsModelListListener = new Listener() {
					public void handleEvent(Event event) {
						String[] items = requirementsModelList.getSelection();
						if(items.length != 0 && items[0] != null && !items[0].equals("")){
							
							//extract file name
							//string is a substring of the current selected string
							//starting from first character (0) to the position of file extension + length of file extension
							String reqModel = items[0].toString().substring(0,items[0].toString().lastIndexOf(".")+4);
	
							requirementsSelectionLabel.setText("You selected Requirements Model: " + reqModel);
							reqFilterData.setRequirementsModelName(reqModel);
						} else {
							requirementsSelectionLabel.setText("Select the Requirements Model here:");
							reqFilterData.setRequirementsModelName("");
						}
						validatePage();
			
					}
				};
				requirementsModelList.addListener(SWT.Selection, requirementsModelListListener);
		}
			
			
		/*UI complete*/		
		setControl(composite);
	
	}

	//deactivate finish button
	public boolean canFinish(){
		return false;
	}
		
	/**
	 * validate();
	 * @return boolean
	 */
	
	
	private boolean validatePage() {

		boolean finishedSelection = (reqFilterData.getServiceModelName() != null && reqFilterData.getServiceModelName() != "")
				&& (reqFilterData.getRequirementsModelName() != null && reqFilterData.getRequirementsModelName() != "");
		
		
		if(finishedSelection){
			boolean hasConfigurations = 
					(SFMConfigurationsOperations.emptyConfigurations(reqFilterData.getRequirementsModelName()) != true)
					&& (SFMConfigurationsOperations.emptyConfigurations(reqFilterData.getServiceModelName())!= true);
			
			if(hasConfigurations){
				setErrorMessage(null);
				setPageComplete(true);
			} else {
				setErrorMessage("Please determine service configurations for your selected requirements and service model.");
				setPageComplete(false);
			}
			
		} else {
		
			setErrorMessage("Please select requirements and service model.");
			setPageComplete(false);
		}
		return finishedSelection;
	}
}