package leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task76_MinimumWindowSubstring_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat("").isEqualTo("");
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static class Solution {
        public String minWindow(String s, String t) {
            if (t.length() > s.length()) return "";
            if (s.equals(t)) return t;

            char[] sset = new char[58];
            char[] tset = new char[58];

            t.chars().forEach(ch -> ++tset[ch - 'A']);
            s.chars().forEach(ch -> ++sset[ch - 'A']);

            int minR = s.length() - 1, minL = 0;
            int l = 0, r = s.length() - 1;
            while (l - r > t.length()) {
                --sset[s.charAt(l) - 'A'];
                ++l;
                if (substr(tset, sset)) {
                    minR = r; minL = l;
                    continue;
                } else {
                    ++sset[s.charAt(l) - 'A'];
                    --l;
                }
                --sset[s.charAt(r) - 'A'];
                --r;
                if (substr(tset, sset)) {
                    minR = r; minL = l;
                    continue;
                }
                break;
            }
            return (minR - minL) < s.length() ? s.substring(minL, minR - minL + 1) : "";
        }

        boolean substr(char[] tset, char[] sset) {
            for (int i = 0; i < tset.length; ++i)
                if (tset[i] > sset[i]) return false;
            return true;
        }
    }
}