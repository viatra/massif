/*******************************************************************************
 * Copyright (c) 2010-2019, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Dénes Harmath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.layout.elk;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.RecursiveGraphLayoutEngine;
import org.eclipse.elk.core.data.LayoutMetaDataService;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.util.BasicProgressMonitor;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.elk.graph.util.ElkGraphUtil;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Connection;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.api.layout.BlockLayoutSpecification;
import hu.bme.mit.massif.simulink.api.layout.IExporterLayoutProvider;
import hu.bme.mit.massif.simulink.api.util.Point;

/**
 * Automatic layout provider using ELK.
 */
public class ElkLayoutProvider implements IExporterLayoutProvider {
    
    private final double nodeSize;
    private final double nodeVerticalSpacing;
    private final double nodeHorizontalSpacing;

    public ElkLayoutProvider(double nodeSize, double nodeHorizontalSpacing, double nodeVerticalSpacing) {
        this.nodeSize = nodeSize;
        this.nodeHorizontalSpacing = nodeHorizontalSpacing;
        this.nodeVerticalSpacing = nodeVerticalSpacing;
        LayoutMetaDataService.getInstance().registerLayoutMetaDataProviders(new LayeredMetaDataProvider());
    }
    
    @Override
    public void updateSpecifications(Map<Block, BlockLayoutSpecification> layout) {
        ElkNode graph = createEmptyGraph();
        Set<Block> blocks = layout.keySet();
        Map<Block, ElkNode> nodes = createNodes(blocks, graph);
        createEdges(blocks, nodes);
        layout(graph);
        layout.putAll(getSpecifications(nodes));
    }

    private ElkNode createEmptyGraph() {
        ElkNode graph = ElkGraphUtil.createGraph();
        graph.setProperty(CoreOptions.ALGORITHM, LayeredOptions.ALGORITHM_ID);
        graph.setProperty(CoreOptions.DIRECTION, Direction.RIGHT);
        graph.setProperty(CoreOptions.SPACING_NODE_NODE, nodeVerticalSpacing);
        graph.setProperty(CoreOptions.SPACING_COMPONENT_COMPONENT, nodeVerticalSpacing);
        graph.setProperty(LayeredMetaDataProvider.SPACING_NODE_NODE_BETWEEN_LAYERS, nodeHorizontalSpacing);
        return graph;
    }

    private Map<Block, ElkNode> createNodes(Set<Block> blocks, ElkNode graph) {
        return blocks.stream().collect(Collectors.toMap(block -> block, block -> createNode(graph)));
    }

    private ElkNode createNode(ElkNode graph) {
        ElkNode node = ElkGraphUtil.createNode(graph);
        node.setWidth(nodeSize);
        node.setHeight(nodeSize);
        return node;
    }
    
    private static void createEdges(Set<Block> blocks, Map<Block, ElkNode> nodes) {
        for (Block block : blocks) {
            for (OutPort outPort : block.getOutports()) {
                if (outPort.getConnection() != null) {
                    createEdges(outPort.getConnection(), nodes);
                }
            }
        }
    }
    
    private static void createEdges(Connection connection, Map<Block, ElkNode> nodes) {
        ElkNode source = nodes.get(getSource(connection));
        if (source != null) {
            ElkPort sourcePort = ElkGraphUtil.createPort(source);
            for (SingleConnection singleConnection : getSingleConnections(connection).collect(Collectors.toSet())) {
                Block targetBlock = getTarget(singleConnection);
                ElkNode target = nodes.get(targetBlock);
                if (target != null) {
                    ElkPort targetPort = ElkGraphUtil.createPort(target);
                    ElkGraphUtil.createSimpleEdge(sourcePort, targetPort);                    
                }
            }
        }
    }

    private static Block getSource(Connection connection) {
        return connection.getFrom().getContainer();
    }

    public static Stream<SingleConnection> getSingleConnections(Connection connection) {
        if (connection instanceof SingleConnection) {
            SingleConnection singleConnection = (SingleConnection) connection;
            return Stream.of(singleConnection);
        } else if (connection instanceof MultiConnection) {
            MultiConnection multiConnection = (MultiConnection) connection;
            return multiConnection.getConnections().stream();
        } else {
            return Stream.of();
        }
    }
    
    public static Block getTarget(SingleConnection singleConnection) {
        return singleConnection.getTo().getContainer();
    }

    private static void layout(ElkNode graph) {
        new RecursiveGraphLayoutEngine().layout(graph, new BasicProgressMonitor());
    }

    private static Map<Block, BlockLayoutSpecification> getSpecifications(Map<Block, ElkNode> nodes) {
        return nodes.entrySet().stream().collect(Collectors.toMap(it -> it.getKey(), it -> ElkLayoutProvider.getSpecification(it.getValue())));
    }
    
    private static BlockLayoutSpecification getSpecification(ElkNode node) {
        BlockLayoutSpecification specification = new BlockLayoutSpecification();
        specification.topLeft = new Point(node.getX(), node.getY());
        specification.width = node.getWidth();
        specification.height = node.getHeight();
        return specification;
    }
    
}
