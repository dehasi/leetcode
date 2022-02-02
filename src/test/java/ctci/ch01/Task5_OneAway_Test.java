package ctci.ch01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task5_OneAway_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isOneEdit("pale", "ple")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isOneEdit("pales", "pale")).isTrue();
    }

    @Test void test3() {
        assertThat(solution.isOneEdit("pale", "bale")).isTrue();
    }

    @Test void test4() {
        assertThat(solution.isOneEdit("pale", "bake")).isFalse();
    }

    @Test void test5() {
        assertThat(solution.isOneEdit("pale", "able")).isFalse();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {

        // aaab
        // aaac
        //[a:3, b:1]
        //[a:0, b:1, c:-1]

        // aaabb
        // aaac
        //[a:3, b:2]
        //[a:0, b:2, c:-1]

        //[_] s1. len? s1 chars? only lowercase chars

        boolean isOneEdit(String s1, String s2) {
            if (s1.length() == s2.length()) return oneReplace(s1, s2);
            if (s1.length() - s2.length() == 1) return oneAdd(s1, s2);
            if (s1.length() - s2.length() == -1) return oneAdd(s2, s1);
            return false;
        }

        boolean oneReplace(String s1, String s2) {
            assert s1.length() == s2.length();
            boolean wasDiff = false;
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) != s2.charAt(i))
                    if (wasDiff) return false;
                    else wasDiff = true;
            }
            return true;
        }

        boolean oneAdd(String s1, String s2) {
            assert s1.length() - s2.length() == 1;
            boolean wasDiff = false;
            int i = 0, j = 0;
            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    if (wasDiff) return false;
                    wasDiff = true;
                    ++i;
                    continue;
                }
                ++i; ++j;
            }
            return true;
        }
    }
}