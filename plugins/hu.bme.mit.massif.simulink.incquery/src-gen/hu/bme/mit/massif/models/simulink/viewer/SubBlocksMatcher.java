package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.SubBlocksMatch;
import hu.bme.mit.massif.models.simulink.viewer.util.SubBlocksQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.SubSystem;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.viewer.subBlocks pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SubBlocksMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}ContainsItem(container = subSys, item = bl)
 * {@literal @}QueryExplorer(display=true)
 * pattern subBlocks(subSys, bl){
 * 	SubSystem.subBlocks(subSys, bl);
 * 	//neg find portBlock(bl);
 * }
 * </pre></code>
 * 
 * @see SubBlocksMatch
 * @see SubBlocksProcessor
 * @see SubBlocksQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SubBlocksMatcher extends BaseMatcher<SubBlocksMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SubBlocksMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SubBlocksMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SubBlocksMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SUBSYS = 0;
  
  private final static int POSITION_BL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SubBlocksMatcher.class);
  
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
  public SubBlocksMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SubBlocksMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return matches represented as a SubBlocksMatch object.
   * 
   */
  public Collection<SubBlocksMatch> getAllMatches(final SubSystem pSubSys, final Block pBl) {
    return rawGetAllMatches(new Object[]{pSubSys, pBl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return a match represented as a SubBlocksMatch object, or null if no match is found.
   * 
   */
  public SubBlocksMatch getOneArbitraryMatch(final SubSystem pSubSys, final Block pBl) {
    return rawGetOneArbitraryMatch(new Object[]{pSubSys, pBl});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SubSystem pSubSys, final Block pBl) {
    return rawHasMatch(new Object[]{pSubSys, pBl});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SubSystem pSubSys, final Block pBl) {
    return rawCountMatches(new Object[]{pSubSys, pBl});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SubSystem pSubSys, final Block pBl, final IMatchProcessor<? super SubBlocksMatch> processor) {
    rawForEachMatch(new Object[]{pSubSys, pBl}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SubSystem pSubSys, final Block pBl, final IMatchProcessor<? super SubBlocksMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSubSys, pBl}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SubBlocksMatch newMatch(final SubSystem pSubSys, final Block pBl) {
    return SubBlocksMatch.newMatch(pSubSys, pBl);
  }
  
  /**
   * Retrieve the set of values that occur in matches for subSys.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SubSystem> rawAccumulateAllValuesOfsubSys(final Object[] parameters) {
    Set<SubSystem> results = new HashSet<SubSystem>();
    rawAccumulateAllValues(POSITION_SUBSYS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for subSys.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SubSystem> getAllValuesOfsubSys() {
    return rawAccumulateAllValuesOfsubSys(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for subSys.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SubSystem> getAllValuesOfsubSys(final SubBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfsubSys(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for subSys.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SubSystem> getAllValuesOfsubSys(final Block pBl) {
    return rawAccumulateAllValuesOfsubSys(new Object[]{
    null, 
    pBl
    });
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
  
  /**
   * Retrieve the set of values that occur in matches for bl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfbl(final SubBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfbl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for bl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfbl(final SubSystem pSubSys) {
    return rawAccumulateAllValuesOfbl(new Object[]{
    pSubSys, 
    null
    });
  }
  
  @Override
  protected SubBlocksMatch tupleToMatch(final Tuple t) {
    try {
    	return SubBlocksMatch.newMatch((hu.bme.mit.massif.simulink.SubSystem) t.get(POSITION_SUBSYS), (hu.bme.mit.massif.simulink.Block) t.get(POSITION_BL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SubBlocksMatch arrayToMatch(final Object[] match) {
    try {
    	return SubBlocksMatch.newMatch((hu.bme.mit.massif.simulink.SubSystem) match[POSITION_SUBSYS], (hu.bme.mit.massif.simulink.Block) match[POSITION_BL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SubBlocksMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SubBlocksMatch.newMutableMatch((hu.bme.mit.massif.simulink.SubSystem) match[POSITION_SUBSYS], (hu.bme.mit.massif.simulink.Block) match[POSITION_BL]);
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
  public static IQuerySpecification<SubBlocksMatcher> querySpecification() throws IncQueryException {
    return SubBlocksQuerySpecification.instance();
  }
}
