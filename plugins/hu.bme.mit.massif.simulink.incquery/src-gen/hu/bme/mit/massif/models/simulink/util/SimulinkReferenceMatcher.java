package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.SimulinkReferenceMatch;
import hu.bme.mit.massif.models.simulink.util.util.SimulinkReferenceQuerySpecification;
import hu.bme.mit.massif.simulink.SimulinkReference;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.simulinkReference pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SimulinkReferenceMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern simulinkReference(SR: SimulinkReference, Name, Qual) = {
 * 	SimulinkReference.name(SR,Name);
 * 	SimulinkReference.qualifier(SR,Qual);
 * }
 * </pre></code>
 * 
 * @see SimulinkReferenceMatch
 * @see SimulinkReferenceProcessor
 * @see SimulinkReferenceQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SimulinkReferenceMatcher extends BaseMatcher<SimulinkReferenceMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<SimulinkReferenceMatcher> querySpecification() throws IncQueryException {
    return SimulinkReferenceQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SimulinkReferenceMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SimulinkReferenceMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SimulinkReferenceMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SR = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static int POSITION_QUAL = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SimulinkReferenceMatcher.class);
  
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
  public SimulinkReferenceMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SimulinkReferenceMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return matches represented as a SimulinkReferenceMatch object.
   * 
   */
  public Collection<SimulinkReferenceMatch> getAllMatches(final SimulinkReference pSR, final String pName, final String pQual) {
    return rawGetAllMatches(new Object[]{pSR, pName, pQual});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return a match represented as a SimulinkReferenceMatch object, or null if no match is found.
   * 
   */
  public SimulinkReferenceMatch getOneArbitraryMatch(final SimulinkReference pSR, final String pName, final String pQual) {
    return rawGetOneArbitraryMatch(new Object[]{pSR, pName, pQual});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SimulinkReference pSR, final String pName, final String pQual) {
    return rawHasMatch(new Object[]{pSR, pName, pQual});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SimulinkReference pSR, final String pName, final String pQual) {
    return rawCountMatches(new Object[]{pSR, pName, pQual});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SimulinkReference pSR, final String pName, final String pQual, final IMatchProcessor<? super SimulinkReferenceMatch> processor) {
    rawForEachMatch(new Object[]{pSR, pName, pQual}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SimulinkReference pSR, final String pName, final String pQual, final IMatchProcessor<? super SimulinkReferenceMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSR, pName, pQual}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<SimulinkReferenceMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final SimulinkReference pSR, final String pName, final String pQual) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSR, pName, pQual});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SimulinkReferenceMatch newMatch(final SimulinkReference pSR, final String pName, final String pQual) {
    return SimulinkReferenceMatch.newMatch(pSR, pName, pQual);
    
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
  public Set<SimulinkReference> getAllValuesOfSR(final SimulinkReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOfSR(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for SR.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOfSR(final String pName, final String pQual) {
    return rawAccumulateAllValuesOfSR(new Object[]{null, pName, pQual});
  }
  
  /**
   * Retrieve the set of values that occur in matches for Name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfName(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfName() {
    return rawAccumulateAllValuesOfName(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfName(final SimulinkReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOfName(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfName(final SimulinkReference pSR, final String pQual) {
    return rawAccumulateAllValuesOfName(new Object[]{pSR, null, pQual});
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
  public Set<String> getAllValuesOfQual(final SimulinkReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOfQual(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Qual.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfQual(final SimulinkReference pSR, final String pName) {
    return rawAccumulateAllValuesOfQual(new Object[]{pSR, pName, null});
  }
  
  @Override
  protected SimulinkReferenceMatch tupleToMatch(final Tuple t) {
    try {
      return SimulinkReferenceMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkReference) t.get(POSITION_SR), (java.lang.String) t.get(POSITION_NAME), (java.lang.String) t.get(POSITION_QUAL));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SimulinkReferenceMatch arrayToMatch(final Object[] match) {
    try {
      return SimulinkReferenceMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkReference) match[POSITION_SR], (java.lang.String) match[POSITION_NAME], (java.lang.String) match[POSITION_QUAL]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SimulinkReferenceMatch arrayToMatchMutable(final Object[] match) {
    try {
      return SimulinkReferenceMatch.newMutableMatch((hu.bme.mit.massif.simulink.SimulinkReference) match[POSITION_SR], (java.lang.String) match[POSITION_NAME], (java.lang.String) match[POSITION_QUAL]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
