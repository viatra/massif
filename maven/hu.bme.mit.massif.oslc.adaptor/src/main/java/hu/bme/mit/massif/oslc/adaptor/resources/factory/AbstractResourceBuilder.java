package hu.bme.mit.massif.oslc.adaptor.resources.factory;

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

abstract class AbstractResourceBuilder {

    private Class<? extends AbstractResource> forClazz;
    private AbstractResourceBuilder           parent;

    public AbstractResource build(final MatlabCommandFactory commandFactory, final String id, final String systemId) {
        AbstractResource resource = null;
        try {
            resource = newInstance();
        } catch (final URISyntaxException e) {
            e.printStackTrace();
        }
        // TODO: set the about
        if (resource != null)
            resource.setAbout(getAbout(id, systemId));
        build(commandFactory, id, systemId, resource);
        return resource;
    }

    protected void superBuild(final MatlabCommandFactory commandFactory, final String id, final String systemId,
            final AbstractResource ar) {
        if (parent != null)
            parent.build(commandFactory, id, systemId, ar);
    }

    public void build(final MatlabCommandFactory commandFactory, final String id, final String systemId,
            final AbstractResource ar) {
        superBuild(commandFactory, id, systemId, ar);
        buildResource(commandFactory, id, systemId, ar);
    }

    protected abstract void buildResource(final MatlabCommandFactory commandFactory, final String id, String systemId,
            AbstractResource ar);

    public abstract List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
            int page, int limit);

    public abstract AbstractResource newInstance() throws URISyntaxException;

    public abstract URI getAbout(String id, String systemId);

    public Class<? extends AbstractResource> getForClazz() {
        return forClazz;
    }

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
