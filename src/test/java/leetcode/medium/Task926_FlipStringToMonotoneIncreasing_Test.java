package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task926_FlipStringToMonotoneIncreasing_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        assertThat(solution.minFlipsMonoIncr("00110")).isEqualTo(1);
        assertThat(solution.minFlipsMonoIncr("010110")).isEqualTo(2);
        assertThat(solution.minFlipsMonoIncr("00011000")).isEqualTo(2);
    }

    // [x] Input boundaries: len(s) in [1..10^5], s_i in (0|1)
    // [x] Edge cases: all zeros/ones, len == 1;
    // [_] Complexity (time, memory):
    static
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int ones = 0, zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') ++zeros;
                else ++ones;
            }
            if (ones == 0 || zeros == 0) return 0;
            return -1;
        }
    }
}