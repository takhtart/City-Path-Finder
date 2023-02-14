package ca.mcmaster.cas.se2aa4.a2.visualizer;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;

import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.List;

import org.apache.batik.ext.awt.geom.Polygon2D;

import java.awt.*;

public class GraphicRenderer {

    private static final int THICKNESS = 3;
    public void render(Mesh aMesh, Graphics2D canvas) {
        canvas.setColor(Color.BLACK);
        Stroke stroke = new BasicStroke(0.5f);
        canvas.setStroke(stroke);


        /* //Displays Segments (Below Vertices)
        for (Segment s: aMesh.getSegmentsList()) {
            
            List<Vertex> v = aMesh.getVerticesList();
            int v1 = s.getV1Idx();
            int v2 = s.getV2Idx();
            double centre_x1 = v.get(v1).getX();
            double centre_y1 = v.get(v1).getY();
            double centre_x2 = v.get(v2).getX();
            double centre_y2 = v.get(v2).getY();
            canvas.setColor(extractColor(s.getPropertiesList()));
            Line2D.Double Line = new Line2D.Double(centre_x1,centre_y1,centre_x2,centre_y2);
            canvas.draw(Line);

    

        } */

        //Displays Vertices (On Top Of Segments)
        for (Vertex v: aMesh.getVerticesList()) {
            double centre_x = v.getX() - (THICKNESS/2.0d);
            double centre_y = v.getY() - (THICKNESS/2.0d);
            Color old = canvas.getColor();
            canvas.setColor(extractColor(v.getPropertiesList()));
            Ellipse2D point = new Ellipse2D.Double(centre_x, centre_y, THICKNESS, THICKNESS);
            canvas.fill(point);
            canvas.setColor(old);
        }
        
        for(Polygon p: aMesh.getPolygonsList()){
            for(int i = 0; i<4; i++){
                List<Vertex> v = aMesh.getVerticesList();
                Segment s = aMesh.getSegments(p.getSegmentIdxs(i));
                int v1 = s.getV1Idx();
                int v2 = s.getV2Idx();
                double centre_x1 = v.get(v1).getX();
                double centre_y1 = v.get(v1).getY();
                double centre_x2 = v.get(v2).getX();
                double centre_y2 = v.get(v2).getY();
                canvas.setColor(extractColor(s.getPropertiesList()));
                Line2D.Double Line = new Line2D.Double(centre_x1,centre_y1,centre_x2,centre_y2);
                //canvas.drawString(""+p.getSegmentIdxs(i),(float)(((centre_x1+centre_x2)/2)+5), (float)((centre_y1+centre_y2)/2)-3);
                canvas.draw(Line);
            }
        }

        //Displays Segment Numbers
        Font stringFont = new Font( "SansSerif", Font.PLAIN, 3 );
        canvas.setFont(stringFont);
        for (int i = 0; i < aMesh.getSegmentsList().size(); i++) {
            Segment s = aMesh.getSegmentsList().get(i);
            
            List<Vertex> v = aMesh.getVerticesList();
            int v1 = s.getV1Idx();
            int v2 = s.getV2Idx();
            float centre_x1 = (float) v.get(v1).getX();
            float centre_y1 = (float) v.get(v1).getY();
            float centre_x2 = (float) v.get(v2).getX();
            float centre_y2 = (float) v.get(v2).getY();
            canvas.setColor(extractColor(s.getPropertiesList()));
            String index = Integer.toString(i);
            if ((centre_y1+centre_y2)/2+3 > 500){
                canvas.drawString(index,((centre_x1+centre_x2)/2), ((centre_y1+centre_y2)/2)-3);
            }
            else{
                canvas.drawString(index,((centre_x1+centre_x2)/2), ((centre_y1+centre_y2)/2)+3);
            }
           

    

        }

       


        /* for (int i = 0; i < aMesh.getPolygonsList().size(); i++) {
            Polygon p = aMesh.getPolygonsList().get(i);

            Structs.Segment segment1 = aMesh.getSegments(p.getSegmentIdxs(0));
            Structs.Segment segment2 = aMesh.getSegments(p.getSegmentIdxs(1));
            Structs.Segment segment3 = aMesh.getSegments(p.getSegmentIdxs(2));
            Structs.Segment segment4 = aMesh.getSegments(p.getSegmentIdxs(3));

           canvas.setColor(extractColor(segment1.getPropertiesList()));
           canvas.setColor(extractColor(segment2.getPropertiesList()));
           canvas.setColor(extractColor(segment3.getPropertiesList()));
           canvas.setColor(extractColor(segment4.getPropertiesList()));

           canvas.draw(new Line2D.Double(aMesh.getVertices(segment1.getV1Idx()).getX(),aMesh.getVertices(segment1.getV1Idx()).getY(),aMesh.getVertices(segment1.getV2Idx()).getX(),aMesh.getVertices(segment1.getV2Idx()).getY()));
           canvas.draw(new Line2D.Double(aMesh.getVertices(segment2.getV1Idx()).getX(),aMesh.getVertices(segment2.getV1Idx()).getY(),aMesh.getVertices(segment2.getV2Idx()).getX(),aMesh.getVertices(segment2.getV2Idx()).getY()));
           canvas.draw(new Line2D.Double(aMesh.getVertices(segment3.getV1Idx()).getX(),aMesh.getVertices(segment3.getV1Idx()).getY(),aMesh.getVertices(segment3.getV2Idx()).getX(),aMesh.getVertices(segment3.getV2Idx()).getY()));
           canvas.draw(new Line2D.Double(aMesh.getVertices(segment4.getV1Idx()).getX(),aMesh.getVertices(segment4.getV1Idx()).getY(),aMesh.getVertices(segment4.getV2Idx()).getX(),aMesh.getVertices(segment4.getV2Idx()).getY()));



        } */

        
        //System.out.println("Vertices: " + aMesh.getVerticesList());
        //System.out.println("Segments: " + aMesh.getSegmentsList());
    
        
    }

    private Color extractColor(List<Property> properties) {
        String val = null;
        for(Property p: properties) {
            if (p.getKey().equals("rgba_color")) {
                System.out.println(p.getValue());
                val = p.getValue();
            }
        }
        if (val == null)
            return Color.BLACK;
        String[] raw = val.split(",");
        int red = Integer.parseInt(raw[0]);
        int green = Integer.parseInt(raw[1]);
        int blue = Integer.parseInt(raw[2]);
        int transparencyAlpha = Integer.parseInt(raw[3]);
        return new Color(red, green, blue, transparencyAlpha);
    }

}
