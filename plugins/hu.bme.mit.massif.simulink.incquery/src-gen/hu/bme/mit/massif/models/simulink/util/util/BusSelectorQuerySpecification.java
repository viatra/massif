package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.BusSelectorMatch;
import hu.bme.mit.massif.models.simulink.util.BusSelectorMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate BusSelectorMatcher in a type-safe way.
 * 
 * @see BusSelectorMatcher
 * @see BusSelectorMatch
 * 
 */
@SuppressWarnings("all")
public final class BusSelectorQuerySpecification extends BaseGeneratedEMFQuerySpecification<BusSelectorMatcher> {
  private BusSelectorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BusSelectorQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected BusSelectorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BusSelectorMatcher.on(engine);
  }
  
  @Override
  public BusSelectorMatch newEmptyMatch() {
    return BusSelectorMatch.newEmptyMatch();
  }
  
  @Override
  public BusSelectorMatch newMatch(final Object... parameters) {
    return BusSelectorMatch.newMatch((hu.bme.mit.massif.simulink.BusSelector) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static BusSelectorQuerySpecification INSTANCE = make();
    
    public static BusSelectorQuerySpecification make() {
      return new BusSelectorQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static BusSelectorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.busSelector";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("selector");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("selector", "hu.bme.mit.massif.simulink.BusSelector"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_selector = body.getOrCreateVariableByName("selector");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_selector, "selector")
      	));
      	new TypeUnary(body, var_selector, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "BusSelector"), "http://hu.bme.mit.massif/simulink/1.0/BusSelector");
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
