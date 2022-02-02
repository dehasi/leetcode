package ctci.ch01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task7_RotateMatrix_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        solution.rotate(matrix);
        assertThat(matrix).isEqualTo(new int[][] {
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3}
        });
    }

    @Test void antiTranspose() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        solution.antiTranspose(matrix);
        assertThat(matrix).isEqualTo(new int[][] {
            {9, 6, 3},
            {8, 5, 2},
            {7, 4, 1}
        });
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; ++i)
                for (int j = n - i - 1; j >= 0; --j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][n - i - 1];
                    matrix[n - j - 1][n - i - 1] = tmp;
                }

            for (int j = 0; j < n; ++j)
                for (int i = 0; i < n / 2; ++i) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = tmp;
                }
        }

        void antiTranspose(int[][] matrix) {
            int n = matrix.length;

            for (int i = 0; i < n; ++i)
                for (int j = n - i - 1; j >= 0; --j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][n - i - 1];
                    matrix[n - j - 1][n - i - 1] = tmp;
                }
        }
    }
}