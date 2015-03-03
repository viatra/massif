package hu.bme.mit.massif.models.simulink.derived;

import hu.bme.mit.massif.models.simulink.derived.EnablerMatch;
import hu.bme.mit.massif.models.simulink.derived.util.EnablerQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Enable;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.derived.enabler pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link EnablerMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryBasedFeature
 * pattern enabler(Block: Block, Enabler : Enable) = {
 * 	Block.ports(Block,Enabler);
 * }
 * </pre></code>
 * 
 * @see EnablerMatch
 * @see EnablerProcessor
 * @see EnablerQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class EnablerMatcher extends BaseMatcher<EnablerMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static EnablerMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    EnablerMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new EnablerMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BLOCK = 0;
  
  private final static int POSITION_ENABLER = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(EnablerMatcher.class);
  
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
  public EnablerMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public EnablerMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @return matches represented as a EnablerMatch object.
   * 
   */
  public Collection<EnablerMatch> getAllMatches(final Block pBlock, final Enable pEnabler) {
    return rawGetAllMatches(new Object[]{pBlock, pEnabler});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @return a match represented as a EnablerMatch object, or null if no match is found.
   * 
   */
  public EnablerMatch getOneArbitraryMatch(final Block pBlock, final Enable pEnabler) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock, pEnabler});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Block pBlock, final Enable pEnabler) {
    return rawHasMatch(new Object[]{pBlock, pEnabler});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Block pBlock, final Enable pEnabler) {
    return rawCountMatches(new Object[]{pBlock, pEnabler});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Block pBlock, final Enable pEnabler, final IMatchProcessor<? super EnablerMatch> processor) {
    rawForEachMatch(new Object[]{pBlock, pEnabler}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Block pBlock, final Enable pEnabler, final IMatchProcessor<? super EnablerMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock, pEnabler}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EnablerMatch newMatch(final Block pBlock, final Enable pEnabler) {
    return EnablerMatch.newMatch(pBlock, pEnabler);
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
  public Set<Block> getAllValuesOfBlock(final EnablerMatch partialMatch) {
    return rawAccumulateAllValuesOfBlock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Block.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfBlock(final Enable pEnabler) {
    return rawAccumulateAllValuesOfBlock(new Object[]{
    null, 
    pEnabler
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for Enabler.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Enable> rawAccumulateAllValuesOfEnabler(final Object[] parameters) {
    Set<Enable> results = new HashSet<Enable>();
    rawAccumulateAllValues(POSITION_ENABLER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Enabler.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Enable> getAllValuesOfEnabler() {
    return rawAccumulateAllValuesOfEnabler(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Enabler.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Enable> getAllValuesOfEnabler(final EnablerMatch partialMatch) {
    return rawAccumulateAllValuesOfEnabler(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Enabler.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Enable> getAllValuesOfEnabler(final Block pBlock) {
    return rawAccumulateAllValuesOfEnabler(new Object[]{
    pBlock, 
    null
    });
  }
  
  @Override
  protected EnablerMatch tupleToMatch(final Tuple t) {
    try {
    	return EnablerMatch.newMatch((hu.bme.mit.massif.simulink.Block) t.get(POSITION_BLOCK), (hu.bme.mit.massif.simulink.Enable) t.get(POSITION_ENABLER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EnablerMatch arrayToMatch(final Object[] match) {
    try {
    	return EnablerMatch.newMatch((hu.bme.mit.massif.simulink.Block) match[POSITION_BLOCK], (hu.bme.mit.massif.simulink.Enable) match[POSITION_ENABLER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EnablerMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return EnablerMatch.newMutableMatch((hu.bme.mit.massif.simulink.Block) match[POSITION_BLOCK], (hu.bme.mit.massif.simulink.Enable) match[POSITION_ENABLER]);
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
  public static IQuerySpecification<EnablerMatcher> querySpecification() throws IncQueryException {
    return EnablerQuerySpecification.instance();
  }
}
