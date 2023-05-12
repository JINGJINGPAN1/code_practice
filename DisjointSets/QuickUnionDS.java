package DisjointSets;

public class QuickUnionDS{
    private int[] parent;

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }

    private int find(int p) {
        int root = p;
        while (parent[root] >= 0) {
            root = parent[root];
        }
        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootQ] = rootP;
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
