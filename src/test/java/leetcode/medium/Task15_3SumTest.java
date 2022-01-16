package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task15_3SumTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        List<List<Integer>> result = solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4});

        assertThat(result).containsExactlyInAnyOrder(
            asList(-1, -1, 2),
            asList(-1, 0, 1));
    }

    @Test void test2() {
        List<List<Integer>> result = solution.threeSum(new int[] {});

        assertThat(result).isEmpty();
    }

    @Test void test3() {
        List<List<Integer>> result = solution.threeSum(new int[] {0});

        assertThat(result).isEmpty();
    }

    @Timeout(5)
    @Test void test4() {
        List<List<Integer>> result = solution.threeSum(new int[3000]);

        assertThat(result).containsExactlyInAnyOrder(
            asList(0, 0, 0));
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int k = bs(nums, j + 1, nums.length, -nums[i] - nums[j]);
                    if (k > 0) result.add(asList(nums[i], nums[j], nums[k]));
                }
            }
            return new ArrayList<>(result);
        }

        // Arrays.binarySearch is faster
        int bs(int[] arr, int from, int to, int key) {
            while (from < to) {
                int mid = from + (to - from) / 2;
                if (arr[mid] == key) return mid;
                if (arr[mid] > key) to = mid;
                else from = mid + 1;
            }
            return -1;
        }
    }
}
