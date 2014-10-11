package hu.bme.mit.transima.models.simulink.derived;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Trigger;
import hu.bme.mit.transima.models.simulink.derived.util.TriggerQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.derived.trigger pattern,
 * to be used in conjunction with {@link TriggerMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TriggerMatcher
 * @see TriggerProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TriggerMatch extends BasePatternMatch {
  private Block fBlock;
  
  private Trigger fTrigger;
  
  private static List<String> parameterNames = makeImmutableList("Block", "Trigger");
  
  private TriggerMatch(final Block pBlock, final Trigger pTrigger) {
    this.fBlock = pBlock;
    this.fTrigger = pTrigger;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Block".equals(parameterName)) return this.fBlock;
    if ("Trigger".equals(parameterName)) return this.fTrigger;
    return null;
    
  }
  
  public Block getBlock() {
    return this.fBlock;
    
  }
  
  public Trigger getTrigger() {
    return this.fTrigger;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Block".equals(parameterName) ) {
    	this.fBlock = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    if ("Trigger".equals(parameterName) ) {
    	this.fTrigger = (hu.bme.mit.transima.Simulink.Trigger) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBlock(final Block pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
    
  }
  
  public void setTrigger(final Trigger pTrigger) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTrigger = pTrigger;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.derived.trigger";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return TriggerMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fTrigger};
    
  }
  
  @Override
  public TriggerMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fTrigger) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Block\"=" + prettyPrintValue(fBlock) + ", ");
    result.append("\"Trigger\"=" + prettyPrintValue(fTrigger));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fTrigger == null) ? 0 : fTrigger.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TriggerMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TriggerMatch other = (TriggerMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fTrigger == null) {if (other.fTrigger != null) return false;}
    else if (!fTrigger.equals(other.fTrigger)) return false;
    return true;
  }
  
  @Override
  public TriggerQuerySpecification specification() {
    try {
    	return TriggerQuerySpecification.instance();
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
  public static TriggerMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pTrigger the fixed value of pattern parameter Trigger, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TriggerMatch newMutableMatch(final Block pBlock, final Trigger pTrigger) {
    return new Mutable(pBlock, pTrigger);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pTrigger the fixed value of pattern parameter Trigger, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TriggerMatch newMatch(final Block pBlock, final Trigger pTrigger) {
    return new Immutable(pBlock, pTrigger);
    
  }
  
  private static final class Mutable extends TriggerMatch {
    Mutable(final Block pBlock, final Trigger pTrigger) {
      super(pBlock, pTrigger);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TriggerMatch {
    Immutable(final Block pBlock, final Trigger pTrigger) {
      super(pBlock, pTrigger);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
