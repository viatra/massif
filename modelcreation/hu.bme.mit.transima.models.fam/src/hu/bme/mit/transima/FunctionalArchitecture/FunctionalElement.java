/**
 */
package hu.bme.mit.transima.FunctionalArchitecture;

import hu.bme.mit.transima.Component.PlatformConnectedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the abstract supertype of communicating elements that make up the function trees of a {fam.FunctionalArchitectureModel}.
 * Element are either top-level entries in the model or a subelement of {fam.Function} elements.
 * 
 * The communication between elements are created by defining an #{fam.InformationLink} between a #{fam.FunctionalOutput}
 * on the #{fam.FunctionalInterface} of the source element and a #{fam.FunctionalInput} on the interface of the target element.
 *  
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getModel <em>Model</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getParent <em>Parent</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getInterface <em>Interface</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getConnects <em>Connects</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalElement()
 * @model abstract="true"
 * @generated
 */
public interface FunctionalElement extends PlatformConnectedElement {
    /**
     * Returns the value of the '<em><b>Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed by transitively navigating backwards on containment references until the model root is reached.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Model</em>' reference.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalElement_Model()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.fam.derived.model'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.fam.derived.model'"
     * @generated
     */
    FunctionalArchitectureModel getModel();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getSubElements <em>Sub Elements</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(Function)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalElement_Parent()
     * @see hu.bme.mit.transima.FunctionalArchitecture.Function#getSubElements
     * @model opposite="subElements" transient="false"
     * @generated
     */
    Function getParent();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(Function value);

    /**
     * Returns the value of the '<em><b>Interface</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' containment reference.
     * @see #setInterface(FunctionalInterface)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalElement_Interface()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getElement
     * @model opposite="element" containment="true"
     * @generated
     */
    FunctionalInterface getInterface();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getInterface <em>Interface</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' containment reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(FunctionalInterface value);

    /**
     * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed by gathering outgoing information links on all outputs in the interface of the element.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Outgoing Links</em>' reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalElement_OutgoingLinks()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.fam.derived.outgoingLinks'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.fam.derived.outgoingLinks'"
     * @generated
     */
    EList<InformationLink> getOutgoingLinks();

    /**
     * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed by gathering incoming information links on all inputs in the interface of the element.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Incoming Links</em>' reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalElement_IncomingLinks()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.fam.derived.incomingLinks'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.fam.derived.incomingLinks'"
     * @generated
     */
    EList<InformationLink> getIncomingLinks();

    /**
     * Returns the value of the '<em><b>Connects</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connects</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed based on the outgoing and incoming links of the element.
     * 
     * b{Validation}
     *  * WARN: Element is connected to itself
     * <!-- end-model-doc -->
     * @return the value of the '<em>Connects</em>' reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalElement_Connects()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.fam.derived.connects'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.fam.derived.connects'"
     * @generated
     */
    EList<FunctionalElement> getConnects();

} // FunctionalElement
