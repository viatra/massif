/**
 */
package hu.bme.mit.massif.simulink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a Simulink block that may contain subblocks that specify its internal structure and behavior.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/subsystem.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.SubSystem#getSubBlocks <em>Sub Blocks</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.SubSystem#getTag <em>Tag</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSubSystem()
 * @model
 * @generated
 */
public interface SubSystem extends Block {
    /**
     * Returns the value of the '<em><b>Sub Blocks</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.massif.simulink.Block}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.Block#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Blocks</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Blocks</em>' containment reference list.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSubSystem_SubBlocks()
     * @see hu.bme.mit.massif.simulink.Block#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
    EList<Block> getSubBlocks();

    /**
     * Returns the value of the '<em><b>Tag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tag</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tag</em>' attribute.
     * @see #setTag(String)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSubSystem_Tag()
     * @model
     * @generated
     */
    String getTag();

    /**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.SubSystem#getTag <em>Tag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tag</em>' attribute.
     * @see #getTag()
     * @generated
     */
    void setTag(String value);

} // SubSystem
