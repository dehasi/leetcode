package array;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertTrue(solution.containsDuplicate(new int[] {1, 2, 3, 1}));
    }

    @Test void test2() {
        assertFalse(solution.containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    @Test void test3() {

    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>(nums.length);
            for (int num : nums)
                if (!set.add(num)) return true;

            return false;
        }
    }
}