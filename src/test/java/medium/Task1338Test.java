package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1338Test {

    private Solution solution = new Solution();

    @Test void test1() {
        int result = solution.minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7});

        assertEquals(result, 2);
    }

    @Test void test2() {
        int result = solution.minSetSize(new int[] {7, 7, 7, 7, 7, 7, 7});

        assertEquals(result, 1);
    }

    @Test void test3() {
        int result = solution.minSetSize(new int[] {1, 9});

        assertEquals(result, 1);
    }

    @Test void test4() {
        int result = solution.minSetSize(new int[] {1000, 1000, 3, 7});

        assertEquals(result, 1);
    }

    @Test void test5() {
        int result = solution.minSetSize(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        assertEquals(result, 5);
    }

    class Solution {

        public int minSetSize(int[] arr) {
            Map<Integer, Integer> freqs = new HashMap<>();
            for (int j : arr) {
                freqs.put(j, freqs.getOrDefault(j, 0) + 1);
            }

            List<Integer> sizes = freqs.values().stream().sorted(reverseOrder()).collect(toList());
            int setSize = 0, arrSize = 0;
            for (Integer cnt : sizes) {
                arrSize += cnt;
                ++setSize;
                if (arrSize >= arr.length / 2)
                    return setSize;
            }
            return setSize;
        }
    }
}
