package adtTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.*;

public class GraphTest {





    @Test
    public void NodeCheck(){
        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
    
        Node c = new Node(0, 20.0, 20);
        Node c1 = new Node(1, 40, 20);
        Node c2 = new Node(0, 40, 40);
        Edge e = new Edge(0,1);
        Edge e1 = new Edge(1,2);
        Edge e2 = new Edge(2,0);

        nodes.add(c);
        nodes.add(c1);
        nodes.add(c2);
        edges.add(e);
        edges.add(e1);
        edges.add(e2);

        Graph g = new Graph(nodes, edges);

        assertEquals(3, g.getNodeCount());
        assertNotEquals(1, g.getNodeCount());
  
    }

    @Test
    public void EdgeCheck(){
        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
    
        Node c = new Node(0, 20.0, 20);
        Node c1 = new Node(1, 40, 20);
        Node c2 = new Node(0, 40, 40);
        Edge e = new Edge(0,1);
        Edge e1 = new Edge(1,2);
        Edge e2 = new Edge(2,0);

        nodes.add(c);
        nodes.add(c1);
        nodes.add(c2);
        edges.add(e);
        edges.add(e1);
        edges.add(e2);

        Graph g = new Graph(nodes, edges);

        assertEquals(3, g.getEdgesCount());
        assertNotEquals(1, g.getEdgesCount());
  
    }
    
}
