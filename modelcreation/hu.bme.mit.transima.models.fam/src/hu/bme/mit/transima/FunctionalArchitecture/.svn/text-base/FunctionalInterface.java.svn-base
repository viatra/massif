/**
 */
package hu.bme.mit.transima.FunctionalArchitecture;

import hu.bme.mit.transima.Component.PlatformConnectedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the communication interface of a #{fam.FunctionalElement} with a set of input and output #{fam.FunctionalData} communication points.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getInputs <em>Inputs</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getData <em>Data</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getElement <em>Element</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalInterface()
 * @model
 * @generated
 */
public interface FunctionalInterface extends PlatformConnectedElement {
    /**
     * Returns the value of the '<em><b>Inputs</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInput}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed by filtering the values in the data feature to inputs.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Inputs</em>' reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalInterface_Inputs()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.fam.derived.inputs'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.fam.derived.inputs'"
     * @generated
     */
    EList<FunctionalInput> getInputs();

    /**
     * Returns the value of the '<em><b>Data</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data</em>' containment reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalInterface_Data()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<FunctionalData> getData();

    /**
     * Returns the value of the '<em><b>Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Element</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Element</em>' container reference.
     * @see #setElement(FunctionalElement)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalInterface_Element()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getInterface
     * @model opposite="interface" transient="false"
     * @generated
     */
    FunctionalElement getElement();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getElement <em>Element</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Element</em>' container reference.
     * @see #getElement()
     * @generated
     */
    void setElement(FunctionalElement value);

    /**
     * Returns the value of the '<em><b>Outputs</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalOutput}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed by filtering the values in the data feature to outputs.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Outputs</em>' reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalInterface_Outputs()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.fam.derived.outputs'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.fam.derived.outputs'"
     * @generated
     */
    EList<FunctionalOutput> getOutputs();

} // FunctionalInterface
