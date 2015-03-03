package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.OutPortToOutPortConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.OutPortToOutPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.util.BusSpecificationInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleOutPortToOutPortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate OutPortToOutPortConnectionMatcher in a type-safe way.
 * 
 * @see OutPortToOutPortConnectionMatcher
 * @see OutPortToOutPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class OutPortToOutPortConnectionQuerySpecification extends BaseGeneratedEMFQuerySpecification<OutPortToOutPortConnectionMatcher> {
  private OutPortToOutPortConnectionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OutPortToOutPortConnectionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected OutPortToOutPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OutPortToOutPortConnectionMatcher.on(engine);
  }
  
  @Override
  public OutPortToOutPortConnectionMatch newEmptyMatch() {
    return OutPortToOutPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public OutPortToOutPortConnectionMatch newMatch(final Object... parameters) {
    return OutPortToOutPortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static OutPortToOutPortConnectionQuerySpecification INSTANCE = make();
    
    public static OutPortToOutPortConnectionQuerySpecification make() {
      return new OutPortToOutPortConnectionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static OutPortToOutPortConnectionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.outPortToOutPortConnection";
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
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      	PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      	PVariable var__pc = body.getOrCreateVariableByName("_pc");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"),
      				
      		new ExportedParameter(body, var_targetOutPort, "targetOutPort")
      	));
      	new TypeUnary(body, var_sourceOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new TypeUnary(body, var_targetOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_targetOutPort, var__pc), SimpleOutPortToOutPortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_sourceOutPort = body.getOrCreateVariableByName("sourceOutPort");
      	PVariable var_targetOutPort = body.getOrCreateVariableByName("targetOutPort");
      	PVariable var_busInPort = body.getOrCreateVariableByName("busInPort");
      	PVariable var__pc = body.getOrCreateVariableByName("_pc");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sourceOutPort, "sourceOutPort"),
      				
      		new ExportedParameter(body, var_targetOutPort, "targetOutPort")
      	));
      	new TypeUnary(body, var_sourceOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new TypeUnary(body, var_targetOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new PositivePatternCall(body, new FlatTuple(var_sourceOutPort, var_busInPort, var__pc), PortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_busInPort, var_targetOutPort), BusSpecificationInPortToOutPortQuerySpecification.instance().getInternalQueryRepresentation());
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
