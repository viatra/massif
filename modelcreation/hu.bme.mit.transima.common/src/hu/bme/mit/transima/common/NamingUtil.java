package hu.bme.mit.transima.common;

import hu.bme.mit.transima.Simulink.BusSelector;
import hu.bme.mit.transima.Simulink.BusSignalMapping;
import hu.bme.mit.transima.Simulink.Property;
import hu.bme.mit.transima.Simulink.SimulinkElement;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Strings;

public class NamingUtil {

    public static String getShortNameOfNamedElement(EObject transimaElement) {
        String result = "";
        /* SIMULINK */
        if (transimaElement instanceof SimulinkElement) {
            result = ((SimulinkElement) transimaElement).getName();
        } else if (transimaElement instanceof Property) {
            result = ((Property) transimaElement).getName();
        } else if (transimaElement instanceof BusSignalMapping) {
            EObject parent = transimaElement.eContainer();
            if (parent instanceof BusSelector) {
                BusSelector busSelector = (BusSelector) parent;
                result = "BusSignalMapping " + busSelector.getMappings().indexOf(transimaElement);
            } else {
                result = "BusSignalMapping";
            }
        } else {
            result = transimaElement.toString();
        }
        return Strings.nullToEmpty(result);
    }

    public static String getLongNameOfNamedElement(EObject transimaElement) {
        String result = "";
        EObject parent = transimaElement.eContainer();
        if (!isModel(parent)) {
            result = getLongNameOfNamedElement(parent);
        }
        if ("".equals(result)) {
            return result.concat(getShortNameOfNamedElement(transimaElement));
        } else {
            return result.concat("/" + getShortNameOfNamedElement(transimaElement));
        }
    }

    protected static boolean isModel(EObject eobj) {
        boolean isModel = false;
        return isModel;
    }

    public static String getGlobalNameOfNamedElement(EObject transimaElement) {
        String result = "";
        EObject parent = transimaElement.eContainer();
        if (parent != null) {
            result = getGlobalNameOfNamedElement(parent);
        }
        if ("".equals(result)) {
            return result.concat(getShortNameOfNamedElement(transimaElement));
        } else {
            return result.concat("/" + getShortNameOfNamedElement(transimaElement));
        }
    }

}
