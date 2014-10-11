/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the connection between #{simulink.Block} elements in order to transfer data from an outport to one or more inports.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.Connection#getFrom <em>From</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Connection#getLineName <em>Line Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getConnection()
 * @model abstract="true"
 * @generated
 */
public interface Connection extends SimulinkElement {
    /**
	 * Returns the value of the '<em><b>From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.OutPort#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' container reference.
	 * @see #setFrom(OutPort)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getConnection_From()
	 * @see hu.bme.mit.transima.Simulink.OutPort#getConnection
	 * @model opposite="connection" transient="false"
	 * @generated
	 */
    OutPort getFrom();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Connection#getFrom <em>From</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' container reference.
	 * @see #getFrom()
	 * @generated
	 */
    void setFrom(OutPort value);

				/**
	 * Returns the value of the '<em><b>Line Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Name</em>' attribute.
	 * @see #setLineName(String)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getConnection_LineName()
	 * @model
	 * @generated
	 */
	String getLineName();

				/**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Connection#getLineName <em>Line Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Name</em>' attribute.
	 * @see #getLineName()
	 * @generated
	 */
	void setLineName(String value);

} // Connection
