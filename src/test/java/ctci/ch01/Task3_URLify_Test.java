package ctci.ch01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3_URLify_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.urlify("abc", 3)).isEqualTo("abc");
    }

    @Test void test2() {
        assertThat(solution.urlify("   ", 1)).isEqualTo("%20");
    }

    @Test void test3() {
        String input = "Mr John Smith    ";
        String output = "Mr%20John%20Smith";
        assertThat(input.length()).isEqualTo(output.length());
        assertThat(solution.urlify(input, 13)).isEqualTo(output);
    }

    @Test void test4() {
        assertThat(solution.urlify("", 0)).isEqualTo("");
    }

    // [_] Input boundaries:
    // [_] Edge cases: all spaces, no spaces, empty string
    // [_] Complexity (time, memory): O(n), O(1) - we do it actually in place.
    class Solution {

        String urlify(String s, int trueLen) {
            char[] input = s.toCharArray();

            for (int chari = trueLen - 1, spacei = input.length - 1; chari >= 0; --chari) {
                if (input[chari] == ' ') {
                    input[spacei] = '0';
                    input[spacei - 1] = '2';
                    input[spacei - 2] = '%';
                    spacei -= 3;
                } else {
                    input[spacei] = input[chari];
                    spacei -= 1;
                }
            }
            return new String(input);
        }
    }
}