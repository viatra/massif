package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.BusMappingInSelectorMatch;
import hu.bme.mit.massif.models.simulink.util.BusMappingInSelectorMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate BusMappingInSelectorMatcher in a type-safe way.
 * 
 * @see BusMappingInSelectorMatcher
 * @see BusMappingInSelectorMatch
 * 
 */
@SuppressWarnings("all")
public final class BusMappingInSelectorQuerySpecification extends BaseGeneratedEMFQuerySpecification<BusMappingInSelectorMatcher> {
  private BusMappingInSelectorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BusMappingInSelectorQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected BusMappingInSelectorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BusMappingInSelectorMatcher.on(engine);
  }
  
  @Override
  public BusMappingInSelectorMatch newEmptyMatch() {
    return BusMappingInSelectorMatch.newEmptyMatch();
  }
  
  @Override
  public BusMappingInSelectorMatch newMatch(final Object... parameters) {
    return BusMappingInSelectorMatch.newMatch((hu.bme.mit.massif.simulink.BusSelector) parameters[0], (hu.bme.mit.massif.simulink.BusSignalMapping) parameters[1], (hu.bme.mit.massif.simulink.OutPort) parameters[2], (hu.bme.mit.massif.simulink.OutPort) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static BusMappingInSelectorQuerySpecification INSTANCE = make();
    
    public static BusMappingInSelectorQuerySpecification make() {
      return new BusMappingInSelectorQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static BusMappingInSelectorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.busMappingInSelector";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("selector","mapping","mappingFrom","mappingTo");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("selector", "hu.bme.mit.massif.simulink.BusSelector"),new PParameter("mapping", "hu.bme.mit.massif.simulink.BusSignalMapping"),new PParameter("mappingFrom", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("mappingTo", "hu.bme.mit.massif.simulink.OutPort"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
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
      	new TypeBinary(body, CONTEXT, var_selector, var_mapping, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "BusSelector", "mappings"), "http://hu.bme.mit.massif/simulink/1.0/BusSelector.mappings");
      	new TypeBinary(body, CONTEXT, var_mapping, var_mappingFrom, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "BusSignalMapping", "mappingFrom"), "http://hu.bme.mit.massif/simulink/1.0/BusSignalMapping.mappingFrom");
      	new TypeBinary(body, CONTEXT, var_mapping, var_mappingTo, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "BusSignalMapping", "mappingTo"), "http://hu.bme.mit.massif/simulink/1.0/BusSignalMapping.mappingTo");
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
