/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
 *******************************************************************************/
package br.com.embraer.massif.commandevaluation.util;

/**
 * Class to hold utility methods to be used in the project
 *
 * @author ldnascim
 */
public class ModelProviderUtil {

	/**
	 * Converts an array of objects to a plain string with
	 * a given separator 
	 * @param array Array of objects
	 * @param separator Separator
	 * @return array of objects converted to a plain string with
	 * 		   a given separator 
	 */
	public static String convertArrayToString(Object[] array, String separator) {
		if(array == null ){
			return "";
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
		   result.append(array[i]);
		   result.append(separator);
		}
		return result.toString();
	}
}
