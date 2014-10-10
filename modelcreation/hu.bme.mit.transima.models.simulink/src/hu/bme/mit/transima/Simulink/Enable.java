/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents an enable port of a #{simulink.Block}.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/enable.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.Enable#getStatesWhenEnabling <em>States When Enabling</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getEnable()
 * @model
 * @generated
 */
public interface Enable extends InPort {
    /**
     * Returns the value of the '<em><b>States When Enabling</b></em>' attribute.
     * The literals are from the enumeration {@link hu.bme.mit.transima.Simulink.EnableStates}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>States When Enabling</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>States When Enabling</em>' attribute.
     * @see hu.bme.mit.transima.Simulink.EnableStates
     * @see #setStatesWhenEnabling(EnableStates)
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getEnable_StatesWhenEnabling()
     * @model
     * @generated
     */
    EnableStates getStatesWhenEnabling();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Enable#getStatesWhenEnabling <em>States When Enabling</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>States When Enabling</em>' attribute.
     * @see hu.bme.mit.transima.Simulink.EnableStates
     * @see #getStatesWhenEnabling()
     * @generated
     */
    void setStatesWhenEnabling(EnableStates value);

} // Enable
