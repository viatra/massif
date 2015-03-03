package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.InPortToInPortConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.InPortToInPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.util.BusSpecificationInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleInPortToInPortConnectionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate InPortToInPortConnectionMatcher in a type-safe way.
 * 
 * @see InPortToInPortConnectionMatcher
 * @see InPortToInPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class InPortToInPortConnectionQuerySpecification extends BaseGeneratedEMFQuerySpecification<InPortToInPortConnectionMatcher> {
  private InPortToInPortConnectionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InPortToInPortConnectionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InPortToInPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InPortToInPortConnectionMatcher.on(engine);
  }
  
  @Override
  public InPortToInPortConnectionMatch newEmptyMatch() {
    return InPortToInPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public InPortToInPortConnectionMatch newMatch(final Object... parameters) {
    return InPortToInPortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.InPort) parameters[0], (hu.bme.mit.massif.simulink.InPort) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static InPortToInPortConnectionQuerySpecification INSTANCE = make();
    
    public static InPortToInPortConnectionQuerySpecification make() {
      return new InPortToInPortConnectionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InPortToInPortConnectionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.inPortToInPortConnection";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sourceInPort","targetInPort");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sourceInPort", "hu.bme.mit.massif.simulink.InPort"),new PParameter("targetInPort", "hu.bme.mit.massif.simulink.InPort"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      	PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      	PVariable var__pc = body.getOrCreateVariableByName("_pc");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sourceInPort, "sourceInPort"),
      				
      		new ExportedParameter(body, var_targetInPort, "targetInPort")
      	));
      	new TypeUnary(body, var_sourceInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_targetInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_targetInPort, var__pc), SimpleInPortToInPortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_sourceInPort = body.getOrCreateVariableByName("sourceInPort");
      	PVariable var_targetInPort = body.getOrCreateVariableByName("targetInPort");
      	PVariable var_outPortOfBS = body.getOrCreateVariableByName("outPortOfBS");
      	PVariable var__pc = body.getOrCreateVariableByName("_pc");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sourceInPort, "sourceInPort"),
      				
      		new ExportedParameter(body, var_targetInPort, "targetInPort")
      	));
      	new TypeUnary(body, var_sourceInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_targetInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new PositivePatternCall(body, new FlatTuple(var_sourceInPort, var_outPortOfBS), BusSpecificationInPortToOutPortQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_outPortOfBS, var_targetInPort, var__pc), PortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
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
