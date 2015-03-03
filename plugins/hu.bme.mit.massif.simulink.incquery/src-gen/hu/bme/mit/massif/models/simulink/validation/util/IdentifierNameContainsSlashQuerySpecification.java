package hu.bme.mit.massif.models.simulink.validation.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.validation.IdentifierNameContainsSlashMatch;
import hu.bme.mit.massif.models.simulink.validation.IdentifierNameContainsSlashMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate IdentifierNameContainsSlashMatcher in a type-safe way.
 * 
 * @see IdentifierNameContainsSlashMatcher
 * @see IdentifierNameContainsSlashMatch
 * 
 */
@SuppressWarnings("all")
public final class IdentifierNameContainsSlashQuerySpecification extends BaseGeneratedEMFQuerySpecification<IdentifierNameContainsSlashMatcher> {
  private IdentifierNameContainsSlashQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IdentifierNameContainsSlashQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected IdentifierNameContainsSlashMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return IdentifierNameContainsSlashMatcher.on(engine);
  }
  
  @Override
  public IdentifierNameContainsSlashMatch newEmptyMatch() {
    return IdentifierNameContainsSlashMatch.newEmptyMatch();
  }
  
  @Override
  public IdentifierNameContainsSlashMatch newMatch(final Object... parameters) {
    return IdentifierNameContainsSlashMatch.newMatch((hu.bme.mit.massif.simulink.IdentifierReference) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static IdentifierNameContainsSlashQuerySpecification INSTANCE = make();
    
    public static IdentifierNameContainsSlashQuerySpecification make() {
      return new IdentifierNameContainsSlashQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static IdentifierNameContainsSlashQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.validation.identifierNameContainsSlash";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("id");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("id", "hu.bme.mit.massif.simulink.IdentifierReference"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_id = body.getOrCreateVariableByName("id");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_id, "id")
      	));
      	new TypeUnary(body, var_id, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "IdentifierReference"), "http://hu.bme.mit.massif/simulink/1.0/IdentifierReference");
      	new TypeBinary(body, CONTEXT, var_id, var_name, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "SimulinkReference", "name"), "http://hu.bme.mit.massif/simulink/1.0/SimulinkReference.name");
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern identifierNameContainsSlash";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("name");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.String name = (java.lang.String) provider.getValue("name");
      			return evaluateExpression_1_1(name);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Constraint");
      	annotation.addAttribute("message", "Identifier $id$ must not contain '/'!");
      	annotation.addAttribute("location", new ParameterReference("id"));
      	annotation.addAttribute("severity", "error");
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
  
  private static boolean evaluateExpression_1_1(final String name) {
    boolean _contains = name.contains("/");
    return _contains;
  }
}
