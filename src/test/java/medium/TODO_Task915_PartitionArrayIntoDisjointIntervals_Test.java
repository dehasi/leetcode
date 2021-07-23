package medium;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TODO_Task915_PartitionArrayIntoDisjointIntervals_Test {

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

    }

    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int pow = 1;
            while (pow < n) pow *= 2;

            int[] minTree = new int[pow * 2];
            Arrays.fill(minTree, Integer.MAX_VALUE);
            // [9,9,9,9,1,2,3,4]
            // [9,9,1,3,1,2,3,4]
            // [9,1,1,3,1,2,3,4]
            // [0,1,2,3,4,5,6,7]
            return 0;
        }
    }
}