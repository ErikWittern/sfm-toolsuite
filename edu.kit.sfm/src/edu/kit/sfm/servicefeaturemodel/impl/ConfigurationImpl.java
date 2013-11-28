/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.Attribute;
import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.Preference;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage;

import edu.kit.sfm.servicefeaturemodel.util.ServicefeaturemodelValidator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl#getServiceFeatures <em>Service Features</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl#getPreferences <em>Preferences</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
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
	 * The cached value of the '{@link #getServiceFeatures() <em>Service Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceFeature> serviceFeatures;

	/**
	 * The cached value of the '{@link #getPreferences() <em>Preferences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Preference> preferences;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.CONFIGURATION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.CONFIGURATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ServiceFeature> getServiceFeatures() {
		if (serviceFeatures == null) {
			serviceFeatures = new EObjectResolvingEList<ServiceFeature>(ServiceFeature.class, this, ServicefeaturemodelPackage.CONFIGURATION__SERVICE_FEATURES);
		}
		return serviceFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Preference> getPreferences() {
		if (preferences == null) {
			preferences = new EObjectContainmentEList<Preference>(Preference.class, this, ServicefeaturemodelPackage.CONFIGURATION__PREFERENCES);
		}
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ServicefeaturemodelPackage.CONFIGURATION__ATTRIBUTES);
		}
		return attributes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.CONFIGURATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validate(DiagnosticChain diagnostic, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostic != null) {
				diagnostic.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ServicefeaturemodelValidator.DIAGNOSTIC_SOURCE,
						 ServicefeaturemodelValidator.CONFIGURATION__VALIDATE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "validate", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicefeaturemodelPackage.CONFIGURATION__PREFERENCES:
				return ((InternalEList<?>)getPreferences()).basicRemove(otherEnd, msgs);
			case ServicefeaturemodelPackage.CONFIGURATION__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case ServicefeaturemodelPackage.CONFIGURATION__NAME:
				return getName();
			case ServicefeaturemodelPackage.CONFIGURATION__ID:
				return getId();
			case ServicefeaturemodelPackage.CONFIGURATION__SERVICE_FEATURES:
				return getServiceFeatures();
			case ServicefeaturemodelPackage.CONFIGURATION__PREFERENCES:
				return getPreferences();
			case ServicefeaturemodelPackage.CONFIGURATION__ATTRIBUTES:
				return getAttributes();
			case ServicefeaturemodelPackage.CONFIGURATION__DESCRIPTION:
				return getDescription();
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
			case ServicefeaturemodelPackage.CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__ID:
				setId((String)newValue);
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__SERVICE_FEATURES:
				getServiceFeatures().clear();
				getServiceFeatures().addAll((Collection<? extends ServiceFeature>)newValue);
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__PREFERENCES:
				getPreferences().clear();
				getPreferences().addAll((Collection<? extends Preference>)newValue);
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__DESCRIPTION:
				setDescription((String)newValue);
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
			case ServicefeaturemodelPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__ID:
				setId(ID_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__SERVICE_FEATURES:
				getServiceFeatures().clear();
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__PREFERENCES:
				getPreferences().clear();
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__ATTRIBUTES:
				getAttributes().clear();
				return;
			case ServicefeaturemodelPackage.CONFIGURATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case ServicefeaturemodelPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicefeaturemodelPackage.CONFIGURATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ServicefeaturemodelPackage.CONFIGURATION__SERVICE_FEATURES:
				return serviceFeatures != null && !serviceFeatures.isEmpty();
			case ServicefeaturemodelPackage.CONFIGURATION__PREFERENCES:
				return preferences != null && !preferences.isEmpty();
			case ServicefeaturemodelPackage.CONFIGURATION__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case ServicefeaturemodelPackage.CONFIGURATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(", id: ");
		result.append(id);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
