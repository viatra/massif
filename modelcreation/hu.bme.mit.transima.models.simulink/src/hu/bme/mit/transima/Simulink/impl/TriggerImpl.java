/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.EnableStates;
import hu.bme.mit.transima.Simulink.SimulinkPackage;
import hu.bme.mit.transima.Simulink.Trigger;
import hu.bme.mit.transima.Simulink.TriggerType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.TriggerImpl#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.TriggerImpl#getStatesWhenEnabling <em>States When Enabling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TriggerImpl extends InPortImpl implements Trigger {
    /**
	 * The default value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTriggerType()
	 * @generated
	 * @ordered
	 */
    protected static final TriggerType TRIGGER_TYPE_EDEFAULT = TriggerType.RISING;

    /**
	 * The cached value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTriggerType()
	 * @generated
	 * @ordered
	 */
    protected TriggerType triggerType = TRIGGER_TYPE_EDEFAULT;

    /**
	 * The default value of the '{@link #getStatesWhenEnabling() <em>States When Enabling</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getStatesWhenEnabling()
	 * @generated
	 * @ordered
	 */
    protected static final EnableStates STATES_WHEN_ENABLING_EDEFAULT = EnableStates.HELD;

    /**
	 * The cached value of the '{@link #getStatesWhenEnabling() <em>States When Enabling</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getStatesWhenEnabling()
	 * @generated
	 * @ordered
	 */
    protected EnableStates statesWhenEnabling = STATES_WHEN_ENABLING_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TriggerImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return SimulinkPackage.Literals.TRIGGER;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TriggerType getTriggerType() {
		return triggerType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTriggerType(TriggerType newTriggerType) {
		TriggerType oldTriggerType = triggerType;
		triggerType = newTriggerType == null ? TRIGGER_TYPE_EDEFAULT : newTriggerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.TRIGGER__TRIGGER_TYPE, oldTriggerType, triggerType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EnableStates getStatesWhenEnabling() {
		return statesWhenEnabling;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setStatesWhenEnabling(EnableStates newStatesWhenEnabling) {
		EnableStates oldStatesWhenEnabling = statesWhenEnabling;
		statesWhenEnabling = newStatesWhenEnabling == null ? STATES_WHEN_ENABLING_EDEFAULT : newStatesWhenEnabling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.TRIGGER__STATES_WHEN_ENABLING, oldStatesWhenEnabling, statesWhenEnabling));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.TRIGGER__TRIGGER_TYPE:
				return getTriggerType();
			case SimulinkPackage.TRIGGER__STATES_WHEN_ENABLING:
				return getStatesWhenEnabling();
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
			case SimulinkPackage.TRIGGER__TRIGGER_TYPE:
				setTriggerType((TriggerType)newValue);
				return;
			case SimulinkPackage.TRIGGER__STATES_WHEN_ENABLING:
				setStatesWhenEnabling((EnableStates)newValue);
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
			case SimulinkPackage.TRIGGER__TRIGGER_TYPE:
				setTriggerType(TRIGGER_TYPE_EDEFAULT);
				return;
			case SimulinkPackage.TRIGGER__STATES_WHEN_ENABLING:
				setStatesWhenEnabling(STATES_WHEN_ENABLING_EDEFAULT);
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
			case SimulinkPackage.TRIGGER__TRIGGER_TYPE:
				return triggerType != TRIGGER_TYPE_EDEFAULT;
			case SimulinkPackage.TRIGGER__STATES_WHEN_ENABLING:
				return statesWhenEnabling != STATES_WHEN_ENABLING_EDEFAULT;
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
		result.append(" (triggerType: ");
		result.append(triggerType);
		result.append(", statesWhenEnabling: ");
		result.append(statesWhenEnabling);
		result.append(')');
		return result.toString();
	}

} //TriggerImpl
