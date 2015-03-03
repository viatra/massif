package hu.bme.mit.massif.models.simulink.derived;

import hu.bme.mit.massif.models.simulink.derived.EnablerMatcher;
import hu.bme.mit.massif.models.simulink.derived.HasSourceBlockMatcher;
import hu.bme.mit.massif.models.simulink.derived.InportsMatcher;
import hu.bme.mit.massif.models.simulink.derived.NameMatcher;
import hu.bme.mit.massif.models.simulink.derived.OutportsMatcher;
import hu.bme.mit.massif.models.simulink.derived.ReferencedModelMatcher;
import hu.bme.mit.massif.models.simulink.derived.SourceBlockMatcher;
import hu.bme.mit.massif.models.simulink.derived.SourceBlockNotFoundMatcher;
import hu.bme.mit.massif.models.simulink.derived.TriggerMatcher;
import hu.bme.mit.massif.models.simulink.derived.util.EnablerQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.HasSourceBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.InportsQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.NameQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.OutportsQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.ReferencedModelQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.SourceBlockNotFoundQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.SourceBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.derived.util.TriggerQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in derivedFeatures.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file derivedFeatures.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.massif.models.simulink.derived, the group contains the definition of the following patterns: <ul>
 * <li>inports</li>
 * <li>outports</li>
 * <li>trigger</li>
 * <li>enabler</li>
 * <li>name</li>
 * <li>sourceBlock</li>
 * <li>hasSourceBlock</li>
 * <li>sourceBlockNotFound</li>
 * <li>referencedModel</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class DerivedFeatures extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static DerivedFeatures instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new DerivedFeatures();
    }
    return INSTANCE;
  }
  
  private static DerivedFeatures INSTANCE;
  
  private DerivedFeatures() throws IncQueryException {
    querySpecifications.add(InportsQuerySpecification.instance());
    querySpecifications.add(OutportsQuerySpecification.instance());
    querySpecifications.add(TriggerQuerySpecification.instance());
    querySpecifications.add(EnablerQuerySpecification.instance());
    querySpecifications.add(NameQuerySpecification.instance());
    querySpecifications.add(SourceBlockQuerySpecification.instance());
    querySpecifications.add(HasSourceBlockQuerySpecification.instance());
    querySpecifications.add(SourceBlockNotFoundQuerySpecification.instance());
    querySpecifications.add(ReferencedModelQuerySpecification.instance());
  }
  
  public InportsQuerySpecification getInports() throws IncQueryException {
    return InportsQuerySpecification.instance();
  }
  
  public InportsMatcher getInports(final IncQueryEngine engine) throws IncQueryException {
    return InportsMatcher.on(engine);
  }
  
  public OutportsQuerySpecification getOutports() throws IncQueryException {
    return OutportsQuerySpecification.instance();
  }
  
  public OutportsMatcher getOutports(final IncQueryEngine engine) throws IncQueryException {
    return OutportsMatcher.on(engine);
  }
  
  public TriggerQuerySpecification getTrigger() throws IncQueryException {
    return TriggerQuerySpecification.instance();
  }
  
  public TriggerMatcher getTrigger(final IncQueryEngine engine) throws IncQueryException {
    return TriggerMatcher.on(engine);
  }
  
  public EnablerQuerySpecification getEnabler() throws IncQueryException {
    return EnablerQuerySpecification.instance();
  }
  
  public EnablerMatcher getEnabler(final IncQueryEngine engine) throws IncQueryException {
    return EnablerMatcher.on(engine);
  }
  
  public NameQuerySpecification getName() throws IncQueryException {
    return NameQuerySpecification.instance();
  }
  
  public NameMatcher getName(final IncQueryEngine engine) throws IncQueryException {
    return NameMatcher.on(engine);
  }
  
  public SourceBlockQuerySpecification getSourceBlock() throws IncQueryException {
    return SourceBlockQuerySpecification.instance();
  }
  
  public SourceBlockMatcher getSourceBlock(final IncQueryEngine engine) throws IncQueryException {
    return SourceBlockMatcher.on(engine);
  }
  
  public HasSourceBlockQuerySpecification getHasSourceBlock() throws IncQueryException {
    return HasSourceBlockQuerySpecification.instance();
  }
  
  public HasSourceBlockMatcher getHasSourceBlock(final IncQueryEngine engine) throws IncQueryException {
    return HasSourceBlockMatcher.on(engine);
  }
  
  public SourceBlockNotFoundQuerySpecification getSourceBlockNotFound() throws IncQueryException {
    return SourceBlockNotFoundQuerySpecification.instance();
  }
  
  public SourceBlockNotFoundMatcher getSourceBlockNotFound(final IncQueryEngine engine) throws IncQueryException {
    return SourceBlockNotFoundMatcher.on(engine);
  }
  
  public ReferencedModelQuerySpecification getReferencedModel() throws IncQueryException {
    return ReferencedModelQuerySpecification.instance();
  }
  
  public ReferencedModelMatcher getReferencedModel(final IncQueryEngine engine) throws IncQueryException {
    return ReferencedModelMatcher.on(engine);
  }
}
