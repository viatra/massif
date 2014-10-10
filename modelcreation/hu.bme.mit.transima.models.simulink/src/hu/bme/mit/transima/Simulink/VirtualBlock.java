/**
 */
package hu.bme.mit.transima.Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the abstract supertype of blocks that do not explicitly affect the simulation of the Simulink system.
 * These blocks are called virtual and are added as syntactic sugar, for example #{simulink.Goto} and #{simulink.From} can be used 
 * instead of a direct #{simulink.Connection} to connect blocks.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getVirtualBlock()
 * @model abstract="true"
 * @generated
 */
public interface VirtualBlock extends Block {
} // VirtualBlock
