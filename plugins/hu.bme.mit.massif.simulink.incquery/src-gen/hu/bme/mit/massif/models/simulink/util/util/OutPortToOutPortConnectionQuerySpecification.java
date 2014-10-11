package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.OutPortToOutPortConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.OutPortToOutPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.util.BusSpecificationInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleOutPortToOutPortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate OutPortToOutPortConnectionMatcher in a type-safe way.
 * 
 * @see OutPortToOutPortConnectionMatcher
 * @see OutPortToOutPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class OutPortToOutPortConnectionQuerySpecification extends BaseGeneratedQuerySpecification<OutPortToOutPortConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OutPortToOutPortConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected OutPortToOutPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OutPortToOutPortConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.outPortToOutPortConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("sourceOutPort","targetOutPort");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceOutPort", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("targetOutPort", "hu.bme.mit.massif.simulink.OutPort"));
  }
  
  @Override
  public OutPortToOutPortConnectionMatch newEmptyMatch() {
    return OutPortToOutPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public OutPortToOutPortConnectionMatch newMatch(final Object... parameters) {
    return OutPortToOutPortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      PVariable var__pc = body.getOrCreateVariableByName("_pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_targetOutPort, var__pc), SimpleOutPortToOutPortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      PVariable var_busInPort = body.getOrCreateVariableByName("busInPort");
      PVariable var__pc = body.getOrCreateVariableByName("_pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_busInPort, var__pc), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_busInPort, var_targetOutPort), BusSpecificationInPortToOutPortQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OutPortToOutPortConnectionQuerySpecification INSTANCE = make();
    
    public static OutPortToOutPortConnectionQuerySpecification make() {
      return new OutPortToOutPortConnectionQuerySpecification();					
      
    }
  }
}
