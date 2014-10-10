/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.IdentifierReference;
import hu.bme.mit.transima.Simulink.SimulinkElement;
import hu.bme.mit.transima.Simulink.SimulinkPackage;
import hu.bme.mit.transima.Simulink.SimulinkReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.incquery.querybasedfeatures.runtime.IQueryBasedFeatureHandler;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureKind;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.SimulinkElementImpl#getSimulinkRef <em>Simulink Ref</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.SimulinkElementImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SimulinkElementImpl extends EObjectImpl implements SimulinkElement {
    /**
     * The cached value of the '{@link #getSimulinkRef() <em>Simulink Ref</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulinkRef()
     * @generated
     * @ordered
     */
    protected IdentifierReference simulinkRef;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SimulinkElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimulinkPackage.Literals.SIMULINK_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IdentifierReference getSimulinkRef() {
        return simulinkRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSimulinkRef(IdentifierReference newSimulinkRef, NotificationChain msgs) {
        IdentifierReference oldSimulinkRef = simulinkRef;
        simulinkRef = newSimulinkRef;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, oldSimulinkRef, newSimulinkRef);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSimulinkRef(IdentifierReference newSimulinkRef) {
        if (newSimulinkRef != simulinkRef) {
            NotificationChain msgs = null;
            if (simulinkRef != null)
                msgs = ((InternalEObject)simulinkRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, null, msgs);
            if (newSimulinkRef != null)
                msgs = ((InternalEObject)newSimulinkRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, null, msgs);
            msgs = basicSetSimulinkRef(newSimulinkRef, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF, newSimulinkRef, newSimulinkRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getNameGen() {
        // TODO: implement this method to return the 'Name' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                return basicSetSimulinkRef(null, msgs);
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                return getSimulinkRef();
            case SimulinkPackage.SIMULINK_ELEMENT__NAME:
                return getName();
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                setSimulinkRef((IdentifierReference)newValue);
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                setSimulinkRef((IdentifierReference)null);
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
            case SimulinkPackage.SIMULINK_ELEMENT__SIMULINK_REF:
                return simulinkRef != null;
            case SimulinkPackage.SIMULINK_ELEMENT__NAME:
                return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
        }
        return super.eIsSet(featureID);
    }

    /**
     * EMF-IncQuery handler for query-based feature name
     */
    private IQueryBasedFeatureHandler nameHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature name
     */
    public String getName() {
        if (nameHandler == null) {
            nameHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                SimulinkPackageImpl.Literals.SIMULINK_ELEMENT__NAME,
                "hu.bme.mit.transima.models.simulink.derived.name", "SE", "Name",
                QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (java.lang.String) nameHandler.getSingleReferenceValue(this);
    }

} //SimulinkElementImpl
