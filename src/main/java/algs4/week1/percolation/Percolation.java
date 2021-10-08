package algs4.week1.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int virtualTop;
    private final int virtualBottom;
    private final WeightedQuickUnionUF weightedUnionUF;

    private final boolean[] grid;
    private final int n;
    private int numberOfOpenSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        assertPositive(n);
        this.n = n;
        int size = n * n;
        virtualTop = size;
        virtualBottom = virtualTop + 1;
        weightedUnionUF = new WeightedQuickUnionUF(size + 2);

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
        if (row == 1) weightedUnionUF.union(cell, virtualTop);
        if (row == n) weightedUnionUF.union(cell, virtualBottom);
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
        return isOpen(row, col) && weightedUnionUF.find(cell(row, col)) == weightedUnionUF.find(virtualTop);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedUnionUF.find(virtualTop) == weightedUnionUF.find(virtualBottom);
    }

    private static void assertPositive(int n) {
        if (n <= 0) throw new IllegalArgumentException("n should be greater that 0 but was " + n);
    }
}
