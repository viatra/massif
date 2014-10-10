/**
 */
package hu.bme.mit.transima.FunctionalArchitecture.impl;

import hu.bme.mit.transima.Component.ComponentPackage;

import hu.bme.mit.transima.FunctionalArchitecture.DesignAssuranceLevel;
import hu.bme.mit.transima.FunctionalArchitecture.FAMActuator;
import hu.bme.mit.transima.FunctionalArchitecture.FAMSensor;
import hu.bme.mit.transima.FunctionalArchitecture.FAMTerminator;
import hu.bme.mit.transima.FunctionalArchitecture.Function;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionType;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModel;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelFactory;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalData;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalInput;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface;
import hu.bme.mit.transima.FunctionalArchitecture.FunctionalOutput;
import hu.bme.mit.transima.FunctionalArchitecture.InformationLink;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionalArchitectureModelPackageImpl extends EPackageImpl implements FunctionalArchitectureModelPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionalElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass informationLinkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionalArchitectureModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass famSensorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass famActuatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass famTerminatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionalInterfaceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionalInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionalOutputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionalDataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum functionTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum designAssuranceLevelEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private FunctionalArchitectureModelPackageImpl() {
        super(eNS_URI, FunctionalArchitectureModelFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link FunctionalArchitectureModelPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static FunctionalArchitectureModelPackage init() {
        if (isInited) return (FunctionalArchitectureModelPackage)EPackage.Registry.INSTANCE.getEPackage(FunctionalArchitectureModelPackage.eNS_URI);

        // Obtain or create and register package
        FunctionalArchitectureModelPackageImpl theFunctionalArchitectureModelPackage = (FunctionalArchitectureModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FunctionalArchitectureModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FunctionalArchitectureModelPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ComponentPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theFunctionalArchitectureModelPackage.createPackageContents();

        // Initialize created meta-data
        theFunctionalArchitectureModelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFunctionalArchitectureModelPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(FunctionalArchitectureModelPackage.eNS_URI, theFunctionalArchitectureModelPackage);
        return theFunctionalArchitectureModelPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunction() {
        return functionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFunction_Type() {
        return (EAttribute)functionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFunction_DesignAssuranceLevel() {
        return (EAttribute)functionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFunction_MinimumDesignFrequency() {
        return (EAttribute)functionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunction_SubElements() {
        return (EReference)functionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFunction_Requirements() {
        return (EAttribute)functionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunctionalElement() {
        return functionalElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalElement_Model() {
        return (EReference)functionalElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalElement_Parent() {
        return (EReference)functionalElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalElement_Interface() {
        return (EReference)functionalElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalElement_OutgoingLinks() {
        return (EReference)functionalElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalElement_IncomingLinks() {
        return (EReference)functionalElementEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalElement_Connects() {
        return (EReference)functionalElementEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInformationLink() {
        return informationLinkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInformationLink_From() {
        return (EReference)informationLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInformationLink_To() {
        return (EReference)informationLinkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInformationLink_SignalFlow() {
        return (EReference)informationLinkEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInformationLink_Passes() {
        return (EReference)informationLinkEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunctionalArchitectureModel() {
        return functionalArchitectureModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalArchitectureModel_RootElements() {
        return (EReference)functionalArchitectureModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFAMSensor() {
        return famSensorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFAMActuator() {
        return famActuatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFAMTerminator() {
        return famTerminatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFAMTerminator_Data() {
        return (EReference)famTerminatorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunctionalInterface() {
        return functionalInterfaceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalInterface_Inputs() {
        return (EReference)functionalInterfaceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalInterface_Data() {
        return (EReference)functionalInterfaceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalInterface_Element() {
        return (EReference)functionalInterfaceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalInterface_Outputs() {
        return (EReference)functionalInterfaceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunctionalInput() {
        return functionalInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalInput_IncomingLinks() {
        return (EReference)functionalInputEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunctionalOutput() {
        return functionalOutputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalOutput_OutgoingLinks() {
        return (EReference)functionalOutputEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunctionalData() {
        return functionalDataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFunctionalData_DataType() {
        return (EAttribute)functionalDataEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalData_Interface() {
        return (EReference)functionalDataEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalData_Terminator() {
        return (EReference)functionalDataEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFunctionalData_SampleTime() {
        return (EAttribute)functionalDataEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionalData_PassedBy() {
        return (EReference)functionalDataEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getFunctionType() {
        return functionTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getDesignAssuranceLevel() {
        return designAssuranceLevelEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionalArchitectureModelFactory getFunctionalArchitectureModelFactory() {
        return (FunctionalArchitectureModelFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        functionEClass = createEClass(FUNCTION);
        createEAttribute(functionEClass, FUNCTION__TYPE);
        createEAttribute(functionEClass, FUNCTION__DESIGN_ASSURANCE_LEVEL);
        createEAttribute(functionEClass, FUNCTION__MINIMUM_DESIGN_FREQUENCY);
        createEReference(functionEClass, FUNCTION__SUB_ELEMENTS);
        createEAttribute(functionEClass, FUNCTION__REQUIREMENTS);

        functionalElementEClass = createEClass(FUNCTIONAL_ELEMENT);
        createEReference(functionalElementEClass, FUNCTIONAL_ELEMENT__MODEL);
        createEReference(functionalElementEClass, FUNCTIONAL_ELEMENT__PARENT);
        createEReference(functionalElementEClass, FUNCTIONAL_ELEMENT__INTERFACE);
        createEReference(functionalElementEClass, FUNCTIONAL_ELEMENT__OUTGOING_LINKS);
        createEReference(functionalElementEClass, FUNCTIONAL_ELEMENT__INCOMING_LINKS);
        createEReference(functionalElementEClass, FUNCTIONAL_ELEMENT__CONNECTS);

        informationLinkEClass = createEClass(INFORMATION_LINK);
        createEReference(informationLinkEClass, INFORMATION_LINK__FROM);
        createEReference(informationLinkEClass, INFORMATION_LINK__TO);
        createEReference(informationLinkEClass, INFORMATION_LINK__SIGNAL_FLOW);
        createEReference(informationLinkEClass, INFORMATION_LINK__PASSES);

        functionalArchitectureModelEClass = createEClass(FUNCTIONAL_ARCHITECTURE_MODEL);
        createEReference(functionalArchitectureModelEClass, FUNCTIONAL_ARCHITECTURE_MODEL__ROOT_ELEMENTS);

        famSensorEClass = createEClass(FAM_SENSOR);

        famActuatorEClass = createEClass(FAM_ACTUATOR);

        famTerminatorEClass = createEClass(FAM_TERMINATOR);
        createEReference(famTerminatorEClass, FAM_TERMINATOR__DATA);

        functionalInterfaceEClass = createEClass(FUNCTIONAL_INTERFACE);
        createEReference(functionalInterfaceEClass, FUNCTIONAL_INTERFACE__INPUTS);
        createEReference(functionalInterfaceEClass, FUNCTIONAL_INTERFACE__DATA);
        createEReference(functionalInterfaceEClass, FUNCTIONAL_INTERFACE__ELEMENT);
        createEReference(functionalInterfaceEClass, FUNCTIONAL_INTERFACE__OUTPUTS);

        functionalInputEClass = createEClass(FUNCTIONAL_INPUT);
        createEReference(functionalInputEClass, FUNCTIONAL_INPUT__INCOMING_LINKS);

        functionalOutputEClass = createEClass(FUNCTIONAL_OUTPUT);
        createEReference(functionalOutputEClass, FUNCTIONAL_OUTPUT__OUTGOING_LINKS);

        functionalDataEClass = createEClass(FUNCTIONAL_DATA);
        createEAttribute(functionalDataEClass, FUNCTIONAL_DATA__DATA_TYPE);
        createEReference(functionalDataEClass, FUNCTIONAL_DATA__INTERFACE);
        createEReference(functionalDataEClass, FUNCTIONAL_DATA__TERMINATOR);
        createEAttribute(functionalDataEClass, FUNCTIONAL_DATA__SAMPLE_TIME);
        createEReference(functionalDataEClass, FUNCTIONAL_DATA__PASSED_BY);

        // Create enums
        functionTypeEEnum = createEEnum(FUNCTION_TYPE);
        designAssuranceLevelEEnum = createEEnum(DESIGN_ASSURANCE_LEVEL);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ComponentPackage theComponentPackage = (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage(ComponentPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        functionEClass.getESuperTypes().add(this.getFunctionalElement());
        functionalElementEClass.getESuperTypes().add(theComponentPackage.getPlatformConnectedElement());
        informationLinkEClass.getESuperTypes().add(theComponentPackage.getPlatformConnectedElement());
        functionalArchitectureModelEClass.getESuperTypes().add(theComponentPackage.getPlatformConnectedElement());
        famSensorEClass.getESuperTypes().add(this.getFunctionalElement());
        famActuatorEClass.getESuperTypes().add(this.getFunctionalElement());
        famTerminatorEClass.getESuperTypes().add(theComponentPackage.getPlatformConnectedElement());
        functionalInterfaceEClass.getESuperTypes().add(theComponentPackage.getPlatformConnectedElement());
        functionalInputEClass.getESuperTypes().add(this.getFunctionalData());
        functionalOutputEClass.getESuperTypes().add(this.getFunctionalData());
        functionalDataEClass.getESuperTypes().add(theComponentPackage.getPlatformConnectedElement());

        // Initialize classes and features; add operations and parameters
        initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFunction_Type(), this.getFunctionType(), "type", null, 1, 1, Function.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getFunction_DesignAssuranceLevel(), this.getDesignAssuranceLevel(), "designAssuranceLevel", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFunction_MinimumDesignFrequency(), ecorePackage.getEFloat(), "minimumDesignFrequency", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunction_SubElements(), this.getFunctionalElement(), this.getFunctionalElement_Parent(), "subElements", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFunction_Requirements(), ecorePackage.getEString(), "requirements", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(functionalElementEClass, FunctionalElement.class, "FunctionalElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionalElement_Model(), this.getFunctionalArchitectureModel(), null, "model", null, 1, 1, FunctionalElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalElement_Parent(), this.getFunction(), this.getFunction_SubElements(), "parent", null, 0, 1, FunctionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalElement_Interface(), this.getFunctionalInterface(), this.getFunctionalInterface_Element(), "interface", null, 0, 1, FunctionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalElement_OutgoingLinks(), this.getInformationLink(), null, "outgoingLinks", null, 0, -1, FunctionalElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalElement_IncomingLinks(), this.getInformationLink(), null, "incomingLinks", null, 0, -1, FunctionalElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalElement_Connects(), this.getFunctionalElement(), null, "connects", null, 0, -1, FunctionalElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(informationLinkEClass, InformationLink.class, "InformationLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInformationLink_From(), this.getFunctionalOutput(), this.getFunctionalOutput_OutgoingLinks(), "from", null, 0, 1, InformationLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInformationLink_To(), this.getFunctionalInput(), this.getFunctionalInput_IncomingLinks(), "to", null, 0, 1, InformationLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInformationLink_SignalFlow(), theComponentPackage.getSignalFlow(), null, "signalFlow", null, 0, 1, InformationLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInformationLink_Passes(), this.getFunctionalData(), this.getFunctionalData_PassedBy(), "passes", null, 0, -1, InformationLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(functionalArchitectureModelEClass, FunctionalArchitectureModel.class, "FunctionalArchitectureModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionalArchitectureModel_RootElements(), this.getFunctionalElement(), null, "rootElements", null, 0, -1, FunctionalArchitectureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(famSensorEClass, FAMSensor.class, "FAMSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(famActuatorEClass, FAMActuator.class, "FAMActuator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(famTerminatorEClass, FAMTerminator.class, "FAMTerminator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFAMTerminator_Data(), this.getFunctionalData(), this.getFunctionalData_Terminator(), "data", null, 0, 1, FAMTerminator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(functionalInterfaceEClass, FunctionalInterface.class, "FunctionalInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionalInterface_Inputs(), this.getFunctionalInput(), null, "inputs", null, 0, -1, FunctionalInterface.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalInterface_Data(), this.getFunctionalData(), this.getFunctionalData_Interface(), "data", null, 0, -1, FunctionalInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalInterface_Element(), this.getFunctionalElement(), this.getFunctionalElement_Interface(), "element", null, 0, 1, FunctionalInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalInterface_Outputs(), this.getFunctionalOutput(), null, "outputs", null, 0, -1, FunctionalInterface.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(functionalInputEClass, FunctionalInput.class, "FunctionalInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionalInput_IncomingLinks(), this.getInformationLink(), this.getInformationLink_To(), "incomingLinks", null, 0, -1, FunctionalInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(functionalOutputEClass, FunctionalOutput.class, "FunctionalOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionalOutput_OutgoingLinks(), this.getInformationLink(), this.getInformationLink_From(), "outgoingLinks", null, 0, -1, FunctionalOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(functionalDataEClass, FunctionalData.class, "FunctionalData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFunctionalData_DataType(), ecorePackage.getEString(), "dataType", null, 0, 1, FunctionalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalData_Interface(), this.getFunctionalInterface(), this.getFunctionalInterface_Data(), "interface", null, 0, 1, FunctionalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalData_Terminator(), this.getFAMTerminator(), this.getFAMTerminator_Data(), "terminator", null, 0, 1, FunctionalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFunctionalData_SampleTime(), ecorePackage.getEString(), "sampleTime", null, 0, 1, FunctionalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionalData_PassedBy(), this.getInformationLink(), this.getInformationLink_Passes(), "passedBy", null, 0, -1, FunctionalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(functionTypeEEnum, FunctionType.class, "FunctionType");
        addEEnumLiteral(functionTypeEEnum, FunctionType.ROOT);
        addEEnumLiteral(functionTypeEEnum, FunctionType.INTERMEDIATE);
        addEEnumLiteral(functionTypeEEnum, FunctionType.LEAF);

        initEEnum(designAssuranceLevelEEnum, DesignAssuranceLevel.class, "DesignAssuranceLevel");
        addEEnumLiteral(designAssuranceLevelEEnum, DesignAssuranceLevel.A);
        addEEnumLiteral(designAssuranceLevelEEnum, DesignAssuranceLevel.B);
        addEEnumLiteral(designAssuranceLevelEEnum, DesignAssuranceLevel.C);
        addEEnumLiteral(designAssuranceLevelEEnum, DesignAssuranceLevel.D);
        addEEnumLiteral(designAssuranceLevelEEnum, DesignAssuranceLevel.E);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // org.eclipse.viatra2.emf.incquery.derived.feature
        createOrgAnnotations();
        // org.eclipse.incquery.querybasedfeature
        createOrg_1Annotations();
    }

    /**
     * Initializes the annotations for <b>org.eclipse.viatra2.emf.incquery.derived.feature</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createOrgAnnotations() {
        String source = "org.eclipse.viatra2.emf.incquery.derived.feature";					
        addAnnotation
          (getFunction_Type(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.type"
           });						
        addAnnotation
          (getFunctionalElement_Model(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.model"
           });				
        addAnnotation
          (getFunctionalElement_OutgoingLinks(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.outgoingLinks"
           });				
        addAnnotation
          (getFunctionalElement_IncomingLinks(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.incomingLinks"
           });				
        addAnnotation
          (getFunctionalElement_Connects(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.connects"
           });											
        addAnnotation
          (getFunctionalInterface_Inputs(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.inputs"
           });				
        addAnnotation
          (getFunctionalInterface_Outputs(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.outputs"
           });							
    }

    /**
     * Initializes the annotations for <b>org.eclipse.incquery.querybasedfeature</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createOrg_1Annotations() {
        String source = "org.eclipse.incquery.querybasedfeature";						
        addAnnotation
          (getFunction_Type(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.type"
           });						
        addAnnotation
          (getFunctionalElement_Model(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.model"
           });				
        addAnnotation
          (getFunctionalElement_OutgoingLinks(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.outgoingLinks"
           });				
        addAnnotation
          (getFunctionalElement_IncomingLinks(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.incomingLinks"
           });				
        addAnnotation
          (getFunctionalElement_Connects(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.connects"
           });											
        addAnnotation
          (getFunctionalInterface_Inputs(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.inputs"
           });				
        addAnnotation
          (getFunctionalInterface_Outputs(), 
           source, 
           new String[] {
             "patternFQN", "hu.bme.mit.transima.models.fam.derived.outputs"
           });						
    }

} //FunctionalArchitectureModelPackageImpl
