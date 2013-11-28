/**
 */
package edu.kit.sfm.servicefeaturemodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Aggregation Rules</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.kit.sfm.servicefeaturemodel.ServicefeaturemodelPackage#getAggregationRules()
 * @model
 * @generated
 */
public enum AggregationRules implements Enumerator {
	/**
	 * The '<em><b>Sum</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUM_VALUE
	 * @generated
	 * @ordered
	 */
	SUM(0, "Sum", "Sum"),

	/**
	 * The '<em><b>Product</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCT_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCT(1, "Product", "Product"),

	/**
	 * The '<em><b>At Least Once</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AT_LEAST_ONCE_VALUE
	 * @generated
	 * @ordered
	 */
	AT_LEAST_ONCE(2, "AtLeastOnce", "AtLeastOnce"),

	/**
	 * The '<em><b>Minimum</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINIMUM_VALUE
	 * @generated
	 * @ordered
	 */
	MINIMUM(3, "Minimum", "Minimum"),

	/**
	 * The '<em><b>Maximum</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAXIMUM_VALUE
	 * @generated
	 * @ordered
	 */
	MAXIMUM(4, "Maximum", "Maximum");

	/**
	 * The '<em><b>Sum</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sum</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUM
	 * @model name="Sum"
	 * @generated
	 * @ordered
	 */
	public static final int SUM_VALUE = 0;

	/**
	 * The '<em><b>Product</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Product</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCT
	 * @model name="Product"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT_VALUE = 1;

	/**
	 * The '<em><b>At Least Once</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>At Least Once</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AT_LEAST_ONCE
	 * @model name="AtLeastOnce"
	 * @generated
	 * @ordered
	 */
	public static final int AT_LEAST_ONCE_VALUE = 2;

	/**
	 * The '<em><b>Minimum</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Minimum</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINIMUM
	 * @model name="Minimum"
	 * @generated
	 * @ordered
	 */
	public static final int MINIMUM_VALUE = 3;

	/**
	 * The '<em><b>Maximum</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Maximum</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAXIMUM
	 * @model name="Maximum"
	 * @generated
	 * @ordered
	 */
	public static final int MAXIMUM_VALUE = 4;

	/**
	 * An array of all the '<em><b>Aggregation Rules</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AggregationRules[] VALUES_ARRAY =
		new AggregationRules[] {
			SUM,
			PRODUCT,
			AT_LEAST_ONCE,
			MINIMUM,
			MAXIMUM,
		};

	/**
	 * A public read-only list of all the '<em><b>Aggregation Rules</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AggregationRules> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Aggregation Rules</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AggregationRules get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AggregationRules result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Aggregation Rules</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AggregationRules getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AggregationRules result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Aggregation Rules</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AggregationRules get(int value) {
		switch (value) {
			case SUM_VALUE: return SUM;
			case PRODUCT_VALUE: return PRODUCT;
			case AT_LEAST_ONCE_VALUE: return AT_LEAST_ONCE;
			case MINIMUM_VALUE: return MINIMUM;
			case MAXIMUM_VALUE: return MAXIMUM;
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
	private AggregationRules(int value, String name, String literal) {
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
	
} //AggregationRules
