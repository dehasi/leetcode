package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task378_KthSmallestElementSortedMatrix_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.kthSmallest($$(
            $(1, 5, 9),
            $(10, 11, 13),
            $(12, 13, 15)), 8
        )).isEqualTo(13);
    }

    private static int[] $(int... vals) {return vals;}

    private static int[][] $$(int[]... rows) {return rows;}

    // [x] Input boundaries: square matrix, len n in [1..100] matrix[i][j] in [-10^9..10^9]; k in [1..n^2]
    // [x] Edge cases: n = 1, k = 1, k = n^2
    // [_] Complexity (time, memory):
    static
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            return -42;
        }
    }
}