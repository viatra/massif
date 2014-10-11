package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.PortConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.PortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.util.MultiConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate PortConnectionMatcher in a type-safe way.
 * 
 * @see PortConnectionMatcher
 * @see PortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class PortConnectionQuerySpecification extends BaseGeneratedQuerySpecification<PortConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected PortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.portConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("outP","inP","pc");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("outP", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("inP", "hu.bme.mit.massif.simulink.InPort"),new PParameter("pc", "hu.bme.mit.massif.simulink.SingleConnection"));
  }
  
  @Override
  public PortConnectionMatch newEmptyMatch() {
    return PortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public PortConnectionMatch newMatch(final Object... parameters) {
    return PortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.InPort) parameters[1], (hu.bme.mit.massif.simulink.SingleConnection) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_outP = body.getOrCreateVariableByName("outP");
      PVariable var_inP = body.getOrCreateVariableByName("inP");
      PVariable var_pc = body.getOrCreateVariableByName("pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outP, "outP"), 
        new ExportedParameter(body, var_inP, "inP"), 
        new ExportedParameter(body, var_pc, "pc")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_outP, var_inP, var_pc), SimpleConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_outP = body.getOrCreateVariableByName("outP");
      PVariable var_inP = body.getOrCreateVariableByName("inP");
      PVariable var_pc = body.getOrCreateVariableByName("pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outP, "outP"), 
        new ExportedParameter(body, var_inP, "inP"), 
        new ExportedParameter(body, var_pc, "pc")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_outP, var_inP, var_pc), MultiConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static PortConnectionQuerySpecification INSTANCE = make();
    
    public static PortConnectionQuerySpecification make() {
      return new PortConnectionQuerySpecification();					
      
    }
  }
}
