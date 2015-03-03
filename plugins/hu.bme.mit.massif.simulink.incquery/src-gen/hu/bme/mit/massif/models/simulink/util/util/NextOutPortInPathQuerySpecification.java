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
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NextOutPortInPathMatcher in a type-safe way.
 * 
 * @see NextOutPortInPathMatcher
 * @see NextOutPortInPathMatch
 * 
 */
@SuppressWarnings("all")
public final class NextOutPortInPathQuerySpecification extends BaseGeneratedEMFQuerySpecification<NextOutPortInPathMatcher> {
  private NextOutPortInPathQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NextOutPortInPathQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NextOutPortInPathMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NextOutPortInPathMatcher.on(engine);
  }
  
  @Override
  public NextOutPortInPathMatch newEmptyMatch() {
    return NextOutPortInPathMatch.newEmptyMatch();
  }
  
  @Override
  public NextOutPortInPathMatch newMatch(final Object... parameters) {
    return NextOutPortInPathMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1], (hu.bme.mit.massif.simulink.OutPort) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static NextOutPortInPathQuerySpecification INSTANCE = make();
    
    public static NextOutPortInPathQuerySpecification make() {
      return new NextOutPortInPathQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static NextOutPortInPathQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
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
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
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
      	new TypeUnary(body, var_sourceOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new TypeUnary(body, var_nextOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new TypeUnary(body, var_targetOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_nextOutPort), OutPortToOutPortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_nextOutPort, var_targetOutPort), ConnectedOutPortsQuerySpecification.instance().getInternalQueryRepresentation());
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
      	new TypeUnary(body, var_sourceOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new TypeUnary(body, var_targetOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_targetOutPort), OutPortToOutPortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
