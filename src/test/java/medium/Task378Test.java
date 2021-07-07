package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task378Test {

    private Solution solution = new Solution();

    @Test void test1() {
        int result = solution.kthSmallest(new int[][] {
            {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        }, 8);

        assertEquals(result, 13);
    }

    @Test void test2() {
        int result = solution.kthSmallest(new int[][] {
            {-5}}, 1);

        assertEquals(result, -5);
    }

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {

            k -= 1;
            List<Integer> ans = new ArrayList<>(matrix.length * matrix.length);
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    ans.add(matrix[i][j]);

            Collections.sort(ans);
            return ans.get(k);
        }
    }
}
