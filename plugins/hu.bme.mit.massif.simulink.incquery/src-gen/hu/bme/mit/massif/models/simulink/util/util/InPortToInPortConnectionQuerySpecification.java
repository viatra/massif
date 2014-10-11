package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.InPortToInPortConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.InPortToInPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.util.BusSpecificationInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleInPortToInPortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate InPortToInPortConnectionMatcher in a type-safe way.
 * 
 * @see InPortToInPortConnectionMatcher
 * @see InPortToInPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class InPortToInPortConnectionQuerySpecification extends BaseGeneratedQuerySpecification<InPortToInPortConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InPortToInPortConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected InPortToInPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InPortToInPortConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.inPortToInPortConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("sourceInPort","targetInPort");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceInPort", "hu.bme.mit.massif.simulink.InPort"),new PParameter("targetInPort", "hu.bme.mit.massif.simulink.InPort"));
  }
  
  @Override
  public InPortToInPortConnectionMatch newEmptyMatch() {
    return InPortToInPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public InPortToInPortConnectionMatch newMatch(final Object... parameters) {
    return InPortToInPortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.InPort) parameters[0], (hu.bme.mit.massif.simulink.InPort) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      PVariable var__pc = body.getOrCreateVariableByName("_pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_targetInPort, var__pc), SimpleInPortToInPortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      PVariable var_outPortOfBS = body.getOrCreateVariableByName("outPortOfBS");
      PVariable var__pc = body.getOrCreateVariableByName("_pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_outPortOfBS), BusSpecificationInPortToOutPortQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_outPortOfBS, var_targetInPort, var__pc), PortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static InPortToInPortConnectionQuerySpecification INSTANCE = make();
    
    public static InPortToInPortConnectionQuerySpecification make() {
      return new InPortToInPortConnectionQuerySpecification();					
      
    }
  }
}
