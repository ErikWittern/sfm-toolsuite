/**
 */
package edu.kit.sfm.servicefeaturemodel.impl;

import edu.kit.sfm.servicefeaturemodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicefeaturemodelFactoryImpl extends EFactoryImpl implements ServicefeaturemodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServicefeaturemodelFactory init() {
		try {
			ServicefeaturemodelFactory theServicefeaturemodelFactory = (ServicefeaturemodelFactory)EPackage.Registry.INSTANCE.getEFactory(ServicefeaturemodelPackage.eNS_URI);
			if (theServicefeaturemodelFactory != null) {
				return theServicefeaturemodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServicefeaturemodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicefeaturemodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ServicefeaturemodelPackage.SERVICE: return createService();
			case ServicefeaturemodelPackage.OPTIONAL_SERVICE_FEATURE: return createOptionalServiceFeature();
			case ServicefeaturemodelPackage.ATTRIBUTE: return createAttribute();
			case ServicefeaturemodelPackage.REQUIRES: return createRequires();
			case ServicefeaturemodelPackage.EXCLUDES: return createExcludes();
			case ServicefeaturemodelPackage.OR: return createOR();
			case ServicefeaturemodelPackage.XOR: return createXOR();
			case ServicefeaturemodelPackage.SERVICE_FEATURE_DIAGRAM: return createServiceFeatureDiagram();
			case ServicefeaturemodelPackage.CONFIGURATION: return createConfiguration();
			case ServicefeaturemodelPackage.PREFERENCE: return createPreference();
			case ServicefeaturemodelPackage.MANDATORY_SERVICE_FEATURE: return createMandatoryServiceFeature();
			case ServicefeaturemodelPackage.CONFIGURATIONS: return createConfigurations();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPES: return createAttributeTypes();
			case ServicefeaturemodelPackage.ATTRIBUTE_TYPE: return createAttributeType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ServicefeaturemodelPackage.ATTRIBUTE_DOMAIN:
				return createAttributeDomainFromString(eDataType, initialValue);
			case ServicefeaturemodelPackage.AGGREGATION_RULES:
				return createAggregationRulesFromString(eDataType, initialValue);
			case ServicefeaturemodelPackage.SCALE_ORDERS:
				return createScaleOrdersFromString(eDataType, initialValue);
			case ServicefeaturemodelPackage.FEATURE_TYPES:
				return createFeatureTypesFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ServicefeaturemodelPackage.ATTRIBUTE_DOMAIN:
				return convertAttributeDomainToString(eDataType, instanceValue);
			case ServicefeaturemodelPackage.AGGREGATION_RULES:
				return convertAggregationRulesToString(eDataType, instanceValue);
			case ServicefeaturemodelPackage.SCALE_ORDERS:
				return convertScaleOrdersToString(eDataType, instanceValue);
			case ServicefeaturemodelPackage.FEATURE_TYPES:
				return convertFeatureTypesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionalServiceFeature createOptionalServiceFeature() {
		OptionalServiceFeatureImpl optionalServiceFeature = new OptionalServiceFeatureImpl();
		return optionalServiceFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requires createRequires() {
		RequiresImpl requires = new RequiresImpl();
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Excludes createExcludes() {
		ExcludesImpl excludes = new ExcludesImpl();
		return excludes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OR createOR() {
		ORImpl or = new ORImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XOR createXOR() {
		XORImpl xor = new XORImpl();
		return xor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFeatureDiagram createServiceFeatureDiagram() {
		ServiceFeatureDiagramImpl serviceFeatureDiagram = new ServiceFeatureDiagramImpl();
		return serviceFeatureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preference createPreference() {
		PreferenceImpl preference = new PreferenceImpl();
		return preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MandatoryServiceFeature createMandatoryServiceFeature() {
		MandatoryServiceFeatureImpl mandatoryServiceFeature = new MandatoryServiceFeatureImpl();
		return mandatoryServiceFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configurations createConfigurations() {
		ConfigurationsImpl configurations = new ConfigurationsImpl();
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeTypes createAttributeTypes() {
		AttributeTypesImpl attributeTypes = new AttributeTypesImpl();
		return attributeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeType createAttributeType() {
		AttributeTypeImpl attributeType = new AttributeTypeImpl();
		return attributeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDomain createAttributeDomainFromString(EDataType eDataType, String initialValue) {
		AttributeDomain result = AttributeDomain.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttributeDomainToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationRules createAggregationRulesFromString(EDataType eDataType, String initialValue) {
		AggregationRules result = AggregationRules.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAggregationRulesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaleOrders createScaleOrdersFromString(EDataType eDataType, String initialValue) {
		ScaleOrders result = ScaleOrders.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScaleOrdersToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTypes createFeatureTypesFromString(EDataType eDataType, String initialValue) {
		FeatureTypes result = FeatureTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicefeaturemodelPackage getServicefeaturemodelPackage() {
		return (ServicefeaturemodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServicefeaturemodelPackage getPackage() {
		return ServicefeaturemodelPackage.eINSTANCE;
	}

} //ServicefeaturemodelFactoryImpl
