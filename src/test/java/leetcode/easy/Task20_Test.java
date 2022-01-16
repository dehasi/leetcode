package leetcode.easy;

import java.util.Stack;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task20_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isValid("()")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isValid("()[]{}")).isTrue();
    }

    @Test void test3() {
        assertThat(solution.isValid("(]")).isFalse();
    }

    @Test void test4() {
        assertThat(solution.isValid("([)]")).isFalse();
    }

    @Test void test5() {
        assertThat(solution.isValid("{[]}")).isTrue();
    }

    @Test void test6() {
        assertThat(solution.isValid("{")).isFalse();
        assertThat(solution.isValid("}")).isFalse();
    }

    // [x] Input boundaries are clarified
    // [x] Edge cases are covered
    // [x] Complexity is calculated (time, memory)
    class Solution {
        public boolean isValid(String s) { // s [1..10^4]; s[i] in [](){}; can't be empty
            Stack<Character> stack = new Stack<>(); // 2*10^4 bytes = 20kB. O(n) memory

            for (Character ch : s.toCharArray()) { // O(n), n = s.len
                switch (ch) {
                    case ')':
                        if (stack.empty() || stack.pop() != '(') return false;
                        break;
                    case ']':
                        if (stack.empty() || stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.empty() || stack.pop() != '{') return false;
                        break;
                    default:
                        stack.push(ch);
                }
            }
            return stack.empty();
        }
    }
}