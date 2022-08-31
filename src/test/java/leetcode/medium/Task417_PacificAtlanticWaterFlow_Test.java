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

    List<Integer> $(int x, int y) {
        return Arrays.asList(x, y);
    }

    // [x] Input boundaries: m,n in [1..100], heights[r][c] in [0..10^5]
    // [x] Edge cases: 1x1, mx1, 1xn
    // [_] Complexity (time, memory):
    static
    class Solution {

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            final byte none = 0, pacific = 1, atlantic = 2, both = 3;
            int n = heights.length, m = heights[0].length;
            byte[][] flows = new byte[n][m];

            Arrays.fill(flows[0], pacific);
            Arrays.fill(flows[n - 1], atlantic);
            for (int r = 0; r < n; ++r) {
                flows[r][0] = pacific;
                flows[r][m - 1] = atlantic;
            }

            flows[0][n - 1] = both;
            flows[m - 1][0] = both;

            // fill pacific
            for (int r = 1; r < n; ++r) {
                for (int c = 1; c < m; ++c) {
                    int cur = heights[r][c];
                    if (cur >= heights[r - 1][c]) flows[r][c] = flows[r - 1][c];
                    if (cur >= heights[r][c - 1]) flows[r][c] = (byte)Math.max(flows[r][c], flows[r][c - 1]);
                }
            }

            // fill atlantic & both
            for (int r = n - 2; r >= 0; --r) {
                for (int c = m - 2; c >= 0; --c) {
                    int cur = heights[r][c];
                    if (cur >= heights[r][c + 1]) {
                        if (flows[r][c + 1] == pacific || flows[r][c + 1] == both)
                            flows[r][c] = both;
                    }
                    if (cur >= heights[r + 1][c]) {
                        if (flows[r + 1][c] == pacific || flows[r + 1][c] == both)
                            flows[r][c] = both;
                    }
                }
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int r = 0; r < n; ++r)
                for (int c = 0; c < m; ++c)
                    if (flows[r][c] == both)
                        result.add(Arrays.asList(r, c));

            return result;
        }
    }
}