package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task315_CountOfSmallerNumbersAfterSelf_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.countSmaller($(5, 2, 6, 1))).containsExactly(2, 1, 1, 0);
    }

    @Test void test2() {
        assertThat(solution.countSmaller($(-1))).containsExactly(0);
    }

    @Test void test3() {
        assertThat(solution.countSmaller($(-1, -1))).containsExactly(0, 0);
    }

    private static int[] $(int... vars) {return vars;}

    // [x] Input boundaries: nums.len in [1..10^5], nums[i] in [-10^4..10^4]
    // [x] Edge cases: nums.len == 1; nums[i] == nums[i+1] forAll i;
    // [_] Complexity (time, memory):
    static
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            if (n == 1) return List.of(0);
            Integer[] counts = new Integer[n];
            Set<Integer> uniq = new HashSet<>(n / 10);
            for (int num : nums) uniq.add(num);

            List<Integer> keys = new ArrayList<>(uniq);
            Collections.sort(keys);
            counts[n - 1] = 0;
            Map<Integer, Integer> map = new HashMap<>(n);
            map.put(nums[n - 1], 1);

            for (int i = n - 2; i >= 0; --i) {
                if (nums[i] == nums[i + 1]) {
                    counts[i] = counts[i + 1];
                } else {
                    int count = 0;
                    for (Integer key : keys) {
                        if (key >= nums[i]) break;
                        count += map.getOrDefault(key, 0);
                    }
                    counts[i] = count;
                }
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            return Arrays.asList(counts);
        }
    }
}