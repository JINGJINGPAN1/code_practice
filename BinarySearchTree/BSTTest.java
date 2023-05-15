package BinarySearchTree;

import org.junit.Test;

public class BSTTest {

    @Test
    public void testInsert(){
        BST<Integer> bst = new BST<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(60);
        bst.insert(40);
    }

    @Test
    public void testFind(){
        BST<Integer> bst = new BST<>();

        bst.insert(50);
        bst.insert(30);
        bst.find(50);

    }

    @Test
    public void testDelete(){
        BST<Integer> bst = new BST<>();

        bst.insert(50);
        bst.insert(30);
        bst.delete(50);

    }




}
