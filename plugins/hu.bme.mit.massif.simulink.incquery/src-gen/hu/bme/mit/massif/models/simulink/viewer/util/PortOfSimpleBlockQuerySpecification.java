package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.viewer.PortOfSimpleBlockMatch;
import hu.bme.mit.massif.models.simulink.viewer.PortOfSimpleBlockMatcher;
import hu.bme.mit.massif.models.simulink.viewer.util.BlockPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.PortOfPortBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.SubBlocksQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate PortOfSimpleBlockMatcher in a type-safe way.
 * 
 * @see PortOfSimpleBlockMatcher
 * @see PortOfSimpleBlockMatch
 * 
 */
@SuppressWarnings("all")
public final class PortOfSimpleBlockQuerySpecification extends BaseGeneratedEMFQuerySpecification<PortOfSimpleBlockMatcher> {
  private PortOfSimpleBlockQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortOfSimpleBlockQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PortOfSimpleBlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortOfSimpleBlockMatcher.on(engine);
  }
  
  @Override
  public PortOfSimpleBlockMatch newEmptyMatch() {
    return PortOfSimpleBlockMatch.newEmptyMatch();
  }
  
  @Override
  public PortOfSimpleBlockMatch newMatch(final Object... parameters) {
    return PortOfSimpleBlockMatch.newMatch((hu.bme.mit.massif.simulink.Port) parameters[0], (hu.bme.mit.massif.simulink.Block) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static PortOfSimpleBlockQuerySpecification INSTANCE = make();
    
    public static PortOfSimpleBlockQuerySpecification make() {
      return new PortOfSimpleBlockQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PortOfSimpleBlockQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.viewer.portOfSimpleBlock";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("port","block");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("port", "hu.bme.mit.massif.simulink.Port"),new PParameter("block", "hu.bme.mit.massif.simulink.Block"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_port = body.getOrCreateVariableByName("port");
      	PVariable var_block = body.getOrCreateVariableByName("block");
      	PVariable var__t = body.getOrCreateVariableByName("_t");
      	PVariable var__sub2 = body.getOrCreateVariableByName("_sub2");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_port, "port"),
      				
      		new ExportedParameter(body, var_block, "block")
      	));
      	new PositivePatternCall(body, new FlatTuple(var_block, var_port), BlockPortsQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_port, var__t), PortOfPortBlockQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_block, var__sub2), SubBlocksQuerySpecification.instance().getInternalQueryRepresentation());
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
