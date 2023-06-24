package RedBlackTree;

import org.junit.Test;
import static org.junit.Assert.*;

public class RedBlackTreeTest {

    @Test
    public void testInsert() {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();

        tree.insert(10);
        assertTrue(tree.search(10));

        tree.insert(20);
        assertTrue(tree.search(10));
        assertTrue(tree.search(20));

        tree.insert(5);
        assertTrue(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(20));

        tree.insert(30);
        assertTrue(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(20));
        assertTrue(tree.search(30));
    }

    @Test
    public void testSearch() {
        RedBlackTree<String> tree = new RedBlackTree<String>();

        tree.insert("apple");
        assertTrue(tree.search("apple"));

        tree.insert("banana");
        assertTrue(tree.search("apple"));
        assertTrue(tree.search("banana"));

        tree.insert("orange");
        assertTrue(tree.search("apple"));
        assertTrue(tree.search("banana"));
        assertTrue(tree.search("orange"));

        assertFalse(tree.search("pear"));
    }
}
