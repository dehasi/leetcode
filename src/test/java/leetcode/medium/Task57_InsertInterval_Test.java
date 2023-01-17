package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class Task57_InsertInterval_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        assertThat(solution.insert($$($(1, 3), $(6, 9)), $(2, 5))).isEqualTo($$($(1, 5), $(6, 9)));
        assertThat(solution.insert($$($(1, 2), $(3, 5), $(6, 7), $(8, 10), $(12, 16)), $(4, 8))).isEqualTo($$($(1, 2), $(3, 10), $(12, 16)));
    }

    @Test
    void test2() {
        assertThat(solution.insert($$($(1, 5)), $(5, 7))).isEqualTo($$($(1, 7)));
    }

    @Test
    void test3() {
        assertThat(solution.insert($$($(3, 5), $(12, 15)), $(6, 6))).isEqualTo($$($(3, 5), $(6, 6), $(12, 15)));
    }


    private static int[] $(int... vals) {
        return vals;
    }

    private static int[][] $$(int[]... rows) {
        return rows;
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals.length == 0) return new int[][]{newInterval};
            List<int[]> result = new ArrayList<>(intervals.length);
            int i = 0, S = newInterval[0], E = newInterval[1];

            // take what we can before overlap
            for (; i < intervals.length; ++i) {
                int si = intervals[i][0], ei = intervals[i][1];
                if (S <= ei) break;
                result.add(intervals[i]);
            }

            // merge
            int nS = S, nE = E, cnt = 0;
            for (; i < intervals.length; ++i) {
                int si = intervals[i][0], ei = intervals[i][1];
                if (nE < si) break;
                nS = Math.min(nS, si);
                nE = Math.max(nE, ei);
                ++cnt;
            }
            if (cnt > 0)
                result.add(new int[]{nS, nE});
            else if (i < intervals.length && newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
            }
            // take the rest
            for (; i < intervals.length; ++i) {
                result.add(intervals[i]);
            }

            // newInterval is the last
            if (intervals[intervals.length - 1][1] < newInterval[0]) {
                result.add(newInterval);
            }
            int[][] array = new int[result.size()][];
            result.toArray(array); // fill the array
            return array;
        }
    }
}