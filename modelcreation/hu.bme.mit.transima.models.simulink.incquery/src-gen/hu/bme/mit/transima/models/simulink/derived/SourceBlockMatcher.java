package hu.bme.mit.transima.models.simulink.derived;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.models.simulink.derived.SourceBlockMatch;
import hu.bme.mit.transima.models.simulink.derived.util.SourceBlockQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.derived.sourceBlock pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SourceBlockMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryBasedFeature
 * pattern sourceBlock(This : Block, Source : Block) = {
 * 	Block.sourceBlockRef(This,SrcRef);
 * 	Block.simulinkRef(Source,SR);
 * 	
 * 	find referenceEqual(SrcRef, SR);
 * }
 * </pre></code>
 * 
 * @see SourceBlockMatch
 * @see SourceBlockProcessor
 * @see SourceBlockQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SourceBlockMatcher extends BaseMatcher<SourceBlockMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<SourceBlockMatcher> querySpecification() throws IncQueryException {
    return SourceBlockQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SourceBlockMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SourceBlockMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SourceBlockMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_THIS = 0;
  
  private final static int POSITION_SOURCE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SourceBlockMatcher.class);
  
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
  public SourceBlockMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SourceBlockMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return matches represented as a SourceBlockMatch object.
   * 
   */
  public Collection<SourceBlockMatch> getAllMatches(final Block pThis, final Block pSource) {
    return rawGetAllMatches(new Object[]{pThis, pSource});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return a match represented as a SourceBlockMatch object, or null if no match is found.
   * 
   */
  public SourceBlockMatch getOneArbitraryMatch(final Block pThis, final Block pSource) {
    return rawGetOneArbitraryMatch(new Object[]{pThis, pSource});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Block pThis, final Block pSource) {
    return rawHasMatch(new Object[]{pThis, pSource});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Block pThis, final Block pSource) {
    return rawCountMatches(new Object[]{pThis, pSource});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Block pThis, final Block pSource, final IMatchProcessor<? super SourceBlockMatch> processor) {
    rawForEachMatch(new Object[]{pThis, pSource}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Block pThis, final Block pSource, final IMatchProcessor<? super SourceBlockMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pThis, pSource}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<SourceBlockMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Block pThis, final Block pSource) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pThis, pSource});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SourceBlockMatch newMatch(final Block pThis, final Block pSource) {
    return SourceBlockMatch.newMatch(pThis, pSource);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Block> rawAccumulateAllValuesOfThis(final Object[] parameters) {
    Set<Block> results = new HashSet<Block>();
    rawAccumulateAllValues(POSITION_THIS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfThis() {
    return rawAccumulateAllValuesOfThis(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfThis(final SourceBlockMatch partialMatch) {
    return rawAccumulateAllValuesOfThis(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfThis(final Block pSource) {
    return rawAccumulateAllValuesOfThis(new Object[]{null, pSource});
  }
  
  /**
   * Retrieve the set of values that occur in matches for Source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Block> rawAccumulateAllValuesOfSource(final Object[] parameters) {
    Set<Block> results = new HashSet<Block>();
    rawAccumulateAllValues(POSITION_SOURCE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfSource() {
    return rawAccumulateAllValuesOfSource(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfSource(final SourceBlockMatch partialMatch) {
    return rawAccumulateAllValuesOfSource(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Block> getAllValuesOfSource(final Block pThis) {
    return rawAccumulateAllValuesOfSource(new Object[]{pThis, null});
  }
  
  @Override
  protected SourceBlockMatch tupleToMatch(final Tuple t) {
    try {
      return SourceBlockMatch.newMatch((hu.bme.mit.transima.Simulink.Block) t.get(POSITION_THIS), (hu.bme.mit.transima.Simulink.Block) t.get(POSITION_SOURCE));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SourceBlockMatch arrayToMatch(final Object[] match) {
    try {
      return SourceBlockMatch.newMatch((hu.bme.mit.transima.Simulink.Block) match[POSITION_THIS], (hu.bme.mit.transima.Simulink.Block) match[POSITION_SOURCE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SourceBlockMatch arrayToMatchMutable(final Object[] match) {
    try {
      return SourceBlockMatch.newMutableMatch((hu.bme.mit.transima.Simulink.Block) match[POSITION_THIS], (hu.bme.mit.transima.Simulink.Block) match[POSITION_SOURCE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
