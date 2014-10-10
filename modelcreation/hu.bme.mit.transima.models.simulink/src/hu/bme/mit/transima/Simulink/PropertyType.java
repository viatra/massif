/**
 */
package hu.bme.mit.transima.Simulink;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;
import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Property Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This EEnum represents the possible value types of #{simulink.Property} elements.
 * <!-- end-model-doc -->
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getPropertyType()
 * @model
 * @generated
 */
public enum PropertyType implements Enumerator
{
    /**
     * The '<em><b>String Property</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #STRING_PROPERTY_VALUE
     * @generated
     * @ordered
     */
    STRING_PROPERTY(0, "StringProperty", "StringProperty"),
    /**
     * The '<em><b>Integer Property</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INTEGER_PROPERTY_VALUE
     * @generated
     * @ordered
     */
    INTEGER_PROPERTY(1, "IntegerProperty", "IntegerProperty"),
    /**
     * The '<em><b>Double Property</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOUBLE_PROPERTY_VALUE
     * @generated
     * @ordered
     */
    DOUBLE_PROPERTY(2, "DoubleProperty", "DoubleProperty");
    /**
     * The '<em><b>String Property</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>String Property</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #STRING_PROPERTY
     * @model name="StringProperty"
     * @generated
     * @ordered
     */
    public static final int STRING_PROPERTY_VALUE = 0;

    /**
     * The '<em><b>Integer Property</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Integer Property</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INTEGER_PROPERTY
     * @model name="IntegerProperty"
     * @generated
     * @ordered
     */
    public static final int INTEGER_PROPERTY_VALUE = 1;

    /**
     * The '<em><b>Double Property</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Double Property</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DOUBLE_PROPERTY
     * @model name="DoubleProperty"
     * @generated
     * @ordered
     */
    public static final int DOUBLE_PROPERTY_VALUE = 2;

    /**
     * An array of all the '<em><b>Property Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final PropertyType[] VALUES_ARRAY =
        new PropertyType[] {
            STRING_PROPERTY,
            INTEGER_PROPERTY,
            DOUBLE_PROPERTY,
        };

    /**
     * A public read-only list of all the '<em><b>Property Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<PropertyType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Property Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PropertyType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PropertyType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Property Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PropertyType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PropertyType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Property Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PropertyType get(int value) {
        switch (value) {
            case STRING_PROPERTY_VALUE: return STRING_PROPERTY;
            case INTEGER_PROPERTY_VALUE: return INTEGER_PROPERTY;
            case DOUBLE_PROPERTY_VALUE: return DOUBLE_PROPERTY;
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
    private PropertyType(int value, String name, String literal) {
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
}
