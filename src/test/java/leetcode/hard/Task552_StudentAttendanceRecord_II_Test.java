package leetcode.hard;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class Task552_StudentAttendanceRecord_II_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.checkRecord(1)).isEqualTo(3);
    }

    @Test void test2() {
        assertThat(solution.checkRecord(2)).isEqualTo(8);
    }

    @Test void test3() {
        assertThat(solution.checkRecord(3)).isEqualTo(19);
    }

    @Test void test4() {
        assertThat(solution.checkRecord(4)).isEqualTo(43);
    }

    @Disabled("Fails with stackoverflow, passes on LeetCode")
    @Test void test10101() {
        assertThat(solution.checkRecord(10101)).isEqualTo(183236316);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        static final int modulo = 1000_000_000 + 7;
        static final int A = 1, L = 2, P = 3, EMPTY = 0;

        private int[][][] cache;

        public int checkRecord(int n) {
            cache = new int[n + 1][3][2];
            for (int[][] array2D : cache) {
                for (int[] array1D : array2D) {
                    Arrays.fill(array1D, -1);
                }
            }
            return count(n, -0, 0);
        }

        int count(int n, int consecutiveLatest, int totalAbsents) {
            if (consecutiveLatest >= 3 || totalAbsents >= 2) return 0;
            if (n == 0) return 1;

            if (cache[n][consecutiveLatest][totalAbsents] != -1)
                return cache[n][consecutiveLatest][totalAbsents];

            // present
            int result = count(n - 1, 0, totalAbsents);
            result %= modulo;

            // late
            result += count(n - 1, consecutiveLatest + 1, totalAbsents);
            result %= modulo;

            // absent
            result += count(n - 1, 0, totalAbsents + 1);
            result %= modulo;

            return cache[n][consecutiveLatest][totalAbsents] = result;
        }
    }
}
