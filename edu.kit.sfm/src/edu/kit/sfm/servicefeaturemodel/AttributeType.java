/**
 */
package edu.kit.sfm.servicefeaturemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getDomain <em>Domain</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getAggregationRule <em>Aggregation Rule</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getScaleOrder <em>Scale Order</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#isToBeEvaluated <em>To Be Evaluated</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getCustomAttributeTypePriority <em>Custom Attribute Type Priority</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirementWeight <em>Requirement Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType()
 * @model
 * @generated
 */
public interface AttributeType extends EObject {
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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.sfm.servicefeaturemodel.AttributeDomain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' attribute.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeDomain
	 * @see #setDomain(AttributeDomain)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_Domain()
	 * @model
	 * @generated
	 */
	AttributeDomain getDomain();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getDomain <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' attribute.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeDomain
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(AttributeDomain value);

	/**
	 * Returns the value of the '<em><b>Aggregation Rule</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.sfm.servicefeaturemodel.AggregationRules}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Rule</em>' attribute.
	 * @see edu.kit.sfm.servicefeaturemodel.AggregationRules
	 * @see #setAggregationRule(AggregationRules)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_AggregationRule()
	 * @model
	 * @generated
	 */
	AggregationRules getAggregationRule();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getAggregationRule <em>Aggregation Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Rule</em>' attribute.
	 * @see edu.kit.sfm.servicefeaturemodel.AggregationRules
	 * @see #getAggregationRule()
	 * @generated
	 */
	void setAggregationRule(AggregationRules value);

	/**
	 * Returns the value of the '<em><b>Scale Order</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.sfm.servicefeaturemodel.ScaleOrders}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale Order</em>' attribute.
	 * @see edu.kit.sfm.servicefeaturemodel.ScaleOrders
	 * @see #setScaleOrder(ScaleOrders)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_ScaleOrder()
	 * @model
	 * @generated
	 */
	ScaleOrders getScaleOrder();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getScaleOrder <em>Scale Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale Order</em>' attribute.
	 * @see edu.kit.sfm.servicefeaturemodel.ScaleOrders
	 * @see #getScaleOrder()
	 * @generated
	 */
	void setScaleOrder(ScaleOrders value);

	/**
	 * Returns the value of the '<em><b>To Be Evaluated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Be Evaluated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Be Evaluated</em>' attribute.
	 * @see #setToBeEvaluated(boolean)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_ToBeEvaluated()
	 * @model required="true"
	 * @generated
	 */
	boolean isToBeEvaluated();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#isToBeEvaluated <em>To Be Evaluated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Be Evaluated</em>' attribute.
	 * @see #isToBeEvaluated()
	 * @generated
	 */
	void setToBeEvaluated(boolean value);

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
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Custom Attribute Type Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Attribute Type Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Attribute Type Priority</em>' attribute.
	 * @see #setCustomAttributeTypePriority(int)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_CustomAttributeTypePriority()
	 * @model
	 * @generated
	 */
	int getCustomAttributeTypePriority();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getCustomAttributeTypePriority <em>Custom Attribute Type Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Attribute Type Priority</em>' attribute.
	 * @see #getCustomAttributeTypePriority()
	 * @generated
	 */
	void setCustomAttributeTypePriority(int value);

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' attribute.
	 * @see #setRequirement(String)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_Requirement()
	 * @model
	 * @generated
	 */
	String getRequirement();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirement <em>Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' attribute.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(String value);

	/**
	 * Returns the value of the '<em><b>Requirement Weight</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Weight</em>' attribute.
	 * @see #setRequirementWeight(String)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeType_RequirementWeight()
	 * @model default="1.0"
	 * @generated
	 */
	String getRequirementWeight();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirementWeight <em>Requirement Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Weight</em>' attribute.
	 * @see #getRequirementWeight()
	 * @generated
	 */
	void setRequirementWeight(String value);

} // AttributeType
