/**
 */
package edu.kit.sfm.servicefeaturemodel;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Feature Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getServiceFeatures <em>Service Features</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeatureDiagram()
 * @model
 * @generated
 */
public interface ServiceFeatureDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Features</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.sfm.servicefeaturemodel.ServiceFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Features</em>' containment reference list.
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeatureDiagram_ServiceFeatures()
	 * @model containment="true"
	 * @generated
	 */
	List<ServiceFeature> getServiceFeatures();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeatureDiagram_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeatureDiagram_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeatureDiagram_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // ServiceFeatureDiagram
