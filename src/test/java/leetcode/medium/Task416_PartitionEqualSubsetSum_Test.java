package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class Task416_PartitionEqualSubsetSum_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.canPartition($(1, 5, 11, 5))).isTrue();
        assertThat(solution.canPartition($(1, 2, 3, 5))).isFalse();
    }

    @Test void lon_input() {
        assertTimeoutPreemptively(Duration.ofSeconds(30), () -> {
            assertThat(solution.canPartition($(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97))).isFalse();
        });
    }

    private static int[] $(int... vals) {
        return vals;
    }

    // [x] Input boundaries: len(nums) in [1..200], nums[i] in [1..100]
    // [x] Edge cases: len(nums) == 1, max(nums) > sum(nums)/2
    // [_] Complexity (time, memory):
    static
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length < 2) return false;

            int sum = 0, max = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if (sum % 2 != 0) return false;
            sum /= 2;
            if (max == sum) return true;
            if (max > sum) return false;

            return find(0, sum, nums);
        }

        Map<String, Boolean> cache = new HashMap<>();

        boolean find(int i, int sum, int[] nums) {
            if (i == nums.length || sum < 0) return sum == 0;

            if (sum == 0) return true;
            String key = i + "-" + sum;
            if (cache.containsKey(key)) return cache.get(key);

            boolean result = find(i + 1, sum, nums) || find(i + 1, sum - nums[i], nums);
            cache.put(key, result);
            return result;
        }
    }
}
