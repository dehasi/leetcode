package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task740_DeleteAndEarn_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.deleteAndEarn(nums(2, 3, 4))).isEqualTo(6);
    }

    static int[] nums(int... nums) {return nums;}

    // [_] Input boundaries: ums.length in [1..20_000] nums[i] in [1..10_000]
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int deleteAndEarn(int[] nums) {
            Map<Integer, Integer> valuesCount = new HashMap<>();
            for (int num : nums)
                valuesCount.put(num, valuesCount.getOrDefault(num, 0) + 1);

            List<Integer> values = new ArrayList<>(valuesCount.keySet());
            Collections.sort(values);
            Set<Integer> removed = new HashSet<>();
            return calcMax(values, removed, valuesCount);
        }

        private int calcMax(
            List<Integer> values, Set<Integer> removed, Map<Integer, Integer> valuesCount) {
            if (values.size() == removed.size()) return 0;

            int max = 0;
            for (int i = 0; i < values.size(); ++i) {
                int value = values.get(i);
                if (removed.contains(value)) continue;
                removed.add(value);
                boolean plus = removed.add(value + 1);
                boolean minus = removed.add(value - 1);
                max = Math.max(max, valuesCount.get(value) * value + calcMax(values, removed, valuesCount));
                if (plus) removed.remove(value + 1);
                if (minus) removed.remove(value - 1);
                removed.add(value);
            }
            return max;
        }
    }
}
/*
3, 4, 2

 */