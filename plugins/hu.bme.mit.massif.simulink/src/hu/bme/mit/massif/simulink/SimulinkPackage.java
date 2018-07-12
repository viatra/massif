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
/**
 */
package hu.bme.mit.massif.simulink;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The Simulink EPackage represents the core concepts of Matlab Simulink models with a strong focus on the structure
 *  and less focus on the behavior, simulation and layout specific details.
 * 
 * The five main concepts (easily recognised by #{simulink.SimulinkElement} and its subtypes) are the following:
 *  * Elements on a Simulink model that can be identified and named are subtypes of #{simulink.SimulinkElement},
 *  which stores the identifier as a #{simulink.SimulinkReference} element.
 *  * The root element, #{simulink.SimulinkModel}, stores the file path and version for the original Simulink system it represents
 *  to help in handling changes in the represented system.
 *  * The Simulink model contains a hierarchy of #{simulink.Block} elements that may have properties and specify a source
 *  block from a Simulink library. The source block is set if the internal structure and behavior of the block is defined by a library block.
 *  * The communication between blocks is done through #{simulink.Port} elements, that can be either output or input. 
 *  Each port is represented by a #{simulink.PortBlock}  inside the block.
 *  * The output ports are connected to input ports using #{simulink.Connection} elements that can be one-to-one single connections or one-to-many multiconnections.
 * <!-- end-model-doc -->
 * @see hu.bme.mit.massif.simulink.SimulinkFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='org.eclipse.viatra.query.querybasedfeature'"
 * @generated
 */
public interface SimulinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simulink";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hu.bme.mit.massif/simulink/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simulink";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulinkPackage eINSTANCE = hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.SimulinkElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkElementImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimulinkElement()
	 * @generated
	 */
	int SIMULINK_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_ELEMENT__SIMULINK_REF = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_ELEMENT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.BlockImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__SIMULINK_REF = SIMULINK_ELEMENT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__NAME = SIMULINK_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__PROPERTIES = SIMULINK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__PORTS = SIMULINK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__TRIGGER = SIMULINK_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__ENABLER = SIMULINK_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__INPORTS = SIMULINK_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__OUTPORTS = SIMULINK_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__PARENT = SIMULINK_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__SOURCE_BLOCK = SIMULINK_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__SOURCE_BLOCK_REF = SIMULINK_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = SIMULINK_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.PortImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 2;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__SIMULINK_REF = SIMULINK_ELEMENT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = SIMULINK_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CONTAINER = SIMULINK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PORT_BLOCK = SIMULINK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PORT_TYPE = SIMULINK_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PORT_NO = SIMULINK_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = SIMULINK_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.PropertyImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SOURCE = 3;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.InPortImpl <em>In Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.InPortImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getInPort()
	 * @generated
	 */
	int IN_PORT = 4;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT__SIMULINK_REF = PORT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT__CONTAINER = PORT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Port Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT__PORT_BLOCK = PORT__PORT_BLOCK;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT__PORT_TYPE = PORT__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Port No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT__PORT_NO = PORT__PORT_NO;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT__CONNECTION = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>In Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.OutPortImpl <em>Out Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.OutPortImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getOutPort()
	 * @generated
	 */
	int OUT_PORT = 5;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT__SIMULINK_REF = PORT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT__CONTAINER = PORT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Port Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT__PORT_BLOCK = PORT__PORT_BLOCK;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT__PORT_TYPE = PORT__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Port No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT__PORT_NO = PORT__PORT_NO;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT__CONNECTION = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Out Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.ConnectionImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 6;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SIMULINK_REF = SIMULINK_ELEMENT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__NAME = SIMULINK_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__FROM = SIMULINK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__LINE_NAME = SIMULINK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = SIMULINK_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.TriggerImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 7;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__SIMULINK_REF = IN_PORT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__NAME = IN_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__CONTAINER = IN_PORT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Port Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__PORT_BLOCK = IN_PORT__PORT_BLOCK;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__PORT_TYPE = IN_PORT__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Port No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__PORT_NO = IN_PORT__PORT_NO;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__CONNECTION = IN_PORT__CONNECTION;

	/**
	 * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__TRIGGER_TYPE = IN_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>States When Enabling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__STATES_WHEN_ENABLING = IN_PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = IN_PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.EnableImpl <em>Enable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.EnableImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getEnable()
	 * @generated
	 */
	int ENABLE = 8;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__SIMULINK_REF = IN_PORT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__NAME = IN_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__CONTAINER = IN_PORT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Port Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__PORT_BLOCK = IN_PORT__PORT_BLOCK;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__PORT_TYPE = IN_PORT__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Port No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__PORT_NO = IN_PORT__PORT_NO;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__CONNECTION = IN_PORT__CONNECTION;

	/**
	 * The feature id for the '<em><b>States When Enabling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE__STATES_WHEN_ENABLING = IN_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_FEATURE_COUNT = IN_PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.BusSpecificationImpl <em>Bus Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.BusSpecificationImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusSpecification()
	 * @generated
	 */
	int BUS_SPECIFICATION = 26;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__SIMULINK_REF = BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__NAME = BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__PROPERTIES = BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__PORTS = BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__TRIGGER = BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__ENABLER = BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__INPORTS = BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__OUTPORTS = BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__PARENT = BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__SOURCE_BLOCK = BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION__SOURCE_BLOCK_REF = BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The number of structural features of the '<em>Bus Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SPECIFICATION_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.BusSelectorImpl <em>Bus Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.BusSelectorImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusSelector()
	 * @generated
	 */
	int BUS_SELECTOR = 9;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__SIMULINK_REF = BUS_SPECIFICATION__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__NAME = BUS_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__PROPERTIES = BUS_SPECIFICATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__PORTS = BUS_SPECIFICATION__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__TRIGGER = BUS_SPECIFICATION__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__ENABLER = BUS_SPECIFICATION__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__INPORTS = BUS_SPECIFICATION__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__OUTPORTS = BUS_SPECIFICATION__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__PARENT = BUS_SPECIFICATION__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__SOURCE_BLOCK = BUS_SPECIFICATION__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__SOURCE_BLOCK_REF = BUS_SPECIFICATION__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__MAPPINGS = BUS_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output As Bus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__OUTPUT_AS_BUS = BUS_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bus Creator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR__BUS_CREATOR = BUS_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bus Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SELECTOR_FEATURE_COUNT = BUS_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.BusCreatorImpl <em>Bus Creator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.BusCreatorImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusCreator()
	 * @generated
	 */
	int BUS_CREATOR = 10;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__SIMULINK_REF = BUS_SPECIFICATION__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__NAME = BUS_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__PROPERTIES = BUS_SPECIFICATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__PORTS = BUS_SPECIFICATION__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__TRIGGER = BUS_SPECIFICATION__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__ENABLER = BUS_SPECIFICATION__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__INPORTS = BUS_SPECIFICATION__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__OUTPORTS = BUS_SPECIFICATION__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__PARENT = BUS_SPECIFICATION__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__SOURCE_BLOCK = BUS_SPECIFICATION__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR__SOURCE_BLOCK_REF = BUS_SPECIFICATION__SOURCE_BLOCK_REF;

	/**
	 * The number of structural features of the '<em>Bus Creator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CREATOR_FEATURE_COUNT = BUS_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.VirtualBlockImpl <em>Virtual Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.VirtualBlockImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getVirtualBlock()
	 * @generated
	 */
	int VIRTUAL_BLOCK = 12;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__SIMULINK_REF = BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__NAME = BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__PROPERTIES = BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__PORTS = BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__TRIGGER = BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__ENABLER = BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__INPORTS = BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__OUTPORTS = BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__PARENT = BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__SOURCE_BLOCK = BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK__SOURCE_BLOCK_REF = BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The number of structural features of the '<em>Virtual Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BLOCK_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.GotoImpl <em>Goto</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.GotoImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getGoto()
	 * @generated
	 */
	int GOTO = 11;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__SIMULINK_REF = VIRTUAL_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__NAME = VIRTUAL_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__PROPERTIES = VIRTUAL_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__PORTS = VIRTUAL_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__TRIGGER = VIRTUAL_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__ENABLER = VIRTUAL_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__INPORTS = VIRTUAL_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__OUTPORTS = VIRTUAL_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__PARENT = VIRTUAL_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__SOURCE_BLOCK = VIRTUAL_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__SOURCE_BLOCK_REF = VIRTUAL_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>From Blocks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__FROM_BLOCKS = VIRTUAL_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tag Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__TAG_VISIBILITY = VIRTUAL_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Goto Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__GOTO_TAG = VIRTUAL_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Goto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_FEATURE_COUNT = VIRTUAL_BLOCK_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.FromImpl <em>From</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.FromImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getFrom()
	 * @generated
	 */
	int FROM = 13;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__SIMULINK_REF = VIRTUAL_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__NAME = VIRTUAL_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__PROPERTIES = VIRTUAL_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__PORTS = VIRTUAL_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__TRIGGER = VIRTUAL_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__ENABLER = VIRTUAL_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__INPORTS = VIRTUAL_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__OUTPORTS = VIRTUAL_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__PARENT = VIRTUAL_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__SOURCE_BLOCK = VIRTUAL_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__SOURCE_BLOCK_REF = VIRTUAL_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Goto Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM__GOTO_BLOCK = VIRTUAL_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>From</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_FEATURE_COUNT = VIRTUAL_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.SimulinkModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkModelImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimulinkModel()
	 * @generated
	 */
	int SIMULINK_MODEL = 14;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_MODEL__SIMULINK_REF = SIMULINK_ELEMENT__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_MODEL__NAME = SIMULINK_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_MODEL__VERSION = SIMULINK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_MODEL__CONTAINS = SIMULINK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_MODEL__FILE = SIMULINK_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_MODEL__LIBRARY = SIMULINK_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_MODEL_FEATURE_COUNT = SIMULINK_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.MultiConnectionImpl <em>Multi Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.MultiConnectionImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getMultiConnection()
	 * @generated
	 */
	int MULTI_CONNECTION = 15;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONNECTION__SIMULINK_REF = CONNECTION__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONNECTION__NAME = CONNECTION__NAME;

	/**
	 * The feature id for the '<em><b>From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONNECTION__FROM = CONNECTION__FROM;

	/**
	 * The feature id for the '<em><b>Line Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONNECTION__LINE_NAME = CONNECTION__LINE_NAME;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONNECTION__CONNECTIONS = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.SingleConnectionImpl <em>Single Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.SingleConnectionImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSingleConnection()
	 * @generated
	 */
	int SINGLE_CONNECTION = 16;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_CONNECTION__SIMULINK_REF = CONNECTION__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_CONNECTION__NAME = CONNECTION__NAME;

	/**
	 * The feature id for the '<em><b>From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_CONNECTION__FROM = CONNECTION__FROM;

	/**
	 * The feature id for the '<em><b>Line Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_CONNECTION__LINE_NAME = CONNECTION__LINE_NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_CONNECTION__PARENT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_CONNECTION__TO = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Single Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.PortBlockImpl <em>Port Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.PortBlockImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPortBlock()
	 * @generated
	 */
	int PORT_BLOCK = 17;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__SIMULINK_REF = VIRTUAL_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__NAME = VIRTUAL_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__PROPERTIES = VIRTUAL_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__PORTS = VIRTUAL_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__TRIGGER = VIRTUAL_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__ENABLER = VIRTUAL_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__INPORTS = VIRTUAL_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__OUTPORTS = VIRTUAL_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__PARENT = VIRTUAL_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__SOURCE_BLOCK = VIRTUAL_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__SOURCE_BLOCK_REF = VIRTUAL_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK__PORT = VIRTUAL_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_BLOCK_FEATURE_COUNT = VIRTUAL_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.OutPortBlockImpl <em>Out Port Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.OutPortBlockImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getOutPortBlock()
	 * @generated
	 */
	int OUT_PORT_BLOCK = 18;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__SIMULINK_REF = PORT_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__NAME = PORT_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__PROPERTIES = PORT_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__PORTS = PORT_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__TRIGGER = PORT_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__ENABLER = PORT_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__INPORTS = PORT_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__OUTPORTS = PORT_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__PARENT = PORT_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__SOURCE_BLOCK = PORT_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__SOURCE_BLOCK_REF = PORT_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK__PORT = PORT_BLOCK__PORT;

	/**
	 * The number of structural features of the '<em>Out Port Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PORT_BLOCK_FEATURE_COUNT = PORT_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.InPortBlockImpl <em>In Port Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.InPortBlockImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getInPortBlock()
	 * @generated
	 */
	int IN_PORT_BLOCK = 19;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__SIMULINK_REF = PORT_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__NAME = PORT_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__PROPERTIES = PORT_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__PORTS = PORT_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__TRIGGER = PORT_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__ENABLER = PORT_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__INPORTS = PORT_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__OUTPORTS = PORT_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__PARENT = PORT_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__SOURCE_BLOCK = PORT_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__SOURCE_BLOCK_REF = PORT_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK__PORT = PORT_BLOCK__PORT;

	/**
	 * The number of structural features of the '<em>In Port Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PORT_BLOCK_FEATURE_COUNT = PORT_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.TriggerBlockImpl <em>Trigger Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.TriggerBlockImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTriggerBlock()
	 * @generated
	 */
	int TRIGGER_BLOCK = 20;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__SIMULINK_REF = IN_PORT_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__NAME = IN_PORT_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__PROPERTIES = IN_PORT_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__PORTS = IN_PORT_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__TRIGGER = IN_PORT_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__ENABLER = IN_PORT_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__INPORTS = IN_PORT_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__OUTPORTS = IN_PORT_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__PARENT = IN_PORT_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__SOURCE_BLOCK = IN_PORT_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__SOURCE_BLOCK_REF = IN_PORT_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__PORT = IN_PORT_BLOCK__PORT;

	/**
	 * The number of structural features of the '<em>Trigger Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK_FEATURE_COUNT = IN_PORT_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.EnableBlockImpl <em>Enable Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.EnableBlockImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getEnableBlock()
	 * @generated
	 */
	int ENABLE_BLOCK = 21;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__SIMULINK_REF = IN_PORT_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__NAME = IN_PORT_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__PROPERTIES = IN_PORT_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__PORTS = IN_PORT_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__TRIGGER = IN_PORT_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__ENABLER = IN_PORT_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__INPORTS = IN_PORT_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__OUTPORTS = IN_PORT_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__PARENT = IN_PORT_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__SOURCE_BLOCK = IN_PORT_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__SOURCE_BLOCK_REF = IN_PORT_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK__PORT = IN_PORT_BLOCK__PORT;

	/**
	 * The number of structural features of the '<em>Enable Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLE_BLOCK_FEATURE_COUNT = IN_PORT_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.SimulinkReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkReferenceImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimulinkReference()
	 * @generated
	 */
	int SIMULINK_REFERENCE = 22;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_REFERENCE__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_REFERENCE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_REFERENCE__QUALIFIER = 2;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULINK_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.GotoTagVisibilityImpl <em>Goto Tag Visibility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.GotoTagVisibilityImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getGotoTagVisibility()
	 * @generated
	 */
	int GOTO_TAG_VISIBILITY = 23;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__SIMULINK_REF = VIRTUAL_BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__NAME = VIRTUAL_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__PROPERTIES = VIRTUAL_BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__PORTS = VIRTUAL_BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__TRIGGER = VIRTUAL_BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__ENABLER = VIRTUAL_BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__INPORTS = VIRTUAL_BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__OUTPORTS = VIRTUAL_BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__PARENT = VIRTUAL_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__SOURCE_BLOCK = VIRTUAL_BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__SOURCE_BLOCK_REF = VIRTUAL_BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Goto Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY__GOTO_BLOCK = VIRTUAL_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goto Tag Visibility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TAG_VISIBILITY_FEATURE_COUNT = VIRTUAL_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.SubSystemImpl <em>Sub System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.SubSystemImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSubSystem()
	 * @generated
	 */
	int SUB_SYSTEM = 24;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__SIMULINK_REF = BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__NAME = BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__PROPERTIES = BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__PORTS = BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__TRIGGER = BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__ENABLER = BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__INPORTS = BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__OUTPORTS = BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__PARENT = BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__SOURCE_BLOCK = BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__SOURCE_BLOCK_REF = BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Sub Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__SUB_BLOCKS = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__TAG = BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.ModelReferenceImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getModelReference()
	 * @generated
	 */
	int MODEL_REFERENCE = 25;

	/**
	 * The feature id for the '<em><b>Simulink Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__SIMULINK_REF = BLOCK__SIMULINK_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__NAME = BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__PROPERTIES = BLOCK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__PORTS = BLOCK__PORTS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__TRIGGER = BLOCK__TRIGGER;

	/**
	 * The feature id for the '<em><b>Enabler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__ENABLER = BLOCK__ENABLER;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__INPORTS = BLOCK__INPORTS;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__OUTPORTS = BLOCK__OUTPORTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__PARENT = BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__SOURCE_BLOCK = BLOCK__SOURCE_BLOCK;

	/**
	 * The feature id for the '<em><b>Source Block Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__SOURCE_BLOCK_REF = BLOCK__SOURCE_BLOCK_REF;

	/**
	 * The feature id for the '<em><b>Referenced Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__REFERENCED_MODEL = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__MODEL_REF = BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl <em>Bus Signal Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusSignalMapping()
	 * @generated
	 */
	int BUS_SIGNAL_MAPPING = 27;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SIGNAL_MAPPING__SELECTOR = 0;

	/**
	 * The feature id for the '<em><b>Mapping From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SIGNAL_MAPPING__MAPPING_FROM = 1;

	/**
	 * The feature id for the '<em><b>Mapping To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SIGNAL_MAPPING__MAPPING_TO = 2;

	/**
	 * The feature id for the '<em><b>Mapping Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SIGNAL_MAPPING__MAPPING_PATH = 3;

	/**
	 * The feature id for the '<em><b>Incomplete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SIGNAL_MAPPING__INCOMPLETE = 4;

	/**
	 * The number of structural features of the '<em>Bus Signal Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_SIGNAL_MAPPING_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.LibraryLinkReferenceImpl <em>Library Link Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.LibraryLinkReferenceImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getLibraryLinkReference()
	 * @generated
	 */
	int LIBRARY_LINK_REFERENCE = 28;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_LINK_REFERENCE__ELEMENT = SIMULINK_REFERENCE__ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_LINK_REFERENCE__NAME = SIMULINK_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_LINK_REFERENCE__QUALIFIER = SIMULINK_REFERENCE__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_LINK_REFERENCE__DISABLED = SIMULINK_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Library Link Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_LINK_REFERENCE_FEATURE_COUNT = SIMULINK_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.impl.IdentifierReferenceImpl <em>Identifier Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.impl.IdentifierReferenceImpl
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getIdentifierReference()
	 * @generated
	 */
	int IDENTIFIER_REFERENCE = 29;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REFERENCE__ELEMENT = SIMULINK_REFERENCE__ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REFERENCE__NAME = SIMULINK_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REFERENCE__QUALIFIER = SIMULINK_REFERENCE__QUALIFIER;

	/**
	 * The number of structural features of the '<em>Identifier Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REFERENCE_FEATURE_COUNT = SIMULINK_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.PropertyType <em>Property Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.PropertyType
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 30;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.EnableStates <em>Enable States</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.EnableStates
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getEnableStates()
	 * @generated
	 */
	int ENABLE_STATES = 31;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.TriggerType <em>Trigger Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.TriggerType
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTriggerType()
	 * @generated
	 */
	int TRIGGER_TYPE = 32;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.TagVisibility <em>Tag Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.TagVisibility
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTagVisibility()
	 * @generated
	 */
	int TAG_VISIBILITY = 33;

	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.PropertySource <em>Property Source</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.PropertySource
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPropertySource()
	 * @generated
	 */
	int PROPERTY_SOURCE = 34;


	/**
	 * The meta object id for the '{@link hu.bme.mit.massif.simulink.SimscapePortType <em>Simscape Port Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.massif.simulink.SimscapePortType
	 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimscapePortType()
	 * @generated
	 */
	int SIMSCAPE_PORT_TYPE = 35;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.SimulinkElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkElement
	 * @generated
	 */
	EClass getSimulinkElement();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.massif.simulink.SimulinkElement#getSimulinkRef <em>Simulink Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simulink Ref</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkElement#getSimulinkRef()
	 * @see #getSimulinkElement()
	 * @generated
	 */
	EReference getSimulinkElement_SimulinkRef();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.SimulinkElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkElement#getName()
	 * @see #getSimulinkElement()
	 * @generated
	 */
	EAttribute getSimulinkElement_Name();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see hu.bme.mit.massif.simulink.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.massif.simulink.Block#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getProperties()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.massif.simulink.Block#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getPorts()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Ports();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.Block#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trigger</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getTrigger()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Trigger();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.Block#getEnabler <em>Enabler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enabler</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getEnabler()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Enabler();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.massif.simulink.Block#getInports <em>Inports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inports</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getInports()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Inports();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.massif.simulink.Block#getOutports <em>Outports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outports</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getOutports()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Outports();

	/**
	 * Returns the meta object for the container reference '{@link hu.bme.mit.massif.simulink.Block#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getParent()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Parent();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.Block#getSourceBlock <em>Source Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Block</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getSourceBlock()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_SourceBlock();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.massif.simulink.Block#getSourceBlockRef <em>Source Block Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Block Ref</em>'.
	 * @see hu.bme.mit.massif.simulink.Block#getSourceBlockRef()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_SourceBlockRef();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see hu.bme.mit.massif.simulink.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the container reference '{@link hu.bme.mit.massif.simulink.Port#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see hu.bme.mit.massif.simulink.Port#getContainer()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Container();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.Port#getPortBlock <em>Port Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port Block</em>'.
	 * @see hu.bme.mit.massif.simulink.Port#getPortBlock()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_PortBlock();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Port#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see hu.bme.mit.massif.simulink.Port#getPortType()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_PortType();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Port#getPortNo <em>Port No</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port No</em>'.
	 * @see hu.bme.mit.massif.simulink.Port#getPortNo()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_PortNo();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see hu.bme.mit.massif.simulink.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.bme.mit.massif.simulink.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.bme.mit.massif.simulink.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hu.bme.mit.massif.simulink.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Property#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see hu.bme.mit.massif.simulink.Property#getSource()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Source();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.InPort <em>In Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Port</em>'.
	 * @see hu.bme.mit.massif.simulink.InPort
	 * @generated
	 */
	EClass getInPort();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.InPort#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see hu.bme.mit.massif.simulink.InPort#getConnection()
	 * @see #getInPort()
	 * @generated
	 */
	EReference getInPort_Connection();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.OutPort <em>Out Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Port</em>'.
	 * @see hu.bme.mit.massif.simulink.OutPort
	 * @generated
	 */
	EClass getOutPort();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.massif.simulink.OutPort#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connection</em>'.
	 * @see hu.bme.mit.massif.simulink.OutPort#getConnection()
	 * @see #getOutPort()
	 * @generated
	 */
	EReference getOutPort_Connection();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see hu.bme.mit.massif.simulink.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the container reference '{@link hu.bme.mit.massif.simulink.Connection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>From</em>'.
	 * @see hu.bme.mit.massif.simulink.Connection#getFrom()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_From();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Connection#getLineName <em>Line Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Name</em>'.
	 * @see hu.bme.mit.massif.simulink.Connection#getLineName()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_LineName();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see hu.bme.mit.massif.simulink.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Trigger#getTriggerType <em>Trigger Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Type</em>'.
	 * @see hu.bme.mit.massif.simulink.Trigger#getTriggerType()
	 * @see #getTrigger()
	 * @generated
	 */
	EAttribute getTrigger_TriggerType();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Trigger#getStatesWhenEnabling <em>States When Enabling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>States When Enabling</em>'.
	 * @see hu.bme.mit.massif.simulink.Trigger#getStatesWhenEnabling()
	 * @see #getTrigger()
	 * @generated
	 */
	EAttribute getTrigger_StatesWhenEnabling();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.Enable <em>Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enable</em>'.
	 * @see hu.bme.mit.massif.simulink.Enable
	 * @generated
	 */
	EClass getEnable();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Enable#getStatesWhenEnabling <em>States When Enabling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>States When Enabling</em>'.
	 * @see hu.bme.mit.massif.simulink.Enable#getStatesWhenEnabling()
	 * @see #getEnable()
	 * @generated
	 */
	EAttribute getEnable_StatesWhenEnabling();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.BusSelector <em>Bus Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Selector</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSelector
	 * @generated
	 */
	EClass getBusSelector();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.massif.simulink.BusSelector#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSelector#getMappings()
	 * @see #getBusSelector()
	 * @generated
	 */
	EReference getBusSelector_Mappings();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.BusSelector#isOutputAsBus <em>Output As Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output As Bus</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSelector#isOutputAsBus()
	 * @see #getBusSelector()
	 * @generated
	 */
	EAttribute getBusSelector_OutputAsBus();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.BusSelector#getBusCreator <em>Bus Creator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bus Creator</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSelector#getBusCreator()
	 * @see #getBusSelector()
	 * @generated
	 */
	EReference getBusSelector_BusCreator();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.BusCreator <em>Bus Creator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Creator</em>'.
	 * @see hu.bme.mit.massif.simulink.BusCreator
	 * @generated
	 */
	EClass getBusCreator();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.Goto <em>Goto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto</em>'.
	 * @see hu.bme.mit.massif.simulink.Goto
	 * @generated
	 */
	EClass getGoto();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.massif.simulink.Goto#getFromBlocks <em>From Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Blocks</em>'.
	 * @see hu.bme.mit.massif.simulink.Goto#getFromBlocks()
	 * @see #getGoto()
	 * @generated
	 */
	EReference getGoto_FromBlocks();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Goto#getTagVisibility <em>Tag Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag Visibility</em>'.
	 * @see hu.bme.mit.massif.simulink.Goto#getTagVisibility()
	 * @see #getGoto()
	 * @generated
	 */
	EAttribute getGoto_TagVisibility();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.Goto#getGotoTag <em>Goto Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goto Tag</em>'.
	 * @see hu.bme.mit.massif.simulink.Goto#getGotoTag()
	 * @see #getGoto()
	 * @generated
	 */
	EAttribute getGoto_GotoTag();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.VirtualBlock <em>Virtual Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Block</em>'.
	 * @see hu.bme.mit.massif.simulink.VirtualBlock
	 * @generated
	 */
	EClass getVirtualBlock();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.From <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From</em>'.
	 * @see hu.bme.mit.massif.simulink.From
	 * @generated
	 */
	EClass getFrom();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.From#getGotoBlock <em>Goto Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Goto Block</em>'.
	 * @see hu.bme.mit.massif.simulink.From#getGotoBlock()
	 * @see #getFrom()
	 * @generated
	 */
	EReference getFrom_GotoBlock();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.SimulinkModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkModel
	 * @generated
	 */
	EClass getSimulinkModel();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.SimulinkModel#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkModel#getVersion()
	 * @see #getSimulinkModel()
	 * @generated
	 */
	EAttribute getSimulinkModel_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.massif.simulink.SimulinkModel#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkModel#getContains()
	 * @see #getSimulinkModel()
	 * @generated
	 */
	EReference getSimulinkModel_Contains();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.SimulinkModel#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkModel#getFile()
	 * @see #getSimulinkModel()
	 * @generated
	 */
	EAttribute getSimulinkModel_File();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.SimulinkModel#isLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkModel#isLibrary()
	 * @see #getSimulinkModel()
	 * @generated
	 */
	EAttribute getSimulinkModel_Library();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.MultiConnection <em>Multi Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Connection</em>'.
	 * @see hu.bme.mit.massif.simulink.MultiConnection
	 * @generated
	 */
	EClass getMultiConnection();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.massif.simulink.MultiConnection#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see hu.bme.mit.massif.simulink.MultiConnection#getConnections()
	 * @see #getMultiConnection()
	 * @generated
	 */
	EReference getMultiConnection_Connections();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.SingleConnection <em>Single Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Connection</em>'.
	 * @see hu.bme.mit.massif.simulink.SingleConnection
	 * @generated
	 */
	EClass getSingleConnection();

	/**
	 * Returns the meta object for the container reference '{@link hu.bme.mit.massif.simulink.SingleConnection#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see hu.bme.mit.massif.simulink.SingleConnection#getParent()
	 * @see #getSingleConnection()
	 * @generated
	 */
	EReference getSingleConnection_Parent();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.SingleConnection#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see hu.bme.mit.massif.simulink.SingleConnection#getTo()
	 * @see #getSingleConnection()
	 * @generated
	 */
	EReference getSingleConnection_To();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.PortBlock <em>Port Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Block</em>'.
	 * @see hu.bme.mit.massif.simulink.PortBlock
	 * @generated
	 */
	EClass getPortBlock();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.PortBlock#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see hu.bme.mit.massif.simulink.PortBlock#getPort()
	 * @see #getPortBlock()
	 * @generated
	 */
	EReference getPortBlock_Port();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.OutPortBlock <em>Out Port Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Port Block</em>'.
	 * @see hu.bme.mit.massif.simulink.OutPortBlock
	 * @generated
	 */
	EClass getOutPortBlock();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.InPortBlock <em>In Port Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Port Block</em>'.
	 * @see hu.bme.mit.massif.simulink.InPortBlock
	 * @generated
	 */
	EClass getInPortBlock();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.TriggerBlock <em>Trigger Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger Block</em>'.
	 * @see hu.bme.mit.massif.simulink.TriggerBlock
	 * @generated
	 */
	EClass getTriggerBlock();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.EnableBlock <em>Enable Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enable Block</em>'.
	 * @see hu.bme.mit.massif.simulink.EnableBlock
	 * @generated
	 */
	EClass getEnableBlock();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.SimulinkReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkReference
	 * @generated
	 */
	EClass getSimulinkReference();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.SimulinkReference#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkReference#getElement()
	 * @see #getSimulinkReference()
	 * @generated
	 */
	EReference getSimulinkReference_Element();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.SimulinkReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkReference#getName()
	 * @see #getSimulinkReference()
	 * @generated
	 */
	EAttribute getSimulinkReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.SimulinkReference#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualifier</em>'.
	 * @see hu.bme.mit.massif.simulink.SimulinkReference#getQualifier()
	 * @see #getSimulinkReference()
	 * @generated
	 */
	EAttribute getSimulinkReference_Qualifier();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.GotoTagVisibility <em>Goto Tag Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto Tag Visibility</em>'.
	 * @see hu.bme.mit.massif.simulink.GotoTagVisibility
	 * @generated
	 */
	EClass getGotoTagVisibility();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.GotoTagVisibility#getGotoBlock <em>Goto Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Goto Block</em>'.
	 * @see hu.bme.mit.massif.simulink.GotoTagVisibility#getGotoBlock()
	 * @see #getGotoTagVisibility()
	 * @generated
	 */
	EReference getGotoTagVisibility_GotoBlock();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.SubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub System</em>'.
	 * @see hu.bme.mit.massif.simulink.SubSystem
	 * @generated
	 */
	EClass getSubSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.massif.simulink.SubSystem#getSubBlocks <em>Sub Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Blocks</em>'.
	 * @see hu.bme.mit.massif.simulink.SubSystem#getSubBlocks()
	 * @see #getSubSystem()
	 * @generated
	 */
	EReference getSubSystem_SubBlocks();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.SubSystem#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see hu.bme.mit.massif.simulink.SubSystem#getTag()
	 * @see #getSubSystem()
	 * @generated
	 */
	EAttribute getSubSystem_Tag();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.ModelReference <em>Model Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Reference</em>'.
	 * @see hu.bme.mit.massif.simulink.ModelReference
	 * @generated
	 */
	EClass getModelReference();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.ModelReference#getReferencedModel <em>Referenced Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Model</em>'.
	 * @see hu.bme.mit.massif.simulink.ModelReference#getReferencedModel()
	 * @see #getModelReference()
	 * @generated
	 */
	EReference getModelReference_ReferencedModel();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.massif.simulink.ModelReference#getModelRef <em>Model Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Ref</em>'.
	 * @see hu.bme.mit.massif.simulink.ModelReference#getModelRef()
	 * @see #getModelReference()
	 * @generated
	 */
	EReference getModelReference_ModelRef();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.BusSpecification <em>Bus Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Specification</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSpecification
	 * @generated
	 */
	EClass getBusSpecification();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.BusSignalMapping <em>Bus Signal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Signal Mapping</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSignalMapping
	 * @generated
	 */
	EClass getBusSignalMapping();

	/**
	 * Returns the meta object for the container reference '{@link hu.bme.mit.massif.simulink.BusSignalMapping#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Selector</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSignalMapping#getSelector()
	 * @see #getBusSignalMapping()
	 * @generated
	 */
	EReference getBusSignalMapping_Selector();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.BusSignalMapping#getMappingFrom <em>Mapping From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping From</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSignalMapping#getMappingFrom()
	 * @see #getBusSignalMapping()
	 * @generated
	 */
	EReference getBusSignalMapping_MappingFrom();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.massif.simulink.BusSignalMapping#getMappingTo <em>Mapping To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping To</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSignalMapping#getMappingTo()
	 * @see #getBusSignalMapping()
	 * @generated
	 */
	EReference getBusSignalMapping_MappingTo();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.BusSignalMapping#getMappingPath <em>Mapping Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapping Path</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSignalMapping#getMappingPath()
	 * @see #getBusSignalMapping()
	 * @generated
	 */
	EAttribute getBusSignalMapping_MappingPath();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.BusSignalMapping#isIncomplete <em>Incomplete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incomplete</em>'.
	 * @see hu.bme.mit.massif.simulink.BusSignalMapping#isIncomplete()
	 * @see #getBusSignalMapping()
	 * @generated
	 */
	EAttribute getBusSignalMapping_Incomplete();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.LibraryLinkReference <em>Library Link Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Link Reference</em>'.
	 * @see hu.bme.mit.massif.simulink.LibraryLinkReference
	 * @generated
	 */
	EClass getLibraryLinkReference();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.massif.simulink.LibraryLinkReference#isDisabled <em>Disabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disabled</em>'.
	 * @see hu.bme.mit.massif.simulink.LibraryLinkReference#isDisabled()
	 * @see #getLibraryLinkReference()
	 * @generated
	 */
	EAttribute getLibraryLinkReference_Disabled();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.massif.simulink.IdentifierReference <em>Identifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Reference</em>'.
	 * @see hu.bme.mit.massif.simulink.IdentifierReference
	 * @generated
	 */
	EClass getIdentifierReference();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.massif.simulink.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Type</em>'.
	 * @see hu.bme.mit.massif.simulink.PropertyType
	 * @generated
	 */
	EEnum getPropertyType();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.massif.simulink.EnableStates <em>Enable States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enable States</em>'.
	 * @see hu.bme.mit.massif.simulink.EnableStates
	 * @generated
	 */
	EEnum getEnableStates();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.massif.simulink.TriggerType <em>Trigger Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trigger Type</em>'.
	 * @see hu.bme.mit.massif.simulink.TriggerType
	 * @generated
	 */
	EEnum getTriggerType();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.massif.simulink.TagVisibility <em>Tag Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tag Visibility</em>'.
	 * @see hu.bme.mit.massif.simulink.TagVisibility
	 * @generated
	 */
	EEnum getTagVisibility();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.massif.simulink.PropertySource <em>Property Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Source</em>'.
	 * @see hu.bme.mit.massif.simulink.PropertySource
	 * @generated
	 */
	EEnum getPropertySource();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.massif.simulink.SimscapePortType <em>Simscape Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Simscape Port Type</em>'.
	 * @see hu.bme.mit.massif.simulink.SimscapePortType
	 * @generated
	 */
	EEnum getSimscapePortType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimulinkFactory getSimulinkFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.SimulinkElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkElementImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimulinkElement()
		 * @generated
		 */
		EClass SIMULINK_ELEMENT = eINSTANCE.getSimulinkElement();

		/**
		 * The meta object literal for the '<em><b>Simulink Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULINK_ELEMENT__SIMULINK_REF = eINSTANCE.getSimulinkElement_SimulinkRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULINK_ELEMENT__NAME = eINSTANCE.getSimulinkElement_Name();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.BlockImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__PROPERTIES = eINSTANCE.getBlock_Properties();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__PORTS = eINSTANCE.getBlock_Ports();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__TRIGGER = eINSTANCE.getBlock_Trigger();

		/**
		 * The meta object literal for the '<em><b>Enabler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__ENABLER = eINSTANCE.getBlock_Enabler();

		/**
		 * The meta object literal for the '<em><b>Inports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__INPORTS = eINSTANCE.getBlock_Inports();

		/**
		 * The meta object literal for the '<em><b>Outports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__OUTPORTS = eINSTANCE.getBlock_Outports();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__PARENT = eINSTANCE.getBlock_Parent();

		/**
		 * The meta object literal for the '<em><b>Source Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__SOURCE_BLOCK = eINSTANCE.getBlock_SourceBlock();

		/**
		 * The meta object literal for the '<em><b>Source Block Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__SOURCE_BLOCK_REF = eINSTANCE.getBlock_SourceBlockRef();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.PortImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__CONTAINER = eINSTANCE.getPort_Container();

		/**
		 * The meta object literal for the '<em><b>Port Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PORT_BLOCK = eINSTANCE.getPort_PortBlock();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__PORT_TYPE = eINSTANCE.getPort_PortType();

		/**
		 * The meta object literal for the '<em><b>Port No</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__PORT_NO = eINSTANCE.getPort_PortNo();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.PropertyImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__SOURCE = eINSTANCE.getProperty_Source();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.InPortImpl <em>In Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.InPortImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getInPort()
		 * @generated
		 */
		EClass IN_PORT = eINSTANCE.getInPort();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PORT__CONNECTION = eINSTANCE.getInPort_Connection();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.OutPortImpl <em>Out Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.OutPortImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getOutPort()
		 * @generated
		 */
		EClass OUT_PORT = eINSTANCE.getOutPort();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUT_PORT__CONNECTION = eINSTANCE.getOutPort_Connection();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.ConnectionImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__FROM = eINSTANCE.getConnection_From();

		/**
		 * The meta object literal for the '<em><b>Line Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__LINE_NAME = eINSTANCE.getConnection_LineName();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.TriggerImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>Trigger Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGER__TRIGGER_TYPE = eINSTANCE.getTrigger_TriggerType();

		/**
		 * The meta object literal for the '<em><b>States When Enabling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGER__STATES_WHEN_ENABLING = eINSTANCE.getTrigger_StatesWhenEnabling();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.EnableImpl <em>Enable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.EnableImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getEnable()
		 * @generated
		 */
		EClass ENABLE = eINSTANCE.getEnable();

		/**
		 * The meta object literal for the '<em><b>States When Enabling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENABLE__STATES_WHEN_ENABLING = eINSTANCE.getEnable_StatesWhenEnabling();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.BusSelectorImpl <em>Bus Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.BusSelectorImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusSelector()
		 * @generated
		 */
		EClass BUS_SELECTOR = eINSTANCE.getBusSelector();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_SELECTOR__MAPPINGS = eINSTANCE.getBusSelector_Mappings();

		/**
		 * The meta object literal for the '<em><b>Output As Bus</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS_SELECTOR__OUTPUT_AS_BUS = eINSTANCE.getBusSelector_OutputAsBus();

		/**
		 * The meta object literal for the '<em><b>Bus Creator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_SELECTOR__BUS_CREATOR = eINSTANCE.getBusSelector_BusCreator();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.BusCreatorImpl <em>Bus Creator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.BusCreatorImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusCreator()
		 * @generated
		 */
		EClass BUS_CREATOR = eINSTANCE.getBusCreator();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.GotoImpl <em>Goto</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.GotoImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getGoto()
		 * @generated
		 */
		EClass GOTO = eINSTANCE.getGoto();

		/**
		 * The meta object literal for the '<em><b>From Blocks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOTO__FROM_BLOCKS = eINSTANCE.getGoto_FromBlocks();

		/**
		 * The meta object literal for the '<em><b>Tag Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOTO__TAG_VISIBILITY = eINSTANCE.getGoto_TagVisibility();

		/**
		 * The meta object literal for the '<em><b>Goto Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOTO__GOTO_TAG = eINSTANCE.getGoto_GotoTag();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.VirtualBlockImpl <em>Virtual Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.VirtualBlockImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getVirtualBlock()
		 * @generated
		 */
		EClass VIRTUAL_BLOCK = eINSTANCE.getVirtualBlock();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.FromImpl <em>From</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.FromImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getFrom()
		 * @generated
		 */
		EClass FROM = eINSTANCE.getFrom();

		/**
		 * The meta object literal for the '<em><b>Goto Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM__GOTO_BLOCK = eINSTANCE.getFrom_GotoBlock();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.SimulinkModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkModelImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimulinkModel()
		 * @generated
		 */
		EClass SIMULINK_MODEL = eINSTANCE.getSimulinkModel();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULINK_MODEL__VERSION = eINSTANCE.getSimulinkModel_Version();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULINK_MODEL__CONTAINS = eINSTANCE.getSimulinkModel_Contains();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULINK_MODEL__FILE = eINSTANCE.getSimulinkModel_File();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULINK_MODEL__LIBRARY = eINSTANCE.getSimulinkModel_Library();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.MultiConnectionImpl <em>Multi Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.MultiConnectionImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getMultiConnection()
		 * @generated
		 */
		EClass MULTI_CONNECTION = eINSTANCE.getMultiConnection();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_CONNECTION__CONNECTIONS = eINSTANCE.getMultiConnection_Connections();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.SingleConnectionImpl <em>Single Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.SingleConnectionImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSingleConnection()
		 * @generated
		 */
		EClass SINGLE_CONNECTION = eINSTANCE.getSingleConnection();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_CONNECTION__PARENT = eINSTANCE.getSingleConnection_Parent();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_CONNECTION__TO = eINSTANCE.getSingleConnection_To();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.PortBlockImpl <em>Port Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.PortBlockImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPortBlock()
		 * @generated
		 */
		EClass PORT_BLOCK = eINSTANCE.getPortBlock();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_BLOCK__PORT = eINSTANCE.getPortBlock_Port();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.OutPortBlockImpl <em>Out Port Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.OutPortBlockImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getOutPortBlock()
		 * @generated
		 */
		EClass OUT_PORT_BLOCK = eINSTANCE.getOutPortBlock();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.InPortBlockImpl <em>In Port Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.InPortBlockImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getInPortBlock()
		 * @generated
		 */
		EClass IN_PORT_BLOCK = eINSTANCE.getInPortBlock();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.TriggerBlockImpl <em>Trigger Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.TriggerBlockImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTriggerBlock()
		 * @generated
		 */
		EClass TRIGGER_BLOCK = eINSTANCE.getTriggerBlock();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.EnableBlockImpl <em>Enable Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.EnableBlockImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getEnableBlock()
		 * @generated
		 */
		EClass ENABLE_BLOCK = eINSTANCE.getEnableBlock();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.SimulinkReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkReferenceImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimulinkReference()
		 * @generated
		 */
		EClass SIMULINK_REFERENCE = eINSTANCE.getSimulinkReference();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULINK_REFERENCE__ELEMENT = eINSTANCE.getSimulinkReference_Element();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULINK_REFERENCE__NAME = eINSTANCE.getSimulinkReference_Name();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULINK_REFERENCE__QUALIFIER = eINSTANCE.getSimulinkReference_Qualifier();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.GotoTagVisibilityImpl <em>Goto Tag Visibility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.GotoTagVisibilityImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getGotoTagVisibility()
		 * @generated
		 */
		EClass GOTO_TAG_VISIBILITY = eINSTANCE.getGotoTagVisibility();

		/**
		 * The meta object literal for the '<em><b>Goto Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOTO_TAG_VISIBILITY__GOTO_BLOCK = eINSTANCE.getGotoTagVisibility_GotoBlock();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.SubSystemImpl <em>Sub System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.SubSystemImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSubSystem()
		 * @generated
		 */
		EClass SUB_SYSTEM = eINSTANCE.getSubSystem();

		/**
		 * The meta object literal for the '<em><b>Sub Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM__SUB_BLOCKS = eINSTANCE.getSubSystem_SubBlocks();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_SYSTEM__TAG = eINSTANCE.getSubSystem_Tag();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.ModelReferenceImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getModelReference()
		 * @generated
		 */
		EClass MODEL_REFERENCE = eINSTANCE.getModelReference();

		/**
		 * The meta object literal for the '<em><b>Referenced Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REFERENCE__REFERENCED_MODEL = eINSTANCE.getModelReference_ReferencedModel();

		/**
		 * The meta object literal for the '<em><b>Model Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REFERENCE__MODEL_REF = eINSTANCE.getModelReference_ModelRef();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.BusSpecificationImpl <em>Bus Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.BusSpecificationImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusSpecification()
		 * @generated
		 */
		EClass BUS_SPECIFICATION = eINSTANCE.getBusSpecification();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl <em>Bus Signal Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getBusSignalMapping()
		 * @generated
		 */
		EClass BUS_SIGNAL_MAPPING = eINSTANCE.getBusSignalMapping();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_SIGNAL_MAPPING__SELECTOR = eINSTANCE.getBusSignalMapping_Selector();

		/**
		 * The meta object literal for the '<em><b>Mapping From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_SIGNAL_MAPPING__MAPPING_FROM = eINSTANCE.getBusSignalMapping_MappingFrom();

		/**
		 * The meta object literal for the '<em><b>Mapping To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_SIGNAL_MAPPING__MAPPING_TO = eINSTANCE.getBusSignalMapping_MappingTo();

		/**
		 * The meta object literal for the '<em><b>Mapping Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS_SIGNAL_MAPPING__MAPPING_PATH = eINSTANCE.getBusSignalMapping_MappingPath();

		/**
		 * The meta object literal for the '<em><b>Incomplete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS_SIGNAL_MAPPING__INCOMPLETE = eINSTANCE.getBusSignalMapping_Incomplete();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.LibraryLinkReferenceImpl <em>Library Link Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.LibraryLinkReferenceImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getLibraryLinkReference()
		 * @generated
		 */
		EClass LIBRARY_LINK_REFERENCE = eINSTANCE.getLibraryLinkReference();

		/**
		 * The meta object literal for the '<em><b>Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_LINK_REFERENCE__DISABLED = eINSTANCE.getLibraryLinkReference_Disabled();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.impl.IdentifierReferenceImpl <em>Identifier Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.impl.IdentifierReferenceImpl
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getIdentifierReference()
		 * @generated
		 */
		EClass IDENTIFIER_REFERENCE = eINSTANCE.getIdentifierReference();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.PropertyType <em>Property Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.PropertyType
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPropertyType()
		 * @generated
		 */
		EEnum PROPERTY_TYPE = eINSTANCE.getPropertyType();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.EnableStates <em>Enable States</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.EnableStates
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getEnableStates()
		 * @generated
		 */
		EEnum ENABLE_STATES = eINSTANCE.getEnableStates();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.TriggerType <em>Trigger Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.TriggerType
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTriggerType()
		 * @generated
		 */
		EEnum TRIGGER_TYPE = eINSTANCE.getTriggerType();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.TagVisibility <em>Tag Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.TagVisibility
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getTagVisibility()
		 * @generated
		 */
		EEnum TAG_VISIBILITY = eINSTANCE.getTagVisibility();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.PropertySource <em>Property Source</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.PropertySource
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getPropertySource()
		 * @generated
		 */
		EEnum PROPERTY_SOURCE = eINSTANCE.getPropertySource();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.massif.simulink.SimscapePortType <em>Simscape Port Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.massif.simulink.SimscapePortType
		 * @see hu.bme.mit.massif.simulink.impl.SimulinkPackageImpl#getSimscapePortType()
		 * @generated
		 */
		EEnum SIMSCAPE_PORT_TYPE = eINSTANCE.getSimscapePortType();

	}

} //SimulinkPackage
