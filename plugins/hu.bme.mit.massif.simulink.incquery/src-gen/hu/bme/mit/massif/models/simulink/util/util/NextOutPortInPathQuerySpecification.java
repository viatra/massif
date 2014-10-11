package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.NextOutPortInPathMatch;
import hu.bme.mit.massif.models.simulink.util.NextOutPortInPathMatcher;
import hu.bme.mit.massif.models.simulink.util.util.ConnectedOutPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.OutPortToOutPortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate NextOutPortInPathMatcher in a type-safe way.
 * 
 * @see NextOutPortInPathMatcher
 * @see NextOutPortInPathMatch
 * 
 */
@SuppressWarnings("all")
public final class NextOutPortInPathQuerySpecification extends BaseGeneratedQuerySpecification<NextOutPortInPathMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NextOutPortInPathQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected NextOutPortInPathMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NextOutPortInPathMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.nextOutPortInPath";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("sourceOutPort","nextOutPort","targetOutPort");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceOutPort", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("nextOutPort", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("targetOutPort", "hu.bme.mit.massif.simulink.OutPort"));
  }
  
  @Override
  public NextOutPortInPathMatch newEmptyMatch() {
    return NextOutPortInPathMatch.newEmptyMatch();
  }
  
  @Override
  public NextOutPortInPathMatch newMatch(final Object... parameters) {
    return NextOutPortInPathMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1], (hu.bme.mit.massif.simulink.OutPort) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_nextOutPort = body.getOrCreateVariableByName("nextOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_nextOutPort, "nextOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_nextOutPort), OutPortToOutPortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_nextOutPort, var_targetOutPort), ConnectedOutPortsQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "nextOutPort"), 
        new ExportedParameter(body, var_targetOutPort, "targetOutPort")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_targetOutPort), OutPortToOutPortConnectionQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static NextOutPortInPathQuerySpecification INSTANCE = make();
    
    public static NextOutPortInPathQuerySpecification make() {
      return new NextOutPortInPathQuerySpecification();					
      
    }
  }
}
