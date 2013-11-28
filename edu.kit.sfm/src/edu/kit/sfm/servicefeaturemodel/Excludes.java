/**
 */
package edu.kit.sfm.servicefeaturemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Excludes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Excludes#getServiceFeature <em>Service Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getExcludes()
 * @model
 * @generated
 */
public interface Excludes extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Feature</em>' reference.
	 * @see #setServiceFeature(ServiceFeature)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getExcludes_ServiceFeature()
	 * @model required="true"
	 * @generated
	 */
	ServiceFeature getServiceFeature();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Excludes#getServiceFeature <em>Service Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Feature</em>' reference.
	 * @see #getServiceFeature()
	 * @generated
	 */
	void setServiceFeature(ServiceFeature value);

} // Excludes
