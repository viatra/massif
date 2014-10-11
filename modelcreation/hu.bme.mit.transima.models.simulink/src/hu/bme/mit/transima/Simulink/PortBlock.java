/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the abstract supertype of blocks that represent ports of a subsystem.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.PortBlock#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getPortBlock()
 * @model abstract="true"
 * @generated
 */
public interface PortBlock extends VirtualBlock {
    /**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.Port#getPortBlock <em>Port Block</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(Port)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getPortBlock_Port()
	 * @see hu.bme.mit.transima.Simulink.Port#getPortBlock
	 * @model opposite="portBlock"
	 * @generated
	 */
    Port getPort();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.PortBlock#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
    void setPort(Port value);

} // PortBlock
