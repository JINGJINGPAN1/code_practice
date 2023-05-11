package DisjointSets;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickFindDSTest {

    @Test
    public void testIsConnected(){
        QuickFindDS ds = new QuickFindDS(7);
        assertFalse(ds.isConnected(2,3));

        ds.connect(2, 3);
        assertTrue(ds.isConnected(2, 3));
    }

    @Test
    public void testConnect(){
        QuickFindDS ds = new QuickFindDS(10);
        assertFalse(ds.isConnected(0, 1));
        assertFalse(ds.isConnected(3, 9));

        ds.connect(0,1);
        ds.connect(3,9);

        assertTrue(ds.isConnected(0, 1));
        assertTrue(ds.isConnected(3, 9));

        assertEquals(true,ds.isConnected(0,1));


    }


}
