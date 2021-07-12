package contest;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3811/
class IsomorphicStringsTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertTrue(solution.isIsomorphic("egg", "add"));
    }

    @Test void test2() {
        assertFalse(solution.isIsomorphic("foo", "bar"));
    }

    @Test void test3() {
        assertTrue(solution.isIsomorphic("paper", "title"));
    }

    @Test void test4() {
        assertFalse(solution.isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    @Test void test5() {
        assertTrue(solution.isIsomorphic("a", "a"));
    }

    @Test void test6() {
        assertFalse(solution.isIsomorphic("badc", "baba"));
    }

    static class Solution {

        public boolean isIsomorphic(String s, String t) {
            int n = s.length();
            Map<Character, Character> map = new HashMap<>(n);

            for (int i = 0; i < n; ++i) {
                char ss = s.charAt(i);
                char tt = t.charAt(i);
                if (!map.containsKey(ss)) {
                    if (map.containsValue(tt)) return false;
                    else map.put(ss, tt);
                }
                if (map.get(ss) != tt) return false;
            }

            return true;
        }
    }
}
