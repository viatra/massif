package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.SimpleOutPortToOutPortConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.SimpleOutPortToOutPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.util.GotoConnectedPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.InPortToBlockPortOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortBlockInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SimpleOutPortToOutPortConnectionMatcher in a type-safe way.
 * 
 * @see SimpleOutPortToOutPortConnectionMatcher
 * @see SimpleOutPortToOutPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class SimpleOutPortToOutPortConnectionQuerySpecification extends BaseGeneratedQuerySpecification<SimpleOutPortToOutPortConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SimpleOutPortToOutPortConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SimpleOutPortToOutPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SimpleOutPortToOutPortConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.simpleOutPortToOutPortConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("sourceOutPort","targetOutPort","connection");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceOutPort", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("targetOutPort", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("connection", "hu.bme.mit.massif.simulink.SingleConnection"));
  }
  
  @Override
  public SimpleOutPortToOutPortConnectionMatch newEmptyMatch() {
    return SimpleOutPortToOutPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public SimpleOutPortToOutPortConnectionMatch newMatch(final Object... parameters) {
    return SimpleOutPortToOutPortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1], (hu.bme.mit.massif.simulink.SingleConnection) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      PVariable var_connection = body.getOrCreateVariableByName("connection");
      PVariable var_gotoInPort = body.getOrCreateVariableByName("gotoInPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort"), 
        new ExportedParameter(body, var_connection, "connection")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_gotoInPort, var_connection), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_gotoInPort, var_targetOutPort), GotoConnectedPortsQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      PVariable var_connection = body.getOrCreateVariableByName("connection");
      PVariable var_pBlIn = body.getOrCreateVariableByName("pBlIn");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort"), 
        new ExportedParameter(body, var_connection, "connection")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_pBlIn, var_connection), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_pBlIn, var_targetOutPort), PortBlockInPortToOutPortQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      PVariable var_connection = body.getOrCreateVariableByName("connection");
      PVariable var_inPort = body.getOrCreateVariableByName("inPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort"), 
        new ExportedParameter(body, var_connection, "connection")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_inPort, var_connection), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_inPort, var_targetOutPort), InPortToBlockPortOutPortQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SimpleOutPortToOutPortConnectionQuerySpecification INSTANCE = make();
    
    public static SimpleOutPortToOutPortConnectionQuerySpecification make() {
      return new SimpleOutPortToOutPortConnectionQuerySpecification();					
      
    }
  }
}
