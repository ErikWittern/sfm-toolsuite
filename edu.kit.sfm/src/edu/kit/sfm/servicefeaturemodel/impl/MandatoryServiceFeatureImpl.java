/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.FeatureTypes;
import edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mandatory Service Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.MandatoryServiceFeatureImpl#getFeatureTypes <em>Feature Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MandatoryServiceFeatureImpl extends ServiceFeatureImpl implements MandatoryServiceFeature {
	/**
	 * The default value of the '{@link #getFeatureTypes() <em>Feature Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureTypes()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureTypes FEATURE_TYPES_EDEFAULT = FeatureTypes.GROUPING_FEATURE;

	/**
	 * The cached value of the '{@link #getFeatureTypes() <em>Feature Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureTypes()
	 * @generated
	 * @ordered
	 */
	protected FeatureTypes featureTypes = FEATURE_TYPES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MandatoryServiceFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.MANDATORY_SERVICE_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTypes getFeatureTypes() {
		return featureTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureTypes(FeatureTypes newFeatureTypes) {
		FeatureTypes oldFeatureTypes = featureTypes;
		featureTypes = newFeatureTypes == null ? FEATURE_TYPES_EDEFAULT : newFeatureTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.MANDATORY_SERVICE_FEATURE__FEATURE_TYPES, oldFeatureTypes, featureTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicefeaturemodelPackage.MANDATORY_SERVICE_FEATURE__FEATURE_TYPES:
				return getFeatureTypes();
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
			case ServicefeaturemodelPackage.MANDATORY_SERVICE_FEATURE__FEATURE_TYPES:
				setFeatureTypes((FeatureTypes)newValue);
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
			case ServicefeaturemodelPackage.MANDATORY_SERVICE_FEATURE__FEATURE_TYPES:
				setFeatureTypes(FEATURE_TYPES_EDEFAULT);
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
			case ServicefeaturemodelPackage.MANDATORY_SERVICE_FEATURE__FEATURE_TYPES:
				return featureTypes != FEATURE_TYPES_EDEFAULT;
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
		result.append(" (featureTypes: ");
		result.append(featureTypes);
		result.append(')');
		return result.toString();
	}

} //MandatoryServiceFeatureImpl
