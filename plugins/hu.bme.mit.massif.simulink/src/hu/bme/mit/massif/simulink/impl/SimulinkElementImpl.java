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
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulink Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.SimulinkElementImpl#getSimulinkRef <em>Simulink Ref</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.SimulinkElementImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SimulinkElementImpl extends EObjectImpl implements SimulinkElement {
	/**
     * The cached value of the '{@link #getSimulinkRef() <em>Simulink Ref</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSimulinkRef()
     * @generated
     * @ordered
     */
	protected IdentifierReference simulinkRef;

	/**
     * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.SIMULINK_ELEMENT__NAME).getSettingDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SimulinkElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SimulinkPackage.Literals.SIMULINK_ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IdentifierReference getSimulinkRef() {
        return simulinkRef;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSimulinkRef(IdentifierReference newSimulinkRef, NotificationChain msgs) {
        IdentifierReference oldSimulinkRef = simulinkRef;
        simulinkRef = newSimulinkRef;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, oldSimulinkRef, newSimulinkRef);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSimulinkRef(IdentifierReference newSimulinkRef) {
        if (newSimulinkRef != simulinkRef) {
            NotificationChain msgs = null;
            if (simulinkRef != null)
                msgs = ((InternalEObject)simulinkRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, null, msgs);
            if (newSimulinkRef != null)
                msgs = ((InternalEObject)newSimulinkRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, null, msgs);
            msgs = basicSetSimulinkRef(newSimulinkRef, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, newSimulinkRef, newSimulinkRef));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return (String)NAME__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                return basicSetSimulinkRef(null, msgs);
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                return getSimulinkRef();
            case SimulinkPackage.SIMULINK_ELEMENT__NAME:
                return getName();
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                setSimulinkRef((IdentifierReference)newValue);
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                setSimulinkRef((IdentifierReference)null);
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                return simulinkRef != null;
            case SimulinkPackage.SIMULINK_ELEMENT__NAME:
                return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
        }
        return super.eIsSet(featureID);
    }

} //SimulinkElementImpl
