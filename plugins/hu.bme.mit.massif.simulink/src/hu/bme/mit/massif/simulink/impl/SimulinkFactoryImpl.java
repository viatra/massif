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
package hu.bme.mit.massif.simulink.impl;

import hu.bme.mit.massif.simulink.*;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusCreator;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.Enable;
import hu.bme.mit.massif.simulink.EnableBlock;
import hu.bme.mit.massif.simulink.EnableStates;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.IdentifierReference;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.LibraryLinkReference;
import hu.bme.mit.massif.simulink.ModelReference;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SimulinkPackage;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.TagVisibility;
import hu.bme.mit.massif.simulink.Trigger;
import hu.bme.mit.massif.simulink.TriggerBlock;
import hu.bme.mit.massif.simulink.TriggerType;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulinkFactoryImpl extends EFactoryImpl implements SimulinkFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SimulinkFactory init() {
        try {
            SimulinkFactory theSimulinkFactory = (SimulinkFactory)EPackage.Registry.INSTANCE.getEFactory(SimulinkPackage.eNS_URI);
            if (theSimulinkFactory != null) {
                return theSimulinkFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SimulinkFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimulinkFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case SimulinkPackage.BLOCK: return createBlock();
            case SimulinkPackage.PARAMETER: return createParameter();
            case SimulinkPackage.IN_PORT: return createInPort();
            case SimulinkPackage.OUT_PORT: return createOutPort();
            case SimulinkPackage.TRIGGER: return createTrigger();
            case SimulinkPackage.ENABLE: return createEnable();
            case SimulinkPackage.BUS_SELECTOR: return createBusSelector();
            case SimulinkPackage.BUS_CREATOR: return createBusCreator();
            case SimulinkPackage.GOTO: return createGoto();
            case SimulinkPackage.FROM: return createFrom();
            case SimulinkPackage.SIMULINK_MODEL: return createSimulinkModel();
            case SimulinkPackage.MULTI_CONNECTION: return createMultiConnection();
            case SimulinkPackage.SINGLE_CONNECTION: return createSingleConnection();
            case SimulinkPackage.OUT_PORT_BLOCK: return createOutPortBlock();
            case SimulinkPackage.IN_PORT_BLOCK: return createInPortBlock();
            case SimulinkPackage.TRIGGER_BLOCK: return createTriggerBlock();
            case SimulinkPackage.ENABLE_BLOCK: return createEnableBlock();
            case SimulinkPackage.GOTO_TAG_VISIBILITY: return createGotoTagVisibility();
            case SimulinkPackage.SUB_SYSTEM: return createSubSystem();
            case SimulinkPackage.MODEL_REFERENCE: return createModelReference();
            case SimulinkPackage.BUS_SIGNAL_MAPPING: return createBusSignalMapping();
            case SimulinkPackage.LIBRARY_LINK_REFERENCE: return createLibraryLinkReference();
            case SimulinkPackage.IDENTIFIER_REFERENCE: return createIdentifierReference();
            case SimulinkPackage.STATE: return createState();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case SimulinkPackage.ENABLE_STATES:
                return createEnableStatesFromString(eDataType, initialValue);
            case SimulinkPackage.TRIGGER_TYPE:
                return createTriggerTypeFromString(eDataType, initialValue);
            case SimulinkPackage.TAG_VISIBILITY:
                return createTagVisibilityFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case SimulinkPackage.ENABLE_STATES:
                return convertEnableStatesToString(eDataType, instanceValue);
            case SimulinkPackage.TRIGGER_TYPE:
                return convertTriggerTypeToString(eDataType, instanceValue);
            case SimulinkPackage.TAG_VISIBILITY:
                return convertTagVisibilityToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block createBlock() {
        BlockImpl block = new BlockImpl();
        return block;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InPort createInPort() {
        InPortImpl inPort = new InPortImpl();
        return inPort;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OutPort createOutPort() {
        OutPortImpl outPort = new OutPortImpl();
        return outPort;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Trigger createTrigger() {
        TriggerImpl trigger = new TriggerImpl();
        return trigger;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Enable createEnable() {
        EnableImpl enable = new EnableImpl();
        return enable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusSelector createBusSelector() {
        BusSelectorImpl busSelector = new BusSelectorImpl();
        return busSelector;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusCreator createBusCreator() {
        BusCreatorImpl busCreator = new BusCreatorImpl();
        return busCreator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Goto createGoto() {
        GotoImpl goto_ = new GotoImpl();
        return goto_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public From createFrom() {
        FromImpl from = new FromImpl();
        return from;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimulinkModel createSimulinkModel() {
        SimulinkModelImpl simulinkModel = new SimulinkModelImpl();
        return simulinkModel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MultiConnection createMultiConnection() {
        MultiConnectionImpl multiConnection = new MultiConnectionImpl();
        return multiConnection;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SingleConnection createSingleConnection() {
        SingleConnectionImpl singleConnection = new SingleConnectionImpl();
        return singleConnection;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OutPortBlock createOutPortBlock() {
        OutPortBlockImpl outPortBlock = new OutPortBlockImpl();
        return outPortBlock;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InPortBlock createInPortBlock() {
        InPortBlockImpl inPortBlock = new InPortBlockImpl();
        return inPortBlock;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TriggerBlock createTriggerBlock() {
        TriggerBlockImpl triggerBlock = new TriggerBlockImpl();
        return triggerBlock;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EnableBlock createEnableBlock() {
        EnableBlockImpl enableBlock = new EnableBlockImpl();
        return enableBlock;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GotoTagVisibility createGotoTagVisibility() {
        GotoTagVisibilityImpl gotoTagVisibility = new GotoTagVisibilityImpl();
        return gotoTagVisibility;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SubSystem createSubSystem() {
        SubSystemImpl subSystem = new SubSystemImpl();
        return subSystem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ModelReference createModelReference() {
        ModelReferenceImpl modelReference = new ModelReferenceImpl();
        return modelReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusSignalMapping createBusSignalMapping() {
        BusSignalMappingImpl busSignalMapping = new BusSignalMappingImpl();
        return busSignalMapping;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LibraryLinkReference createLibraryLinkReference() {
        LibraryLinkReferenceImpl libraryLinkReference = new LibraryLinkReferenceImpl();
        return libraryLinkReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IdentifierReference createIdentifierReference() {
        IdentifierReferenceImpl identifierReference = new IdentifierReferenceImpl();
        return identifierReference;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public State createState() {
        StateImpl state = new StateImpl();
        return state;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EnableStates createEnableStatesFromString(EDataType eDataType, String initialValue) {
        EnableStates result = EnableStates.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEnableStatesToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TriggerType createTriggerTypeFromString(EDataType eDataType, String initialValue) {
        TriggerType result = TriggerType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertTriggerTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TagVisibility createTagVisibilityFromString(EDataType eDataType, String initialValue) {
        TagVisibility result = TagVisibility.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertTagVisibilityToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimulinkPackage getSimulinkPackage() {
        return (SimulinkPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static SimulinkPackage getPackage() {
        return SimulinkPackage.eINSTANCE;
    }

} //SimulinkFactoryImpl
