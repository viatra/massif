package hu.bme.mit.transima.core.util.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.incquery.runtime.base.itc.igraph.IGraphDataSource;


public class DepthFirstSearch {

    List<Deque<Object>> paths = new ArrayList<Deque<Object>>();
	
    public List<Deque<Object>> depthFirstSearch(IGraphDataSource<Object> graph, Object startNode, Object endNode) {
		List<Object> endNodes = new ArrayList<Object>();
		endNodes.add(endNode);
		return depthFirstSearch(graph, startNode, endNodes);
	}

    public List<Deque<Object>> depthFirstSearch(IGraphDataSource<Object> graph, Object startNode, List<Object> endNodes) {
        Deque<Object> visited = new LinkedList<Object>();
	    visited.add(startNode);
	    return depthFirstSearch(graph, visited, endNodes);
	}
	
	
    protected List<Deque<Object>> depthFirstSearch(IGraphDataSource<Object> graph, Deque<Object> visited,
        List<Object> endNodes) {
        List<Object> nodes = graph.getTargetNodes(visited.getLast());
        // examine adjacent nodes
        for (Object node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (endNodes.contains(node)) {
                visited.add(node);
                addPath(visited);
                visited.removeLast();
                break;
            }
        }
        // in breadth-first, recursion needs to come after visiting connected nodes
        for (Object node : nodes) {
            if (visited.contains(node) || endNodes.contains(node)) {
                continue;
            }
            visited.addLast(node);
            depthFirstSearch(graph, visited, endNodes);
            visited.removeLast();
        }
        
        return paths;
    }

	/**
	 * Save path to store
	 * 
	 * @param visited
	 * */
    protected void addPath(Deque<Object> visited) {
    	//clone visited LinkedList
        Deque<Object> visitedClone = new LinkedList<Object>(visited);
    	paths.add(visitedClone);
    }

    public List<Deque<Object>> getPaths() {
		return paths;
	}
    
}
