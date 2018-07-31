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
import hu.bme.mit.massif.simulink.BusSpecification;
import hu.bme.mit.massif.simulink.SimulinkPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSelectorImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSelectorImpl#isOutputAsBus <em>Output As Bus</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.BusSelectorImpl#getBusCreator <em>Bus Creator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BusSelectorImpl extends BusSpecificationImpl implements BusSelector {
	/**
     * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMappings()
     * @generated
     * @ordered
     */
	protected EList<BusSignalMapping> mappings;

	/**
     * The default value of the '{@link #isOutputAsBus() <em>Output As Bus</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOutputAsBus()
     * @generated
     * @ordered
     */
	protected static final boolean OUTPUT_AS_BUS_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isOutputAsBus() <em>Output As Bus</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOutputAsBus()
     * @generated
     * @ordered
     */
	protected boolean outputAsBus = OUTPUT_AS_BUS_EDEFAULT;

	/**
     * The cached value of the '{@link #getBusCreator() <em>Bus Creator</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBusCreator()
     * @generated
     * @ordered
     */
	protected BusSpecification busCreator;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BusSelectorImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SimulinkPackage.Literals.BUS_SELECTOR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<BusSignalMapping> getMappings() {
        if (mappings == null) {
            mappings = new EObjectContainmentWithInverseEList<BusSignalMapping>(BusSignalMapping.class, this, SimulinkPackage.BUS_SELECTOR__MAPPINGS, SimulinkPackage.BUS_SIGNAL_MAPPING__SELECTOR);
        }
        return mappings;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isOutputAsBus() {
        return outputAsBus;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOutputAsBus(boolean newOutputAsBus) {
        boolean oldOutputAsBus = outputAsBus;
        outputAsBus = newOutputAsBus;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BUS_SELECTOR__OUTPUT_AS_BUS, oldOutputAsBus, outputAsBus));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusSpecification getBusCreator() {
        if (busCreator != null && busCreator.eIsProxy()) {
            InternalEObject oldBusCreator = (InternalEObject)busCreator;
            busCreator = (BusSpecification)eResolveProxy(oldBusCreator);
            if (busCreator != oldBusCreator) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.BUS_SELECTOR__BUS_CREATOR, oldBusCreator, busCreator));
            }
        }
        return busCreator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusSpecification basicGetBusCreator() {
        return busCreator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBusCreator(BusSpecification newBusCreator) {
        BusSpecification oldBusCreator = busCreator;
        busCreator = newBusCreator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BUS_SELECTOR__BUS_CREATOR, oldBusCreator, busCreator));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimulinkPackage.BUS_SELECTOR__MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappings()).basicAdd(otherEnd, msgs);
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
            case SimulinkPackage.BUS_SELECTOR__MAPPINGS:
                return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
            case SimulinkPackage.BUS_SELECTOR__MAPPINGS:
                return getMappings();
            case SimulinkPackage.BUS_SELECTOR__OUTPUT_AS_BUS:
                return isOutputAsBus();
            case SimulinkPackage.BUS_SELECTOR__BUS_CREATOR:
                if (resolve) return getBusCreator();
                return basicGetBusCreator();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SimulinkPackage.BUS_SELECTOR__MAPPINGS:
                getMappings().clear();
                getMappings().addAll((Collection<? extends BusSignalMapping>)newValue);
                return;
            case SimulinkPackage.BUS_SELECTOR__OUTPUT_AS_BUS:
                setOutputAsBus((Boolean)newValue);
                return;
            case SimulinkPackage.BUS_SELECTOR__BUS_CREATOR:
                setBusCreator((BusSpecification)newValue);
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
            case SimulinkPackage.BUS_SELECTOR__MAPPINGS:
                getMappings().clear();
                return;
            case SimulinkPackage.BUS_SELECTOR__OUTPUT_AS_BUS:
                setOutputAsBus(OUTPUT_AS_BUS_EDEFAULT);
                return;
            case SimulinkPackage.BUS_SELECTOR__BUS_CREATOR:
                setBusCreator((BusSpecification)null);
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
            case SimulinkPackage.BUS_SELECTOR__MAPPINGS:
                return mappings != null && !mappings.isEmpty();
            case SimulinkPackage.BUS_SELECTOR__OUTPUT_AS_BUS:
                return outputAsBus != OUTPUT_AS_BUS_EDEFAULT;
            case SimulinkPackage.BUS_SELECTOR__BUS_CREATOR:
                return busCreator != null;
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
        result.append(" (outputAsBus: ");
        result.append(outputAsBus);
        result.append(')');
        return result.toString();
    }

} //BusSelectorImpl
