package hu.bme.mit.massif.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.derived.TriggerMatch;
import hu.bme.mit.massif.models.simulink.derived.TriggerMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate TriggerMatcher in a type-safe way.
 * 
 * @see TriggerMatcher
 * @see TriggerMatch
 * 
 */
@SuppressWarnings("all")
public final class TriggerQuerySpecification extends BaseGeneratedQuerySpecification<TriggerMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TriggerQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected TriggerMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TriggerMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.derived.trigger";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("Block","Trigger");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("Block", "hu.bme.mit.massif.simulink.Block"),new PParameter("Trigger", "hu.bme.mit.massif.simulink.Trigger"));
  }
  
  @Override
  public TriggerMatch newEmptyMatch() {
    return TriggerMatch.newEmptyMatch();
  }
  
  @Override
  public TriggerMatch newMatch(final Object... parameters) {
    return TriggerMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.Trigger) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_Block = body.getOrCreateVariableByName("Block");
      PVariable var_Trigger = body.getOrCreateVariableByName("Trigger");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_Block, "Block"), 
        new ExportedParameter(body, var_Trigger, "Trigger")
      ));
      
      
      new TypeUnary(body, var_Trigger, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "Trigger"), "http://hu.bme.mit.massif/simulink/1.0/Trigger");
      new TypeBinary(body, CONTEXT, var_Block, var_Trigger, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      addAnnotation(annotation);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static TriggerQuerySpecification INSTANCE = make();
    
    public static TriggerQuerySpecification make() {
      return new TriggerQuerySpecification();					
      
    }
  }
}
