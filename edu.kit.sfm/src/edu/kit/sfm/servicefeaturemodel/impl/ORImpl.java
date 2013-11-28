/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.OR;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ORImpl#getMinFeaturesToChoose <em>Min Features To Choose</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ORImpl#getMaxFeaturesToChoose <em>Max Features To Choose</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ORImpl extends GroupRelationshipImpl implements OR {
	/**
	 * The default value of the '{@link #getMinFeaturesToChoose() <em>Min Features To Choose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinFeaturesToChoose()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_FEATURES_TO_CHOOSE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinFeaturesToChoose() <em>Min Features To Choose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinFeaturesToChoose()
	 * @generated
	 * @ordered
	 */
	protected int minFeaturesToChoose = MIN_FEATURES_TO_CHOOSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxFeaturesToChoose() <em>Max Features To Choose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFeaturesToChoose()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_FEATURES_TO_CHOOSE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxFeaturesToChoose() <em>Max Features To Choose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFeaturesToChoose()
	 * @generated
	 * @ordered
	 */
	protected int maxFeaturesToChoose = MAX_FEATURES_TO_CHOOSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ORImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.OR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinFeaturesToChoose() {
		return minFeaturesToChoose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinFeaturesToChoose(int newMinFeaturesToChoose) {
		int oldMinFeaturesToChoose = minFeaturesToChoose;
		minFeaturesToChoose = newMinFeaturesToChoose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.OR__MIN_FEATURES_TO_CHOOSE, oldMinFeaturesToChoose, minFeaturesToChoose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxFeaturesToChoose() {
		return maxFeaturesToChoose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxFeaturesToChoose(int newMaxFeaturesToChoose) {
		int oldMaxFeaturesToChoose = maxFeaturesToChoose;
		maxFeaturesToChoose = newMaxFeaturesToChoose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.OR__MAX_FEATURES_TO_CHOOSE, oldMaxFeaturesToChoose, maxFeaturesToChoose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicefeaturemodelPackage.OR__MIN_FEATURES_TO_CHOOSE:
				return getMinFeaturesToChoose();
			case ServicefeaturemodelPackage.OR__MAX_FEATURES_TO_CHOOSE:
				return getMaxFeaturesToChoose();
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
			case ServicefeaturemodelPackage.OR__MIN_FEATURES_TO_CHOOSE:
				setMinFeaturesToChoose((Integer)newValue);
				return;
			case ServicefeaturemodelPackage.OR__MAX_FEATURES_TO_CHOOSE:
				setMaxFeaturesToChoose((Integer)newValue);
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
			case ServicefeaturemodelPackage.OR__MIN_FEATURES_TO_CHOOSE:
				setMinFeaturesToChoose(MIN_FEATURES_TO_CHOOSE_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.OR__MAX_FEATURES_TO_CHOOSE:
				setMaxFeaturesToChoose(MAX_FEATURES_TO_CHOOSE_EDEFAULT);
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
			case ServicefeaturemodelPackage.OR__MIN_FEATURES_TO_CHOOSE:
				return minFeaturesToChoose != MIN_FEATURES_TO_CHOOSE_EDEFAULT;
			case ServicefeaturemodelPackage.OR__MAX_FEATURES_TO_CHOOSE:
				return maxFeaturesToChoose != MAX_FEATURES_TO_CHOOSE_EDEFAULT;
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
		result.append(" (minFeaturesToChoose: ");
		result.append(minFeaturesToChoose);
		result.append(", maxFeaturesToChoose: ");
		result.append(maxFeaturesToChoose);
		result.append(')');
		return result.toString();
	}

} //ORImpl
