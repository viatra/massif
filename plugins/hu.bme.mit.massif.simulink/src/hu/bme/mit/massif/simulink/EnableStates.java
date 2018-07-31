/**
 */
package hu.bme.mit.massif.simulink;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Enable States</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This EEnum represents the possible settings of a #{simulink.Enable} port for specifying what happens to the states of blocks in the enabled system upon disabling.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/enable.html}
 * <!-- end-model-doc -->
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getEnableStates()
 * @model
 * @generated
 */
public enum EnableStates implements Enumerator {
    /**
     * The '<em><b>Held</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #HELD_VALUE
     * @generated
     * @ordered
     */
    HELD(0, "Held", "Held"),

    /**
     * The '<em><b>Reset</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RESET_VALUE
     * @generated
     * @ordered
     */
    RESET(1, "Reset", "Reset"),

    /**
     * The '<em><b>Inherit</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INHERIT_VALUE
     * @generated
     * @ordered
     */
    INHERIT(2, "Inherit", "Inherit");

    /**
     * The '<em><b>Held</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Held</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #HELD
     * @model name="Held"
     * @generated
     * @ordered
     */
    public static final int HELD_VALUE = 0;

    /**
     * The '<em><b>Reset</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Reset</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RESET
     * @model name="Reset"
     * @generated
     * @ordered
     */
    public static final int RESET_VALUE = 1;

    /**
     * The '<em><b>Inherit</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Inherit</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INHERIT
     * @model name="Inherit"
     * @generated
     * @ordered
     */
    public static final int INHERIT_VALUE = 2;

    /**
     * An array of all the '<em><b>Enable States</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final EnableStates[] VALUES_ARRAY =
        new EnableStates[] {
            HELD,
            RESET,
            INHERIT,
        };

    /**
     * A public read-only list of all the '<em><b>Enable States</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<EnableStates> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Enable States</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static EnableStates get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            EnableStates result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Enable States</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static EnableStates getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            EnableStates result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Enable States</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static EnableStates get(int value) {
        switch (value) {
            case HELD_VALUE: return HELD;
            case RESET_VALUE: return RESET;
            case INHERIT_VALUE: return INHERIT;
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
    private EnableStates(int value, String name, String literal) {
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
    
} //EnableStates
