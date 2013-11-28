/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.Excludes;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Excludes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ExcludesImpl#getServiceFeature <em>Service Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExcludesImpl extends EObjectImpl implements Excludes {
	/**
	 * The cached value of the '{@link #getServiceFeature() <em>Service Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceFeature()
	 * @generated
	 * @ordered
	 */
	protected ServiceFeature serviceFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExcludesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.EXCLUDES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFeature getServiceFeature() {
		if (serviceFeature != null && serviceFeature.eIsProxy()) {
			InternalEObject oldServiceFeature = (InternalEObject)serviceFeature;
			serviceFeature = (ServiceFeature)eResolveProxy(oldServiceFeature);
			if (serviceFeature != oldServiceFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicefeaturemodelPackage.EXCLUDES__SERVICE_FEATURE, oldServiceFeature, serviceFeature));
			}
		}
		return serviceFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFeature basicGetServiceFeature() {
		return serviceFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceFeature(ServiceFeature newServiceFeature) {
		ServiceFeature oldServiceFeature = serviceFeature;
		serviceFeature = newServiceFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.EXCLUDES__SERVICE_FEATURE, oldServiceFeature, serviceFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicefeaturemodelPackage.EXCLUDES__SERVICE_FEATURE:
				if (resolve) return getServiceFeature();
				return basicGetServiceFeature();
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
			case ServicefeaturemodelPackage.EXCLUDES__SERVICE_FEATURE:
				setServiceFeature((ServiceFeature)newValue);
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
			case ServicefeaturemodelPackage.EXCLUDES__SERVICE_FEATURE:
				setServiceFeature((ServiceFeature)null);
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
			case ServicefeaturemodelPackage.EXCLUDES__SERVICE_FEATURE:
				return serviceFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //ExcludesImpl
