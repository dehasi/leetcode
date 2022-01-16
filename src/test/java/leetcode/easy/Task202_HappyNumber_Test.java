package leetcode.easy;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task202_HappyNumber_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isHappy(19)).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isHappy(2)).isFalse();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> seen = new HashSet<>();
            seen.add(n);
            while (true) {
                int sqsum = 0;
                for (; n > 0; n /= 10)
                    sqsum += (n % 10) * (n % 10);
                if (sqsum == 1) return true;
                if (!seen.add(n = sqsum)) return false;
            }
        }
    }
}