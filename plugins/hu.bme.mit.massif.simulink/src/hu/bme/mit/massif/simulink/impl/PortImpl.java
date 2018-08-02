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

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.PortImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.impl.PortImpl#getPortBlock <em>Port Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PortImpl extends SimulinkElementImpl implements Port {
	/**
     * The cached value of the '{@link #getPortBlock() <em>Port Block</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPortBlock()
     * @generated
     * @ordered
     */
	protected PortBlock portBlock;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PortImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SimulinkPackage.Literals.PORT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block getContainer() {
        if (eContainerFeatureID() != SimulinkPackage.PORT__CONTAINER) return null;
        return (Block)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetContainer(Block newContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newContainer, SimulinkPackage.PORT__CONTAINER, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setContainer(Block newContainer) {
        if (newContainer != eInternalContainer() || (eContainerFeatureID() != SimulinkPackage.PORT__CONTAINER && newContainer != null)) {
            if (EcoreUtil.isAncestor(this, newContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContainer != null)
                msgs = ((InternalEObject)newContainer).eInverseAdd(this, SimulinkPackage.BLOCK__PORTS, Block.class, msgs);
            msgs = basicSetContainer(newContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.PORT__CONTAINER, newContainer, newContainer));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PortBlock getPortBlock() {
        if (portBlock != null && portBlock.eIsProxy()) {
            InternalEObject oldPortBlock = (InternalEObject)portBlock;
            portBlock = (PortBlock)eResolveProxy(oldPortBlock);
            if (portBlock != oldPortBlock) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.PORT__PORT_BLOCK, oldPortBlock, portBlock));
            }
        }
        return portBlock;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PortBlock basicGetPortBlock() {
        return portBlock;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPortBlock(PortBlock newPortBlock, NotificationChain msgs) {
        PortBlock oldPortBlock = portBlock;
        portBlock = newPortBlock;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.PORT__PORT_BLOCK, oldPortBlock, newPortBlock);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPortBlock(PortBlock newPortBlock) {
        if (newPortBlock != portBlock) {
            NotificationChain msgs = null;
            if (portBlock != null)
                msgs = ((InternalEObject)portBlock).eInverseRemove(this, SimulinkPackage.PORT_BLOCK__PORT, PortBlock.class, msgs);
            if (newPortBlock != null)
                msgs = ((InternalEObject)newPortBlock).eInverseAdd(this, SimulinkPackage.PORT_BLOCK__PORT, PortBlock.class, msgs);
            msgs = basicSetPortBlock(newPortBlock, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.PORT__PORT_BLOCK, newPortBlock, newPortBlock));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimulinkPackage.PORT__CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContainer((Block)otherEnd, msgs);
            case SimulinkPackage.PORT__PORT_BLOCK:
                if (portBlock != null)
                    msgs = ((InternalEObject)portBlock).eInverseRemove(this, SimulinkPackage.PORT_BLOCK__PORT, PortBlock.class, msgs);
                return basicSetPortBlock((PortBlock)otherEnd, msgs);
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
            case SimulinkPackage.PORT__CONTAINER:
                return basicSetContainer(null, msgs);
            case SimulinkPackage.PORT__PORT_BLOCK:
                return basicSetPortBlock(null, msgs);
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
            case SimulinkPackage.PORT__CONTAINER:
                return eInternalContainer().eInverseRemove(this, SimulinkPackage.BLOCK__PORTS, Block.class, msgs);
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
            case SimulinkPackage.PORT__CONTAINER:
                return getContainer();
            case SimulinkPackage.PORT__PORT_BLOCK:
                if (resolve) return getPortBlock();
                return basicGetPortBlock();
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
            case SimulinkPackage.PORT__CONTAINER:
                setContainer((Block)newValue);
                return;
            case SimulinkPackage.PORT__PORT_BLOCK:
                setPortBlock((PortBlock)newValue);
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
            case SimulinkPackage.PORT__CONTAINER:
                setContainer((Block)null);
                return;
            case SimulinkPackage.PORT__PORT_BLOCK:
                setPortBlock((PortBlock)null);
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
            case SimulinkPackage.PORT__CONTAINER:
                return getContainer() != null;
            case SimulinkPackage.PORT__PORT_BLOCK:
                return portBlock != null;
        }
        return super.eIsSet(featureID);
    }

} //PortImpl
