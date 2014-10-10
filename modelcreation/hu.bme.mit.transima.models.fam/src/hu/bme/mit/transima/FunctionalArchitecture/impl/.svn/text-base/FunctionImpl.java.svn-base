/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.FunctionalArchitecture.DesignAssuranceLevel;
import hu.bme.mit.transima.FunctionalArchitecture.Function;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionType;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.incquery.querybasedfeatures.runtime.IQueryBasedFeatureHandler;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureKind;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionImpl#getType <em>Type</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionImpl#getDesignAssuranceLevel <em>Design Assurance Level</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionImpl#getMinimumDesignFrequency <em>Minimum Design Frequency</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionImpl#getSubElements <em>Sub Elements</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.impl.FunctionImpl#getRequirements <em>Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends FunctionalElementImpl implements Function {
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final FunctionType TYPE_EDEFAULT = FunctionType.ROOT;

    /**
     * The default value of the '{@link #getDesignAssuranceLevel() <em>Design Assurance Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDesignAssuranceLevel()
     * @generated
     * @ordered
     */
    protected static final DesignAssuranceLevel DESIGN_ASSURANCE_LEVEL_EDEFAULT = DesignAssuranceLevel.A;

    /**
     * The cached value of the '{@link #getDesignAssuranceLevel() <em>Design Assurance Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDesignAssuranceLevel()
     * @generated
     * @ordered
     */
    protected DesignAssuranceLevel designAssuranceLevel = DESIGN_ASSURANCE_LEVEL_EDEFAULT;

    /**
     * The default value of the '{@link #getMinimumDesignFrequency() <em>Minimum Design Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinimumDesignFrequency()
     * @generated
     * @ordered
     */
    protected static final float MINIMUM_DESIGN_FREQUENCY_EDEFAULT = 0.0F;

    /**
     * The cached value of the '{@link #getMinimumDesignFrequency() <em>Minimum Design Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinimumDesignFrequency()
     * @generated
     * @ordered
     */
    protected float minimumDesignFrequency = MINIMUM_DESIGN_FREQUENCY_EDEFAULT;

    /**
     * The cached value of the '{@link #getSubElements() <em>Sub Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubElements()
     * @generated
     * @ordered
     */
    protected EList<FunctionalElement> subElements;

    /**
     * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequirements()
     * @generated
     * @ordered
     */
    protected EList<String> requirements;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FunctionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FunctionalArchitectureModelPackage.Literals.FUNCTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionType getTypeGen() {
        // TODO: implement this method to return the 'Type' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DesignAssuranceLevel getDesignAssuranceLevel() {
        return designAssuranceLevel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDesignAssuranceLevel(DesignAssuranceLevel newDesignAssuranceLevel) {
        DesignAssuranceLevel oldDesignAssuranceLevel = designAssuranceLevel;
        designAssuranceLevel = newDesignAssuranceLevel == null ? DESIGN_ASSURANCE_LEVEL_EDEFAULT : newDesignAssuranceLevel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTION__DESIGN_ASSURANCE_LEVEL, oldDesignAssuranceLevel, designAssuranceLevel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getMinimumDesignFrequency() {
        return minimumDesignFrequency;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMinimumDesignFrequency(float newMinimumDesignFrequency) {
        float oldMinimumDesignFrequency = minimumDesignFrequency;
        minimumDesignFrequency = newMinimumDesignFrequency;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FunctionalArchitectureModelPackage.FUNCTION__MINIMUM_DESIGN_FREQUENCY, oldMinimumDesignFrequency, minimumDesignFrequency));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FunctionalElement> getSubElements() {
        if (subElements == null) {
            subElements = new EObjectContainmentWithInverseEList<FunctionalElement>(FunctionalElement.class, this, FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS, FunctionalArchitectureModelPackage.FUNCTIONAL_ELEMENT__PARENT);
        }
        return subElements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getRequirements() {
        if (requirements == null) {
            requirements = new EDataTypeUniqueEList<String>(String.class, this, FunctionalArchitectureModelPackage.FUNCTION__REQUIREMENTS);
        }
        return requirements;
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
            case FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubElements()).basicAdd(otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS:
                return ((InternalEList<?>)getSubElements()).basicRemove(otherEnd, msgs);
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
            case FunctionalArchitectureModelPackage.FUNCTION__TYPE:
                return getType();
            case FunctionalArchitectureModelPackage.FUNCTION__DESIGN_ASSURANCE_LEVEL:
                return getDesignAssuranceLevel();
            case FunctionalArchitectureModelPackage.FUNCTION__MINIMUM_DESIGN_FREQUENCY:
                return getMinimumDesignFrequency();
            case FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS:
                return getSubElements();
            case FunctionalArchitectureModelPackage.FUNCTION__REQUIREMENTS:
                return getRequirements();
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
            case FunctionalArchitectureModelPackage.FUNCTION__DESIGN_ASSURANCE_LEVEL:
                setDesignAssuranceLevel((DesignAssuranceLevel)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTION__MINIMUM_DESIGN_FREQUENCY:
                setMinimumDesignFrequency((Float)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS:
                getSubElements().clear();
                getSubElements().addAll((Collection<? extends FunctionalElement>)newValue);
                return;
            case FunctionalArchitectureModelPackage.FUNCTION__REQUIREMENTS:
                getRequirements().clear();
                getRequirements().addAll((Collection<? extends String>)newValue);
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
            case FunctionalArchitectureModelPackage.FUNCTION__DESIGN_ASSURANCE_LEVEL:
                setDesignAssuranceLevel(DESIGN_ASSURANCE_LEVEL_EDEFAULT);
                return;
            case FunctionalArchitectureModelPackage.FUNCTION__MINIMUM_DESIGN_FREQUENCY:
                setMinimumDesignFrequency(MINIMUM_DESIGN_FREQUENCY_EDEFAULT);
                return;
            case FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS:
                getSubElements().clear();
                return;
            case FunctionalArchitectureModelPackage.FUNCTION__REQUIREMENTS:
                getRequirements().clear();
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
            case FunctionalArchitectureModelPackage.FUNCTION__TYPE:
                return getType() != TYPE_EDEFAULT;
            case FunctionalArchitectureModelPackage.FUNCTION__DESIGN_ASSURANCE_LEVEL:
                return designAssuranceLevel != DESIGN_ASSURANCE_LEVEL_EDEFAULT;
            case FunctionalArchitectureModelPackage.FUNCTION__MINIMUM_DESIGN_FREQUENCY:
                return minimumDesignFrequency != MINIMUM_DESIGN_FREQUENCY_EDEFAULT;
            case FunctionalArchitectureModelPackage.FUNCTION__SUB_ELEMENTS:
                return subElements != null && !subElements.isEmpty();
            case FunctionalArchitectureModelPackage.FUNCTION__REQUIREMENTS:
                return requirements != null && !requirements.isEmpty();
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
        result.append(" (designAssuranceLevel: ");
        result.append(designAssuranceLevel);
        result.append(", minimumDesignFrequency: ");
        result.append(minimumDesignFrequency);
        result.append(", requirements: ");
        result.append(requirements);
        result.append(')');
        return result.toString();
    }

    /**
     * EMF-IncQuery handler for query-based feature type
     */
    private IQueryBasedFeatureHandler typeHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature type
     */
    public FunctionType getType() {
        if (typeHandler == null) {
            typeHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                FunctionalArchitectureModelPackageImpl.Literals.FUNCTION__TYPE,
                "hu.bme.mit.transima.models.fam.derived.type", "This", "Target",
                QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (hu.bme.mit.transima.FunctionalArchitecture.FunctionType) typeHandler.getSingleReferenceValue(this);
    }

} //FunctionImpl
