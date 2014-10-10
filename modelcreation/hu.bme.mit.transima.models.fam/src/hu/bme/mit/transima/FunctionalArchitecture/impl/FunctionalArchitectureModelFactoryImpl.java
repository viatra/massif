/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.FunctionalArchitecture.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionalArchitectureModelFactoryImpl extends EFactoryImpl implements FunctionalArchitectureModelFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FunctionalArchitectureModelFactory init() {
        try {
            FunctionalArchitectureModelFactory theFunctionalArchitectureModelFactory = (FunctionalArchitectureModelFactory)EPackage.Registry.INSTANCE.getEFactory(FunctionalArchitectureModelPackage.eNS_URI);
            if (theFunctionalArchitectureModelFactory != null) {
                return theFunctionalArchitectureModelFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FunctionalArchitectureModelFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalArchitectureModelFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case FunctionalArchitectureModelPackage.FUNCTION: return createFunction();
            case FunctionalArchitectureModelPackage.INFORMATION_LINK: return createInformationLink();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_ARCHITECTURE_MODEL: return createFunctionalArchitectureModel();
            case FunctionalArchitectureModelPackage.FAM_SENSOR: return createFAMSensor();
            case FunctionalArchitectureModelPackage.FAM_ACTUATOR: return createFAMActuator();
            case FunctionalArchitectureModelPackage.FAM_TERMINATOR: return createFAMTerminator();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INTERFACE: return createFunctionalInterface();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_INPUT: return createFunctionalInput();
            case FunctionalArchitectureModelPackage.FUNCTIONAL_OUTPUT: return createFunctionalOutput();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case FunctionalArchitectureModelPackage.FUNCTION_TYPE:
                return createFunctionTypeFromString(eDataType, initialValue);
            case FunctionalArchitectureModelPackage.DESIGN_ASSURANCE_LEVEL:
                return createDesignAssuranceLevelFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case FunctionalArchitectureModelPackage.FUNCTION_TYPE:
                return convertFunctionTypeToString(eDataType, instanceValue);
            case FunctionalArchitectureModelPackage.DESIGN_ASSURANCE_LEVEL:
                return convertDesignAssuranceLevelToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Function createFunction() {
        FunctionImpl function = new FunctionImpl();
        return function;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InformationLink createInformationLink() {
        InformationLinkImpl informationLink = new InformationLinkImpl();
        return informationLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalArchitectureModel createFunctionalArchitectureModel() {
        FunctionalArchitectureModelImpl functionalArchitectureModel = new FunctionalArchitectureModelImpl();
        return functionalArchitectureModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FAMSensor createFAMSensor() {
        FAMSensorImpl famSensor = new FAMSensorImpl();
        return famSensor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FAMActuator createFAMActuator() {
        FAMActuatorImpl famActuator = new FAMActuatorImpl();
        return famActuator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FAMTerminator createFAMTerminator() {
        FAMTerminatorImpl famTerminator = new FAMTerminatorImpl();
        return famTerminator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalInterface createFunctionalInterface() {
        FunctionalInterfaceImpl functionalInterface = new FunctionalInterfaceImpl();
        return functionalInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalInput createFunctionalInput() {
        FunctionalInputImpl functionalInput = new FunctionalInputImpl();
        return functionalInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalOutput createFunctionalOutput() {
        FunctionalOutputImpl functionalOutput = new FunctionalOutputImpl();
        return functionalOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionType createFunctionTypeFromString(EDataType eDataType, String initialValue) {
        FunctionType result = FunctionType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertFunctionTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DesignAssuranceLevel createDesignAssuranceLevelFromString(EDataType eDataType, String initialValue) {
        DesignAssuranceLevel result = DesignAssuranceLevel.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDesignAssuranceLevelToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalArchitectureModelPackage getFunctionalArchitectureModelPackage() {
        return (FunctionalArchitectureModelPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static FunctionalArchitectureModelPackage getPackage() {
        return FunctionalArchitectureModelPackage.eINSTANCE;
    }

} //FunctionalArchitectureModelFactoryImpl
