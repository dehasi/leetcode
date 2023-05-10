package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


public class Task62_UniquePaths_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.uniquePaths(3, 7)).isEqualTo(28);
        assertThat(solution.uniquePaths(3, 2)).isEqualTo(3);
        assertThat(solution.uniquePaths(1, 4)).isEqualTo(1);
    }

    @Test void long_input() {
        assertTimeoutPreemptively(Duration.ofSeconds(30), () -> {
            assertThat(solution.uniquePaths(51, 9)).isEqualTo(1916797311);
        });
    }

    // [x] Input boundaries: m,n in [1..100]
    // [x] Edge cases: n == 1 or m == 1 or both
    // [x] Complexity (time, memory): TC = O(m*n) MC = O(m*n)
    static
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1) return 1;
            int[][] memo = new int[m + 1][n + 1];

            return uniquePaths(m, n, memo);
        }

        private int uniquePaths(int m, int n, int[][] memo) {
            if (m == 1 || n == 1) return memo[m][n] = 1;
            if (memo[m][n] > 0) return memo[m][n];
            return memo[m][n] = uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo);
        }


        private int uniquePaths_suboptimal(int m, int n) {
            if (m == 1 || n == 1) return 1;

            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
    }
}