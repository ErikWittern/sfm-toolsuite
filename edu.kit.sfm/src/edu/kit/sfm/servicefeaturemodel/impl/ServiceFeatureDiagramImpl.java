/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.ServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Feature Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl#getServiceFeatures <em>Service Features</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceFeatureDiagramImpl extends EObjectImpl implements ServiceFeatureDiagram {
	/**
	 * The cached value of the '{@link #getServiceFeatures() <em>Service Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceFeature> serviceFeatures;

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
	protected ServiceFeatureDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.SERVICE_FEATURE_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ServiceFeature> getServiceFeatures() {
		if (serviceFeatures == null) {
			serviceFeatures = new EObjectContainmentEList<ServiceFeature>(ServiceFeature.class, this, ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES);
		}
		return serviceFeatures;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES:
				return ((InternalEList<?>)getServiceFeatures()).basicRemove(otherEnd, msgs);
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES:
				return getServiceFeatures();
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__NAME:
				return getName();
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__DESCRIPTION:
				return getDescription();
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__ID:
				return getId();
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES:
				getServiceFeatures().clear();
				getServiceFeatures().addAll((Collection<? extends ServiceFeature>)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__ID:
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES:
				getServiceFeatures().clear();
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__ID:
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES:
				return serviceFeatures != null && !serviceFeatures.isEmpty();
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM__ID:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //ServiceFeatureDiagramImpl
