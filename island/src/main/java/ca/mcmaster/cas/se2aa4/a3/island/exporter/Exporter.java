package ca.mcmaster.cas.se2aa4.a3.island.exporter;

import java.util.ArrayList;
import java.util.List;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.*;
import ca.mcmaster.cas.se2aa4.a3.island.adt.*;

public class Exporter {
    private List<Vertex> vertices = new ArrayList<>();
    private List<Segment> segments = new ArrayList<>();
    private List<Polygon> polygons = new ArrayList<>();

    public Mesh buildStructs(List<Corner> corners,List<Edge> edges, List<Tile> tiles){
        

        for (Corner c: corners) {
            double x = c.getX();
            double y = c.getY();
            Property color = Property.newBuilder().setKey("rgb_color").setValue(c.getStringColor()).build();
            Property size = Property.newBuilder().setKey("size").setValue(Double.toString(c.getSize())).build();
            Property isCity = Property.newBuilder().setKey("city").setValue(Boolean.toString(c.isCity())).build();
            Vertex vertex = Vertex.newBuilder().setX(x).setY(y).addProperties(color).addProperties(size).addProperties(isCity).build();
            vertices.add(vertex);
        }

        

        for (Edge e: edges) {
            int v1 = e.getV1Idx();
            int v2 = e.getV2Idx();
            Property color = Property.newBuilder().setKey("rgb_color").setValue(e.getStringColor()).build();
            Segment segment = Segment.newBuilder().setV1Idx(v1).setV2Idx(v2).addProperties(color).build();
            Property thickness = Property.newBuilder().setKey("thickness").setValue(""+e.getThickness()).build();
            segment = Segment.newBuilder(segment).setV1Idx(v1).setV2Idx(v2).addProperties(thickness).build();
            segments.add(segment);
        }

        for (Tile t: tiles) {
            Property color = Property.newBuilder().setKey("rgb_color").setValue(t.getStringColor()).build();
            Property tiletype = Property.newBuilder().setKey("tiletype").setValue(t.getTiletype()).build();
            Polygon polygon = Polygon.newBuilder().addAllSegmentIdxs(t.getSegmentsList()).addAllNeighborIdxs(t.getNeighborsList()).setCentroidIdx(t.getCentroidIdx()).addProperties(color).addProperties(tiletype).build();
            polygons.add(polygon);
        }

        return Mesh.newBuilder().addAllVertices(vertices).addAllSegments(segments).addAllPolygons(polygons).build();

    }
}
