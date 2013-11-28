/**
 */
package edu.kit.sfm.servicefeaturemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optional Service Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature#getFeatureType <em>Feature Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getOptionalServiceFeature()
 * @model
 * @generated
 */
public interface OptionalServiceFeature extends ServiceFeature {
	/**
	 * Returns the value of the '<em><b>Feature Type</b></em>' attribute.
	 * The default value is <code>"InstanceFeature"</code>.
	 * The literals are from the enumeration {@link edu.kit.sfm.servicefeaturemodel.FeatureTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Type</em>' attribute.
	 * @see edu.kit.sfm.servicefeaturemodel.FeatureTypes
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getOptionalServiceFeature_FeatureType()
	 * @model default="InstanceFeature" changeable="false"
	 * @generated
	 */
	FeatureTypes getFeatureType();

} // OptionalServiceFeature
