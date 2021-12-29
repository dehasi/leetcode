package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task461_HammingDistance_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.hammingDistance(1, 4)).isEqualTo(2);
    }

    @Test void test2() {
        assertThat(solution.hammingDistance(1, 3)).isEqualTo(1);
    }

    @Test void test3() {
        assertThat(solution.hammingDistance(Integer.MAX_VALUE, 0)).isEqualTo(31);
    }

    @Test void test4() {
        assertThat(solution.hammingDistance(3, 3)).isEqualTo(0);
    }

    // [_] Input boundaries are clarified, int:[0, 2^31 - 1]
    // [_] Edge cases are covered, 0, int_max
    // [_] Complexity is calculated (time, memory), O(31),
    class Solution {
        public int hammingDistance(int x, int y) {
            int res = 0;
            for (int xor = x ^ y; xor > 0; xor >>= 1)
                if ((xor & 1) == 1)
                    ++res;
            return res;
        }
    }
}