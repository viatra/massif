/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.Component.impl.PlatformConnectedElementImpl;

import hu.bme.mit.transima.FunctionalArchitecture.FAMTerminator;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalData;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface;

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
 * An implementation of the model object '<em><b>Functional Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalDataImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalDataImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalDataImpl#getTerminator <em>Terminator</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalDataImpl#getSampleTime <em>Sample Time</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionalDataImpl#getPassedBy <em>Passed By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FunctionalDataImpl extends PlatformConnectedElementImpl implements FunctionalData {
    /**
     * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataType()
     * @generated
     * @ordered
     */
    protected static final String DATA_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataType()
     * @generated
     * @ordered
     */
    protected String dataType = DATA_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getTerminator() <em>Terminator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTerminator()
     * @generated
     * @ordered
     */
    protected FAMTerminator terminator;

    /**
     * The default value of the '{@link #getSampleTime() <em>Sample Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSampleTime()
     * @generated
     * @ordered
     */
    protected static final String SAMPLE_TIME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSampleTime() <em>Sample Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSampleTime()
     * @generated
     * @ordered
     */
    protected String sampleTime = SAMPLE_TIME_EDEFAULT;

    /**
     * The cached value of the '{@link #getPassedBy() <em>Passed By</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassedBy()
     * @generated
     * @ordered
     */
    protected EList<InformationLink> passedBy;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FunctionalDataImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FunctionalArchitectureModelPackage.Literals.FUNCTIONAL_DATA;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataType(String newDataType) {
        String oldDataType = dataType;
        dataType = newDataType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__DATA_TYPE, oldDataType, dataType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalInterface getInterface() {
        if (eContainerFeatureID() != FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE) return null;
        return (FunctionalInterface)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInterface(FunctionalInterface newInterface, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInterface, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInterface(FunctionalInterface newInterface) {
        if (newInterface != eInternalContainer() || (eContainerFeatureID() != FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE && newInterface != null)) {
            if (EcoreUtil.isAncestor(this, newInterface))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInterface != null)
                msgs = ((InternalEObject)newInterface).eInverseAdd(this, FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA, FunctionalInterface.class, msgs);
            msgs = basicSetInterface(newInterface, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE, newInterface, newInterface));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FAMTerminator getTerminator() {
        return terminator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTerminator(FAMTerminator newTerminator, NotificationChain msgs) {
        FAMTerminator oldTerminator = terminator;
        terminator = newTerminator;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR, oldTerminator, newTerminator);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTerminator(FAMTerminator newTerminator) {
        if (newTerminator != terminator) {
            NotificationChain msgs = null;
            if (terminator != null)
                msgs = ((InternalEObject)terminator).eInverseRemove(this, FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA, FAMTerminator.class, msgs);
            if (newTerminator != null)
                msgs = ((InternalEObject)newTerminator).eInverseAdd(this, FunctionalArchitectureModelPackage.FAM_TERMINATOR__DATA, FAMTerminator.class, msgs);
            msgs = basicSetTerminator(newTerminator, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR, newTerminator, newTerminator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSampleTime() {
        return sampleTime;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSampleTime(String newSampleTime) {
        String oldSampleTime = sampleTime;
        sampleTime = newSampleTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__SAMPLE_TIME, oldSampleTime, sampleTime));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InformationLink> getPassedBy() {
        if (passedBy == null) {
            passedBy = new EObjectWithInverseResolvingEList.ManyInverse<InformationLink>(InformationLink.class, this, FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY, FunctionalArchitectureModelPackage.INFORMATION_LINK__PASSES);
        }
        return passedBy;
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInterface((FunctionalInterface)otherEnd, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR:
                if (terminator != null)
                    msgs = ((InternalEObject)terminator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR, null, msgs);
                return basicSetTerminator((FAMTerminator)otherEnd, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPassedBy()).basicAdd(otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE:
                return basicSetInterface(null, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR:
                return basicSetTerminator(null, msgs);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY:
                return ((InternalEList<?>)getPassedBy()).basicRemove(otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE:
                return eInternalContainer().eInverseRemove(this, FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE__DATA, FunctionalInterface.class, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__DATA_TYPE:
                return getDataType();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE:
                return getInterface();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR:
                return getTerminator();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__SAMPLE_TIME:
                return getSampleTime();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY:
                return getPassedBy();
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__DATA_TYPE:
                setDataType((String)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE:
                setInterface((FunctionalInterface)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR:
                setTerminator((FAMTerminator)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__SAMPLE_TIME:
                setSampleTime((String)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY:
                getPassedBy().clear();
                getPassedBy().addAll((Collection<? extends InformationLink>)newValue);
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__DATA_TYPE:
                setDataType(DATA_TYPE_EDEFAULT);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE:
                setInterface((FunctionalInterface)null);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR:
                setTerminator((FAMTerminator)null);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__SAMPLE_TIME:
                setSampleTime(SAMPLE_TIME_EDEFAULT);
                return;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY:
                getPassedBy().clear();
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
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__DATA_TYPE:
                return DATA_TYPE_EDEFAULT == null ? dataType != null : !DATA_TYPE_EDEFAULT.equals(dataType);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__INTERFACE:
                return getInterface() != null;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__TERMINATOR:
                return terminator != null;
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__SAMPLE_TIME:
                return SAMPLE_TIME_EDEFAULT == null ? sampleTime != null : !SAMPLE_TIME_EDEFAULT.equals(sampleTime);
            case FunctionalArchitectureModelPackage.FUNCTIONAL_DATA__PASSED_BY:
                return passedBy != null && !passedBy.isEmpty();
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
        result.append(" (dataType: ");
        result.append(dataType);
        result.append(", sampleTime: ");
        result.append(sampleTime);
        result.append(')');
        return result.toString();
    }

} //FunctionalDataImpl
