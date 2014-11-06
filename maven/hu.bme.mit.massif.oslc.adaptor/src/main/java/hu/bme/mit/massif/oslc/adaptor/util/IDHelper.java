/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Robert Doczi, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.oslc.adaptor.util;

/**
 * Static utility class to help refactoring and reverting id-s.
 * 
 * @author Robert Doczi
 */
public class IDHelper {

    /**
     * Removes every occurrence of '/' and ' ' character in the provided string.
     * 
     * @param id
     *            original string.
     * @return refactored string.
     */
    public static String refactorId(final String id) {
        String temp = id;
        temp = temp.replace("/", "$1SL1$");
        temp = temp.replace(" ", "$1S1$");
        return temp;
    }

    /**
     * Reverts a refactored string back to its original form.
     * 
     * @param id
     *            refactored string.
     * @return the original string.
     */
    public static String revertId(final String id) {
        String temp = id;
        temp = temp.replace("$1SL1$", "/");
        temp = temp.replace("$1S1$", " ");
        return temp;
    }

}
