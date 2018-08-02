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

import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkPackage;
import hu.bme.mit.massif.simulink.SimulinkReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulink Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.SimulinkReferenceImpl#getElement <em>Element</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.SimulinkReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.SimulinkReferenceImpl#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SimulinkReferenceImpl extends EObjectImpl implements SimulinkReference {
	/**
     * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElement()
     * @generated
     * @ordered
     */
	protected SimulinkElement element;

	/**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final String NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected String name = NAME_EDEFAULT;

	/**
     * The default value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getQualifier()
     * @generated
     * @ordered
     */
	protected static final String QUALIFIER_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getQualifier()
     * @generated
     * @ordered
     */
	protected String qualifier = QUALIFIER_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SimulinkReferenceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SimulinkPackage.Literals.SIMULINK_REFERENCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimulinkElement getElement() {
        if (element != null && element.eIsProxy()) {
            InternalEObject oldElement = (InternalEObject)element;
            element = (SimulinkElement)eResolveProxy(oldElement);
            if (element != oldElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.SIMULINK_REFERENCE__ELEMENT, oldElement, element));
            }
        }
        return element;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimulinkElement basicGetElement() {
        return element;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setElement(SimulinkElement newElement) {
        SimulinkElement oldElement = element;
        element = newElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.SIMULINK_REFERENCE__ELEMENT, oldElement, element));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.SIMULINK_REFERENCE__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getQualifier() {
        return qualifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setQualifier(String newQualifier) {
        String oldQualifier = qualifier;
        qualifier = newQualifier;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.SIMULINK_REFERENCE__QUALIFIER, oldQualifier, qualifier));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getFQN() {
        if(qualifier != null)
            return qualifier+"/"+name;
        else 
            return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SimulinkPackage.SIMULINK_REFERENCE__ELEMENT:
                if (resolve) return getElement();
                return basicGetElement();
            case SimulinkPackage.SIMULINK_REFERENCE__NAME:
                return getName();
            case SimulinkPackage.SIMULINK_REFERENCE__QUALIFIER:
                return getQualifier();
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
            case SimulinkPackage.SIMULINK_REFERENCE__ELEMENT:
                setElement((SimulinkElement)newValue);
                return;
            case SimulinkPackage.SIMULINK_REFERENCE__NAME:
                setName((String)newValue);
                return;
            case SimulinkPackage.SIMULINK_REFERENCE__QUALIFIER:
                setQualifier((String)newValue);
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
            case SimulinkPackage.SIMULINK_REFERENCE__ELEMENT:
                setElement((SimulinkElement)null);
                return;
            case SimulinkPackage.SIMULINK_REFERENCE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimulinkPackage.SIMULINK_REFERENCE__QUALIFIER:
                setQualifier(QUALIFIER_EDEFAULT);
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
            case SimulinkPackage.SIMULINK_REFERENCE__ELEMENT:
                return element != null;
            case SimulinkPackage.SIMULINK_REFERENCE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimulinkPackage.SIMULINK_REFERENCE__QUALIFIER:
                return QUALIFIER_EDEFAULT == null ? qualifier != null : !QUALIFIER_EDEFAULT.equals(qualifier);
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
        result.append(" (name: ");
        result.append(name);
        result.append(", qualifier: ");
        result.append(qualifier);
        result.append(')');
        return result.toString();
    }

} //SimulinkReferenceImpl
