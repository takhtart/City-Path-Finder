package ca.mcmaster.cas.se2aa4.a3.island.adt;

import java.util.List;

public class Tile {
    private final int centroid;
    private final List<Integer> edge, neighbor, neighbortile, corners;
    private int red,green,blue = 255;
    private String tiletype;

    public Tile(List<Integer> edge, List<Integer> neighbor, int centroid, List<Integer> neighbortile, List<Integer> corners) {
        this.edge = edge;
        this.neighbor = neighbor;
        this.centroid = centroid;
        this.neighbortile = neighbortile;
        this.corners = corners;
    }


    public void setColor(int r, int g, int b){
        if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255){
            this.red = r;
            this.green = g;
            this.blue = b;
        }
    }

    public void setTileType(String type){
        this.tiletype = type;
    }

    public String getStringColor(){
        return red + "," + green + "," + blue;
    }
    
    public int getCentroidIdx() {
        return centroid;
    }

    public List<Integer> getNeighborsList() {
        return neighbor;
    }

    public List<Integer> getSegmentsList() {
        return edge;
    }

    public int getNeighborsCount(){
        return neighbor.size();
    }

    public int geSegmentsCount(){
        return edge.size();
    }

    public List<Integer> getNeighboringTiles(){
        return neighbortile;
    }

    public List<Integer> getCorners(){
        return corners;
    }

    public String getTiletype(){
        return tiletype;
    }

}