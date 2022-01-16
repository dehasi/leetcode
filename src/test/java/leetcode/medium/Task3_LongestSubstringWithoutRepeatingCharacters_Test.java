package leetcode.medium;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3_LongestSubstringWithoutRepeatingCharacters_Test {

    private final Solution solution = new Solution();

//    @Test void test1() {
//        assertThat(solution).isEqualTo("");
//    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0, l = 0, r = 0;
            HashSet<Character> set = new HashSet<>(26);
            while (r < s.length()) {
                if(!set.contains(s.charAt(r))) {
                    set.add(s.charAt(r));
                    ++r;
                    max = Math.max(max, set.size());
                }else {
                    set.remove(s.charAt(l));
                    ++l;
                }
            }
            return max;
        }
    }
}