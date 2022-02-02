package ctci.ch01;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2_StringPermutation_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isPermutation2("abc", "bca")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isPermutation2("abc", "abz")).isFalse();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {

        boolean isPermutation(String a, String b) {
            if (a.length() != b.length()) return false;

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length(); ++i) {
                char ch = a.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for (int i = 0; i < b.length(); ++i) {
                char ch = b.charAt(i);
                if (!map.containsKey(ch)) return false;
                int cnt = map.get(ch) - 1;
                if (cnt == 0) map.remove(ch);
                else map.put(ch, cnt);
            }

            return map.isEmpty();
        }

        boolean isPermutation2(String a, String b) {
            if (a.length() != b.length()) return false;

            int[] charCount = new int[128];
            for (int i = 0; i < a.length(); ++i)
                ++charCount[a.charAt(i)];

            for (int i = 0; i < b.length(); ++i)
                --charCount[b.charAt(i)];

            for (int cnt : charCount)
                if (cnt != 0) return false;

            return true;
        }
    }
}