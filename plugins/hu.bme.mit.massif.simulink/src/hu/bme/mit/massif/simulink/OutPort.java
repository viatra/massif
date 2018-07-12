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
 * A representation of the model object '<em><b>Out Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents an outport of a #{simulink.Block}.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/outport.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.OutPort#getConnection <em>Connection</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getOutPort()
 * @model
 * @generated
 */
public interface OutPort extends Port {
	/**
	 * Returns the value of the '<em><b>Connection</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.Connection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection</em>' containment reference.
	 * @see #setConnection(Connection)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getOutPort_Connection()
	 * @see hu.bme.mit.massif.simulink.Connection#getFrom
	 * @model opposite="from" containment="true"
	 * @generated
	 */
	Connection getConnection();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.OutPort#getConnection <em>Connection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' containment reference.
	 * @see #getConnection()
	 * @generated
	 */
	void setConnection(Connection value);

} // OutPort
