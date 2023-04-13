package ca.mcmaster.cas.se2aa4.a4.pathfinder.adt;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
    private final double x, y;
    private List<Integer> neighbors = new ArrayList<>();
    private double cost = Double.MAX_VALUE;
    private String nodetype;
    private int reference;
    private int index;

    

    public Node(int i, double x, double y) {
        this.index = i;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setReference(int r){
        reference = r;
    }

    public int getReference(){
        return reference;
    }
    
    public void setNodeType(String type){
        nodetype = type;

    }

    public String getNodeType(){
        return nodetype;
    }

    public void setCost(double d){
        cost = d;
    }

    public double getCost(){
        return cost;
    }

    public int getIndex(){
        return index;
    }

    public List<Integer> getNeighborsNodes(){
        return neighbors;
    }

    public void addNeighbor(int n){
        neighbors.add(n);
    }


    public int compareTo(Node n) {
        if(this.cost < n.getCost()){
            return -1;
        }
        else if(this.cost > n.getCost()){
            return 1;
        }
        else
            return 0;
    }

}


