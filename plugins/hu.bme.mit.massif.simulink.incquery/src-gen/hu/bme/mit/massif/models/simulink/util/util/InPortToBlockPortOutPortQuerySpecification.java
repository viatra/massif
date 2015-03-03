package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.InPortToBlockPortOutPortMatch;
import hu.bme.mit.massif.models.simulink.util.InPortToBlockPortOutPortMatcher;
import hu.bme.mit.massif.models.simulink.util.util.PortToPortBlockQuerySpecification;
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
 * A pattern-specific query specification that can instantiate InPortToBlockPortOutPortMatcher in a type-safe way.
 * 
 * @see InPortToBlockPortOutPortMatcher
 * @see InPortToBlockPortOutPortMatch
 * 
 */
@SuppressWarnings("all")
public final class InPortToBlockPortOutPortQuerySpecification extends BaseGeneratedEMFQuerySpecification<InPortToBlockPortOutPortMatcher> {
  private InPortToBlockPortOutPortQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InPortToBlockPortOutPortQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InPortToBlockPortOutPortMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InPortToBlockPortOutPortMatcher.on(engine);
  }
  
  @Override
  public InPortToBlockPortOutPortMatch newEmptyMatch() {
    return InPortToBlockPortOutPortMatch.newEmptyMatch();
  }
  
  @Override
  public InPortToBlockPortOutPortMatch newMatch(final Object... parameters) {
    return InPortToBlockPortOutPortMatch.newMatch((hu.bme.mit.massif.simulink.InPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static InPortToBlockPortOutPortQuerySpecification INSTANCE = make();
    
    public static InPortToBlockPortOutPortQuerySpecification make() {
      return new InPortToBlockPortOutPortQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InPortToBlockPortOutPortQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.inPortToBlockPortOutPort";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("inPort","outPortOfPBl");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("inPort", "hu.bme.mit.massif.simulink.InPort"),new PParameter("outPortOfPBl", "hu.bme.mit.massif.simulink.OutPort"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_inPort = body.getOrCreateVariableByName("inPort");
      	PVariable var_outPortOfPBl = body.getOrCreateVariableByName("outPortOfPBl");
      	PVariable var_pBl = body.getOrCreateVariableByName("pBl");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_inPort, "inPort"),
      				
      		new ExportedParameter(body, var_outPortOfPBl, "outPortOfPBl")
      	));
      	new TypeUnary(body, var_inPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeUnary(body, var_outPortOfPBl, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      	new PositivePatternCall(body, new FlatTuple(var_inPort, var_pBl), PortToPortBlockQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeUnary(body, var_pBl, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "PortBlock"), "http://hu.bme.mit.massif/simulink/1.0/PortBlock");
      	new TypeBinary(body, CONTEXT, var_pBl, var_outPortOfPBl, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
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
