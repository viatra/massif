package hu.bme.mit.massif.oslc.adaptor.util;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class Utils {

    public static boolean isNumber(final String str) {
        if (str.isEmpty())
            return false;
        final NumberFormat formatter = NumberFormat.getInstance();
        final ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.isEmpty();
    }
}
