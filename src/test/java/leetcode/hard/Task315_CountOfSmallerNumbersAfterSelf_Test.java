package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task315_CountOfSmallerNumbersAfterSelf_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.countSmaller($(5, 2, 6, 1))).containsExactly(2, 1, 1, 0);
    }

    @Test void test2() {
        assertThat(solution.countSmaller($(-1))).containsExactly(0);
    }

    @Test void test3() {
        assertThat(solution.countSmaller($(-1, -1))).containsExactly(0, 0);
    }

    private static int[] $(int... vars) {return vars;}

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> counts = new ArrayList<>(nums.length);


            return counts;
        }
    }
}