package leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task84_LargestRectangleInHistogram_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3})).isEqualTo(10);
    }

    @Test void test2() {
        assertThat(solution.largestRectangleArea(new int[] {2, 4})).isEqualTo(4);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int l = 0, r = heights.length - 1, max = 0;
            if (heights.length == 0) return max;
            if (heights.length == 1) return heights[0];

            while (l <= r) {
                int size = Math.min(heights[l], heights[r]) * (r - l + 1);
                max = Math.max(max, size);
                if ((r > 0 && l < heights.length - 1) && heights[l + 1] > heights[r - 1]) ++l;
                else --r;
            }
            return max;
        }
    }
}