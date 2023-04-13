package ca.mcmaster.cas.se2aa4.a3.island.city;

import java.util.List;

import java.util.ArrayList;

import ca.mcmaster.cas.se2aa4.a3.island.adt.*;
import ca.mcmaster.cas.se2aa4.a3.island.adt.Edge;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.PathGen.Dijkstra;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.*;

public class Roads {
    

    public List<ca.mcmaster.cas.se2aa4.a3.island.adt.Edge> generateroads(IslandMesh mesh, List<Integer> cities){

        List<ca.mcmaster.cas.se2aa4.a3.island.adt.Edge> roads = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        int capital = 0;
        List<Integer> cityNodes = new ArrayList<>();
        List<ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.Edge> edges = new ArrayList<>();
        
        int i = 0;
        for (Tile t : mesh.getTilesList()){
            int centroididx = t.getCentroidIdx();
            Corner centroid = mesh.getCorner(centroididx);

            if (cities.indexOf(centroididx) != -1){
                if (centroid.getCityType().equals("capital")){
                    capital = i;
                }
                else{
                    cityNodes.add(i);
                }
            }

            Node n = new Node(i, centroid.getX(), centroid.getY());
            n.setReference(centroididx);
            n.setNodeType(t.getTiletype());

            nodes.add(n);

            i++;
        }

        for (int index = 0; index < nodes.size(); index++) {

            List<Integer> neighborPolyIdx = mesh.getTile(index).getNeighborsList();

            for (int j = 0; j < neighborPolyIdx.size(); j++) {
                int ref = mesh.getTile(neighborPolyIdx.get(j)).getCentroidIdx();

                for (int k = 0; k < nodes.size(); k++) {
                    if (ref == nodes.get(k).getReference()){
                        nodes.get(index).addNeighbor(k);
                        break;
                    }
                    
                }
                
            }
            
        }
        

        Graph g = new Graph(nodes, edges);

        Dijkstra d = new Dijkstra();
        List<Node> Dijkstra = d.GenDijkstra(nodes.get(capital), g);

        for (int j = 0; j < cityNodes.size(); j++) {
            List<Integer> cornerspath = new ArrayList<>();
            List<Node> path = d.findpath(nodes.get(capital), nodes.get(cityNodes.get(j)), Dijkstra);

            for (int l = 0; l < path.size(); l++) {
                cornerspath.add(path.get(l).getReference());
            }

            for (int l = 0; l < cornerspath.size()-1; l++) {
                ca.mcmaster.cas.se2aa4.a3.island.adt.Edge edge = new Edge(cornerspath.get(l), cornerspath.get(l+1));
                edge.setColor(0,0,0);
                edge.setThickness(3);
                edge.createRoad();
                roads.add(edge);
            }


            
        }


        return roads;
    }
}

