package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.PortToPortBlockMatch;
import hu.bme.mit.massif.models.simulink.util.PortToPortBlockMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate PortToPortBlockMatcher in a type-safe way.
 * 
 * @see PortToPortBlockMatcher
 * @see PortToPortBlockMatch
 * 
 */
@SuppressWarnings("all")
public final class PortToPortBlockQuerySpecification extends BaseGeneratedEMFQuerySpecification<PortToPortBlockMatcher> {
  private PortToPortBlockQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortToPortBlockQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PortToPortBlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortToPortBlockMatcher.on(engine);
  }
  
  @Override
  public PortToPortBlockMatch newEmptyMatch() {
    return PortToPortBlockMatch.newEmptyMatch();
  }
  
  @Override
  public PortToPortBlockMatch newMatch(final Object... parameters) {
    return PortToPortBlockMatch.newMatch((hu.bme.mit.massif.simulink.Port) parameters[0], (hu.bme.mit.massif.simulink.PortBlock) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static PortToPortBlockQuerySpecification INSTANCE = make();
    
    public static PortToPortBlockQuerySpecification make() {
      return new PortToPortBlockQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PortToPortBlockQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.portToPortBlock";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("port","portBlock");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("port", "hu.bme.mit.massif.simulink.Port"),new PParameter("portBlock", "hu.bme.mit.massif.simulink.PortBlock"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_port = body.getOrCreateVariableByName("port");
      	PVariable var_portBlock = body.getOrCreateVariableByName("portBlock");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_port, "port"),
      				
      		new ExportedParameter(body, var_portBlock, "portBlock")
      	));
      	new TypeBinary(body, CONTEXT, var_port, var_portBlock, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Port", "portBlock"), "http://hu.bme.mit.massif/simulink/1.0/Port.portBlock");
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
