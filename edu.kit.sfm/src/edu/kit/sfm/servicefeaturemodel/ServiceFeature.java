/**
 */
package edu.kit.sfm.servicefeaturemodel;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getGroupRelationship <em>Group Relationship</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getRequires <em>Requires</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getServiceFeatures <em>Service Features</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getMinAmount <em>Min Amount</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getMaxAmount <em>Max Amount</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#isMapsToGSMElement <em>Maps To GSM Element</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getAssociatedGSMElement <em>Associated GSM Element</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getId <em>Id</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#isRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature()
 * @model abstract="true"
 * @generated
 */
public interface ServiceFeature extends EObject {
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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getName <em>Name</em>}' attribute.
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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.sfm.servicefeaturemodel.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	List<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Group Relationship</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Relationship</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Relationship</em>' containment reference.
	 * @see #setGroupRelationship(GroupRelationship)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_GroupRelationship()
	 * @model containment="true"
	 * @generated
	 */
	GroupRelationship getGroupRelationship();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getGroupRelationship <em>Group Relationship</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Relationship</em>' containment reference.
	 * @see #getGroupRelationship()
	 * @generated
	 */
	void setGroupRelationship(GroupRelationship value);

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.sfm.servicefeaturemodel.Requires}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' containment reference list.
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_Requires()
	 * @model containment="true"
	 * @generated
	 */
	List<Requires> getRequires();

	/**
	 * Returns the value of the '<em><b>Excludes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.sfm.servicefeaturemodel.Excludes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excludes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excludes</em>' containment reference list.
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_Excludes()
	 * @model containment="true"
	 * @generated
	 */
	List<Excludes> getExcludes();

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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_ServiceFeatures()
	 * @model containment="true"
	 * @generated
	 */
	List<ServiceFeature> getServiceFeatures();

	/**
	 * Returns the value of the '<em><b>Min Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Amount</em>' attribute.
	 * @see #setMinAmount(int)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_MinAmount()
	 * @model
	 * @generated
	 */
	int getMinAmount();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getMinAmount <em>Min Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Amount</em>' attribute.
	 * @see #getMinAmount()
	 * @generated
	 */
	void setMinAmount(int value);

	/**
	 * Returns the value of the '<em><b>Max Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Amount</em>' attribute.
	 * @see #setMaxAmount(int)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_MaxAmount()
	 * @model
	 * @generated
	 */
	int getMaxAmount();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getMaxAmount <em>Max Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Amount</em>' attribute.
	 * @see #getMaxAmount()
	 * @generated
	 */
	void setMaxAmount(int value);

	/**
	 * Returns the value of the '<em><b>Maps To GSM Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps To GSM Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps To GSM Element</em>' attribute.
	 * @see #setMapsToGSMElement(boolean)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_MapsToGSMElement()
	 * @model
	 * @generated
	 */
	boolean isMapsToGSMElement();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#isMapsToGSMElement <em>Maps To GSM Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maps To GSM Element</em>' attribute.
	 * @see #isMapsToGSMElement()
	 * @generated
	 */
	void setMapsToGSMElement(boolean value);

	/**
	 * Returns the value of the '<em><b>Associated GSM Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated GSM Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated GSM Element</em>' attribute.
	 * @see #setAssociatedGSMElement(String)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_AssociatedGSMElement()
	 * @model
	 * @generated
	 */
	String getAssociatedGSMElement();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getAssociatedGSMElement <em>Associated GSM Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated GSM Element</em>' attribute.
	 * @see #getAssociatedGSMElement()
	 * @generated
	 */
	void setAssociatedGSMElement(String value);

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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getServiceFeature_Required()
	 * @model
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

} // ServiceFeature
