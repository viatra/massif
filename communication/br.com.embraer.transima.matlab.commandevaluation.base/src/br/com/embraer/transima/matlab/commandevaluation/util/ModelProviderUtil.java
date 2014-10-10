package br.com.embraer.transima.matlab.commandevaluation.util;

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
