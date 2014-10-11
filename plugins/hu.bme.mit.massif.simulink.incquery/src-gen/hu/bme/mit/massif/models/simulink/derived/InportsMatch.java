package hu.bme.mit.massif.models.simulink.derived;

import hu.bme.mit.massif.models.simulink.derived.util.InportsQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPort;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.derived.inports pattern,
 * to be used in conjunction with {@link InportsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InportsMatcher
 * @see InportsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InportsMatch extends BasePatternMatch {
  private Block fBlock;
  
  private InPort fInPort;
  
  private static List<String> parameterNames = makeImmutableList("Block", "InPort");
  
  private InportsMatch(final Block pBlock, final InPort pInPort) {
    this.fBlock = pBlock;
    this.fInPort = pInPort;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Block".equals(parameterName)) return this.fBlock;
    if ("InPort".equals(parameterName)) return this.fInPort;
    return null;
    
  }
  
  public Block getBlock() {
    return this.fBlock;
    
  }
  
  public InPort getInPort() {
    return this.fInPort;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Block".equals(parameterName) ) {
    	this.fBlock = (hu.bme.mit.massif.simulink.Block) newValue;
    	return true;
    }
    if ("InPort".equals(parameterName) ) {
    	this.fInPort = (hu.bme.mit.massif.simulink.InPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBlock(final Block pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
    
  }
  
  public void setInPort(final InPort pInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInPort = pInPort;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.derived.inports";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return InportsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fInPort};
    
  }
  
  @Override
  public InportsMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fInPort) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Block\"=" + prettyPrintValue(fBlock) + ", ");
    result.append("\"InPort\"=" + prettyPrintValue(fInPort));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fInPort == null) ? 0 : fInPort.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InportsMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    InportsMatch other = (InportsMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fInPort == null) {if (other.fInPort != null) return false;}
    else if (!fInPort.equals(other.fInPort)) return false;
    return true;
  }
  
  @Override
  public InportsQuerySpecification specification() {
    try {
    	return InportsQuerySpecification.instance();
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
  public static InportsMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pInPort the fixed value of pattern parameter InPort, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InportsMatch newMutableMatch(final Block pBlock, final InPort pInPort) {
    return new Mutable(pBlock, pInPort);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pInPort the fixed value of pattern parameter InPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InportsMatch newMatch(final Block pBlock, final InPort pInPort) {
    return new Immutable(pBlock, pInPort);
    
  }
  
  private static final class Mutable extends InportsMatch {
    Mutable(final Block pBlock, final InPort pInPort) {
      super(pBlock, pInPort);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InportsMatch {
    Immutable(final Block pBlock, final InPort pInPort) {
      super(pBlock, pInPort);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
