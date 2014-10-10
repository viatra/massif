/**
 */
package hu.bme.mit.transima.FunctionalArchitecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This EClass represents a function in the #{fam.FunctionalArchitectureModel} with a given design assurance level and a minimum design frequency.
 * The type of the function specifies whether it is a root of a function tree, an intermediate element or a leaf function.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getType <em>Type</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getDesignAssuranceLevel <em>Design Assurance Level</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getMinimumDesignFrequency <em>Minimum Design Frequency</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getSubElements <em>Sub Elements</em>}</li>
 *   <li>{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getRequirements <em>Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends FunctionalElement {
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value is computed based on the parent and subElements relations as follows (in this order):
     *  * Root: if there is no parent function
     *  * Leaf: if there are no subElements
     *  * Intermediate: otherwise
     * <!-- end-model-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionType
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunction_Type()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="org.eclipse.viatra2.emf.incquery.derived.feature patternFQN='hu.bme.mit.transima.models.fam.derived.type'"
     *        annotation="org.eclipse.incquery.querybasedfeature patternFQN='hu.bme.mit.transima.models.fam.derived.type'"
     * @generated
     */
    FunctionType getType();

    /**
     * Returns the value of the '<em><b>Design Assurance Level</b></em>' attribute.
     * The literals are from the enumeration {@link hu.bme.mit.transima.FunctionalArchitecture.DesignAssuranceLevel}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Design Assurance Level</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Design Assurance Level</em>' attribute.
     * @see hu.bme.mit.transima.FunctionalArchitecture.DesignAssuranceLevel
     * @see #setDesignAssuranceLevel(DesignAssuranceLevel)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunction_DesignAssuranceLevel()
     * @model
     * @generated
     */
    DesignAssuranceLevel getDesignAssuranceLevel();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getDesignAssuranceLevel <em>Design Assurance Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Design Assurance Level</em>' attribute.
     * @see hu.bme.mit.transima.FunctionalArchitecture.DesignAssuranceLevel
     * @see #getDesignAssuranceLevel()
     * @generated
     */
    void setDesignAssuranceLevel(DesignAssuranceLevel value);

    /**
     * Returns the value of the '<em><b>Minimum Design Frequency</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum Design Frequency</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum Design Frequency</em>' attribute.
     * @see #setMinimumDesignFrequency(float)
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunction_MinimumDesignFrequency()
     * @model
     * @generated
     */
    float getMinimumDesignFrequency();

    /**
     * Sets the value of the '{@link hu.bme.mit.transima.FunctionalArchitecture.Function#getMinimumDesignFrequency <em>Minimum Design Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum Design Frequency</em>' attribute.
     * @see #getMinimumDesignFrequency()
     * @generated
     */
    void setMinimumDesignFrequency(float value);

    /**
     * Returns the value of the '<em><b>Sub Elements</b></em>' containment reference list.
     * The list contents are of type {@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement}.
     * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Elements</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Elements</em>' containment reference list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunction_SubElements()
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalElement#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
    EList<FunctionalElement> getSubElements();

    /**
     * Returns the value of the '<em><b>Requirements</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Requirements</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Requirements</em>' attribute list.
     * @see hu.bme.mit.transima.FunctionalArchitecture.FunctionalArchitectureModelPackage#getFunction_Requirements()
     * @model
     * @generated
     */
    EList<String> getRequirements();

} // Function
