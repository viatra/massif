/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents an outport of a #{simulink.Block}.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/outport.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.OutPort#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getOutPort()
 * @model
 * @generated
 */
public interface OutPort extends Port {
    /**
     * Returns the value of the '<em><b>Connection</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.Connection#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection</em>' containment reference.
     * @see #setConnection(Connection)
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getOutPort_Connection()
     * @see hu.bme.mit.transima.Simulink.Connection#getFrom
     * @model opposite="from" containment="true"
     * @generated
     */
    Connection getConnection();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.Simulink.OutPort#getConnection <em>Connection</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection</em>' containment reference.
     * @see #getConnection()
     * @generated
     */
    void setConnection(Connection value);

} // OutPort
