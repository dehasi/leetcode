package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1009_ComplementOfBase10Integer_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.bitwiseComplement(5)).isEqualTo(2);
    }

    @Test void test2() {
        assertThat(solution.bitwiseComplement(7)).isEqualTo(0);
    }

    @Test void test3() {
        assertThat(solution.bitwiseComplement(10)).isEqualTo(5);
    }

    @Test void test4() {
        assertThat(solution.bitwiseComplement(0)).isEqualTo(1);
    }

    @Test void test5() {
        assertThat(solution.bitwiseComplement(1000000000)).isEqualTo(73741823);
    }

    // [x] Input boundaries: n in [0..10^9] - almost the whole int
    // [x] Edge cases: 0,  how to get the higher bit? i,e, 0001100 -> 0000011
    // [x] Complexity (time, memory): O(32)
    class Solution {
        public int bitwiseComplement(int n) {
            int mask = 1;
            if (n == 0) return mask;
            while (mask < n)
                mask = mask * 2 + 1;

            return mask ^ n;
        }
    }
}