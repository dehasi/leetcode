package algs4.week1;

public class WeightedUnionUF {

    private final int[] id;
    private final int[] sz;

    public WeightedUnionUF(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i; sz[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j; sz[j] += sz[i]; // id[i] is child of j. => sz[j] is increased
        } else {
            id[j] = i; sz[i] += sz[j];
        }
        // if sz[i] == sz.length || sz[j] == sz.length then all connected.
    }

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]]; // path compression
            i = id[i];
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
