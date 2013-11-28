/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.AttributeType;
import edu.kit.sfm.servicefeaturemodel.AttributeTypes;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypesImpl#getAttributeTypes <em>Attribute Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeTypesImpl extends EObjectImpl implements AttributeTypes {
	/**
	 * The cached value of the '{@link #getAttributeTypes() <em>Attribute Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeType> attributeTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeTypesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.ATTRIBUTE_TYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<AttributeType> getAttributeTypes() {
		if (attributeTypes == null) {
			attributeTypes = new EObjectContainmentEList<AttributeType>(AttributeType.class, this, ServicefeaturemodelPackage.ATTRIBUTE_TYPES__ATTRIBUTE_TYPES);
		}
		return attributeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPES__ATTRIBUTE_TYPES:
				return ((InternalEList<?>)getAttributeTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPES__ATTRIBUTE_TYPES:
				return getAttributeTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPES__ATTRIBUTE_TYPES:
				getAttributeTypes().clear();
				getAttributeTypes().addAll((Collection<? extends AttributeType>)newValue);
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
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPES__ATTRIBUTE_TYPES:
				getAttributeTypes().clear();
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
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPES__ATTRIBUTE_TYPES:
				return attributeTypes != null && !attributeTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AttributeTypesImpl
