package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task417_PacificAtlanticWaterFlow_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}};

        assertThat(solution.pacificAtlantic(heights)).containsExactlyInAnyOrder(
            $(0, 4), $(1, 3), $(1, 4), $(2, 2), $(3, 0), $(3, 1), $(4, 0));
    }

    @Test void test2() {
        int[][] heights = {{1}, {4}, {5}};
        assertThat(solution.pacificAtlantic(heights)).containsExactlyInAnyOrder(
            $(0, 0), $(1, 0), $(2, 0));

        int[][] heights2 = {{1, 2, 3}};
        assertThat(solution.pacificAtlantic(heights2)).containsExactlyInAnyOrder(
            $(0, 0), $(0, 1), $(0, 2));

        int[][] heights3 = {{1}};
        assertThat(solution.pacificAtlantic(heights3)).containsExactlyInAnyOrder(
            $(0, 0));
    }

    @Test void test3() {
        int[][] heights = {
            {10, 10, 10},
            {10, 1, 10},
            {10, 10, 10}};

        assertThat(solution.pacificAtlantic(heights)).containsExactlyInAnyOrder(
            $(0, 0), $(0, 1), $(0, 2),
            $(1, 0),  /**/    $(1, 2),
            $(2, 0), $(2, 1), $(2, 2));
    }

    List<Integer> $(int x, int y) {
        return Arrays.asList(x, y);
    }

    // [x] Input boundaries: m,n in [1..100], heights[r][c] in [0..10^5]
    // [x] Edge cases: 1x1, mx1, 1xn
    // [_] Complexity (time, memory):
    static
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {

            int n = heights.length, m = heights[0].length;
            byte[][] flows = new byte[n][m];

            boolean[][] pacific = new boolean[n][m];
            boolean[][] atlantic = new boolean[n][m];

            for (int i = 0; i < n; ++i) {
                dfs(i, 0, heights, pacific);
                dfs(i, m - 1, heights, atlantic);
            }

            for (int j = 0; j < m; ++j) {
                dfs(0, j, heights, pacific);
                dfs(n - 1, j, heights, atlantic);
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    if (pacific[i][j] && atlantic[i][j])
                        result.add(Arrays.asList(i, j));

            return result;
        }

        private final int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
            visited[i][j] = true;

            for (int[] d : dir) {
                int di = i + d[0];
                int dj = j + d[1];
                if (di < 0 || dj < 0
                    || di >= visited.length || dj >= visited[i].length
                    || visited[di][dj]) continue;

                if (heights[di][dj] >= heights[i][j])
                    dfs(di, dj, heights, visited);
            }
        }
    }
}