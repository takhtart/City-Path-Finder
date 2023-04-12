package ca.mcmaster.cas.se2aa4.a4.pathfinder.PathGen;

import java.util.List;

import ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.*;;

public interface FindPath {

    List<Node> findpath(Node source, Node dest, List<Node> SSSP);

}
