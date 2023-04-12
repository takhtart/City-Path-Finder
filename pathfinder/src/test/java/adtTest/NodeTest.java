package adtTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.Node;

public class NodeTest {
    List<Integer> neighbors = new ArrayList<>();
    
    @Test
    public void testXY(){
        final Node c = new Node(0, 20.0, 23.0);
        assertEquals(20.0, c.getX());
        assertEquals(23.0, c.getY());

        assertNotEquals(23.0, c.getX());
        assertNotEquals(20.0, c.getY());
    }

}
