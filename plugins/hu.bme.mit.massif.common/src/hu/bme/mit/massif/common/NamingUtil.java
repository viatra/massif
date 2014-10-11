package hu.bme.mit.massif.common;

import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.Property;
import hu.bme.mit.massif.simulink.SimulinkElement;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Strings;

public class NamingUtil {

    public static String getShortNameOfNamedElement(EObject massifElement) {
        String result = "";
        /* SIMULINK */
        if (massifElement instanceof SimulinkElement) {
            result = ((SimulinkElement) massifElement).getName();
        } else if (massifElement instanceof Property) {
            result = ((Property) massifElement).getName();
        } else if (massifElement instanceof BusSignalMapping) {
            EObject parent = massifElement.eContainer();
            if (parent instanceof BusSelector) {
                BusSelector busSelector = (BusSelector) parent;
                result = "BusSignalMapping " + busSelector.getMappings().indexOf(massifElement);
            } else {
                result = "BusSignalMapping";
            }
        } else {
            result = massifElement.toString();
        }
        return Strings.nullToEmpty(result);
    }

    public static String getLongNameOfNamedElement(EObject massifElement) {
        String result = "";
        EObject parent = massifElement.eContainer();
        if (!isModel(parent)) {
            result = getLongNameOfNamedElement(parent);
        }
        if ("".equals(result)) {
            return result.concat(getShortNameOfNamedElement(massifElement));
        } else {
            return result.concat("/" + getShortNameOfNamedElement(massifElement));
        }
    }

    protected static boolean isModel(EObject eobj) {
        boolean isModel = false;
        return isModel;
    }

    public static String getGlobalNameOfNamedElement(EObject massifElement) {
        String result = "";
        EObject parent = massifElement.eContainer();
        if (parent != null) {
            result = getGlobalNameOfNamedElement(parent);
        }
        if ("".equals(result)) {
            return result.concat(getShortNameOfNamedElement(massifElement));
        } else {
            return result.concat("/" + getShortNameOfNamedElement(massifElement));
        }
    }

}
