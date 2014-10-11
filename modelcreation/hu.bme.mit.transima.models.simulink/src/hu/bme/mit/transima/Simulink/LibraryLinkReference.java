/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library Link Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a specific class used for representing links to Simulink elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.LibraryLinkReference#isDisabled <em>Disabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getLibraryLinkReference()
 * @model
 * @generated
 */
public interface LibraryLinkReference extends SimulinkReference {
    /**
	 * Returns the value of the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Disabled links mean that the block was originally copied from a library but it was modified later.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disabled</em>' attribute.
	 * @see #setDisabled(boolean)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getLibraryLinkReference_Disabled()
	 * @model
	 * @generated
	 */
    boolean isDisabled();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.LibraryLinkReference#isDisabled <em>Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disabled</em>' attribute.
	 * @see #isDisabled()
	 * @generated
	 */
    void setDisabled(boolean value);

} // LibraryLinkReference
