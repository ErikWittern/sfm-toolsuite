/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.AggregationRules;
import edu.kit.sfm.servicefeaturemodel.AttributeDomain;
import edu.kit.sfm.servicefeaturemodel.AttributeType;
import edu.kit.sfm.servicefeaturemodel.ScaleOrders;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#getAggregationRule <em>Aggregation Rule</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#getScaleOrder <em>Scale Order</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#isToBeEvaluated <em>To Be Evaluated</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#getCustomAttributeTypePriority <em>Custom Attribute Type Priority</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl#getRequirement <em>Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeTypeImpl extends EObjectImpl implements AttributeType {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeDomain DOMAIN_EDEFAULT = AttributeDomain.CONTINUOUS;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected AttributeDomain domain = DOMAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAggregationRule() <em>Aggregation Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationRule()
	 * @generated
	 * @ordered
	 */
	protected static final AggregationRules AGGREGATION_RULE_EDEFAULT = AggregationRules.SUM;

	/**
	 * The cached value of the '{@link #getAggregationRule() <em>Aggregation Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationRule()
	 * @generated
	 * @ordered
	 */
	protected AggregationRules aggregationRule = AGGREGATION_RULE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScaleOrder() <em>Scale Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScaleOrder()
	 * @generated
	 * @ordered
	 */
	protected static final ScaleOrders SCALE_ORDER_EDEFAULT = ScaleOrders.HIGHER_IS_BETTER;

	/**
	 * The cached value of the '{@link #getScaleOrder() <em>Scale Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScaleOrder()
	 * @generated
	 * @ordered
	 */
	protected ScaleOrders scaleOrder = SCALE_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isToBeEvaluated() <em>To Be Evaluated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isToBeEvaluated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TO_BE_EVALUATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isToBeEvaluated() <em>To Be Evaluated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isToBeEvaluated()
	 * @generated
	 * @ordered
	 */
	protected boolean toBeEvaluated = TO_BE_EVALUATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomAttributeTypePriority() <em>Custom Attribute Type Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomAttributeTypePriority()
	 * @generated
	 * @ordered
	 */
	protected static final int CUSTOM_ATTRIBUTE_TYPE_PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCustomAttributeTypePriority() <em>Custom Attribute Type Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomAttributeTypePriority()
	 * @generated
	 * @ordered
	 */
	protected int customAttributeTypePriority = CUSTOM_ATTRIBUTE_TYPE_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequirement() <em>Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected String requirement = REQUIREMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.ATTRIBUTE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDomain getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(AttributeDomain newDomain) {
		AttributeDomain oldDomain = domain;
		domain = newDomain == null ? DOMAIN_EDEFAULT : newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationRules getAggregationRule() {
		return aggregationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationRule(AggregationRules newAggregationRule) {
		AggregationRules oldAggregationRule = aggregationRule;
		aggregationRule = newAggregationRule == null ? AGGREGATION_RULE_EDEFAULT : newAggregationRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__AGGREGATION_RULE, oldAggregationRule, aggregationRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaleOrders getScaleOrder() {
		return scaleOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScaleOrder(ScaleOrders newScaleOrder) {
		ScaleOrders oldScaleOrder = scaleOrder;
		scaleOrder = newScaleOrder == null ? SCALE_ORDER_EDEFAULT : newScaleOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__SCALE_ORDER, oldScaleOrder, scaleOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isToBeEvaluated() {
		return toBeEvaluated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToBeEvaluated(boolean newToBeEvaluated) {
		boolean oldToBeEvaluated = toBeEvaluated;
		toBeEvaluated = newToBeEvaluated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__TO_BE_EVALUATED, oldToBeEvaluated, toBeEvaluated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCustomAttributeTypePriority() {
		return customAttributeTypePriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomAttributeTypePriority(int newCustomAttributeTypePriority) {
		int oldCustomAttributeTypePriority = customAttributeTypePriority;
		customAttributeTypePriority = newCustomAttributeTypePriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__CUSTOM_ATTRIBUTE_TYPE_PRIORITY, oldCustomAttributeTypePriority, customAttributeTypePriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequirement() {
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirement(String newRequirement) {
		String oldRequirement = requirement;
		requirement = newRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE_TYPE__REQUIREMENT, oldRequirement, requirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__NAME:
				return getName();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DOMAIN:
				return getDomain();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__AGGREGATION_RULE:
				return getAggregationRule();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__SCALE_ORDER:
				return getScaleOrder();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__TO_BE_EVALUATED:
				return isToBeEvaluated();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DESCRIPTION:
				return getDescription();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__CUSTOM_ATTRIBUTE_TYPE_PRIORITY:
				return getCustomAttributeTypePriority();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__REQUIREMENT:
				return getRequirement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__NAME:
				setName((String)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DOMAIN:
				setDomain((AttributeDomain)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__AGGREGATION_RULE:
				setAggregationRule((AggregationRules)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__SCALE_ORDER:
				setScaleOrder((ScaleOrders)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__TO_BE_EVALUATED:
				setToBeEvaluated((Boolean)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__CUSTOM_ATTRIBUTE_TYPE_PRIORITY:
				setCustomAttributeTypePriority((Integer)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__REQUIREMENT:
				setRequirement((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DOMAIN:
				setDomain(DOMAIN_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__AGGREGATION_RULE:
				setAggregationRule(AGGREGATION_RULE_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__SCALE_ORDER:
				setScaleOrder(SCALE_ORDER_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__TO_BE_EVALUATED:
				setToBeEvaluated(TO_BE_EVALUATED_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__CUSTOM_ATTRIBUTE_TYPE_PRIORITY:
				setCustomAttributeTypePriority(CUSTOM_ATTRIBUTE_TYPE_PRIORITY_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__REQUIREMENT:
				setRequirement(REQUIREMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DOMAIN:
				return domain != DOMAIN_EDEFAULT;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__AGGREGATION_RULE:
				return aggregationRule != AGGREGATION_RULE_EDEFAULT;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__SCALE_ORDER:
				return scaleOrder != SCALE_ORDER_EDEFAULT;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__TO_BE_EVALUATED:
				return toBeEvaluated != TO_BE_EVALUATED_EDEFAULT;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__CUSTOM_ATTRIBUTE_TYPE_PRIORITY:
				return customAttributeTypePriority != CUSTOM_ATTRIBUTE_TYPE_PRIORITY_EDEFAULT;
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE__REQUIREMENT:
				return REQUIREMENT_EDEFAULT == null ? requirement != null : !REQUIREMENT_EDEFAULT.equals(requirement);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", domain: ");
		result.append(domain);
		result.append(", aggregationRule: ");
		result.append(aggregationRule);
		result.append(", scaleOrder: ");
		result.append(scaleOrder);
		result.append(", toBeEvaluated: ");
		result.append(toBeEvaluated);
		result.append(", description: ");
		result.append(description);
		result.append(", customAttributeTypePriority: ");
		result.append(customAttributeTypePriority);
		result.append(", requirement: ");
		result.append(requirement);
		result.append(')');
		return result.toString();
	}

} //AttributeTypeImpl
