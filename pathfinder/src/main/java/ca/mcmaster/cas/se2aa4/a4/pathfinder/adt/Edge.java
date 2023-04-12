package ca.mcmaster.cas.se2aa4.a4.pathfinder.adt;

public class Edge {

    private final int c1, c2;
    private int weight;
    private int thickness;

    public Edge(int c1, int c2) {
        this.c1 = c1;
        this.c2 = c2;
    }
    
    public int getV1Idx(){
        return c1;
    }

    public int getV2Idx(){
        return c2;
    }

    public void setEdgeWeight(Node n1, Node n2){
        this.weight = (int)Math.sqrt(Math.pow(n1.getX() - n2.getX(),2) + Math.pow(n1.getY()- n2.getY(),2));;
    }

    public int getEdgeWeight(){
        return weight;
    }

    public void setThickness(int thickness){
        this.thickness = thickness;
    }
    public int getThickness(){
        return thickness;
    }
    

}
