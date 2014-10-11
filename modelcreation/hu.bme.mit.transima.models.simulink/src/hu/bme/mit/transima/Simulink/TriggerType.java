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
 * A representation of the literals of the enumeration '<em><b>Trigger Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This EEnum represents the possible events that can trigger the execution of a subsystem with a #{simulink.Trigger} port.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/trigger.html}
 * <!-- end-model-doc -->
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getTriggerType()
 * @model
 * @generated
 */
public enum TriggerType implements Enumerator
{
    /**
	 * The '<em><b>Rising</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #RISING_VALUE
	 * @generated
	 * @ordered
	 */
    RISING(0, "Rising", "Rising"),
    /**
	 * The '<em><b>Falling</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FALLING_VALUE
	 * @generated
	 * @ordered
	 */
    FALLING(1, "Falling", "Falling"),
    /**
	 * The '<em><b>Either</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #EITHER_VALUE
	 * @generated
	 * @ordered
	 */
    EITHER(2, "Either", "Either"),
    /**
	 * The '<em><b>Function Call</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FUNCTION_CALL_VALUE
	 * @generated
	 * @ordered
	 */
    FUNCTION_CALL(3, "FunctionCall", "FunctionCall");
    /**
	 * The '<em><b>Rising</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Rising</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #RISING
	 * @model name="Rising"
	 * @generated
	 * @ordered
	 */
    public static final int RISING_VALUE = 0;

    /**
	 * The '<em><b>Falling</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Falling</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FALLING
	 * @model name="Falling"
	 * @generated
	 * @ordered
	 */
    public static final int FALLING_VALUE = 1;

    /**
	 * The '<em><b>Either</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Either</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #EITHER
	 * @model name="Either"
	 * @generated
	 * @ordered
	 */
    public static final int EITHER_VALUE = 2;

    /**
	 * The '<em><b>Function Call</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Function Call</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FUNCTION_CALL
	 * @model name="FunctionCall"
	 * @generated
	 * @ordered
	 */
    public static final int FUNCTION_CALL_VALUE = 3;

    /**
	 * An array of all the '<em><b>Trigger Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private static final TriggerType[] VALUES_ARRAY =
        new TriggerType[] {
			RISING,
			FALLING,
			EITHER,
			FUNCTION_CALL,
		};

    /**
	 * A public read-only list of all the '<em><b>Trigger Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final List<TriggerType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
	 * Returns the '<em><b>Trigger Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static TriggerType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TriggerType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>Trigger Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static TriggerType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TriggerType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>Trigger Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static TriggerType get(int value) {
		switch (value) {
			case RISING_VALUE: return RISING;
			case FALLING_VALUE: return FALLING;
			case EITHER_VALUE: return EITHER;
			case FUNCTION_CALL_VALUE: return FUNCTION_CALL;
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
    private TriggerType(int value, String name, String literal) {
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
