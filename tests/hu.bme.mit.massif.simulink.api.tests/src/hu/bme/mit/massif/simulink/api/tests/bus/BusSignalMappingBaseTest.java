package hu.bme.mit.massif.simulink.api.tests.bus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.bme.mit.massif.models.simulink.util.BusMappingInSelectorMatcher;
import hu.bme.mit.massif.models.simulink.util.BusSelectorMatcher;
import hu.bme.mit.massif.models.simulink.util.util.BusMappingInSelectorProcessor;
import hu.bme.mit.massif.models.simulink.util.util.BusSelectorProcessor;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMapper;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMappingCreator;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMappingPathFinder;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import com.google.common.collect.Maps;

public class BusSignalMappingBaseTest {

    protected String modelUri;

    public BusSignalMapper prepareBusSignalMapper() throws Exception {
        Exporter exporter = new Exporter();
    
        SimulinkModel loadedModel = exporter.loadSimulinkModel(modelUri);
    
        ResourceSet resourceSet = loadedModel.eResource().getResourceSet();
        BusSignalMapper mapper = new BusSignalMapper(resourceSet);
        mapper.logDebug("> Testing on model: " + modelUri);
        mapper.logDebug(">> Simulink model: " + mapper.getFQNOrEmpty(loadedModel));
        return mapper;
    }

    protected void checkPathFinder(final BusSignalMapper mapper) throws IncQueryException {
        BusMappingInSelectorMatcher selectorMatcher = BusMappingInSelectorMatcher.on(mapper.getEngine());
        selectorMatcher.forEachMatch(new BusMappingInSelectorProcessor() {

			@Override
			public void process(BusSelector pSelector, BusSignalMapping pMapping, OutPort pMappingFrom,OutPort pMappingTo) {
                mapper.logDebug("==========");
                mapper.logDebug("Testing path finder on: " + mapper.getFQNOrEmpty((SimulinkElement) pMappingFrom) + " to " + mapper.getFQNOrEmpty((SimulinkElement) pMappingTo));
                String path = new BusSignalMappingPathFinder(mapper).findMappingPath((BusSignalMapping) pMapping);
                mapper.logDebug(">>> Found mapping: " + path);
                assertEquals(((BusSignalMapping) pMapping).getMappingPath(), path);
                mapper.logDebug("==========");
			}

        });
    }

    protected void executeMappingCreator(final BusSignalMapper mapper, final boolean includesIncomplete) throws IncQueryException {
        BusSelectorMatcher selectorMatcher = BusSelectorMatcher.on(mapper.getEngine());
        final Map<BusSignalMapping, OutPort> mappings = Maps.newHashMap();
        selectorMatcher.forEachMatch(new BusSelectorProcessor() {
            
			@Override
			public void process(BusSelector pSelector) {
                mapper.logDebug("Removing mappings from " + mapper.getFQNOrEmpty((SimulinkElement) pSelector));
                (pSelector).setBusCreator(null);
                for (BusSignalMapping mapping : (pSelector).getMappings()) {
                    if(mapping.getMappingFrom() != null){
                        mappings.put(mapping, mapping.getMappingFrom());
                    }
                    mapping.setMappingFrom(null);
                }
			}

        });
        selectorMatcher.forEachMatch(new BusSelectorProcessor() {
            
			@Override
			public void process(BusSelector pSelector) {
				  mapper.logDebug("==========");
	                mapper.logDebug("Testing mapping creator on: " + mapper.getFQNOrEmpty((SimulinkElement) pSelector));
	                ((BusSelector) pSelector).setBusCreator(null);
	                for (BusSignalMapping mapping : ((BusSelector) pSelector).getMappings()) {
	                    mapping.setMappingFrom(null);
	                }
	                new BusSignalMappingCreator(mapper).createBusMapping((BusSelector) pSelector);
	                boolean hasComplete = false;
	                if(!includesIncomplete){
	                    for (BusSignalMapping mapping : ((BusSelector) pSelector).getMappings()) {
	                        assertEquals(mappings.get(mapping), mapping.getMappingFrom());
	                        hasComplete = true;
	                    }
	                } else {
	                    for (BusSignalMapping mapping : ((BusSelector) pSelector).getMappings()) {
	                        assertTrue(mapping.getMappingFrom() != null);
	                        OutPort outPort = mappings.get(mapping);
	                        if(outPort != null){
	                            assertTrue(mapping.getMappingFrom().equals(outPort));
	                        }
	                        hasComplete = hasComplete || !mapping.isIncomplete();
	                    }
	                }
	                if(hasComplete){
	                    assertTrue(((BusSelector) pSelector).getBusCreator() != null);
	                }
	                mapper.logDebug("==========");
			}

        });
    }

}
