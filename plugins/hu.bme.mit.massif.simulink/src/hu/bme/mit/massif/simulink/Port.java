/**
 */
package hu.bme.mit.massif.simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the abstract supertype of block ports that are used for allowing data communication and signaling between blocks.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.Port#getContainer <em>Container</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Port#getPortBlock <em>Port Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends SimulinkElement {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.Block#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Block)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getPort_Container()
	 * @see hu.bme.mit.massif.simulink.Block#getPorts
	 * @model opposite="ports" transient="false"
	 * @generated
	 */
	Block getContainer();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.Port#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Block value);

	/**
	 * Returns the value of the '<em><b>Port Block</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.PortBlock#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Block</em>' reference.
	 * @see #setPortBlock(PortBlock)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getPort_PortBlock()
	 * @see hu.bme.mit.massif.simulink.PortBlock#getPort
	 * @model opposite="port"
	 * @generated
	 */
	PortBlock getPortBlock();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.Port#getPortBlock <em>Port Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Block</em>' reference.
	 * @see #getPortBlock()
	 * @generated
	 */
	void setPortBlock(PortBlock value);

} // Port
