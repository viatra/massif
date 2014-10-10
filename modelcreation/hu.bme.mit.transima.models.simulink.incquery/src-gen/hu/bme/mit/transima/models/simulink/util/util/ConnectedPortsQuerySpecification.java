package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.ConnectedPortsMatch;
import hu.bme.mit.transima.models.simulink.util.ConnectedPortsMatcher;
import hu.bme.mit.transima.models.simulink.util.util.ConnectedInPortsQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ConnectedPortsMatcher in a type-safe way.
 * 
 * @see ConnectedPortsMatcher
 * @see ConnectedPortsMatch
 * 
 */
@SuppressWarnings("all")
public final class ConnectedPortsQuerySpecification extends BaseGeneratedQuerySpecification<ConnectedPortsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ConnectedPortsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected ConnectedPortsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ConnectedPortsMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.connectedPorts";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("outP","inP","firstPC");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("outP", "hu.bme.mit.transima.Simulink.OutPort"),new PParameter("inP", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("firstPC", "hu.bme.mit.transima.Simulink.SingleConnection"));
  }
  
  public ConnectedPortsMatch newEmptyMatch() {
    return ConnectedPortsMatch.newEmptyMatch();
  }
  
  public ConnectedPortsMatch newMatch(final Object... parameters) {
    return ConnectedPortsMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) parameters[0], (hu.bme.mit.transima.Simulink.InPort) parameters[1], (hu.bme.mit.transima.Simulink.SingleConnection) parameters[2]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_outP = body.getOrCreateVariableByName("outP");
      PVariable var_inP = body.getOrCreateVariableByName("inP");
      PVariable var_firstPC = body.getOrCreateVariableByName("firstPC");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outP, "outP"), 
        new ExportedParameter(body, var_inP, "inP"), 
        new ExportedParameter(body, var_firstPC, "firstPC")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_outP, var_inP, var_firstPC), PortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_outP = body.getOrCreateVariableByName("outP");
      PVariable var_inP = body.getOrCreateVariableByName("inP");
      PVariable var_firstPC = body.getOrCreateVariableByName("firstPC");
      PVariable var_innerIP = body.getOrCreateVariableByName("innerIP");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outP, "outP"), 
        new ExportedParameter(body, var_inP, "inP"), 
        new ExportedParameter(body, var_firstPC, "firstPC")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_outP, var_innerIP, var_firstPC), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_innerIP, var_inP), ConnectedInPortsQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ConnectedPortsQuerySpecification INSTANCE = make();
    
    public static ConnectedPortsQuerySpecification make() {
      return new ConnectedPortsQuerySpecification();					
      
    }
  }
}
