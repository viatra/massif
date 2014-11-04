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
package hu.bme.mit.massif.oslc.adaptor.resources.factory;

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

/**
 * Abstract builder class for building OSLC resources.
 * 
 * @author Dóczi Róbert
 *
 */
abstract class AbstractResourceBuilder {

    /**
     * The resource the builder can build.
     */
    private Class<? extends AbstractResource> forClazz;

    /**
     * The builder that can build the parent of the OSLC resource.
     */
    private AbstractResourceBuilder parent;

    /**
     * Creates an OSLC resource representing the simulink element with the specified id in the specified system.
     * 
     * @param commandFactory
     *            The matlab command factory to use.
     * @param id
     *            The id of the simulink element.
     * @param systemId
     *            The id of the simulink system.
     * @return The OSLC resource representing the simulink element.
     */
    public AbstractResource build(final MatlabCommandFactory commandFactory, final String id, final String systemId) {
        AbstractResource resource = null;
        try {
            resource = newInstance();
        } catch (final URISyntaxException e) {
            e.printStackTrace();
        }
        if (resource != null)
            resource.setAbout(getAbout(id, systemId));
        build(commandFactory, id, systemId, resource);
        return resource;
    }

    protected void superBuild(final MatlabCommandFactory commandFactory, final String id, final String systemId, final AbstractResource ar) {
        if (parent != null)
            parent.build(commandFactory, id, systemId, ar);
    }

    /**
     * Creates an OSLC resource representing the simulink element with the specified id in the specified system using the provided OSLC
     * resource object.
     * 
     * @param commandFactory
     *            The matlab command factory to use.
     * @param id
     *            The id of the simulink element.
     * @param systemId
     *            The id of the simulink system.
     * @return The OSLC resource representing the simulink element.
     */
    public void build(final MatlabCommandFactory commandFactory, final String id, final String systemId, final AbstractResource ar) {
        superBuild(commandFactory, id, systemId, ar);
        buildResource(commandFactory, id, systemId, ar);
    }

    protected abstract void buildResource(final MatlabCommandFactory commandFactory, final String id, String systemId, AbstractResource ar);

    /**
     * Collects every simulink element whiches OSLC resource this builder can build.
     * @param commandFactory The matlab command factory to use.
     * @param systemId The id of the simulink system.
     * @param page The page number.
     * @param limit The number of elements on an individual page.
     * @return The list of OSLC resources.
     */
    public abstract List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId, int page, int limit);

    /**
     * Creates a new empty OSLC resource specific to the builder implementation.
     * @return The empty OSLC resource.
     * @throws URISyntaxException
     */
    public abstract AbstractResource newInstance() throws URISyntaxException;

    /**
     * Gets the URI of the OSLC resource.
     * @param id The id of the simulink element.
     * @param systemId The id of the simulink system.
     * @return
     */
    public abstract URI getAbout(String id, String systemId);

    /**
     * Returns the class the builder can build.
     * @return The class the builder can build.
     */
    public Class<? extends AbstractResource> getForClazz() {
        return forClazz;
    }

    /**
     * Sets the class the builder can build.
     * @forClass The class the builder can build.
     */
    public void setForClazz(final Class<? extends AbstractResource> forClass) {
        forClazz = forClass;
    }

    public AbstractResourceBuilder getParent() {
        return parent;
    }

    public void setParent(final AbstractResourceBuilder parent) {
        this.parent = parent;
    }
}
