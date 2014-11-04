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

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * Contains generic utility methods.
 * 
 * @author Dóczi Róbert
 *
 */
public class Utils {

    /**
     * Checks whether the provided string is a number.
     * @param str The string.
     * @return True if the provided string is a number, false otherwise.
     */
    public static boolean isNumber(final String str) {
        if (isNullOrEmpty(str))  // empty string and null is not a number
            return false;
        final NumberFormat formatter = NumberFormat.getInstance();
        final ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    /**
     * Checks whether the provided string is null or empty.
     * @param s The string.
     * @return True if the string is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.isEmpty();
    }
}
