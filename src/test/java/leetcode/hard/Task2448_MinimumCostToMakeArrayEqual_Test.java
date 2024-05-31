package leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task2448_MinimumCostToMakeArrayEqual_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.minCost($(1, 3, 5, 2), $(2, 3, 1, 14))).isEqualTo(8);
        assertThat(solution.minCost($(2, 2, 2, 2, 2), $(4, 2, 8, 1, 3))).isEqualTo(0);
    }

    @Test void test2() {
        assertThat(solution.minCost(
                $(735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518),
                $(724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215, 790754, 320604, 468575, 825614)))
                .isEqualTo(1907611126748L);
    }

    private static int[] $(int... vals) {return vals;}

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public long minCost(int[] nums, int[] cost) {
            int l = min(nums), r = max(nums) + 1;
            long ans = movements(nums, l, cost);

            while (l < r) {
                int mid = l + (r - l) / 2;
                long c = movements(nums, mid, cost);
                if (c <= ans) {
                    ans = c;
                    r = mid;
                } else {
                    l = mid + 1;
                }

            }
            return ans;
        }

        private int min(int[] nums) {
            int min = nums[0];
            for (int num : nums)
                if (num < min) min = num;
            return min;
        }

        private int max(int[] nums) {
            int max = nums[0];
            for (int num : nums)
                if (num > max) max = num;
            return max;
        }

        private long movements(int[] nums, int target, int[] cost) {
            long sum = 0;
            for (int i = 0; i < nums.length; ++i)
                sum += Math.abs((long) target - (long) nums[i]) * (long) cost[i];
            return sum;
        }
    }
}