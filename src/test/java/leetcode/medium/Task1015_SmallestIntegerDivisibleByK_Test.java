package leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1015_SmallestIntegerDivisibleByK_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.smallestRepunitDivByK(1)).isEqualTo(1);
    }

    @Test void test2() {
        assertThat(solution.smallestRepunitDivByK(2)).isEqualTo(-1);
    }

    @Test void test3() {
        assertThat(solution.smallestRepunitDivByK(3)).isEqualTo(3); //111
    }

    @Test void test4() {
        assertThat(solution.smallestRepunitDivByK(4)).isEqualTo(-1);
    }

    @Test void test5() {
        assertThat(solution.smallestRepunitDivByK(23)).isEqualTo(22);
    }

    // [x] Input boundaries are clarified: [1..100_000]
    // [x] Edge cases are covered: N > int_max, we use reminders;
    // [x] Complexity is calculated (time, memory) O(k) O(k),  we just check all reminders.
    class Solution {
        public int smallestRepunitDivByK(int k) {
            if (k % 2 == 0 || k % 5 == 0) return -1;
            if (k == 1) return 1;

            Set<Integer> rems = new HashSet<>(k);
            for (int len = 1, rem = 1; ; ++len, rem = (rem * 10 + 1) % k) {
                if (rem == 0) return len;
                if (!rems.add(rem)) return -1;
            }
        }
    }
}