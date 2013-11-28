/**
 */
package edu.kit.sfm.servicefeaturemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Service#getServiceFeatureDiagram <em>Service Feature Diagram</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Service#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Service#getId <em>Id</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Service#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Service#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Service#getAttributeTypes <em>Attribute Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getService()
 * @model
 * @generated
 */
public interface Service extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Feature Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Feature Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Feature Diagram</em>' containment reference.
	 * @see #setServiceFeatureDiagram(ServiceFeatureDiagram)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getService_ServiceFeatureDiagram()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ServiceFeatureDiagram getServiceFeatureDiagram();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Service#getServiceFeatureDiagram <em>Service Feature Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Feature Diagram</em>' containment reference.
	 * @see #getServiceFeatureDiagram()
	 * @generated
	 */
	void setServiceFeatureDiagram(ServiceFeatureDiagram value);

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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getService_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Service#getDescription <em>Description</em>}' attribute.
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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getService_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Service#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getService_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Service#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference.
	 * @see #setConfigurations(Configurations)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getService_Configurations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Configurations getConfigurations();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Service#getConfigurations <em>Configurations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configurations</em>' containment reference.
	 * @see #getConfigurations()
	 * @generated
	 */
	void setConfigurations(Configurations value);

	/**
	 * Returns the value of the '<em><b>Attribute Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Types</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Types</em>' containment reference.
	 * @see #setAttributeTypes(AttributeTypes)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getService_AttributeTypes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AttributeTypes getAttributeTypes();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.Service#getAttributeTypes <em>Attribute Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Types</em>' containment reference.
	 * @see #getAttributeTypes()
	 * @generated
	 */
	void setAttributeTypes(AttributeTypes value);

} // Service
