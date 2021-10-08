package array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleNumber {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.singleNumber(new int[] {2, 2, 1})).isEqualTo(1);
    }

    @Test void test2() {
        assertThat(solution.singleNumber(new int[] {4, 1, 2, 1, 2})).isEqualTo(4);
    }

    @Test void test3() {
        assertThat(solution.singleNumber(new int[] {1})).isEqualTo(1);
    }

    // [_] Input boundaries are clarified
    // [_] Edge cases are covered
    // [_] Complexity is calculated (time, memory)
    class Solution {
        public int singleNumber(int[] nums) { // [1..30k]; nums[i] in [-30k..30k]
            int result = nums[0];
            for (int i = 1; i < nums.length; ++i)
                result ^= nums[i];

            return result;
        }
    }
}