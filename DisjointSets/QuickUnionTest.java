package DisjointSets;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickUnionTest {
    @Test
    public void testIsConnected(){
        QuickUnionDS du = new QuickUnionDS(6);
        assertFalse(du.isConnected(2,3));

        du.union(2, 3);
        assertTrue(du.isConnected(2, 3));
    }
}
