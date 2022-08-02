package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task378_KthSmallestElementSortedMatrix_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}};

        assertThat(solution.kthSmallest(matrix, 1)).isEqualTo(1);
        assertThat(solution.kthSmallest(matrix, 2)).isEqualTo(5);
        assertThat(solution.kthSmallest(matrix, 3)).isEqualTo(9);
        assertThat(solution.kthSmallest(matrix, 4)).isEqualTo(10);
        assertThat(solution.kthSmallest(matrix, 5)).isEqualTo(11);
        assertThat(solution.kthSmallest(matrix, 6)).isEqualTo(12);
        assertThat(solution.kthSmallest(matrix, 7)).isEqualTo(13);
        assertThat(solution.kthSmallest(matrix, 8)).isEqualTo(13);
        assertThat(solution.kthSmallest(matrix, 9)).isEqualTo(15);
    }

    private static int[] $(int... vals) {return vals;}

    private static int[][] $$(int[]... rows) {return rows;}

    // [x] Input boundaries: square matrix, len n in [1..100] matrix[i][j] in [-10^9..10^9]; k in [1..n^2]
    // [x] Edge cases: n = 1, k = 1, k = n^2
    // [x] Complexity (time, memory): TC: n^2log(n) MC: O(n)
    static
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            if (k == 1) return matrix[0][0];
            class Triple {
                final int i, j, val;

                int val() {return val;}

                Triple(int i, int j, int val) {
                    this.i = i;
                    this.j = j;
                    this.val = val;
                }
            }
            int n = matrix.length;
            PriorityQueue<Triple> heap = new PriorityQueue<>(n, Comparator.comparing(Triple::val));

            int kth = matrix[0][0];
            for (int i = 0; i < n; ++i)  // O(n)?
                heap.add(new Triple(i, 0, matrix[i][0]));

            while (k-- > 0) { // k log(n)
                var cur = heap.poll(); //const
                kth = cur.val; // not possible, because k <= n^2
                int i = cur.i, j = cur.j + 1;
                if (j < n)
                    heap.add(new Triple(i, j, matrix[i][j])); // log
            }
            return kth;
        }
    }
}