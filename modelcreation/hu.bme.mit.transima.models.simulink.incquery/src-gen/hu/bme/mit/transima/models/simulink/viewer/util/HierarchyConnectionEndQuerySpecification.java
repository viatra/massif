package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.viewer.HierarchyConnectionEndMatch;
import hu.bme.mit.transima.models.simulink.viewer.HierarchyConnectionEndMatcher;
import hu.bme.mit.transima.models.simulink.viewer.util.PortOfPortBlockQuerySpecification;
import hu.bme.mit.transima.models.simulink.viewer.util.PortOfSimpleBlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate HierarchyConnectionEndMatcher in a type-safe way.
 * 
 * @see HierarchyConnectionEndMatcher
 * @see HierarchyConnectionEndMatch
 * 
 */
@SuppressWarnings("all")
public final class HierarchyConnectionEndQuerySpecification extends BaseGeneratedQuerySpecification<HierarchyConnectionEndMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HierarchyConnectionEndQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected HierarchyConnectionEndMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HierarchyConnectionEndMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.hierarchyConnectionEnd";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("port","block");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("port", "hu.bme.mit.transima.Simulink.Port"),new PParameter("block", "hu.bme.mit.transima.Simulink.Block"));
  }
  
  @Override
  public HierarchyConnectionEndMatch newEmptyMatch() {
    return HierarchyConnectionEndMatch.newEmptyMatch();
  }
  
  @Override
  public HierarchyConnectionEndMatch newMatch(final Object... parameters) {
    return HierarchyConnectionEndMatch.newMatch((hu.bme.mit.transima.Simulink.Port) parameters[0], (hu.bme.mit.transima.Simulink.Block) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_port = body.getOrCreateVariableByName("port");
      PVariable var_block = body.getOrCreateVariableByName("block");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_port, "port"), 
        new ExportedParameter(body, var_block, "block")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_port, var_block), PortOfPortBlockQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_port = body.getOrCreateVariableByName("port");
      PVariable var_block = body.getOrCreateVariableByName("block");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_port, "port"), 
        new ExportedParameter(body, var_block, "block")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_port, var_block), PortOfSimpleBlockQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static HierarchyConnectionEndQuerySpecification INSTANCE = make();
    
    public static HierarchyConnectionEndQuerySpecification make() {
      return new HierarchyConnectionEndQuerySpecification();					
      
    }
  }
}
