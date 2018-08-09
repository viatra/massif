/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.util;

import hu.bme.mit.massif.simulink.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.massif.simulink.SimulinkPackage
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
            public Adapter caseParameter(Parameter object) {
                return createParameterAdapter();
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
            public Adapter caseState(State object) {
                return createStateAdapter();
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
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.SimulinkElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.SimulinkElement
     * @generated
     */
	public Adapter createSimulinkElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.Block
     * @generated
     */
	public Adapter createBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.Port <em>Port</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.Port
     * @generated
     */
	public Adapter createPortAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.Parameter
     * @generated
     */
    public Adapter createParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.InPort <em>In Port</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.InPort
     * @generated
     */
	public Adapter createInPortAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.OutPort <em>Out Port</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.OutPort
     * @generated
     */
	public Adapter createOutPortAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.Connection
     * @generated
     */
	public Adapter createConnectionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.Trigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.Trigger
     * @generated
     */
	public Adapter createTriggerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.Enable <em>Enable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.Enable
     * @generated
     */
	public Adapter createEnableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.BusSelector <em>Bus Selector</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.BusSelector
     * @generated
     */
	public Adapter createBusSelectorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.BusCreator <em>Bus Creator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.BusCreator
     * @generated
     */
	public Adapter createBusCreatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.Goto <em>Goto</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.Goto
     * @generated
     */
	public Adapter createGotoAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.VirtualBlock <em>Virtual Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.VirtualBlock
     * @generated
     */
	public Adapter createVirtualBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.From <em>From</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.From
     * @generated
     */
	public Adapter createFromAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.SimulinkModel <em>Model</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.SimulinkModel
     * @generated
     */
	public Adapter createSimulinkModelAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.MultiConnection <em>Multi Connection</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.MultiConnection
     * @generated
     */
	public Adapter createMultiConnectionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.SingleConnection <em>Single Connection</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.SingleConnection
     * @generated
     */
	public Adapter createSingleConnectionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.PortBlock <em>Port Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.PortBlock
     * @generated
     */
	public Adapter createPortBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.OutPortBlock <em>Out Port Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.OutPortBlock
     * @generated
     */
	public Adapter createOutPortBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.InPortBlock <em>In Port Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.InPortBlock
     * @generated
     */
	public Adapter createInPortBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.TriggerBlock <em>Trigger Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.TriggerBlock
     * @generated
     */
	public Adapter createTriggerBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.EnableBlock <em>Enable Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.EnableBlock
     * @generated
     */
	public Adapter createEnableBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.SimulinkReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.SimulinkReference
     * @generated
     */
	public Adapter createSimulinkReferenceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.GotoTagVisibility <em>Goto Tag Visibility</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.GotoTagVisibility
     * @generated
     */
	public Adapter createGotoTagVisibilityAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.SubSystem <em>Sub System</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.SubSystem
     * @generated
     */
	public Adapter createSubSystemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.ModelReference <em>Model Reference</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.ModelReference
     * @generated
     */
	public Adapter createModelReferenceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.BusSpecification <em>Bus Specification</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.BusSpecification
     * @generated
     */
	public Adapter createBusSpecificationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.BusSignalMapping <em>Bus Signal Mapping</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.BusSignalMapping
     * @generated
     */
	public Adapter createBusSignalMappingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.LibraryLinkReference <em>Library Link Reference</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.LibraryLinkReference
     * @generated
     */
	public Adapter createLibraryLinkReferenceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.IdentifierReference <em>Identifier Reference</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.IdentifierReference
     * @generated
     */
	public Adapter createIdentifierReferenceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link hu.bme.mit.massif.simulink.State <em>State</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.bme.mit.massif.simulink.State
     * @generated
     */
    public Adapter createStateAdapter() {
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
