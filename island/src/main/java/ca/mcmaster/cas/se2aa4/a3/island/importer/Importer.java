package ca.mcmaster.cas.se2aa4.a3.island.importer;

import java.util.ArrayList;
import java.util.List;


import ca.mcmaster.cas.se2aa4.a2.io.Structs.*;
import ca.mcmaster.cas.se2aa4.a3.island.adt.*;


public class Importer {
    private double width, height = 0;
    private List<Corner> corners = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();;
    private List<Tile> tiles = new ArrayList<>();;

    public IslandMesh buildADT(List<Vertex> vertices,List<Segment> segments, List<Polygon> polygons){


        for (Vertex v: vertices) {
            double x = v.getX();
            double y = v.getY();
            
            if (x > width){
                width = x;
            }

            if (y > height){
                height = y;
            }

            Corner corner = new Corner(x, y);
            corners.add(corner);
        }

        for (Segment s: segments) {
            Edge edge = new Edge(s.getV1Idx(), s.getV2Idx());
            edges.add(edge);
        }

        List<Integer> centroidlist = new ArrayList<>();
        for (Polygon p: polygons){
            centroidlist.add(p.getCentroidIdx());
        }

        for (Polygon p: polygons) {
            List<Integer> polyvert = new ArrayList<>();
            for (int i = 0; i < p.getSegmentIdxsCount(); i++) {
                int v1 = segments.get(p.getSegmentIdxs(i)).getV1Idx();
                int v2 = segments.get(p.getSegmentIdxs(i)).getV2Idx();
                if (!polyvert.contains(v1)){
                    polyvert.add(v1);
                }
                if (!polyvert.contains(v2)){
                    polyvert.add(v2);
                }   
            }

            Tile tile = new Tile(p.getSegmentIdxsList(), p.getNeighborIdxsList(), p.getCentroidIdx(),polyvert);
            tiles.add(tile);
        }

        IslandMesh Mesh = new IslandMesh(width, height, corners, edges, tiles);

        return Mesh;

    }

}
