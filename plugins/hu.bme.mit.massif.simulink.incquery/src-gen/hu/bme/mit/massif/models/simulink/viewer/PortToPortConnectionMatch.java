package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.util.PortToPortConnectionQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.viewer.portToPortConnection pattern,
 * to be used in conjunction with {@link PortToPortConnectionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PortToPortConnectionMatcher
 * @see PortToPortConnectionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PortToPortConnectionMatch extends BasePatternMatch {
  private Block fFrom;
  
  private Block fTo;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("from", "to", "name");
  
  private PortToPortConnectionMatch(final Block pFrom, final Block pTo, final String pName) {
    this.fFrom = pFrom;
    this.fTo = pTo;
    this.fName = pName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("from".equals(parameterName)) return this.fFrom;
    if ("to".equals(parameterName)) return this.fTo;
    if ("name".equals(parameterName)) return this.fName;
    return null;
    
  }
  
  public Block getFrom() {
    return this.fFrom;
    
  }
  
  public Block getTo() {
    return this.fTo;
    
  }
  
  public String getName() {
    return this.fName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("from".equals(parameterName) ) {
    	this.fFrom = (hu.bme.mit.massif.simulink.Block) newValue;
    	return true;
    }
    if ("to".equals(parameterName) ) {
    	this.fTo = (hu.bme.mit.massif.simulink.Block) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setFrom(final Block pFrom) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFrom = pFrom;
    
  }
  
  public void setTo(final Block pTo) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTo = pTo;
    
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.viewer.portToPortConnection";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PortToPortConnectionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fFrom, fTo, fName};
    
  }
  
  @Override
  public PortToPortConnectionMatch toImmutable() {
    return isMutable() ? newMatch(fFrom, fTo, fName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"from\"=" + prettyPrintValue(fFrom) + ", ");
    result.append("\"to\"=" + prettyPrintValue(fTo) + ", ");
    result.append("\"name\"=" + prettyPrintValue(fName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fFrom == null) ? 0 : fFrom.hashCode());
    result = prime * result + ((fTo == null) ? 0 : fTo.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PortToPortConnectionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PortToPortConnectionMatch other = (PortToPortConnectionMatch) obj;
    if (fFrom == null) {if (other.fFrom != null) return false;}
    else if (!fFrom.equals(other.fFrom)) return false;
    if (fTo == null) {if (other.fTo != null) return false;}
    else if (!fTo.equals(other.fTo)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public PortToPortConnectionQuerySpecification specification() {
    try {
    	return PortToPortConnectionQuerySpecification.instance();
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
  public static PortToPortConnectionMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pTo the fixed value of pattern parameter to, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PortToPortConnectionMatch newMutableMatch(final Block pFrom, final Block pTo, final String pName) {
    return new Mutable(pFrom, pTo, pName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pTo the fixed value of pattern parameter to, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PortToPortConnectionMatch newMatch(final Block pFrom, final Block pTo, final String pName) {
    return new Immutable(pFrom, pTo, pName);
    
  }
  
  private static final class Mutable extends PortToPortConnectionMatch {
    Mutable(final Block pFrom, final Block pTo, final String pName) {
      super(pFrom, pTo, pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PortToPortConnectionMatch {
    Immutable(final Block pFrom, final Block pTo, final String pName) {
      super(pFrom, pTo, pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
