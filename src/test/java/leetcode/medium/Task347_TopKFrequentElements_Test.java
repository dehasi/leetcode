package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;


public class Task347_TopKFrequentElements_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.topKFrequent($(1, 1, 1, 2, 2, 3), 2)).containsExactlyInAnyOrder(1, 2);
        assertThat(solution.topKFrequent($(1, 3), 2)).containsExactlyInAnyOrder(1, 3);
        assertThat(solution.topKFrequent($(1), 1)).containsExactlyInAnyOrder(1);
    }

    private static int[] $(int... vals) {
        return vals;
    }

    // [x] Input boundaries: len(nums) in [1..10^5], nums[i] in [-10^4..10^4], k in [1..uniq-elems]
    // [x] Edge cases: k = len(nums), nums = [1, 2] k = 2
    // [_] Complexity (time, memory):
    static
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int[] result = new int[k];

            var map = new HashMap<Integer, Integer>(k);
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            var queue = new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            map.entrySet().forEach(queue::add);

            for (int i = 0; i < k; ++i) {
                result[i] = queue.poll().getKey();
            }

            return result;
        }
    }
}