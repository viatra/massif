package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.models.simulink.util.ReferenceQualifierMatch;
import hu.bme.mit.transima.models.simulink.util.util.ReferenceQualifierQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.util.referenceQualifier pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ReferenceQualifierMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern referenceQualifier(SR: SimulinkReference, Qual) = {
 * 	SimulinkReference.qualifier(SR,Qual);
 * }
 * </pre></code>
 * 
 * @see ReferenceQualifierMatch
 * @see ReferenceQualifierProcessor
 * @see ReferenceQualifierQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ReferenceQualifierMatcher extends BaseMatcher<ReferenceQualifierMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ReferenceQualifierMatcher> querySpecification() throws IncQueryException {
    return ReferenceQualifierQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ReferenceQualifierMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ReferenceQualifierMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ReferenceQualifierMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SR = 0;
  
  private final static int POSITION_QUAL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ReferenceQualifierMatcher.class);
  
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
  public ReferenceQualifierMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ReferenceQualifierMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return matches represented as a ReferenceQualifierMatch object.
   * 
   */
  public Collection<ReferenceQualifierMatch> getAllMatches(final SimulinkReference pSR, final String pQual) {
    return rawGetAllMatches(new Object[]{pSR, pQual});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return a match represented as a ReferenceQualifierMatch object, or null if no match is found.
   * 
   */
  public ReferenceQualifierMatch getOneArbitraryMatch(final SimulinkReference pSR, final String pQual) {
    return rawGetOneArbitraryMatch(new Object[]{pSR, pQual});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SimulinkReference pSR, final String pQual) {
    return rawHasMatch(new Object[]{pSR, pQual});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SimulinkReference pSR, final String pQual) {
    return rawCountMatches(new Object[]{pSR, pQual});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SimulinkReference pSR, final String pQual, final IMatchProcessor<? super ReferenceQualifierMatch> processor) {
    rawForEachMatch(new Object[]{pSR, pQual}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SimulinkReference pSR, final String pQual, final IMatchProcessor<? super ReferenceQualifierMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSR, pQual}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  public DeltaMonitor<ReferenceQualifierMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final SimulinkReference pSR, final String pQual) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSR, pQual});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ReferenceQualifierMatch newMatch(final SimulinkReference pSR, final String pQual) {
    return ReferenceQualifierMatch.newMatch(pSR, pQual);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for SR.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkReference> rawAccumulateAllValuesOfSR(final Object[] parameters) {
    Set<SimulinkReference> results = new HashSet<SimulinkReference>();
    rawAccumulateAllValues(POSITION_SR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for SR.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOfSR() {
    return rawAccumulateAllValuesOfSR(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for SR.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOfSR(final ReferenceQualifierMatch partialMatch) {
    return rawAccumulateAllValuesOfSR(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for SR.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOfSR(final String pQual) {
    return rawAccumulateAllValuesOfSR(new Object[]{null, pQual});
  }
  
  /**
   * Retrieve the set of values that occur in matches for Qual.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfQual(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_QUAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Qual.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfQual() {
    return rawAccumulateAllValuesOfQual(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Qual.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfQual(final ReferenceQualifierMatch partialMatch) {
    return rawAccumulateAllValuesOfQual(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Qual.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfQual(final SimulinkReference pSR) {
    return rawAccumulateAllValuesOfQual(new Object[]{pSR, null});
  }
  
  protected ReferenceQualifierMatch tupleToMatch(final Tuple t) {
    try {
      return ReferenceQualifierMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkReference) t.get(POSITION_SR), (java.lang.String) t.get(POSITION_QUAL));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  protected ReferenceQualifierMatch arrayToMatch(final Object[] match) {
    try {
      return ReferenceQualifierMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkReference) match[POSITION_SR], (java.lang.String) match[POSITION_QUAL]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  protected ReferenceQualifierMatch arrayToMatchMutable(final Object[] match) {
    try {
      return ReferenceQualifierMatch.newMutableMatch((hu.bme.mit.transima.Simulink.SimulinkReference) match[POSITION_SR], (java.lang.String) match[POSITION_QUAL]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
