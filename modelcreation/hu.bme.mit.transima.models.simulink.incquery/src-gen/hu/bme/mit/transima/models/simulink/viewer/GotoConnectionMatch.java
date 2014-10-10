package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.From;
import hu.bme.mit.transima.Simulink.Goto;
import hu.bme.mit.transima.models.simulink.viewer.util.GotoConnectionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.viewer.gotoConnection pattern,
 * to be used in conjunction with {@link GotoConnectionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GotoConnectionMatcher
 * @see GotoConnectionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GotoConnectionMatch extends BasePatternMatch {
  private Goto fFrom;
  
  private From fTo;
  
  private static List<String> parameterNames = makeImmutableList("from", "to");
  
  private GotoConnectionMatch(final Goto pFrom, final From pTo) {
    this.fFrom = pFrom;
    this.fTo = pTo;
    
  }
  
  public Object get(final String parameterName) {
    if ("from".equals(parameterName)) return this.fFrom;
    if ("to".equals(parameterName)) return this.fTo;
    return null;
    
  }
  
  public Goto getFrom() {
    return this.fFrom;
    
  }
  
  public From getTo() {
    return this.fTo;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("from".equals(parameterName) ) {
    	this.fFrom = (hu.bme.mit.transima.Simulink.Goto) newValue;
    	return true;
    }
    if ("to".equals(parameterName) ) {
    	this.fTo = (hu.bme.mit.transima.Simulink.From) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setFrom(final Goto pFrom) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFrom = pFrom;
    
  }
  
  public void setTo(final From pTo) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTo = pTo;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.viewer.gotoConnection";
    
  }
  
  public List<String> parameterNames() {
    return GotoConnectionMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fFrom, fTo};
    
  }
  
  public GotoConnectionMatch toImmutable() {
    return isMutable() ? newMatch(fFrom, fTo) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"from\"=" + prettyPrintValue(fFrom) + ", ");
    result.append("\"to\"=" + prettyPrintValue(fTo));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fFrom == null) ? 0 : fFrom.hashCode());
    result = prime * result + ((fTo == null) ? 0 : fTo.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof GotoConnectionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    GotoConnectionMatch other = (GotoConnectionMatch) obj;
    if (fFrom == null) {if (other.fFrom != null) return false;}
    else if (!fFrom.equals(other.fFrom)) return false;
    if (fTo == null) {if (other.fTo != null) return false;}
    else if (!fTo.equals(other.fTo)) return false;
    return true;
  }
  
  public GotoConnectionQuerySpecification specification() {
    try {
    	return GotoConnectionQuerySpecification.instance();
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
  public static GotoConnectionMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pTo the fixed value of pattern parameter to, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GotoConnectionMatch newMutableMatch(final Goto pFrom, final From pTo) {
    return new Mutable(pFrom, pTo);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pTo the fixed value of pattern parameter to, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static GotoConnectionMatch newMatch(final Goto pFrom, final From pTo) {
    return new Immutable(pFrom, pTo);
    
  }
  
  private static final class Mutable extends GotoConnectionMatch {
    Mutable(final Goto pFrom, final From pTo) {
      super(pFrom, pTo);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GotoConnectionMatch {
    Immutable(final Goto pFrom, final From pTo) {
      super(pFrom, pTo);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
