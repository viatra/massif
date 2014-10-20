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

import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Signal Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl#getMappingFrom <em>Mapping From</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl#getMappingTo <em>Mapping To</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl#getMappingPath <em>Mapping Path</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSignalMappingImpl#isIncomplete <em>Incomplete</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusSignalMappingImpl extends EObjectImpl implements BusSignalMapping {
	/**
	 * The cached value of the '{@link #getMappingFrom() <em>Mapping From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingFrom()
	 * @generated
	 * @ordered
	 */
	protected OutPort mappingFrom;

	/**
	 * The cached value of the '{@link #getMappingTo() <em>Mapping To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingTo()
	 * @generated
	 * @ordered
	 */
	protected OutPort mappingTo;

	/**
	 * The default value of the '{@link #getMappingPath() <em>Mapping Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingPath()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPING_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappingPath() <em>Mapping Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingPath()
	 * @generated
	 * @ordered
	 */
	protected String mappingPath = MAPPING_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #isIncomplete() <em>Incomplete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncomplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCOMPLETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncomplete() <em>Incomplete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncomplete()
	 * @generated
	 * @ordered
	 */
	protected boolean incomplete = INCOMPLETE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusSignalMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkPackage.Literals.BUS_SIGNAL_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusSelector getSelector() {
		if (eContainerFeatureID() != SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR) return null;
		return (BusSelector)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelector(BusSelector newSelector, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSelector, SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelector(BusSelector newSelector) {
		if (newSelector != eInternalContainer() || (eContainerFeatureID() != SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR && newSelector != null)) {
			if (EcoreUtil.isAncestor(this, newSelector))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSelector != null)
				msgs = ((InternalEObject)newSelector).eInverseAdd(this, SimulinkPackage.BUS_SELECTOR__MAPPINGS, BusSelector.class, msgs);
			msgs = basicSetSelector(newSelector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR, newSelector, newSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPort getMappingFrom() {
		if (mappingFrom != null && mappingFrom.eIsProxy()) {
			InternalEObject oldMappingFrom = (InternalEObject)mappingFrom;
			mappingFrom = (OutPort)eResolveProxy(oldMappingFrom);
			if (mappingFrom != oldMappingFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_FROM, oldMappingFrom, mappingFrom));
			}
		}
		return mappingFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPort basicGetMappingFrom() {
		return mappingFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingFrom(OutPort newMappingFrom) {
		OutPort oldMappingFrom = mappingFrom;
		mappingFrom = newMappingFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_FROM, oldMappingFrom, mappingFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPort getMappingTo() {
		if (mappingTo != null && mappingTo.eIsProxy()) {
			InternalEObject oldMappingTo = (InternalEObject)mappingTo;
			mappingTo = (OutPort)eResolveProxy(oldMappingTo);
			if (mappingTo != oldMappingTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_TO, oldMappingTo, mappingTo));
			}
		}
		return mappingTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPort basicGetMappingTo() {
		return mappingTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingTo(OutPort newMappingTo) {
		OutPort oldMappingTo = mappingTo;
		mappingTo = newMappingTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_TO, oldMappingTo, mappingTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMappingPath() {
		return mappingPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingPath(String newMappingPath) {
		String oldMappingPath = mappingPath;
		mappingPath = newMappingPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_PATH, oldMappingPath, mappingPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncomplete() {
		return incomplete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomplete(boolean newIncomplete) {
		boolean oldIncomplete = incomplete;
		incomplete = newIncomplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BUS_SIGNAL_MAPPING__INCOMPLETE, oldIncomplete, incomplete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSelector((BusSelector)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR:
				return basicSetSelector(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR:
				return eInternalContainer().eInverseRemove(this, SimulinkPackage.BUS_SELECTOR__MAPPINGS, BusSelector.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR:
				return getSelector();
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_FROM:
				if (resolve) return getMappingFrom();
				return basicGetMappingFrom();
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_TO:
				if (resolve) return getMappingTo();
				return basicGetMappingTo();
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_PATH:
				return getMappingPath();
			case SimulinkPackage.BUS_SIGNAL_MAPPING__INCOMPLETE:
				return isIncomplete();
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
			case SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR:
				setSelector((BusSelector)newValue);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_FROM:
				setMappingFrom((OutPort)newValue);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_TO:
				setMappingTo((OutPort)newValue);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_PATH:
				setMappingPath((String)newValue);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__INCOMPLETE:
				setIncomplete((Boolean)newValue);
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
			case SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR:
				setSelector((BusSelector)null);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_FROM:
				setMappingFrom((OutPort)null);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_TO:
				setMappingTo((OutPort)null);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_PATH:
				setMappingPath(MAPPING_PATH_EDEFAULT);
				return;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__INCOMPLETE:
				setIncomplete(INCOMPLETE_EDEFAULT);
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
			case SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR:
				return getSelector() != null;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_FROM:
				return mappingFrom != null;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_TO:
				return mappingTo != null;
			case SimulinkPackage.BUS_SIGNAL_MAPPING__MAPPING_PATH:
				return MAPPING_PATH_EDEFAULT == null ? mappingPath != null : !MAPPING_PATH_EDEFAULT.equals(mappingPath);
			case SimulinkPackage.BUS_SIGNAL_MAPPING__INCOMPLETE:
				return incomplete != INCOMPLETE_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mappingPath: ");
		result.append(mappingPath);
		result.append(", incomplete: ");
		result.append(incomplete);
		result.append(')');
		return result.toString();
	}

} //BusSignalMappingImpl
