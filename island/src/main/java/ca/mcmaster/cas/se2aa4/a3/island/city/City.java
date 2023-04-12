package ca.mcmaster.cas.se2aa4.a3.island.city;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import ca.mcmaster.cas.se2aa4.a3.island.adt.IslandMesh;
import ca.mcmaster.cas.se2aa4.a3.island.adt.*;

public class City {
    private final int numCities;

    public City(int numCities){
        this.numCities = numCities;
    }

    public IslandMesh generatecities(IslandMesh mesh){
        List<Integer> CityIdx = new ArrayList<>();

        for (int i = 0; i < numCities; i++) {

            Random rand = new Random();
            String[] cities = {"hamlet","city","village","capital"};

            while (true){
                int tileidx = rand.nextInt(0,mesh.getTilesCount());
                Tile tile = mesh.getTilesList().get(tileidx);

                if (tile.getTiletype().equals("land")){
                    int centroididx = tile.getCentroidIdx();
                    Corner centroid = mesh.getCornersList().get(centroididx);
                    CityIdx.add(centroididx);
                    
                    if (i == numCities-1){
                        centroid.createCity(cities[3]);
                    }
                    else{
                        int cityidx = rand.nextInt(0,3);
                        centroid.createCity(cities[cityidx]);
                    }
                
                    break;
                }

            }

           

            
            
        }

        IslandMesh CityMesh = new IslandMesh(mesh.getWidth(), mesh.getHeight(), mesh.getCornersList(), mesh.getEdgesList(), mesh.getTilesList());

        Roads r = new Roads();
        List<Edge> roads = r.generateroads(CityMesh, CityIdx);
        mesh.getEdgesList().addAll(roads);

        IslandMesh PathedMesh = new IslandMesh(mesh.getWidth(), mesh.getHeight(), mesh.getCornersList(), mesh.getEdgesList(), mesh.getTilesList());

        return PathedMesh;


    }
}
