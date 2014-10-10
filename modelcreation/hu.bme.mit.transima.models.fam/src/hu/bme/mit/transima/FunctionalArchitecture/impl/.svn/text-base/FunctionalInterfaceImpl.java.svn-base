/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.Component.impl.PlatformConnectedElementImpl;

import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalData;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalInput;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalOutput;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.incquery.querybasedfeatures.runtime.IQueryBasedFeatureHandler;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureKind;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalInterfaceImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalInterfaceImpl#getData <em>Data</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalInterfaceImpl#getElement <em>Element</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalInterfaceImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalInterfaceImpl extends PlatformConnectedElementImpl implements FunctionalInterface {
    /**
     * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getData()
     * @generated
     * @ordered
     */
    protected EList<FunctionalData> data;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FunctionalInterfaceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FunctionalArchitectureModelPackage.Literals.FUNCTIONAL_INTERFACE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FunctionalInput> getInputsGen() {
        // TODO: implement this method to return the 'Inputs' reference list
        // Ensure that you remove @generated or mark it @generated NOT
        // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
        // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FunctionalData> getData() {
        if (data == null) {
            data = new EObjectContainmentWithInverseEList<FunctionalData>(FunctionalData.class, this, FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE);
        }
        return data;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalElement getElement() {
        if (eContainerFeatureID() != FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT) return null;
        return (FunctionalElement)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetElement(FunctionalElement newElement, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newElement, FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setElement(FunctionalElement newElement) {
        if (newElement != eInternalContainer() || (eContainerFeatureID() != FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT && newElement != null)) {
            if (EcoreUtil.isAncestor(this, newElement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newElement != null)
                msgs = ((InternalEObject)newElement).eInverseAdd(this, FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE, FunctionalElement.class, msgs);
            msgs = basicSetElement(newElement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT, newElement, newElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FunctionalOutput> getOutputsGen() {
        // TODO: implement this method to return the 'Outputs' reference list
        // Ensure that you remove @generated or mark it @generated NOT
        // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
        // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
        throw new UnsupportedOperationException();
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getData()).basicAdd(otherEnd, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetElement((FunctionalElement)otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA:
                return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT:
                return basicSetElement(null, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT:
                return eInternalContainer().eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE, FunctionalElement.class, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__INPUTS:
                return getInputs();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA:
                return getData();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT:
                return getElement();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__OUTPUTS:
                return getOutputs();
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA:
                getData().clear();
                getData().addAll((Collection<? extends FunctionalData>)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT:
                setElement((FunctionalElement)newValue);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA:
                getData().clear();
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT:
                setElement((FunctionalElement)null);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__INPUTS:
                return !getInputs().isEmpty();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA:
                return data != null && !data.isEmpty();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT:
                return getElement() != null;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__OUTPUTS:
                return !getOutputs().isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * EMF-IncQuery handler for query-based feature inputs
     */
    private IQueryBasedFeatureHandler inputsHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature inputs
     */
    public EList<FunctionalInput> getInputs() {
        if (inputsHandler == null) {
            inputsHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                FunctionalArchitectureModelPackageImpl.Literals.FUNCTIONAL_INTERFACE__INPUTS,
                "hu.bme.mit.transima.models.fam.derived.inputs", "This", "Target",
                QueryBasedFeatureKind.MANY_REFERENCE, true, false);
        }
        return inputsHandler.getManyReferenceValueAsEList(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature outputs
     */
    private IQueryBasedFeatureHandler outputsHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature outputs
     */
    public EList<FunctionalOutput> getOutputs() {
        if (outputsHandler == null) {
            outputsHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                FunctionalArchitectureModelPackageImpl.Literals.FUNCTIONAL_INTERFACE__OUTPUTS,
                "hu.bme.mit.transima.models.fam.derived.outputs", "This", "Target",
                QueryBasedFeatureKind.MANY_REFERENCE, true, false);
        }
        return outputsHandler.getManyReferenceValueAsEList(this);
    }

} //FunctionalInterfaceImpl
