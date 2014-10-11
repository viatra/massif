/**
 */
package hu.bme.mit.transima.Simulink.util;

import hu.bme.mit.transima.Simulink.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage
 * @generated
 */
public class SimulinkAdapterFactory extends AdapterFactoryImpl {
    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static SimulinkPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SimulinkAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SimulinkPackage.eINSTANCE;
		}
	}

    /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
    @Override
    public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

    /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SimulinkSwitch<Adapter> modelSwitch =
        new SimulinkSwitch<Adapter>() {
			@Override
			public Adapter caseSimulinkElement(SimulinkElement object) {
				return createSimulinkElementAdapter();
			}
			@Override
			public Adapter caseBlock(Block object) {
				return createBlockAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseInPort(InPort object) {
				return createInPortAdapter();
			}
			@Override
			public Adapter caseOutPort(OutPort object) {
				return createOutPortAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseTrigger(Trigger object) {
				return createTriggerAdapter();
			}
			@Override
			public Adapter caseEnable(Enable object) {
				return createEnableAdapter();
			}
			@Override
			public Adapter caseBusSelector(BusSelector object) {
				return createBusSelectorAdapter();
			}
			@Override
			public Adapter caseBusCreator(BusCreator object) {
				return createBusCreatorAdapter();
			}
			@Override
			public Adapter caseGoto(Goto object) {
				return createGotoAdapter();
			}
			@Override
			public Adapter caseVirtualBlock(VirtualBlock object) {
				return createVirtualBlockAdapter();
			}
			@Override
			public Adapter caseFrom(From object) {
				return createFromAdapter();
			}
			@Override
			public Adapter caseSimulinkModel(SimulinkModel object) {
				return createSimulinkModelAdapter();
			}
			@Override
			public Adapter caseMultiConnection(MultiConnection object) {
				return createMultiConnectionAdapter();
			}
			@Override
			public Adapter caseSingleConnection(SingleConnection object) {
				return createSingleConnectionAdapter();
			}
			@Override
			public Adapter casePortBlock(PortBlock object) {
				return createPortBlockAdapter();
			}
			@Override
			public Adapter caseOutPortBlock(OutPortBlock object) {
				return createOutPortBlockAdapter();
			}
			@Override
			public Adapter caseInPortBlock(InPortBlock object) {
				return createInPortBlockAdapter();
			}
			@Override
			public Adapter caseTriggerBlock(TriggerBlock object) {
				return createTriggerBlockAdapter();
			}
			@Override
			public Adapter caseEnableBlock(EnableBlock object) {
				return createEnableBlockAdapter();
			}
			@Override
			public Adapter caseSimulinkReference(SimulinkReference object) {
				return createSimulinkReferenceAdapter();
			}
			@Override
			public Adapter caseGotoTagVisibility(GotoTagVisibility object) {
				return createGotoTagVisibilityAdapter();
			}
			@Override
			public Adapter caseSubSystem(SubSystem object) {
				return createSubSystemAdapter();
			}
			@Override
			public Adapter caseModelReference(ModelReference object) {
				return createModelReferenceAdapter();
			}
			@Override
			public Adapter caseBusSpecification(BusSpecification object) {
				return createBusSpecificationAdapter();
			}
			@Override
			public Adapter caseBusSignalMapping(BusSignalMapping object) {
				return createBusSignalMappingAdapter();
			}
			@Override
			public Adapter caseLibraryLinkReference(LibraryLinkReference object) {
				return createLibraryLinkReferenceAdapter();
			}
			@Override
			public Adapter caseIdentifierReference(IdentifierReference object) {
				return createIdentifierReferenceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

    /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
    @Override
    public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.SimulinkElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.SimulinkElement
	 * @generated
	 */
    public Adapter createSimulinkElementAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.Block
	 * @generated
	 */
    public Adapter createBlockAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.Port
	 * @generated
	 */
    public Adapter createPortAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.Property
	 * @generated
	 */
    public Adapter createPropertyAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.InPort <em>In Port</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.InPort
	 * @generated
	 */
    public Adapter createInPortAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.OutPort <em>Out Port</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.OutPort
	 * @generated
	 */
    public Adapter createOutPortAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.Connection
	 * @generated
	 */
    public Adapter createConnectionAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.Trigger
	 * @generated
	 */
    public Adapter createTriggerAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.Enable <em>Enable</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.Enable
	 * @generated
	 */
    public Adapter createEnableAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.BusSelector <em>Bus Selector</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.BusSelector
	 * @generated
	 */
    public Adapter createBusSelectorAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.BusCreator <em>Bus Creator</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.BusCreator
	 * @generated
	 */
    public Adapter createBusCreatorAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.Goto <em>Goto</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.Goto
	 * @generated
	 */
    public Adapter createGotoAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.VirtualBlock <em>Virtual Block</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.VirtualBlock
	 * @generated
	 */
    public Adapter createVirtualBlockAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.From <em>From</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.From
	 * @generated
	 */
    public Adapter createFromAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.SimulinkModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.SimulinkModel
	 * @generated
	 */
    public Adapter createSimulinkModelAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.MultiConnection <em>Multi Connection</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.MultiConnection
	 * @generated
	 */
    public Adapter createMultiConnectionAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.SingleConnection <em>Single Connection</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.SingleConnection
	 * @generated
	 */
    public Adapter createSingleConnectionAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.PortBlock <em>Port Block</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.PortBlock
	 * @generated
	 */
    public Adapter createPortBlockAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.OutPortBlock <em>Out Port Block</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.OutPortBlock
	 * @generated
	 */
    public Adapter createOutPortBlockAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.InPortBlock <em>In Port Block</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.InPortBlock
	 * @generated
	 */
    public Adapter createInPortBlockAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.TriggerBlock <em>Trigger Block</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.TriggerBlock
	 * @generated
	 */
    public Adapter createTriggerBlockAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.EnableBlock <em>Enable Block</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.EnableBlock
	 * @generated
	 */
    public Adapter createEnableBlockAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.SimulinkReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.SimulinkReference
	 * @generated
	 */
    public Adapter createSimulinkReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.GotoTagVisibility <em>Goto Tag Visibility</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.GotoTagVisibility
	 * @generated
	 */
    public Adapter createGotoTagVisibilityAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.SubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.SubSystem
	 * @generated
	 */
    public Adapter createSubSystemAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.ModelReference <em>Model Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.ModelReference
	 * @generated
	 */
    public Adapter createModelReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.BusSpecification <em>Bus Specification</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.BusSpecification
	 * @generated
	 */
    public Adapter createBusSpecificationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.BusSignalMapping <em>Bus Signal Mapping</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.BusSignalMapping
	 * @generated
	 */
    public Adapter createBusSignalMappingAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.LibraryLinkReference <em>Library Link Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.LibraryLinkReference
	 * @generated
	 */
    public Adapter createLibraryLinkReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.transima.Simulink.IdentifierReference <em>Identifier Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.transima.Simulink.IdentifierReference
	 * @generated
	 */
    public Adapter createIdentifierReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
    public Adapter createEObjectAdapter() {
		return null;
	}

} //SimulinkAdapterFactory
