/**
 * 
 */
package hu.bme.mit.massif.simulink.api.util.bus;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import hu.bme.mit.massif.models.simulink.util.FirstOutPortFromBusSpecificationMatch;
import hu.bme.mit.massif.simulink.BusCreator;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.BusSpecification;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 
 * @author Abel Hegedus
 * 
 */
public class BusSignalMappingCreator {

    private static final String DOT_REGEXP = Pattern.quote(".");
    private BusSignalMapper mapper;

    public BusSignalMappingCreator(BusSignalMapper mapper) {
        this.mapper = mapper;
    }

    public void createBusMapping(BusSelector selector) {
        checkSelectorBeforeMapping(selector);
        String selectorFQN = mapper.getFQNOrEmpty(selector);
        mapper.logDebug("Create bus mapping called for %s", selectorFQN);
        if (selector.getBusCreator() == null) {
            findCreatorAndCreateBusMapping(selector);
        } else {
            // reentrant request, do nothing
            mapper.logDebug("Selector mappings of %s are already set", selectorFQN);
        }
    }

    private void checkSelectorBeforeMapping(BusSelector selector) {
        checkArgument(selector != null, "Selector cannot be null!");
        BusSpecification creator = selector.getBusCreator();
        EList<BusSignalMapping> mappings = selector.getMappings();
        checkArgument(selector.getOutports().size() <= mappings.size(), "Mappings of %s selector are incomplete!",
                selector);
        for (BusSignalMapping mapping : mappings) {
            checkState(!Strings.isNullOrEmpty(mapping.getMappingPath()),
                    "Mapping path of mapping %s cannot be null or empty!", mapping);
            if (creator != null) {
                checkState(mapping.getMappingFrom() != null, "Mapping %s is incomplete, FROM outport not set!", mapping);
            }
            checkState(mapping.getMappingTo() != null, "Mapping %s is incomplete, TO outport not set!", mapping);
            checkState(selector.getOutports().contains(mapping.getMappingTo()),
                    "TO outport of mapping %s is not outport of selector!", mapping);
        }
    }

    private void findCreatorAndCreateBusMapping(BusSelector selector) {
        SpecifiableOriginatingOutPort origin = findBusCreatorOfIncomigBus(selector);
        if (origin.specification == null) {
            handleIncompleteMappings(origin.outPort, selector.getMappings());
        } else {
            createBusMappingUsingCreator(selector, origin.specification);
        }
        mapper.logDebug("Created bus mapping for %s", mapper.getFQNOrEmpty(selector));
    }

    private SpecifiableOriginatingOutPort findBusCreatorOfIncomigBus(BusSelector selector) {
        SpecifiableOriginatingOutPort origin = getOriginatingOutPortForBusSelector(selector);
        BusSpecification previousSpec = origin.specification;
        if (previousSpec != null) {
            origin = findBusCreatorForOriginatingBusSpecification(origin);
        }
        return origin;
    }

    private SpecifiableOriginatingOutPort getOriginatingOutPortForBusSelector(BusSelector selector) {
        // outport before bus selector is always determined, setting not required
        SpecifiableOriginatingOutPort result = getOriginatingOutPortForBusSpecfication(selector, null);
        return result;
    }

    private SpecifiableOriginatingOutPort getOriginatingOutPortForBusSpecfication(BusSpecification specification, OutPort outPort) {
        OutPort firstOutPort = findOriginatingOutPortForSpecification(specification, outPort);
        BusSpecification prevSpec = null;
        if (firstOutPort.getContainer() instanceof BusSpecification) {
            prevSpec = (BusSpecification) firstOutPort.getContainer();
        }
        SpecifiableOriginatingOutPort result = new SpecifiableOriginatingOutPort(prevSpec, firstOutPort);
        return result;
    }

    private OutPort findOriginatingOutPortForSpecification(BusSpecification specification,
            OutPort outPortBeforeSpecification) {
        Collection<FirstOutPortFromBusSpecificationMatch> matches = mapper.getFirstOutPortFromBusSpecificationMatcher()
                .getAllMatches(null, specification, outPortBeforeSpecification);
        checkState(matches.size() == 1, "Invalid model, backward navigation is not deterministic!");
        FirstOutPortFromBusSpecificationMatch match = Iterables.getOnlyElement(matches);
        OutPort firstOutPort = (OutPort) match.getOutPort();
        return firstOutPort;
    }

