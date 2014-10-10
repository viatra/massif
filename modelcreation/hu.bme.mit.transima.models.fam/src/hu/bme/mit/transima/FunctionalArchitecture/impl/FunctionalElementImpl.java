/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.Component.impl.PlatformConnectedElementImpl;

import hu.bme.mit.transima.FunctionalArchitecture.Function;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModel;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface;
import hu.bme.mit.transima.FunctionalArchitecture.InformationLink;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.querybasedfeatures.runtime.IQueryBasedFeatureHandler;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureKind;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalElementImpl#getModel <em>Model</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalElementImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalElementImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalElementImpl#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalElementImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalElementImpl#getConnects <em>Connects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FunctionalElementImpl extends PlatformConnectedElementImpl implements FunctionalElement {
    /**
     * The cached value of the '{@link #getInterface() <em>Interface</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInterface()
     * @generated
     * @ordered
     */
    protected FunctionalInterface interface_;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FunctionalElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FunctionalArchitectureModelPackage.Literals.FUNCTIONAL_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalArchitectureModel getModel() {
        FunctionalArchitectureModel model = basicGetModel();
        return model != null && model.eIsProxy() ? (FunctionalArchitectureModel)eResolveProxy((InternalEObject)model) : model;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalArchitectureModel basicGetModelGen() {
        // TODO: implement this method to return the 'Model' reference
        // -> do not perform proxy resolution
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Function getParent() {
        if (eContainerFeatureID() != FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT) return null;
        return (Function)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParent(Function newParent, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParent, FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent(Function newParent) {
        if (newParent != eInternalContainer() || (eContainerFeatureID() != FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT && newParent != null)) {
            if (EcoreUtil.isAncestor(this, newParent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParent != null)
                msgs = ((InternalEObject)newParent).eInverseAdd(this, FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS, Function.class, msgs);
            msgs = basicSetParent(newParent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT, newParent, newParent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalInterface getInterface() {
        return interface_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInterface(FunctionalInterface newInterface, NotificationChain msgs) {
        FunctionalInterface oldInterface = interface_;
        interface_ = newInterface;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE, oldInterface, newInterface);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInterface(FunctionalInterface newInterface) {
        if (newInterface != interface_) {
            NotificationChain msgs = null;
            if (interface_ != null)
                msgs = ((InternalEObject)interface_).eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT, FunctionalInterface.class, msgs);
            if (newInterface != null)
                msgs = ((InternalEObject)newInterface).eInverseAdd(this, FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__ELEMENT, FunctionalInterface.class, msgs);
            msgs = basicSetInterface(newInterface, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE, newInterface, newInterface));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InformationLink> getOutgoingLinksGen() {
        // TODO: implement this method to return the 'Outgoing Links' reference list
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
    public EList<InformationLink> getIncomingLinksGen() {
        // TODO: implement this method to return the 'Incoming Links' reference list
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
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParent((Function)otherEnd, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE:
                if (interface_ != null)
                    msgs = ((InternalEObject)interface_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE, null, msgs);
                return basicSetInterface((FunctionalInterface)otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT:
                return basicSetParent(null, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE:
                return basicSetInterface(null, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT:
                return eInternalContainer().eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS, Function.class, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__MODEL:
                if (resolve) return getModel();
                return basicGetModel();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT:
                return getParent();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE:
                return getInterface();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__OUTGOING_LINKS:
                return getOutgoingLinks();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INCOMING_LINKS:
                return getIncomingLinks();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__CONNECTS:
                return getConnects();
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT:
                setParent((Function)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE:
                setInterface((FunctionalInterface)newValue);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT:
                setParent((Function)null);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE:
                setInterface((FunctionalInterface)null);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__MODEL:
                return basicGetModel() != null;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT:
                return getParent() != null;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INTERFACE:
                return interface_ != null;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__OUTGOING_LINKS:
                return !getOutgoingLinks().isEmpty();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__INCOMING_LINKS:
                return !getIncomingLinks().isEmpty();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__CONNECTS:
                return !getConnects().isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FunctionalElement> getConnectsGen() {
        // TODO: implement this method to return the 'Connects' reference list
        // Ensure that you remove @generated or mark it @generated NOT
        // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
        // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature connects
     */
    public FunctionalElement basicGetConnects() {
        if (connectsHandler == null) {
            connectsHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                    FunctionalArchitectureModelPackageImpl.Literals.FUNCTIONAL_ELEMENT__CONNECTS,
                    "hu.bme.mit.transima.models.fam.derived.connects", "This", "Target",
                    QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement) connectsHandler
                .getSingleReferenceValue(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature model
     */
    private IQueryBasedFeatureHandler modelHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature model
     */
    public FunctionalArchitectureModel basicGetModel() {
        if (modelHandler == null) {
            modelHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                FunctionalArchitectureModelPackageImpl.Literals.FUNCTIONAL_ELEMENT__MODEL,
                "hu.bme.mit.transima.models.fam.derived.model", "This", "Target",
                QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModel) modelHandler
                .getSingleReferenceValue(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature outgoingLinks
     */
    private IQueryBasedFeatureHandler outgoingLinksHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature outgoingLinks
     */
    public EList<InformationLink> getOutgoingLinks() {
        if (outgoingLinksHandler == null) {
            outgoingLinksHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                FunctionalArchitectureModelPackageImpl.Literals.FUNCTIONAL_ELEMENT__OUTGOING_LINKS,
                "hu.bme.mit.transima.models.fam.derived.outgoingLinks", "This", "Target",
                QueryBasedFeatureKind.MANY_REFERENCE, true, false);
        }
        return outgoingLinksHandler.getManyReferenceValueAsEList(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature incomingLinks
     */
    private IQueryBasedFeatureHandler incomingLinksHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature incomingLinks
     */
    public EList<InformationLink> getIncomingLinks() {
        if (incomingLinksHandler == null) {
            incomingLinksHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                FunctionalArchitectureModelPackageImpl.Literals.FUNCTIONAL_ELEMENT__INCOMING_LINKS,
                "hu.bme.mit.transima.models.fam.derived.incomingLinks", "This", "Target",
                QueryBasedFeatureKind.MANY_REFERENCE, true, false);
        }
        return incomingLinksHandler.getManyReferenceValueAsEList(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature connects
     */
    private IQueryBasedFeatureHandler connectsHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature connects
     */
    public EList<FunctionalElement> getConnects() {
        if (connectsHandler == null) {
            connectsHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                FunctionalArchitectureModelPackageImpl.Literals.FUNCTIONAL_ELEMENT__CONNECTS,
                "hu.bme.mit.transima.models.fam.derived.connects", "This", "Target",
                QueryBasedFeatureKind.MANY_REFERENCE, true, false);
        }
        return connectsHandler.getManyReferenceValueAsEList(this);
    }

} //FunctionalElementImpl
