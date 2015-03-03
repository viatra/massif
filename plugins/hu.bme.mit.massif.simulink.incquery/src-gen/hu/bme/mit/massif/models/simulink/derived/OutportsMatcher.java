package hu.bme.mit.massif.models.simulink.derived;

import hu.bme.mit.massif.models.simulink.derived.OutportsMatch;
import hu.bme.mit.massif.models.simulink.derived.util.OutportsQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
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
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.derived.outports pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link OutportsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryBasedFeature
 * pattern outports(Block: Block, OutPort : OutPort) = {
 * 	Block.ports(Block,OutPort);
 * }
 * </pre></code>
 * 
 * @see OutportsMatch
 * @see OutportsProcessor
 * @see OutportsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class OutportsMatcher extends BaseMatcher<OutportsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static OutportsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    OutportsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new OutportsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BLOCK = 0;
  
  private final static int POSITION_OUTPORT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(OutportsMatcher.class);
  
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
  public OutportsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public OutportsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @return matches represented as a OutportsMatch object.
   * 
   */
  public Collection<OutportsMatch> getAllMatches(final Block pBlock, final OutPort pOutPort) {
    return rawGetAllMatches(new Object[]{pBlock, pOutPort});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @return a match represented as a OutportsMatch object, or null if no match is found.
   * 
   */
  public OutportsMatch getOneArbitraryMatch(final Block pBlock, final OutPort pOutPort) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock, pOutPort});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Block pBlock, final OutPort pOutPort) {
    return rawHasMatch(new Object[]{pBlock, pOutPort});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Block pBlock, final OutPort pOutPort) {
    return rawCountMatches(new Object[]{pBlock, pOutPort});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Block pBlock, final OutPort pOutPort, final IMatchProcessor<? super OutportsMatch> processor) {
    rawForEachMatch(new Object[]{pBlock, pOutPort}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Block pBlock, final OutPort pOutPort, final IMatchProcessor<? super OutportsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock, pOutPort}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public OutportsMatch newMatch(final Block pBlock, final OutPort pOutPort) {
    return OutportsMatch.newMatch(pBlock, pOutPort);
  }
  
  /**
   * Retrieve the set of values that occur in matches for Block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Block> rawAccumulateAllValuesOfBlock(final Object[] parameters) {
    Set<Block> results = new HashSet<Block>();
    rawAccumulateAllValues(POSITION_BLOCK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfBlock() {
    return rawAccumulateAllValuesOfBlock(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfBlock(final OutportsMatch partialMatch) {
    return rawAccumulateAllValuesOfBlock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfBlock(final OutPort pOutPort) {
    return rawAccumulateAllValuesOfBlock(new Object[]{
    null, 
    pOutPort
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for OutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfOutPort(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_OUTPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for OutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfOutPort() {
    return rawAccumulateAllValuesOfOutPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for OutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfOutPort(final OutportsMatch partialMatch) {
    return rawAccumulateAllValuesOfOutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for OutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfOutPort(final Block pBlock) {
    return rawAccumulateAllValuesOfOutPort(new Object[]{
    pBlock, 
    null
    });
  }
  
  @Override
  protected OutportsMatch tupleToMatch(final Tuple t) {
    try {
    	return OutportsMatch.newMatch((hu.bme.mit.massif.simulink.Block) t.get(POSITION_BLOCK), (hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_OUTPORT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected OutportsMatch arrayToMatch(final Object[] match) {
    try {
    	return OutportsMatch.newMatch((hu.bme.mit.massif.simulink.Block) match[POSITION_BLOCK], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTPORT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected OutportsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return OutportsMatch.newMutableMatch((hu.bme.mit.massif.simulink.Block) match[POSITION_BLOCK], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTPORT]);
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
  public static IQuerySpecification<OutportsMatcher> querySpecification() throws IncQueryException {
    return OutportsQuerySpecification.instance();
  }
}
