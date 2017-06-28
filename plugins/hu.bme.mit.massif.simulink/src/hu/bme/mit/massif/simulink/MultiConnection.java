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
 * A representation of the model object '<em><b>Multi Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a connection between a single #{simulink.OutPort} and multiple #{simulink.InPort}.
 * Each inport is connected by a #{simulink.SingleConnection} contained by this connection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.MultiConnection#getConnections <em>Connections</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getMultiConnection()
 * @model
 * @generated
 */
public interface MultiConnection extends Connection {
	/**
     * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.massif.simulink.SingleConnection}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.SingleConnection#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Connections</em>' containment reference list.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getMultiConnection_Connections()
     * @see hu.bme.mit.massif.simulink.SingleConnection#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
	EList<SingleConnection> getConnections();

} // MultiConnection
