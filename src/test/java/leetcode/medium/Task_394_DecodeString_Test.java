package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task_394_DecodeString_Test {

    private final Solution solution = new Solution();

    @Test void test0() {
        assertThat(solution.decodeString("q")).isEqualTo("q");
    }

    @Test void test1() {
        assertThat(solution.decodeString("3[a]")).isEqualTo("aaa");
    }

    @Test void test2() {
        assertThat(solution.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public String decodeString(String s) {
            Queue<Character> queue = new ArrayDeque<>(s.length());
            for (int i = 0; i < s.length(); ++i)
                queue.add(s.charAt(i));
            return decode(queue);
        }

        private String decode(Queue<Character> queue) {
            StringBuilder result = new StringBuilder();
            StringBuilder pattern = new StringBuilder();
            int num = 0;
            while (!queue.isEmpty()) {
                char ch = queue.poll();
                if (ch == ']') {
                    if (num == 0) return result.append(pattern).toString();
                    while (num-- > 0) result.append(pattern);
                    pattern = new StringBuilder();
                }
                else if (ch == '[') {
                    pattern.append(decode(queue));
                } else if (Character.isDigit(ch)) num = 10 * num + ch - '0';
                else pattern.append(ch);
            }
            return result.toString();
        }
    }
}