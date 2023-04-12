package shortestpathTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aa4.a4.pathfinder.PathGen.Dijkstra;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.*;


public class ShortestPathTest {

    @Test
    public void SSSPTest(){
        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        Node n0 = new Node(0, 0, 0);
        Node n1 = new Node(1, 20,10);
        Node n2 = new Node(2, 40, 30);
        Node n3 = new Node(3, 50, 50);
        Node n4 = new Node(4, 60, 40);
        Node n5 = new Node(5, 70, 70);
        Node n6 = new Node(6, 80, 100);

        n0.setNodeType("land");
        n1.setNodeType("land");
        n2.setNodeType("land");
        n3.setNodeType("land");
        n4.setNodeType("land");
        n5.setNodeType("land");
        n6.setNodeType("land");

        n0.addNeighbor(1);

        n1.addNeighbor(0);
        n1.addNeighbor(2);
        n1.addNeighbor(3);

        n2.addNeighbor(1);
        n2.addNeighbor(3);
        n2.addNeighbor(4);

        n3.addNeighbor(1);
        n3.addNeighbor(2);
        n3.addNeighbor(4);
        n3.addNeighbor(5);

        n4.addNeighbor(2);
        n4.addNeighbor(3);
        n4.addNeighbor(5);

        n5.addNeighbor(3);
        n5.addNeighbor(4);
        n5.addNeighbor(6);

        n6.addNeighbor(5);


        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);

        Graph graph = new Graph(nodes, edges);

        Dijkstra d = new Dijkstra();
        List<Node> path = d.GenDijkstra(n0, graph);
        List<Node> NodePath = d.findpath(n0,n6,path);

        List<Integer> ShortestIdxPath = new ArrayList<>();
        for (Node k : NodePath) {
            ShortestIdxPath.add(k.getIndex());
        }
        
        int[] Expected = {0,1,3,5,6};

        for (int i = 0; i < Expected.length; i++) {

            assertEquals(Expected[i], ShortestIdxPath.get(i));

        }



    }

}
