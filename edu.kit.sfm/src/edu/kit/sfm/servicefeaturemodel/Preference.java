/**
 */
package edu.kit.sfm.servicefeaturemodel;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Preference#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Preference#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Preference#getValue <em>Value</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Preference#getStakeholderGroup <em>Stakeholder Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getPreference()
 * @model
 * @generated
 */
public interface Preference extends EObject {
	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getPreference_CreationDate()
	 * @model
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Preference#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getPreference_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Preference#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getPreference_Value()
	 * @model
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Preference#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * Returns the value of the '<em><b>Stakeholder Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholder Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholder Group</em>' attribute.
	 * @see #setStakeholderGroup(String)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getPreference_StakeholderGroup()
	 * @model
	 * @generated
	 */
	String getStakeholderGroup();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Preference#getStakeholderGroup <em>Stakeholder Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stakeholder Group</em>' attribute.
	 * @see #getStakeholderGroup()
	 * @generated
	 */
	void setStakeholderGroup(String value);

} // Preference
