/**
 */
package edu.kit.sfm.servicefeaturemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OR</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.OR#getMinFeaturesToChoose <em>Min Features To Choose</em>}</li>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.OR#getMaxFeaturesToChoose <em>Max Features To Choose</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getOR()
 * @model
 * @generated
 */
public interface OR extends GroupRelationship {
	/**
	 * Returns the value of the '<em><b>Min Features To Choose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Features To Choose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Features To Choose</em>' attribute.
	 * @see #setMinFeaturesToChoose(int)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getOR_MinFeaturesToChoose()
	 * @model
	 * @generated
	 */
	int getMinFeaturesToChoose();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.OR#getMinFeaturesToChoose <em>Min Features To Choose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Features To Choose</em>' attribute.
	 * @see #getMinFeaturesToChoose()
	 * @generated
	 */
	void setMinFeaturesToChoose(int value);

	/**
	 * Returns the value of the '<em><b>Max Features To Choose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Features To Choose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Features To Choose</em>' attribute.
	 * @see #setMaxFeaturesToChoose(int)
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getOR_MaxFeaturesToChoose()
	 * @model
	 * @generated
	 */
	int getMaxFeaturesToChoose();

	/**
	 * Sets the value of the '{@link edu.kit.sfm.servicefeaturemodel.OR#getMaxFeaturesToChoose <em>Max Features To Choose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Features To Choose</em>' attribute.
	 * @see #getMaxFeaturesToChoose()
	 * @generated
	 */
	void setMaxFeaturesToChoose(int value);

} // OR
