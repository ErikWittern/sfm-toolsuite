/**
 */
package edu.kit.sfm.servicefeaturemodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelFactory
 * @model kind="package"
 * @generated
 */
public interface ServicefeaturemodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "servicefeaturemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://servicefeaturemodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "servicefeaturemodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicefeaturemodelPackage eINSTANCE = edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServiceImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Service Feature Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_FEATURE_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ID = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CONFIGURATIONS = 4;

	/**
	 * The feature id for the '<em><b>Attribute Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ATTRIBUTE_TYPES = 5;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureImpl <em>Service Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getServiceFeature()
	 * @generated
	 */
	int SERVICE_FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__ATTRIBUTES = 2;

	/**
	 * The feature id for the '<em><b>Group Relationship</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__GROUP_RELATIONSHIP = 3;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__REQUIRES = 4;

	/**
	 * The feature id for the '<em><b>Excludes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__EXCLUDES = 5;

	/**
	 * The feature id for the '<em><b>Service Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__SERVICE_FEATURES = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__ID = 7;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__REQUIRED = 8;

	/**
	 * The feature id for the '<em><b>Requirement Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE__REQUIREMENT_WEIGHT = 9;

	/**
	 * The number of structural features of the '<em>Service Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.OptionalServiceFeatureImpl <em>Optional Service Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.OptionalServiceFeatureImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getOptionalServiceFeature()
	 * @generated
	 */
	int OPTIONAL_SERVICE_FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__NAME = SERVICE_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__DESCRIPTION = SERVICE_FEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__ATTRIBUTES = SERVICE_FEATURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Group Relationship</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__GROUP_RELATIONSHIP = SERVICE_FEATURE__GROUP_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__REQUIRES = SERVICE_FEATURE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Excludes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__EXCLUDES = SERVICE_FEATURE__EXCLUDES;

	/**
	 * The feature id for the '<em><b>Service Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__SERVICE_FEATURES = SERVICE_FEATURE__SERVICE_FEATURES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__ID = SERVICE_FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__REQUIRED = SERVICE_FEATURE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Requirement Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__REQUIREMENT_WEIGHT = SERVICE_FEATURE__REQUIREMENT_WEIGHT;

	/**
	 * The feature id for the '<em><b>Feature Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE__FEATURE_TYPE = SERVICE_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Optional Service Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_SERVICE_FEATURE_FEATURE_COUNT = SERVICE_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.AttributeImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Instantiation Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__INSTANTIATION_VALUE = 0;

	/**
	 * The feature id for the '<em><b>Attribute Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ATTRIBUTE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ID = 2;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.RequiresImpl <em>Requires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.RequiresImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getRequires()
	 * @generated
	 */
	int REQUIRES = 4;

	/**
	 * The feature id for the '<em><b>Service Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES__SERVICE_FEATURE = 0;

	/**
	 * The number of structural features of the '<em>Requires</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ExcludesImpl <em>Excludes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ExcludesImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getExcludes()
	 * @generated
	 */
	int EXCLUDES = 5;

	/**
	 * The feature id for the '<em><b>Service Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES__SERVICE_FEATURE = 0;

	/**
	 * The number of structural features of the '<em>Excludes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.GroupRelationshipImpl <em>Group Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.GroupRelationshipImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getGroupRelationship()
	 * @generated
	 */
	int GROUP_RELATIONSHIP = 11;

	/**
	 * The feature id for the '<em><b>Optional Service Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES = 0;

	/**
	 * The number of structural features of the '<em>Group Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_RELATIONSHIP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ORImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getOR()
	 * @generated
	 */
	int OR = 6;

	/**
	 * The feature id for the '<em><b>Optional Service Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OPTIONAL_SERVICE_FEATURES = GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES;

	/**
	 * The feature id for the '<em><b>Min Features To Choose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__MIN_FEATURES_TO_CHOOSE = GROUP_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Features To Choose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__MAX_FEATURES_TO_CHOOSE = GROUP_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = GROUP_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.XORImpl <em>XOR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.XORImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getXOR()
	 * @generated
	 */
	int XOR = 7;

	/**
	 * The feature id for the '<em><b>Optional Service Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__OPTIONAL_SERVICE_FEATURES = GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES;

	/**
	 * The number of structural features of the '<em>XOR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = GROUP_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl <em>Service Feature Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getServiceFeatureDiagram()
	 * @generated
	 */
	int SERVICE_FEATURE_DIAGRAM = 8;

	/**
	 * The feature id for the '<em><b>Service Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_DIAGRAM__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_DIAGRAM__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_DIAGRAM__ID = 3;

	/**
	 * The number of structural features of the '<em>Service Feature Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_DIAGRAM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ID = 1;

	/**
	 * The feature id for the '<em><b>Service Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__SERVICE_FEATURES = 2;

	/**
	 * The feature id for the '<em><b>Preferences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PREFERENCES = 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ATTRIBUTES = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__SELECTED = 6;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.PreferenceImpl <em>Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.PreferenceImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getPreference()
	 * @generated
	 */
	int PREFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__CREATION_DATE = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Stakeholder Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__STAKEHOLDER_GROUP = 3;

	/**
	 * The number of structural features of the '<em>Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.MandatoryServiceFeatureImpl <em>Mandatory Service Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.MandatoryServiceFeatureImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getMandatoryServiceFeature()
	 * @generated
	 */
	int MANDATORY_SERVICE_FEATURE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__NAME = SERVICE_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__DESCRIPTION = SERVICE_FEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__ATTRIBUTES = SERVICE_FEATURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Group Relationship</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__GROUP_RELATIONSHIP = SERVICE_FEATURE__GROUP_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__REQUIRES = SERVICE_FEATURE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Excludes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__EXCLUDES = SERVICE_FEATURE__EXCLUDES;

	/**
	 * The feature id for the '<em><b>Service Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__SERVICE_FEATURES = SERVICE_FEATURE__SERVICE_FEATURES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__ID = SERVICE_FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__REQUIRED = SERVICE_FEATURE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Requirement Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__REQUIREMENT_WEIGHT = SERVICE_FEATURE__REQUIREMENT_WEIGHT;

	/**
	 * The feature id for the '<em><b>Feature Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE__FEATURE_TYPES = SERVICE_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mandatory Service Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANDATORY_SERVICE_FEATURE_FEATURE_COUNT = SERVICE_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationsImpl <em>Configurations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ConfigurationsImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getConfigurations()
	 * @generated
	 */
	int CONFIGURATIONS = 13;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATIONS__CONFIGURATIONS = 0;

	/**
	 * The number of structural features of the '<em>Configurations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypesImpl <em>Attribute Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.AttributeTypesImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttributeTypes()
	 * @generated
	 */
	int ATTRIBUTE_TYPES = 14;

	/**
	 * The feature id for the '<em><b>Attribute Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPES__ATTRIBUTE_TYPES = 0;

	/**
	 * The number of structural features of the '<em>Attribute Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttributeType()
	 * @generated
	 */
	int ATTRIBUTE_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__DOMAIN = 1;

	/**
	 * The feature id for the '<em><b>Aggregation Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__AGGREGATION_RULE = 2;

	/**
	 * The feature id for the '<em><b>Scale Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__SCALE_ORDER = 3;

	/**
	 * The feature id for the '<em><b>To Be Evaluated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__TO_BE_EVALUATED = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Custom Attribute Type Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__CUSTOM_ATTRIBUTE_TYPE_PRIORITY = 6;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__REQUIREMENT = 7;

	/**
	 * The feature id for the '<em><b>Requirement Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__REQUIREMENT_WEIGHT = 8;

	/**
	 * The number of structural features of the '<em>Attribute Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.AttributeDomain <em>Attribute Domain</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeDomain
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttributeDomain()
	 * @generated
	 */
	int ATTRIBUTE_DOMAIN = 16;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.AggregationRules <em>Aggregation Rules</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.AggregationRules
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAggregationRules()
	 * @generated
	 */
	int AGGREGATION_RULES = 17;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.ScaleOrders <em>Scale Orders</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.ScaleOrders
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getScaleOrders()
	 * @generated
	 */
	int SCALE_ORDERS = 18;

	/**
	 * The meta object id for the '{@link edu.kit.sfm.servicefeaturemodel.FeatureTypes <em>Feature Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.sfm.servicefeaturemodel.FeatureTypes
	 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getFeatureTypes()
	 * @generated
	 */
	int FEATURE_TYPES = 19;


	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.sfm.servicefeaturemodel.Service#getServiceFeatureDiagram <em>Service Feature Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Feature Diagram</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Service#getServiceFeatureDiagram()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceFeatureDiagram();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Service#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Service#getDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Description();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Service#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Service#getId()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Id();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.sfm.servicefeaturemodel.Service#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configurations</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Service#getConfigurations()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Configurations();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.sfm.servicefeaturemodel.Service#getAttributeTypes <em>Attribute Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute Types</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Service#getAttributeTypes()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_AttributeTypes();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature <em>Service Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Feature</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature
	 * @generated
	 */
	EClass getServiceFeature();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getName()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EAttribute getServiceFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getDescription()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EAttribute getServiceFeature_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getAttributes()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EReference getServiceFeature_Attributes();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getGroupRelationship <em>Group Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Group Relationship</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getGroupRelationship()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EReference getServiceFeature_GroupRelationship();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requires</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getRequires()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EReference getServiceFeature_Requires();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getExcludes <em>Excludes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Excludes</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getExcludes()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EReference getServiceFeature_Excludes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getServiceFeatures <em>Service Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Features</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getServiceFeatures()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EReference getServiceFeature_ServiceFeatures();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getId()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EAttribute getServiceFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#isRequired()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EAttribute getServiceFeature_Required();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeature#getRequirementWeight <em>Requirement Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Weight</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeature#getRequirementWeight()
	 * @see #getServiceFeature()
	 * @generated
	 */
	EAttribute getServiceFeature_RequirementWeight();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature <em>Optional Service Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optional Service Feature</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature
	 * @generated
	 */
	EClass getOptionalServiceFeature();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature#getFeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Type</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature#getFeatureType()
	 * @see #getOptionalServiceFeature()
	 * @generated
	 */
	EAttribute getOptionalServiceFeature_FeatureType();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Attribute#getInstantiationValue <em>Instantiation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instantiation Value</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Attribute#getInstantiationValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_InstantiationValue();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.sfm.servicefeaturemodel.Attribute#getAttributeType <em>Attribute Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute Type</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Attribute#getAttributeType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_AttributeType();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Attribute#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Attribute#getId()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Id();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.Requires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requires</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Requires
	 * @generated
	 */
	EClass getRequires();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.sfm.servicefeaturemodel.Requires#getServiceFeature <em>Service Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service Feature</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Requires#getServiceFeature()
	 * @see #getRequires()
	 * @generated
	 */
	EReference getRequires_ServiceFeature();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.Excludes <em>Excludes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excludes</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Excludes
	 * @generated
	 */
	EClass getExcludes();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.sfm.servicefeaturemodel.Excludes#getServiceFeature <em>Service Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service Feature</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Excludes#getServiceFeature()
	 * @see #getExcludes()
	 * @generated
	 */
	EReference getExcludes_ServiceFeature();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.OR#getMinFeaturesToChoose <em>Min Features To Choose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Features To Choose</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.OR#getMinFeaturesToChoose()
	 * @see #getOR()
	 * @generated
	 */
	EAttribute getOR_MinFeaturesToChoose();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.OR#getMaxFeaturesToChoose <em>Max Features To Choose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Features To Choose</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.OR#getMaxFeaturesToChoose()
	 * @see #getOR()
	 * @generated
	 */
	EAttribute getOR_MaxFeaturesToChoose();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.XOR <em>XOR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XOR</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.XOR
	 * @generated
	 */
	EClass getXOR();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram <em>Service Feature Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Feature Diagram</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram
	 * @generated
	 */
	EClass getServiceFeatureDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getServiceFeatures <em>Service Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Features</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getServiceFeatures()
	 * @see #getServiceFeatureDiagram()
	 * @generated
	 */
	EReference getServiceFeatureDiagram_ServiceFeatures();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getName()
	 * @see #getServiceFeatureDiagram()
	 * @generated
	 */
	EAttribute getServiceFeatureDiagram_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getDescription()
	 * @see #getServiceFeatureDiagram()
	 * @generated
	 */
	EAttribute getServiceFeatureDiagram_Description();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram#getId()
	 * @see #getServiceFeatureDiagram()
	 * @generated
	 */
	EAttribute getServiceFeatureDiagram_Id();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Configuration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration#getId()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Id();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.sfm.servicefeaturemodel.Configuration#getServiceFeatures <em>Service Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Service Features</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration#getServiceFeatures()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ServiceFeatures();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.Configuration#getPreferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preferences</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration#getPreferences()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Preferences();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.Configuration#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration#getAttributes()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Configuration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration#getDescription()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Description();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Configuration#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configuration#isSelected()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Selected();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.Preference <em>Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preference</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Preference
	 * @generated
	 */
	EClass getPreference();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Preference#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Preference#getCreationDate()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_CreationDate();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Preference#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Preference#getDescription()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_Description();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Preference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Preference#getValue()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_Value();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.Preference#getStakeholderGroup <em>Stakeholder Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stakeholder Group</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Preference#getStakeholderGroup()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_StakeholderGroup();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.GroupRelationship <em>Group Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Relationship</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.GroupRelationship
	 * @generated
	 */
	EClass getGroupRelationship();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.GroupRelationship#getOptionalServiceFeatures <em>Optional Service Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Optional Service Features</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.GroupRelationship#getOptionalServiceFeatures()
	 * @see #getGroupRelationship()
	 * @generated
	 */
	EReference getGroupRelationship_OptionalServiceFeatures();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature <em>Mandatory Service Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mandatory Service Feature</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature
	 * @generated
	 */
	EClass getMandatoryServiceFeature();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature#getFeatureTypes <em>Feature Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Types</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature#getFeatureTypes()
	 * @see #getMandatoryServiceFeature()
	 * @generated
	 */
	EAttribute getMandatoryServiceFeature_FeatureTypes();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.Configurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configurations</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configurations
	 * @generated
	 */
	EClass getConfigurations();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.Configurations#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.Configurations#getConfigurations()
	 * @see #getConfigurations()
	 * @generated
	 */
	EReference getConfigurations_Configurations();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.AttributeTypes <em>Attribute Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Types</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeTypes
	 * @generated
	 */
	EClass getAttributeTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.sfm.servicefeaturemodel.AttributeTypes#getAttributeTypes <em>Attribute Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute Types</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeTypes#getAttributeTypes()
	 * @see #getAttributeTypes()
	 * @generated
	 */
	EReference getAttributeTypes_AttributeTypes();

	/**
	 * Returns the meta object for class '{@link edu.kit.sfm.servicefeaturemodel.AttributeType <em>Attribute Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Type</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType
	 * @generated
	 */
	EClass getAttributeType();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getName()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getDomain()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_Domain();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getAggregationRule <em>Aggregation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregation Rule</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getAggregationRule()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_AggregationRule();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getScaleOrder <em>Scale Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale Order</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getScaleOrder()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_ScaleOrder();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#isToBeEvaluated <em>To Be Evaluated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Be Evaluated</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#isToBeEvaluated()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_ToBeEvaluated();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getDescription()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_Description();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getCustomAttributeTypePriority <em>Custom Attribute Type Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attribute Type Priority</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getCustomAttributeTypePriority()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_CustomAttributeTypePriority();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirement()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_Requirement();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirementWeight <em>Requirement Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Weight</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeType#getRequirementWeight()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_RequirementWeight();

	/**
	 * Returns the meta object for enum '{@link edu.kit.sfm.servicefeaturemodel.AttributeDomain <em>Attribute Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Attribute Domain</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AttributeDomain
	 * @generated
	 */
	EEnum getAttributeDomain();

	/**
	 * Returns the meta object for enum '{@link edu.kit.sfm.servicefeaturemodel.AggregationRules <em>Aggregation Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aggregation Rules</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.AggregationRules
	 * @generated
	 */
	EEnum getAggregationRules();

	/**
	 * Returns the meta object for enum '{@link edu.kit.sfm.servicefeaturemodel.ScaleOrders <em>Scale Orders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scale Orders</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.ScaleOrders
	 * @generated
	 */
	EEnum getScaleOrders();

	/**
	 * Returns the meta object for enum '{@link edu.kit.sfm.servicefeaturemodel.FeatureTypes <em>Feature Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Types</em>'.
	 * @see edu.kit.sfm.servicefeaturemodel.FeatureTypes
	 * @generated
	 */
	EEnum getFeatureTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServicefeaturemodelFactory getServicefeaturemodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServiceImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Service Feature Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_FEATURE_DIAGRAM = eINSTANCE.getService_ServiceFeatureDiagram();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__DESCRIPTION = eINSTANCE.getService_Description();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__ID = eINSTANCE.getService_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__CONFIGURATIONS = eINSTANCE.getService_Configurations();

		/**
		 * The meta object literal for the '<em><b>Attribute Types</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__ATTRIBUTE_TYPES = eINSTANCE.getService_AttributeTypes();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureImpl <em>Service Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getServiceFeature()
		 * @generated
		 */
		EClass SERVICE_FEATURE = eINSTANCE.getServiceFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE__NAME = eINSTANCE.getServiceFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE__DESCRIPTION = eINSTANCE.getServiceFeature_Description();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FEATURE__ATTRIBUTES = eINSTANCE.getServiceFeature_Attributes();

		/**
		 * The meta object literal for the '<em><b>Group Relationship</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FEATURE__GROUP_RELATIONSHIP = eINSTANCE.getServiceFeature_GroupRelationship();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FEATURE__REQUIRES = eINSTANCE.getServiceFeature_Requires();

		/**
		 * The meta object literal for the '<em><b>Excludes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FEATURE__EXCLUDES = eINSTANCE.getServiceFeature_Excludes();

		/**
		 * The meta object literal for the '<em><b>Service Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FEATURE__SERVICE_FEATURES = eINSTANCE.getServiceFeature_ServiceFeatures();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE__ID = eINSTANCE.getServiceFeature_Id();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE__REQUIRED = eINSTANCE.getServiceFeature_Required();

		/**
		 * The meta object literal for the '<em><b>Requirement Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE__REQUIREMENT_WEIGHT = eINSTANCE.getServiceFeature_RequirementWeight();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.OptionalServiceFeatureImpl <em>Optional Service Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.OptionalServiceFeatureImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getOptionalServiceFeature()
		 * @generated
		 */
		EClass OPTIONAL_SERVICE_FEATURE = eINSTANCE.getOptionalServiceFeature();

		/**
		 * The meta object literal for the '<em><b>Feature Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIONAL_SERVICE_FEATURE__FEATURE_TYPE = eINSTANCE.getOptionalServiceFeature_FeatureType();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.AttributeImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Instantiation Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__INSTANTIATION_VALUE = eINSTANCE.getAttribute_InstantiationValue();

		/**
		 * The meta object literal for the '<em><b>Attribute Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__ATTRIBUTE_TYPE = eINSTANCE.getAttribute_AttributeType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__ID = eINSTANCE.getAttribute_Id();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.RequiresImpl <em>Requires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.RequiresImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getRequires()
		 * @generated
		 */
		EClass REQUIRES = eINSTANCE.getRequires();

		/**
		 * The meta object literal for the '<em><b>Service Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRES__SERVICE_FEATURE = eINSTANCE.getRequires_ServiceFeature();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ExcludesImpl <em>Excludes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ExcludesImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getExcludes()
		 * @generated
		 */
		EClass EXCLUDES = eINSTANCE.getExcludes();

		/**
		 * The meta object literal for the '<em><b>Service Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUDES__SERVICE_FEATURE = eINSTANCE.getExcludes_ServiceFeature();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ORImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

		/**
		 * The meta object literal for the '<em><b>Min Features To Choose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OR__MIN_FEATURES_TO_CHOOSE = eINSTANCE.getOR_MinFeaturesToChoose();

		/**
		 * The meta object literal for the '<em><b>Max Features To Choose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OR__MAX_FEATURES_TO_CHOOSE = eINSTANCE.getOR_MaxFeaturesToChoose();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.XORImpl <em>XOR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.XORImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getXOR()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXOR();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl <em>Service Feature Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServiceFeatureDiagramImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getServiceFeatureDiagram()
		 * @generated
		 */
		EClass SERVICE_FEATURE_DIAGRAM = eINSTANCE.getServiceFeatureDiagram();

		/**
		 * The meta object literal for the '<em><b>Service Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FEATURE_DIAGRAM__SERVICE_FEATURES = eINSTANCE.getServiceFeatureDiagram_ServiceFeatures();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE_DIAGRAM__NAME = eINSTANCE.getServiceFeatureDiagram_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE_DIAGRAM__DESCRIPTION = eINSTANCE.getServiceFeatureDiagram_Description();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FEATURE_DIAGRAM__ID = eINSTANCE.getServiceFeatureDiagram_Id();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ConfigurationImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__ID = eINSTANCE.getConfiguration_Id();

		/**
		 * The meta object literal for the '<em><b>Service Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__SERVICE_FEATURES = eINSTANCE.getConfiguration_ServiceFeatures();

		/**
		 * The meta object literal for the '<em><b>Preferences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__PREFERENCES = eINSTANCE.getConfiguration_Preferences();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__ATTRIBUTES = eINSTANCE.getConfiguration_Attributes();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__DESCRIPTION = eINSTANCE.getConfiguration_Description();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__SELECTED = eINSTANCE.getConfiguration_Selected();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.PreferenceImpl <em>Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.PreferenceImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getPreference()
		 * @generated
		 */
		EClass PREFERENCE = eINSTANCE.getPreference();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__CREATION_DATE = eINSTANCE.getPreference_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__DESCRIPTION = eINSTANCE.getPreference_Description();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__VALUE = eINSTANCE.getPreference_Value();

		/**
		 * The meta object literal for the '<em><b>Stakeholder Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__STAKEHOLDER_GROUP = eINSTANCE.getPreference_StakeholderGroup();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.GroupRelationshipImpl <em>Group Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.GroupRelationshipImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getGroupRelationship()
		 * @generated
		 */
		EClass GROUP_RELATIONSHIP = eINSTANCE.getGroupRelationship();

		/**
		 * The meta object literal for the '<em><b>Optional Service Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_RELATIONSHIP__OPTIONAL_SERVICE_FEATURES = eINSTANCE.getGroupRelationship_OptionalServiceFeatures();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.MandatoryServiceFeatureImpl <em>Mandatory Service Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.MandatoryServiceFeatureImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getMandatoryServiceFeature()
		 * @generated
		 */
		EClass MANDATORY_SERVICE_FEATURE = eINSTANCE.getMandatoryServiceFeature();

		/**
		 * The meta object literal for the '<em><b>Feature Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANDATORY_SERVICE_FEATURE__FEATURE_TYPES = eINSTANCE.getMandatoryServiceFeature_FeatureTypes();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.ConfigurationsImpl <em>Configurations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ConfigurationsImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getConfigurations()
		 * @generated
		 */
		EClass CONFIGURATIONS = eINSTANCE.getConfigurations();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATIONS__CONFIGURATIONS = eINSTANCE.getConfigurations_Configurations();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypesImpl <em>Attribute Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.AttributeTypesImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttributeTypes()
		 * @generated
		 */
		EClass ATTRIBUTE_TYPES = eINSTANCE.getAttributeTypes();

		/**
		 * The meta object literal for the '<em><b>Attribute Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_TYPES__ATTRIBUTE_TYPES = eINSTANCE.getAttributeTypes_AttributeTypes();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.impl.AttributeTypeImpl
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttributeType()
		 * @generated
		 */
		EClass ATTRIBUTE_TYPE = eINSTANCE.getAttributeType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__NAME = eINSTANCE.getAttributeType_Name();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__DOMAIN = eINSTANCE.getAttributeType_Domain();

		/**
		 * The meta object literal for the '<em><b>Aggregation Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__AGGREGATION_RULE = eINSTANCE.getAttributeType_AggregationRule();

		/**
		 * The meta object literal for the '<em><b>Scale Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__SCALE_ORDER = eINSTANCE.getAttributeType_ScaleOrder();

		/**
		 * The meta object literal for the '<em><b>To Be Evaluated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__TO_BE_EVALUATED = eINSTANCE.getAttributeType_ToBeEvaluated();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__DESCRIPTION = eINSTANCE.getAttributeType_Description();

		/**
		 * The meta object literal for the '<em><b>Custom Attribute Type Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__CUSTOM_ATTRIBUTE_TYPE_PRIORITY = eINSTANCE.getAttributeType_CustomAttributeTypePriority();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__REQUIREMENT = eINSTANCE.getAttributeType_Requirement();

		/**
		 * The meta object literal for the '<em><b>Requirement Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__REQUIREMENT_WEIGHT = eINSTANCE.getAttributeType_RequirementWeight();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.AttributeDomain <em>Attribute Domain</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.AttributeDomain
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAttributeDomain()
		 * @generated
		 */
		EEnum ATTRIBUTE_DOMAIN = eINSTANCE.getAttributeDomain();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.AggregationRules <em>Aggregation Rules</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.AggregationRules
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getAggregationRules()
		 * @generated
		 */
		EEnum AGGREGATION_RULES = eINSTANCE.getAggregationRules();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.ScaleOrders <em>Scale Orders</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.ScaleOrders
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getScaleOrders()
		 * @generated
		 */
		EEnum SCALE_ORDERS = eINSTANCE.getScaleOrders();

		/**
		 * The meta object literal for the '{@link edu.kit.sfm.servicefeaturemodel.FeatureTypes <em>Feature Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.sfm.servicefeaturemodel.FeatureTypes
		 * @see edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelPackageImpl#getFeatureTypes()
		 * @generated
		 */
		EEnum FEATURE_TYPES = eINSTANCE.getFeatureTypes();

	}

} //ServicefeaturemodelPackage
