package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.models.simulink.viewer.BlockPortsMatch;
import hu.bme.mit.transima.models.simulink.viewer.util.BlockPortsQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.viewer.blockPorts pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BlockPortsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern blockPorts(block, port) {
 * 	Block.ports(block,port);
 * }
 * </pre></code>
 * 
 * @see BlockPortsMatch
 * @see BlockPortsProcessor
 * @see BlockPortsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BlockPortsMatcher extends BaseMatcher<BlockPortsMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BlockPortsMatcher> querySpecification() throws IncQueryException {
    return BlockPortsQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BlockPortsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BlockPortsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BlockPortsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BLOCK = 0;
  
  private final static int POSITION_PORT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BlockPortsMatcher.class);
  
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
  public BlockPortsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BlockPortsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return matches represented as a BlockPortsMatch object.
   * 
   */
  public Collection<BlockPortsMatch> getAllMatches(final Block pBlock, final Port pPort) {
    return rawGetAllMatches(new Object[]{pBlock, pPort});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return a match represented as a BlockPortsMatch object, or null if no match is found.
   * 
   */
  public BlockPortsMatch getOneArbitraryMatch(final Block pBlock, final Port pPort) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock, pPort});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Block pBlock, final Port pPort) {
    return rawHasMatch(new Object[]{pBlock, pPort});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Block pBlock, final Port pPort) {
    return rawCountMatches(new Object[]{pBlock, pPort});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Block pBlock, final Port pPort, final IMatchProcessor<? super BlockPortsMatch> processor) {
    rawForEachMatch(new Object[]{pBlock, pPort}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Block pBlock, final Port pPort, final IMatchProcessor<? super BlockPortsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock, pPort}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<BlockPortsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Block pBlock, final Port pPort) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pBlock, pPort});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BlockPortsMatch newMatch(final Block pBlock, final Port pPort) {
    return BlockPortsMatch.newMatch(pBlock, pPort);
    
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
  public Set<Block> getAllValuesOfblock(final BlockPortsMatch partialMatch) {
    return rawAccumulateAllValuesOfblock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfblock(final Port pPort) {
    return rawAccumulateAllValuesOfblock(new Object[]{null, pPort});
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
  public Set<Port> getAllValuesOfport(final BlockPortsMatch partialMatch) {
    return rawAccumulateAllValuesOfport(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for port.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Port> getAllValuesOfport(final Block pBlock) {
    return rawAccumulateAllValuesOfport(new Object[]{pBlock, null});
  }
  
  @Override
  protected BlockPortsMatch tupleToMatch(final Tuple t) {
    try {
      return BlockPortsMatch.newMatch((hu.bme.mit.transima.Simulink.Block) t.get(POSITION_BLOCK), (hu.bme.mit.transima.Simulink.Port) t.get(POSITION_PORT));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BlockPortsMatch arrayToMatch(final Object[] match) {
    try {
      return BlockPortsMatch.newMatch((hu.bme.mit.transima.Simulink.Block) match[POSITION_BLOCK], (hu.bme.mit.transima.Simulink.Port) match[POSITION_PORT]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BlockPortsMatch arrayToMatchMutable(final Object[] match) {
    try {
      return BlockPortsMatch.newMutableMatch((hu.bme.mit.transima.Simulink.Block) match[POSITION_BLOCK], (hu.bme.mit.transima.Simulink.Port) match[POSITION_PORT]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
