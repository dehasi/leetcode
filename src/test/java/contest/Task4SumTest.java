package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4SumTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        List<List<Integer>> result = solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);

        assertThat(result).containsExactlyInAnyOrder(
            asList(-2, -1, 1, 2),
            asList(-2, 0, 0, 2),
            asList(-1, 0, 0, 1));
    }

    @Test void test2() {
        List<List<Integer>> result = solution.fourSum(new int[] {2, 2, 2, 2, 2}, 8);

        assertThat(result).containsExactlyInAnyOrder(
            asList(2, 2, 2, 2));
    }

    @Test void test3() {
        List<List<Integer>> result = solution.fourSum(new int[] {0, 0, 0, 0}, 0);

        assertThat(result).containsExactlyInAnyOrder(
            asList(0, 0, 0, 0));
    }

    @Test void test4() {
        List<List<Integer>> result = solution.fourSum(new int[] {1, -2, -5, -4, -3, 3, 3, 5}, -11);

        assertThat(result).containsExactlyInAnyOrder(
            asList(-5, -4, -3, 1));
    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                int diff = target - nums[i];
                List<Integer> indexes = map.getOrDefault(diff, new ArrayList<>());
                indexes.add(i);
                map.put(diff, indexes);
            }
            Set<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < nums.length; ++i)
                for (int j = i + 1; j < nums.length; ++j)
                    for (int k = j + 1, pair = nums[i] + nums[j]; k < nums.length; ++k)
                        for (int t : map.getOrDefault(pair + nums[k], emptyList()))
                            if (t > k) result.add(asList(nums[i], nums[j], nums[k], nums[t]));
            return new ArrayList<>(result);
        }
    }
}