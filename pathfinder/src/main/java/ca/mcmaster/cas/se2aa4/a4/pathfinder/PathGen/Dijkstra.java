package ca.mcmaster.cas.se2aa4.a4.pathfinder.PathGen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.*;

public class Dijkstra implements FindPath{

        public List<Node> GenDijkstra(Node source, Graph g){

                List<Node> nodes = new ArrayList<>(g.getNodeList());
                List<Node> path = new ArrayList<>();

                //Initialize Path Array As Nulls
                for (int i = 0; i < g.getNodeCount(); i++) {
                    path.add(null);
                }
                
                path.set(source.getIndex(),source);
                source.setCost(0.0);
                
                PriorityQueue<Node> MinPQ = new PriorityQueue<Node>();
                MinPQ.add(source);
                while (MinPQ.isEmpty() == false){
                    Node m = MinPQ.poll();
                    for (Integer o: m.getNeighborsNodes()){
                        Node n = nodes.get(o);
        
                        if ((m.getCost() + weight(n, m)) < n.getCost()){
                            path.set(n.getIndex(), m);
                            n.setCost((m.getCost() + weight(n, m)));
                            MinPQ.add(n);
                        }
                    }
        
        
                }
        
                return path;
            }

            public List<Node> findpath(Node source, Node dest, List<Node> Dijkstra){
                List<Node> p = new ArrayList<>();
                
                
                while (source != dest){
                    p.add(dest);
                    dest = Dijkstra.get(dest.getIndex());
                }
                p.add(source);

                Collections.reverse(p);
        
                return p;
            }

            public double weight(Node n, Node m){
                if (n.getNodeType().equals("ocean") || m.getNodeType().equals("ocean")){
                    return Math.sqrt(Math.pow(n.getX() - m.getX(),2) + Math.pow(n.getY()- m.getY(),2))*4;
                }
                else if (n.getNodeType().equals("lake") || m.getNodeType().equals("lake") || n.getNodeType().equals("lagoon") || m.getNodeType().equals("lagoon") ){
                    return Math.sqrt(Math.pow(n.getX() - m.getX(),2) + Math.pow(n.getY()- m.getY(),2)) * 40;
                }
                else{
                    return Math.sqrt(Math.pow(n.getX() - m.getX(),2) + Math.pow(n.getY()- m.getY(),2));
                }
                
             }
    }
