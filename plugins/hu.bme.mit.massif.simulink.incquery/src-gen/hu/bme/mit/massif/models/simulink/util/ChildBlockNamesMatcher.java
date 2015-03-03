package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.ChildBlockNamesMatch;
import hu.bme.mit.massif.models.simulink.util.util.ChildBlockNamesQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.childBlockNames pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildBlockNamesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern childBlockNames(elem : SimulinkElement, child : SimulinkElement, name){
 * 	SimulinkModel.contains(elem, child);
 * 	find elementName(child, name);
 * } or {
 * 	SubSystem.subBlocks(elem, child);
 * 	find elementName(child, name);
 * } or {
 * 	Block.ports(elem, child);
 * 	find elementName(child, name);
 * } or {
 * 	MultiConnection.connections(child, elem);
 * 	find elementName(child, name);
 * }
 * </pre></code>
 * 
 * @see ChildBlockNamesMatch
 * @see ChildBlockNamesProcessor
 * @see ChildBlockNamesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildBlockNamesMatcher extends BaseMatcher<ChildBlockNamesMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildBlockNamesMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ChildBlockNamesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ChildBlockNamesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ELEM = 0;
  
  private final static int POSITION_CHILD = 1;
  
  private final static int POSITION_NAME = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ChildBlockNamesMatcher.class);
  
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
  public ChildBlockNamesMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ChildBlockNamesMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a ChildBlockNamesMatch object.
   * 
   */
  public Collection<ChildBlockNamesMatch> getAllMatches(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    return rawGetAllMatches(new Object[]{pElem, pChild, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a ChildBlockNamesMatch object, or null if no match is found.
   * 
   */
  public ChildBlockNamesMatch getOneArbitraryMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pElem, pChild, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    return rawHasMatch(new Object[]{pElem, pChild, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    return rawCountMatches(new Object[]{pElem, pChild, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName, final IMatchProcessor<? super ChildBlockNamesMatch> processor) {
    rawForEachMatch(new Object[]{pElem, pChild, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName, final IMatchProcessor<? super ChildBlockNamesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pElem, pChild, pName}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ChildBlockNamesMatch newMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    return ChildBlockNamesMatch.newMatch(pElem, pChild, pName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkElement> rawAccumulateAllValuesOfelem(final Object[] parameters) {
    Set<SimulinkElement> results = new HashSet<SimulinkElement>();
    rawAccumulateAllValues(POSITION_ELEM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfelem() {
    return rawAccumulateAllValuesOfelem(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfelem(final ChildBlockNamesMatch partialMatch) {
    return rawAccumulateAllValuesOfelem(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfelem(final SimulinkElement pChild, final String pName) {
    return rawAccumulateAllValuesOfelem(new Object[]{
    null, 
    pChild, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkElement> rawAccumulateAllValuesOfchild(final Object[] parameters) {
    Set<SimulinkElement> results = new HashSet<SimulinkElement>();
    rawAccumulateAllValues(POSITION_CHILD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfchild() {
    return rawAccumulateAllValuesOfchild(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfchild(final ChildBlockNamesMatch partialMatch) {
    return rawAccumulateAllValuesOfchild(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfchild(final SimulinkElement pElem, final String pName) {
    return rawAccumulateAllValuesOfchild(new Object[]{
    pElem, 
    null, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final ChildBlockNamesMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final SimulinkElement pElem, final SimulinkElement pChild) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pElem, 
    pChild, 
    null
    });
  }
  
  @Override
  protected ChildBlockNamesMatch tupleToMatch(final Tuple t) {
    try {
    	return ChildBlockNamesMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkElement) t.get(POSITION_ELEM), (hu.bme.mit.massif.simulink.SimulinkElement) t.get(POSITION_CHILD), (java.lang.String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildBlockNamesMatch arrayToMatch(final Object[] match) {
    try {
    	return ChildBlockNamesMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkElement) match[POSITION_ELEM], (hu.bme.mit.massif.simulink.SimulinkElement) match[POSITION_CHILD], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildBlockNamesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ChildBlockNamesMatch.newMutableMatch((hu.bme.mit.massif.simulink.SimulinkElement) match[POSITION_ELEM], (hu.bme.mit.massif.simulink.SimulinkElement) match[POSITION_CHILD], (java.lang.String) match[POSITION_NAME]);
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
  public static IQuerySpecification<ChildBlockNamesMatcher> querySpecification() throws IncQueryException {
    return ChildBlockNamesQuerySpecification.instance();
  }
}
