package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.Simulink.SingleConnection;
import hu.bme.mit.transima.models.simulink.util.util.PortConnectionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.portConnection pattern,
 * to be used in conjunction with {@link PortConnectionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PortConnectionMatcher
 * @see PortConnectionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PortConnectionMatch extends BasePatternMatch {
  private OutPort fOutP;
  
  private InPort fInP;
  
  private SingleConnection fPc;
  
  private static List<String> parameterNames = makeImmutableList("outP", "inP", "pc");
  
  private PortConnectionMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    this.fOutP = pOutP;
    this.fInP = pInP;
    this.fPc = pPc;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("outP".equals(parameterName)) return this.fOutP;
    if ("inP".equals(parameterName)) return this.fInP;
    if ("pc".equals(parameterName)) return this.fPc;
    return null;
    
  }
  
  public OutPort getOutP() {
    return this.fOutP;
    
  }
  
  public InPort getInP() {
    return this.fInP;
    
  }
  
  public SingleConnection getPc() {
    return this.fPc;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("outP".equals(parameterName) ) {
    	this.fOutP = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    if ("inP".equals(parameterName) ) {
    	this.fInP = (hu.bme.mit.transima.Simulink.InPort) newValue;
    	return true;
    }
    if ("pc".equals(parameterName) ) {
    	this.fPc = (hu.bme.mit.transima.Simulink.SingleConnection) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setOutP(final OutPort pOutP) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOutP = pOutP;
    
  }
  
  public void setInP(final InPort pInP) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInP = pInP;
    
  }
  
  public void setPc(final SingleConnection pPc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPc = pPc;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.portConnection";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PortConnectionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOutP, fInP, fPc};
    
  }
  
  @Override
  public PortConnectionMatch toImmutable() {
    return isMutable() ? newMatch(fOutP, fInP, fPc) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"outP\"=" + prettyPrintValue(fOutP) + ", ");
    result.append("\"inP\"=" + prettyPrintValue(fInP) + ", ");
    result.append("\"pc\"=" + prettyPrintValue(fPc));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOutP == null) ? 0 : fOutP.hashCode());
    result = prime * result + ((fInP == null) ? 0 : fInP.hashCode());
    result = prime * result + ((fPc == null) ? 0 : fPc.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PortConnectionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PortConnectionMatch other = (PortConnectionMatch) obj;
    if (fOutP == null) {if (other.fOutP != null) return false;}
    else if (!fOutP.equals(other.fOutP)) return false;
    if (fInP == null) {if (other.fInP != null) return false;}
    else if (!fInP.equals(other.fInP)) return false;
    if (fPc == null) {if (other.fPc != null) return false;}
    else if (!fPc.equals(other.fPc)) return false;
    return true;
  }
  
  @Override
  public PortConnectionQuerySpecification specification() {
    try {
    	return PortConnectionQuerySpecification.instance();
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
  public static PortConnectionMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PortConnectionMatch newMutableMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return new Mutable(pOutP, pInP, pPc);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PortConnectionMatch newMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return new Immutable(pOutP, pInP, pPc);
    
  }
  
  private static final class Mutable extends PortConnectionMatch {
    Mutable(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
      super(pOutP, pInP, pPc);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PortConnectionMatch {
    Immutable(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
      super(pOutP, pInP, pPc);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
