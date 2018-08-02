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
package hu.bme.mit.massif.simulink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the basic building block of Simulink systems. Each block has properties, ports and
 *  can refer to a source block that was used as the template from a library to create the element.
 * 
 * The properties are not a map, so the block may have multiple properties with the same name, or even same name-value pair.
 * 
 * The different type of ports are accessible through computed filtered lists.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getPorts <em>Ports</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getEnabler <em>Enabler</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getInports <em>Inports</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getOutports <em>Outports</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getParent <em>Parent</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getSourceBlock <em>Source Block</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Block#getSourceBlockRef <em>Source Block Ref</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends SimulinkElement {
	/**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.massif.simulink.Parameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_Parameters()
     * @model containment="true"
     * @generated
     */
    EList<Parameter> getParameters();

    /**
     * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.massif.simulink.Port}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.Port#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Ports</em>' containment reference list.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_Ports()
     * @see hu.bme.mit.massif.simulink.Port#getContainer
     * @model opposite="container" containment="true"
     * @generated
     */
	EList<Port> getPorts();

	/**
     * Returns the value of the '<em><b>Trigger</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Trigger ports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Trigger</em>' reference.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_Trigger()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='hu.bme.mit.massif.models.simulink.derived.trigger'"
     * @generated
     */
	Trigger getTrigger();

	/**
     * Returns the value of the '<em><b>Enabler</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Enable ports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Enabler</em>' reference.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_Enabler()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='hu.bme.mit.massif.models.simulink.derived.enabler'"
     * @generated
     */
	Enable getEnabler();

	/**
     * Returns the value of the '<em><b>Inports</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.massif.simulink.InPort}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Inports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Inports</em>' reference list.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_Inports()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='hu.bme.mit.massif.models.simulink.derived.inports'"
     * @generated
     */
	EList<InPort> getInports();

	/**
     * Returns the value of the '<em><b>Outports</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.massif.simulink.OutPort}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Outports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Outports</em>' reference list.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_Outports()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='hu.bme.mit.massif.models.simulink.derived.outports'"
     * @generated
     */
	EList<OutPort> getOutports();

	/**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.SubSystem#getSubBlocks <em>Sub Blocks</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(SubSystem)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_Parent()
     * @see hu.bme.mit.massif.simulink.SubSystem#getSubBlocks
     * @model opposite="subBlocks" transient="false"
     * @generated
     */
	SubSystem getParent();

	/**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Block#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
	void setParent(SubSystem value);

	/**
     * Returns the value of the '<em><b>Source Block</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value of the reference is computed by finding the element with the same name and qualifier as stored in the sourceBlockRef.
     * 
     * b{Validation}
     *  * WARN: Cannot find block specified by source block reference.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Source Block</em>' reference.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_SourceBlock()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='hu.bme.mit.massif.models.simulink.derived.sourceBlock'"
     * @generated
     */
	Block getSourceBlock();

	/**
     * Returns the value of the '<em><b>Source Block Ref</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Block Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Source Block Ref</em>' containment reference.
     * @see #setSourceBlockRef(LibraryLinkReference)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getBlock_SourceBlockRef()
     * @model containment="true"
     * @generated
     */
	LibraryLinkReference getSourceBlockRef();

	/**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Block#getSourceBlockRef <em>Source Block Ref</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Block Ref</em>' containment reference.
     * @see #getSourceBlockRef()
     * @generated
     */
	void setSourceBlockRef(LibraryLinkReference value);

} // Block
