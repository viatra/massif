package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.util.PortBlockQuerySpecification;
import hu.bme.mit.massif.simulink.PortBlock;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.viewer.portBlock pattern,
 * to be used in conjunction with {@link PortBlockMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PortBlockMatcher
 * @see PortBlockProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PortBlockMatch extends BasePatternMatch {
  private PortBlock fBl;
  
  private static List<String> parameterNames = makeImmutableList("bl");
  
  private PortBlockMatch(final PortBlock pBl) {
    this.fBl = pBl;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("bl".equals(parameterName)) return this.fBl;
    return null;
    
  }
  
  public PortBlock getBl() {
    return this.fBl;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("bl".equals(parameterName) ) {
    	this.fBl = (hu.bme.mit.massif.simulink.PortBlock) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBl(final PortBlock pBl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBl = pBl;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.viewer.portBlock";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PortBlockMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBl};
    
  }
  
  @Override
  public PortBlockMatch toImmutable() {
    return isMutable() ? newMatch(fBl) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"bl\"=" + prettyPrintValue(fBl));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBl == null) ? 0 : fBl.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PortBlockMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PortBlockMatch other = (PortBlockMatch) obj;
    if (fBl == null) {if (other.fBl != null) return false;}
    else if (!fBl.equals(other.fBl)) return false;
    return true;
  }
  
  @Override
  public PortBlockQuerySpecification specification() {
    try {
    	return PortBlockQuerySpecification.instance();
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
  public static PortBlockMatch newEmptyMatch() {
    return new Mutable(null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PortBlockMatch newMutableMatch(final PortBlock pBl) {
    return new Mutable(pBl);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PortBlockMatch newMatch(final PortBlock pBl) {
    return new Immutable(pBl);
    
  }
  
  private static final class Mutable extends PortBlockMatch {
    Mutable(final PortBlock pBl) {
      super(pBl);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PortBlockMatch {
    Immutable(final PortBlock pBl) {
      super(pBl);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
