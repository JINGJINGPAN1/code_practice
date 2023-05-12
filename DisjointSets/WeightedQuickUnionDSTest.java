package DisjointSets;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightedQuickUnionDSTest {
    @Test
    public void testIsConnected(){
        WeightedQuickUnionDS du = new WeightedQuickUnionDS(6);
        assertFalse(du.isConnected(2,3));

        du.union(2, 3);
        assertTrue(du.isConnected(2, 3));
    }
}
