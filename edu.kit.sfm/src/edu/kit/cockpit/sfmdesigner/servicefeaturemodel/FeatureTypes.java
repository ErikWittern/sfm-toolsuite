/**
 */
package edu.kit.cockpit.sfmdesigner.servicefeaturemodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Feature Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage#getFeatureTypes()
 * @model
 * @generated
 */
public enum FeatureTypes implements Enumerator {
	/**
	 * The '<em><b>Grouping Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GROUPING_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	GROUPING_FEATURE(0, "GroupingFeature", "GroupingFeature"),

	/**
	 * The '<em><b>Abstract Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	ABSTRACT_FEATURE(1, "AbstractFeature", "AbstractFeature"),

	/**
	 * The '<em><b>Instance Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	INSTANCE_FEATURE(2, "InstanceFeature", "InstanceFeature");

	/**
	 * The '<em><b>Grouping Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Grouping Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GROUPING_FEATURE
	 * @model name="GroupingFeature"
	 * @generated
	 * @ordered
	 */
	public static final int GROUPING_FEATURE_VALUE = 0;

	/**
	 * The '<em><b>Abstract Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Abstract Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_FEATURE
	 * @model name="AbstractFeature"
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_FEATURE_VALUE = 1;

	/**
	 * The '<em><b>Instance Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Instance Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_FEATURE
	 * @model name="InstanceFeature"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANCE_FEATURE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Feature Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FeatureTypes[] VALUES_ARRAY =
		new FeatureTypes[] {
			GROUPING_FEATURE,
			ABSTRACT_FEATURE,
			INSTANCE_FEATURE,
		};

	/**
	 * A public read-only list of all the '<em><b>Feature Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FeatureTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Feature Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureTypes get(int value) {
		switch (value) {
			case GROUPING_FEATURE_VALUE: return GROUPING_FEATURE;
			case ABSTRACT_FEATURE_VALUE: return ABSTRACT_FEATURE;
			case INSTANCE_FEATURE_VALUE: return INSTANCE_FEATURE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FeatureTypes(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FeatureTypes
