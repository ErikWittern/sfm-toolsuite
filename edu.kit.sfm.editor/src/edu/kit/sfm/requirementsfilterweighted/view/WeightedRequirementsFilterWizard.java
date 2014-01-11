package edu.kit.sfm.requirementsfilterweighted.view;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import edu.kit.sfm.requirementsfilterweighted.model.AttributeTypeRequirement;
import edu.kit.sfm.requirementsfilterweighted.model.FeatureRequirement;
import edu.kit.sfm.servicefeaturemodel.Service;

public class WeightedRequirementsFilterWizard extends Wizard {
	
	/**
	 * Variables to be used throughout the wizard:
	 */
	private ReviewRequirementsPage reviewPage;
	private ResultsRequirementsPage resultsPage;
	private List<FeatureRequirement> featureReqList;
	private List<AttributeTypeRequirement> attReqList;
	private Service service;
	
	/**
	 * Constructor
	 */
	public WeightedRequirementsFilterWizard(Service service, List<FeatureRequirement> featureReqList, List<AttributeTypeRequirement> attReqList) {
		this.featureReqList = featureReqList;
		this.attReqList = attReqList;
		this.service = service;
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
		reviewPage = new ReviewRequirementsPage("Configure requirements filter");
		resultsPage = new ResultsRequirementsPage("Review results");
		addPage(reviewPage);
		addPage(resultsPage);
	}
	
	/**
	 * Getters and setters
	 */
	public List<FeatureRequirement> getFeatureReqList() {
		return featureReqList;
	}


	public void setFeatureReqList(List<FeatureRequirement> featureReqList) {
		this.featureReqList = featureReqList;
	}


	public List<AttributeTypeRequirement> getAttReqList() {
		return attReqList;
	}


	public void setAttReqList(List<AttributeTypeRequirement> attReqList) {
		this.attReqList = attReqList;
	}
	
	public Service getService(){
		return service;
	}
}
