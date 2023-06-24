package RedBlackTree;

public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node<T> {
        T val;
        Node<T> left, right;
        boolean color;

        Node(T val, boolean color) {
            this.val = val;
            this.color = color;
        }
    }

    public void insert(T val) {
        root = insert(root, val);
        root.color = BLACK;
    }

    private Node<T> insert(Node<T> node, T val) {
        if (node == null) {
            return new Node<T>(val, RED);
        }

        int cmp = val.compareTo(node.val);
        if (cmp < 0) {
            node.left = insert(node.left, val);
        } else if (cmp > 0) {
            node.right = insert(node.right, val);
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node<T> rotateLeft(Node<T> h) {
        Node<T> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node<T> rotateRight(Node<T> h) {
        Node<T> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node<T> h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
