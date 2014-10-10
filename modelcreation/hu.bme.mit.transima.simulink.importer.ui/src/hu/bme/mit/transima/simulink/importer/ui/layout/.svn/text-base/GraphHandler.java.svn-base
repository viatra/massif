package hu.bme.mit.transima.simulink.importer.ui.layout;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Connection;
import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.MultiConnection;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.Simulink.SingleConnection;
import hu.bme.mit.transima.simulink.api.layout.BlockLayoutSpecification;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import y.base.Node;
import y.layout.FixNodeLayoutStage;
import y.layout.LayoutOrientation;
import y.layout.hierarchic.IncrementalHierarchicLayouter;
import y.layout.hierarchic.incremental.EdgeLayoutDescriptor;
import y.layout.hierarchic.incremental.NodeLayoutDescriptor;
import y.layout.hierarchic.incremental.RoutingStyle;
import y.view.Graph2D;
import y.view.NodeRealizer;

public class GraphHandler {
	
	//TODO: private visibility
	private Graph2D graph;
	private IncrementalHierarchicLayouter layouter;
	private Map<String,Node> fqnNodeList;
	
	//Connection descriptor: Block's FQNname - target's FQNname
	private Map<String, EList<String>> connections;
	
	
	public GraphHandler() {
		connections = new HashMap<String, EList<String>>();
		layouter = new IncrementalHierarchicLayouter();
		fqnNodeList = new HashMap<String, Node>();
		graph = new Graph2D();
	}
	
	//Add node to graph
	public void addNode(double width, double height, String blockFQN){
		//Create new node with given size
		graph.createNode(0.0f, 0.0f, width, height, blockFQN);
		
		//Add to hashmap FQN and node
		fqnNodeList.put(blockFQN, graph.lastNode());
	}
	
	
	//Add all node(block) to level and process the connection between block
	public void processSameLevelBlocks(Map<Block, BlockLayoutSpecification> bls){
		//create nodes
		for (Map.Entry<Block, BlockLayoutSpecification> block : bls.entrySet()) {
			String blockFQN = block.getKey().getSimulinkRef().getFQN();
			
			double blockWidth = block.getValue().width;
			double blockHeight = block.getValue().height;
			
			addNode(blockWidth, blockHeight, blockFQN);
			
			//Set the connections map with given "references"
			EList<String> targetReferences = checkReferenceFromBlock(block.getKey());
			connections.put(blockFQN, targetReferences);
		}
		
		//createEdges
		for (Map.Entry<String, EList<String>> conn : connections.entrySet()){
		    String sourceFQN = conn.getKey();
		    EList<String> targetFQNs = conn.getValue();
		    for (String targetFQN : targetFQNs) {
		    	Node source = fqnNodeList.get(sourceFQN);
		    	Node target = fqnNodeList.get(targetFQN);
		    	
		    	if(target != null){
		    		graph.createEdge(source, target);
		    	}
			}
		}
	
		//layout the graph
		this.doIHLLayout();
		
		//set the upperLeft coordinates
		graph.setLocation(40.0, 40.0);
		
		//set the TopLeft positions of blocks on bls
		for (Map.Entry<Block, BlockLayoutSpecification> block : bls.entrySet()) {
			Node node = fqnNodeList.get(block.getKey().getSimulinkRef().getFQN());
			NodeRealizer realizer = graph.getRealizer(node);
			block.getValue().topLeft.x = realizer.getX();
			block.getValue().topLeft.y = realizer.getY();
		}
		
	}
	
	
	//Search reference from the given Block, return with the list of target blocks
	public EList<String> checkReferenceFromBlock(Block block){
		EList<String> targetBlocksFQN = new BasicEList<String>();
		
		EList<Port> outPorts = block.getPorts();
		for (Port port : outPorts) {
			if(port instanceof OutPort){
				OutPort outPort = (OutPort) port;
				Connection connection = outPort.getConnection();
				if(connection instanceof SingleConnection){
					SingleConnection singleConnection = (SingleConnection) connection;
					InPort to = singleConnection.getTo();
					Block container = to.getContainer();
					String fqn = container.getSimulinkRef().getFQN();
					targetBlocksFQN.add(fqn);
				}else if(connection instanceof MultiConnection){
					MultiConnection multiConnection = (MultiConnection) connection;
					EList<SingleConnection> connections2 = multiConnection.getConnections();
					for (SingleConnection singleConnection : connections2) {
						InPort to = singleConnection.getTo();
						Block container = to.getContainer();
						String fqn = container.getSimulinkRef().getFQN();
						targetBlocksFQN.add(fqn);
					}
				}
			}
		}
		
		return targetBlocksFQN;
	}
	
	
	//IncrementalHierarchicLayouter settings
	public void doIHLLayout(){
		//Layouter settings
		layouter.setBackloopRoutingEnabled(true);
		layouter.setSelfLoopLayouterEnabled(true);
		layouter.setLayoutOrientation(FixNodeLayoutStage.FIX_POINT_POLICY_CENTER);
		layouter.setGroupAlignmentPolicy(IncrementalHierarchicLayouter.POLICY_ALIGN_GROUPS_CENTER);
		layouter.setLayoutOrientation(LayoutOrientation.LEFT_TO_RIGHT);
		layouter.setMinimumLayerDistance(50.0);
			
		EdgeLayoutDescriptor edgeSettings = new EdgeLayoutDescriptor();
		NodeLayoutDescriptor nodeSettings = new NodeLayoutDescriptor();
		RoutingStyle stl = new RoutingStyle(RoutingStyle.EDGE_STYLE_ORTHOGONAL);
		
		//Edge routing settings
		stl.setBackloopRoutingStyle(RoutingStyle.EDGE_STYLE_ORTHOGONAL);
		stl.setSelfloopRoutingStyle(RoutingStyle.EDGE_STYLE_ORTHOGONAL);
		
		//Create node setting for layouter
		nodeSettings.setLayerAlignment(1.0d);
		nodeSettings.setMinimumDistance(20.0);
		
		//Create edge settings for layouter
		edgeSettings.setOrthogonallyRouted(true);
		edgeSettings.setRoutingStyle(stl);
		
		//Enable the node and edge settings
		layouter.setEdgeLayoutDescriptor(edgeSettings);
		layouter.setNodeLayoutDescriptor(nodeSettings);
				
		//Do layout with the given settings
		layouter.doLayout(graph);
	}
}
