package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.SimpleInPortToInPortConnectionMatch;
import hu.bme.mit.transima.models.simulink.util.SimpleInPortToInPortConnectionMatcher;
import hu.bme.mit.transima.models.simulink.util.util.GotoConnectedPortsQuerySpecification;
import hu.bme.mit.transima.models.simulink.util.util.InPortToBlockPortOutPortQuerySpecification;
import hu.bme.mit.transima.models.simulink.util.util.PortBlockInPortToOutPortQuerySpecification;
import hu.bme.mit.transima.models.simulink.util.util.PortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SimpleInPortToInPortConnectionMatcher in a type-safe way.
 * 
 * @see SimpleInPortToInPortConnectionMatcher
 * @see SimpleInPortToInPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class SimpleInPortToInPortConnectionQuerySpecification extends BaseGeneratedQuerySpecification<SimpleInPortToInPortConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SimpleInPortToInPortConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SimpleInPortToInPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SimpleInPortToInPortConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.simpleInPortToInPortConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("sourceInPort","targetInPort","connection");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceInPort", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("targetInPort", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("connection", "hu.bme.mit.transima.Simulink.SingleConnection"));
  }
  
  @Override
  public SimpleInPortToInPortConnectionMatch newEmptyMatch() {
    return SimpleInPortToInPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public SimpleInPortToInPortConnectionMatch newMatch(final Object... parameters) {
    return SimpleInPortToInPortConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) parameters[0], (hu.bme.mit.transima.Simulink.InPort) parameters[1], (hu.bme.mit.transima.Simulink.SingleConnection) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      PVariable var_connection = body.getOrCreateVariableByName("connection");
      PVariable var_fromOutPort = body.getOrCreateVariableByName("fromOutPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort"), 
        new ExportedParameter(body, var_connection, "connection")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_fromOutPort), GotoConnectedPortsQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_fromOutPort, var_targetInPort, var_connection), PortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      PVariable var_connection = body.getOrCreateVariableByName("connection");
      PVariable var_plOut = body.getOrCreateVariableByName("plOut");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort"), 
        new ExportedParameter(body, var_connection, "connection")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_plOut), InPortToBlockPortOutPortQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_plOut, var_targetInPort, var_connection), PortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      PVariable var_connection = body.getOrCreateVariableByName("connection");
      PVariable var_outerOutPort = body.getOrCreateVariableByName("outerOutPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort"), 
        new ExportedParameter(body, var_connection, "connection")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_outerOutPort), PortBlockInPortToOutPortQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_outerOutPort, var_targetInPort, var_connection), PortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SimpleInPortToInPortConnectionQuerySpecification INSTANCE = make();
    
    public static SimpleInPortToInPortConnectionQuerySpecification make() {
      return new SimpleInPortToInPortConnectionQuerySpecification();					
      
    }
  }
}
