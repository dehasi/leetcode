package leetcode.medium;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2007_FindOriginalArrayFromDoubledArray_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.findOriginalArray($(1, 3, 4, 2, 6, 8))).isEqualTo($(1, 3, 4));
        assertThat(solution.findOriginalArray($(6, 3, 0, 1))).isEqualTo($());
        assertThat(solution.findOriginalArray($(1))).isEqualTo($());
        assertThat(solution.findOriginalArray($(3, 3, 3, 3))).isEqualTo($());
    }

    private static int[] $(int... vals) {return vals;}

    // [x] Input boundaries: array len in [1..10^5] array values in [0..10^5]
    // [x] Edge cases: empty array, all elems are the same
    // [x] Complexity (time, memory): TC = O(n), MC = O(n)
    static
    class Solution {
        private static final int[] EMPTY = new int[0];

        public int[] findOriginalArray(int[] changed) {
            int n = changed.length;
            if (n % 2 == 1) return EMPTY;

            int maxValue = Arrays.stream(changed).max().getAsInt();
            int[] buckets = new int[maxValue + 1];
            for (int val : changed)
                ++buckets[val];

            int[] result = new int[n / 2];
            for (int i = 0, j = 0; i < buckets.length; ++i) {
                while (buckets[i] > 0) {
                    --buckets[i];
                    int doubled = 2 * i;
                    if (doubled >= buckets.length || buckets[doubled] <= 0)
                        return EMPTY; // can't double
                    --buckets[doubled];
                    result[j++] = i;
                }
            }
            return result;
        }
    }
}
