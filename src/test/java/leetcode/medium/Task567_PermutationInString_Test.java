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

        public boolean checkInclusion(String s1, String s2) {
            if(s2.length() < s1.length()) return false;

            int n = s1.length();
            int[] s1chars = array(s1, 0, n);
            int[] s2chars = array(s2, 0, n);

            for(int l = 0, r = n; r < s2.length(); ++l, ++r) {
                if(Arrays.equals(s1chars, s2chars)) return true;
                --s2chars[s2.charAt(l) - 'a'];
                ++s2chars[s2.charAt(r) - 'a'];
            }
            return Arrays.equals(s1chars, s2chars);
        }

        int[] array(String s, int from, int toEx) {
            int[] chars = new int[26];
            for(int i = from; i < toEx; ++i)
                ++chars[s.charAt(i) - 'a'];
            return chars;
        }

        public boolean checkInclusion1(String s1, String s2) {
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