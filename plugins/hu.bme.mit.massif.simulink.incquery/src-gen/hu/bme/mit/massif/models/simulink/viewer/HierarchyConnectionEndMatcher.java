package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.HierarchyConnectionEndMatch;
import hu.bme.mit.massif.models.simulink.viewer.util.HierarchyConnectionEndQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Port;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.viewer.hierarchyConnectionEnd pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link HierarchyConnectionEndMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern hierarchyConnectionEnd(port, block){
 * 	find portOfPortBlock(port, block);
 * } or {
 * 	find portOfSimpleBlock(port, block);
 * }
 * </pre></code>
 * 
 * @see HierarchyConnectionEndMatch
 * @see HierarchyConnectionEndProcessor
 * @see HierarchyConnectionEndQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class HierarchyConnectionEndMatcher extends BaseMatcher<HierarchyConnectionEndMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<HierarchyConnectionEndMatcher> querySpecification() throws IncQueryException {
    return HierarchyConnectionEndQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static HierarchyConnectionEndMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    HierarchyConnectionEndMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new HierarchyConnectionEndMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PORT = 0;
  
  private final static int POSITION_BLOCK = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(HierarchyConnectionEndMatcher.class);
  
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
  public HierarchyConnectionEndMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public HierarchyConnectionEndMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return matches represented as a HierarchyConnectionEndMatch object.
   * 
   */
  public Collection<HierarchyConnectionEndMatch> getAllMatches(final Port pPort, final Block pBlock) {
    return rawGetAllMatches(new Object[]{pPort, pBlock});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return a match represented as a HierarchyConnectionEndMatch object, or null if no match is found.
   * 
   */
  public HierarchyConnectionEndMatch getOneArbitraryMatch(final Port pPort, final Block pBlock) {
    return rawGetOneArbitraryMatch(new Object[]{pPort, pBlock});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Port pPort, final Block pBlock) {
    return rawHasMatch(new Object[]{pPort, pBlock});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Port pPort, final Block pBlock) {
    return rawCountMatches(new Object[]{pPort, pBlock});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Port pPort, final Block pBlock, final IMatchProcessor<? super HierarchyConnectionEndMatch> processor) {
    rawForEachMatch(new Object[]{pPort, pBlock}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Port pPort, final Block pBlock, final IMatchProcessor<? super HierarchyConnectionEndMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPort, pBlock}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<HierarchyConnectionEndMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Port pPort, final Block pBlock) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pPort, pBlock});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public HierarchyConnectionEndMatch newMatch(final Port pPort, final Block pBlock) {
    return HierarchyConnectionEndMatch.newMatch(pPort, pBlock);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for port.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Port> rawAccumulateAllValuesOfport(final Object[] parameters) {
    Set<Port> results = new HashSet<Port>();
    rawAccumulateAllValues(POSITION_PORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for port.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Port> getAllValuesOfport() {
    return rawAccumulateAllValuesOfport(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for port.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Port> getAllValuesOfport(final HierarchyConnectionEndMatch partialMatch) {
    return rawAccumulateAllValuesOfport(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for port.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Port> getAllValuesOfport(final Block pBlock) {
    return rawAccumulateAllValuesOfport(new Object[]{null, pBlock});
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Block> rawAccumulateAllValuesOfblock(final Object[] parameters) {
    Set<Block> results = new HashSet<Block>();
    rawAccumulateAllValues(POSITION_BLOCK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfblock() {
    return rawAccumulateAllValuesOfblock(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfblock(final HierarchyConnectionEndMatch partialMatch) {
    return rawAccumulateAllValuesOfblock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfblock(final Port pPort) {
    return rawAccumulateAllValuesOfblock(new Object[]{pPort, null});
  }
  
  @Override
  protected HierarchyConnectionEndMatch tupleToMatch(final Tuple t) {
    try {
      return HierarchyConnectionEndMatch.newMatch((hu.bme.mit.massif.simulink.Port) t.get(POSITION_PORT), (hu.bme.mit.massif.simulink.Block) t.get(POSITION_BLOCK));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected HierarchyConnectionEndMatch arrayToMatch(final Object[] match) {
    try {
      return HierarchyConnectionEndMatch.newMatch((hu.bme.mit.massif.simulink.Port) match[POSITION_PORT], (hu.bme.mit.massif.simulink.Block) match[POSITION_BLOCK]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected HierarchyConnectionEndMatch arrayToMatchMutable(final Object[] match) {
    try {
      return HierarchyConnectionEndMatch.newMutableMatch((hu.bme.mit.massif.simulink.Port) match[POSITION_PORT], (hu.bme.mit.massif.simulink.Block) match[POSITION_BLOCK]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
