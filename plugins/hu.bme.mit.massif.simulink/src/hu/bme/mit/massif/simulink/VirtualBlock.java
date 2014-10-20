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
 * A representation of the model object '<em><b>Virtual Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the abstract supertype of blocks that do not explicitly affect the simulation of the Simulink system.
 * These blocks are called virtual and are added as syntactic sugar, for example #{simulink.Goto} and #{simulink.From} can be used 
 * instead of a direct #{simulink.Connection} to connect blocks.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getVirtualBlock()
 * @model abstract="true"
 * @generated
 */
public interface VirtualBlock extends Block {
} // VirtualBlock
