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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the connection between #{simulink.Block} elements in order to transfer data from an outport to one or more inports.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.Connection#getFrom <em>From</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Connection#getLineName <em>Line Name</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getConnection()
 * @model abstract="true"
 * @generated
 */
public interface Connection extends SimulinkElement {
	/**
	 * Returns the value of the '<em><b>From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.OutPort#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' container reference.
	 * @see #setFrom(OutPort)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getConnection_From()
	 * @see hu.bme.mit.massif.simulink.OutPort#getConnection
	 * @model opposite="connection" transient="false"
	 * @generated
	 */
	OutPort getFrom();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.Connection#getFrom <em>From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' container reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(OutPort value);

	/**
	 * Returns the value of the '<em><b>Line Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Name</em>' attribute.
	 * @see #setLineName(String)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getConnection_LineName()
	 * @model
	 * @generated
	 */
	String getLineName();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.Connection#getLineName <em>Line Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Name</em>' attribute.
	 * @see #getLineName()
	 * @generated
	 */
	void setLineName(String value);

} // Connection
