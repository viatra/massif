package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.util.PortBlockInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.util.portBlockInPortToOutPort pattern,
 * to be used in conjunction with {@link PortBlockInPortToOutPortMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PortBlockInPortToOutPortMatcher
 * @see PortBlockInPortToOutPortProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PortBlockInPortToOutPortMatch extends BasePatternMatch {
  private InPort fInPortOfPBl;
  
  private OutPort fOutPort;
  
  private static List<String> parameterNames = makeImmutableList("inPortOfPBl", "outPort");
  
  private PortBlockInPortToOutPortMatch(final InPort pInPortOfPBl, final OutPort pOutPort) {
    this.fInPortOfPBl = pInPortOfPBl;
    this.fOutPort = pOutPort;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("inPortOfPBl".equals(parameterName)) return this.fInPortOfPBl;
    if ("outPort".equals(parameterName)) return this.fOutPort;
    return null;
  }
  
  public InPort getInPortOfPBl() {
    return this.fInPortOfPBl;
  }
  
  public OutPort getOutPort() {
    return this.fOutPort;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("inPortOfPBl".equals(parameterName) ) {
    	this.fInPortOfPBl = (hu.bme.mit.massif.simulink.InPort) newValue;
    	return true;
    }
    if ("outPort".equals(parameterName) ) {
    	this.fOutPort = (hu.bme.mit.massif.simulink.OutPort) newValue;
    	return true;
    }
    return false;
  }
  
  public void setInPortOfPBl(final InPort pInPortOfPBl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInPortOfPBl = pInPortOfPBl;
  }
  
  public void setOutPort(final OutPort pOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOutPort = pOutPort;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.util.portBlockInPortToOutPort";
  }
  
  @Override
  public List<String> parameterNames() {
    return PortBlockInPortToOutPortMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fInPortOfPBl, fOutPort};
  }
  
  @Override
  public PortBlockInPortToOutPortMatch toImmutable() {
    return isMutable() ? newMatch(fInPortOfPBl, fOutPort) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"inPortOfPBl\"=" + prettyPrintValue(fInPortOfPBl) + ", ");
    
    result.append("\"outPort\"=" + prettyPrintValue(fOutPort)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fInPortOfPBl == null) ? 0 : fInPortOfPBl.hashCode());
    result = prime * result + ((fOutPort == null) ? 0 : fOutPort.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PortBlockInPortToOutPortMatch)) { // this should be infrequent
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
    PortBlockInPortToOutPortMatch other = (PortBlockInPortToOutPortMatch) obj;
    if (fInPortOfPBl == null) {if (other.fInPortOfPBl != null) return false;}
    else if (!fInPortOfPBl.equals(other.fInPortOfPBl)) return false;
    if (fOutPort == null) {if (other.fOutPort != null) return false;}
    else if (!fOutPort.equals(other.fOutPort)) return false;
    return true;
  }
  
  @Override
  public PortBlockInPortToOutPortQuerySpecification specification() {
    try {
    	return PortBlockInPortToOutPortQuerySpecification.instance();
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
  public static PortBlockInPortToOutPortMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PortBlockInPortToOutPortMatch newMutableMatch(final InPort pInPortOfPBl, final OutPort pOutPort) {
    return new Mutable(pInPortOfPBl, pOutPort);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PortBlockInPortToOutPortMatch newMatch(final InPort pInPortOfPBl, final OutPort pOutPort) {
    return new Immutable(pInPortOfPBl, pOutPort);
  }
  
  private static final class Mutable extends PortBlockInPortToOutPortMatch {
    Mutable(final InPort pInPortOfPBl, final OutPort pOutPort) {
      super(pInPortOfPBl, pOutPort);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PortBlockInPortToOutPortMatch {
    Immutable(final InPort pInPortOfPBl, final OutPort pOutPort) {
      super(pInPortOfPBl, pOutPort);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
