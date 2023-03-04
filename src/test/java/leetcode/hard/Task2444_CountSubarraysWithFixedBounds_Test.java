package leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task2444_CountSubarraysWithFixedBounds_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        assertThat(solution.countSubarrays($(1, 3, 5, 2, 7, 5), 1, 5)).isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(solution.countSubarrays($(1, 1, 1, 1), 1, 1)).isEqualTo(10);
    }

    private static int[] $(int... vals) {
        return vals;
    }

    // [x] Input boundaries: nums, minK, maxK in [1..10^6], len(nums) in [2..10^5]
    // [x] Edge cases: minK == maxK, all(nums) < minK, all(nums) > maxK,
    // [_] Complexity (time, memory):
    static
    class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            return 0;
        }
    }
}