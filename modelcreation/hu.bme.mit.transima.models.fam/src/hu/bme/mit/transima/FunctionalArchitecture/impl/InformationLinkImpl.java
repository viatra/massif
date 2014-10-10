/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.Component.SignalFlow;

import hu.bme.mit.transima.Component.impl.PlatformConnectedElementImpl;

import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalData;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalInput;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalOutput;
import hu.bme.mit.transima.FunctionalArchitecture.InformationLink;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.InformationLinkImpl#getFrom <em>From</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.InformationLinkImpl#getTo <em>To</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.InformationLinkImpl#getSignalFlow <em>Signal Flow</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.InformationLinkImpl#getPasses <em>Passes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InformationLinkImpl extends PlatformConnectedElementImpl implements InformationLink {
    /**
     * The cached value of the '{@link #getTo() <em>To</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
    protected FunctionalInput to;

    /**
     * The cached value of the '{@link #getSignalFlow() <em>Signal Flow</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSignalFlow()
     * @generated
     * @ordered
     */
    protected SignalFlow signalFlow;

    /**
     * The cached value of the '{@link #getPasses() <em>Passes</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPasses()
     * @generated
     * @ordered
     */
    protected EList<FunctionalData> passes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InformationLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FunctionalArchitectureModelPackage.Literals.INFORMATION_LINK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalOutput getFrom() {
        if (eContainerFeatureID() != FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM) return null;
        return (FunctionalOutput)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFrom(FunctionalOutput newFrom, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newFrom, FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFrom(FunctionalOutput newFrom) {
        if (newFrom != eInternalContainer() || (eContainerFeatureID() != FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM && newFrom != null)) {
            if (EcoreUtil.isAncestor(this, newFrom))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFrom != null)
                msgs = ((InternalEObject)newFrom).eInverseAdd(this, FunctionalArchitectureModelPackage.FUNCTIONAL_OUTPUT__OUTGOING_LINKS, FunctionalOutput.class, msgs);
            msgs = basicSetFrom(newFrom, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM, newFrom, newFrom));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalInput getTo() {
        if (to != null && to.eIsProxy()) {
            InternalEObject oldTo = (InternalEObject)to;
            to = (FunctionalInput)eResolveProxy(oldTo);
            if (to != oldTo) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionalArchitectureModelPackage.INFORMATION_LINK__TO, oldTo, to));
            }
        }
        return to;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalInput basicGetTo() {
        return to;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTo(FunctionalInput newTo, NotificationChain msgs) {
        FunctionalInput oldTo = to;
        to = newTo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.INFORMATION_LINK__TO, oldTo, newTo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTo(FunctionalInput newTo) {
        if (newTo != to) {
            NotificationChain msgs = null;
            if (to != null)
                msgs = ((InternalEObject)to).eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTIONAL_INPUT__INCOMING_LINKS, FunctionalInput.class, msgs);
            if (newTo != null)
                msgs = ((InternalEObject)newTo).eInverseAdd(this, FunctionalArchitectureModelPackage.FUNCTIONAL_INPUT__INCOMING_LINKS, FunctionalInput.class, msgs);
            msgs = basicSetTo(newTo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.INFORMATION_LINK__TO, newTo, newTo));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignalFlow getSignalFlow() {
        return signalFlow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSignalFlow(SignalFlow newSignalFlow, NotificationChain msgs) {
        SignalFlow oldSignalFlow = signalFlow;
        signalFlow = newSignalFlow;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW, oldSignalFlow, newSignalFlow);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSignalFlow(SignalFlow newSignalFlow) {
        if (newSignalFlow != signalFlow) {
            NotificationChain msgs = null;
            if (signalFlow != null)
                msgs = ((InternalEObject)signalFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW, null, msgs);
            if (newSignalFlow != null)
                msgs = ((InternalEObject)newSignalFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW, null, msgs);
            msgs = basicSetSignalFlow(newSignalFlow, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW, newSignalFlow, newSignalFlow));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FunctionalData> getPasses() {
        if (passes == null) {
            passes = new EObjectWithInverseResolvingEList.ManyInverse<FunctionalData>(FunctionalData.class, this, FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY);
        }
        return passes;
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
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetFrom((FunctionalOutput)otherEnd, msgs);
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__TO:
                if (to != null)
                    msgs = ((InternalEObject)to).eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTIONAL_INPUT__INCOMING_LINKS, FunctionalInput.class, msgs);
                return basicSetTo((FunctionalInput)otherEnd, msgs);
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPasses()).basicAdd(otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM:
                return basicSetFrom(null, msgs);
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__TO:
                return basicSetTo(null, msgs);
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW:
                return basicSetSignalFlow(null, msgs);
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES:
                return ((InternalEList<?>)getPasses()).basicRemove(otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM:
                return eInternalContainer().eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTIONAL_OUTPUT__OUTGOING_LINKS, FunctionalOutput.class, msgs);
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
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM:
                return getFrom();
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__TO:
                if (resolve) return getTo();
                return basicGetTo();
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW:
                return getSignalFlow();
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES:
                return getPasses();
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
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM:
                setFrom((FunctionalOutput)newValue);
                return;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__TO:
                setTo((FunctionalInput)newValue);
                return;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW:
                setSignalFlow((SignalFlow)newValue);
                return;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES:
                getPasses().clear();
                getPasses().addAll((Collection<? extends FunctionalData>)newValue);
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
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM:
                setFrom((FunctionalOutput)null);
                return;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__TO:
                setTo((FunctionalInput)null);
                return;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW:
                setSignalFlow((SignalFlow)null);
                return;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES:
                getPasses().clear();
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
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__FROM:
                return getFrom() != null;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__TO:
                return to != null;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__SIGNAL_FLOW:
                return signalFlow != null;
            case FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES:
                return passes != null && !passes.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //InformationLinkImpl
