package ca.mcmaster.cas.se2aa4.a3.island.city;

import java.util.Random;

import ca.mcmaster.cas.se2aa4.a3.island.adt.IslandMesh;
import ca.mcmaster.cas.se2aa4.a3.island.adt.*;

public class City {
    private final int numCities;

    public City(int numCities){
        this.numCities = numCities;
    }

    public IslandMesh generatecities(IslandMesh mesh){

        for (int i = 0; i < numCities; i++) {

            Random rand = new Random();
            String[] cities = {"hamlet","city","village","capital"};

            while (true){
                int tileidx = rand.nextInt(0,mesh.getTilesCount());
                Tile tile = mesh.getTilesList().get(tileidx);

                if (tile.getTiletype().equals("land")){
                    int centroididx = tile.getCentroidIdx();
                    Corner cendroid = mesh.getCornersList().get(centroididx);
                    Corner c = new Corner(cendroid.getX(), cendroid.getY());
                    
                    if (i == numCities-1){
                        c.createCity("capital");
                    }
                    else{
                        int cityidx = rand.nextInt(0,3);
                        c.createCity(cities[cityidx]);
                    }
                    
                    mesh.getCornersList().add(c);
                    break;

                }

            }

            
        }

        IslandMesh Mesh = new IslandMesh(mesh.getWidth(), mesh.getHeight(), mesh.getCornersList(), mesh.getEdgesList(), mesh.getTilesList());

        return Mesh;


    }
}
