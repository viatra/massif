/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goto Tag Visibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Goto Tag Visibility block defines the accessibility of #{simulink.Goto} block tags that have scoped visibility.
 *  The tag specified as the Goto tag parameter is accessible by #{simulink.From} blocks in the same subsystem that contains the Goto Tag Visibility block and in subsystems below it in the model hierarchy.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/gototagvisibility.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.GotoTagVisibility#getGotoBlock <em>Goto Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getGotoTagVisibility()
 * @model
 * @generated
 */
public interface GotoTagVisibility extends VirtualBlock {
    /**
	 * Returns the value of the '<em><b>Goto Block</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Goto Block</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Goto Block</em>' reference.
	 * @see #setGotoBlock(Goto)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getGotoTagVisibility_GotoBlock()
	 * @model
	 * @generated
	 */
    Goto getGotoBlock();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.GotoTagVisibility#getGotoBlock <em>Goto Block</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goto Block</em>' reference.
	 * @see #getGotoBlock()
	 * @generated
	 */
    void setGotoBlock(Goto value);

} // GotoTagVisibility
