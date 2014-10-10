package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.FirstOutPortFromBusSpecificationMatch;
import hu.bme.mit.transima.models.simulink.util.FirstOutPortFromBusSpecificationMatcher;
import hu.bme.mit.transima.models.simulink.util.util.OutportsReachedFromBusSpecificationQuerySpecification;
import hu.bme.mit.transima.models.simulink.util.util.SimpleConnectedOutPortQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate FirstOutPortFromBusSpecificationMatcher in a type-safe way.
 * 
 * @see FirstOutPortFromBusSpecificationMatcher
 * @see FirstOutPortFromBusSpecificationMatch
 * 
 */
@SuppressWarnings("all")
public final class FirstOutPortFromBusSpecificationQuerySpecification extends BaseGeneratedQuerySpecification<FirstOutPortFromBusSpecificationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FirstOutPortFromBusSpecificationQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected FirstOutPortFromBusSpecificationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FirstOutPortFromBusSpecificationMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.firstOutPortFromBusSpecification";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("outPort","nextSpec","endPortBeforeNextSpec");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("outPort", "hu.bme.mit.transima.Simulink.OutPort"),new PParameter("nextSpec", "hu.bme.mit.transima.Simulink.BusSpecification"),new PParameter("endPortBeforeNextSpec", "hu.bme.mit.transima.Simulink.OutPort"));
  }
  
  public FirstOutPortFromBusSpecificationMatch newEmptyMatch() {
    return FirstOutPortFromBusSpecificationMatch.newEmptyMatch();
  }
  
  public FirstOutPortFromBusSpecificationMatch newMatch(final Object... parameters) {
    return FirstOutPortFromBusSpecificationMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) parameters[0], (hu.bme.mit.transima.Simulink.BusSpecification) parameters[1], (hu.bme.mit.transima.Simulink.OutPort) parameters[2]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_outPort = body.getOrCreateVariableByName("outPort");
      PVariable var_nextSpec = body.getOrCreateVariableByName("nextSpec");
      PVariable var_endPortBeforeNextSpec = body.getOrCreateVariableByName("endPortBeforeNextSpec");
      PVariable var__prevOP = body.getOrCreateVariableByName("_prevOP");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outPort, "outPort"), 
        new ExportedParameter(body, var_nextSpec, "nextSpec"), 
        new ExportedParameter(body, var_endPortBeforeNextSpec, "endPortBeforeNextSpec")
      ));
      
      new TypeUnary(body, var_outPort, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "OutPort"), "http://hu.bme.mit.transima/simulink/1.0/OutPort");
      
      new TypeUnary(body, var_nextSpec, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "BusSpecification"), "http://hu.bme.mit.transima/simulink/1.0/BusSpecification");
      
      new TypeUnary(body, var_endPortBeforeNextSpec, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "OutPort"), "http://hu.bme.mit.transima/simulink/1.0/OutPort");
      new PositivePatternCall(body, new FlatTuple(var_outPort, var_nextSpec, var_endPortBeforeNextSpec), OutportsReachedFromBusSpecificationQuerySpecification.instance());
      new NegativePatternCall(body, new FlatTuple(var__prevOP, var_outPort), SimpleConnectedOutPortQuerySpecification.instance().instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static FirstOutPortFromBusSpecificationQuerySpecification INSTANCE = make();
    
    public static FirstOutPortFromBusSpecificationQuerySpecification make() {
      return new FirstOutPortFromBusSpecificationQuerySpecification();					
      
    }
  }
}
