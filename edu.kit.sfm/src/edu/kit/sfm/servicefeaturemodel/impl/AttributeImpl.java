/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.Attribute;
import edu.kit.sfm.servicefeaturemodel.AttributeType;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeImpl#getInstantiationValue <em>Instantiation Value</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeImpl#getAttributeType <em>Attribute Type</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends EObjectImpl implements Attribute {
	/**
	 * The default value of the '{@link #getInstantiationValue() <em>Instantiation Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiationValue()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANTIATION_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstantiationValue() <em>Instantiation Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiationValue()
	 * @generated
	 * @ordered
	 */
	protected String instantiationValue = INSTANTIATION_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributeType() <em>Attribute Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeType()
	 * @generated
	 * @ordered
	 */
	protected AttributeType attributeType;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstantiationValue() {
		return instantiationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiationValue(String newInstantiationValue) {
		String oldInstantiationValue = instantiationValue;
		instantiationValue = newInstantiationValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE__INSTANTIATION_VALUE, oldInstantiationValue, instantiationValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeType getAttributeType() {
		if (attributeType != null && attributeType.eIsProxy()) {
			InternalEObject oldAttributeType = (InternalEObject)attributeType;
			attributeType = (AttributeType)eResolveProxy(oldAttributeType);
			if (attributeType != oldAttributeType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicefeaturemodelPackage.ATTRIBUTE__ATTRIBUTE_TYPE, oldAttributeType, attributeType));
			}
		}
		return attributeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeType basicGetAttributeType() {
		return attributeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeType(AttributeType newAttributeType) {
		AttributeType oldAttributeType = attributeType;
		attributeType = newAttributeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE__ATTRIBUTE_TYPE, oldAttributeType, attributeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.ATTRIBUTE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE__INSTANTIATION_VALUE:
				return getInstantiationValue();
			case ServicefeaturemodelPackage.ATTRIBUTE__ATTRIBUTE_TYPE:
				if (resolve) return getAttributeType();
				return basicGetAttributeType();
			case ServicefeaturemodelPackage.ATTRIBUTE__ID:
				return getId();
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
			case ServicefeaturemodelPackage.ATTRIBUTE__INSTANTIATION_VALUE:
				setInstantiationValue((String)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE__ATTRIBUTE_TYPE:
				setAttributeType((AttributeType)newValue);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE__ID:
				setId((String)newValue);
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
			case ServicefeaturemodelPackage.ATTRIBUTE__INSTANTIATION_VALUE:
				setInstantiationValue(INSTANTIATION_VALUE_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE__ATTRIBUTE_TYPE:
				setAttributeType((AttributeType)null);
				return;
			case ServicefeaturemodelPackage.ATTRIBUTE__ID:
				setId(ID_EDEFAULT);
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
			case ServicefeaturemodelPackage.ATTRIBUTE__INSTANTIATION_VALUE:
				return INSTANTIATION_VALUE_EDEFAULT == null ? instantiationValue != null : !INSTANTIATION_VALUE_EDEFAULT.equals(instantiationValue);
			case ServicefeaturemodelPackage.ATTRIBUTE__ATTRIBUTE_TYPE:
				return attributeType != null;
			case ServicefeaturemodelPackage.ATTRIBUTE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (instantiationValue: ");
		result.append(instantiationValue);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
