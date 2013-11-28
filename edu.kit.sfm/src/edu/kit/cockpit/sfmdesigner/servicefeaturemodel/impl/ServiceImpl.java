/**
 */
package edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.AttributeTypes;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Configurations;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServiceFeatureDiagram;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceImpl#getServiceFeatureDiagram <em>Service Feature Diagram</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceImpl#getAttributeTypes <em>Attribute Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends EObjectImpl implements Service {
	/**
	 * The cached value of the '{@link #getServiceFeatureDiagram() <em>Service Feature Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceFeatureDiagram()
	 * @generated
	 * @ordered
	 */
	protected ServiceFeatureDiagram serviceFeatureDiagram;

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
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected Configurations configurations;

	/**
	 * The cached value of the '{@link #getAttributeTypes() <em>Attribute Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeTypes()
	 * @generated
	 * @ordered
	 */
	protected AttributeTypes attributeTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFeatureDiagram getServiceFeatureDiagram() {
		return serviceFeatureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceFeatureDiagram(ServiceFeatureDiagram newServiceFeatureDiagram, NotificationChain msgs) {
		ServiceFeatureDiagram oldServiceFeatureDiagram = serviceFeatureDiagram;
		serviceFeatureDiagram = newServiceFeatureDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM, oldServiceFeatureDiagram, newServiceFeatureDiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceFeatureDiagram(ServiceFeatureDiagram newServiceFeatureDiagram) {
		if (newServiceFeatureDiagram != serviceFeatureDiagram) {
			NotificationChain msgs = null;
			if (serviceFeatureDiagram != null)
				msgs = ((InternalEObject)serviceFeatureDiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM, null, msgs);
			if (newServiceFeatureDiagram != null)
				msgs = ((InternalEObject)newServiceFeatureDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM, null, msgs);
			msgs = basicSetServiceFeatureDiagram(newServiceFeatureDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM, newServiceFeatureDiagram, newServiceFeatureDiagram));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configurations getConfigurations() {
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurations(Configurations newConfigurations, NotificationChain msgs) {
		Configurations oldConfigurations = configurations;
		configurations = newConfigurations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS, oldConfigurations, newConfigurations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurations(Configurations newConfigurations) {
		if (newConfigurations != configurations) {
			NotificationChain msgs = null;
			if (configurations != null)
				msgs = ((InternalEObject)configurations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS, null, msgs);
			if (newConfigurations != null)
				msgs = ((InternalEObject)newConfigurations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS, null, msgs);
			msgs = basicSetConfigurations(newConfigurations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS, newConfigurations, newConfigurations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeTypes getAttributeTypes() {
		return attributeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttributeTypes(AttributeTypes newAttributeTypes, NotificationChain msgs) {
		AttributeTypes oldAttributeTypes = attributeTypes;
		attributeTypes = newAttributeTypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES, oldAttributeTypes, newAttributeTypes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeTypes(AttributeTypes newAttributeTypes) {
		if (newAttributeTypes != attributeTypes) {
			NotificationChain msgs = null;
			if (attributeTypes != null)
				msgs = ((InternalEObject)attributeTypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES, null, msgs);
			if (newAttributeTypes != null)
				msgs = ((InternalEObject)newAttributeTypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES, null, msgs);
			msgs = basicSetAttributeTypes(newAttributeTypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES, newAttributeTypes, newAttributeTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM:
				return basicSetServiceFeatureDiagram(null, msgs);
			case ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS:
				return basicSetConfigurations(null, msgs);
			case ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES:
				return basicSetAttributeTypes(null, msgs);
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
			case ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM:
				return getServiceFeatureDiagram();
			case ServicefeaturemodelPackage.SERVICE__DESCRIPTION:
				return getDescription();
			case ServicefeaturemodelPackage.SERVICE__ID:
				return getId();
			case ServicefeaturemodelPackage.SERVICE__NAME:
				return getName();
			case ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS:
				return getConfigurations();
			case ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES:
				return getAttributeTypes();
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
			case ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM:
				setServiceFeatureDiagram((ServiceFeatureDiagram)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE__ID:
				setId((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE__NAME:
				setName((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS:
				setConfigurations((Configurations)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES:
				setAttributeTypes((AttributeTypes)newValue);
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
			case ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM:
				setServiceFeatureDiagram((ServiceFeatureDiagram)null);
				return;
			case ServicefeaturemodelPackage.SERVICE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE__ID:
				setId(ID_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS:
				setConfigurations((Configurations)null);
				return;
			case ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES:
				setAttributeTypes((AttributeTypes)null);
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
			case ServicefeaturemodelPackage.SERVICE__SERVICE_FEATURE_DIAGRAM:
				return serviceFeatureDiagram != null;
			case ServicefeaturemodelPackage.SERVICE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicefeaturemodelPackage.SERVICE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ServicefeaturemodelPackage.SERVICE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicefeaturemodelPackage.SERVICE__CONFIGURATIONS:
				return configurations != null;
			case ServicefeaturemodelPackage.SERVICE__ATTRIBUTE_TYPES:
				return attributeTypes != null;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ServiceImpl
