package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Task399_EvaluateDivision_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.calcEquation(
                List.of(p("a", "b"), p("b", "c")), $(2.0, 3.0),
                List.of(p("a", "c"), p("b", "a"), p("a", "e"), p("a", "a"), p("x", "x"))
        )).isEqualTo($(6.0, 0.5, -1.0, 1.0, -1.0));
    }

    private static List<String> p(String a, String b) {
        return List.of(a, b);
    }

    private static double[] $(double... vals) {
        return vals;
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] result = new double[queries.size()];

            return result;
        }
    }
}