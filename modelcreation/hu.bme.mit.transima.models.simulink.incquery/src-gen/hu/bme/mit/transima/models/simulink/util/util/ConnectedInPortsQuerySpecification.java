package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.ConnectedInPortsMatch;
import hu.bme.mit.transima.models.simulink.util.ConnectedInPortsMatcher;
import hu.bme.mit.transima.models.simulink.util.util.InPortToInPortConnectionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ConnectedInPortsMatcher in a type-safe way.
 * 
 * @see ConnectedInPortsMatcher
 * @see ConnectedInPortsMatch
 * 
 */
@SuppressWarnings("all")
public final class ConnectedInPortsQuerySpecification extends BaseGeneratedQuerySpecification<ConnectedInPortsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ConnectedInPortsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected ConnectedInPortsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ConnectedInPortsMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.connectedInPorts";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("sourceInPort","targetInPort");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceInPort", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("targetInPort", "hu.bme.mit.transima.Simulink.InPort"));
  }
  
  public ConnectedInPortsMatch newEmptyMatch() {
    return ConnectedInPortsMatch.newEmptyMatch();
  }
  
  public ConnectedInPortsMatch newMatch(final Object... parameters) {
    return ConnectedInPortsMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) parameters[0], (hu.bme.mit.transima.Simulink.InPort) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort")
      ));
      
      
      new BinaryTransitiveClosure(body, new FlatTuple(var_sourceInPort, var_targetInPort), InPortToInPortConnectionQuerySpecification.instance().instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ConnectedInPortsQuerySpecification INSTANCE = make();
    
    public static ConnectedInPortsQuerySpecification make() {
      return new ConnectedInPortsQuerySpecification();					
      
    }
  }
}
