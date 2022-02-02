package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task567_PermutationInString_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.checkInclusion("ab", "eidbaooo")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.checkInclusion("ab", "eidboaoo")).isFalse();
    }

    @Test void test3() {
        assertThat(solution.checkInclusion("ab", "ab")).isTrue();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {

        int[] array(String s, int from, int toEx) {
            int[] letters = new int[26];
            for (int i = from; i < toEx; ++i)
                ++letters[s.charAt(i) - 'a'];
            return letters;
        }

        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) return false;

            HashSet<Character> letters = new HashSet<>(26);
            for (int i = 0; i < s1.length() && letters.size() < 26; ++i)
                letters.add(s1.charAt(i));

            int n = s1.length();
            int[] a1 = array(s1, 0, n);
            for (int i = 0; i + n-1 < s2.length(); ++i) {
                if (letters.contains(s2.charAt(i)) && Arrays.equals(a1, array(s2, i, i+n)))
                    return true;
            }
            return false;
        }
    }
}