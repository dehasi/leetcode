package algs4.week1;

import algs4.week1.percolation.Percolation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PercolationTest {

    @Test void open_diagonal_opensCorrectly() {
        int n = 5;
        Percolation percolation = new Percolation(n);
        for (int i = 1; i <= n; ++i) Assertions.assertThat(percolation.isOpen(i, i)).as("[%s,%s]", i).isFalse();

        for (int i = 1; i <= n; ++i) percolation.open(i, i);

        for (int i = 1; i <= n; ++i) Assertions.assertThat(percolation.isOpen(i, i)).isTrue();
    }

    @Test void percolates_shouldPercolate() {
        int n = 5;
        Percolation percolation = new Percolation(n);

        for (int i = 1; i < n; ++i) {
            Assertions.assertThat(percolation.isFull(i, 1)).isFalse();
            percolation.open(i, 1);
            Assertions.assertThat(percolation.percolates()).isFalse();
            Assertions.assertThat(percolation.isFull(i, 1)).isTrue();
        }
        percolation.open(n, 1);
        Assertions.assertThat(percolation.percolates()).isTrue();
    }

    @Test void isFull_calculatesCorrectly() {
        int n = 5;
        Percolation percolation = new Percolation(n);

        for (int i = 1; i < n; ++i) {
            Assertions.assertThat(percolation.isFull(i, 1)).isFalse();
            percolation.open(i, 1);
            Assertions.assertThat(percolation.percolates()).isFalse();
            Assertions.assertThat(percolation.isFull(i, 1)).isTrue();
        }
        percolation.open(n, 1);
        Assertions.assertThat(percolation.percolates()).isTrue();
    }
}