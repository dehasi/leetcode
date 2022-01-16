package leetcode.medium;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task8 {
    Solution solution = new Solution();

    @Test void test1() {
        int result = solution.myAtoi("20000000000000000000");

        assertEquals(result, MAX_VALUE);
    }

    @Test void test2() {
        int result = solution.myAtoi("   -42");

        assertEquals(result, -42);
    }

    @Test void test3() {
        int result = solution.myAtoi("+-12");

        assertEquals(result, 0);
    }

    @Test void test4() {
        assertEquals(solution.myAtoi("2147483647"), MAX_VALUE);
        assertEquals(solution.myAtoi("2147483648"), MAX_VALUE);
        assertEquals(solution.myAtoi("-2147483648"), MIN_VALUE);
        assertEquals(solution.myAtoi("-2147483647"), -2147483647);
    }

    @Test void test5() {
        assertEquals(solution.myAtoi("-91283472332"), MIN_VALUE);
    }

    @Test void maxValues() {
        System.out.println(MIN_VALUE);
        System.out.println(MAX_VALUE);
    }

    static class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            if (s.isEmpty()) return 0;

            int start = 0; int sign = 1;
            if (s.charAt(0) == '-') {
                sign = -1; start = 1;
            } else if (s.charAt(0) == '+') {
                start = 1;
            }

            int result = 0;
            for (int i = start; i < s.length(); ++i) {
                int digit = s.charAt(i) - '0';
                if (digit < 0 || digit > 9) break;
                if (result > MAX_VALUE / 10 || result == MAX_VALUE / 10 && digit > MAX_VALUE % 10)
                    return sign > 0 ? MAX_VALUE : MIN_VALUE;
                result = 10 * result + digit;
            }

            return sign * result;
        }
    }
}
