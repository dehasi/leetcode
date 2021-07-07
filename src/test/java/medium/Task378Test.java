package medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task378Test {

    private Solution solution = new Solution();

    @Test void test1() {
        int result = solution.kthSmallest(new int[][] {
            {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        }, 8);

        assertEquals(result, 8);
    }

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            return 1;
        }
    }
}
