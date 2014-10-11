package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.viewer.PortOfSimpleBlockMatch;
import hu.bme.mit.transima.models.simulink.viewer.PortOfSimpleBlockMatcher;
import hu.bme.mit.transima.models.simulink.viewer.util.BlockPortsQuerySpecification;
import hu.bme.mit.transima.models.simulink.viewer.util.PortOfPortBlockQuerySpecification;
import hu.bme.mit.transima.models.simulink.viewer.util.SubBlocksQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate PortOfSimpleBlockMatcher in a type-safe way.
 * 
 * @see PortOfSimpleBlockMatcher
 * @see PortOfSimpleBlockMatch
 * 
 */
@SuppressWarnings("all")
public final class PortOfSimpleBlockQuerySpecification extends BaseGeneratedQuerySpecification<PortOfSimpleBlockMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortOfSimpleBlockQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected PortOfSimpleBlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortOfSimpleBlockMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.portOfSimpleBlock";
    
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
  public PortOfSimpleBlockMatch newEmptyMatch() {
    return PortOfSimpleBlockMatch.newEmptyMatch();
  }
  
  @Override
  public PortOfSimpleBlockMatch newMatch(final Object... parameters) {
    return PortOfSimpleBlockMatch.newMatch((hu.bme.mit.transima.Simulink.Port) parameters[0], (hu.bme.mit.transima.Simulink.Block) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_port = body.getOrCreateVariableByName("port");
      PVariable var_block = body.getOrCreateVariableByName("block");
      PVariable var__t = body.getOrCreateVariableByName("_t");
      PVariable var__sub2 = body.getOrCreateVariableByName("_sub2");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_port, "port"), 
        new ExportedParameter(body, var_block, "block")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_block, var_port), BlockPortsQuerySpecification.instance());
      new NegativePatternCall(body, new FlatTuple(var_port, var__t), PortOfPortBlockQuerySpecification.instance().instance());
      new NegativePatternCall(body, new FlatTuple(var_block, var__sub2), SubBlocksQuerySpecification.instance().instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static PortOfSimpleBlockQuerySpecification INSTANCE = make();
    
    public static PortOfSimpleBlockQuerySpecification make() {
      return new PortOfSimpleBlockQuerySpecification();					
      
    }
  }
}
