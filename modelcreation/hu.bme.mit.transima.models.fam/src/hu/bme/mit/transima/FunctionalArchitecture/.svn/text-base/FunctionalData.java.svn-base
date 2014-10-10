/**
 */
package hu.bme.mit.transima.FunctionalArchitecture;

import hu.bme.mit.transima.Component.PlatformConnectedElement;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents the abstract supertype of data communication points on a #{fam.FunctionalInterface}.
 * Each data element can specify the datatype and sample time used.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getDataType <em>Data Type</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getInterface <em>Interface</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getTerminator <em>Terminator</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getSampleTime <em>Sample Time</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getPassedBy <em>Passed By</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalData()
 * @model abstract="true"
 * @generated
 */
public interface FunctionalData extends PlatformConnectedElement {
    /**
     * Returns the value of the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Type</em>' attribute.
     * @see #setDataType(String)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalData_DataType()
     * @model
     * @generated
     */
    String getDataType();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getDataType <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Type</em>' attribute.
     * @see #getDataType()
     * @generated
     */
    void setDataType(String value);

    /**
     * Returns the value of the '<em><b>Interface</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getData <em>Data</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' container reference.
     * @see #setInterface(FunctionalInterface)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalData_Interface()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalInterface#getData
     * @model opposite="data" transient="false"
     * @generated
     */
    FunctionalInterface getInterface();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getInterface <em>Interface</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' container reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(FunctionalInterface value);

    /**
     * Returns the value of the '<em><b>Terminator</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FAMTerminator#getData <em>Data</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Terminator</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * b{Validation}
     *  * ERROR: information link connected to terminated data.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Terminator</em>' containment reference.
     * @see #setTerminator(FAMTerminator)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalData_Terminator()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FAMTerminator#getData
     * @model opposite="data" containment="true"
     * @generated
     */
    FAMTerminator getTerminator();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getTerminator <em>Terminator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Terminator</em>' containment reference.
     * @see #getTerminator()
     * @generated
     */
    void setTerminator(FAMTerminator value);

    /**
     * Returns the value of the '<em><b>Sample Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sample Time</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sample Time</em>' attribute.
     * @see #setSampleTime(String)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalData_SampleTime()
     * @model
     * @generated
     */
    String getSampleTime();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalData#getSampleTime <em>Sample Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sample Time</em>' attribute.
     * @see #getSampleTime()
     * @generated
     */
    void setSampleTime(String value);

    /**
     * Returns the value of the '<em><b>Passed By</b></em>' reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getPasses <em>Passes</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Passed By</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Passed By</em>' reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunctionalData_PassedBy()
     * @see hu.bme.mit.transima.FunctionalArchitecture.InformationLink#getPasses
     * @model opposite="passes"
     * @generated
     */
    EList<InformationLink> getPassedBy();

} // FunctionalData
