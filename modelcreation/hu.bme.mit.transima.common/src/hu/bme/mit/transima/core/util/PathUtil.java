package hu.bme.mit.transima.core.util;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Utility class for creating relative paths.
 * 
 * @author R�bert D�czi
 */
public class PathUtil {

    private static final String PARENT_DIR_PATH_FRAGMENT = "..";

    /**
     * Creates a relative path from the provided {@code fromPath} to the provided {@code toPath}.
     * 
     * @param fromPath
     *            The start of the relative path.
     * @param toPath
     *            The end of the relative path.
     * @return The relative path.
     */
    public static String absoluteToRelativePath(final String fromPath, final String toPath) {

        String pathSeparator = System.getProperty("file.separator");

        String[] base = fromPath.split(Pattern.quote(pathSeparator));
        String[] target = toPath.split(Pattern.quote(pathSeparator));

        // First get all the common elements. Store them as a string,
        // and also count how many of them there are.
        StringBuffer common = new StringBuffer();

        int commonIndex = 0;
        while (commonIndex < target.length && commonIndex < base.length
                && target[commonIndex].equals(base[commonIndex])) {
            common.append(target[commonIndex]).append(pathSeparator);
            commonIndex++;
        }

        if (commonIndex == 0)
            // No single common path element. This most
            // likely indicates differing drive letters, like C: and D:.
            // These paths cannot be relativized.
            throw new IllegalArgumentException("No common path element found for '" + toPath + "' and '" + fromPath
                    + "'");

        boolean baseIsFile = isBaseFile(fromPath, pathSeparator);

        StringBuffer relative = new StringBuffer();

        if (base.length != commonIndex) {
            int numDirsUp = baseIsFile ? base.length - commonIndex - 1 : base.length - commonIndex;

            for (int i = 0; i < numDirsUp; i++) {
                relative.append(PARENT_DIR_PATH_FRAGMENT).append(pathSeparator);
            }
        }
        relative.append(toPath.substring(common.length()));
        return relative.toString();
    }

    /**
     * Resolves the relative path to get an absolute path to the location.
     * 
     * @param basePath
     *            The base of the relative path.
     * @param relativePath
     *            The relative path to be resolved.
     * @return The absolute path resolved from relative path.
     */
    public static String relativeToAbsolutePath(final String basePath, final String relativePath) {

        String pathSeparator = System.getProperty("file.separator");

        String[] base = basePath.split(Pattern.quote(pathSeparator));
        String[] relative = relativePath.split(Pattern.quote(pathSeparator));

        int index = base.length - 1;

        // check if the base is a file...
        boolean baseIsFile = isBaseFile(basePath, pathSeparator);

        StringBuilder absolute = new StringBuilder();

        // if the base is file then we need to move back one more index
        if (baseIsFile) {
            index--;
        }

        int i = 0;
        for (; i < relative.length; i++) {
            String relativePart = relative[i];
            if (relativePart.equals(PARENT_DIR_PATH_FRAGMENT)) {
                index--;
            } else {
                break;
            }
        }

        for (int j = 0; j <= index; j++) {
            absolute.append(base[j] + pathSeparator);
        }

        // 'i' is the amount of "../"-s, so we need to move i * 3 characters to get to
        // the required part of the relative path
        int numberOfParentNavigation = PARENT_DIR_PATH_FRAGMENT.length() + pathSeparator.length();
        absolute.append(relativePath.substring(numberOfParentNavigation));

        return absolute.toString();
    }

    /**
     * Checks if the provided path is a file
     * 
     * @param base
     *            The path to be checked.
     * @param separator
     *            The system file separator.
     * @return True if is file, false otherwise.
     */
    private static boolean isBaseFile(final String base, final String separator) {

        // The number of directories we have to backtrack depends on whether the base is a file or a dir
        // For example, the relative path from
        //
        // /foo/bar/baz/gg/ff to /foo/bar/baz
        //
        // ".." if ff is a file
        // "../.." if ff is a directory
        //
        // The following is a heuristic to figure out if the base refers to a file or dir. It's not perfect, because
        // the resource referred to by this path may not actually exist
        boolean baseIsFile = true;

        File baseResource = new File(base);

        if (baseResource.exists()) {
            baseIsFile = baseResource.isFile();
        } else if (base.endsWith(separator)) {
            baseIsFile = false;
        }

        return baseIsFile;
    }
    
    public static String calculatePathFromAbsoluteAndRelative(final String base, final String relative){
		if(base != null && relative != null && base.startsWith("platform:/resource/")){
			// Change delimiters
			String rawRelative = relative.replace('\\', '/');
			
            String rawPath = base.substring(0, base.lastIndexOf('/'));
	
			String delim = "../";
			while(rawRelative.startsWith(delim)){
				rawRelative = rawRelative.substring(delim.length());
				int lio = rawPath.lastIndexOf('/');
				if(lio != -1){
					rawPath = rawPath.substring(0, lio);
				}else{
					return null;
				}
			}
	    	
	    	return rawPath + "/" + rawRelative;
		}
		return null;
    }

}
