package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.SubSystem;
import hu.bme.mit.transima.models.simulink.viewer.util.SubSystemQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.viewer.subSystem pattern,
 * to be used in conjunction with {@link SubSystemMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SubSystemMatcher
 * @see SubSystemProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SubSystemMatch extends BasePatternMatch {
  private SubSystem fSubS;
  
  private static List<String> parameterNames = makeImmutableList("subS");
  
  private SubSystemMatch(final SubSystem pSubS) {
    this.fSubS = pSubS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("subS".equals(parameterName)) return this.fSubS;
    return null;
    
  }
  
  public SubSystem getSubS() {
    return this.fSubS;
    
  }
  
  @Override
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
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.viewer.subSystem";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SubSystemMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSubS};
    
  }
  
  @Override
  public SubSystemMatch toImmutable() {
    return isMutable() ? newMatch(fSubS) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"subS\"=" + prettyPrintValue(fSubS));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSubS == null) ? 0 : fSubS.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SubSystemMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SubSystemMatch other = (SubSystemMatch) obj;
    if (fSubS == null) {if (other.fSubS != null) return false;}
    else if (!fSubS.equals(other.fSubS)) return false;
    return true;
  }
  
  @Override
  public SubSystemQuerySpecification specification() {
    try {
    	return SubSystemQuerySpecification.instance();
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
  public static SubSystemMatch newEmptyMatch() {
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
  public static SubSystemMatch newMutableMatch(final SubSystem pSubS) {
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
  public static SubSystemMatch newMatch(final SubSystem pSubS) {
    return new Immutable(pSubS);
    
  }
  
  private static final class Mutable extends SubSystemMatch {
    Mutable(final SubSystem pSubS) {
      super(pSubS);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SubSystemMatch {
    Immutable(final SubSystem pSubS) {
      super(pSubS);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
