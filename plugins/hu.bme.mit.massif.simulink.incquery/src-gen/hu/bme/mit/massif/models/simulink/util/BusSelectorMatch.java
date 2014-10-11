package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.util.BusSelectorQuerySpecification;
import hu.bme.mit.massif.simulink.BusSelector;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.util.busSelector pattern,
 * to be used in conjunction with {@link BusSelectorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BusSelectorMatcher
 * @see BusSelectorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BusSelectorMatch extends BasePatternMatch {
  private BusSelector fSelector;
  
  private static List<String> parameterNames = makeImmutableList("selector");
  
  private BusSelectorMatch(final BusSelector pSelector) {
    this.fSelector = pSelector;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("selector".equals(parameterName)) return this.fSelector;
    return null;
    
  }
  
  public BusSelector getSelector() {
    return this.fSelector;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("selector".equals(parameterName) ) {
    	this.fSelector = (hu.bme.mit.massif.simulink.BusSelector) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSelector(final BusSelector pSelector) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSelector = pSelector;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.util.busSelector";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BusSelectorMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSelector};
    
  }
  
  @Override
  public BusSelectorMatch toImmutable() {
    return isMutable() ? newMatch(fSelector) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"selector\"=" + prettyPrintValue(fSelector));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSelector == null) ? 0 : fSelector.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BusSelectorMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BusSelectorMatch other = (BusSelectorMatch) obj;
    if (fSelector == null) {if (other.fSelector != null) return false;}
    else if (!fSelector.equals(other.fSelector)) return false;
    return true;
  }
  
  @Override
  public BusSelectorQuerySpecification specification() {
    try {
    	return BusSelectorQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static BusSelectorMatch newEmptyMatch() {
    return new Mutable(null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BusSelectorMatch newMutableMatch(final BusSelector pSelector) {
    return new Mutable(pSelector);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BusSelectorMatch newMatch(final BusSelector pSelector) {
    return new Immutable(pSelector);
    
  }
  
  private static final class Mutable extends BusSelectorMatch {
    Mutable(final BusSelector pSelector) {
      super(pSelector);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BusSelectorMatch {
    Immutable(final BusSelector pSelector) {
      super(pSelector);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
