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
package hu.bme.mit.massif.simulink.impl;

import hu.bme.mit.massif.simulink.IdentifierReference;
import hu.bme.mit.massif.simulink.ModelReference;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.ModelReferenceImpl#getReferencedModel <em>Referenced Model</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.ModelReferenceImpl#getModelRef <em>Model Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelReferenceImpl extends BlockImpl implements ModelReference {
	/**
	 * The cached setting delegate for the '{@link #getReferencedModel() <em>Referenced Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedModel()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate REFERENCED_MODEL__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.MODEL_REFERENCE__REFERENCED_MODEL).getSettingDelegate();

	/**
	 * The cached value of the '{@link #getModelRef() <em>Model Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelRef()
	 * @generated
	 * @ordered
	 */
	protected IdentifierReference modelRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkPackage.Literals.MODEL_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkModel getReferencedModel() {
		return (SimulinkModel)REFERENCED_MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkModel basicGetReferencedModel() {
		return (SimulinkModel)REFERENCED_MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierReference getModelRef() {
		return modelRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelRef(IdentifierReference newModelRef, NotificationChain msgs) {
		IdentifierReference oldModelRef = modelRef;
		modelRef = newModelRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.MODEL_REFERENCE__MODEL_REF, oldModelRef, newModelRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelRef(IdentifierReference newModelRef) {
		if (newModelRef != modelRef) {
			NotificationChain msgs = null;
			if (modelRef != null)
				msgs = ((InternalEObject)modelRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.MODEL_REFERENCE__MODEL_REF, null, msgs);
			if (newModelRef != null)
				msgs = ((InternalEObject)newModelRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.MODEL_REFERENCE__MODEL_REF, null, msgs);
			msgs = basicSetModelRef(newModelRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.MODEL_REFERENCE__MODEL_REF, newModelRef, newModelRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				return basicSetModelRef(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.MODEL_REFERENCE__REFERENCED_MODEL:
				if (resolve) return getReferencedModel();
				return basicGetReferencedModel();
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				return getModelRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				setModelRef((IdentifierReference)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				setModelRef((IdentifierReference)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimulinkPackage.MODEL_REFERENCE__REFERENCED_MODEL:
				return REFERENCED_MODEL__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				return modelRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelReferenceImpl
