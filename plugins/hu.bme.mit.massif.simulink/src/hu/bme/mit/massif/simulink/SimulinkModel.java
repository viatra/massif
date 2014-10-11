/**
 */
package hu.bme.mit.massif.simulink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulink Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the root of an imported Simulink system that contains blocks. The version and file path informations are stored to allow change management. The library attribute stores whether the model was a library or a regular model in Matlab.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.massif.simulink.SimulinkModel#getVersion <em>Version</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.SimulinkModel#getContains <em>Contains</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.SimulinkModel#getFile <em>File</em>}</li>
 *   <li>{@link hu.bme.mit.massif.simulink.SimulinkModel#isLibrary <em>Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSimulinkModel()
 * @model
 * @generated
 */
public interface SimulinkModel extends SimulinkElement {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSimulinkModel_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.SimulinkModel#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Contains</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.massif.simulink.Block}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' containment reference list.
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSimulinkModel_Contains()
	 * @model containment="true"
	 * @generated
	 */
	EList<Block> getContains();

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSimulinkModel_File()
	 * @model
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.SimulinkModel#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

	/**
	 * Returns the value of the '<em><b>Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' attribute.
	 * @see #setLibrary(boolean)
	 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getSimulinkModel_Library()
	 * @model
	 * @generated
	 */
	boolean isLibrary();

	/**
	 * Sets the value of the '{@link hu.bme.mit.massif.simulink.SimulinkModel#isLibrary <em>Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library</em>' attribute.
	 * @see #isLibrary()
	 * @generated
	 */
	void setLibrary(boolean value);

} // SimulinkModel
