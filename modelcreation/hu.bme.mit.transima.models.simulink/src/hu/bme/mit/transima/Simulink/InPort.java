/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents an inport of a #{simulink.Block}.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/inport.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.InPort#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getInPort()
 * @model
 * @generated
 */
public interface InPort extends Port {
    /**
     * Returns the value of the '<em><b>Connection</b></em>' reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.SingleConnection#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection</em>' reference.
     * @see #setConnection(SingleConnection)
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getInPort_Connection()
     * @see hu.bme.mit.transima.Simulink.SingleConnection#getTo
     * @model opposite="to"
     * @generated
     */
    SingleConnection getConnection();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.Simulink.InPort#getConnection <em>Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection</em>' reference.
     * @see #getConnection()
     * @generated
     */
    void setConnection(SingleConnection value);

} // InPort
