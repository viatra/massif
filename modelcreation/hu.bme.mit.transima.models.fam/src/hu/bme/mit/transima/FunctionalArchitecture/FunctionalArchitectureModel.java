/**
 */
package hu.bme.mit.transima.FunctionalArchitecture;

import hu.bme.mit.transima.Component.PlatformConnectedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Architecture Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the root of the functional architecture model that contains functions, sensors, actuators and their interconnections.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModel#getRootElements <em>Root Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalArchitectureModel()
 * @model
 * @generated
 */
public interface FunctionalArchitectureModel extends PlatformConnectedElement {
    /**
     * Returns the value of the '<em><b>Root Elements</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Elements</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root Elements</em>' containment reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalArchitectureModel_RootElements()
     * @model containment="true"
     * @generated
     */
    EList<FunctionalElement> getRootElements();

} // FunctionalArchitectureModel
