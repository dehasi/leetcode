package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task560Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int result = solution.subarraySum(new int[] {1, 1, 1}, 2);

        assertEquals(result, 2);
    }

    @Test void test2() {
        int result = solution.subarraySum(new int[] {1, 2, 3}, 3);

        assertEquals(result, 2);
    }

    @Test void test3() {
        int result = solution.subarraySum(new int[] {1, 2, 3, -1, 1}, 3);

        assertEquals(result, 3);
    }

    @Test void test4() {
        int result = solution.subarraySum(new int[] {1, 2, 0}, 3);

        assertEquals(result, 2);
    }

    @Test void test5() {
        int result = solution.subarraySum(new int[] {1}, 0);

        assertEquals(result, 0);
    }

    @Test void test6() {
        int result = solution.subarraySum(new int[] {-1, -1, 1}, 0);

        assertEquals(result, 1);
    }

    class Solution {

        public int subarraySum(int[] nums, int k) {
            int result = 0, prefixSum = 0, n = nums.length;
            Map<Integer, Integer> hash = new HashMap<>(n);
            hash.put(prefixSum, 1);
            for (int i = 0; i < n; ++i) {
                prefixSum += nums[i];
                if (hash.containsKey(prefixSum - k))
                    result += hash.getOrDefault(prefixSum - k, 0);
                hash.put(prefixSum, hash.getOrDefault(prefixSum, 0) + 1);
            }
            return result;
        }
    }
}
