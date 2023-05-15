package BinarySearchTree;

class BST<Key extends Comparable<Key>>{
    private Node root;

    private class Node{
        private Key key;
        private Node left;
        private Node right;

        public Node(Key key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    public BST(){
        root = null;
    }

    public void insert(Key key){
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, Key key){
        if(root == null){
            return new Node(key);
        }
        int cmp = key.compareTo(root.key);
        if(cmp < 0){
            return insertRec(root.left,key);
        }
        if(cmp > 0){
            return insertRec(root.right,key);
        }
        return root;
    }

    public Node find(Key sk){
        return findRec(root, sk);
    }

    private Node findRec(Node T, Key sk) {
        if(T == null){
            return null;
        }
        int cmp = sk.compareTo(T.key);
        if(cmp == 0){
            return T;
        }
        else if(cmp < 0){
            return findRec(T.left,sk);
        }
        else return findRec(T.right,sk);
    }

    public void delete(Key key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, Key key) {
        if (root == null) {
            return null;
        }

        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = deleteRec(root.left, key);
        } else if (cmp > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private Key minValue(Node node) {
        Key minVal = node.key;
        while (node.left != null) {
            minVal = node.left.key;
            node = node.left;
        }
        return minVal;
    }

}
























/**class BST<Key extends Comparable<Key>> {
    private Node root;

    private class Node {
        private Key key;
        private Node left;
        private Node right;

        public Node(Key key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public BST() {
        root = null;
    }

    public void insert(Key key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, Key key) {
        if (root == null) {
            return new Node(key);
        }

        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            root.left = insertRec(root.left, key);
        else if (cmp > 0)
            root.right = insertRec(root.right, key);

        return root;
    }

    public Node find(Key sk) {
        return findRec(root, sk);
    }

    private Node findRec(Node T, Key sk) {
        if (T == null)
            return null;

        int cmp = sk.compareTo(T.key);
        if (cmp == 0)
            return T;
        else if (cmp < 0)
            return findRec(T.left, sk);
        else
            return findRec(T.right, sk);
    }
}*/

