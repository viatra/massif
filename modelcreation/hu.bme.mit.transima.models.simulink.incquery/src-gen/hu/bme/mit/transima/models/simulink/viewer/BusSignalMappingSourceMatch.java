package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.BusSelector;
import hu.bme.mit.transima.models.simulink.viewer.util.BusSignalMappingSourceQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.viewer.busSignalMappingSource pattern,
 * to be used in conjunction with {@link BusSignalMappingSourceMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BusSignalMappingSourceMatcher
 * @see BusSignalMappingSourceProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BusSignalMappingSourceMatch extends BasePatternMatch {
  private BusSelector fBusSelector;
  
  private Block fFrom;
  
  private String fName;
  
  private String fToName;
  
  private static List<String> parameterNames = makeImmutableList("busSelector", "from", "name", "toName");
  
  private BusSignalMappingSourceMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    this.fBusSelector = pBusSelector;
    this.fFrom = pFrom;
    this.fName = pName;
    this.fToName = pToName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("busSelector".equals(parameterName)) return this.fBusSelector;
    if ("from".equals(parameterName)) return this.fFrom;
    if ("name".equals(parameterName)) return this.fName;
    if ("toName".equals(parameterName)) return this.fToName;
    return null;
    
  }
  
  public BusSelector getBusSelector() {
    return this.fBusSelector;
    
  }
  
  public Block getFrom() {
    return this.fFrom;
    
  }
  
  public String getName() {
    return this.fName;
    
  }
  
  public String getToName() {
    return this.fToName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("busSelector".equals(parameterName) ) {
    	this.fBusSelector = (hu.bme.mit.transima.Simulink.BusSelector) newValue;
    	return true;
    }
    if ("from".equals(parameterName) ) {
    	this.fFrom = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    if ("toName".equals(parameterName) ) {
    	this.fToName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBusSelector(final BusSelector pBusSelector) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBusSelector = pBusSelector;
    
  }
  
  public void setFrom(final Block pFrom) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFrom = pFrom;
    
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
    
  }
  
  public void setToName(final String pToName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fToName = pToName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.viewer.busSignalMappingSource";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BusSignalMappingSourceMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBusSelector, fFrom, fName, fToName};
    
  }
  
  @Override
  public BusSignalMappingSourceMatch toImmutable() {
    return isMutable() ? newMatch(fBusSelector, fFrom, fName, fToName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"busSelector\"=" + prettyPrintValue(fBusSelector) + ", ");
    result.append("\"from\"=" + prettyPrintValue(fFrom) + ", ");
    result.append("\"name\"=" + prettyPrintValue(fName) + ", ");
    result.append("\"toName\"=" + prettyPrintValue(fToName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBusSelector == null) ? 0 : fBusSelector.hashCode());
    result = prime * result + ((fFrom == null) ? 0 : fFrom.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    result = prime * result + ((fToName == null) ? 0 : fToName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BusSignalMappingSourceMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BusSignalMappingSourceMatch other = (BusSignalMappingSourceMatch) obj;
    if (fBusSelector == null) {if (other.fBusSelector != null) return false;}
    else if (!fBusSelector.equals(other.fBusSelector)) return false;
    if (fFrom == null) {if (other.fFrom != null) return false;}
    else if (!fFrom.equals(other.fFrom)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    if (fToName == null) {if (other.fToName != null) return false;}
    else if (!fToName.equals(other.fToName)) return false;
    return true;
  }
  
  @Override
  public BusSignalMappingSourceQuerySpecification specification() {
    try {
    	return BusSignalMappingSourceQuerySpecification.instance();
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
  public static BusSignalMappingSourceMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BusSignalMappingSourceMatch newMutableMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    return new Mutable(pBusSelector, pFrom, pName, pToName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBusSelector the fixed value of pattern parameter busSelector, or null if not bound.
   * @param pFrom the fixed value of pattern parameter from, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pToName the fixed value of pattern parameter toName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BusSignalMappingSourceMatch newMatch(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
    return new Immutable(pBusSelector, pFrom, pName, pToName);
    
  }
  
  private static final class Mutable extends BusSignalMappingSourceMatch {
    Mutable(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
      super(pBusSelector, pFrom, pName, pToName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BusSignalMappingSourceMatch {
    Immutable(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName) {
      super(pBusSelector, pFrom, pName, pToName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
