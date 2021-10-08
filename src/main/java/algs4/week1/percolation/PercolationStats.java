package algs4.week1.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;

    private final double mean;
    private final double stddev;
    private final double lo;
    private final double hi;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException("n should be greater that 0 but was " + n);
        if (trials <= 0) throw new IllegalArgumentException("trials should be greater that 0 but was " + trials);

        double[] openRatios = openRatiosPerTrail(n, trials);

        mean = StdStats.mean(openRatios);
        stddev = StdStats.stddev(openRatios);
        lo = mean - CONFIDENCE_95 * stddev / Math.sqrt(trials);
        hi = mean + CONFIDENCE_95 * stddev / Math.sqrt(trials);
    }

    private double[] openRatiosPerTrail(int n, int trials) {
        double[] openRatios = new double[trials];
        for (int i = 0; i < trials; ++i) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                percolation.open(row, col);
            }
            openRatios[i] = percolation.numberOfOpenSites() / (double) (n * n);
        }
        return openRatios;
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return lo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return hi;
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.printf("mean                    = %s\n", stats.mean());
        System.out.printf("stddev                  = %s\n", stats.stddev());
        System.out.printf("95%% confidence interval = [%s, %s]\n", stats.confidenceLo(), stats.confidenceHi());
    }
}