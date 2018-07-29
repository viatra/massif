package hu.bme.mit.massif.simulink.ui.providers;

import hu.bme.mit.massif.simulink.api.extension.IBlockImportFilter;
import hu.bme.mit.massif.simulink.ui.MassifSimulinkUIPlugin;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public enum ImportFilterRegistry {

	INSTANCE;
	
	private Map<String,IBlockImportFilter> filtersById;
	
	public synchronized Map<String, IBlockImportFilter> getFiltersById() {
		if(filtersById == null){
			readExtensionRegistry();
		}
		return ImmutableMap.copyOf(filtersById);
	}

	private void readExtensionRegistry(){
		filtersById = Maps.newHashMap();
		
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
								IBlockImportFilter filter = (IBlockImportFilter) el.createExecutableExtension("filterImplClass");
								String filterId = el.getAttribute("filterId");
								if (filterId != null && !"".equals(filterId) && filter != null) {
									filtersById.put(filterId,filter);
								}
							} catch (Exception e) {
								MassifSimulinkUIPlugin.getDefault().getLog().log(
												new Status(IStatus.ERROR,
												MassifSimulinkUIPlugin.PLUGIN_ID,
												"Could not initialize filter!"
												));
							}
						}
					}
				}
			}
		}

	}

}
