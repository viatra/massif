package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.ConnectedOutPortsMatch;
import hu.bme.mit.transima.models.simulink.util.ConnectedOutPortsMatcher;
import hu.bme.mit.transima.models.simulink.util.util.OutPortToOutPortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ConnectedOutPortsMatcher in a type-safe way.
 * 
 * @see ConnectedOutPortsMatcher
 * @see ConnectedOutPortsMatch
 * 
 */
@SuppressWarnings("all")
public final class ConnectedOutPortsQuerySpecification extends BaseGeneratedQuerySpecification<ConnectedOutPortsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ConnectedOutPortsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected ConnectedOutPortsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ConnectedOutPortsMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.connectedOutPorts";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("sourceOutPort","targetOutPort");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceOutPort", "hu.bme.mit.transima.Simulink.OutPort"),new PParameter("targetOutPort", "hu.bme.mit.transima.Simulink.OutPort"));
  }
  
  public ConnectedOutPortsMatch newEmptyMatch() {
    return ConnectedOutPortsMatch.newEmptyMatch();
  }
  
  public ConnectedOutPortsMatch newMatch(final Object... parameters) {
    return ConnectedOutPortsMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) parameters[0], (hu.bme.mit.transima.Simulink.OutPort) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort")
      ));
      
      
      new BinaryTransitiveClosure(body, new FlatTuple(var_sourceOutPort, var_targetOutPort), OutPortToOutPortConnectionQuerySpecification.instance().instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ConnectedOutPortsQuerySpecification INSTANCE = make();
    
    public static ConnectedOutPortsQuerySpecification make() {
      return new ConnectedOutPortsQuerySpecification();					
      
    }
  }
}
