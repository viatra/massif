/**
 */
package hu.bme.mit.massif.simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The From block accepts a signal from a corresponding #{simulink.Goto} block, then passes it as output.
 *  The data type of the output is the same as that of the input from the Goto block.
 *  From and Goto blocks allow you to pass a signal from one block to another without actually connecting them.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/from.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.From#getGotoBlock <em>Goto Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getFrom()
 * @model
 * @generated
 */
public interface From extends VirtualBlock {
	/**
	 * Returns the value of the '<em><b>Goto Block</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.Goto#getFromBlocks <em>From Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goto Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goto Block</em>' reference.
	 * @see #setGotoBlock(Goto)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getFrom_GotoBlock()
	 * @see hu.bme.mit.massif.simulink.Goto#getFromBlocks
	 * @model opposite="fromBlocks"
	 * @generated
	 */
	Goto getGotoBlock();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.From#getGotoBlock <em>Goto Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goto Block</em>' reference.
	 * @see #getGotoBlock()
	 * @generated
	 */
	void setGotoBlock(Goto value);

} // From
