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
        final byte not_visited = 0, none = 1, pacific = 2, atlantic = 3, both = 4;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {

            int n = heights.length, m = heights[0].length;
            byte[][] flows = new byte[n][m];

            //            Arrays.fill(flows[0], pacific);
            //            Arrays.fill(flows[n - 1], atlantic);
            //            for (int r = 0; r < n; ++r) {
            //                flows[r][0] = pacific;
            //                flows[r][m - 1] = atlantic;
            //            }
            //
            //            flows[0][n - 1] = both;
            //            flows[m - 1][0] = both;

            for (int i = 0; i < heights.length; ++i) {
                for (int j = 0; j < heights[0].length; ++j) {
                    if (flows[i][j] == not_visited)
                        flows[i][j] = dfs(i, j, heights, flows, 1000000);
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int r = 0; r < n; ++r)
                for (int c = 0; c < m; ++c)
                    if (flows[r][c] == both)
                        result.add(Arrays.asList(r, c));

            return result;
        }

        byte dfs(int i, int j, int[][] heights, byte[][] flows, int parent) {
            if (i < 0) return pacific;
            if (j < 0) return pacific;
            if (i >= heights.length) return atlantic;
            if (j >= heights[i].length) return atlantic;
            if (flows[i][j] != 0) return flows[i][j];
            if (heights[i][j] > parent) return none;
            flows[i][j] = none;
            byte result = 0, a = 0, p = 0;

            result = dfs(i + 1, j, heights, flows, heights[i][j]);
            if (result == pacific) ++p;
            if (result == atlantic) ++a;
            if (result == both) {++a; ++p;}
            result = dfs(i, j + 1, heights, flows, heights[i][j]);
            if (result == pacific) ++p;
            if (result == atlantic) ++a;
            if (result == both) {++a; ++p;}
            result = dfs(i - 1, j, heights, flows, heights[i][j]);
            if (result == pacific) ++p;
            if (result == atlantic) ++a;
            if (result == both) {++a; ++p;}
            result = dfs(i, j - 1, heights, flows, heights[i][j]);
            if (result == pacific) ++p;
            if (result == atlantic) ++a;
            if (result == both) {++a; ++p;}

            if (a == 0 && p == 0) return flows[i][j] = none;
            if (a == 0 && p > 0) return flows[i][j] = pacific;
            if (a > 0 && p == 0) return flows[i][j] = atlantic;
            if (a > 0 && p > 0) return flows[i][j] = both;
            return -54;
        }
    }
}