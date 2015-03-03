package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.LineNameMatch;
import hu.bme.mit.massif.models.simulink.util.LineNameMatcher;
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
 * A pattern-specific query specification that can instantiate LineNameMatcher in a type-safe way.
 * 
 * @see LineNameMatcher
 * @see LineNameMatch
 * 
 */
@SuppressWarnings("all")
public final class LineNameQuerySpecification extends BaseGeneratedEMFQuerySpecification<LineNameMatcher> {
  private LineNameQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LineNameQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LineNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LineNameMatcher.on(engine);
  }
  
  @Override
  public LineNameMatch newEmptyMatch() {
    return LineNameMatch.newEmptyMatch();
  }
  
  @Override
  public LineNameMatch newMatch(final Object... parameters) {
    return LineNameMatch.newMatch((hu.bme.mit.massif.simulink.Connection) parameters[0], (java.lang.String) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static LineNameQuerySpecification INSTANCE = make();
    
    public static LineNameQuerySpecification make() {
      return new LineNameQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LineNameQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.lineName";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("conn","name");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("conn", "hu.bme.mit.massif.simulink.Connection"),new PParameter("name", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_conn = body.getOrCreateVariableByName("conn");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_conn, "conn"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new TypeBinary(body, CONTEXT, var_conn, var_name, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Connection", "lineName"), "http://hu.bme.mit.massif/simulink/1.0/Connection.lineName");
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
