/**
 */
package edu.kit.sfm.servicefeaturemodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage
 * @generated
 */
public interface ServicefeaturemodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicefeaturemodelFactory eINSTANCE = edu.kit.sfm.servicefeaturemodel.impl.ServicefeaturemodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	Service createService();

	/**
	 * Returns a new object of class '<em>Optional Service Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Optional Service Feature</em>'.
	 * @generated
	 */
	OptionalServiceFeature createOptionalServiceFeature();

	/**
	 * Returns a new object of class '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute</em>'.
	 * @generated
	 */
	Attribute createAttribute();

	/**
	 * Returns a new object of class '<em>Requires</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requires</em>'.
	 * @generated
	 */
	Requires createRequires();

	/**
	 * Returns a new object of class '<em>Excludes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Excludes</em>'.
	 * @generated
	 */
	Excludes createExcludes();

	/**
	 * Returns a new object of class '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OR</em>'.
	 * @generated
	 */
	OR createOR();

	/**
	 * Returns a new object of class '<em>XOR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XOR</em>'.
	 * @generated
	 */
	XOR createXOR();

	/**
	 * Returns a new object of class '<em>Service Feature Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Feature Diagram</em>'.
	 * @generated
	 */
	ServiceFeatureDiagram createServiceFeatureDiagram();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Preference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preference</em>'.
	 * @generated
	 */
	Preference createPreference();

	/**
	 * Returns a new object of class '<em>Mandatory Service Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mandatory Service Feature</em>'.
	 * @generated
	 */
	MandatoryServiceFeature createMandatoryServiceFeature();

	/**
	 * Returns a new object of class '<em>Configurations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configurations</em>'.
	 * @generated
	 */
	Configurations createConfigurations();

	/**
	 * Returns a new object of class '<em>Attribute Types</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Types</em>'.
	 * @generated
	 */
	AttributeTypes createAttributeTypes();

	/**
	 * Returns a new object of class '<em>Attribute Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Type</em>'.
	 * @generated
	 */
	AttributeType createAttributeType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ServicefeaturemodelPackage getServicefeaturemodelPackage();

} //ServicefeaturemodelFactory
