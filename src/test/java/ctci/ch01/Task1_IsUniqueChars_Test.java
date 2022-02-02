package ctci.ch01;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1_IsUniqueChars_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isUniqChars3("abc")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isUniqChars3("abca")).isFalse();
    }

    // [x] Input boundaries: assume only ASCII lowercase.
    // [x] Edge cases: empty string, long string
    // [x] Complexity (time, memory): O(n)

    class Solution {
        boolean isUniqChars(String str) {
            HashSet<Character> chars = new HashSet<>();
            for (int i = 0; i < str.length(); ++i)
                if (!chars.add(str.charAt(i))) return false;
            return true;
        }

        boolean isUniqChars2(String str) {
            if (str.length() > 128) return false;
            boolean[] chars = new boolean[128];

            for (int i = 0; i < str.length(); ++i) {
                int ch = str.charAt(i) - 'a';
                if (chars[ch]) return false;
                chars[ch] = true;
            }
            return true;
        }

        boolean isUniqChars3(String str) {
            if (str.length() > 128) return false;

            int chars = 0;
            for (int i = 0; i < str.length(); ++i) {
                int ch = str.charAt(i) - 'a';
                if ((chars & (1 << ch)) != 0) return false;
                chars |= (1 << ch);
            }
            return true;
        }
    }
}