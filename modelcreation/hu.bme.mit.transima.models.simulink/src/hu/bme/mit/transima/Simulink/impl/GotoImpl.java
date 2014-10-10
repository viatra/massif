/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.From;
import hu.bme.mit.transima.Simulink.Goto;
import hu.bme.mit.transima.Simulink.SimulinkPackage;
import hu.bme.mit.transima.Simulink.TagVisibility;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goto</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.GotoImpl#getFromBlocks <em>From Blocks</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.GotoImpl#getTagVisibility <em>Tag Visibility</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.GotoImpl#getGotoTag <em>Goto Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GotoImpl extends VirtualBlockImpl implements Goto {
    /**
     * The cached value of the '{@link #getFromBlocks() <em>From Blocks</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFromBlocks()
     * @generated
     * @ordered
     */
    protected EList<From> fromBlocks;

    /**
     * The default value of the '{@link #getTagVisibility() <em>Tag Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTagVisibility()
     * @generated
     * @ordered
     */
    protected static final TagVisibility TAG_VISIBILITY_EDEFAULT = TagVisibility.LOCAL;

    /**
     * The cached value of the '{@link #getTagVisibility() <em>Tag Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTagVisibility()
     * @generated
     * @ordered
     */
    protected TagVisibility tagVisibility = TAG_VISIBILITY_EDEFAULT;

    /**
     * The default value of the '{@link #getGotoTag() <em>Goto Tag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGotoTag()
     * @generated
     * @ordered
     */
    protected static final String GOTO_TAG_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getGotoTag() <em>Goto Tag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGotoTag()
     * @generated
     * @ordered
     */
    protected String gotoTag = GOTO_TAG_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GotoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimulinkPackage.Literals.GOTO;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<From> getFromBlocks() {
        if (fromBlocks == null) {
            fromBlocks = new EObjectWithInverseResolvingEList<From>(From.class, this, SimulinkPackage.GOTO__FROM_BLOCKS, SimulinkPackage.FROM__GOTO_BLOCK);
        }
        return fromBlocks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TagVisibility getTagVisibility() {
        return tagVisibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTagVisibility(TagVisibility newTagVisibility) {
        TagVisibility oldTagVisibility = tagVisibility;
        tagVisibility = newTagVisibility == null ? TAG_VISIBILITY_EDEFAULT : newTagVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.GOTO__TAG_VISIBILITY, oldTagVisibility, tagVisibility));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getGotoTag() {
        return gotoTag;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGotoTag(String newGotoTag) {
        String oldGotoTag = gotoTag;
        gotoTag = newGotoTag;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.GOTO__GOTO_TAG, oldGotoTag, gotoTag));
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
            case SimulinkPackage.GOTO__FROM_BLOCKS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFromBlocks()).basicAdd(otherEnd, msgs);
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
            case SimulinkPackage.GOTO__FROM_BLOCKS:
                return ((InternalEList<?>)getFromBlocks()).basicRemove(otherEnd, msgs);
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
            case SimulinkPackage.GOTO__FROM_BLOCKS:
                return getFromBlocks();
            case SimulinkPackage.GOTO__TAG_VISIBILITY:
                return getTagVisibility();
            case SimulinkPackage.GOTO__GOTO_TAG:
                return getGotoTag();
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
            case SimulinkPackage.GOTO__FROM_BLOCKS:
                getFromBlocks().clear();
                getFromBlocks().addAll((Collection<? extends From>)newValue);
                return;
            case SimulinkPackage.GOTO__TAG_VISIBILITY:
                setTagVisibility((TagVisibility)newValue);
                return;
            case SimulinkPackage.GOTO__GOTO_TAG:
                setGotoTag((String)newValue);
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
            case SimulinkPackage.GOTO__FROM_BLOCKS:
                getFromBlocks().clear();
                return;
            case SimulinkPackage.GOTO__TAG_VISIBILITY:
                setTagVisibility(TAG_VISIBILITY_EDEFAULT);
                return;
            case SimulinkPackage.GOTO__GOTO_TAG:
                setGotoTag(GOTO_TAG_EDEFAULT);
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
            case SimulinkPackage.GOTO__FROM_BLOCKS:
                return fromBlocks != null && !fromBlocks.isEmpty();
            case SimulinkPackage.GOTO__TAG_VISIBILITY:
                return tagVisibility != TAG_VISIBILITY_EDEFAULT;
            case SimulinkPackage.GOTO__GOTO_TAG:
                return GOTO_TAG_EDEFAULT == null ? gotoTag != null : !GOTO_TAG_EDEFAULT.equals(gotoTag);
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
        result.append(" (tagVisibility: ");
        result.append(tagVisibility);
        result.append(", gotoTag: ");
        result.append(gotoTag);
        result.append(')');
        return result.toString();
    }

} //GotoImpl
