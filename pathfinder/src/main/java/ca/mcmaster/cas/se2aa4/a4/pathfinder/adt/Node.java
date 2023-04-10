package ca.mcmaster.cas.se2aa4.a4.pathfinder.adt;

import java.util.List;

public class Node {
    private final double x, y;
    private final List<Integer> neighbors;
    private int  red, green, blue = 0;
    public Node(double x, double y, List<Integer> neighbors) {
        this.x = x;
        this.y = y;
        this.neighbors = neighbors;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public List<Integer> getNeighborIdxsList(){
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node corner = (Node) o;
        return x == corner.x && y == corner.y;
    }

    public void setColor(int r, int g, int b){
        if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255){
            this.red = r;
            this.green = g;
            this.blue = b;
        }
    }

    public String getStringColor(){
        return red + "," + green + "," + blue;
    }

}


