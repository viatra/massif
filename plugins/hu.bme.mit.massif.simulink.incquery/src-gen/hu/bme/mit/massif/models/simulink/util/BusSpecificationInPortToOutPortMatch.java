package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.util.BusSpecificationInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.util.busSpecificationInPortToOutPort pattern,
 * to be used in conjunction with {@link BusSpecificationInPortToOutPortMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BusSpecificationInPortToOutPortMatcher
 * @see BusSpecificationInPortToOutPortProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BusSpecificationInPortToOutPortMatch extends BasePatternMatch {
  private InPort fInportOfBS;
  
  private OutPort fOutPortOfBS;
  
  private static List<String> parameterNames = makeImmutableList("inportOfBS", "outPortOfBS");
  
  private BusSpecificationInPortToOutPortMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    this.fInportOfBS = pInportOfBS;
    this.fOutPortOfBS = pOutPortOfBS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("inportOfBS".equals(parameterName)) return this.fInportOfBS;
    if ("outPortOfBS".equals(parameterName)) return this.fOutPortOfBS;
    return null;
    
  }
  
  public InPort getInportOfBS() {
    return this.fInportOfBS;
    
  }
  
  public OutPort getOutPortOfBS() {
    return this.fOutPortOfBS;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("inportOfBS".equals(parameterName) ) {
    	this.fInportOfBS = (hu.bme.mit.massif.simulink.InPort) newValue;
    	return true;
    }
    if ("outPortOfBS".equals(parameterName) ) {
    	this.fOutPortOfBS = (hu.bme.mit.massif.simulink.OutPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setInportOfBS(final InPort pInportOfBS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInportOfBS = pInportOfBS;
    
  }
  
  public void setOutPortOfBS(final OutPort pOutPortOfBS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOutPortOfBS = pOutPortOfBS;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.util.busSpecificationInPortToOutPort";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BusSpecificationInPortToOutPortMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fInportOfBS, fOutPortOfBS};
    
  }
  
  @Override
  public BusSpecificationInPortToOutPortMatch toImmutable() {
    return isMutable() ? newMatch(fInportOfBS, fOutPortOfBS) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"inportOfBS\"=" + prettyPrintValue(fInportOfBS) + ", ");
    result.append("\"outPortOfBS\"=" + prettyPrintValue(fOutPortOfBS));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fInportOfBS == null) ? 0 : fInportOfBS.hashCode());
    result = prime * result + ((fOutPortOfBS == null) ? 0 : fOutPortOfBS.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BusSpecificationInPortToOutPortMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BusSpecificationInPortToOutPortMatch other = (BusSpecificationInPortToOutPortMatch) obj;
    if (fInportOfBS == null) {if (other.fInportOfBS != null) return false;}
    else if (!fInportOfBS.equals(other.fInportOfBS)) return false;
    if (fOutPortOfBS == null) {if (other.fOutPortOfBS != null) return false;}
    else if (!fOutPortOfBS.equals(other.fOutPortOfBS)) return false;
    return true;
  }
  
  @Override
  public BusSpecificationInPortToOutPortQuerySpecification specification() {
    try {
    	return BusSpecificationInPortToOutPortQuerySpecification.instance();
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
  public static BusSpecificationInPortToOutPortMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BusSpecificationInPortToOutPortMatch newMutableMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return new Mutable(pInportOfBS, pOutPortOfBS);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BusSpecificationInPortToOutPortMatch newMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return new Immutable(pInportOfBS, pOutPortOfBS);
    
  }
  
  private static final class Mutable extends BusSpecificationInPortToOutPortMatch {
    Mutable(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
      super(pInportOfBS, pOutPortOfBS);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BusSpecificationInPortToOutPortMatch {
    Immutable(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
      super(pInportOfBS, pOutPortOfBS);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
