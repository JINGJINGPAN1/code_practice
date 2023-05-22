package BTree;

public class BTree {
    private BTreeNode root;
    private int order;

    public BTree(int order) {
        this.root = new BTreeNode(order, true);
        this.order = order;
    }

    public void insert(int key) {
        BTreeNode r = root;
        if (r.getNumKeys() == (2 * order - 1)) {
            BTreeNode s = new BTreeNode(order, false);
            root = s;
            s.setChild(0, r);
            splitChild(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }
    private void insertNonFull(BTreeNode node, int key) {
        int i = node.getNumKeys() - 1;
        if (node.isLeaf()) {
            while (i >= 0 && key < node.getKey(i)) {
                node.setKey(i + 1, node.getKey(i));
                i--;
            }
            node.setKey(i + 1, key);
            node.setNumKeys(node.getNumKeys() + 1);
        } else {
            while (i >= 0 && key < node.getKey(i)) {
                i--;
            }
            i++;
            if (node.getChild(i).getNumKeys() == (2 * order - 1)) {
                splitChild(node, i);
                if (key > node.getKey(i)) {
                    i++;
                }
            }
            insertNonFull(node.getChild(i), key);
        }
    }
    private void splitChild(BTreeNode parentNode, int childIndex) {
        int order = this.order;
        BTreeNode childNode = parentNode.getChild(childIndex);
        BTreeNode newChildNode = new BTreeNode(order, childNode.isLeaf());
        parentNode.setNumKeys(parentNode.getNumKeys() + 1);
        for (int j = order - 2; j >= childIndex; j--) {
            parentNode.setKey(j + 1, parentNode.getKey(j));
        }
        parentNode.setKey(childIndex, childNode.getKey(order - 2));
        for (int j = order - 1; j >= childIndex + 1; j--) {
            parentNode.setChild(j + 1, parentNode.getChild(j));
        }
        parentNode.setChild(childIndex + 1, newChildNode);
        for (int j = order - 2; j >= 0; j--) {
            newChildNode.setKey(j, childNode.getKey(j + order - 1));
        }
        for (int j = order - 1; j >= 0; j--) {
            if (!childNode.isLeaf()) {
                newChildNode.setChild(j, childNode.getChild(j + order - 1));
            }
        }
        childNode.setNumKeys(order - 1);
        newChildNode.setNumKeys(order - 1);
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(BTreeNode node, int key) {
        int i = 0;
        while (i < node.getNumKeys() && key > node.getKey(i)) {
            i++;
        }
        if (i < node.getNumKeys() && key == node.getKey(i)) {
            return true;
        } else if (node.isLeaf()) {
            return false;
        } else {
            return search(node.getChild(i), key);
        }
    }

}
