package hu.bme.mit.massif.simulink.api.provider.filter;

import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;

import java.util.Set;

/**
 * Implementations of this class provide import filter for the Simulink importer.
 * 
 * @author Marton Bur
 *
 */
public interface IFilterProvider {

	/**
	 * Returns all registered import filters
	 * 
	 * @return
	 */
	Set<ISimulinkImportFilter> getRegisteredFilters(ModelObject model);
}
