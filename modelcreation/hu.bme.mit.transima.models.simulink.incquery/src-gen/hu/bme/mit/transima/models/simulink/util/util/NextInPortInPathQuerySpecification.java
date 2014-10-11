package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.NextInPortInPathMatch;
import hu.bme.mit.transima.models.simulink.util.NextInPortInPathMatcher;
import hu.bme.mit.transima.models.simulink.util.util.ConnectedInPortsQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NextInPortInPathMatcher in a type-safe way.
 * 
 * @see NextInPortInPathMatcher
 * @see NextInPortInPathMatch
 * 
 */
@SuppressWarnings("all")
public final class NextInPortInPathQuerySpecification extends BaseGeneratedQuerySpecification<NextInPortInPathMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NextInPortInPathQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected NextInPortInPathMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NextInPortInPathMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.nextInPortInPath";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("sourceInPort","nextInPort","targetInPort");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceInPort", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("nextInPort", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("targetInPort", "hu.bme.mit.transima.Simulink.InPort"));
  }
  
  @Override
  public NextInPortInPathMatch newEmptyMatch() {
    return NextInPortInPathMatch.newEmptyMatch();
  }
  
  @Override
  public NextInPortInPathMatch newMatch(final Object... parameters) {
    return NextInPortInPathMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) parameters[0], (hu.bme.mit.transima.Simulink.InPort) parameters[1], (hu.bme.mit.transima.Simulink.InPort) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_nextInPort = body.getOrCreateVariableByName("nextInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_nextInPort, "nextInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_nextInPort), InPortToInPortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_nextInPort, var_targetInPort), ConnectedInPortsQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceInPort, "sourceInPort"), 
        new ExportedParameter(body, var_targetInPort, "nextInPort"), 
        new ExportedParameter(body, var_targetInPort, "targetInPort")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_targetInPort), InPortToInPortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static NextInPortInPathQuerySpecification INSTANCE = make();
    
    public static NextInPortInPathQuerySpecification make() {
      return new NextInPortInPathQuerySpecification();					
      
    }
  }
}
