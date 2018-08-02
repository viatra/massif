
package hu.bme.mit.massif.simulink;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents properties of #{simulink.Block} elements. Each property has a name, a type and a value.
 * The value is stored as a character string but is validated based on the type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Parameter#getType <em>Type</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Parameter#getValue <em>Value</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Parameter#getSource <em>Source</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.Parameter#isReadOnly <em>Read Only</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject {
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
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getParameter_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Parameter#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getParameter_Type()
     * @model
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Parameter#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * b{Validation}
     *  * ERROR: Value type is not compatible with property type.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getParameter_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Parameter#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Source</b></em>' attribute.
     * The literals are from the enumeration {@link hu.bme.mit.massif.simulink.ParameterSource}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' attribute.
     * @see hu.bme.mit.massif.simulink.ParameterSource
     * @see #setSource(ParameterSource)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getParameter_Source()
     * @model
     * @generated
     */
    ParameterSource getSource();

    /**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Parameter#getSource <em>Source</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' attribute.
     * @see hu.bme.mit.massif.simulink.ParameterSource
     * @see #getSource()
     * @generated
     */
    void setSource(ParameterSource value);

    /**
     * Returns the value of the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Read Only</em>' attribute.
     * @see #setReadOnly(boolean)
     * @see hu.bme.mit.massif.simulink.SimulinkPackage#getParameter_ReadOnly()
     * @model
     * @generated
     */
    boolean isReadOnly();

    /**
     * Sets the value of the '{@link hu.bme.mit.massif.simulink.Parameter#isReadOnly <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Only</em>' attribute.
     * @see #isReadOnly()
     * @generated
     */
    void setReadOnly(boolean value);

} // Parameter
