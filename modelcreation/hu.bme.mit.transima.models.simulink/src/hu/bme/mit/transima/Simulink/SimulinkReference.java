/**
 */
package hu.bme.mit.transima.Simulink;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This abstract EClass represents a reference for a Simulink element. The identifier is a fully qualified
 *  name constructed from a qualifier (the fully qualified name of the parent of the element) and a name.
 * Since a #{simulink.SimulinkElement} can be identified based on its fully qualified name, it is possible
 *  to reference an element by cloning and storing the reference instead of a direct link to the element itself.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.SimulinkReference#getElement <em>Element</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.SimulinkReference#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.SimulinkReference#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSimulinkReference()
 * @model abstract="true"
 * @generated
 */
public interface SimulinkReference extends EObject {
    /**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Element</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(SimulinkElement)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSimulinkReference_Element()
	 * @model
	 * @generated
	 */
    SimulinkElement getElement();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.SimulinkReference#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
    void setElement(SimulinkElement value);

    /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSimulinkReference_Name()
	 * @model
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.SimulinkReference#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

    /**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Qualifier</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute.
	 * @see #setQualifier(String)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getSimulinkReference_Qualifier()
	 * @model
	 * @generated
	 */
    String getQualifier();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.SimulinkReference#getQualifier <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' attribute.
	 * @see #getQualifier()
	 * @generated
	 */
    void setQualifier(String value);

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(qualifier != null)\r\n\treturn qualifier+\"/\"+name;\r\nelse \r\n\treturn name;'"
	 * @generated
	 */
    String getFQN();

} // SimulinkReference
