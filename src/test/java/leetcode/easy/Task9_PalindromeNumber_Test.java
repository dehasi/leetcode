package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task9_PalindromeNumber_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isPalindrome(121)).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isPalindrome(-121)).isFalse();
    }

    @Test void tes3() {
        assertThat(solution.isPalindrome(10)).isFalse();
    }

    @Test void tes4() {
        assertThat(solution.isPalindrome(123_456_789_1)).isFalse();
    }

    // [x] Input boundaries: all integer
    // [x] Edge cases are covered, 900_000_000 in reverse can't fit int
    // [x] Complexity is calculated (time, memory) O(len(x)): x is int => O(10)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            if (x != 0 && x % 10 == 0) return false;
            if (x < 10) return true;

            int revers = 0;
            for (int i = x; i > 0; i /= 10)
                revers = revers * 10 + i % 10;

            return revers == x;
        }
    }
}