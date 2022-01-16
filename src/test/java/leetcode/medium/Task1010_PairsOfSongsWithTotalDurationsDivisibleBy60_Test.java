package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1010_PairsOfSongsWithTotalDurationsDivisibleBy60_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.numPairsDivisibleBy60(new int[] {30, 20, 150, 100, 40})).isEqualTo(3);
    }

    @Test void test2() {
        assertThat(solution.numPairsDivisibleBy60(new int[] {60, 60, 60})).isEqualTo(3);
    }

    // [x] Input boundaries are clarified, time <=60_000, time[i] in [1..500]
    // [x] Edge cases are covered: time.len = 1; time[i]%60 = 0;
    // [x] Complexity is calculated (time, memory) O(n), mem = O(60)
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] remainders = new int[60];
            int count = 0;
            for (int i = 0; i < time.length; ++i) {
                int remainder = time[i] % 60;
                count += remainders[(60 - remainder) % 60];
                ++remainders[remainder];
            }
            return count;
        }
    }
}