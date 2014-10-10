package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.models.simulink.viewer.util.BlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.viewer.block pattern,
 * to be used in conjunction with {@link BlockMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BlockMatcher
 * @see BlockProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BlockMatch extends BasePatternMatch {
  private Block fBl;
  
  private static List<String> parameterNames = makeImmutableList("bl");
  
  private BlockMatch(final Block pBl) {
    this.fBl = pBl;
    
  }
  
  public Object get(final String parameterName) {
    if ("bl".equals(parameterName)) return this.fBl;
    return null;
    
  }
  
  public Block getBl() {
    return this.fBl;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("bl".equals(parameterName) ) {
    	this.fBl = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBl(final Block pBl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBl = pBl;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.viewer.block";
    
  }
  
  public List<String> parameterNames() {
    return BlockMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fBl};
    
  }
  
  public BlockMatch toImmutable() {
    return isMutable() ? newMatch(fBl) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"bl\"=" + prettyPrintValue(fBl));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBl == null) ? 0 : fBl.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BlockMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BlockMatch other = (BlockMatch) obj;
    if (fBl == null) {if (other.fBl != null) return false;}
    else if (!fBl.equals(other.fBl)) return false;
    return true;
  }
  
  public BlockQuerySpecification specification() {
    try {
    	return BlockQuerySpecification.instance();
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
  public static BlockMatch newEmptyMatch() {
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
  public static BlockMatch newMutableMatch(final Block pBl) {
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
  public static BlockMatch newMatch(final Block pBl) {
    return new Immutable(pBl);
    
  }
  
  private static final class Mutable extends BlockMatch {
    Mutable(final Block pBl) {
      super(pBl);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BlockMatch {
    Immutable(final Block pBl) {
      super(pBl);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
