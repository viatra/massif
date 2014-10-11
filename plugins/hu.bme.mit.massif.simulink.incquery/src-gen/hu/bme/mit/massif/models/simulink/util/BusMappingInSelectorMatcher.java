package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.BusMappingInSelectorMatch;
import hu.bme.mit.massif.models.simulink.util.util.BusMappingInSelectorQuerySpecification;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.OutPort;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.busMappingInSelector pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BusMappingInSelectorMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern busMappingInSelector(selector, mapping, mappingFrom, mappingTo) {
 * 	BusSelector.mappings(selector, mapping);
 * 	BusSignalMapping.mappingFrom(mapping, mappingFrom);
 * 	BusSignalMapping.mappingTo(mapping, mappingTo);
 * }
 * </pre></code>
 * 
 * @see BusMappingInSelectorMatch
 * @see BusMappingInSelectorProcessor
 * @see BusMappingInSelectorQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BusMappingInSelectorMatcher extends BaseMatcher<BusMappingInSelectorMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BusMappingInSelectorMatcher> querySpecification() throws IncQueryException {
    return BusMappingInSelectorQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BusMappingInSelectorMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BusMappingInSelectorMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BusMappingInSelectorMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SELECTOR = 0;
  
  private final static int POSITION_MAPPING = 1;
  
  private final static int POSITION_MAPPINGFROM = 2;
  
  private final static int POSITION_MAPPINGTO = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BusMappingInSelectorMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public BusMappingInSelectorMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public BusMappingInSelectorMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return matches represented as a BusMappingInSelectorMatch object.
   * 
   */
  public Collection<BusMappingInSelectorMatch> getAllMatches(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return rawGetAllMatches(new Object[]{pSelector, pMapping, pMappingFrom, pMappingTo});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return a match represented as a BusMappingInSelectorMatch object, or null if no match is found.
   * 
   */
  public BusMappingInSelectorMatch getOneArbitraryMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return rawGetOneArbitraryMatch(new Object[]{pSelector, pMapping, pMappingFrom, pMappingTo});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return rawHasMatch(new Object[]{pSelector, pMapping, pMappingFrom, pMappingTo});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return rawCountMatches(new Object[]{pSelector, pMapping, pMappingFrom, pMappingTo});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo, final IMatchProcessor<? super BusMappingInSelectorMatch> processor) {
    rawForEachMatch(new Object[]{pSelector, pMapping, pMappingFrom, pMappingTo}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo, final IMatchProcessor<? super BusMappingInSelectorMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSelector, pMapping, pMappingFrom, pMappingTo}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<BusMappingInSelectorMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSelector, pMapping, pMappingFrom, pMappingTo});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BusMappingInSelectorMatch newMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return BusMappingInSelectorMatch.newMatch(pSelector, pMapping, pMappingFrom, pMappingTo);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for selector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BusSelector> rawAccumulateAllValuesOfselector(final Object[] parameters) {
    Set<BusSelector> results = new HashSet<BusSelector>();
    rawAccumulateAllValues(POSITION_SELECTOR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for selector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSelector> getAllValuesOfselector() {
    return rawAccumulateAllValuesOfselector(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for selector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSelector> getAllValuesOfselector(final BusMappingInSelectorMatch partialMatch) {
    return rawAccumulateAllValuesOfselector(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for selector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSelector> getAllValuesOfselector(final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return rawAccumulateAllValuesOfselector(new Object[]{null, pMapping, pMappingFrom, pMappingTo});
  }
  
  /**
   * Retrieve the set of values that occur in matches for mapping.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BusSignalMapping> rawAccumulateAllValuesOfmapping(final Object[] parameters) {
    Set<BusSignalMapping> results = new HashSet<BusSignalMapping>();
    rawAccumulateAllValues(POSITION_MAPPING, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for mapping.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSignalMapping> getAllValuesOfmapping() {
    return rawAccumulateAllValuesOfmapping(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mapping.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSignalMapping> getAllValuesOfmapping(final BusMappingInSelectorMatch partialMatch) {
    return rawAccumulateAllValuesOfmapping(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mapping.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSignalMapping> getAllValuesOfmapping(final BusSelector pSelector, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return rawAccumulateAllValuesOfmapping(new Object[]{pSelector, null, pMappingFrom, pMappingTo});
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingFrom.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfmappingFrom(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_MAPPINGFROM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingFrom.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfmappingFrom() {
    return rawAccumulateAllValuesOfmappingFrom(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingFrom.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfmappingFrom(final BusMappingInSelectorMatch partialMatch) {
    return rawAccumulateAllValuesOfmappingFrom(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingFrom.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfmappingFrom(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingTo) {
    return rawAccumulateAllValuesOfmappingFrom(new Object[]{pSelector, pMapping, null, pMappingTo});
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfmappingTo(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_MAPPINGTO, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfmappingTo() {
    return rawAccumulateAllValuesOfmappingTo(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfmappingTo(final BusMappingInSelectorMatch partialMatch) {
    return rawAccumulateAllValuesOfmappingTo(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mappingTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfmappingTo(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom) {
    return rawAccumulateAllValuesOfmappingTo(new Object[]{pSelector, pMapping, pMappingFrom, null});
  }
  
  @Override
  protected BusMappingInSelectorMatch tupleToMatch(final Tuple t) {
    try {
      return BusMappingInSelectorMatch.newMatch((hu.bme.mit.massif.simulink.BusSelector) t.get(POSITION_SELECTOR), (hu.bme.mit.massif.simulink.BusSignalMapping) t.get(POSITION_MAPPING), (hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_MAPPINGFROM), (hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_MAPPINGTO));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BusMappingInSelectorMatch arrayToMatch(final Object[] match) {
    try {
      return BusMappingInSelectorMatch.newMatch((hu.bme.mit.massif.simulink.BusSelector) match[POSITION_SELECTOR], (hu.bme.mit.massif.simulink.BusSignalMapping) match[POSITION_MAPPING], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_MAPPINGFROM], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_MAPPINGTO]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BusMappingInSelectorMatch arrayToMatchMutable(final Object[] match) {
    try {
      return BusMappingInSelectorMatch.newMutableMatch((hu.bme.mit.massif.simulink.BusSelector) match[POSITION_SELECTOR], (hu.bme.mit.massif.simulink.BusSignalMapping) match[POSITION_MAPPING], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_MAPPINGFROM], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_MAPPINGTO]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
