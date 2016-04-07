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
 * A representation of the model object '<em><b>Goto</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Goto block passes its input to its corresponding #{simulink.From} blocks.
 *  From and #{simulink.Goto} blocks allow you to pass a signal from one block to another without actually connecting them.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/goto.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.Goto#getFromBlocks <em>From Blocks</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Goto#getTagVisibility <em>Tag Visibility</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Goto#getGotoTag <em>Goto Tag</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getGoto()
 * @model
 * @generated
 */
public interface Goto extends VirtualBlock {
	/**
     * Returns the value of the '<em><b>From Blocks</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.massif.simulink.From}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.massif.simulink.From#getGotoBlock <em>Goto Block</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Blocks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From Blocks</em>' reference list.
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getGoto_FromBlocks()
     * @see hu.bme.mit.massif.simulink.From#getGotoBlock
     * @model opposite="gotoBlock"
     * @generated
     */
	EList<From> getFromBlocks();

	/**
     * Returns the value of the '<em><b>Tag Visibility</b></em>' attribute.
     * The literals are from the enumeration {@link hu.bme.mit.massif.simulink.TagVisibility}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Tag Visibility</em>' attribute.
     * @see hu.bme.mit.massif.simulink.TagVisibility
     * @see #setTagVisibility(TagVisibility)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getGoto_TagVisibility()
     * @model
     * @generated
     */
	TagVisibility getTagVisibility();

	/**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Goto#getTagVisibility <em>Tag Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tag Visibility</em>' attribute.
     * @see hu.bme.mit.massif.simulink.TagVisibility
     * @see #getTagVisibility()
     * @generated
     */
	void setTagVisibility(TagVisibility value);

	/**
     * Returns the value of the '<em><b>Goto Tag</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goto Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Goto Tag</em>' attribute.
     * @see #setGotoTag(String)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getGoto_GotoTag()
     * @model
     * @generated
     */
	String getGotoTag();

	/**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Goto#getGotoTag <em>Goto Tag</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Goto Tag</em>' attribute.
     * @see #getGotoTag()
     * @generated
     */
	void setGotoTag(String value);

} // Goto
