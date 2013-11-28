/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.GroupRelationship;
import edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature;
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
 * An implementation of the model object '<em><b>Group Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.GroupRelationshipImpl#getOptionalServiceFeatures <em>Optional Service Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GroupRelationshipImpl extends EObjectImpl implements GroupRelationship {
	/**
	 * The cached value of the '{@link #getOptionalServiceFeatures() <em>Optional Service Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalServiceFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<OptionalServiceFeature> optionalServiceFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.GROUP_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<OptionalServiceFeature> getOptionalServiceFeatures() {
		if (optionalServiceFeatures == null) {
			optionalServiceFeatures = new EObjectContainmentEList<OptionalServiceFeature>(OptionalServiceFeature.class, this, ServicefeaturemodelPackage.GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES);
		}
		return optionalServiceFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicefeaturemodelPackage.GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES:
				return ((InternalEList<?>)getOptionalServiceFeatures()).basicRemove(otherEnd, msgs);
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
			case ServicefeaturemodelPackage.GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES:
				return getOptionalServiceFeatures();
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
			case ServicefeaturemodelPackage.GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES:
				getOptionalServiceFeatures().clear();
				getOptionalServiceFeatures().addAll((Collection<? extends OptionalServiceFeature>)newValue);
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
			case ServicefeaturemodelPackage.GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES:
				getOptionalServiceFeatures().clear();
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
			case ServicefeaturemodelPackage.GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES:
				return optionalServiceFeatures != null && !optionalServiceFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GroupRelationshipImpl
