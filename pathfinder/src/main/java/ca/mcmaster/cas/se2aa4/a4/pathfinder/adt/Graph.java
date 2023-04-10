package ca.mcmaster.cas.se2aa4.a4.pathfinder.adt;

import java.util.List;

public class Graph {
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
    
    public Edge getEdge(int i){
        return edges.get(i);
    }

    public List<Edge> getEdgesList(){
        return edges;
    }

    public int getEdgesCount(){
        return edges.size();
    }

    public Node getNode(int i){
        return nodes.get(i);
    }

    public List<Node> getNodeList(){
        return nodes;
    }

    public int getNodeCount(){
        return nodes.size();
    }


    
}
