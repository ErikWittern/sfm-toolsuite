/**
 */
package edu.kit.sfm.servicefeaturemodel;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configurations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.sfm.servicefeaturemodel.Configurations#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getConfigurations()
 * @model
 * @generated
 */
public interface Configurations extends EObject {
	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.sfm.servicefeaturemodel.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getConfigurations_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	List<Configuration> getConfigurations();

} // Configurations
