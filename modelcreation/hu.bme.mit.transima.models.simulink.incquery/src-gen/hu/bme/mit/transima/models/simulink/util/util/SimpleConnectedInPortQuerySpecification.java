package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.SimpleConnectedInPortMatch;
import hu.bme.mit.transima.models.simulink.util.SimpleConnectedInPortMatcher;
import hu.bme.mit.transima.models.simulink.util.util.SimpleInPortToInPortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SimpleConnectedInPortMatcher in a type-safe way.
 * 
 * @see SimpleConnectedInPortMatcher
 * @see SimpleConnectedInPortMatch
 * 
 */
@SuppressWarnings("all")
public final class SimpleConnectedInPortQuerySpecification extends BaseGeneratedQuerySpecification<SimpleConnectedInPortMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SimpleConnectedInPortQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected SimpleConnectedInPortMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SimpleConnectedInPortMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.simpleConnectedInPort";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("sourceInPort","targetInPort");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceInPort", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("targetInPort", "hu.bme.mit.transima.Simulink.InPort"));
  }
  
  public SimpleConnectedInPortMatch newEmptyMatch() {
    return SimpleConnectedInPortMatch.newEmptyMatch();
  }
  
  public SimpleConnectedInPortMatch newMatch(final Object... parameters) {
    return SimpleConnectedInPortMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) parameters[0], (hu.bme.mit.transima.Simulink.InPort) parameters[1]);
  }
  
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
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SimpleConnectedInPortQuerySpecification INSTANCE = make();
    
    public static SimpleConnectedInPortQuerySpecification make() {
      return new SimpleConnectedInPortQuerySpecification();					
      
    }
  }
}
