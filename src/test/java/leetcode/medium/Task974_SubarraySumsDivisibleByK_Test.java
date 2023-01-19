package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task974_SubarraySumsDivisibleByK_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        assertThat(solution.subarraysDivByK($(4, 5, 0, -2, -3, 1), 5)).isEqualTo(7);
    }

    private static int[] $(int... vals) {
        return vals;
    }

    // [x] Input boundaries: len(nums) in [1..3*10^4] num_i in [-10^4..10^4], k in [2..10^4]
    //      sum(num) = 3*10^4*10^4 = 3*10^8
    //      max(int) ~ 2^31 ~ 2*2^10*2^10*2^10 ~ (2^10 ~> 10^3) 2*10^3*10^3*10^3 ~ 2*10^9 ~ 20*10^8
    //      sum(num) << max(int)
    // [z] Edge cases: len(nums) == 0, len(nums) == 1.
    // [_] Complexity (time, memory):
    static
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int[] prefixSum = new int[nums.length]; // MC = O(n)
            prefixSum[0] = nums[0];

            for (int i = 1; i < nums.length; ++i) { // O(n)
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }

            int result = 0;
            for (int w = 0; w < nums.length; ++w) {
                int sum = prefixSum[w];
                if (sum % k == 0) ++result;
                for (int i = w + 1; i < nums.length; ++i) {
                    sum -= nums[i - w - 1];
                    sum += nums[i];
                    if (sum % k == 0) ++result;
                }
            }
            return result;
        }
    }
}