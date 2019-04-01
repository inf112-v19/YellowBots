package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Hole;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HoleTest {

    public Hole hole;

    @Test
    public void canMoveIntoFromTest(){
        hole = new Hole(1);
        assertTrue(hole.canMoveIntoFrom(90));
    }

    @Test
    public void canMoveOutFrom(){
        hole = new Hole(1);
        assertFalse(hole.canMoveOutFrom(90));
    }
}
