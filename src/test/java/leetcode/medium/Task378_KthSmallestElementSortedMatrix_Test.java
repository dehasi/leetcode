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
    // [_] Complexity (time, memory):
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

            int kth = -1;
            for (int j = 0; j < n; ++j) heap.add(new Triple(0, j, matrix[0][j]));

            while (k > 0 && !heap.isEmpty()) {
                var cur = heap.poll();
                kth = cur.val;
                int i = cur.i;
                int j = cur.j + 1;
                if (j < n) {
                    heap.add(new Triple(i, j, matrix[i][j]));
                    --k;
                }
            }
            return kth;
        }

        class Heap {
            final int size;
            final int[] vals;
            int index = 0;

            Heap(int size) {
                this.size = size;
                int pow = nextPowOfTwo(size);
                vals = new int[2 * pow];
            }

            private static int nextPowOfTwo(int val) {
                int pow = 1;
                while (pow < val) pow *= 2;
                return pow;
            }
        }
    }
}