package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.GotoConnectedPortsMatch;
import hu.bme.mit.massif.models.simulink.util.GotoConnectedPortsMatcher;
import hu.bme.mit.massif.models.simulink.util.util.BlockToPortQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate GotoConnectedPortsMatcher in a type-safe way.
 * 
 * @see GotoConnectedPortsMatcher
 * @see GotoConnectedPortsMatch
 * 
 */
@SuppressWarnings("all")
public final class GotoConnectedPortsQuerySpecification extends BaseGeneratedEMFQuerySpecification<GotoConnectedPortsMatcher> {
  private GotoConnectedPortsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static GotoConnectedPortsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected GotoConnectedPortsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return GotoConnectedPortsMatcher.on(engine);
  }
  
  @Override
  public GotoConnectedPortsMatch newEmptyMatch() {
    return GotoConnectedPortsMatch.newEmptyMatch();
  }
  
  @Override
  public GotoConnectedPortsMatch newMatch(final Object... parameters) {
    return GotoConnectedPortsMatch.newMatch((hu.bme.mit.massif.simulink.InPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static GotoConnectedPortsQuerySpecification INSTANCE = make();
    
    public static GotoConnectedPortsQuerySpecification make() {
      return new GotoConnectedPortsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static GotoConnectedPortsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.gotoConnectedPorts";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("gotoInPort","fromOutPort");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("gotoInPort", "hu.bme.mit.massif.simulink.InPort"),new PParameter("fromOutPort", "hu.bme.mit.massif.simulink.OutPort"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_gotoInPort = body.getOrCreateVariableByName("gotoInPort");
      	PVariable var_fromOutPort = body.getOrCreateVariableByName("fromOutPort");
      	PVariable var_GT = body.getOrCreateVariableByName("GT");
      	PVariable var_From = body.getOrCreateVariableByName("From");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_gotoInPort, "gotoInPort"),
      				
      		new ExportedParameter(body, var_fromOutPort, "fromOutPort")
      	));
      	new TypeUnary(body, var_gotoInPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_fromOutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new PositivePatternCall(body, new FlatTuple(var_GT, var_gotoInPort), BlockToPortQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeBinary(body, CONTEXT, var_GT, var_From, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Goto", "fromBlocks"), "http://hu.bme.mit.massif/simulink/1.0/Goto.fromBlocks");
      	new PositivePatternCall(body, new FlatTuple(var_From, var_fromOutPort), BlockToPortQuerySpecification.instance().getInternalQueryRepresentation());
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
