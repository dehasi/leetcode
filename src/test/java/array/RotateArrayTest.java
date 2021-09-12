package array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateArrayTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};

        solution.rotate(array, 3);

        assertThat(array).containsExactly(5, 6, 7, 1, 2, 3, 4);
    }

    @Test void test2() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6};

        solution.rotate(array, 2);

        assertThat(array).containsExactly(5, 6, 1, 2, 3, 4);
    }

    @Test void test3() {

    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            if (n == 1) return;
            k = k % n;

            for (int i = 0; i < n / 2; ++i) {
                int t = nums[i];
                nums[i] = nums[n - 1 - i];
                nums[n - 1 - i] = t;
            }

            for (int i = 0; i < k / 2; ++i) {
                int t = nums[i];
                nums[i] = nums[k - 1 - i];
                nums[k - 1 - i] = t;
            }

            for (int i = k; i < k + (n - k + 1) / 2; ++i) {
                int t = nums[i];
                nums[i] = nums[n - 1 - i - k];
                nums[n - 1 - i - k] = t;
            }
        }
    }
}