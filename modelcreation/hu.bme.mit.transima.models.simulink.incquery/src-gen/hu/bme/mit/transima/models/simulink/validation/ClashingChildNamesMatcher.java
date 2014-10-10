package hu.bme.mit.transima.models.simulink.validation;

import hu.bme.mit.transima.Simulink.SimulinkElement;
import hu.bme.mit.transima.models.simulink.validation.ClashingChildNamesMatch;
import hu.bme.mit.transima.models.simulink.validation.util.ClashingChildNamesQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.validation.clashingChildNames pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ClashingChildNamesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Constraint(severity = "error", location = child,
 * 	message = "Child $child$ has a sibling in $parent$ with the same name!",
 * 	targetEditorId = "hu.bme.mit.transima.simulink.ui.editor1"
 * )
 * pattern clashingChildNames(parent : SimulinkElement, child : SimulinkElement) {
 * 	find childBlockNames(parent, child, name);
 * 	find childBlockNames(parent, child2, name);
 * 	child != child2;
 * }
 * </pre></code>
 * 
 * @see ClashingChildNamesMatch
 * @see ClashingChildNamesProcessor
 * @see ClashingChildNamesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ClashingChildNamesMatcher extends BaseMatcher<ClashingChildNamesMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ClashingChildNamesMatcher> querySpecification() throws IncQueryException {
    return ClashingChildNamesQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ClashingChildNamesMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ClashingChildNamesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ClashingChildNamesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PARENT = 0;
  
  private final static int POSITION_CHILD = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ClashingChildNamesMatcher.class);
  
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
  public ClashingChildNamesMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ClashingChildNamesMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return matches represented as a ClashingChildNamesMatch object.
   * 
   */
  public Collection<ClashingChildNamesMatch> getAllMatches(final SimulinkElement pParent, final SimulinkElement pChild) {
    return rawGetAllMatches(new Object[]{pParent, pChild});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return a match represented as a ClashingChildNamesMatch object, or null if no match is found.
   * 
   */
  public ClashingChildNamesMatch getOneArbitraryMatch(final SimulinkElement pParent, final SimulinkElement pChild) {
    return rawGetOneArbitraryMatch(new Object[]{pParent, pChild});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SimulinkElement pParent, final SimulinkElement pChild) {
    return rawHasMatch(new Object[]{pParent, pChild});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SimulinkElement pParent, final SimulinkElement pChild) {
    return rawCountMatches(new Object[]{pParent, pChild});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SimulinkElement pParent, final SimulinkElement pChild, final IMatchProcessor<? super ClashingChildNamesMatch> processor) {
    rawForEachMatch(new Object[]{pParent, pChild}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SimulinkElement pParent, final SimulinkElement pChild, final IMatchProcessor<? super ClashingChildNamesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pParent, pChild}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  public DeltaMonitor<ClashingChildNamesMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final SimulinkElement pParent, final SimulinkElement pChild) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pParent, pChild});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ClashingChildNamesMatch newMatch(final SimulinkElement pParent, final SimulinkElement pChild) {
    return ClashingChildNamesMatch.newMatch(pParent, pChild);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkElement> rawAccumulateAllValuesOfparent(final Object[] parameters) {
    Set<SimulinkElement> results = new HashSet<SimulinkElement>();
    rawAccumulateAllValues(POSITION_PARENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfparent() {
    return rawAccumulateAllValuesOfparent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfparent(final ClashingChildNamesMatch partialMatch) {
    return rawAccumulateAllValuesOfparent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfparent(final SimulinkElement pChild) {
    return rawAccumulateAllValuesOfparent(new Object[]{null, pChild});
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
  public Set<SimulinkElement> getAllValuesOfchild(final ClashingChildNamesMatch partialMatch) {
    return rawAccumulateAllValuesOfchild(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkElement> getAllValuesOfchild(final SimulinkElement pParent) {
    return rawAccumulateAllValuesOfchild(new Object[]{pParent, null});
  }
  
  protected ClashingChildNamesMatch tupleToMatch(final Tuple t) {
    try {
      return ClashingChildNamesMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkElement) t.get(POSITION_PARENT), (hu.bme.mit.transima.Simulink.SimulinkElement) t.get(POSITION_CHILD));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  protected ClashingChildNamesMatch arrayToMatch(final Object[] match) {
    try {
      return ClashingChildNamesMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkElement) match[POSITION_PARENT], (hu.bme.mit.transima.Simulink.SimulinkElement) match[POSITION_CHILD]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  protected ClashingChildNamesMatch arrayToMatchMutable(final Object[] match) {
    try {
      return ClashingChildNamesMatch.newMutableMatch((hu.bme.mit.transima.Simulink.SimulinkElement) match[POSITION_PARENT], (hu.bme.mit.transima.Simulink.SimulinkElement) match[POSITION_CHILD]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
