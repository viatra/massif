package hu.bme.mit.massif.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.derived.NameMatch;
import hu.bme.mit.massif.models.simulink.derived.NameMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate NameMatcher in a type-safe way.
 * 
 * @see NameMatcher
 * @see NameMatch
 * 
 */
@SuppressWarnings("all")
public final class NameQuerySpecification extends BaseGeneratedEMFQuerySpecification<NameMatcher> {
  private NameQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NameQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NameMatcher.on(engine);
  }
  
  @Override
  public NameMatch newEmptyMatch() {
    return NameMatch.newEmptyMatch();
  }
  
  @Override
  public NameMatch newMatch(final Object... parameters) {
    return NameMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkElement) parameters[0], (java.lang.String) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static NameQuerySpecification INSTANCE = make();
    
    public static NameQuerySpecification make() {
      return new NameQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static NameQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.derived.name";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("SE","Name");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("SE", "hu.bme.mit.massif.simulink.SimulinkElement"),new PParameter("Name", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_SE = body.getOrCreateVariableByName("SE");
      	PVariable var_Name = body.getOrCreateVariableByName("Name");
      	PVariable var_SR = body.getOrCreateVariableByName("SR");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_SE, "SE"),
      				
      		new ExportedParameter(body, var_Name, "Name")
      	));
      	new TypeBinary(body, CONTEXT, var_SE, var_SR, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "SimulinkElement", "simulinkRef"), "http://hu.bme.mit.massif/simulink/1.0/SimulinkElement.simulinkRef");
      	new TypeBinary(body, CONTEXT, var_SR, var_Name, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "SimulinkReference", "name"), "http://hu.bme.mit.massif/simulink/1.0/SimulinkReference.name");
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      	addAnnotation(annotation);
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
