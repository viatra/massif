/**
 */
package hu.bme.mit.transima.FunctionalArchitecture;

import hu.bme.mit.transima.Component.PlatformConnectedElement;
import hu.bme.mit.transima.Component.SignalFlow;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a data connection between two #{fam.FunctionalElement} starting
 *  from an output data on the interface of the source element and leading to an input data
 *  on the interface other target element.
 * 
 * The information link can also contains a #{comp.SignalFlow} if it is mapped to multiple elements in a platform-specific model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getFrom <em>From</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getTo <em>To</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getSignalFlow <em>Signal Flow</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getPasses <em>Passes</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getInformationLink()
 * @model
 * @generated
 */
public interface InformationLink extends PlatformConnectedElement {
    /**
     * Returns the value of the '<em><b>From</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalOutput#getOutgoingLinks <em>Outgoing Links</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' container reference.
     * @see #setFrom(FunctionalOutput)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getInformationLink_From()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalOutput#getOutgoingLinks
     * @model opposite="outgoingLinks" transient="false"
     * @generated
     */
    FunctionalOutput getFrom();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getFrom <em>From</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' container reference.
     * @see #getFrom()
     * @generated
     */
    void setFrom(FunctionalOutput value);

    /**
     * Returns the value of the '<em><b>To</b></em>' reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInput#getIncomingLinks <em>Incoming Links</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' reference.
     * @see #setTo(FunctionalInput)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getInformationLink_To()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalInput#getIncomingLinks
     * @model opposite="incomingLinks"
     * @generated
     */
    FunctionalInput getTo();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getTo <em>To</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' reference.
     * @see #getTo()
     * @generated
     */
    void setTo(FunctionalInput value);

    /**
     * Returns the value of the '<em><b>Signal Flow</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signal Flow</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signal Flow</em>' containment reference.
     * @see #setSignalFlow(SignalFlow)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getInformationLink_SignalFlow()
     * @model containment="true"
     * @generated
     */
    SignalFlow getSignalFlow();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getSignalFlow <em>Signal Flow</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signal Flow</em>' containment reference.
     * @see #getSignalFlow()
     * @generated
     */
    void setSignalFlow(SignalFlow value);

    /**
     * Returns the value of the '<em><b>Passes</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getPassedBy <em>Passed By</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Passes</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Passes</em>' reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getInformationLink_Passes()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getPassedBy
     * @model opposite="passedBy"
     * @generated
     */
    EList<FunctionalData> getPasses();

} // InformationLink
