/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
/**
 */
package hu.bme.mit.massif.simulink;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tag Visibility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The Tag Visibility is a parameter of #{simulink.Goto} blocks to determine the location of #{simulink.From} blocks that access the signal.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/goto.html}
 * <!-- end-model-doc -->
 * @see hu.bme.mit.massif.simulink.SimulinkPackage#getTagVisibility()
 * @model
 * @generated
 */
public enum TagVisibility implements Enumerator {
	/**
     * The '<em><b>Local</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #LOCAL_VALUE
     * @generated
     * @ordered
     */
	LOCAL(0, "Local", "Local"),

	/**
     * The '<em><b>Scoped</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SCOPED_VALUE
     * @generated
     * @ordered
     */
	SCOPED(1, "Scoped", "Scoped"),

	/**
     * The '<em><b>Global</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #GLOBAL_VALUE
     * @generated
     * @ordered
     */
	GLOBAL(2, "Global", "Global");

	/**
     * The '<em><b>Local</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Local</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #LOCAL
     * @model name="Local"
     * @generated
     * @ordered
     */
	public static final int LOCAL_VALUE = 0;

	/**
     * The '<em><b>Scoped</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scoped</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SCOPED
     * @model name="Scoped"
     * @generated
     * @ordered
     */
	public static final int SCOPED_VALUE = 1;

	/**
     * The '<em><b>Global</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Global</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #GLOBAL
     * @model name="Global"
     * @generated
     * @ordered
     */
	public static final int GLOBAL_VALUE = 2;

	/**
     * An array of all the '<em><b>Tag Visibility</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final TagVisibility[] VALUES_ARRAY =
		new TagVisibility[] {
            LOCAL,
            SCOPED,
            GLOBAL,
        };

	/**
     * A public read-only list of all the '<em><b>Tag Visibility</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<TagVisibility> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Tag Visibility</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
	public static TagVisibility get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TagVisibility result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Tag Visibility</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
	public static TagVisibility getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TagVisibility result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Tag Visibility</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
	public static TagVisibility get(int value) {
        switch (value) {
            case LOCAL_VALUE: return LOCAL;
            case SCOPED_VALUE: return SCOPED;
            case GLOBAL_VALUE: return GLOBAL;
        }
        return null;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final int value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String name;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String literal;

	/**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private TagVisibility(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getValue() {
      return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
      return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLiteral() {
      return literal;
    }

	/**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        return literal;
    }
	
} //TagVisibility