    private SpecifiableOriginatingOutPort findBusCreatorForOriginatingBusSpecification(SpecifiableOriginatingOutPort origin) {
        BusSpecification busSpecification = origin.specification;
        OutPort previousSpecOutPort = origin.outPort;

        SpecifiableOriginatingOutPort creator = null;
        if (busSpecification instanceof BusSelector) {
            BusSelector previousBusSelector = (BusSelector) busSpecification;
            if (previousBusSelector.getBusCreator() == null) {
                // not set -> push current exploration to "stack" and create bus mapping of previous selector
                createBusMapping(previousBusSelector);
            }
            creator = findBusCreatorThroughBusSelector(busSpecification, previousSpecOutPort, previousBusSelector);
        } else if (busSpecification instanceof BusCreator) {
            creator = new SpecifiableOriginatingOutPort(busSpecification, previousSpecOutPort);
        } else {
            throw new IllegalStateException(
                    "Previous bus specification cannot be other type of elements! But encountered: " + busSpecification);
        }
        BusSpecification specification = creator.specification;
        mapper.logDebug(String.format("Creator of bus is %s", mapper.getFQNOrEmpty(specification)));
        return creator;
    }

    private SpecifiableOriginatingOutPort findBusCreatorThroughBusSelector(BusSpecification busSpecification,
            OutPort previousSpecOutPort, BusSelector previousBusSelector) {
        SpecifiableOriginatingOutPort creator = null;
        if (previousBusSelector.isOutputAsBus()) {
            creator = new SpecifiableOriginatingOutPort(busSpecification, previousSpecOutPort);
        } else {
            // bus creator set and mappings done -> use mapping to find corresponding outport and continue
            for (BusSignalMapping m : previousBusSelector.getMappings()) {
                if (previousSpecOutPort.equals(m.getMappingTo())) {
                    OutPort mappingFrom = m.getMappingFrom();
                    // go backwards
                    creator = findBusCreatorOfBusSignal(previousBusSelector.getBusCreator(), mappingFrom);
                }
            }
        }
        return creator;
    }

    private SpecifiableOriginatingOutPort findBusCreatorOfBusSignal(BusSpecification creator, OutPort outPort) {
        SpecifiableOriginatingOutPort origin = getOriginatingOutPortForBusSpecfication(creator, outPort);
        if (origin.specification != null) {
            origin = findBusCreatorForOriginatingBusSpecification(origin);
        }
        return origin;
    }

    private void handleIncompleteMappings(OutPort firstOutPort, Iterable<BusSignalMapping> mappings) {
        for (BusSignalMapping busSignalMapping : mappings) {
            busSignalMapping.setIncomplete(true);
            busSignalMapping.setMappingFrom(firstOutPort);
            mapper.logDebug("Setting incomplete mapping: %s, port: %s", busSignalMapping.getMappingPath(),
                    mapper.getFQNOrEmpty(firstOutPort));
        }
    }

    private void createBusMappingUsingCreator(BusSelector selector, BusSpecification creator) {
        Map<String, FragmentResolution> fragmentResolutionMap = initializeFragmentResolutionMap(selector);
        resolveMappingsInFragmentResolutionMap(creator, fragmentResolutionMap);
        selector.setBusCreator(creator);
    }

    private Map<String, FragmentResolution> initializeFragmentResolutionMap(BusSelector selector) {
        Map<String, FragmentResolution> resolutionMap = Maps.newHashMap();
        for (BusSignalMapping mapping : selector.getMappings()) {
            // find mappingFrom for each mapping by path
            String mappingPath = mapping.getMappingPath();
            OutPort mappingTo = mapping.getMappingTo();
            List<String> fragments = splitPathToFragments(mappingPath);
            mapper.logDebug("Storing fragments: %s, port: %s", fragments, mapper.getFQNOrEmpty(mappingTo));
            storeFragmentsInMap(resolutionMap, mapping, mappingTo, fragments);
        }
        return resolutionMap;
    }

    private List<String> splitPathToFragments(String mappingPath) {
        // split path by dot, could be new StringTokenizer(mappingPath,".");
        List<String> fragments = Lists.newArrayList(mappingPath.split(DOT_REGEXP));
        return fragments;
    }

    private void storeFragmentsInMap(Map<String, FragmentResolution> resolutionMap, BusSignalMapping mapping,
            OutPort outPort, List<String> fragments) {
        // first fragment identifies common mappings
        String firstFrag = fragments.remove(0);
        FragmentResolution fragStore = resolutionMap.get(firstFrag);
        if (fragStore == null) {
            fragStore = new FragmentResolution(outPort);
            resolutionMap.put(firstFrag, fragStore);
        }
        // put rest of fragments with mapping to track resolution
        fragStore.fragmentMap.put(mapping, fragments);
    }

    private void resolveMappingsInFragmentResolutionMap(BusSpecification creator,
            Map<String, FragmentResolution> resolutionMap) {
        updateResolutionMapForFirstSegments(creator, resolutionMap);
        for (FragmentResolution store : resolutionMap.values()) {
            findOutPortForMappings(creator, store);
        }
    }

