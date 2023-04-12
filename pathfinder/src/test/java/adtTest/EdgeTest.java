package adtTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aa4.a4.pathfinder.adt.Edge;

public class EdgeTest {

    @Test
    public void GetIDX(){
        final Edge e = new Edge(1,2);
        assertEquals(1, e.getV1Idx());
        assertEquals(2, e.getV2Idx());
        assertNotEquals(2, e.getV1Idx());
        assertNotEquals(1, e.getV2Idx());
  
    }

    @Test
    public void thickness(){
        final Edge e = new Edge(1,2);
        e.setThickness(2);
        assertEquals(2, e.getThickness());
        assertNotEquals(1, e.getThickness());
  
    }
    
}
