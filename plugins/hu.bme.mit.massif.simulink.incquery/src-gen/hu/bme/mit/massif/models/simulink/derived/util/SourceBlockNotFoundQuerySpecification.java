package hu.bme.mit.massif.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.derived.SourceBlockNotFoundMatch;
import hu.bme.mit.massif.models.simulink.derived.SourceBlockNotFoundMatcher;
import hu.bme.mit.massif.models.simulink.derived.util.HasSourceBlockQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SourceBlockNotFoundMatcher in a type-safe way.
 * 
 * @see SourceBlockNotFoundMatcher
 * @see SourceBlockNotFoundMatch
 * 
 */
@SuppressWarnings("all")
public final class SourceBlockNotFoundQuerySpecification extends BaseGeneratedEMFQuerySpecification<SourceBlockNotFoundMatcher> {
  private SourceBlockNotFoundQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SourceBlockNotFoundQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SourceBlockNotFoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SourceBlockNotFoundMatcher.on(engine);
  }
  
  @Override
  public SourceBlockNotFoundMatch newEmptyMatch() {
    return SourceBlockNotFoundMatch.newEmptyMatch();
  }
  
  @Override
  public SourceBlockNotFoundMatch newMatch(final Object... parameters) {
    return SourceBlockNotFoundMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.LibraryLinkReference) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static SourceBlockNotFoundQuerySpecification INSTANCE = make();
    
    public static SourceBlockNotFoundQuerySpecification make() {
      return new SourceBlockNotFoundQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SourceBlockNotFoundQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.derived.sourceBlockNotFound";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Block","BlRef");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Block", "hu.bme.mit.massif.simulink.Block"),new PParameter("BlRef", "hu.bme.mit.massif.simulink.LibraryLinkReference"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_Block = body.getOrCreateVariableByName("Block");
      	PVariable var_BlRef = body.getOrCreateVariableByName("BlRef");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Block, "Block"),
      				
      		new ExportedParameter(body, var_BlRef, "BlRef")
      	));
      	new TypeBinary(body, CONTEXT, var_Block, var_BlRef, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "sourceBlockRef"), "http://hu.bme.mit.massif/simulink/1.0/Block.sourceBlockRef");
      	new NegativePatternCall(body, new FlatTuple(var_Block), HasSourceBlockQuerySpecification.instance().getInternalQueryRepresentation());
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
