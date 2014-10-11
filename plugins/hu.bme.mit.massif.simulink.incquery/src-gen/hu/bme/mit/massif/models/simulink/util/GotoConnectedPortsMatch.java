package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.util.GotoConnectedPortsQuerySpecification;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.util.gotoConnectedPorts pattern,
 * to be used in conjunction with {@link GotoConnectedPortsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GotoConnectedPortsMatcher
 * @see GotoConnectedPortsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GotoConnectedPortsMatch extends BasePatternMatch {
  private InPort fGotoInPort;
  
  private OutPort fFromOutPort;
  
  private static List<String> parameterNames = makeImmutableList("gotoInPort", "fromOutPort");
  
  private GotoConnectedPortsMatch(final InPort pGotoInPort, final OutPort pFromOutPort) {
    this.fGotoInPort = pGotoInPort;
    this.fFromOutPort = pFromOutPort;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("gotoInPort".equals(parameterName)) return this.fGotoInPort;
    if ("fromOutPort".equals(parameterName)) return this.fFromOutPort;
    return null;
    
  }
  
  public InPort getGotoInPort() {
    return this.fGotoInPort;
    
  }
  
  public OutPort getFromOutPort() {
    return this.fFromOutPort;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("gotoInPort".equals(parameterName) ) {
    	this.fGotoInPort = (hu.bme.mit.massif.simulink.InPort) newValue;
    	return true;
    }
    if ("fromOutPort".equals(parameterName) ) {
    	this.fFromOutPort = (hu.bme.mit.massif.simulink.OutPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setGotoInPort(final InPort pGotoInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGotoInPort = pGotoInPort;
    
  }
  
  public void setFromOutPort(final OutPort pFromOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFromOutPort = pFromOutPort;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.util.gotoConnectedPorts";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return GotoConnectedPortsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fGotoInPort, fFromOutPort};
    
  }
  
  @Override
  public GotoConnectedPortsMatch toImmutable() {
    return isMutable() ? newMatch(fGotoInPort, fFromOutPort) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"gotoInPort\"=" + prettyPrintValue(fGotoInPort) + ", ");
    result.append("\"fromOutPort\"=" + prettyPrintValue(fFromOutPort));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fGotoInPort == null) ? 0 : fGotoInPort.hashCode());
    result = prime * result + ((fFromOutPort == null) ? 0 : fFromOutPort.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof GotoConnectedPortsMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    GotoConnectedPortsMatch other = (GotoConnectedPortsMatch) obj;
    if (fGotoInPort == null) {if (other.fGotoInPort != null) return false;}
    else if (!fGotoInPort.equals(other.fGotoInPort)) return false;
    if (fFromOutPort == null) {if (other.fFromOutPort != null) return false;}
    else if (!fFromOutPort.equals(other.fFromOutPort)) return false;
    return true;
  }
  
  @Override
  public GotoConnectedPortsQuerySpecification specification() {
    try {
    	return GotoConnectedPortsQuerySpecification.instance();
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
  public static GotoConnectedPortsMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GotoConnectedPortsMatch newMutableMatch(final InPort pGotoInPort, final OutPort pFromOutPort) {
    return new Mutable(pGotoInPort, pFromOutPort);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static GotoConnectedPortsMatch newMatch(final InPort pGotoInPort, final OutPort pFromOutPort) {
    return new Immutable(pGotoInPort, pFromOutPort);
    
  }
  
  private static final class Mutable extends GotoConnectedPortsMatch {
    Mutable(final InPort pGotoInPort, final OutPort pFromOutPort) {
      super(pGotoInPort, pFromOutPort);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GotoConnectedPortsMatch {
    Immutable(final InPort pGotoInPort, final OutPort pFromOutPort) {
      super(pGotoInPort, pFromOutPort);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
