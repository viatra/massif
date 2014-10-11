package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.SimpleConnectedOutPortMatch;
import hu.bme.mit.massif.models.simulink.util.SimpleConnectedOutPortMatcher;
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
 * A pattern-specific query specification that can instantiate SimpleConnectedOutPortMatcher in a type-safe way.
 * 
 * @see SimpleConnectedOutPortMatcher
 * @see SimpleConnectedOutPortMatch
 * 
 */
@SuppressWarnings("all")
public final class SimpleConnectedOutPortQuerySpecification extends BaseGeneratedQuerySpecification<SimpleConnectedOutPortMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SimpleConnectedOutPortQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SimpleConnectedOutPortMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SimpleConnectedOutPortMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.simpleConnectedOutPort";
    
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
  public SimpleConnectedOutPortMatch newEmptyMatch() {
    return SimpleConnectedOutPortMatch.newEmptyMatch();
  }
  
  @Override
  public SimpleConnectedOutPortMatch newMatch(final Object... parameters) {
    return SimpleConnectedOutPortMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1]);
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
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SimpleConnectedOutPortQuerySpecification INSTANCE = make();
    
    public static SimpleConnectedOutPortQuerySpecification make() {
      return new SimpleConnectedOutPortQuerySpecification();					
      
    }
  }
}
