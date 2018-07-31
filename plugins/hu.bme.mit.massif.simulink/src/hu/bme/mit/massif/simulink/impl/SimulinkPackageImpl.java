/**
 */
package hu.bme.mit.massif.simulink.impl;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusCreator;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.BusSpecification;
import hu.bme.mit.massif.simulink.Connection;
import hu.bme.mit.massif.simulink.Enable;
import hu.bme.mit.massif.simulink.EnableBlock;
import hu.bme.mit.massif.simulink.EnableStates;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.IdentifierReference;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.LibraryLinkReference;
import hu.bme.mit.massif.simulink.ModelReference;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.ParameterSource;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SimulinkPackage;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.TagVisibility;
import hu.bme.mit.massif.simulink.Trigger;
import hu.bme.mit.massif.simulink.TriggerBlock;
import hu.bme.mit.massif.simulink.TriggerType;
import hu.bme.mit.massif.simulink.VirtualBlock;

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
public class SimulinkPackageImpl extends EPackageImpl implements SimulinkPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simulinkElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass blockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass portEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inPortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass outPortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass busSelectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass busCreatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass gotoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass virtualBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fromEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simulinkModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass multiConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass singleConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass portBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass outPortBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inPortBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enableBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simulinkReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass gotoTagVisibilityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass subSystemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modelReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass busSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass busSignalMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass libraryLinkReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass identifierReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum enableStatesEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum triggerTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum tagVisibilityEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum parameterSourceEEnum = null;

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
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SimulinkPackageImpl() {
        super(eNS_URI, SimulinkFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link SimulinkPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SimulinkPackage init() {
        if (isInited) return (SimulinkPackage)EPackage.Registry.INSTANCE.getEPackage(SimulinkPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredSimulinkPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        SimulinkPackageImpl theSimulinkPackage = registeredSimulinkPackage instanceof SimulinkPackageImpl ? (SimulinkPackageImpl)registeredSimulinkPackage : new SimulinkPackageImpl();

        isInited = true;

        // Create package meta-data objects
        theSimulinkPackage.createPackageContents();

        // Initialize created meta-data
        theSimulinkPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSimulinkPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SimulinkPackage.eNS_URI, theSimulinkPackage);
        return theSimulinkPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimulinkElement() {
        return simulinkElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimulinkElement_SimulinkRef() {
        return (EReference)simulinkElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimulinkElement_Name() {
        return (EAttribute)simulinkElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBlock() {
        return blockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Parameters() {
        return (EReference)blockEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Ports() {
        return (EReference)blockEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Trigger() {
        return (EReference)blockEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Enabler() {
        return (EReference)blockEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Inports() {
        return (EReference)blockEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Outports() {
        return (EReference)blockEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Parent() {
        return (EReference)blockEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_SourceBlock() {
        return (EReference)blockEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_SourceBlockRef() {
        return (EReference)blockEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPort() {
        return portEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPort_Container() {
        return (EReference)portEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPort_PortBlock() {
        return (EReference)portEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParameter() {
        return parameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParameter_Name() {
        return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParameter_Type() {
        return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParameter_Value() {
        return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParameter_Source() {
        return (EAttribute)parameterEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInPort() {
        return inPortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInPort_Connection() {
        return (EReference)inPortEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOutPort() {
        return outPortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOutPort_Connection() {
        return (EReference)outPortEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnection() {
        return connectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnection_From() {
        return (EReference)connectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnection_LineName() {
        return (EAttribute)connectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTrigger() {
        return triggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTrigger_TriggerType() {
        return (EAttribute)triggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTrigger_StatesWhenEnabling() {
        return (EAttribute)triggerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEnable() {
        return enableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEnable_StatesWhenEnabling() {
        return (EAttribute)enableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBusSelector() {
        return busSelectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBusSelector_Mappings() {
        return (EReference)busSelectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBusSelector_OutputAsBus() {
        return (EAttribute)busSelectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBusSelector_BusCreator() {
        return (EReference)busSelectorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBusCreator() {
        return busCreatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGoto() {
        return gotoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGoto_FromBlocks() {
        return (EReference)gotoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGoto_TagVisibility() {
        return (EAttribute)gotoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGoto_GotoTag() {
        return (EAttribute)gotoEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVirtualBlock() {
        return virtualBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFrom() {
        return fromEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFrom_GotoBlock() {
        return (EReference)fromEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimulinkModel() {
        return simulinkModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimulinkModel_Version() {
        return (EAttribute)simulinkModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimulinkModel_Contains() {
        return (EReference)simulinkModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimulinkModel_File() {
        return (EAttribute)simulinkModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimulinkModel_Library() {
        return (EAttribute)simulinkModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMultiConnection() {
        return multiConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultiConnection_Connections() {
        return (EReference)multiConnectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSingleConnection() {
        return singleConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSingleConnection_Parent() {
        return (EReference)singleConnectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSingleConnection_To() {
        return (EReference)singleConnectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPortBlock() {
        return portBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPortBlock_Port() {
        return (EReference)portBlockEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOutPortBlock() {
        return outPortBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInPortBlock() {
        return inPortBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTriggerBlock() {
        return triggerBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEnableBlock() {
        return enableBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimulinkReference() {
        return simulinkReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimulinkReference_Element() {
        return (EReference)simulinkReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimulinkReference_Name() {
        return (EAttribute)simulinkReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimulinkReference_Qualifier() {
        return (EAttribute)simulinkReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGotoTagVisibility() {
        return gotoTagVisibilityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGotoTagVisibility_GotoBlock() {
        return (EReference)gotoTagVisibilityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubSystem() {
        return subSystemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubSystem_SubBlocks() {
        return (EReference)subSystemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSubSystem_Tag() {
        return (EAttribute)subSystemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModelReference() {
        return modelReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModelReference_ReferencedModel() {
        return (EReference)modelReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModelReference_ModelRef() {
        return (EReference)modelReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBusSpecification() {
        return busSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBusSignalMapping() {
        return busSignalMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBusSignalMapping_Selector() {
        return (EReference)busSignalMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBusSignalMapping_MappingFrom() {
        return (EReference)busSignalMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBusSignalMapping_MappingTo() {
        return (EReference)busSignalMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBusSignalMapping_MappingPath() {
        return (EAttribute)busSignalMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBusSignalMapping_Incomplete() {
        return (EAttribute)busSignalMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLibraryLinkReference() {
        return libraryLinkReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLibraryLinkReference_Disabled() {
        return (EAttribute)libraryLinkReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIdentifierReference() {
        return identifierReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getEnableStates() {
        return enableStatesEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getTriggerType() {
        return triggerTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getTagVisibility() {
        return tagVisibilityEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getParameterSource() {
        return parameterSourceEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimulinkFactory getSimulinkFactory() {
        return (SimulinkFactory)getEFactoryInstance();
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
        simulinkElementEClass = createEClass(SIMULINK_ELEMENT);
        createEReference(simulinkElementEClass, SIMULINK_ELEMENT__SIMULINK_REF);
        createEAttribute(simulinkElementEClass, SIMULINK_ELEMENT__NAME);

        blockEClass = createEClass(BLOCK);
        createEReference(blockEClass, BLOCK__PARAMETERS);
        createEReference(blockEClass, BLOCK__PORTS);
        createEReference(blockEClass, BLOCK__TRIGGER);
        createEReference(blockEClass, BLOCK__ENABLER);
        createEReference(blockEClass, BLOCK__INPORTS);
        createEReference(blockEClass, BLOCK__OUTPORTS);
        createEReference(blockEClass, BLOCK__PARENT);
        createEReference(blockEClass, BLOCK__SOURCE_BLOCK);
        createEReference(blockEClass, BLOCK__SOURCE_BLOCK_REF);

        portEClass = createEClass(PORT);
        createEReference(portEClass, PORT__CONTAINER);
        createEReference(portEClass, PORT__PORT_BLOCK);

        parameterEClass = createEClass(PARAMETER);
        createEAttribute(parameterEClass, PARAMETER__NAME);
        createEAttribute(parameterEClass, PARAMETER__TYPE);
        createEAttribute(parameterEClass, PARAMETER__VALUE);
        createEAttribute(parameterEClass, PARAMETER__SOURCE);

        inPortEClass = createEClass(IN_PORT);
        createEReference(inPortEClass, IN_PORT__CONNECTION);

        outPortEClass = createEClass(OUT_PORT);
        createEReference(outPortEClass, OUT_PORT__CONNECTION);

        connectionEClass = createEClass(CONNECTION);
        createEReference(connectionEClass, CONNECTION__FROM);
        createEAttribute(connectionEClass, CONNECTION__LINE_NAME);

        triggerEClass = createEClass(TRIGGER);
        createEAttribute(triggerEClass, TRIGGER__TRIGGER_TYPE);
        createEAttribute(triggerEClass, TRIGGER__STATES_WHEN_ENABLING);

        enableEClass = createEClass(ENABLE);
        createEAttribute(enableEClass, ENABLE__STATES_WHEN_ENABLING);

        busSelectorEClass = createEClass(BUS_SELECTOR);
        createEReference(busSelectorEClass, BUS_SELECTOR__MAPPINGS);
        createEAttribute(busSelectorEClass, BUS_SELECTOR__OUTPUT_AS_BUS);
        createEReference(busSelectorEClass, BUS_SELECTOR__BUS_CREATOR);

        busCreatorEClass = createEClass(BUS_CREATOR);

        gotoEClass = createEClass(GOTO);
        createEReference(gotoEClass, GOTO__FROM_BLOCKS);
        createEAttribute(gotoEClass, GOTO__TAG_VISIBILITY);
        createEAttribute(gotoEClass, GOTO__GOTO_TAG);

        virtualBlockEClass = createEClass(VIRTUAL_BLOCK);

        fromEClass = createEClass(FROM);
        createEReference(fromEClass, FROM__GOTO_BLOCK);

        simulinkModelEClass = createEClass(SIMULINK_MODEL);
        createEAttribute(simulinkModelEClass, SIMULINK_MODEL__VERSION);
        createEReference(simulinkModelEClass, SIMULINK_MODEL__CONTAINS);
        createEAttribute(simulinkModelEClass, SIMULINK_MODEL__FILE);
        createEAttribute(simulinkModelEClass, SIMULINK_MODEL__LIBRARY);

        multiConnectionEClass = createEClass(MULTI_CONNECTION);
        createEReference(multiConnectionEClass, MULTI_CONNECTION__CONNECTIONS);

        singleConnectionEClass = createEClass(SINGLE_CONNECTION);
        createEReference(singleConnectionEClass, SINGLE_CONNECTION__PARENT);
        createEReference(singleConnectionEClass, SINGLE_CONNECTION__TO);

        portBlockEClass = createEClass(PORT_BLOCK);
        createEReference(portBlockEClass, PORT_BLOCK__PORT);

        outPortBlockEClass = createEClass(OUT_PORT_BLOCK);

        inPortBlockEClass = createEClass(IN_PORT_BLOCK);

        triggerBlockEClass = createEClass(TRIGGER_BLOCK);

        enableBlockEClass = createEClass(ENABLE_BLOCK);

        simulinkReferenceEClass = createEClass(SIMULINK_REFERENCE);
        createEReference(simulinkReferenceEClass, SIMULINK_REFERENCE__ELEMENT);
        createEAttribute(simulinkReferenceEClass, SIMULINK_REFERENCE__NAME);
        createEAttribute(simulinkReferenceEClass, SIMULINK_REFERENCE__QUALIFIER);

        gotoTagVisibilityEClass = createEClass(GOTO_TAG_VISIBILITY);
        createEReference(gotoTagVisibilityEClass, GOTO_TAG_VISIBILITY__GOTO_BLOCK);

        subSystemEClass = createEClass(SUB_SYSTEM);
        createEReference(subSystemEClass, SUB_SYSTEM__SUB_BLOCKS);
        createEAttribute(subSystemEClass, SUB_SYSTEM__TAG);

        modelReferenceEClass = createEClass(MODEL_REFERENCE);
        createEReference(modelReferenceEClass, MODEL_REFERENCE__REFERENCED_MODEL);
        createEReference(modelReferenceEClass, MODEL_REFERENCE__MODEL_REF);

        busSpecificationEClass = createEClass(BUS_SPECIFICATION);

        busSignalMappingEClass = createEClass(BUS_SIGNAL_MAPPING);
        createEReference(busSignalMappingEClass, BUS_SIGNAL_MAPPING__SELECTOR);
        createEReference(busSignalMappingEClass, BUS_SIGNAL_MAPPING__MAPPING_FROM);
        createEReference(busSignalMappingEClass, BUS_SIGNAL_MAPPING__MAPPING_TO);
        createEAttribute(busSignalMappingEClass, BUS_SIGNAL_MAPPING__MAPPING_PATH);
        createEAttribute(busSignalMappingEClass, BUS_SIGNAL_MAPPING__INCOMPLETE);

        libraryLinkReferenceEClass = createEClass(LIBRARY_LINK_REFERENCE);
        createEAttribute(libraryLinkReferenceEClass, LIBRARY_LINK_REFERENCE__DISABLED);

        identifierReferenceEClass = createEClass(IDENTIFIER_REFERENCE);

        // Create enums
        enableStatesEEnum = createEEnum(ENABLE_STATES);
        triggerTypeEEnum = createEEnum(TRIGGER_TYPE);
        tagVisibilityEEnum = createEEnum(TAG_VISIBILITY);
        parameterSourceEEnum = createEEnum(PARAMETER_SOURCE);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        blockEClass.getESuperTypes().add(this.getSimulinkElement());
        portEClass.getESuperTypes().add(this.getSimulinkElement());
        inPortEClass.getESuperTypes().add(this.getPort());
        outPortEClass.getESuperTypes().add(this.getPort());
        connectionEClass.getESuperTypes().add(this.getSimulinkElement());
        triggerEClass.getESuperTypes().add(this.getInPort());
        enableEClass.getESuperTypes().add(this.getInPort());
        busSelectorEClass.getESuperTypes().add(this.getBusSpecification());
        busCreatorEClass.getESuperTypes().add(this.getBusSpecification());
        gotoEClass.getESuperTypes().add(this.getVirtualBlock());
        virtualBlockEClass.getESuperTypes().add(this.getBlock());
        fromEClass.getESuperTypes().add(this.getVirtualBlock());
        simulinkModelEClass.getESuperTypes().add(this.getSimulinkElement());
        multiConnectionEClass.getESuperTypes().add(this.getConnection());
        singleConnectionEClass.getESuperTypes().add(this.getConnection());
        portBlockEClass.getESuperTypes().add(this.getVirtualBlock());
        outPortBlockEClass.getESuperTypes().add(this.getPortBlock());
        inPortBlockEClass.getESuperTypes().add(this.getPortBlock());
        triggerBlockEClass.getESuperTypes().add(this.getInPortBlock());
        enableBlockEClass.getESuperTypes().add(this.getInPortBlock());
        gotoTagVisibilityEClass.getESuperTypes().add(this.getVirtualBlock());
        subSystemEClass.getESuperTypes().add(this.getBlock());
        modelReferenceEClass.getESuperTypes().add(this.getBlock());
        busSpecificationEClass.getESuperTypes().add(this.getBlock());
        libraryLinkReferenceEClass.getESuperTypes().add(this.getSimulinkReference());
        identifierReferenceEClass.getESuperTypes().add(this.getSimulinkReference());

        // Initialize classes and features; add operations and parameters
        initEClass(simulinkElementEClass, SimulinkElement.class, "SimulinkElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSimulinkElement_SimulinkRef(), this.getIdentifierReference(), null, "simulinkRef", null, 0, 1, SimulinkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimulinkElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimulinkElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBlock_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Ports(), this.getPort(), this.getPort_Container(), "ports", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Trigger(), this.getTrigger(), null, "trigger", null, 0, 1, Block.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Enabler(), this.getEnable(), null, "enabler", null, 0, 1, Block.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Inports(), this.getInPort(), null, "inports", null, 0, -1, Block.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Outports(), this.getOutPort(), null, "outports", null, 0, -1, Block.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Parent(), this.getSubSystem(), this.getSubSystem_SubBlocks(), "parent", null, 0, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_SourceBlock(), this.getBlock(), null, "sourceBlock", null, 0, 1, Block.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_SourceBlockRef(), this.getLibraryLinkReference(), null, "sourceBlockRef", null, 0, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPort_Container(), this.getBlock(), this.getBlock_Ports(), "container", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPort_PortBlock(), this.getPortBlock(), this.getPortBlock_Port(), "portBlock", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParameter_Type(), ecorePackage.getEString(), "type", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParameter_Source(), this.getParameterSource(), "source", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(inPortEClass, InPort.class, "InPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInPort_Connection(), this.getSingleConnection(), this.getSingleConnection_To(), "connection", null, 0, 1, InPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(outPortEClass, OutPort.class, "OutPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOutPort_Connection(), this.getConnection(), this.getConnection_From(), "connection", null, 0, 1, OutPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(connectionEClass, Connection.class, "Connection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConnection_From(), this.getOutPort(), this.getOutPort_Connection(), "from", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConnection_LineName(), ecorePackage.getEString(), "lineName", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTrigger_TriggerType(), this.getTriggerType(), "triggerType", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTrigger_StatesWhenEnabling(), this.getEnableStates(), "statesWhenEnabling", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enableEClass, Enable.class, "Enable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEnable_StatesWhenEnabling(), this.getEnableStates(), "statesWhenEnabling", null, 0, 1, Enable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(busSelectorEClass, BusSelector.class, "BusSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBusSelector_Mappings(), this.getBusSignalMapping(), this.getBusSignalMapping_Selector(), "mappings", null, 0, -1, BusSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getBusSelector_OutputAsBus(), ecorePackage.getEBoolean(), "outputAsBus", null, 0, 1, BusSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBusSelector_BusCreator(), this.getBusSpecification(), null, "busCreator", null, 0, 1, BusSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(busCreatorEClass, BusCreator.class, "BusCreator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(gotoEClass, Goto.class, "Goto", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getGoto_FromBlocks(), this.getFrom(), this.getFrom_GotoBlock(), "fromBlocks", null, 0, -1, Goto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGoto_TagVisibility(), this.getTagVisibility(), "tagVisibility", null, 0, 1, Goto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGoto_GotoTag(), ecorePackage.getEString(), "gotoTag", null, 0, 1, Goto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(virtualBlockEClass, VirtualBlock.class, "VirtualBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(fromEClass, From.class, "From", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFrom_GotoBlock(), this.getGoto(), this.getGoto_FromBlocks(), "gotoBlock", null, 0, 1, From.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(simulinkModelEClass, SimulinkModel.class, "SimulinkModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSimulinkModel_Version(), ecorePackage.getEString(), "version", null, 1, 1, SimulinkModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSimulinkModel_Contains(), this.getBlock(), null, "contains", null, 0, -1, SimulinkModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimulinkModel_File(), ecorePackage.getEString(), "file", null, 0, 1, SimulinkModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimulinkModel_Library(), ecorePackage.getEBoolean(), "library", null, 0, 1, SimulinkModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(multiConnectionEClass, MultiConnection.class, "MultiConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMultiConnection_Connections(), this.getSingleConnection(), this.getSingleConnection_Parent(), "connections", null, 0, -1, MultiConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(singleConnectionEClass, SingleConnection.class, "SingleConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSingleConnection_Parent(), this.getMultiConnection(), this.getMultiConnection_Connections(), "parent", null, 0, 1, SingleConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSingleConnection_To(), this.getInPort(), this.getInPort_Connection(), "to", null, 0, 1, SingleConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(portBlockEClass, PortBlock.class, "PortBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPortBlock_Port(), this.getPort(), this.getPort_PortBlock(), "port", null, 0, 1, PortBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(outPortBlockEClass, OutPortBlock.class, "OutPortBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(inPortBlockEClass, InPortBlock.class, "InPortBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(triggerBlockEClass, TriggerBlock.class, "TriggerBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(enableBlockEClass, EnableBlock.class, "EnableBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(simulinkReferenceEClass, SimulinkReference.class, "SimulinkReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSimulinkReference_Element(), this.getSimulinkElement(), null, "element", null, 0, 1, SimulinkReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimulinkReference_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimulinkReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimulinkReference_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, 1, SimulinkReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(simulinkReferenceEClass, ecorePackage.getEString(), "getFQN", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(gotoTagVisibilityEClass, GotoTagVisibility.class, "GotoTagVisibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getGotoTagVisibility_GotoBlock(), this.getGoto(), null, "gotoBlock", null, 0, 1, GotoTagVisibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(subSystemEClass, SubSystem.class, "SubSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSubSystem_SubBlocks(), this.getBlock(), this.getBlock_Parent(), "subBlocks", null, 0, -1, SubSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSubSystem_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, SubSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(modelReferenceEClass, ModelReference.class, "ModelReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getModelReference_ReferencedModel(), this.getSimulinkModel(), null, "referencedModel", null, 0, 1, ModelReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getModelReference_ModelRef(), this.getIdentifierReference(), null, "modelRef", null, 0, 1, ModelReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(busSpecificationEClass, BusSpecification.class, "BusSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(busSignalMappingEClass, BusSignalMapping.class, "BusSignalMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBusSignalMapping_Selector(), this.getBusSelector(), this.getBusSelector_Mappings(), "selector", null, 0, 1, BusSignalMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBusSignalMapping_MappingFrom(), this.getOutPort(), null, "mappingFrom", null, 0, 1, BusSignalMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBusSignalMapping_MappingTo(), this.getOutPort(), null, "mappingTo", null, 0, 1, BusSignalMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getBusSignalMapping_MappingPath(), ecorePackage.getEString(), "mappingPath", null, 0, 1, BusSignalMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getBusSignalMapping_Incomplete(), ecorePackage.getEBoolean(), "incomplete", null, 0, 1, BusSignalMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(libraryLinkReferenceEClass, LibraryLinkReference.class, "LibraryLinkReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLibraryLinkReference_Disabled(), ecorePackage.getEBoolean(), "disabled", null, 0, 1, LibraryLinkReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(identifierReferenceEClass, IdentifierReference.class, "IdentifierReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(enableStatesEEnum, EnableStates.class, "EnableStates");
        addEEnumLiteral(enableStatesEEnum, EnableStates.HELD);
        addEEnumLiteral(enableStatesEEnum, EnableStates.RESET);
        addEEnumLiteral(enableStatesEEnum, EnableStates.INHERIT);

        initEEnum(triggerTypeEEnum, TriggerType.class, "TriggerType");
        addEEnumLiteral(triggerTypeEEnum, TriggerType.RISING);
        addEEnumLiteral(triggerTypeEEnum, TriggerType.FALLING);
        addEEnumLiteral(triggerTypeEEnum, TriggerType.EITHER);
        addEEnumLiteral(triggerTypeEEnum, TriggerType.FUNCTION_CALL);

        initEEnum(tagVisibilityEEnum, TagVisibility.class, "TagVisibility");
        addEEnumLiteral(tagVisibilityEEnum, TagVisibility.LOCAL);
        addEEnumLiteral(tagVisibilityEEnum, TagVisibility.SCOPED);
        addEEnumLiteral(tagVisibilityEEnum, TagVisibility.GLOBAL);

        initEEnum(parameterSourceEEnum, ParameterSource.class, "ParameterSource");
        addEEnumLiteral(parameterSourceEEnum, ParameterSource.MASK);
        addEEnumLiteral(parameterSourceEEnum, ParameterSource.DIALOG);
        addEEnumLiteral(parameterSourceEEnum, ParameterSource.INTERNAL);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // org.eclipse.viatra.query.querybasedfeature
        createOrgAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";
        addAnnotation
          (this,
           source,
           new String[] {
               "settingDelegates", "org.eclipse.viatra.query.querybasedfeature"
           });
    }

    /**
     * Initializes the annotations for <b>org.eclipse.viatra.query.querybasedfeature</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createOrgAnnotations() {
        String source = "org.eclipse.viatra.query.querybasedfeature";
        addAnnotation
          (getSimulinkElement_Name(),
           source,
           new String[] {
               "patternFQN", "hu.bme.mit.massif.models.simulink.derived.name"
           });
        addAnnotation
          (getBlock_Trigger(),
           source,
           new String[] {
               "patternFQN", "hu.bme.mit.massif.models.simulink.derived.trigger"
           });
        addAnnotation
          (getBlock_Enabler(),
           source,
           new String[] {
               "patternFQN", "hu.bme.mit.massif.models.simulink.derived.enabler"
           });
        addAnnotation
          (getBlock_Inports(),
           source,
           new String[] {
               "patternFQN", "hu.bme.mit.massif.models.simulink.derived.inports"
           });
        addAnnotation
          (getBlock_Outports(),
           source,
           new String[] {
               "patternFQN", "hu.bme.mit.massif.models.simulink.derived.outports"
           });
        addAnnotation
          (getBlock_SourceBlock(),
           source,
           new String[] {
               "patternFQN", "hu.bme.mit.massif.models.simulink.derived.sourceBlock"
           });
        addAnnotation
          (getModelReference_ReferencedModel(),
           source,
           new String[] {
               "patternFQN", "hu.bme.mit.massif.models.simulink.derived.referencedModel"
           });
    }

} //SimulinkPackageImpl
