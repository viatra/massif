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
package hu.bme.mit.massif.simulink.impl;

import hu.bme.mit.massif.simulink.LibraryLinkReference;
import hu.bme.mit.massif.simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library Link Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.LibraryLinkReferenceImpl#isDisabled <em>Disabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibraryLinkReferenceImpl extends SimulinkReferenceImpl implements LibraryLinkReference {
	/**
     * The default value of the '{@link #isDisabled() <em>Disabled</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isDisabled()
     * @generated
     * @ordered
     */
	protected static final boolean DISABLED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isDisabled() <em>Disabled</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isDisabled()
     * @generated
     * @ordered
     */
	protected boolean disabled = DISABLED_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LibraryLinkReferenceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SimulinkPackage.Literals.LIBRARY_LINK_REFERENCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isDisabled() {
        return disabled;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDisabled(boolean newDisabled) {
        boolean oldDisabled = disabled;
        disabled = newDisabled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.LIBRARY_LINK_REFERENCE__DISABLED, oldDisabled, disabled));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SimulinkPackage.LIBRARY_LINK_REFERENCE__DISABLED:
                return isDisabled();
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
            case SimulinkPackage.LIBRARY_LINK_REFERENCE__DISABLED:
                setDisabled((Boolean)newValue);
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
            case SimulinkPackage.LIBRARY_LINK_REFERENCE__DISABLED:
                setDisabled(DISABLED_EDEFAULT);
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
            case SimulinkPackage.LIBRARY_LINK_REFERENCE__DISABLED:
                return disabled != DISABLED_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (disabled: ");
        result.append(disabled);
        result.append(')');
        return result.toString();
    }

} //LibraryLinkReferenceImpl
