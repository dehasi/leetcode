package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1461_CheckIfStringContainsAllBinaryCodesOfSizeK_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.hasAllCodes("00110110", 2)).isTrue();
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    // [x] Input boundaries: s in [1..10^5], k in [1..20]
    // [x] Edge cases: k = 1, k = 20, len(s) < k
    // [x] Complexity (time, memory): O(s), M(2^k)
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            if (s == null || s.length() < k) return false;
            int pow = 1 << k;
            boolean[] has = new boolean[pow];

            int num = Integer.valueOf(s.substring(0, k), 2);
            has[num] = true;
            int got = 1;
            for (int i = k; i < s.length() && got < pow; ++i) {
                num = num << 1;
                if ((num & pow) != 0) num = num ^ pow;
                num += (s.charAt(i) - '0');
                if (!has[num]) ++got;
                has[num] = true;
            }
            return got == pow;
        }
    }
}