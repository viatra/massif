package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.ElementNameMatch;
import hu.bme.mit.massif.models.simulink.util.util.ElementNameQuerySpecification;
import hu.bme.mit.massif.simulink.SimulinkElement;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.elementName pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ElementNameMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern elementName(SE : SimulinkElement, Name) = {
 * 	SimulinkElement.simulinkRef(SE,SR);
 * 	SimulinkReference.name(SR,Name);
 * }
 * </pre></code>
 * 
 * @see ElementNameMatch
 * @see ElementNameProcessor
 * @see ElementNameQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ElementNameMatcher extends BaseMatcher<ElementNameMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ElementNameMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ElementNameMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ElementNameMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SE = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ElementNameMatcher.class);
  
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
  public ElementNameMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ElementNameMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @return matches represented as a ElementNameMatch object.
   * 
   */
  public Collection<ElementNameMatch> getAllMatches(final SimulinkElement pSE, final String pName) {
    return rawGetAllMatches(new Object[]{pSE, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @return a match represented as a ElementNameMatch object, or null if no match is found.
   * 
   */
  public ElementNameMatch getOneArbitraryMatch(final SimulinkElement pSE, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pSE, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SimulinkElement pSE, final String pName) {
    return rawHasMatch(new Object[]{pSE, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SimulinkElement pSE, final String pName) {
    return rawCountMatches(new Object[]{pSE, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SimulinkElement pSE, final String pName, final IMatchProcessor<? super ElementNameMatch> processor) {
    rawForEachMatch(new Object[]{pSE, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SimulinkElement pSE, final String pName, final IMatchProcessor<? super ElementNameMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSE, pName}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ElementNameMatch newMatch(final SimulinkElement pSE, final String pName) {
    return ElementNameMatch.newMatch(pSE, pName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for SE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkElement> rawAccumulateAllValuesOfSE(final Object[] parameters) {
    Set<SimulinkElement> results = new HashSet<SimulinkElement>();
    rawAccumulateAllValues(POSITION_SE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for SE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfSE() {
    return rawAccumulateAllValuesOfSE(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for SE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfSE(final ElementNameMatch partialMatch) {
    return rawAccumulateAllValuesOfSE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for SE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfSE(final String pName) {
    return rawAccumulateAllValuesOfSE(new Object[]{
    null, 
    pName
    });
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
  public Set<String> getAllValuesOfName(final ElementNameMatch partialMatch) {
    return rawAccumulateAllValuesOfName(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfName(final SimulinkElement pSE) {
    return rawAccumulateAllValuesOfName(new Object[]{
    pSE, 
    null
    });
  }
  
  @Override
  protected ElementNameMatch tupleToMatch(final Tuple t) {
    try {
    	return ElementNameMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkElement) t.get(POSITION_SE), (java.lang.String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ElementNameMatch arrayToMatch(final Object[] match) {
    try {
    	return ElementNameMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkElement) match[POSITION_SE], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ElementNameMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ElementNameMatch.newMutableMatch((hu.bme.mit.massif.simulink.SimulinkElement) match[POSITION_SE], (java.lang.String) match[POSITION_NAME]);
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
  public static IQuerySpecification<ElementNameMatcher> querySpecification() throws IncQueryException {
    return ElementNameQuerySpecification.instance();
  }
}