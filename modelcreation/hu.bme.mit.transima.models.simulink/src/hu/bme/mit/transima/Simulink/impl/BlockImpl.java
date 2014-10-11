/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Enable;
import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.LibraryLinkReference;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.Simulink.Property;
import hu.bme.mit.transima.Simulink.SimulinkPackage;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.Simulink.SubSystem;
import hu.bme.mit.transima.Simulink.Trigger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.incquery.querybasedfeatures.runtime.IQueryBasedFeatureHandler;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureKind;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getEnabler <em>Enabler</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getInports <em>Inports</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getOutports <em>Outports</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getSourceBlock <em>Source Block</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.BlockImpl#getSourceBlockRef <em>Source Block Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockImpl extends SimulinkElementImpl implements Block {
    /**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
    protected EList<Property> properties;

    /**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
    protected EList<Port> ports;

    /**
	 * The cached setting delegate for the '{@link #getTrigger() <em>Trigger</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate TRIGGER__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.BLOCK__TRIGGER).getSettingDelegate();

				/**
	 * The cached setting delegate for the '{@link #getEnabler() <em>Enabler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabler()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ENABLER__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.BLOCK__ENABLER).getSettingDelegate();

				/**
	 * The cached setting delegate for the '{@link #getInports() <em>Inports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInports()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate INPORTS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.BLOCK__INPORTS).getSettingDelegate();

				/**
	 * The cached setting delegate for the '{@link #getOutports() <em>Outports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutports()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate OUTPORTS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.BLOCK__OUTPORTS).getSettingDelegate();

				/**
	 * The cached setting delegate for the '{@link #getSourceBlock() <em>Source Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceBlock()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate SOURCE_BLOCK__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.BLOCK__SOURCE_BLOCK).getSettingDelegate();

				/**
	 * The cached value of the '{@link #getSourceBlockRef() <em>Source Block Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSourceBlockRef()
	 * @generated
	 * @ordered
	 */
    protected LibraryLinkReference sourceBlockRef;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected BlockImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return SimulinkPackage.Literals.BLOCK;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, SimulinkPackage.BLOCK__PROPERTIES);
		}
		return properties;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Port> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<Port>(Port.class, this, SimulinkPackage.BLOCK__PORTS, SimulinkPackage.PORT__CONTAINER);
		}
		return ports;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Trigger getTrigger() {
		return (Trigger)TRIGGER__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Trigger basicGetTriggerGen() {
		return (Trigger)TRIGGER__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Enable getEnabler() {
		return (Enable)ENABLER__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Enable basicGetEnablerGen() {
		return (Enable)ENABLER__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<InPort> getInportsGen() {
		return (EList<InPort>)INPORTS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<OutPort> getOutportsGen() {
		return (EList<OutPort>)OUTPORTS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SubSystem getParent() {
		if (eContainerFeatureID() != SimulinkPackage.BLOCK__PARENT) return null;
		return (SubSystem)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetParent(SubSystem newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, SimulinkPackage.BLOCK__PARENT, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setParent(SubSystem newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != SimulinkPackage.BLOCK__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS, SubSystem.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BLOCK__PARENT, newParent, newParent));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Block getSourceBlock() {
		return (Block)SOURCE_BLOCK__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Block basicGetSourceBlockGen() {
		return (Block)SOURCE_BLOCK__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public LibraryLinkReference getSourceBlockRef() {
		return sourceBlockRef;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetSourceBlockRef(LibraryLinkReference newSourceBlockRef, NotificationChain msgs) {
		LibraryLinkReference oldSourceBlockRef = sourceBlockRef;
		sourceBlockRef = newSourceBlockRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.BLOCK__SOURCE_BLOCK_REF, oldSourceBlockRef, newSourceBlockRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSourceBlockRef(LibraryLinkReference newSourceBlockRef) {
		if (newSourceBlockRef != sourceBlockRef) {
			NotificationChain msgs = null;
			if (sourceBlockRef != null)
				msgs = ((InternalEObject)sourceBlockRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.BLOCK__SOURCE_BLOCK_REF, null, msgs);
			if (newSourceBlockRef != null)
				msgs = ((InternalEObject)newSourceBlockRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.BLOCK__SOURCE_BLOCK_REF, null, msgs);
			msgs = basicSetSourceBlockRef(newSourceBlockRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.BLOCK__SOURCE_BLOCK_REF, newSourceBlockRef, newSourceBlockRef));
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
			case SimulinkPackage.BLOCK__PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPorts()).basicAdd(otherEnd, msgs);
			case SimulinkPackage.BLOCK__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((SubSystem)otherEnd, msgs);
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
			case SimulinkPackage.BLOCK__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case SimulinkPackage.BLOCK__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
			case SimulinkPackage.BLOCK__PARENT:
				return basicSetParent(null, msgs);
			case SimulinkPackage.BLOCK__SOURCE_BLOCK_REF:
				return basicSetSourceBlockRef(null, msgs);
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
			case SimulinkPackage.BLOCK__PARENT:
				return eInternalContainer().eInverseRemove(this, SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS, SubSystem.class, msgs);
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
			case SimulinkPackage.BLOCK__PROPERTIES:
				return getProperties();
			case SimulinkPackage.BLOCK__PORTS:
				return getPorts();
			case SimulinkPackage.BLOCK__TRIGGER:
				if (resolve) return getTrigger();
				return basicGetTrigger();
			case SimulinkPackage.BLOCK__ENABLER:
				if (resolve) return getEnabler();
				return basicGetEnabler();
			case SimulinkPackage.BLOCK__INPORTS:
				return getInports();
			case SimulinkPackage.BLOCK__OUTPORTS:
				return getOutports();
			case SimulinkPackage.BLOCK__PARENT:
				return getParent();
			case SimulinkPackage.BLOCK__SOURCE_BLOCK:
				if (resolve) return getSourceBlock();
				return basicGetSourceBlock();
			case SimulinkPackage.BLOCK__SOURCE_BLOCK_REF:
				return getSourceBlockRef();
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
			case SimulinkPackage.BLOCK__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case SimulinkPackage.BLOCK__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case SimulinkPackage.BLOCK__PARENT:
				setParent((SubSystem)newValue);
				return;
			case SimulinkPackage.BLOCK__SOURCE_BLOCK_REF:
				setSourceBlockRef((LibraryLinkReference)newValue);
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
			case SimulinkPackage.BLOCK__PROPERTIES:
				getProperties().clear();
				return;
			case SimulinkPackage.BLOCK__PORTS:
				getPorts().clear();
				return;
			case SimulinkPackage.BLOCK__PARENT:
				setParent((SubSystem)null);
				return;
			case SimulinkPackage.BLOCK__SOURCE_BLOCK_REF:
				setSourceBlockRef((LibraryLinkReference)null);
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
			case SimulinkPackage.BLOCK__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case SimulinkPackage.BLOCK__PORTS:
				return ports != null && !ports.isEmpty();
			case SimulinkPackage.BLOCK__TRIGGER:
				return TRIGGER__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SimulinkPackage.BLOCK__ENABLER:
				return ENABLER__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SimulinkPackage.BLOCK__INPORTS:
				return INPORTS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SimulinkPackage.BLOCK__OUTPORTS:
				return OUTPORTS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SimulinkPackage.BLOCK__PARENT:
				return getParent() != null;
			case SimulinkPackage.BLOCK__SOURCE_BLOCK:
				return SOURCE_BLOCK__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SimulinkPackage.BLOCK__SOURCE_BLOCK_REF:
				return sourceBlockRef != null;
		}
		return super.eIsSet(featureID);
	}

    /**
     * EMF-IncQuery handler for query-based feature inports
     */
    private IQueryBasedFeatureHandler inportsHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature inports
     */
    public EList<InPort> getInports() {
        if (inportsHandler == null) {
            inportsHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                SimulinkPackageImpl.Literals.BLOCK__INPORTS, "hu.bme.mit.transima.models.simulink.derived.inports",
                "Block", "InPort", QueryBasedFeatureKind.MANY_REFERENCE, true, false);
        }
        return inportsHandler.getManyReferenceValueAsEList(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature outports
     */
    private IQueryBasedFeatureHandler outportsHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature outports
     */
    public EList<OutPort> getOutports() {
        if (outportsHandler == null) {
            outportsHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                SimulinkPackageImpl.Literals.BLOCK__OUTPORTS, "hu.bme.mit.transima.models.simulink.derived.outports",
                "Block", "OutPort", QueryBasedFeatureKind.MANY_REFERENCE, true, false);
        }
        return outportsHandler.getManyReferenceValueAsEList(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature trigger
     */
    private IQueryBasedFeatureHandler triggerHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature trigger
     */
    public Trigger basicGetTrigger() {
        if (triggerHandler == null) {
            triggerHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                SimulinkPackageImpl.Literals.BLOCK__TRIGGER, "hu.bme.mit.transima.models.simulink.derived.trigger",
                "Block", "Trigger", QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (hu.bme.mit.transima.Simulink.Trigger) triggerHandler.getSingleReferenceValue(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature enabler
     */
    private IQueryBasedFeatureHandler enablerHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature enabler
     */
    public Enable basicGetEnabler() {
        if (enablerHandler == null) {
            enablerHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                SimulinkPackageImpl.Literals.BLOCK__ENABLER, "hu.bme.mit.transima.models.simulink.derived.enabler",
                "Block", "Enabler", QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (hu.bme.mit.transima.Simulink.Enable) enablerHandler.getSingleReferenceValue(this);
    }

    /**
     * EMF-IncQuery handler for query-based feature sourceBlock
     */
    private IQueryBasedFeatureHandler sourceBlockHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature sourceBlock
     */
    public Block basicGetSourceBlock() {
        if (sourceBlockHandler == null) {
            sourceBlockHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                SimulinkPackageImpl.Literals.BLOCK__SOURCE_BLOCK,
                "hu.bme.mit.transima.models.simulink.derived.sourceBlock", "This", "Source",
                QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (hu.bme.mit.transima.Simulink.Block) sourceBlockHandler.getSingleReferenceValue(this);
    }

} //BlockImpl
