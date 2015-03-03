package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.BlockMatch;
import hu.bme.mit.massif.models.simulink.viewer.util.BlockQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.viewer.block pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BlockMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * or {
 * 	GotoTagVisibility(bl);
 * }
 * 
 * {@literal @}Item(item = bl, label = "$bl$")
 * {@literal @}Format(color = "#F5F5F5", textColor = "#191970")
 * {@literal @}QueryExplorer(display=true)
 * pattern block(bl) {
 * 	Block(bl);
 * 	neg find ignoredBlock(bl);
 * }
 * </pre></code>
 * 
 * @see BlockMatch
 * @see BlockProcessor
 * @see BlockQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BlockMatcher extends BaseMatcher<BlockMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BlockMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BlockMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BlockMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BL = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BlockMatcher.class);
  
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
  public BlockMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BlockMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return matches represented as a BlockMatch object.
   * 
   */
  public Collection<BlockMatch> getAllMatches(final Block pBl) {
    return rawGetAllMatches(new Object[]{pBl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return a match represented as a BlockMatch object, or null if no match is found.
   * 
   */
  public BlockMatch getOneArbitraryMatch(final Block pBl) {
    return rawGetOneArbitraryMatch(new Object[]{pBl});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Block pBl) {
    return rawHasMatch(new Object[]{pBl});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Block pBl) {
    return rawCountMatches(new Object[]{pBl});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Block pBl, final IMatchProcessor<? super BlockMatch> processor) {
    rawForEachMatch(new Object[]{pBl}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Block pBl, final IMatchProcessor<? super BlockMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBl}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BlockMatch newMatch(final Block pBl) {
    return BlockMatch.newMatch(pBl);
  }
  
  /**
   * Retrieve the set of values that occur in matches for bl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Block> rawAccumulateAllValuesOfbl(final Object[] parameters) {
    Set<Block> results = new HashSet<Block>();
    rawAccumulateAllValues(POSITION_BL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for bl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfbl() {
    return rawAccumulateAllValuesOfbl(emptyArray());
  }
  
  @Override
  protected BlockMatch tupleToMatch(final Tuple t) {
    try {
    	return BlockMatch.newMatch((hu.bme.mit.massif.simulink.Block) t.get(POSITION_BL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected BlockMatch arrayToMatch(final Object[] match) {
    try {
    	return BlockMatch.newMatch((hu.bme.mit.massif.simulink.Block) match[POSITION_BL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected BlockMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return BlockMatch.newMutableMatch((hu.bme.mit.massif.simulink.Block) match[POSITION_BL]);
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
  public static IQuerySpecification<BlockMatcher> querySpecification() throws IncQueryException {
    return BlockQuerySpecification.instance();
  }
}
