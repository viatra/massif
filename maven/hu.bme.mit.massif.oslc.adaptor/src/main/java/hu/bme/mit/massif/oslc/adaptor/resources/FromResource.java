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
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

// Start of user code imports
// End of user code

@OslcNamespace(SimulinkAdaptorConstants.SIMULINK_NAMSPACE)
@OslcName(SimulinkAdaptorConstants.FROMRESOURCE)
@OslcResourceShape(title = "FromResource Resource Shape", describes = SimulinkAdaptorConstants.TYPE_FROMRESOURCE)
public class FromResource extends VirtualBlockResource

{

    private Link gotoBlock = new Link();

    public FromResource() throws URISyntaxException {
        super();

        // Start of user code constructor1
        // End of user code
    }

    public FromResource(final URI about) throws URISyntaxException {
        super(about);

        // Start of user code constructor2
        // End of user code
    }

    public static URI constructURI(final String serviceProviderId, final String from) {
        String basePath = ServletListener.getServicesBase();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);

        pathParameters.put("from", from);
        String instanceURI = "/simu/{serviceProviderId}/fromResources/{from}";

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

    @OslcName("gotoBlock")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "gotoBlock")
    @OslcDescription("")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_GOTORESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("gotoBlock")
    public Link getGotoBlock() {
        return gotoBlock;
    }

    public void setGotoBlock(final Link gotoBlock) {
        this.gotoBlock = gotoBlock;
    }

    static public String gotoBlockToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code gotoBlockasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"gotoBlock\">gotoBlock: </LABEL>";

        // Start of user code gotoBlockasHtmlForCreation_mid
        // End of user code

        // Start of user code gotoBlockasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    public String gotoBlockToHtml() {
        String s = "";

        // Start of user code gotoBlocktoHtml_init
        // End of user code

        s = s + "<label for=\"gotoBlock\"><strong>gotoBlock</strong>: </LABEL>";

        // Start of user code gotoBlocktoHtml_mid
        // End of user code

        try {
            s = s + (new GotoResource(gotoBlock.getValue())).toHtml();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code gotoBlocktoHtml_finalize
        // End of user code

        return s;
    }

}
