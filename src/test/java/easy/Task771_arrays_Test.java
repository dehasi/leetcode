package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task771_arrays_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
    }

    @Test void test2() {
        assertThat(solution.numJewelsInStones("z", "ZZ")).isEqualTo(0);
    }

    @Test void test3() {

    }

    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            int[] stonesCount = new int[66];
            for (int i = 0; i < stones.length(); ++i)
                ++stonesCount[stones.charAt(i) - 'A'];

            int result = 0;
            for (int i = 0; i < jewels.length(); ++i)
                result += stonesCount[jewels.charAt(i) - 'A'];

            return result;
        }
    }
}