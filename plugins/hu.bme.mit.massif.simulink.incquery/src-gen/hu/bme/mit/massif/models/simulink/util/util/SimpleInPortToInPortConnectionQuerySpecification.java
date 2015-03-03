package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.SimpleInPortToInPortConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.SimpleInPortToInPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.util.GotoConnectedPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.InPortToBlockPortOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortBlockInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SimpleInPortToInPortConnectionMatcher in a type-safe way.
 * 
 * @see SimpleInPortToInPortConnectionMatcher
 * @see SimpleInPortToInPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class SimpleInPortToInPortConnectionQuerySpecification extends BaseGeneratedEMFQuerySpecification<SimpleInPortToInPortConnectionMatcher> {
  private SimpleInPortToInPortConnectionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SimpleInPortToInPortConnectionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SimpleInPortToInPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SimpleInPortToInPortConnectionMatcher.on(engine);
  }
  
  @Override
  public SimpleInPortToInPortConnectionMatch newEmptyMatch() {
    return SimpleInPortToInPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public SimpleInPortToInPortConnectionMatch newMatch(final Object... parameters) {
    return SimpleInPortToInPortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.InPort) parameters[0], (hu.bme.mit.massif.simulink.InPort) parameters[1], (hu.bme.mit.massif.simulink.SingleConnection) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static SimpleInPortToInPortConnectionQuerySpecification INSTANCE = make();
    
    public static SimpleInPortToInPortConnectionQuerySpecification make() {
      return new SimpleInPortToInPortConnectionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SimpleInPortToInPortConnectionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.simpleInPortToInPortConnection";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sourceInPort","targetInPort","connection");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sourceInPort", "hu.bme.mit.massif.simulink.InPort"),new PParameter("targetInPort", "hu.bme.mit.massif.simulink.InPort"),new PParameter("connection", "hu.bme.mit.massif.simulink.SingleConnection"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
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
      	new TypeUnary(body, var_sourceInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_targetInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_connection, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "SingleConnection"), "http://hu.bme.mit.massif/simulink/1.0/SingleConnection");
      	new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_fromOutPort), GotoConnectedPortsQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_fromOutPort, var_targetInPort, var_connection), PortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
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
      	new TypeUnary(body, var_sourceInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_targetInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_connection, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "SingleConnection"), "http://hu.bme.mit.massif/simulink/1.0/SingleConnection");
      	new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_plOut), InPortToBlockPortOutPortQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_plOut, var_targetInPort, var_connection), PortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
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
      	new TypeUnary(body, var_sourceInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_targetInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_connection, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "SingleConnection"), "http://hu.bme.mit.massif/simulink/1.0/SingleConnection");
      	new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_outerOutPort), PortBlockInPortToOutPortQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_outerOutPort, var_targetInPort, var_connection), PortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
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
