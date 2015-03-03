package hu.bme.mit.massif.models.simulink.derived;

import hu.bme.mit.massif.models.simulink.derived.util.OutportsQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.OutPort;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.derived.outports pattern,
 * to be used in conjunction with {@link OutportsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OutportsMatcher
 * @see OutportsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class OutportsMatch extends BasePatternMatch {
  private Block fBlock;
  
  private OutPort fOutPort;
  
  private static List<String> parameterNames = makeImmutableList("Block", "OutPort");
  
  private OutportsMatch(final Block pBlock, final OutPort pOutPort) {
    this.fBlock = pBlock;
    this.fOutPort = pOutPort;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Block".equals(parameterName)) return this.fBlock;
    if ("OutPort".equals(parameterName)) return this.fOutPort;
    return null;
  }
  
  public Block getBlock() {
    return this.fBlock;
  }
  
  public OutPort getOutPort() {
    return this.fOutPort;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Block".equals(parameterName) ) {
    	this.fBlock = (hu.bme.mit.massif.simulink.Block) newValue;
    	return true;
    }
    if ("OutPort".equals(parameterName) ) {
    	this.fOutPort = (hu.bme.mit.massif.simulink.OutPort) newValue;
    	return true;
    }
    return false;
  }
  
  public void setBlock(final Block pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
  }
  
  public void setOutPort(final OutPort pOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOutPort = pOutPort;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.derived.outports";
  }
  
  @Override
  public List<String> parameterNames() {
    return OutportsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fOutPort};
  }
  
  @Override
  public OutportsMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fOutPort) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Block\"=" + prettyPrintValue(fBlock) + ", ");
    
    result.append("\"OutPort\"=" + prettyPrintValue(fOutPort)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fOutPort == null) ? 0 : fOutPort.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OutportsMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OutportsMatch other = (OutportsMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fOutPort == null) {if (other.fOutPort != null) return false;}
    else if (!fOutPort.equals(other.fOutPort)) return false;
    return true;
  }
  
  @Override
  public OutportsQuerySpecification specification() {
    try {
    	return OutportsQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static OutportsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static OutportsMatch newMutableMatch(final Block pBlock, final OutPort pOutPort) {
    return new Mutable(pBlock, pOutPort);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter OutPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static OutportsMatch newMatch(final Block pBlock, final OutPort pOutPort) {
    return new Immutable(pBlock, pOutPort);
  }
  
  private static final class Mutable extends OutportsMatch {
    Mutable(final Block pBlock, final OutPort pOutPort) {
      super(pBlock, pOutPort);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends OutportsMatch {
    Immutable(final Block pBlock, final OutPort pOutPort) {
      super(pBlock, pOutPort);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
