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
import java.util.HashSet;
import java.util.Iterator;
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
@OslcName(SimulinkAdaptorConstants.SUBSYSTEMRESOURCE)
@OslcResourceShape(title = "SubSystemResource Resource Shape", describes = SimulinkAdaptorConstants.TYPE_SUBSYSTEMRESOURCE)
public class SubSystemResource extends BlockResource

{

    private HashSet<Link> subBlockss = new HashSet<Link>();
    private String        tag;

    public SubSystemResource() throws URISyntaxException {
        super();

        // Start of user code constructor1
        // End of user code
    }

    public SubSystemResource(final URI about) throws URISyntaxException {
        super(about);

        // Start of user code constructor2
        // End of user code
    }

    public static URI constructURI(final String serviceProviderId, final String subSystem) {
        String basePath = ServletListener.getServicesBase();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);

        pathParameters.put("subSystem", subSystem);
        String instanceURI = "/simu/{serviceProviderId}/subSystemResources/{subSystem}";

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

    public void addSubBlocks(final Link subBlocks) {
        this.subBlockss.add(subBlocks);
    }

    @OslcName("subBlocks")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "subBlocks")
    @OslcDescription("")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_BLOCKRESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("subBlocks")
    public HashSet<Link> getSubBlockss() {
        return subBlockss;
    }

    @OslcName("tag")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "tag")
    @OslcDescription("")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("tag")
    public String getTag() {
        return tag;
    }

    public void setSubBlockss(final HashSet<Link> subBlocks) {
        this.subBlockss.clear();
        if (subBlocks != null) {
            this.subBlockss.addAll(subBlocks);
        }

    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

    static public String subBlockssToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code subBlockssasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"subBlocks\">subBlocks: </LABEL>";

        // Start of user code subBlockssasHtmlForCreation_mid
        // End of user code

        // Start of user code subBlockssasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String tagToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code tagasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"tag\">tag: </LABEL>";

        // Start of user code tagasHtmlForCreation_mid
        // End of user code

        s = s + "<input name=\"tag\" type=\"text\" style=\"width: 400px\" id=\"tag\" >";

        // Start of user code tagasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    public String subBlockssToHtml() {
        String s = "";

        // Start of user code subBlocksstoHtml_init
        // End of user code

        s = s + "<label for=\"subBlocks\"><strong>subBlocks</strong>: </LABEL>";

        // Start of user code subBlocksstoHtml_mid
        // End of user code

        try {
            s = s + "<ul>";
            Iterator<Link> itr = subBlockss.iterator();
            while (itr.hasNext()) {
                s = s + "<li>";
                s = s + (new BlockResource(itr.next().getValue())).toHtml();
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code subBlocksstoHtml_finalize
        // End of user code

        return s;
    }

    public String tagToHtml() {
        String s = "";

        // Start of user code tagtoHtml_init
        // End of user code

        s = s + "<label for=\"tag\"><strong>tag</strong>: </LABEL>";

        // Start of user code tagtoHtml_mid
        // End of user code

        try {
            if (tag == null) {
                s = s + "<em>null</em>";
            } else {
                s = s + tag.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code tagtoHtml_finalize
        // End of user code

        return s;
    }

}
