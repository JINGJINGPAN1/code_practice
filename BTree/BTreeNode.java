package BTree;

public class BTreeNode {
    private int[] keys;
    private BTreeNode[] children;
    private int numKeys;
    private boolean leaf;

    public BTreeNode(int order, boolean leaf){
        this.keys = new int[order - 1];
        this.children = new BTreeNode[order];
        this.numKeys = 0;
        this.leaf = leaf;
    }

    public int getKey(int index){
        return keys[index];
    }

    public void setKey(int index, int key){
        keys[index] = key;
    }

    public BTreeNode getChild(int index){
        return children[index];
    }

    public void setChild(int index, BTreeNode child) {
        children[index] = child;
    }

    public int getNumKeys() {
        return numKeys;
    }

    public void setNumKeys(int numKeys) {
        this.numKeys = numKeys;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
