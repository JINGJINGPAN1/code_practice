package DisjointSets;

public class WeightedQuickUnionDS {
    private int[] parent;
    private int[] size;

    public WeightedQuickUnionDS(int N){
        parent = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p){
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ){
            return;
        }

        if(size[rootP] < size[rootQ]){
            parent[rootP] = rootQ;
            size[rootQ] = size[rootP] + size[rootQ];
        } else{
            parent[rootQ] = rootP;
            size[rootP] = size[rootQ] + size[rootP];
        }
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

}
