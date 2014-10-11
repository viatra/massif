package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.BlockToPortMatcher;
import hu.bme.mit.massif.models.simulink.util.BusMappingInSelectorMatcher;
import hu.bme.mit.massif.models.simulink.util.BusSelectorMatcher;
import hu.bme.mit.massif.models.simulink.util.BusSpecificationInPortToOutPortMatcher;
import hu.bme.mit.massif.models.simulink.util.ChildBlockNamesMatcher;
import hu.bme.mit.massif.models.simulink.util.ConnectedInPortsMatcher;
import hu.bme.mit.massif.models.simulink.util.ConnectedOutPortsMatcher;
import hu.bme.mit.massif.models.simulink.util.ConnectedPortsMatcher;
import hu.bme.mit.massif.models.simulink.util.FirstOutPortFromBusSpecificationMatcher;
import hu.bme.mit.massif.models.simulink.util.GotoConnectedPortsMatcher;
import hu.bme.mit.massif.models.simulink.util.InPortToBlockPortOutPortMatcher;
import hu.bme.mit.massif.models.simulink.util.InPortToInPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.LineNameMatcher;
import hu.bme.mit.massif.models.simulink.util.MultiConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.NextInPortInPathMatcher;
import hu.bme.mit.massif.models.simulink.util.NextOutPortInPathMatcher;
import hu.bme.mit.massif.models.simulink.util.OutPortToOutPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.OutportsReachedFromBusSpecificationMatcher;
import hu.bme.mit.massif.models.simulink.util.PortBlockInPortToOutPortMatcher;
import hu.bme.mit.massif.models.simulink.util.PortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.PortToPortBlockMatcher;
import hu.bme.mit.massif.models.simulink.util.ReferenceEqualMatcher;
import hu.bme.mit.massif.models.simulink.util.ReferenceQualifierMatcher;
import hu.bme.mit.massif.models.simulink.util.SimpleConnectedInPortMatcher;
import hu.bme.mit.massif.models.simulink.util.SimpleConnectedOutPortMatcher;
import hu.bme.mit.massif.models.simulink.util.SimpleConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.SimpleInPortToInPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.SimpleOutPortToOutPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.util.SimulinkReferenceMatcher;
import hu.bme.mit.massif.models.simulink.util.util.BlockToPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.BusMappingInSelectorQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.BusSelectorQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.BusSpecificationInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.ChildBlockNamesQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.ConnectedInPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.ConnectedOutPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.ConnectedPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.FirstOutPortFromBusSpecificationQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.GotoConnectedPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.InPortToBlockPortOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.InPortToInPortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.LineNameQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.MultiConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.NextInPortInPathQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.NextOutPortInPathQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.OutPortToOutPortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.OutportsReachedFromBusSpecificationQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortBlockInPortToOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.PortToPortBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.ReferenceEqualQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.ReferenceQualifierQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleConnectedInPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleConnectedOutPortQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleInPortToInPortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleOutPortToOutPortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimulinkReferenceQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in simulinkUtilities.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file simulinkUtilities.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.massif.models.simulink.util, the group contains the definition of the following patterns: <ul>
 * <li>blockToPort</li>
 * <li>portToPortBlock</li>
 * <li>portConnection</li>
 * <li>simpleConnection</li>
 * <li>multiConnection</li>
 * <li>lineName</li>
 * <li>gotoConnectedPorts</li>
 * <li>portBlockInPortToOutPort</li>
 * <li>inPortToBlockPortOutPort</li>
 * <li>busSpecificationInPortToOutPort</li>
 * <li>simpleInPortToInPortConnection</li>
 * <li>inPortToInPortConnection</li>
 * <li>simpleOutPortToOutPortConnection</li>
 * <li>outPortToOutPortConnection</li>
 * <li>connectedInPorts</li>
 * <li>simpleConnectedInPort</li>
 * <li>connectedOutPorts</li>
 * <li>simpleConnectedOutPort</li>
 * <li>connectedPorts</li>
 * <li>nextOutPortInPath</li>
 * <li>nextInPortInPath</li>
 * <li>busSelector</li>
 * <li>busMappingInSelector</li>
 * <li>outportsReachedFromBusSpecification</li>
 * <li>firstOutPortFromBusSpecification</li>
 * <li>simulinkReference</li>
 * <li>referenceQualifier</li>
 * <li>referenceEqual</li>
 * <li>childBlockNames</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class SimulinkUtilities extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static SimulinkUtilities instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new SimulinkUtilities();
    }
    return INSTANCE;
    
  }
  
  private static SimulinkUtilities INSTANCE;
  
  private SimulinkUtilities() throws IncQueryException {
    querySpecifications.add(BlockToPortQuerySpecification.instance());
    querySpecifications.add(PortToPortBlockQuerySpecification.instance());
    querySpecifications.add(PortConnectionQuerySpecification.instance());
    querySpecifications.add(SimpleConnectionQuerySpecification.instance());
    querySpecifications.add(MultiConnectionQuerySpecification.instance());
    querySpecifications.add(LineNameQuerySpecification.instance());
    querySpecifications.add(GotoConnectedPortsQuerySpecification.instance());
    querySpecifications.add(PortBlockInPortToOutPortQuerySpecification.instance());
    querySpecifications.add(InPortToBlockPortOutPortQuerySpecification.instance());
    querySpecifications.add(BusSpecificationInPortToOutPortQuerySpecification.instance());
    querySpecifications.add(SimpleInPortToInPortConnectionQuerySpecification.instance());
    querySpecifications.add(InPortToInPortConnectionQuerySpecification.instance());
    querySpecifications.add(SimpleOutPortToOutPortConnectionQuerySpecification.instance());
    querySpecifications.add(OutPortToOutPortConnectionQuerySpecification.instance());
    querySpecifications.add(ConnectedInPortsQuerySpecification.instance());
    querySpecifications.add(SimpleConnectedInPortQuerySpecification.instance());
    querySpecifications.add(ConnectedOutPortsQuerySpecification.instance());
    querySpecifications.add(SimpleConnectedOutPortQuerySpecification.instance());
    querySpecifications.add(ConnectedPortsQuerySpecification.instance());
    querySpecifications.add(NextOutPortInPathQuerySpecification.instance());
    querySpecifications.add(NextInPortInPathQuerySpecification.instance());
    querySpecifications.add(BusSelectorQuerySpecification.instance());
    querySpecifications.add(BusMappingInSelectorQuerySpecification.instance());
    querySpecifications.add(OutportsReachedFromBusSpecificationQuerySpecification.instance());
    querySpecifications.add(FirstOutPortFromBusSpecificationQuerySpecification.instance());
    querySpecifications.add(SimulinkReferenceQuerySpecification.instance());
    querySpecifications.add(ReferenceQualifierQuerySpecification.instance());
    querySpecifications.add(ReferenceEqualQuerySpecification.instance());
    querySpecifications.add(ChildBlockNamesQuerySpecification.instance());
    
  }
  
  public BlockToPortQuerySpecification getBlockToPort() throws IncQueryException {
    return BlockToPortQuerySpecification.instance();
  }
  
  public BlockToPortMatcher getBlockToPort(final IncQueryEngine engine) throws IncQueryException {
    return BlockToPortMatcher.on(engine);
  }
  
  public PortToPortBlockQuerySpecification getPortToPortBlock() throws IncQueryException {
    return PortToPortBlockQuerySpecification.instance();
  }
  
  public PortToPortBlockMatcher getPortToPortBlock(final IncQueryEngine engine) throws IncQueryException {
    return PortToPortBlockMatcher.on(engine);
  }
  
  public PortConnectionQuerySpecification getPortConnection() throws IncQueryException {
    return PortConnectionQuerySpecification.instance();
  }
  
  public PortConnectionMatcher getPortConnection(final IncQueryEngine engine) throws IncQueryException {
    return PortConnectionMatcher.on(engine);
  }
  
  public SimpleConnectionQuerySpecification getSimpleConnection() throws IncQueryException {
    return SimpleConnectionQuerySpecification.instance();
  }
  
  public SimpleConnectionMatcher getSimpleConnection(final IncQueryEngine engine) throws IncQueryException {
    return SimpleConnectionMatcher.on(engine);
  }
  
  public MultiConnectionQuerySpecification getMultiConnection() throws IncQueryException {
    return MultiConnectionQuerySpecification.instance();
  }
  
  public MultiConnectionMatcher getMultiConnection(final IncQueryEngine engine) throws IncQueryException {
    return MultiConnectionMatcher.on(engine);
  }
  
  public LineNameQuerySpecification getLineName() throws IncQueryException {
    return LineNameQuerySpecification.instance();
  }
  
  public LineNameMatcher getLineName(final IncQueryEngine engine) throws IncQueryException {
    return LineNameMatcher.on(engine);
  }
  
  public GotoConnectedPortsQuerySpecification getGotoConnectedPorts() throws IncQueryException {
    return GotoConnectedPortsQuerySpecification.instance();
  }
  
  public GotoConnectedPortsMatcher getGotoConnectedPorts(final IncQueryEngine engine) throws IncQueryException {
    return GotoConnectedPortsMatcher.on(engine);
  }
  
  public PortBlockInPortToOutPortQuerySpecification getPortBlockInPortToOutPort() throws IncQueryException {
    return PortBlockInPortToOutPortQuerySpecification.instance();
  }
  
  public PortBlockInPortToOutPortMatcher getPortBlockInPortToOutPort(final IncQueryEngine engine) throws IncQueryException {
    return PortBlockInPortToOutPortMatcher.on(engine);
  }
  
  public InPortToBlockPortOutPortQuerySpecification getInPortToBlockPortOutPort() throws IncQueryException {
    return InPortToBlockPortOutPortQuerySpecification.instance();
  }
  
  public InPortToBlockPortOutPortMatcher getInPortToBlockPortOutPort(final IncQueryEngine engine) throws IncQueryException {
    return InPortToBlockPortOutPortMatcher.on(engine);
  }
  
  public BusSpecificationInPortToOutPortQuerySpecification getBusSpecificationInPortToOutPort() throws IncQueryException {
    return BusSpecificationInPortToOutPortQuerySpecification.instance();
  }
  
  public BusSpecificationInPortToOutPortMatcher getBusSpecificationInPortToOutPort(final IncQueryEngine engine) throws IncQueryException {
    return BusSpecificationInPortToOutPortMatcher.on(engine);
  }
  
  public SimpleInPortToInPortConnectionQuerySpecification getSimpleInPortToInPortConnection() throws IncQueryException {
    return SimpleInPortToInPortConnectionQuerySpecification.instance();
  }
  
  public SimpleInPortToInPortConnectionMatcher getSimpleInPortToInPortConnection(final IncQueryEngine engine) throws IncQueryException {
    return SimpleInPortToInPortConnectionMatcher.on(engine);
  }
  
  public InPortToInPortConnectionQuerySpecification getInPortToInPortConnection() throws IncQueryException {
    return InPortToInPortConnectionQuerySpecification.instance();
  }
  
  public InPortToInPortConnectionMatcher getInPortToInPortConnection(final IncQueryEngine engine) throws IncQueryException {
    return InPortToInPortConnectionMatcher.on(engine);
  }
  
  public SimpleOutPortToOutPortConnectionQuerySpecification getSimpleOutPortToOutPortConnection() throws IncQueryException {
    return SimpleOutPortToOutPortConnectionQuerySpecification.instance();
  }
  
  public SimpleOutPortToOutPortConnectionMatcher getSimpleOutPortToOutPortConnection(final IncQueryEngine engine) throws IncQueryException {
    return SimpleOutPortToOutPortConnectionMatcher.on(engine);
  }
  
  public OutPortToOutPortConnectionQuerySpecification getOutPortToOutPortConnection() throws IncQueryException {
    return OutPortToOutPortConnectionQuerySpecification.instance();
  }
  
  public OutPortToOutPortConnectionMatcher getOutPortToOutPortConnection(final IncQueryEngine engine) throws IncQueryException {
    return OutPortToOutPortConnectionMatcher.on(engine);
  }
  
  public ConnectedInPortsQuerySpecification getConnectedInPorts() throws IncQueryException {
    return ConnectedInPortsQuerySpecification.instance();
  }
  
  public ConnectedInPortsMatcher getConnectedInPorts(final IncQueryEngine engine) throws IncQueryException {
    return ConnectedInPortsMatcher.on(engine);
  }
  
  public SimpleConnectedInPortQuerySpecification getSimpleConnectedInPort() throws IncQueryException {
    return SimpleConnectedInPortQuerySpecification.instance();
  }
  
  public SimpleConnectedInPortMatcher getSimpleConnectedInPort(final IncQueryEngine engine) throws IncQueryException {
    return SimpleConnectedInPortMatcher.on(engine);
  }
  
  public ConnectedOutPortsQuerySpecification getConnectedOutPorts() throws IncQueryException {
    return ConnectedOutPortsQuerySpecification.instance();
  }
  
  public ConnectedOutPortsMatcher getConnectedOutPorts(final IncQueryEngine engine) throws IncQueryException {
    return ConnectedOutPortsMatcher.on(engine);
  }
  
  public SimpleConnectedOutPortQuerySpecification getSimpleConnectedOutPort() throws IncQueryException {
    return SimpleConnectedOutPortQuerySpecification.instance();
  }
  
  public SimpleConnectedOutPortMatcher getSimpleConnectedOutPort(final IncQueryEngine engine) throws IncQueryException {
    return SimpleConnectedOutPortMatcher.on(engine);
  }
  
  public ConnectedPortsQuerySpecification getConnectedPorts() throws IncQueryException {
    return ConnectedPortsQuerySpecification.instance();
  }
  
  public ConnectedPortsMatcher getConnectedPorts(final IncQueryEngine engine) throws IncQueryException {
    return ConnectedPortsMatcher.on(engine);
  }
  
  public NextOutPortInPathQuerySpecification getNextOutPortInPath() throws IncQueryException {
    return NextOutPortInPathQuerySpecification.instance();
  }
  
  public NextOutPortInPathMatcher getNextOutPortInPath(final IncQueryEngine engine) throws IncQueryException {
    return NextOutPortInPathMatcher.on(engine);
  }
  
  public NextInPortInPathQuerySpecification getNextInPortInPath() throws IncQueryException {
    return NextInPortInPathQuerySpecification.instance();
  }
  
  public NextInPortInPathMatcher getNextInPortInPath(final IncQueryEngine engine) throws IncQueryException {
    return NextInPortInPathMatcher.on(engine);
  }
  
  public BusSelectorQuerySpecification getBusSelector() throws IncQueryException {
    return BusSelectorQuerySpecification.instance();
  }
  
  public BusSelectorMatcher getBusSelector(final IncQueryEngine engine) throws IncQueryException {
    return BusSelectorMatcher.on(engine);
  }
  
  public BusMappingInSelectorQuerySpecification getBusMappingInSelector() throws IncQueryException {
    return BusMappingInSelectorQuerySpecification.instance();
  }
  
  public BusMappingInSelectorMatcher getBusMappingInSelector(final IncQueryEngine engine) throws IncQueryException {
    return BusMappingInSelectorMatcher.on(engine);
  }
  
  public OutportsReachedFromBusSpecificationQuerySpecification getOutportsReachedFromBusSpecification() throws IncQueryException {
    return OutportsReachedFromBusSpecificationQuerySpecification.instance();
  }
  
  public OutportsReachedFromBusSpecificationMatcher getOutportsReachedFromBusSpecification(final IncQueryEngine engine) throws IncQueryException {
    return OutportsReachedFromBusSpecificationMatcher.on(engine);
  }
  
  public FirstOutPortFromBusSpecificationQuerySpecification getFirstOutPortFromBusSpecification() throws IncQueryException {
    return FirstOutPortFromBusSpecificationQuerySpecification.instance();
  }
  
  public FirstOutPortFromBusSpecificationMatcher getFirstOutPortFromBusSpecification(final IncQueryEngine engine) throws IncQueryException {
    return FirstOutPortFromBusSpecificationMatcher.on(engine);
  }
  
  public SimulinkReferenceQuerySpecification getSimulinkReference() throws IncQueryException {
    return SimulinkReferenceQuerySpecification.instance();
  }
  
  public SimulinkReferenceMatcher getSimulinkReference(final IncQueryEngine engine) throws IncQueryException {
    return SimulinkReferenceMatcher.on(engine);
  }
  
  public ReferenceQualifierQuerySpecification getReferenceQualifier() throws IncQueryException {
    return ReferenceQualifierQuerySpecification.instance();
  }
  
  public ReferenceQualifierMatcher getReferenceQualifier(final IncQueryEngine engine) throws IncQueryException {
    return ReferenceQualifierMatcher.on(engine);
  }
  
  public ReferenceEqualQuerySpecification getReferenceEqual() throws IncQueryException {
    return ReferenceEqualQuerySpecification.instance();
  }
  
  public ReferenceEqualMatcher getReferenceEqual(final IncQueryEngine engine) throws IncQueryException {
    return ReferenceEqualMatcher.on(engine);
  }
  
  public ChildBlockNamesQuerySpecification getChildBlockNames() throws IncQueryException {
    return ChildBlockNamesQuerySpecification.instance();
  }
  
  public ChildBlockNamesMatcher getChildBlockNames(final IncQueryEngine engine) throws IncQueryException {
    return ChildBlockNamesMatcher.on(engine);
  }
}
