package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.util.ConnectedPortsQuerySpecification;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SingleConnection;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.util.connectedPorts pattern,
 * to be used in conjunction with {@link ConnectedPortsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ConnectedPortsMatcher
 * @see ConnectedPortsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ConnectedPortsMatch extends BasePatternMatch {
  private OutPort fOutP;
  
  private InPort fInP;
  
  private SingleConnection fFirstPC;
  
  private static List<String> parameterNames = makeImmutableList("outP", "inP", "firstPC");
  
  private ConnectedPortsMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    this.fOutP = pOutP;
    this.fInP = pInP;
    this.fFirstPC = pFirstPC;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("outP".equals(parameterName)) return this.fOutP;
    if ("inP".equals(parameterName)) return this.fInP;
    if ("firstPC".equals(parameterName)) return this.fFirstPC;
    return null;
  }
  
  public OutPort getOutP() {
    return this.fOutP;
  }
  
  public InPort getInP() {
    return this.fInP;
  }
  
  public SingleConnection getFirstPC() {
    return this.fFirstPC;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("outP".equals(parameterName) ) {
    	this.fOutP = (hu.bme.mit.massif.simulink.OutPort) newValue;
    	return true;
    }
    if ("inP".equals(parameterName) ) {
    	this.fInP = (hu.bme.mit.massif.simulink.InPort) newValue;
    	return true;
    }
    if ("firstPC".equals(parameterName) ) {
    	this.fFirstPC = (hu.bme.mit.massif.simulink.SingleConnection) newValue;
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
  
  public void setFirstPC(final SingleConnection pFirstPC) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFirstPC = pFirstPC;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.util.connectedPorts";
  }
  
  @Override
  public List<String> parameterNames() {
    return ConnectedPortsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOutP, fInP, fFirstPC};
  }
  
  @Override
  public ConnectedPortsMatch toImmutable() {
    return isMutable() ? newMatch(fOutP, fInP, fFirstPC) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"outP\"=" + prettyPrintValue(fOutP) + ", ");
    
    result.append("\"inP\"=" + prettyPrintValue(fInP) + ", ");
    
    result.append("\"firstPC\"=" + prettyPrintValue(fFirstPC)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOutP == null) ? 0 : fOutP.hashCode());
    result = prime * result + ((fInP == null) ? 0 : fInP.hashCode());
    result = prime * result + ((fFirstPC == null) ? 0 : fFirstPC.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ConnectedPortsMatch)) { // this should be infrequent
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
    ConnectedPortsMatch other = (ConnectedPortsMatch) obj;
    if (fOutP == null) {if (other.fOutP != null) return false;}
    else if (!fOutP.equals(other.fOutP)) return false;
    if (fInP == null) {if (other.fInP != null) return false;}
    else if (!fInP.equals(other.fInP)) return false;
    if (fFirstPC == null) {if (other.fFirstPC != null) return false;}
    else if (!fFirstPC.equals(other.fFirstPC)) return false;
    return true;
  }
  
  @Override
  public ConnectedPortsQuerySpecification specification() {
    try {
    	return ConnectedPortsQuerySpecification.instance();
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
  public static ConnectedPortsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ConnectedPortsMatch newMutableMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    return new Mutable(pOutP, pInP, pFirstPC);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ConnectedPortsMatch newMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    return new Immutable(pOutP, pInP, pFirstPC);
  }
  
  private static final class Mutable extends ConnectedPortsMatch {
    Mutable(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
      super(pOutP, pInP, pFirstPC);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ConnectedPortsMatch {
    Immutable(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
      super(pOutP, pInP, pFirstPC);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
