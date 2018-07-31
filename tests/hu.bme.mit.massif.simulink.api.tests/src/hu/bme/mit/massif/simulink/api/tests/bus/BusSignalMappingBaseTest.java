/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.tests.bus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.google.common.collect.Maps;

import hu.bme.mit.massif.models.simulink.util.BusMappingInSelector;
import hu.bme.mit.massif.models.simulink.util.BusMappingInSelector.Match;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMapper;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMappingCreator;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMappingPathFinder;

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

	protected void checkPathFinder(final BusSignalMapper mapper) throws ViatraQueryException {
		BusMappingInSelector.Matcher selectorMatcher = BusMappingInSelector.Matcher.on(mapper.getEngine());
		selectorMatcher.forEachMatch((Match busMappingInSelectorMatch) -> {
			BusSignalMapping pMapping = busMappingInSelectorMatch.getMapping();
			OutPort pMappingFrom = busMappingInSelectorMatch.getMappingFrom();
			OutPort pMappingTo = busMappingInSelectorMatch.getMappingTo();
			mapper.logDebug("==========");
			mapper.logDebug("Testing path finder on: " + mapper.getFQNOrEmpty((SimulinkElement) pMappingFrom) + " to "
					+ mapper.getFQNOrEmpty((SimulinkElement) pMappingTo));
			String path = new BusSignalMappingPathFinder(mapper).findMappingPath((BusSignalMapping) pMapping);
			mapper.logDebug(">>> Found mapping: " + path);
			assertEquals(((BusSignalMapping) pMapping).getMappingPath(), path);
			mapper.logDebug("==========");

		});

	}

	protected void executeMappingCreator(final BusSignalMapper mapper, final boolean includesIncomplete)
			throws ViatraQueryException {
		hu.bme.mit.massif.models.simulink.util.BusSelector.Matcher selectorMatcher = hu.bme.mit.massif.models.simulink.util.BusSelector.Matcher
				.on(mapper.getEngine());
		final Map<BusSignalMapping, OutPort> mappings = Maps.newHashMap();
		selectorMatcher.forEachMatch(match -> {
			BusSelector pSelector = match.getSelector();
			mapper.logDebug("Removing mappings from " + mapper.getFQNOrEmpty((SimulinkElement) pSelector));
			(pSelector).setBusCreator(null);
			for (BusSignalMapping mapping : (pSelector).getMappings()) {
				if (mapping.getMappingFrom() != null) {
					mappings.put(mapping, mapping.getMappingFrom());
				}
				mapping.setMappingFrom(null);
			}

		});

		selectorMatcher.forEachMatch(match -> {
			BusSelector pSelector = match.getSelector();
			mapper.logDebug("==========");
			mapper.logDebug("Testing mapping creator on: " + mapper.getFQNOrEmpty((SimulinkElement) pSelector));
			((BusSelector) pSelector).setBusCreator(null);
			for (BusSignalMapping mapping : ((BusSelector) pSelector).getMappings()) {
				mapping.setMappingFrom(null);
			}
			new BusSignalMappingCreator(mapper).createBusMapping((BusSelector) pSelector);
			boolean hasComplete = false;
			if (!includesIncomplete) {
				for (BusSignalMapping mapping : ((BusSelector) pSelector).getMappings()) {
					assertEquals(mappings.get(mapping), mapping.getMappingFrom());
					hasComplete = true;
				}
			} else {
				for (BusSignalMapping mapping : ((BusSelector) pSelector).getMappings()) {
					assertTrue(mapping.getMappingFrom() != null);
					OutPort outPort = mappings.get(mapping);
					if (outPort != null) {
						assertTrue(mapping.getMappingFrom().equals(outPort));
					}
					hasComplete = hasComplete || !mapping.isIncomplete();
				}
			}
			if (hasComplete) {
				assertTrue(((BusSelector) pSelector).getBusCreator() != null);
			}
			mapper.logDebug("==========");

		});
	}

}
