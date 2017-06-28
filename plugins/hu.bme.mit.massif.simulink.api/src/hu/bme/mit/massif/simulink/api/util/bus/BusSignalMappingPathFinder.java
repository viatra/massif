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
/**
 * 
 */
package hu.bme.mit.massif.simulink.api.util.bus;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.google.common.collect.Maps;

import hu.bme.mit.massif.models.simulink.util.NextOutPortInPathMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusCreator;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.BusSpecification;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.api.util.DepthFirstSearch;
import hu.bme.mit.massif.simulink.api.util.PathMatcherGraphDataSource;

/**
 * Utility class for computing the mapping path for output signals in a Bus Selector. Given a bus signal mapping, the
 * {@link #findMappingPath(BusSignalMapping)} method returns the string path if the source and target outports are
 * correct.
 * 
 * The class is initialized with a resource set and will work on mappings that are contained by the resource set.
 * 
 * @author Abel Hegedus
 * 
 */
public class BusSignalMappingPathFinder {

    BusSignalMapper mapper;

    /**
     * Creates a path finder for mappings in models.
     * 
     * @param mapper
     */
    public BusSignalMappingPathFinder(BusSignalMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Finds the path string for the given mapping. It first checks that the mapping is correctly set (see
     * {@link #checkMappingArgument(BusSignalMapping, IncQueryEngine)}), then uses depth first search to find signal
     * paths between the from and to outports. Finally, the signal path is traversed to collect the line names that make
     * up the path string.
     * 
     * @param mapping
     *            the bus signal mapping that identifies the outport that is selected.
     * @return the path string that selects the given signal from the bus
     * @throws IllegalArgumentException
     *             if the provided mapping is not correctly set up
     * @throws IllegalStateException
     *             if the path computation finds an inconsistency between the model and the mapping
     */
    public String findMappingPath(BusSignalMapping mapping) {
        checkMappingArgument(mapping, mapper.getEngine());
        OutPort mappingFrom = mapping.getMappingFrom();
        OutPort mappingTo = mapping.getMappingTo();

        mapper.logDebug("[PathFinder] Computing bus signal mapping path from %s to %s",
            mapper.getFQNOrEmpty(mappingFrom), mapper.getFQNOrEmpty(mappingTo));

        List<Deque<Entry<OutPort, InPort>>> paths = findPaths(mappingFrom, mappingTo);

        printPaths(paths);

        List<String> results = new ArrayList<String>();
        for (Deque<Entry<OutPort, InPort>> path : paths) {
            path.removeLast(); // last selector does not alter path
            String mappingStringFromPath = findMappingStringFromPath(mappingTo, path);
            results.add(mappingStringFromPath);
        }

        checkState(!results.isEmpty(), "Could not find mapping path based on outport lists!");
        checkState(results.size() == 1, "Multiple paths found: " + results.toString());

        return results.get(0);
    }

    private void checkMappingArgument(BusSignalMapping mapping, ViatraQueryEngine engine) {
        checkArgument(mapping != null, "Mapping cannot be null!");
        checkArgument(mapping.eResource().getResourceSet() == engine.getScope(),
                "Mapping is not part of correct resource set!");
        checkArgument(mapping.getSelector() != null, "Selector cannot be null in mapping!");
        checkArgument(mapping.getMappingFrom() != null, "From port cannot be null in mapping!");
        checkArgument(mapping.getMappingTo() != null, "To port cannot be null in mapping!");
        checkArgument(mapping.getMappingTo().getContainer() == mapping.getSelector());
    }

    private List<Deque<Entry<OutPort, InPort>>> findPaths(OutPort mappingFrom, OutPort mappingTo) {
        List<Deque<Object>> paths = searchForUnfilteredPaths(mappingFrom, mappingTo);
        checkState(!paths.isEmpty(),
                "Cannot find path between ports " + mapper.getFQNOrEmpty(mappingFrom) + " and " + mapper.getFQNOrEmpty(mappingTo));

        if (mapper.isDebugging()) {
            StringBuilder sb = new StringBuilder();
            for (Deque<Object> linkedList : paths) {
                sb.append("Found unfiltered path:\n");
                for (Object object : linkedList) {
                    sb.append(mapper.getFQNOrEmpty((OutPort) object) + "\n");
                }
            }
            mapper.logDebug(sb.toString());
        }

        List<Deque<Entry<OutPort, InPort>>> filteredPaths = new ArrayList<Deque<Entry<OutPort, InPort>>>();
        for (Deque<Object> path : paths) {
            Deque<Entry<OutPort, InPort>> inPortList = filterPath(mappingFrom, mappingTo, path);
            filteredPaths.add(inPortList);
        }
        return filteredPaths;

    }

    private List<Deque<Object>> searchForUnfilteredPaths(OutPort mappingFrom, OutPort mappingTo) {
        PathMatcherGraphDataSource<NextOutPortInPathMatch> matcherGraphDataSource = new PathMatcherGraphDataSource<NextOutPortInPathMatch>(
                mapper.getNextOutPortInPathMatcher());
        matcherGraphDataSource.setTarget(mappingTo);
        DepthFirstSearch search = new DepthFirstSearch();
        List<Deque<Object>> paths = search.depthFirstSearch(matcherGraphDataSource, mappingFrom, mappingTo);
        return paths;
    }

    private Deque<Entry<OutPort, InPort>> filterPath(OutPort mappingFrom, OutPort mappingTo, Deque<Object> path) {
        Iterator<Object> unfilteredPathIterator = path.iterator();
        if (unfilteredPathIterator.hasNext()) {
            Object firstOutPort = unfilteredPathIterator.next();
            checkState(firstOutPort.equals(mappingFrom),
                "Path does not start from port " + mapper.getFQNOrEmpty(mappingFrom));
        }

        Deque<Entry<OutPort, InPort>> inPortList = new LinkedList<Entry<OutPort, InPort>>();
        filterPathTail(mappingFrom, unfilteredPathIterator, inPortList);
        checkState(!inPortList.isEmpty(), "No bus specification in path between ports " + mapper.getFQNOrEmpty(mappingFrom)
                + " and " + mapper.getFQNOrEmpty(mappingTo));
        return inPortList;
    }

    private void filterPathTail(OutPort mappingFrom, Iterator<Object> unfilteredPathIterator,
        Deque<Entry<OutPort, InPort>> inPortList) {
        OutPort lastOutPort = mappingFrom;
        for (; unfilteredPathIterator.hasNext();) {
            Object object = unfilteredPathIterator.next();
            if (object instanceof OutPort) {
                OutPort nextOutPort = (OutPort) object;
                filterNextConnectionInPath(inPortList, lastOutPort, nextOutPort);
                lastOutPort = nextOutPort;
            }
        }
    }

    private void filterNextConnectionInPath(Deque<Entry<OutPort, InPort>> inPortList, OutPort lastOutPort,
            OutPort nextOutPort) {
        Block outportContainer = nextOutPort.getContainer();
        if (outportContainer instanceof BusSpecification) {
            InPort connectedInPort = findConnectedInPortOnNextContainer(lastOutPort, outportContainer);
            checkState(connectedInPort != null, "Invalid path, last outport is not connected to any inports!");
            inPortList.add(Maps.immutableEntry(lastOutPort, connectedInPort));
        }
    }

    private InPort findConnectedInPortOnNextContainer(OutPort lastOutPort, Block outportContainer) {
        InPort connectedInPort = null;
        for (InPort inPort : outportContainer.getInports()) {
            if (mapper.getConnectedOutPort(inPort).equals(lastOutPort)) {
                checkState(connectedInPort == null, "Multiple inports connected to the same outport!");
                connectedInPort = inPort;
            }
        }
        return connectedInPort;
    }

    private void printPaths(List<Deque<Entry<OutPort, InPort>>> paths) {
        if (mapper.isDebugging()) {
            StringBuilder sb = new StringBuilder();
            for (Deque<Entry<OutPort, InPort>> list : paths) {
                sb.append("Found path:\n");
                for (Entry<OutPort, InPort> entry : list) {
                    sb.append(mapper.getFQNOrEmpty(entry.getKey()) + " to " + mapper.getFQNOrEmpty(entry.getValue()));
                    sb.append(" --- line: " + mapper.getCollisionFreeLineName(entry.getValue()) + "\n");
                }
            }
            mapper.logDebug(sb.toString());
        }
    }

    private String findMappingStringFromPath(OutPort mappingTo, Deque<Entry<OutPort, InPort>> path) {
        PathMappingFragmentStore store = new PathMappingFragmentStore();
        for (Entry<OutPort, InPort> entry : path) {
            processNextPathEntry(entry, store);
        }
        return store.pathBuilder.toString();
    }

    private void processNextPathEntry(Entry<OutPort, InPort> entry, PathMappingFragmentStore store) {
        InPort inport = entry.getValue();
        OutPort outport = entry.getKey();
        String currentFragment = store.pathBuilder.toString();
        store.pathFragments.put(outport, currentFragment);
        mapper.logDebug("Adding fragment: %s for %s", currentFragment, mapper.getFQNOrEmpty(outport));
        String lineName = mapper.getCollisionFreeLineName(inport);
        store.collisionFreeNames.put(outport, lineName);
        Block container = inport.getContainer();
        if (container instanceof BusCreator) {
            // signal will be bundled, append name of incoming line
            appendConnectionName(store.pathBuilder, lineName);
        } else if (container instanceof BusSelector) {
            // find the mapping that corresponds to an outport in pathFragments
            BusSelector busSelector = (BusSelector) container;
            Entry<OutPort, String> fragmentForMapping = findFragmentForMapping(store.pathFragments, busSelector);
            mapper.logDebug("Retrieved fragment: %s for %s", fragmentForMapping.getValue(),
                mapper.getFQNOrEmpty(busSelector));
            store.pathBuilder = new StringBuilder(fragmentForMapping.getValue());
            if (busSelector.isOutputAsBus()) {
                String storedLineName = store.collisionFreeNames.get(fragmentForMapping.getKey());
                checkState(storedLineName != null, "No fragment stored for outport in selector mapping!");
                appendConnectionName(store.pathBuilder, storedLineName);
            }
        } else {
            throw new IllegalStateException("Filtered path cannot include other type of elements! But encountered: "
                    + container);
        }
    }

    private void appendConnectionName(StringBuilder pathBuilder, String lineName) {
        if (pathBuilder.length() > 0) {
            pathBuilder.insert(0, ".");
        }
        pathBuilder.insert(0, lineName);
    }

    private Entry<OutPort, String> findFragmentForMapping(Map<OutPort, String> pathFragments, BusSelector busSelector) {
        for (BusSignalMapping m : busSelector.getMappings()) {
            OutPort from = m.getMappingFrom();
            if (pathFragments.containsKey(from)) {
                // replace current path with stored
                return Maps.immutableEntry(from, pathFragments.get(from));
            }
        }
        // if there is none, the path is invalid (selector selects from farther back)
        throw new IllegalStateException("Cannot find path fragment for mapping in bus selector!");
    }

    private static class PathMappingFragmentStore {

        StringBuilder pathBuilder = new StringBuilder();
        Map<OutPort, String> pathFragments = Maps.newHashMap();
        Map<OutPort, String> collisionFreeNames = Maps.newHashMap();

    }

}
