/**
 */
package edu.kit.cockpit.sfmdesigner.servicefeaturemodel.provider;


import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServiceFeature;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelFactory;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage;

import edu.kit.sfm.servicefeaturemodel.provider.ServiceFeatureModelEditPlugin;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServiceFeature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ServiceFeatureItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFeatureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addMinAmountPropertyDescriptor(object);
			addMaxAmountPropertyDescriptor(object);
			addMapsToGSMElementPropertyDescriptor(object);
			addAssociatedGSMElementPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addRequiredPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_name_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_description_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__DESCRIPTION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min Amount feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinAmountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_minAmount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_minAmount_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__MIN_AMOUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Amount feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxAmountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_maxAmount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_maxAmount_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__MAX_AMOUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maps To GSM Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMapsToGSMElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_mapsToGSMElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_mapsToGSMElement_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__MAPS_TO_GSM_ELEMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Associated GSM Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssociatedGSMElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_associatedGSMElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_associatedGSMElement_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__ASSOCIATED_GSM_ELEMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_id_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ServiceFeature_required_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ServiceFeature_required_feature", "_UI_ServiceFeature_type"),
				 ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__REQUIRED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__ATTRIBUTES);
			childrenFeatures.add(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__GROUP_RELATIONSHIP);
			childrenFeatures.add(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__REQUIRES);
			childrenFeatures.add(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__EXCLUDES);
			childrenFeatures.add(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__SERVICE_FEATURES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ServiceFeature)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ServiceFeature_type") :
			getString("_UI_ServiceFeature_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ServiceFeature.class)) {
			case ServicefeaturemodelPackage.SERVICE_FEATURE__NAME:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__DESCRIPTION:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MIN_AMOUNT:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAX_AMOUNT:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__MAPS_TO_GSM_ELEMENT:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ASSOCIATED_GSM_ELEMENT:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ID:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ServicefeaturemodelPackage.SERVICE_FEATURE__ATTRIBUTES:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__GROUP_RELATIONSHIP:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__REQUIRES:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__EXCLUDES:
			case ServicefeaturemodelPackage.SERVICE_FEATURE__SERVICE_FEATURES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__ATTRIBUTES,
				 ServicefeaturemodelFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__GROUP_RELATIONSHIP,
				 ServicefeaturemodelFactory.eINSTANCE.createOR()));

		newChildDescriptors.add
			(createChildParameter
				(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__GROUP_RELATIONSHIP,
				 ServicefeaturemodelFactory.eINSTANCE.createXOR()));

		newChildDescriptors.add
			(createChildParameter
				(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__REQUIRES,
				 ServicefeaturemodelFactory.eINSTANCE.createRequires()));

		newChildDescriptors.add
			(createChildParameter
				(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__EXCLUDES,
				 ServicefeaturemodelFactory.eINSTANCE.createExcludes()));

		newChildDescriptors.add
			(createChildParameter
				(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__SERVICE_FEATURES,
				 ServicefeaturemodelFactory.eINSTANCE.createOptionalServiceFeature()));

		newChildDescriptors.add
			(createChildParameter
				(ServicefeaturemodelPackage.Literals.SERVICE_FEATURE__SERVICE_FEATURES,
				 ServicefeaturemodelFactory.eINSTANCE.createMandatoryServiceFeature()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ServiceFeatureModelEditPlugin.INSTANCE;
	}

}
