package medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task8 {
    Solution solution = new Solution();

    @Test void test1() {
        int result = solution.myAtoi("20000000000000000000");

        assertEquals(result, Integer.MAX_VALUE);
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

        assertEquals(solution.myAtoi("2147483647"), Integer.MAX_VALUE);
        assertEquals(solution.myAtoi("2147483648"), Integer.MAX_VALUE);
        assertEquals(solution.myAtoi("-2147483648"), Integer.MIN_VALUE);
        assertEquals(solution.myAtoi("-2147483647"), -2147483647);
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

            long result = 0;
            for (int i = start; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (!Character.isDigit(ch)) break;
                result *= 10;
                result += ch - '0';

                if (result > Integer.MAX_VALUE)
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            return sign * (int)result;
        }
    }
}
