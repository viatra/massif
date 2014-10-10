/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.Component.impl.PlatformConnectedElementImpl;

import hu.bme.mit.transima.FunctionalArchitecture.FAMTerminator;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalData;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FAM Terminator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FAMTerminatorImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FAMTerminatorImpl extends PlatformConnectedElementImpl implements FAMTerminator {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FAMTerminatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FunctionalArchitectureModelPackage.Literals.FAM_TERMINATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalData getData() {
        if (eContainerFeatureID() != FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA) return null;
        return (FunctionalData)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetData(FunctionalData newData, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newData, FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setData(FunctionalData newData) {
        if (newData != eInternalContainer() || (eContainerFeatureID() != FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA && newData != null)) {
            if (EcoreUtil.isAncestor(this, newData))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newData != null)
                msgs = ((InternalEObject)newData).eInverseAdd(this, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR, FunctionalData.class, msgs);
            msgs = basicSetData(newData, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA, newData, newData));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetData((FunctionalData)otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA:
                return basicSetData(null, msgs);
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
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA:
                return eInternalContainer().eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR, FunctionalData.class, msgs);
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
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA:
                return getData();
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
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA:
                setData((FunctionalData)newValue);
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
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA:
                setData((FunctionalData)null);
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
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA:
                return getData() != null;
        }
        return super.eIsSet(featureID);
    }

} //FAMTerminatorImpl
