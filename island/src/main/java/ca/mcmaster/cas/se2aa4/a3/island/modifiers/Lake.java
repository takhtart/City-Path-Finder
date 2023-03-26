package ca.mcmaster.cas.se2aa4.a3.island.modifiers;

import java.util.*;
import ca.mcmaster.cas.se2aa4.a3.island.adt.*;
import ca.mcmaster.cas.se2aa4.a3.island.configuration.Configuration;

public class Lake {

    private int lakes;

    public Lake(int lakes){
        this.lakes = lakes;
    }
    
    public void createLakes (List<Tile> tilesWithColors){
        
        List<Integer> lands = new ArrayList<>();
        int counter = 0;
        for (Tile t:tilesWithColors){
            if (t.getTiletype().equals("land")){
                lands.add(counter);
            } 
            counter++;
        }
        if (lakes > lands.size()){
            lakes = lands.size();
        }
        Random bag = new Random();
        List<Integer> random = new ArrayList<>();
        for (int i = 0; i<lakes; i++){
            int randInt = lands.get(bag.nextInt(lands.size()));
            for (int j = 0; j<random.size(); j++){
                if (random.get(j) == randInt){
                    randInt = lands.get(bag.nextInt(lands.size()));
                    j = -1;
                }
            }
            random.add(randInt);              
        }
        Collections.sort(random);
        
        int i = 0;
        int j = 0;
        for (Tile t: tilesWithColors){
            if(lakes == 0){
                break;
            }
            if (i == random.get(j)){
                t.setColor(45, 105, 173);
                t.setTileType("lake");
                tilesWithColors.set(i, t); 

                j++;
                if(j==random.size()){
                    break;
                }
            }
            

            i++;
        }
        
        for (int n = 0; n<random.size();n++){
            int rand = 5;
            if(rand == 0){
                continue;
            }
            for (int a: tilesWithColors.get(random.get(n)).getNeighborsList()){
                Tile tile = tilesWithColors.get(a);
                if (tile.getTiletype() == "land" && tile.getElevation() == tilesWithColors.get(random.get(n)).getElevation()){
                    tile.setColor(45, 105, 173);
                    tile.setTileType("lake");
                    tilesWithColors.set(a,tile);
                    if(rand > 4){
                        for (int b: tilesWithColors.get(a).getNeighborsList()){
                            Tile c = tilesWithColors.get(b);
                            if (c.getTiletype() == "land" && tile.getElevation() == tilesWithColors.get(random.get(n)).getElevation()){
                                c.setColor(45, 105, 173);
                                c.setTileType("lake");
                                tilesWithColors.set(a,c);
                            }
                        }
                    }
                }
            }
        }
        
    }
}