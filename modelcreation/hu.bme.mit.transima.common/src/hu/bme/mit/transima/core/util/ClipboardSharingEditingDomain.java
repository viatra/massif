package hu.bme.mit.transima.core.util;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

public class ClipboardSharingEditingDomain extends AdapterFactoryEditingDomain {

    private static Collection<Object> clipboard;

    public ClipboardSharingEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack,
            Map<Resource, Boolean> resourceToReadOnlyMap) {
        super(adapterFactory, commandStack, resourceToReadOnlyMap);
    }

    @Override
    public Collection<Object> getClipboard() {
        return clipboard;
    }

    @SuppressWarnings("static-access")
    @Override
    public void setClipboard(Collection<Object> clipboard) {
        this.clipboard = clipboard;
    }

}
