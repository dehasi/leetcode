package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task22_GenerateParentheses_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.generateParenthesis(1)).containsExactly("()");
    }

    @Test void test2() {
        assertThat(solution.generateParenthesis(2)).containsExactlyInAnyOrder("(())", "()()");
    }

    @Test void test3() {
        assertThat(solution.generateParenthesis(3)).containsExactlyInAnyOrder("((()))", "(()())", "(())()", "()(())", "()()()");
    }

    @Test void test4() {
        assertThat(solution.generateParenthesis(4))
            .containsExactlyInAnyOrder("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> result = new ArrayList<>();
            generate(0, 0, n, new StringBuilder(), result);
            return result;
        }

        void generate(int open, int closed, int n, StringBuilder stack, List<String> result) {
            if (open == closed && closed == n) result.add(stack.toString());

            if (open < n) {
                stack.append('(');
                generate(open + 1, closed, n, stack, result);
                stack.setLength(stack.length() - 1);
            }
            if (closed < open) {
                stack.append(')');
                generate(open, closed + 1, n, stack, result);
                stack.setLength(stack.length() - 1);
            }
        }
    }
}