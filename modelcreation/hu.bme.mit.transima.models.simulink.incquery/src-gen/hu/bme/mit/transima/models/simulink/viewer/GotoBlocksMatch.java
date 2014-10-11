package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.Goto;
import hu.bme.mit.transima.models.simulink.viewer.util.GotoBlocksQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.viewer.gotoBlocks pattern,
 * to be used in conjunction with {@link GotoBlocksMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GotoBlocksMatcher
 * @see GotoBlocksProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GotoBlocksMatch extends BasePatternMatch {
  private Goto fBl;
  
  private static List<String> parameterNames = makeImmutableList("bl");
  
  private GotoBlocksMatch(final Goto pBl) {
    this.fBl = pBl;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("bl".equals(parameterName)) return this.fBl;
    return null;
    
  }
  
  public Goto getBl() {
    return this.fBl;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("bl".equals(parameterName) ) {
    	this.fBl = (hu.bme.mit.transima.Simulink.Goto) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBl(final Goto pBl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBl = pBl;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.viewer.gotoBlocks";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return GotoBlocksMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBl};
    
  }
  
  @Override
  public GotoBlocksMatch toImmutable() {
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
    if (!(obj instanceof GotoBlocksMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    GotoBlocksMatch other = (GotoBlocksMatch) obj;
    if (fBl == null) {if (other.fBl != null) return false;}
    else if (!fBl.equals(other.fBl)) return false;
    return true;
  }
  
  @Override
  public GotoBlocksQuerySpecification specification() {
    try {
    	return GotoBlocksQuerySpecification.instance();
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
  public static GotoBlocksMatch newEmptyMatch() {
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
  public static GotoBlocksMatch newMutableMatch(final Goto pBl) {
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
  public static GotoBlocksMatch newMatch(final Goto pBl) {
    return new Immutable(pBl);
    
  }
  
  private static final class Mutable extends GotoBlocksMatch {
    Mutable(final Goto pBl) {
      super(pBl);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GotoBlocksMatch {
    Immutable(final Goto pBl) {
      super(pBl);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
