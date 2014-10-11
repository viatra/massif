package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.BusSelector;
import hu.bme.mit.transima.Simulink.BusSignalMapping;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.util.BusMappingInSelectorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.busMappingInSelector pattern,
 * to be used in conjunction with {@link BusMappingInSelectorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BusMappingInSelectorMatcher
 * @see BusMappingInSelectorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BusMappingInSelectorMatch extends BasePatternMatch {
  private BusSelector fSelector;
  
  private BusSignalMapping fMapping;
  
  private OutPort fMappingFrom;
  
  private OutPort fMappingTo;
  
  private static List<String> parameterNames = makeImmutableList("selector", "mapping", "mappingFrom", "mappingTo");
  
  private BusMappingInSelectorMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    this.fSelector = pSelector;
    this.fMapping = pMapping;
    this.fMappingFrom = pMappingFrom;
    this.fMappingTo = pMappingTo;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("selector".equals(parameterName)) return this.fSelector;
    if ("mapping".equals(parameterName)) return this.fMapping;
    if ("mappingFrom".equals(parameterName)) return this.fMappingFrom;
    if ("mappingTo".equals(parameterName)) return this.fMappingTo;
    return null;
    
  }
  
  public BusSelector getSelector() {
    return this.fSelector;
    
  }
  
  public BusSignalMapping getMapping() {
    return this.fMapping;
    
  }
  
  public OutPort getMappingFrom() {
    return this.fMappingFrom;
    
  }
  
  public OutPort getMappingTo() {
    return this.fMappingTo;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("selector".equals(parameterName) ) {
    	this.fSelector = (hu.bme.mit.transima.Simulink.BusSelector) newValue;
    	return true;
    }
    if ("mapping".equals(parameterName) ) {
    	this.fMapping = (hu.bme.mit.transima.Simulink.BusSignalMapping) newValue;
    	return true;
    }
    if ("mappingFrom".equals(parameterName) ) {
    	this.fMappingFrom = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    if ("mappingTo".equals(parameterName) ) {
    	this.fMappingTo = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSelector(final BusSelector pSelector) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSelector = pSelector;
    
  }
  
  public void setMapping(final BusSignalMapping pMapping) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMapping = pMapping;
    
  }
  
  public void setMappingFrom(final OutPort pMappingFrom) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMappingFrom = pMappingFrom;
    
  }
  
  public void setMappingTo(final OutPort pMappingTo) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMappingTo = pMappingTo;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.busMappingInSelector";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BusMappingInSelectorMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSelector, fMapping, fMappingFrom, fMappingTo};
    
  }
  
  @Override
  public BusMappingInSelectorMatch toImmutable() {
    return isMutable() ? newMatch(fSelector, fMapping, fMappingFrom, fMappingTo) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"selector\"=" + prettyPrintValue(fSelector) + ", ");
    result.append("\"mapping\"=" + prettyPrintValue(fMapping) + ", ");
    result.append("\"mappingFrom\"=" + prettyPrintValue(fMappingFrom) + ", ");
    result.append("\"mappingTo\"=" + prettyPrintValue(fMappingTo));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSelector == null) ? 0 : fSelector.hashCode());
    result = prime * result + ((fMapping == null) ? 0 : fMapping.hashCode());
    result = prime * result + ((fMappingFrom == null) ? 0 : fMappingFrom.hashCode());
    result = prime * result + ((fMappingTo == null) ? 0 : fMappingTo.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BusMappingInSelectorMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BusMappingInSelectorMatch other = (BusMappingInSelectorMatch) obj;
    if (fSelector == null) {if (other.fSelector != null) return false;}
    else if (!fSelector.equals(other.fSelector)) return false;
    if (fMapping == null) {if (other.fMapping != null) return false;}
    else if (!fMapping.equals(other.fMapping)) return false;
    if (fMappingFrom == null) {if (other.fMappingFrom != null) return false;}
    else if (!fMappingFrom.equals(other.fMappingFrom)) return false;
    if (fMappingTo == null) {if (other.fMappingTo != null) return false;}
    else if (!fMappingTo.equals(other.fMappingTo)) return false;
    return true;
  }
  
  @Override
  public BusMappingInSelectorQuerySpecification specification() {
    try {
    	return BusMappingInSelectorQuerySpecification.instance();
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
  public static BusMappingInSelectorMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BusMappingInSelectorMatch newMutableMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return new Mutable(pSelector, pMapping, pMappingFrom, pMappingTo);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSelector the fixed value of pattern parameter selector, or null if not bound.
   * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
   * @param pMappingFrom the fixed value of pattern parameter mappingFrom, or null if not bound.
   * @param pMappingTo the fixed value of pattern parameter mappingTo, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BusMappingInSelectorMatch newMatch(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
    return new Immutable(pSelector, pMapping, pMappingFrom, pMappingTo);
    
  }
  
  private static final class Mutable extends BusMappingInSelectorMatch {
    Mutable(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
      super(pSelector, pMapping, pMappingFrom, pMappingTo);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BusMappingInSelectorMatch {
    Immutable(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo) {
      super(pSelector, pMapping, pMappingFrom, pMappingTo);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
