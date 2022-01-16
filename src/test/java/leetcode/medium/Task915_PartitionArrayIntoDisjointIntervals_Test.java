package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task915_PartitionArrayIntoDisjointIntervals_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int result = solution.partitionDisjoint(new int[] {5, 0, 3, 8, 6});

        assertThat(result).isEqualTo(3);
    }

    @Test void test2() {
        int result = solution.partitionDisjoint(new int[] {1, 1, 1, 0, 6, 12});

        assertThat(result).isEqualTo(4);
    }

    @Test void test3() {
        int result = solution.partitionDisjoint(new int[] {1, 1});

        assertThat(result).isEqualTo(1);
    }

    @Test void test4() {
        int result = solution.partitionDisjoint(new int[] {6, 0, 8, 30, 37, 6, 75, 98, 39, 90, 63, 74, 52, 92, 64});

        assertThat(result).isEqualTo(2);
    }

    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int[] rmin = new int[n];
            int[] lmax = new int[n];
            rmin[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; --i)
                rmin[i] = Math.min(rmin[i + 1], nums[i]);
            lmax[0] = nums[0];
            for (int i = 1; i < n; ++i)
                lmax[i] = Math.max(lmax[i - 1], nums[i]);

            for (int i = 0; i < n - 1; ++i) {
                if (lmax[i] <= rmin[i + 1])
                    return i + 1;
            }
            return n - 1;
        }
    }
}