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
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a trigger port of a #{simulink.Block}.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/trigger.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.Trigger#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Trigger#getStatesWhenEnabling <em>States When Enabling</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends InPort {
	/**
	 * Returns the value of the '<em><b>Trigger Type</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.massif.simulink.TriggerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger Type</em>' attribute.
	 * @see hu.bme.mit.massif.simulink.TriggerType
	 * @see #setTriggerType(TriggerType)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getTrigger_TriggerType()
	 * @model
	 * @generated
	 */
	TriggerType getTriggerType();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.Trigger#getTriggerType <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger Type</em>' attribute.
	 * @see hu.bme.mit.massif.simulink.TriggerType
	 * @see #getTriggerType()
	 * @generated
	 */
	void setTriggerType(TriggerType value);

	/**
	 * Returns the value of the '<em><b>States When Enabling</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.massif.simulink.EnableStates}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States When Enabling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States When Enabling</em>' attribute.
	 * @see hu.bme.mit.massif.simulink.EnableStates
	 * @see #setStatesWhenEnabling(EnableStates)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getTrigger_StatesWhenEnabling()
	 * @model
	 * @generated
	 */
	EnableStates getStatesWhenEnabling();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.Trigger#getStatesWhenEnabling <em>States When Enabling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>States When Enabling</em>' attribute.
	 * @see hu.bme.mit.massif.simulink.EnableStates
	 * @see #getStatesWhenEnabling()
	 * @generated
	 */
	void setStatesWhenEnabling(EnableStates value);

} // Trigger
