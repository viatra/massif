/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.Component.impl.PlatformConnectedElementImpl;

import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModel;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional Architecture Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalArchitectureModelImpl#getRootElements <em>Root Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalArchitectureModelImpl extends PlatformConnectedElementImpl implements FunctionalArchitectureModel {
    /**
     * The cached value of the '{@link #getRootElements() <em>Root Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRootElements()
     * @generated
     * @ordered
     */
    protected EList<FunctionalElement> rootElements;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FunctionalArchitectureModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FunctionalArchitectureModelPackage.Literals.FUNCTIONAL_ARCHITECTURE_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FunctionalElement> getRootElements() {
        if (rootElements == null) {
            rootElements = new EObjectContainmentEList<FunctionalElement>(FunctionalElement.class, this, FunctionalArchitectureModelPackage.FUNCTIONAL_ARCHITECTURE_MODEL__ROOT_ELEMENTS);
        }
        return rootElements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ARCHITECTURE_MODEL__ROOT_ELEMENTS:
                return ((InternalEList<?>)getRootElements()).basicRemove(otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ARCHITECTURE_MODEL__ROOT_ELEMENTS:
                return getRootElements();
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ARCHITECTURE_MODEL__ROOT_ELEMENTS:
                getRootElements().clear();
                getRootElements().addAll((Collection<? extends FunctionalElement>)newValue);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ARCHITECTURE_MODEL__ROOT_ELEMENTS:
                getRootElements().clear();
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ARCHITECTURE_MODEL__ROOT_ELEMENTS:
                return rootElements != null && !rootElements.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //FunctionalArchitectureModelImpl
