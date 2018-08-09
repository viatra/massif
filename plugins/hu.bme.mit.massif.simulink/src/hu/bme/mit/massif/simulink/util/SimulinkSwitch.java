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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.massif.simulink.SimulinkPackage
 * @generated
 */
public class SimulinkSwitch<T> extends Switch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static SimulinkPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimulinkSwitch() {
        if (modelPackage == null) {
            modelPackage = SimulinkPackage.eINSTANCE;
        }
    }

	/**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case SimulinkPackage.SIMULINK_ELEMENT: {
                SimulinkElement simulinkElement = (SimulinkElement)theEObject;
                T result = caseSimulinkElement(simulinkElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.BLOCK: {
                Block block = (Block)theEObject;
                T result = caseBlock(block);
                if (result == null) result = caseSimulinkElement(block);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.PORT: {
                Port port = (Port)theEObject;
                T result = casePort(port);
                if (result == null) result = caseSimulinkElement(port);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.PARAMETER: {
                Parameter parameter = (Parameter)theEObject;
                T result = caseParameter(parameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.IN_PORT: {
                InPort inPort = (InPort)theEObject;
                T result = caseInPort(inPort);
                if (result == null) result = casePort(inPort);
                if (result == null) result = caseSimulinkElement(inPort);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.OUT_PORT: {
                OutPort outPort = (OutPort)theEObject;
                T result = caseOutPort(outPort);
                if (result == null) result = casePort(outPort);
                if (result == null) result = caseSimulinkElement(outPort);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.CONNECTION: {
                Connection connection = (Connection)theEObject;
                T result = caseConnection(connection);
                if (result == null) result = caseSimulinkElement(connection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.TRIGGER: {
                Trigger trigger = (Trigger)theEObject;
                T result = caseTrigger(trigger);
                if (result == null) result = caseInPort(trigger);
                if (result == null) result = casePort(trigger);
                if (result == null) result = caseSimulinkElement(trigger);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.ENABLE: {
                Enable enable = (Enable)theEObject;
                T result = caseEnable(enable);
                if (result == null) result = caseInPort(enable);
                if (result == null) result = casePort(enable);
                if (result == null) result = caseSimulinkElement(enable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.BUS_SELECTOR: {
                BusSelector busSelector = (BusSelector)theEObject;
                T result = caseBusSelector(busSelector);
                if (result == null) result = caseBusSpecification(busSelector);
                if (result == null) result = caseBlock(busSelector);
                if (result == null) result = caseSimulinkElement(busSelector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.BUS_CREATOR: {
                BusCreator busCreator = (BusCreator)theEObject;
                T result = caseBusCreator(busCreator);
                if (result == null) result = caseBusSpecification(busCreator);
                if (result == null) result = caseBlock(busCreator);
                if (result == null) result = caseSimulinkElement(busCreator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.GOTO: {
                Goto goto_ = (Goto)theEObject;
                T result = caseGoto(goto_);
                if (result == null) result = caseVirtualBlock(goto_);
                if (result == null) result = caseBlock(goto_);
                if (result == null) result = caseSimulinkElement(goto_);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.VIRTUAL_BLOCK: {
                VirtualBlock virtualBlock = (VirtualBlock)theEObject;
                T result = caseVirtualBlock(virtualBlock);
                if (result == null) result = caseBlock(virtualBlock);
                if (result == null) result = caseSimulinkElement(virtualBlock);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.FROM: {
                From from = (From)theEObject;
                T result = caseFrom(from);
                if (result == null) result = caseVirtualBlock(from);
                if (result == null) result = caseBlock(from);
                if (result == null) result = caseSimulinkElement(from);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.SIMULINK_MODEL: {
                SimulinkModel simulinkModel = (SimulinkModel)theEObject;
                T result = caseSimulinkModel(simulinkModel);
                if (result == null) result = caseSimulinkElement(simulinkModel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.MULTI_CONNECTION: {
                MultiConnection multiConnection = (MultiConnection)theEObject;
                T result = caseMultiConnection(multiConnection);
                if (result == null) result = caseConnection(multiConnection);
                if (result == null) result = caseSimulinkElement(multiConnection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.SINGLE_CONNECTION: {
                SingleConnection singleConnection = (SingleConnection)theEObject;
                T result = caseSingleConnection(singleConnection);
                if (result == null) result = caseConnection(singleConnection);
                if (result == null) result = caseSimulinkElement(singleConnection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.PORT_BLOCK: {
                PortBlock portBlock = (PortBlock)theEObject;
                T result = casePortBlock(portBlock);
                if (result == null) result = caseVirtualBlock(portBlock);
                if (result == null) result = caseBlock(portBlock);
                if (result == null) result = caseSimulinkElement(portBlock);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.OUT_PORT_BLOCK: {
                OutPortBlock outPortBlock = (OutPortBlock)theEObject;
                T result = caseOutPortBlock(outPortBlock);
                if (result == null) result = casePortBlock(outPortBlock);
                if (result == null) result = caseVirtualBlock(outPortBlock);
                if (result == null) result = caseBlock(outPortBlock);
                if (result == null) result = caseSimulinkElement(outPortBlock);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.IN_PORT_BLOCK: {
                InPortBlock inPortBlock = (InPortBlock)theEObject;
                T result = caseInPortBlock(inPortBlock);
                if (result == null) result = casePortBlock(inPortBlock);
                if (result == null) result = caseVirtualBlock(inPortBlock);
                if (result == null) result = caseBlock(inPortBlock);
                if (result == null) result = caseSimulinkElement(inPortBlock);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.TRIGGER_BLOCK: {
                TriggerBlock triggerBlock = (TriggerBlock)theEObject;
                T result = caseTriggerBlock(triggerBlock);
                if (result == null) result = caseInPortBlock(triggerBlock);
                if (result == null) result = casePortBlock(triggerBlock);
                if (result == null) result = caseVirtualBlock(triggerBlock);
                if (result == null) result = caseBlock(triggerBlock);
                if (result == null) result = caseSimulinkElement(triggerBlock);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.ENABLE_BLOCK: {
                EnableBlock enableBlock = (EnableBlock)theEObject;
                T result = caseEnableBlock(enableBlock);
                if (result == null) result = caseInPortBlock(enableBlock);
                if (result == null) result = casePortBlock(enableBlock);
                if (result == null) result = caseVirtualBlock(enableBlock);
                if (result == null) result = caseBlock(enableBlock);
                if (result == null) result = caseSimulinkElement(enableBlock);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.SIMULINK_REFERENCE: {
                SimulinkReference simulinkReference = (SimulinkReference)theEObject;
                T result = caseSimulinkReference(simulinkReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.GOTO_TAG_VISIBILITY: {
                GotoTagVisibility gotoTagVisibility = (GotoTagVisibility)theEObject;
                T result = caseGotoTagVisibility(gotoTagVisibility);
                if (result == null) result = caseVirtualBlock(gotoTagVisibility);
                if (result == null) result = caseBlock(gotoTagVisibility);
                if (result == null) result = caseSimulinkElement(gotoTagVisibility);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.SUB_SYSTEM: {
                SubSystem subSystem = (SubSystem)theEObject;
                T result = caseSubSystem(subSystem);
                if (result == null) result = caseBlock(subSystem);
                if (result == null) result = caseSimulinkElement(subSystem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.MODEL_REFERENCE: {
                ModelReference modelReference = (ModelReference)theEObject;
                T result = caseModelReference(modelReference);
                if (result == null) result = caseBlock(modelReference);
                if (result == null) result = caseSimulinkElement(modelReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.BUS_SPECIFICATION: {
                BusSpecification busSpecification = (BusSpecification)theEObject;
                T result = caseBusSpecification(busSpecification);
                if (result == null) result = caseBlock(busSpecification);
                if (result == null) result = caseSimulinkElement(busSpecification);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.BUS_SIGNAL_MAPPING: {
                BusSignalMapping busSignalMapping = (BusSignalMapping)theEObject;
                T result = caseBusSignalMapping(busSignalMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.LIBRARY_LINK_REFERENCE: {
                LibraryLinkReference libraryLinkReference = (LibraryLinkReference)theEObject;
                T result = caseLibraryLinkReference(libraryLinkReference);
                if (result == null) result = caseSimulinkReference(libraryLinkReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.IDENTIFIER_REFERENCE: {
                IdentifierReference identifierReference = (IdentifierReference)theEObject;
                T result = caseIdentifierReference(identifierReference);
                if (result == null) result = caseSimulinkReference(identifierReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimulinkPackage.STATE: {
                State state = (State)theEObject;
                T result = caseState(state);
                if (result == null) result = caseOutPort(state);
                if (result == null) result = casePort(state);
                if (result == null) result = caseSimulinkElement(state);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSimulinkElement(SimulinkElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBlock(Block object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePort(Port object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameter(Parameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>In Port</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>In Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInPort(InPort object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Out Port</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Out Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOutPort(OutPort object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConnection(Connection object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTrigger(Trigger object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Enable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEnable(Enable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Bus Selector</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bus Selector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusSelector(BusSelector object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Bus Creator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bus Creator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusCreator(BusCreator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Goto</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Goto</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseGoto(Goto object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Virtual Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Virtual Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseVirtualBlock(VirtualBlock object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>From</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>From</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFrom(From object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSimulinkModel(SimulinkModel object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Multi Connection</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Multi Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMultiConnection(MultiConnection object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Single Connection</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Single Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSingleConnection(SingleConnection object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Port Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Port Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePortBlock(PortBlock object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Out Port Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Out Port Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOutPortBlock(OutPortBlock object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>In Port Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>In Port Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInPortBlock(InPortBlock object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Trigger Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trigger Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTriggerBlock(TriggerBlock object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Enable Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enable Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEnableBlock(EnableBlock object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSimulinkReference(SimulinkReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Goto Tag Visibility</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Goto Tag Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseGotoTagVisibility(GotoTagVisibility object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sub System</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sub System</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSubSystem(SubSystem object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Model Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseModelReference(ModelReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Bus Specification</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bus Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusSpecification(BusSpecification object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Bus Signal Mapping</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bus Signal Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusSignalMapping(BusSignalMapping object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Library Link Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Library Link Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLibraryLinkReference(LibraryLinkReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Identifier Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIdentifierReference(IdentifierReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>State</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseState(State object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	@Override
	public T defaultCase(EObject object) {
        return null;
    }

} //SimulinkSwitch
