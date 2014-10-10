/**
 */
package hu.bme.mit.transima.Simulink;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the abstract supertype of elements in Simulink systems that can be identified uniquely with a fully qualified name consisting of a name and a qualifier.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.SimulinkElement#getSimulinkRef <em>Simulink Ref</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.SimulinkElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSimulinkElement()
 * @model abstract="true"
 * @generated
 */
public interface SimulinkElement extends EObject {
    /**
     * Returns the value of the '<em><b>Simulink Ref</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Simulink Ref</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Simulink Ref</em>' containment reference.
     * @see #setSimulinkRef(IdentifierReference)
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSimulinkElement_SimulinkRef()
     * @model containment="true"
     * @generated
     */
    IdentifierReference getSimulinkRef();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.Simulink.SimulinkElement#getSimulinkRef <em>Simulink Ref</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simulink Ref</em>' containment reference.
     * @see #getSimulinkRef()
     * @generated
     */
    void setSimulinkRef(IdentifierReference value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed from the name feature of the #{simulink.SimulinkReference} stored in simulinkRef.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSimulinkElement_Name()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.simulink.derived.name'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.simulink.derived.name'"
     * @generated
     */
    String getName();

} // SimulinkElement
