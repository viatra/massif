/**
 */
package hu.bme.mit.transima.Simulink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the basic building block of Simulink systems. Each block has properties, ports and
 *  can refer to a source block that was used as the template from a library to create the element.
 * 
 * The properties are not a map, so the block may have multiple properties with the same name, or even same name-value pair.
 * 
 * The different type of ports are accessible through computed filtered lists.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getProperties <em>Properties</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getPorts <em>Ports</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getEnabler <em>Enabler</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getInports <em>Inports</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getOutports <em>Outports</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getParent <em>Parent</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getSourceBlock <em>Source Block</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Block#getSourceBlockRef <em>Source Block Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends SimulinkElement {
    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.transima.Simulink.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_Properties()
     * @model containment="true"
     * @generated
     */
    EList<Property> getProperties();

    /**
     * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.transima.Simulink.Port}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.Port#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ports</em>' containment reference list.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_Ports()
     * @see hu.bme.mit.transima.Simulink.Port#getContainer
     * @model opposite="container" containment="true"
     * @generated
     */
    EList<Port> getPorts();

    /**
     * Returns the value of the '<em><b>Trigger</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Trigger ports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Trigger</em>' reference.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_Trigger()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.simulink.derived.trigger'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.simulink.derived.trigger'"
     * @generated
     */
    Trigger getTrigger();

    /**
     * Returns the value of the '<em><b>Enabler</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Enable ports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Enabler</em>' reference.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_Enabler()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.simulink.derived.enabler'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.simulink.derived.enabler'"
     * @generated
     */
    Enable getEnabler();

    /**
     * Returns the value of the '<em><b>Inports</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.Simulink.InPort}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Inports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Inports</em>' reference list.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_Inports()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.simulink.derived.inports'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.simulink.derived.inports'"
     * @generated
     */
    EList<InPort> getInports();

    /**
     * Returns the value of the '<em><b>Outports</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.Simulink.OutPort}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The values are computed by filtering Outports from the values of the ports feature.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Outports</em>' reference list.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_Outports()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.simulink.derived.outports'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.simulink.derived.outports'"
     * @generated
     */
    EList<OutPort> getOutports();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.SubSystem#getSubBlocks <em>Sub Blocks</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(SubSystem)
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_Parent()
     * @see hu.bme.mit.transima.Simulink.SubSystem#getSubBlocks
     * @model opposite="subBlocks" transient="false"
     * @generated
     */
    SubSystem getParent();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Block#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(SubSystem value);

    /**
     * Returns the value of the '<em><b>Source Block</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value of the reference is computed by finding the element with the same name and qualifier as stored in the sourceBlockRef.
     * 
     * b{Validation}
     *  * WARN: Cannot find block specified by source block reference.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Source Block</em>' reference.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_SourceBlock()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.simulink.derived.sourceBlock'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.simulink.derived.sourceBlock'"
     * @generated
     */
    Block getSourceBlock();

    /**
     * Returns the value of the '<em><b>Source Block Ref</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Block Ref</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Block Ref</em>' containment reference.
     * @see #setSourceBlockRef(LibraryLinkReference)
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getBlock_SourceBlockRef()
     * @model containment="true"
     * @generated
     */
    LibraryLinkReference getSourceBlockRef();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Block#getSourceBlockRef <em>Source Block Ref</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Block Ref</em>' containment reference.
     * @see #getSourceBlockRef()
     * @generated
     */
    void setSourceBlockRef(LibraryLinkReference value);

} // Block
