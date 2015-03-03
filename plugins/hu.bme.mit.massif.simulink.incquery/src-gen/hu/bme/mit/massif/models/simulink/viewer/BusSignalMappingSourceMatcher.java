package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.BusSignalMappingSourceMatch;
import hu.bme.mit.massif.models.simulink.viewer.util.BusSignalMappingSourceQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusSelector;
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
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.viewer.busSignalMappingSource pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BusSignalMappingSourceMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Edge(source = busSelector, target = from, label = "[$name$ -{@literal >} $toName$]")
 * {@literal @}Format(lineColor = "#228B22", lineStyle = "dotted")
 * {@literal @}QueryExplorer(display=true)
 * pattern busSignalMappingSource(busSelector, from, name, toName) {
 * 	find busMappingInSelector(busSelector, _mapping, fromOP, to);
 * 	find hierarchyConnectionEnd(fromOP,from);
 * 	find portConnection(fromOP, _inP, fromPC);
 * 	find portConnection(to, _toP, toPC);
 * 	find nonNullLineName(fromPC, name);
 * 	find nonNullLineName(toPC, toName);
 * }
 * </pre></code>
 * 
 * @see BusSignalMappingSourceMatch
 * @see BusSignalMappingSourceProcessor
 * @see BusSignalMappingSourceQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BusSignalMappingSourceMatcher extends BaseMatcher<BusSignalMappingSourceMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BusSignalMappingSourceMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BusSignalMappingSourceMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BusSignalMappingSourceMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BUSSELECTOR = 0;
  
  private final static int POSITION_FROM = 1;
  
  private final static int POSITION_NAME = 2;
  
  private final static int POSITION_TONAME = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BusSignalMappingSourceMatcher.class);
  
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
  public BusSignalMappingSourceMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BusSignalMappingSourceMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @return matches represented as a BusSignalMappingSourceMatch object.
   * 
   */
  public Collection<BusSignalMappingSourceMatch> getAllMatches(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    return rawGetAllMatches(new Object[]{pBusSelector, pFrom, pName, pToName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @return a match represented as a BusSignalMappingSourceMatch object, or null if no match is found.
   * 
   */
  public BusSignalMappingSourceMatch getOneArbitraryMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    return rawGetOneArbitraryMatch(new Object[]{pBusSelector, pFrom, pName, pToName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    return rawHasMatch(new Object[]{pBusSelector, pFrom, pName, pToName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    return rawCountMatches(new Object[]{pBusSelector, pFrom, pName, pToName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName, final IMatchProcessor<? super BusSignalMappingSourceMatch> processor) {
    rawForEachMatch(new Object[]{pBusSelector, pFrom, pName, pToName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName, final IMatchProcessor<? super BusSignalMappingSourceMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBusSelector, pFrom, pName, pToName}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BusSignalMappingSourceMatch newMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    return BusSignalMappingSourceMatch.newMatch(pBusSelector, pFrom, pName, pToName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for busSelector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BusSelector> rawAccumulateAllValuesOfbusSelector(final Object[] parameters) {
    Set<BusSelector> results = new HashSet<BusSelector>();
    rawAccumulateAllValues(POSITION_BUSSELECTOR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for busSelector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSelector> getAllValuesOfbusSelector() {
    return rawAccumulateAllValuesOfbusSelector(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for busSelector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSelector> getAllValuesOfbusSelector(final BusSignalMappingSourceMatch partialMatch) {
    return rawAccumulateAllValuesOfbusSelector(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for busSelector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSelector> getAllValuesOfbusSelector(final Block pFrom, final String pName, final String pToName) {
    return rawAccumulateAllValuesOfbusSelector(new Object[]{
    null, 
    pFrom, 
    pName, 
    pToName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for from.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Block> rawAccumulateAllValuesOffrom(final Object[] parameters) {
    Set<Block> results = new HashSet<Block>();
    rawAccumulateAllValues(POSITION_FROM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for from.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOffrom() {
    return rawAccumulateAllValuesOffrom(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for from.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOffrom(final BusSignalMappingSourceMatch partialMatch) {
    return rawAccumulateAllValuesOffrom(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for from.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOffrom(final BusSelector pBusSelector, final String pName, final String pToName) {
    return rawAccumulateAllValuesOffrom(new Object[]{
    pBusSelector, 
    null, 
    pName, 
    pToName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final BusSignalMappingSourceMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final BusSelector pBusSelector, final Block pFrom, final String pToName) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pBusSelector, 
    pFrom, 
    null, 
    pToName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for toName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOftoName(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_TONAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for toName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftoName() {
    return rawAccumulateAllValuesOftoName(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for toName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftoName(final BusSignalMappingSourceMatch partialMatch) {
    return rawAccumulateAllValuesOftoName(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for toName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftoName(final BusSelector pBusSelector, final Block pFrom, final String pName) {
    return rawAccumulateAllValuesOftoName(new Object[]{
    pBusSelector, 
    pFrom, 
    pName, 
    null
    });
  }
  
  @Override
  protected BusSignalMappingSourceMatch tupleToMatch(final Tuple t) {
    try {
    	return BusSignalMappingSourceMatch.newMatch((hu.bme.mit.massif.simulink.BusSelector) t.get(POSITION_BUSSELECTOR), (hu.bme.mit.massif.simulink.Block) t.get(POSITION_FROM), (java.lang.String) t.get(POSITION_NAME), (java.lang.String) t.get(POSITION_TONAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected BusSignalMappingSourceMatch arrayToMatch(final Object[] match) {
    try {
    	return BusSignalMappingSourceMatch.newMatch((hu.bme.mit.massif.simulink.BusSelector) match[POSITION_BUSSELECTOR], (hu.bme.mit.massif.simulink.Block) match[POSITION_FROM], (java.lang.String) match[POSITION_NAME], (java.lang.String) match[POSITION_TONAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected BusSignalMappingSourceMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return BusSignalMappingSourceMatch.newMutableMatch((hu.bme.mit.massif.simulink.BusSelector) match[POSITION_BUSSELECTOR], (hu.bme.mit.massif.simulink.Block) match[POSITION_FROM], (java.lang.String) match[POSITION_NAME], (java.lang.String) match[POSITION_TONAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BusSignalMappingSourceMatcher> querySpecification() throws IncQueryException {
    return BusSignalMappingSourceQuerySpecification.instance();
  }
}
