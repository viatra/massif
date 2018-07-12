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

import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goto Tag Visibility</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.GotoTagVisibilityImpl#getGotoBlock <em>Goto Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GotoTagVisibilityImpl extends VirtualBlockImpl implements GotoTagVisibility {
	/**
	 * The cached value of the '{@link #getGotoBlock() <em>Goto Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGotoBlock()
	 * @generated
	 * @ordered
	 */
	protected Goto gotoBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GotoTagVisibilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkPackage.Literals.GOTO_TAG_VISIBILITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goto getGotoBlock() {
		if (gotoBlock != null && gotoBlock.eIsProxy()) {
			InternalEObject oldGotoBlock = (InternalEObject)gotoBlock;
			gotoBlock = (Goto)eResolveProxy(oldGotoBlock);
			if (gotoBlock != oldGotoBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.GOTO_TAG_VISIBILITY__GOTO_BLOCK, oldGotoBlock, gotoBlock));
			}
		}
		return gotoBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goto basicGetGotoBlock() {
		return gotoBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGotoBlock(Goto newGotoBlock) {
		Goto oldGotoBlock = gotoBlock;
		gotoBlock = newGotoBlock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.GOTO_TAG_VISIBILITY__GOTO_BLOCK, oldGotoBlock, gotoBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.GOTO_TAG_VISIBILITY__GOTO_BLOCK:
				if (resolve) return getGotoBlock();
				return basicGetGotoBlock();
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
			case SimulinkPackage.GOTO_TAG_VISIBILITY__GOTO_BLOCK:
				setGotoBlock((Goto)newValue);
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
			case SimulinkPackage.GOTO_TAG_VISIBILITY__GOTO_BLOCK:
				setGotoBlock((Goto)null);
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
			case SimulinkPackage.GOTO_TAG_VISIBILITY__GOTO_BLOCK:
				return gotoBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //GotoTagVisibilityImpl
