/**
 */
package edu.kit.cockpit.sfmdesigner.servicefeaturemodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Scale Orders</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage#getScaleOrders()
 * @model
 * @generated
 */
public enum ScaleOrders implements Enumerator {
	/**
	 * The '<em><b>Higher Is Better</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHER_IS_BETTER_VALUE
	 * @generated
	 * @ordered
	 */
	HIGHER_IS_BETTER(0, "HigherIsBetter", "HigherIsBetter"),

	/**
	 * The '<em><b>Lower Is Better</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_IS_BETTER_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_IS_BETTER(1, "LowerIsBetter", "LowerIsBetter"),

	/**
	 * The '<em><b>Existence Is Better</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXISTENCE_IS_BETTER_VALUE
	 * @generated
	 * @ordered
	 */
	EXISTENCE_IS_BETTER(2, "ExistenceIsBetter", "ExistenceIsBetter");

	/**
	 * The '<em><b>Higher Is Better</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Higher Is Better</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIGHER_IS_BETTER
	 * @model name="HigherIsBetter"
	 * @generated
	 * @ordered
	 */
	public static final int HIGHER_IS_BETTER_VALUE = 0;

	/**
	 * The '<em><b>Lower Is Better</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lower Is Better</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_IS_BETTER
	 * @model name="LowerIsBetter"
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_IS_BETTER_VALUE = 1;

	/**
	 * The '<em><b>Existence Is Better</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Existence Is Better</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXISTENCE_IS_BETTER
	 * @model name="ExistenceIsBetter"
	 * @generated
	 * @ordered
	 */
	public static final int EXISTENCE_IS_BETTER_VALUE = 2;

	/**
	 * An array of all the '<em><b>Scale Orders</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ScaleOrders[] VALUES_ARRAY =
		new ScaleOrders[] {
			HIGHER_IS_BETTER,
			LOWER_IS_BETTER,
			EXISTENCE_IS_BETTER,
		};

	/**
	 * A public read-only list of all the '<em><b>Scale Orders</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ScaleOrders> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Scale Orders</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaleOrders get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ScaleOrders result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Scale Orders</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaleOrders getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ScaleOrders result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Scale Orders</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaleOrders get(int value) {
		switch (value) {
			case HIGHER_IS_BETTER_VALUE: return HIGHER_IS_BETTER;
			case LOWER_IS_BETTER_VALUE: return LOWER_IS_BETTER;
			case EXISTENCE_IS_BETTER_VALUE: return EXISTENCE_IS_BETTER;
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
	private ScaleOrders(int value, String name, String literal) {
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
	
} //ScaleOrders
