package hu.bme.mit.massif.simulink.importer.ui.providers;

import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.massif.simulink.importer.ui.MassifSimulinkUIPlugin;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.google.common.collect.Maps;

public enum ImportFilterRegistry {

	INSTANCE;
	
	private Map<String,ISimulinkImportFilter> filtersById;
	private Map<String,String> filterNamesById;
	private Map<String,String> filterTooltipsById;

	
	public Map<String, ISimulinkImportFilter> getFiltersById() {
		return filtersById;
	}


	public Map<String, String> getFilterNamesById() {
		return filterNamesById;
	}
	
	public Map<String, String> getFilterTooltipsById() {
		return filterTooltipsById;
	}


	private ImportFilterRegistry(){
		filtersById = Maps.newHashMap();
		filterNamesById = Maps.newHashMap();
		filterTooltipsById = Maps.newHashMap();
		
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
								ISimulinkImportFilter filter = (ISimulinkImportFilter) el.createExecutableExtension("filterImplClass");
								String filterId = el.getAttribute("filterId");
								if (filterId != null && !"".equals(filterId) && filter != null) {
									filtersById.put(filterId,filter);
									filterNamesById.put(filterId,el.getAttribute("filterName"));
									filterTooltipsById.put(filterId,el.getAttribute("filterTooltip"));
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
