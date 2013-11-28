/**
 */
package edu.kit.sfm.servicefeaturemodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Attribute Domain</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAttributeDomain()
 * @model
 * @generated
 */
public enum AttributeDomain implements Enumerator {
	/**
	 * The '<em><b>Continuous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS_VALUE
	 * @generated
	 * @ordered
	 */
	CONTINUOUS(1, "Continuous", "Continuous"),

	/**
	 * The '<em><b>Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
	BOOLEAN(0, "Boolean", "Boolean");

	/**
	 * The '<em><b>Continuous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Continuous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS
	 * @model name="Continuous"
	 * @generated
	 * @ordered
	 */
	public static final int CONTINUOUS_VALUE = 1;

	/**
	 * The '<em><b>Boolean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @model name="Boolean"
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_VALUE = 0;

	/**
	 * An array of all the '<em><b>Attribute Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AttributeDomain[] VALUES_ARRAY =
		new AttributeDomain[] {
			CONTINUOUS,
			BOOLEAN,
		};

	/**
	 * A public read-only list of all the '<em><b>Attribute Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AttributeDomain> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Attribute Domain</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AttributeDomain get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AttributeDomain result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Attribute Domain</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AttributeDomain getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AttributeDomain result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Attribute Domain</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AttributeDomain get(int value) {
		switch (value) {
			case CONTINUOUS_VALUE: return CONTINUOUS;
			case BOOLEAN_VALUE: return BOOLEAN;
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
	private AttributeDomain(int value, String name, String literal) {
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
	
} //AttributeDomain