    private void updateResolutionMapForFirstSegments(BusSpecification specification, Map<String, FragmentResolution> resolutionMap) {
        if (specification instanceof BusCreator) {
            // incoming line names are used
            for (InPort inportOfCreator : specification.getInports()) {
                String collisionFreeLineName = mapper.getCollisionFreeLineName(inportOfCreator);
                OutPort connectedOutPort = mapper.getConnectedOutPort(inportOfCreator);
                setOutPortInResolutionMap(resolutionMap, collisionFreeLineName, connectedOutPort, false);
            }
        } else if (specification instanceof BusSelector) {
            BusSelector busSelector = (BusSelector) specification;
            // use mapping (tricky): find outport, look at name, etc.
            // we know that signals with the same name are not allowed to be selected into a bus
            Set<String> names = Sets.newHashSet();
            for (BusSignalMapping mapping : busSelector.getMappings()) {
                List<String> fragments = splitPathToFragments(mapping.getMappingPath());
                String lastFrag = Iterables.getLast(fragments);
                checkState(!names.contains(lastFrag), "Duplicate signal %s name in bus selector", lastFrag);
                names.add(lastFrag);
                setOutPortInResolutionMap(resolutionMap, lastFrag, mapping.getMappingFrom(), mapping.isIncomplete());
            }
        }
    }

    private void setOutPortInResolutionMap(Map<String, FragmentResolution> resolutionMap, String collisionFreeLineName,
            OutPort connectedOutPort, boolean incomplete) {
        FragmentResolution fragStore = resolutionMap.get(collisionFreeLineName);
        if (fragStore != null) {
            fragStore.outPort = connectedOutPort;
            if (incomplete) {
                for (BusSignalMapping mapping : fragStore.fragmentMap.keySet()) {
                    mapping.setIncomplete(true);
                    mapper.logDebug("Setting incomplete mapping: %s, port: %s", mapping.getMappingPath(),
                            mapper.getFQNOrEmpty(connectedOutPort));
                }
            }
            mapper.logDebug("Found outport for fragment %s, port: %s", collisionFreeLineName,
                    mapper.getFQNOrEmpty(connectedOutPort));
        }
    }

    private void findOutPortForMappings(BusSpecification creator, FragmentResolution resolution) {
        OutPort outPort = resolution.outPort;
        Map<String, FragmentResolution> storeMap = resolveNextFragment(resolution, outPort);
        if (!storeMap.isEmpty()) {
            // unresolved mappings need further navigation
            SpecifiableOriginatingOutPort origin = findBusCreatorOfBusSignal(creator, outPort);
            BusSpecification prevBusSpec = origin.specification;
            if (prevBusSpec != null) {
                resolveMappingsInFragmentResolutionMap(prevBusSpec, storeMap);
            } else {
                Iterable<BusSignalMapping> allMappingsInResolutionMap = getAllMappingInResolutionMap(storeMap);
                handleIncompleteMappings(origin.outPort, allMappingsInResolutionMap);
            }
        }
    }

    private Map<String, FragmentResolution> resolveNextFragment(FragmentResolution resolution, OutPort outPort) {
        Map<String, FragmentResolution> storeMap = Maps.newHashMap();
        for (Entry<BusSignalMapping, List<String>> entry : resolution.fragmentMap.entrySet()) {
            List<String> fragments = entry.getValue();
            BusSignalMapping mapping = entry.getKey();
            if (fragments.isEmpty()) {
                mapping.setMappingFrom(outPort);
                mapper.logDebug("Found mapping %s, port: %s", mapping.getMappingPath(), mapper.getFQNOrEmpty(outPort));
            } else {
                storeFragmentsInMap(storeMap, mapping, outPort, fragments);
            }
        }
        return storeMap;
    }

    private Iterable<BusSignalMapping> getAllMappingInResolutionMap(Map<String, FragmentResolution> resolutionMap) {
        Function<FragmentResolution, Set<BusSignalMapping>> resolutionToMappings = new Function<FragmentResolution, Set<BusSignalMapping>>() {
            @Override
            public Set<BusSignalMapping> apply(FragmentResolution input) {
                return input.fragmentMap.keySet();
            }
        };
        Iterable<Set<BusSignalMapping>> resolutionMapToMappings = Iterables.transform(resolutionMap.values(),
                resolutionToMappings);
        Iterable<BusSignalMapping> allMappingsInResolutionMap = Iterables.concat(resolutionMapToMappings);
        return allMappingsInResolutionMap;
    }

    /**
     * Each {@link FragmentResolution} is responsible for storing the partial fragments that have to be resolved with
     * regards to the outport.
     * 
     * @author Abel Hegedus
     * 
     */
    private static class FragmentResolution {

        OutPort outPort;
        Map<BusSignalMapping, List<String>> fragmentMap = Maps.newHashMap();

        public FragmentResolution(OutPort outPort) {
            this.outPort = outPort;
        }
    }

    private static class SpecifiableOriginatingOutPort {

        BusSpecification specification;
        OutPort outPort;

        public SpecifiableOriginatingOutPort(BusSpecification specification, OutPort outPort) {
            this.specification = specification;
            this.outPort = outPort;
        }

    }

}
