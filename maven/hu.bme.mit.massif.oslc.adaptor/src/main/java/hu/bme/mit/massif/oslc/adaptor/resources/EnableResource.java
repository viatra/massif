/*******************************************************************************
 * Copyright (c) 2012, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
package hu.bme.mit.massif.oslc.adaptor.resources;

import hu.bme.mit.massif.oslc.adaptor.SimulinkAdaptorConstants;
import hu.bme.mit.massif.oslc.adaptor.servlet.ServletListener;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

// Start of user code imports
// End of user code

@OslcNamespace(SimulinkAdaptorConstants.SIMULINK_NAMSPACE)
@OslcName(SimulinkAdaptorConstants.ENABLERESOURCE)
@OslcResourceShape(title = "EnableResource Resource Shape", describes = SimulinkAdaptorConstants.TYPE_ENABLERESOURCE)
public class EnableResource extends InPortResource

{

    private String statesWhenEnabling;

    public EnableResource() throws URISyntaxException {
        super();

        // Start of user code constructor1
        // End of user code
    }

    public EnableResource(final URI about) throws URISyntaxException {
        super(about);

        // Start of user code constructor2
        // End of user code
    }

    public static URI constructURI(final String serviceProviderId, final String enable) {
        String basePath = ServletListener.getServicesBase();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);

        pathParameters.put("enable", enable);
        String instanceURI = "/simu/{serviceProviderId}/enableResources/{enable}";

        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }

    public String toString() {
        String result = "";
        // Start of user code toString_init
        if (getAbout() == null) {
            return result;
        }
        // End of user code

        result = getAbout().toString();

        // Start of user code toString_finalize
        // End of user code

        return result;
    }

    public String toHtml() {
        String result = "";
        // Start of user code toHtml_init
        // End of user code

        result = "<a href=\"" + getAbout() + "\">" + toString() + "</a>";

        // Start of user code toHtml_finalize
        // End of user code

        return result;
    }

    @OslcName("statesWhenEnabling")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "statesWhenEnabling")
    @OslcDescription("")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("statesWhenEnabling")
    public String getStatesWhenEnabling() {
        return statesWhenEnabling;
    }

    public void setStatesWhenEnabling(final String statesWhenEnabling) {
        this.statesWhenEnabling = statesWhenEnabling;
    }

    static public String statesWhenEnablingToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code statesWhenEnablingasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"statesWhenEnabling\">statesWhenEnabling: </LABEL>";

        // Start of user code statesWhenEnablingasHtmlForCreation_mid
        // End of user code

        s = s + "<input name=\"statesWhenEnabling\" type=\"text\" style=\"width: 400px\" id=\"statesWhenEnabling\" >";

        // Start of user code statesWhenEnablingasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    public String statesWhenEnablingToHtml() {
        String s = "";

        // Start of user code statesWhenEnablingtoHtml_init
        // End of user code

        s = s + "<label for=\"statesWhenEnabling\"><strong>statesWhenEnabling</strong>: </LABEL>";

        // Start of user code statesWhenEnablingtoHtml_mid
        // End of user code

        try {
            if (statesWhenEnabling == null) {
                s = s + "<em>null</em>";
            } else {
                s = s + statesWhenEnabling.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code statesWhenEnablingtoHtml_finalize
        // End of user code

        return s;
    }

}
