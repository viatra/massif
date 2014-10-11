/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.SimulinkPackage;
import hu.bme.mit.transima.Simulink.SubSystem;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.SubSystemImpl#getSubBlocks <em>Sub Blocks</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.SubSystemImpl#getTag <em>Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemImpl extends BlockImpl implements SubSystem {
    /**
	 * The cached value of the '{@link #getSubBlocks() <em>Sub Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSubBlocks()
	 * @generated
	 * @ordered
	 */
    protected EList<Block> subBlocks;

    /**
	 * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
    protected static final String TAG_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
    protected String tag = TAG_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SubSystemImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return SimulinkPackage.Literals.SUB_SYSTEM;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Block> getSubBlocks() {
		if (subBlocks == null) {
			subBlocks = new EObjectContainmentWithInverseEList<Block>(Block.class, this, SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS, SimulinkPackage.BLOCK__PARENT);
		}
		return subBlocks;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getTag() {
		return tag;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTag(String newTag) {
		String oldTag = tag;
		tag = newTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.SUB_SYSTEM__TAG, oldTag, tag));
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
			case SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubBlocks()).basicAdd(otherEnd, msgs);
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
			case SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS:
				return ((InternalEList<?>)getSubBlocks()).basicRemove(otherEnd, msgs);
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
			case SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS:
				return getSubBlocks();
			case SimulinkPackage.SUB_SYSTEM__TAG:
				return getTag();
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
			case SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS:
				getSubBlocks().clear();
				getSubBlocks().addAll((Collection<? extends Block>)newValue);
				return;
			case SimulinkPackage.SUB_SYSTEM__TAG:
				setTag((String)newValue);
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
			case SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS:
				getSubBlocks().clear();
				return;
			case SimulinkPackage.SUB_SYSTEM__TAG:
				setTag(TAG_EDEFAULT);
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
			case SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS:
				return subBlocks != null && !subBlocks.isEmpty();
			case SimulinkPackage.SUB_SYSTEM__TAG:
				return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
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
		result.append(" (tag: ");
		result.append(tag);
		result.append(')');
		return result.toString();
	}

} //SubSystemImpl
