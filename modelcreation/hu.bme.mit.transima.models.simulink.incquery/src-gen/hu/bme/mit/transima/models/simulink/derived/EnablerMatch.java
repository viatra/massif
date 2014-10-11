package hu.bme.mit.transima.models.simulink.derived;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Enable;
import hu.bme.mit.transima.models.simulink.derived.util.EnablerQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.derived.enabler pattern,
 * to be used in conjunction with {@link EnablerMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EnablerMatcher
 * @see EnablerProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EnablerMatch extends BasePatternMatch {
  private Block fBlock;
  
  private Enable fEnabler;
  
  private static List<String> parameterNames = makeImmutableList("Block", "Enabler");
  
  private EnablerMatch(final Block pBlock, final Enable pEnabler) {
    this.fBlock = pBlock;
    this.fEnabler = pEnabler;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Block".equals(parameterName)) return this.fBlock;
    if ("Enabler".equals(parameterName)) return this.fEnabler;
    return null;
    
  }
  
  public Block getBlock() {
    return this.fBlock;
    
  }
  
  public Enable getEnabler() {
    return this.fEnabler;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Block".equals(parameterName) ) {
    	this.fBlock = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    if ("Enabler".equals(parameterName) ) {
    	this.fEnabler = (hu.bme.mit.transima.Simulink.Enable) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBlock(final Block pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
    
  }
  
  public void setEnabler(final Enable pEnabler) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEnabler = pEnabler;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.derived.enabler";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EnablerMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fEnabler};
    
  }
  
  @Override
  public EnablerMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fEnabler) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Block\"=" + prettyPrintValue(fBlock) + ", ");
    result.append("\"Enabler\"=" + prettyPrintValue(fEnabler));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fEnabler == null) ? 0 : fEnabler.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EnablerMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EnablerMatch other = (EnablerMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fEnabler == null) {if (other.fEnabler != null) return false;}
    else if (!fEnabler.equals(other.fEnabler)) return false;
    return true;
  }
  
  @Override
  public EnablerQuerySpecification specification() {
    try {
    	return EnablerQuerySpecification.instance();
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
  public static EnablerMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EnablerMatch newMutableMatch(final Block pBlock, final Enable pEnabler) {
    return new Mutable(pBlock, pEnabler);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pEnabler the fixed value of pattern parameter Enabler, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EnablerMatch newMatch(final Block pBlock, final Enable pEnabler) {
    return new Immutable(pBlock, pEnabler);
    
  }
  
  private static final class Mutable extends EnablerMatch {
    Mutable(final Block pBlock, final Enable pEnabler) {
      super(pBlock, pEnabler);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EnablerMatch {
    Immutable(final Block pBlock, final Enable pEnabler) {
      super(pBlock, pEnabler);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
