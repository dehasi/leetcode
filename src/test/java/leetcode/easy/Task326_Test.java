package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task326_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isPowerOfThree(27)).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isPowerOfThree(Integer.MAX_VALUE)).isFalse();
    }

    @Test void test3() {
        assertThat(solution.isPowerOfThree(Integer.MAX_VALUE)).isFalse();
    }

    // [x] Edge cases are covered
    // [x] Complexity is calculated (time, memory)
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n < 0) return false;
            while (n % 3 == 0)
                n = n / 3; // log_3(n)
            return n == 1;
        }
    }
}