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
    // [x] Complexity (time, memory): O(nxm)
    static
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {

            int n = heights.length, m = heights[0].length;

            boolean[][] pacific = new boolean[n][m];
            boolean[][] atlantic = new boolean[n][m];

            for (int i = 0; i < n; ++i) {
                dfs(i, 0, heights, pacific, 0);
                dfs(i, m - 1, heights, atlantic, 0);
            }

            for (int j = 0; j < m; ++j) {
                dfs(0, j, heights, pacific, 0);
                dfs(n - 1, j, heights, atlantic, 0);
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    if (pacific[i][j] && atlantic[i][j])
                        result.add(Arrays.asList(i, j));

            return result;
        }

        private final int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        private void dfs(int i, int j, int[][] heights, boolean[][] visited, int parent) {
            if (i < 0 || j < 0 || i >= visited.length || j >= visited[i].length || visited[i][j]) return;
            if (parent > heights[i][j]) return;

            visited[i][j] = true;

            for (int[] d : dir) {
                int di = i + d[0];
                int dj = j + d[1];
                dfs(di, dj, heights, visited, heights[i][j]);
            }
        }
    }
}