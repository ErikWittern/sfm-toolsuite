/**
 */
package edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Attribute;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Excludes;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.GroupRelationship;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Requires;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServiceFeature;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage;

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
 * An implementation of the model object '<em><b>Service Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getGroupRelationship <em>Group Relationship</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getServiceFeatures <em>Service Features</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getMinAmount <em>Min Amount</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getMaxAmount <em>Max Amount</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#isMapsToGSMElement <em>Maps To GSM Element</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getAssociatedGSMElement <em>Associated GSM Element</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.impl.ServiceFeatureImpl#isRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ServiceFeatureImpl extends EObjectImpl implements ServiceFeature {
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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getGroupRelationship() <em>Group Relationship</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupRelationship()
	 * @generated
	 * @ordered
	 */
	protected GroupRelationship groupRelationship;

	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<Requires> requires;

	/**
	 * The cached value of the '{@link #getExcludes() <em>Excludes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludes()
	 * @generated
	 * @ordered
	 */
	protected EList<Excludes> excludes;

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
	 * The default value of the '{@link #getMinAmount() <em>Min Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinAmount()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_AMOUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinAmount() <em>Min Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinAmount()
	 * @generated
	 * @ordered
	 */
	protected int minAmount = MIN_AMOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxAmount() <em>Max Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAmount()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_AMOUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxAmount() <em>Max Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAmount()
	 * @generated
	 * @ordered
	 */
	protected int maxAmount = MAX_AMOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isMapsToGSMElement() <em>Maps To GSM Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMapsToGSMElement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAPS_TO_GSM_ELEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMapsToGSMElement() <em>Maps To GSM Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMapsToGSMElement()
	 * @generated
	 * @ordered
	 */
	protected boolean mapsToGSMElement = MAPS_TO_GSM_ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssociatedGSMElement() <em>Associated GSM Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedGSMElement()
	 * @generated
	 * @ordered
	 */
	protected static final String ASSOCIATED_GSM_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssociatedGSMElement() <em>Associated GSM Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedGSMElement()
	 * @generated
	 * @ordered
	 */
	protected String associatedGSMElement = ASSOCIATED_GSM_ELEMENT_EDEFAULT;

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
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicefeaturemodelPackage.Literals.SERVICE_FEATURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ServicefeaturemodelPackage.SERVICE_FEATURE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupRelationship getGroupRelationship() {
		return groupRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroupRelationship(GroupRelationship newGroupRelationship, NotificationChain msgs) {
		GroupRelationship oldGroupRelationship = groupRelationship;
		groupRelationship = newGroupRelationship;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP, oldGroupRelationship, newGroupRelationship);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupRelationship(GroupRelationship newGroupRelationship) {
		if (newGroupRelationship != groupRelationship) {
			NotificationChain msgs = null;
			if (groupRelationship != null)
				msgs = ((InternalEObject)groupRelationship).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP, null, msgs);
			if (newGroupRelationship != null)
				msgs = ((InternalEObject)newGroupRelationship).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP, null, msgs);
			msgs = basicSetGroupRelationship(newGroupRelationship, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP, newGroupRelationship, newGroupRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Requires> getRequires() {
		if (requires == null) {
			requires = new EObjectContainmentEList<Requires>(Requires.class, this, ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Excludes> getExcludes() {
		if (excludes == null) {
			excludes = new EObjectContainmentEList<Excludes>(Excludes.class, this, ServicefeaturemodelPackage.SERVICE_FEATURE__EXCLUDES);
		}
		return excludes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ServiceFeature> getServiceFeatures() {
		if (serviceFeatures == null) {
			serviceFeatures = new EObjectContainmentEList<ServiceFeature>(ServiceFeature.class, this, ServicefeaturemodelPackage.SERVICE_FEATURE__SERVICE_FEATURES);
		}
		return serviceFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinAmount() {
		return minAmount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinAmount(int newMinAmount) {
		int oldMinAmount = minAmount;
		minAmount = newMinAmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__MIN_AMOUNT, oldMinAmount, minAmount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxAmount() {
		return maxAmount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAmount(int newMaxAmount) {
		int oldMaxAmount = maxAmount;
		maxAmount = newMaxAmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__MAX_AMOUNT, oldMaxAmount, maxAmount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMapsToGSMElement() {
		return mapsToGSMElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapsToGSMElement(boolean newMapsToGSMElement) {
		boolean oldMapsToGSMElement = mapsToGSMElement;
		mapsToGSMElement = newMapsToGSMElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__MAPS_TO_GSM_ELEMENT, oldMapsToGSMElement, mapsToGSMElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAssociatedGSMElement() {
		return associatedGSMElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedGSMElement(String newAssociatedGSMElement) {
		String oldAssociatedGSMElement = associatedGSMElement;
		associatedGSMElement = newAssociatedGSMElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__ASSOCIATED_GSM_ELEMENT, oldAssociatedGSMElement, associatedGSMElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP:
				return basicSetGroupRelationship(null, msgs);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRES:
				return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__EXCLUDES:
				return ((InternalEList<?>)getExcludes()).basicRemove(otherEnd, msgs);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__SERVICE_FEATURES:
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE__NAME:
				return getName();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__DESCRIPTION:
				return getDescription();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ATTRIBUTES:
				return getAttributes();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP:
				return getGroupRelationship();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRES:
				return getRequires();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__EXCLUDES:
				return getExcludes();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__SERVICE_FEATURES:
				return getServiceFeatures();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MIN_AMOUNT:
				return getMinAmount();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAX_AMOUNT:
				return getMaxAmount();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAPS_TO_GSM_ELEMENT:
				return isMapsToGSMElement();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ASSOCIATED_GSM_ELEMENT:
				return getAssociatedGSMElement();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ID:
				return getId();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRED:
				return isRequired();
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE__NAME:
				setName((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP:
				setGroupRelationship((GroupRelationship)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRES:
				getRequires().clear();
				getRequires().addAll((Collection<? extends Requires>)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__EXCLUDES:
				getExcludes().clear();
				getExcludes().addAll((Collection<? extends Excludes>)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__SERVICE_FEATURES:
				getServiceFeatures().clear();
				getServiceFeatures().addAll((Collection<? extends ServiceFeature>)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MIN_AMOUNT:
				setMinAmount((Integer)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAX_AMOUNT:
				setMaxAmount((Integer)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAPS_TO_GSM_ELEMENT:
				setMapsToGSMElement((Boolean)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ASSOCIATED_GSM_ELEMENT:
				setAssociatedGSMElement((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ID:
				setId((String)newValue);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRED:
				setRequired((Boolean)newValue);
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP:
				setGroupRelationship((GroupRelationship)null);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRES:
				getRequires().clear();
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__EXCLUDES:
				getExcludes().clear();
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__SERVICE_FEATURES:
				getServiceFeatures().clear();
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MIN_AMOUNT:
				setMinAmount(MIN_AMOUNT_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAX_AMOUNT:
				setMaxAmount(MAX_AMOUNT_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAPS_TO_GSM_ELEMENT:
				setMapsToGSMElement(MAPS_TO_GSM_ELEMENT_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ASSOCIATED_GSM_ELEMENT:
				setAssociatedGSMElement(ASSOCIATED_GSM_ELEMENT_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ID:
				setId(ID_EDEFAULT);
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
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
			case ServicefeaturemodelPackage.SERVICE_FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP:
				return groupRelationship != null;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRES:
				return requires != null && !requires.isEmpty();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__EXCLUDES:
				return excludes != null && !excludes.isEmpty();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__SERVICE_FEATURES:
				return serviceFeatures != null && !serviceFeatures.isEmpty();
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MIN_AMOUNT:
				return minAmount != MIN_AMOUNT_EDEFAULT;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAX_AMOUNT:
				return maxAmount != MAX_AMOUNT_EDEFAULT;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAPS_TO_GSM_ELEMENT:
				return mapsToGSMElement != MAPS_TO_GSM_ELEMENT_EDEFAULT;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ASSOCIATED_GSM_ELEMENT:
				return ASSOCIATED_GSM_ELEMENT_EDEFAULT == null ? associatedGSMElement != null : !ASSOCIATED_GSM_ELEMENT_EDEFAULT.equals(associatedGSMElement);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRED:
				return required != REQUIRED_EDEFAULT;
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
		result.append(", minAmount: ");
		result.append(minAmount);
		result.append(", maxAmount: ");
		result.append(maxAmount);
		result.append(", mapsToGSMElement: ");
		result.append(mapsToGSMElement);
		result.append(", associatedGSMElement: ");
		result.append(associatedGSMElement);
		result.append(", id: ");
		result.append(id);
		result.append(", required: ");
		result.append(required);
		result.append(')');
		return result.toString();
	}

} //ServiceFeatureImpl
