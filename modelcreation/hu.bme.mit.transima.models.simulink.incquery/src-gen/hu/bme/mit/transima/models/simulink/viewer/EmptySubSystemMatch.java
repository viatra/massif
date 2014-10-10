package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.SubSystem;
import hu.bme.mit.transima.models.simulink.viewer.util.EmptySubSystemQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.viewer.emptySubSystem pattern,
 * to be used in conjunction with {@link EmptySubSystemMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EmptySubSystemMatcher
 * @see EmptySubSystemProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EmptySubSystemMatch extends BasePatternMatch {
  private SubSystem fSubS;
  
  private static List<String> parameterNames = makeImmutableList("subS");
  
  private EmptySubSystemMatch(final SubSystem pSubS) {
    this.fSubS = pSubS;
    
  }
  
  public Object get(final String parameterName) {
    if ("subS".equals(parameterName)) return this.fSubS;
    return null;
    
  }
  
  public SubSystem getSubS() {
    return this.fSubS;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("subS".equals(parameterName) ) {
    	this.fSubS = (hu.bme.mit.transima.Simulink.SubSystem) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSubS(final SubSystem pSubS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubS = pSubS;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.viewer.emptySubSystem";
    
  }
  
  public List<String> parameterNames() {
    return EmptySubSystemMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fSubS};
    
  }
  
  public EmptySubSystemMatch toImmutable() {
    return isMutable() ? newMatch(fSubS) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"subS\"=" + prettyPrintValue(fSubS));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSubS == null) ? 0 : fSubS.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EmptySubSystemMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EmptySubSystemMatch other = (EmptySubSystemMatch) obj;
    if (fSubS == null) {if (other.fSubS != null) return false;}
    else if (!fSubS.equals(other.fSubS)) return false;
    return true;
  }
  
  public EmptySubSystemQuerySpecification specification() {
    try {
    	return EmptySubSystemQuerySpecification.instance();
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
  public static EmptySubSystemMatch newEmptyMatch() {
    return new Mutable(null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EmptySubSystemMatch newMutableMatch(final SubSystem pSubS) {
    return new Mutable(pSubS);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EmptySubSystemMatch newMatch(final SubSystem pSubS) {
    return new Immutable(pSubS);
    
  }
  
  private static final class Mutable extends EmptySubSystemMatch {
    Mutable(final SubSystem pSubS) {
      super(pSubS);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EmptySubSystemMatch {
    Immutable(final SubSystem pSubS) {
      super(pSubS);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
