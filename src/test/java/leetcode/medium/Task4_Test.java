package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.longestPalindrome("babad")).isEqualTo("bab");
    }

    @Test void test2() {
        assertThat(solution.longestPalindrome("cbbd")).isEqualTo("bb");
    }

    @Test void test3() {
        assertThat(solution.longestPalindrome("a")).isEqualTo("a");
    }

    @Test void test4() {
        assertThat(solution.longestPalindrome("ac")).isEqualTo("c");
    }

    @Test void test5() {
        assertThat(solution.longestPalindrome("bb")).isEqualTo("bb");
    }

    class Solution {
        public String longestPalindrome(String s) {
            char[] string = s.toCharArray();
            int n = string.length;
            if (n == 1) return s;

            int len = 0, from = 0, to = 1;
            for (int i = 0; i < n; ++i) {
                for (int j = n; j > 1 && j > i && (j - i) > len; --j) {
                    if (isPalindrome(string, i, j - 1) && j - i > len) {
                        from = i; to = j;
                        len = to - from;
                    }
                }
            }
            return s.substring(from, to);
        }

        boolean isPalindrome(char[] s, int from, int to) {
            for (int f = from, t = to; f <= t; ++f, --t)
                if (s[f] != s[t]) return false;
            return true;
        }
    }
}