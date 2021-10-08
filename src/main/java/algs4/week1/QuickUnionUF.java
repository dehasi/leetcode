package algs4.week1;

public class QuickUnionUF {

    private final int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; ++i)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

    private int root(int i) {
        while (id[i] != i) i = id[i];
        return i;
    }

    public static void main(String[] args) {

    }
}
