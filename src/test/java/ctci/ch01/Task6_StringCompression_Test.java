package ctci.ch01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task6_StringCompression_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.compress("aabcccccaaa")).isEqualTo("a2b1c5a3");
    }

    @Test void test2() {
        assertThat(solution.compress("Aa")).isEqualTo("Aa");
    }

    // [x] Input boundaries: [A-Za-z]
    // [x] Edge cases: emtpy string, short string, compressed string len > original len
    // [x] Complexity (time, memory): O(n), O(n)
    class Solution {

        String compress(String str) {
            if (str == null || str.length() < 2) return str;
            int copmLen = compressedLen(str);
            if (copmLen >= str.length()) return str;

            StringBuilder compressed = new StringBuilder(copmLen); // mem = O(n)

            for (int i = 0, count = 0; i < str.length(); ++i) { // O(n);
                ++count;
                if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    compressed.append(str.charAt(i)).append(count);
                    count = 0;
                }
            }
            return compressed.toString();
        }

        int compressedLen(String str) {
            int result = 0;
            for (int i = 0, count = 0; i < str.length(); ++i) {
                ++count;
                if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    result = result + 1 + String.valueOf(count).length();
                    count = 0;
                }
            }
            return result;
        }
    }
}