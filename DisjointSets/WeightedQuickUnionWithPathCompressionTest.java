package DisjointSets;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightedQuickUnionWithPathCompressionTest {
    @Test
    public void testIsConnected(){
        WeightedQuickUnionDSWithPathCompression dup = new WeightedQuickUnionDSWithPathCompression(6);
        assertFalse(dup.isConnected(2,3));

        dup.union(2, 3);
        assertTrue(dup.isConnected(2, 3));
    }
}
