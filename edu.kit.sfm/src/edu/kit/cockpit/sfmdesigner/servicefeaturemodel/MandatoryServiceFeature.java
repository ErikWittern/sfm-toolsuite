/**
 */
package edu.kit.cockpit.sfmdesigner.servicefeaturemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mandatory Service Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.MandatoryServiceFeature#getFeatureTypes <em>Feature Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage#getMandatoryServiceFeature()
 * @model
 * @generated
 */
public interface MandatoryServiceFeature extends ServiceFeature {
	/**
	 * Returns the value of the '<em><b>Feature Types</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.FeatureTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Types</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Types</em>' attribute.
	 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.FeatureTypes
	 * @see #setFeatureTypes(FeatureTypes)
	 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage#getMandatoryServiceFeature_FeatureTypes()
	 * @model
	 * @generated
	 */
	FeatureTypes getFeatureTypes();

	/**
	 * Sets the value of the '{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.MandatoryServiceFeature#getFeatureTypes <em>Feature Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Types</em>' attribute.
	 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.FeatureTypes
	 * @see #getFeatureTypes()
	 * @generated
	 */
	void setFeatureTypes(FeatureTypes value);

} // MandatoryServiceFeature
