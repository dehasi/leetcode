package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task1_2SumTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[] result = solution.twoSum(new int[] {2, 7, 11, 15}, 9);

        Arrays.sort(result);
        assertArrayEquals(new int[] {0, 1}, result);
    }

    @Test void test2() {
        int[] result = solution.twoSum(new int[] {3, 2, 4}, 6);
        Arrays.sort(result);
        assertArrayEquals(new int[] {1, 2}, result);
    }

    @Test void test3() {
        int[] result = solution.twoSum(new int[] {3, 3}, 6);

        Arrays.sort(result);
        assertArrayEquals(new int[] {0, 1}, result);
    }

    @Test void test4() {
        int[] result = solution.twoSum(new int[] {0, 2, 2, 2, 0}, 0);

        Arrays.sort(result);
        assertArrayEquals(new int[] {0, 4}, result);
    }

    class Solution {
        // each input would have exactly one solution
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < nums.length; ++i)
                index.put(nums[i], i);

            for (int i = 0; i < nums.length; ++i) {
                int x = index.getOrDefault(target - nums[i], i);
                if (i != x) return new int[] {i, x};
            }
            return null;
        }
    }
}