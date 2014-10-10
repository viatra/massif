/**
 */
package hu.bme.mit.transima.Simulink;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage
 * @generated
 */
public interface SimulinkFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SimulinkFactory eINSTANCE = hu.bme.mit.transima.Simulink.impl.SimulinkFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Block</em>'.
     * @generated
     */
    Block createBlock();

    /**
     * Returns a new object of class '<em>Property</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Property</em>'.
     * @generated
     */
    Property createProperty();

    /**
     * Returns a new object of class '<em>In Port</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>In Port</em>'.
     * @generated
     */
    InPort createInPort();

    /**
     * Returns a new object of class '<em>Out Port</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Out Port</em>'.
     * @generated
     */
    OutPort createOutPort();

    /**
     * Returns a new object of class '<em>Trigger</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trigger</em>'.
     * @generated
     */
    Trigger createTrigger();

    /**
     * Returns a new object of class '<em>Enable</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enable</em>'.
     * @generated
     */
    Enable createEnable();

    /**
     * Returns a new object of class '<em>Bus Selector</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bus Selector</em>'.
     * @generated
     */
    BusSelector createBusSelector();

    /**
     * Returns a new object of class '<em>Bus Creator</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bus Creator</em>'.
     * @generated
     */
    BusCreator createBusCreator();

    /**
     * Returns a new object of class '<em>Goto</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Goto</em>'.
     * @generated
     */
    Goto createGoto();

    /**
     * Returns a new object of class '<em>From</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>From</em>'.
     * @generated
     */
    From createFrom();

    /**
     * Returns a new object of class '<em>Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model</em>'.
     * @generated
     */
    SimulinkModel createSimulinkModel();

    /**
     * Returns a new object of class '<em>Multi Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Multi Connection</em>'.
     * @generated
     */
    MultiConnection createMultiConnection();

    /**
     * Returns a new object of class '<em>Single Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Single Connection</em>'.
     * @generated
     */
    SingleConnection createSingleConnection();

    /**
     * Returns a new object of class '<em>Out Port Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Out Port Block</em>'.
     * @generated
     */
    OutPortBlock createOutPortBlock();

    /**
     * Returns a new object of class '<em>In Port Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>In Port Block</em>'.
     * @generated
     */
    InPortBlock createInPortBlock();

    /**
     * Returns a new object of class '<em>Trigger Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trigger Block</em>'.
     * @generated
     */
    TriggerBlock createTriggerBlock();

    /**
     * Returns a new object of class '<em>Enable Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enable Block</em>'.
     * @generated
     */
    EnableBlock createEnableBlock();

    /**
     * Returns a new object of class '<em>Goto Tag Visibility</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Goto Tag Visibility</em>'.
     * @generated
     */
    GotoTagVisibility createGotoTagVisibility();

    /**
     * Returns a new object of class '<em>Sub System</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Sub System</em>'.
     * @generated
     */
    SubSystem createSubSystem();

    /**
     * Returns a new object of class '<em>Model Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model Reference</em>'.
     * @generated
     */
    ModelReference createModelReference();

    /**
     * Returns a new object of class '<em>Bus Signal Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bus Signal Mapping</em>'.
     * @generated
     */
    BusSignalMapping createBusSignalMapping();

    /**
     * Returns a new object of class '<em>Library Link Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Library Link Reference</em>'.
     * @generated
     */
    LibraryLinkReference createLibraryLinkReference();

    /**
     * Returns a new object of class '<em>Identifier Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Identifier Reference</em>'.
     * @generated
     */
    IdentifierReference createIdentifierReference();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    SimulinkPackage getSimulinkPackage();

} //SimulinkFactory
