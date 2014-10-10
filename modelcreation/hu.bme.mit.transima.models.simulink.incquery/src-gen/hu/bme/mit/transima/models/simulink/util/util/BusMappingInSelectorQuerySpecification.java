package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.BusMappingInSelectorMatch;
import hu.bme.mit.transima.models.simulink.util.BusMappingInSelectorMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate BusMappingInSelectorMatcher in a type-safe way.
 * 
 * @see BusMappingInSelectorMatcher
 * @see BusMappingInSelectorMatch
 * 
 */
@SuppressWarnings("all")
public final class BusMappingInSelectorQuerySpecification extends BaseGeneratedQuerySpecification<BusMappingInSelectorMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BusMappingInSelectorQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected BusMappingInSelectorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BusMappingInSelectorMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.busMappingInSelector";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("selector","mapping","mappingFrom","mappingTo");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("selector", "hu.bme.mit.transima.Simulink.BusSelector"),new PParameter("mapping", "hu.bme.mit.transima.Simulink.BusSignalMapping"),new PParameter("mappingFrom", "hu.bme.mit.transima.Simulink.OutPort"),new PParameter("mappingTo", "hu.bme.mit.transima.Simulink.OutPort"));
  }
  
  public BusMappingInSelectorMatch newEmptyMatch() {
    return BusMappingInSelectorMatch.newEmptyMatch();
  }
  
  public BusMappingInSelectorMatch newMatch(final Object... parameters) {
    return BusMappingInSelectorMatch.newMatch((hu.bme.mit.transima.Simulink.BusSelector) parameters[0], (hu.bme.mit.transima.Simulink.BusSignalMapping) parameters[1], (hu.bme.mit.transima.Simulink.OutPort) parameters[2], (hu.bme.mit.transima.Simulink.OutPort) parameters[3]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_selector = body.getOrCreateVariableByName("selector");
      PVariable var_mapping = body.getOrCreateVariableByName("mapping");
      PVariable var_mappingFrom = body.getOrCreateVariableByName("mappingFrom");
      PVariable var_mappingTo = body.getOrCreateVariableByName("mappingTo");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_selector, "selector"), 
        new ExportedParameter(body, var_mapping, "mapping"), 
        new ExportedParameter(body, var_mappingFrom, "mappingFrom"), 
        new ExportedParameter(body, var_mappingTo, "mappingTo")
      ));
      
      
      
      
      new TypeBinary(body, CONTEXT, var_selector, var_mapping, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "BusSelector", "mappings"), "http://hu.bme.mit.transima/simulink/1.0/BusSelector.mappings");
      new TypeBinary(body, CONTEXT, var_mapping, var_mappingFrom, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "BusSignalMapping", "mappingFrom"), "http://hu.bme.mit.transima/simulink/1.0/BusSignalMapping.mappingFrom");
      new TypeBinary(body, CONTEXT, var_mapping, var_mappingTo, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "BusSignalMapping", "mappingTo"), "http://hu.bme.mit.transima/simulink/1.0/BusSignalMapping.mappingTo");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BusMappingInSelectorQuerySpecification INSTANCE = make();
    
    public static BusMappingInSelectorQuerySpecification make() {
      return new BusMappingInSelectorQuerySpecification();					
      
    }
  }
}
