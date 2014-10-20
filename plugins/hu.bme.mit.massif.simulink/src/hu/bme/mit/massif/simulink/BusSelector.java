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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a bus selector block that separates the signals from the bus received on its inport into its outports.
 * Since it is possible to select only some of the signals and even embedded signals from a bus inside the bus,
 *  mapping entries (#{simulink.BusSignalMapping}) are used to indicate which outport (mappingTo) selects which signals originating from a given outport (mappingFrom).
 * 
 * The outputAsBus attribute is true if the selected signals are bundled into a bus and placed on a single outport.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/busselector.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.BusSelector#getMappings <em>Mappings</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.BusSelector#isOutputAsBus <em>Output As Bus</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.BusSelector#getBusCreator <em>Bus Creator</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBusSelector()
 * @model
 * @generated
 */
public interface BusSelector extends BusSpecification {
	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.massif.simulink.BusSignalMapping}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.BusSignalMapping#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBusSelector_Mappings()
	 * @see hu.bme.mit.massif.simulink.BusSignalMapping#getSelector
	 * @model opposite="selector" containment="true"
	 * @generated
	 */
	EList<BusSignalMapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Output As Bus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output As Bus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output As Bus</em>' attribute.
	 * @see #setOutputAsBus(boolean)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBusSelector_OutputAsBus()
	 * @model
	 * @generated
	 */
	boolean isOutputAsBus();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.BusSelector#isOutputAsBus <em>Output As Bus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output As Bus</em>' attribute.
	 * @see #isOutputAsBus()
	 * @generated
	 */
	void setOutputAsBus(boolean value);

	/**
	 * Returns the value of the '<em><b>Bus Creator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This reference points to the creator of the incoming bus signal.
	 *  Either a bus creator or a bus selector with outputAsBus = true.
	 *  Always determined as backward navigation on signals is deterministic.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bus Creator</em>' reference.
	 * @see #setBusCreator(BusSpecification)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBusSelector_BusCreator()
	 * @model
	 * @generated
	 */
	BusSpecification getBusCreator();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.BusSelector#getBusCreator <em>Bus Creator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Creator</em>' reference.
	 * @see #getBusCreator()
	 * @generated
	 */
	void setBusCreator(BusSpecification value);

} // BusSelector
