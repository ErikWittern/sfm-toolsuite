/**
 */
package edu.kit.cockpit.sfmdesigner.servicefeaturemodel;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.GroupRelationship#getOptionalServiceFeatures <em>Optional Service Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage#getGroupRelationship()
 * @model abstract="true"
 * @generated
 */
public interface GroupRelationship extends EObject {
	/**
	 * Returns the value of the '<em><b>Optional Service Features</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.cockpit.sfmdesigner.servicefeaturemodel.OptionalServiceFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Service Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Service Features</em>' containment reference list.
	 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage#getGroupRelationship_OptionalServiceFeatures()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	List<OptionalServiceFeature> getOptionalServiceFeatures();

} // GroupRelationship
