package hu.bme.mit.massif.simulink.api.provider.filter.impl;

import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.massif.simulink.api.internal.SimulinkApiPlugin;
import hu.bme.mit.massif.simulink.api.provider.filter.IFilterProvider;

import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.google.common.collect.Sets;

public class FilterProviderImpl implements IFilterProvider {


	@Override
	public Set<ISimulinkImportFilter> getRegisteredFilters(ModelObject model) {
		 // Initialization of filters from extensions via the extension point for filters
		Set<ISimulinkImportFilter> filters = Sets.newHashSet();
        IExtensionRegistry reg = Platform.getExtensionRegistry();
        IExtensionPoint poi;

        if (reg != null) {
            poi = reg.getExtensionPoint("hu.bme.mit.massif.simulink.api.import.filters");
            if (poi != null) {
                IExtension[] exts = poi.getExtensions();

                for (IExtension ext : exts) {
                    IConfigurationElement[] els = ext.getConfigurationElements();
                    for (IConfigurationElement el : els) {
                        if (el.getName().equals("filter")) {
                            try {
                                ISimulinkImportFilter filter = (ISimulinkImportFilter) el
                                        .createExecutableExtension("filterImplClass");
                                String identifier = el.getAttribute("filterId");
                                if (identifier != null && !"".equals(identifier) && filter != null) {
                                    for (String applicableFilterId : model.getApplicableFilters()) {
                                        if (applicableFilterId.equals(identifier)) {
                                            filters.add(filter);
                                            break;
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                SimulinkApiPlugin
                                        .getDefault()
                                        .getLog()
                                        .log(new Status(IStatus.ERROR, SimulinkApiPlugin.PLUGIN_ID,
                                                "Could not initialize filter!"));
                            }
                        }
                    }
                }
            }
        }
        return filters;
	}

}
