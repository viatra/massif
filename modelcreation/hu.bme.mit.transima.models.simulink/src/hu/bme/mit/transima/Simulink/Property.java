/**
 */
package hu.bme.mit.transima.Simulink;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents properties of #{simulink.Block} elements. Each property has a name, a type and a value.
 * The value is stored as a character string but is validated based on the type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.Property#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Property#getType <em>Type</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Property#getValue <em>Value</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Property#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends EObject {
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
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getProperty_Name()
	 * @model
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Property#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

    /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.transima.Simulink.PropertyType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see hu.bme.mit.transima.Simulink.PropertyType
	 * @see #setType(PropertyType)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getProperty_Type()
	 * @model
	 * @generated
	 */
    PropertyType getType();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Property#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see hu.bme.mit.transima.Simulink.PropertyType
	 * @see #getType()
	 * @generated
	 */
    void setType(PropertyType value);

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
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getProperty_Value()
	 * @model
	 * @generated
	 */
    String getValue();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Property#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
    void setValue(String value);

    /**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.transima.Simulink.PropertySource}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see hu.bme.mit.transima.Simulink.PropertySource
	 * @see #setSource(PropertySource)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getProperty_Source()
	 * @model
	 * @generated
	 */
    PropertySource getSource();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Property#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see hu.bme.mit.transima.Simulink.PropertySource
	 * @see #getSource()
	 * @generated
	 */
    void setSource(PropertySource value);

} // Property
