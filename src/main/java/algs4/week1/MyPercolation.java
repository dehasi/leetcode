package algs4.week1;

public class MyPercolation {

    private final int start;
    private final int stop;
    private final WeightedUnionUF weightedUnionUF;

    private final boolean[] grid;
    private final int n;
    private int numberOfOpenSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public MyPercolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n should be greater that 0 but was " + n);
        this.n = n;
        int size = n * n;
        start = size;
        stop = start + 1;
        weightedUnionUF = new WeightedUnionUF(size + 2);
        // for (int i = 0; i < n; ++i) weightedUnionUF.union(i, start);
        // for (int i = size - n; i < size; ++i) weightedUnionUF.union(i, stop);

        grid = new boolean[size];
    }

    private int cell(int row, int col) {
        if (row <= 0 || row > n) throw new IllegalArgumentException(String.format("row should be in [1..%s] but was %s", n, row));
        if (col <= 0 || col > n) throw new IllegalArgumentException(String.format("col should be in [1..%s] but was %s", n, col));
        return (row - 1) * n + (col - 1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int cell = cell(row, col);
        if (grid[cell]) return;
        grid[cell] = true;
        ++numberOfOpenSites;
        if (row == 1) weightedUnionUF.union(cell, start);
        if (row == n) weightedUnionUF.union(cell, stop);
        // iterate over neighbours
        // union them if they are open
        if (row - 1 > 0 && isOpen(row - 1, col))
            weightedUnionUF.union(cell, cell(row - 1, col));

        if (row + 1 <= n && isOpen(row + 1, col))
            weightedUnionUF.union(cell, cell(row + 1, col));

        if (col - 1 > 0 && isOpen(row, col - 1))
            weightedUnionUF.union(cell, cell(row, col - 1));

        if (col + 1 <= n && isOpen(row, col + 1))
            weightedUnionUF.union(cell, cell(row, col + 1));
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[cell(row, col)];
    }

    // is the site (row, col) full?
    // A full site is an open site
    // that can be connected to an open site in the top row via a chain of neighboring open sites
    public boolean isFull(int row, int col) {
        return isOpen(row, col) && weightedUnionUF.connected(cell(row, col), start);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedUnionUF.connected(start, stop);
    }

    private static class WeightedUnionUF {

        private final int[] id;
        private final int[] sz;

        public WeightedUnionUF(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; ++i) {
                id[i] = i;
                sz[i] = 1;
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
                id[i] = j;
                sz[j] += sz[i]; // id[i] is child of j. => sz[j] is increased
            } else {
                id[j] = i;
                sz[i] += sz[j];
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
    }
}
