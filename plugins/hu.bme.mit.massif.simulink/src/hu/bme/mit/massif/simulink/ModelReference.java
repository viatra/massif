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
 * A representation of the model object '<em><b>Model Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a #{simulink.SimulinkModel} included as a block in this model.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/model.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.ModelReference#getReferencedModel <em>Referenced Model</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.ModelReference#getModelRef <em>Model Ref</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getModelReference()
 * @model
 * @generated
 */
public interface ModelReference extends Block {
	/**
	 * Returns the value of the '<em><b>Referenced Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the reference is computed by finding the model with the same name and qualifier as stored in the modelRef.
	 * 
	 * b{Validation}
	 *  * WARN: Cannot find model specified by model reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referenced Model</em>' reference.
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getModelReference_ReferencedModel()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='hu.bme.mit.massif.models.simulink.derived.referencedModel'"
	 * @generated
	 */
	SimulinkModel getReferencedModel();

	/**
	 * Returns the value of the '<em><b>Model Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Ref</em>' containment reference.
	 * @see #setModelRef(IdentifierReference)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getModelReference_ModelRef()
	 * @model containment="true"
	 * @generated
	 */
	IdentifierReference getModelRef();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.ModelReference#getModelRef <em>Model Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Ref</em>' containment reference.
	 * @see #getModelRef()
	 * @generated
	 */
	void setModelRef(IdentifierReference value);

} // ModelReference
