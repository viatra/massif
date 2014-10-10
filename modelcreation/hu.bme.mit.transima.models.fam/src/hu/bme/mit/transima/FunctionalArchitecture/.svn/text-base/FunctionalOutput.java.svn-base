/**
 */
package hu.bme.mit.transima.FunctionalArchitecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents an output data communication point on a #{fam.FunctionalInterface}.
 * The output can be connected to input data points by #{fam.InformationLink} elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalOutput#getOutgoingLinks <em>Outgoing Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalOutput()
 * @model
 * @generated
 */
public interface FunctionalOutput extends FunctionalData {
    /**
     * Returns the value of the '<em><b>Outgoing Links</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outgoing Links</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * b{Validation}
     *  * ERROR: Datatype of target input is incompatible with datatype of this output.
     *  * WARN(?): Sample time of target input is different from output sample time.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Outgoing Links</em>' containment reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalOutput_OutgoingLinks()
     * @see hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getFrom
     * @model opposite="from" containment="true"
     * @generated
     */
    EList<InformationLink> getOutgoingLinks();

} // FunctionalOutput
