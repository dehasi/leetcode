package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task125_Palindrome_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isPalindrome("race a car")).isFalse();
    }

    @Test void test3() {
        assertThat(solution.isPalindrome(" ")).isTrue();
    }

    @Test void test4() {
        assertThat(solution.isPalindrome("0P")).isFalse();
    }

    // [x] Input boundaries are clarified 10^5
    // [x] Edge cases are covered empty String
    // [x] Complexity is calculated (time, memory): n = len(s), time O(n), memory O(2*n)
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder(s.length());

            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (Character.isLetter(ch) || Character.isDigit(ch))
                    sb.append(Character.toLowerCase(ch));
            }
            if (sb.isEmpty()) return true;

            return sb.toString().equals(sb.reverse().toString());
        }
    }
}