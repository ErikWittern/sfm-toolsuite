/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.FeatureTypes;
import edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional Service Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.OptionalServiceFeatureImpl#getFeatureType <em>Feature Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionalServiceFeatureImpl extends ServiceFeatureImpl implements OptionalServiceFeature {
	/**
	 * The default value of the '{@link #getFeatureType() <em>Feature Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureType()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureTypes FEATURE_TYPE_EDEFAULT = FeatureTypes.INSTANCE_FEATURE;

	/**
	 * The cached value of the '{@link #getFeatureType() <em>Feature Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureType()
	 * @generated
	 * @ordered
	 */
	protected FeatureTypes featureType = FEATURE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionalServiceFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.OPTIONAL_SERVICE_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTypes getFeatureType() {
		return featureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicefeaturemodelPackage.OPTIONAL_SERVICE_FEATURE__FEATURE_TYPE:
				return getFeatureType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ServicefeaturemodelPackage.OPTIONAL_SERVICE_FEATURE__FEATURE_TYPE:
				return featureType != FEATURE_TYPE_EDEFAULT;
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
		result.append(" (featureType: ");
		result.append(featureType);
		result.append(')');
		return result.toString();
	}

} //OptionalServiceFeatureImpl
