package hu.bme.mit.massif.simulink.ui.providers;

import hu.bme.mit.massif.simulink.api.extension.IBlockImportFilter;
import hu.bme.mit.massif.simulink.api.extension.IParameterImportFilter;
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
	
	private Map<String,IBlockImportFilter> blockFiltersById;
	private Map<String,IParameterImportFilter> parameterFiltersById;
	
	public synchronized Map<String, IBlockImportFilter> getBlockFiltersById() {
		if(blockFiltersById == null){
			readExtensionRegistry();
		}
		return ImmutableMap.copyOf(blockFiltersById);
	}

	public synchronized Map<String, IParameterImportFilter> getParameterFiltersById() {
		if(parameterFiltersById == null){
			readExtensionRegistry();
		}
		return ImmutableMap.copyOf(parameterFiltersById);
	}

	private void readExtensionRegistry(){
		blockFiltersById = Maps.newHashMap();
		parameterFiltersById = Maps.newHashMap();
		
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IExtensionPoint poi;
		
		if (reg != null) {
			poi = reg.getExtensionPoint("hu.bme.mit.massif.simulink.api.import.filters");
			if (poi != null) {
				IExtension[] exts = poi.getExtensions();
				for (IExtension ext : exts) {
					IConfigurationElement[] els = ext.getConfigurationElements();
					for (IConfigurationElement el : els) {
						if (el.getName().equals("blockfilter")) {
							this.<IBlockImportFilter>createFilter(el, "block", blockFiltersById);
						} else if (el.getName().equals("parameterfilter")) {
							this.<IParameterImportFilter>createFilter(el, "parameter", parameterFiltersById);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private <T> void createFilter(IConfigurationElement el, String filterType, Map<String, T> filterMap) {
		try {
			T filter = (T) el.createExecutableExtension(filterType + "FilterImplClass");
			String filterId = el.getAttribute(filterType + "FilterId");
			if (filterId != null && !"".equals(filterId) && filter != null) {
				filterMap.put(filterId, filter);
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
