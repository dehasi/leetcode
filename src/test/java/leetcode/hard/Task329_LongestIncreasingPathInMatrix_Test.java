package leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task329_LongestIncreasingPathInMatrix_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.longestIncreasingPath(new int[][] {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        })).isEqualTo(4);
    }

    @Test void test2() {
        assertThat(solution.longestIncreasingPath(new int[][] {
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        })).isEqualTo(4);
    }

    @Test void test3() {
        assertThat(solution.longestIncreasingPath(new int[][] {
            {1}
        })).isEqualTo(1);
    }

    @Test void test4() {
        assertThat(solution.longestIncreasingPath(new int[][] {
            {1, 2}
        })).isEqualTo(2);
    }

    // [_] Input boundaries:
    // [x] Edge cases: [[1]] [[1],[2]], [[1,2]]
    // [x] Complexity (time, memory): tc O(n*m), mc O(n*m)
    class Solution {

        public int longestIncreasingPath(int[][] matrix) {
            int result = 0;
            int[][] cache = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; ++i)
                for (int j = 0; j < matrix[0].length; ++j)
                    result = Math.max(result, dfs(matrix, cache, -1, i, j));
            return result;
        }

        int dfs(int[][] matrix, int[][] cache, int root, int i, int j) {
            if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[i].length - 1) return 0;
            if (matrix[i][j] <= root) return 0;

            if (cache[i][j] > 0) return cache[i][j];

            int max = 0;
            max = Math.max(max, dfs(matrix, cache, matrix[i][j], i + 1, j));
            max = Math.max(max, dfs(matrix, cache, matrix[i][j], i, j + 1));
            max = Math.max(max, dfs(matrix, cache, matrix[i][j], i - 1, j));
            max = Math.max(max, dfs(matrix, cache, matrix[i][j], i, j - 1));

            return cache[i][j] = max + 1;
        }
    }
}