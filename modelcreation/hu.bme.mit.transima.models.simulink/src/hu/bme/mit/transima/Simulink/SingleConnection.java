/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a simple connections between a single #{simulink.OutPort} and a single #{simulink.InPort}.
 * The outport can be identified either through the from reference or through the parent #{simulink.MultiConnection}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.SingleConnection#getParent <em>Parent</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.SingleConnection#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSingleConnection()
 * @model
 * @generated
 */
public interface SingleConnection extends Connection {
    /**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.MultiConnection#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(MultiConnection)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSingleConnection_Parent()
	 * @see hu.bme.mit.transima.Simulink.MultiConnection#getConnections
	 * @model opposite="connections" transient="false"
	 * @generated
	 */
    MultiConnection getParent();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.SingleConnection#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
    void setParent(MultiConnection value);

    /**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.InPort#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(InPort)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSingleConnection_To()
	 * @see hu.bme.mit.transima.Simulink.InPort#getConnection
	 * @model opposite="connection"
	 * @generated
	 */
    InPort getTo();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.SingleConnection#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
    void setTo(InPort value);

} // SingleConnection
