package leetcode.easy;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task771Test {

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
            HashMap<Character, Integer> stonesCount = new HashMap<>(56);
            for (int i = 0; i < stones.length(); ++i) {
                char ch = stones.charAt(i);
                stonesCount.put(ch, stonesCount.getOrDefault(ch, 0) + 1);
            }
            int result = 0;
            for (int i = 0; i < jewels.length(); ++i)
                result += stonesCount.getOrDefault(jewels.charAt(i), 0);

            return result;
        }
    }
}