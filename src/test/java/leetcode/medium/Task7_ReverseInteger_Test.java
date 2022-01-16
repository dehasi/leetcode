package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task7_ReverseInteger_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.reverse(-123)).isEqualTo(-321);
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int reverse(int x) {
            int result = 0;
            for (int cur, last; x != 0; x /= 10) {
                last = x % 10;
                cur = result * 10 + last;
                if ((cur - last) / 10 != result) return 0;
                result = cur;
            }
            return result;
        }
    }
}