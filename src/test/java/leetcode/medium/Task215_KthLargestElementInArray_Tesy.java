package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task215_KthLargestElementInArray_Tesy {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    // [x] Input boundaries: len(arr) <10^4. arr[i] in [-10^4..10^4]
    // [_] Edge cases:
    // [x] Complexity (time, memory): O(n)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;

            return quickSelect(nums, 0, nums.length - 1, k);
        }

        int quickSelect(int[] nums, int l, int r, int k) {

            int p = l;
            for (int i = l; i < r; ++i) {
                if (nums[i] <= nums[r]) {
                    int t = nums[i];
                    nums[i] = nums[p];
                    nums[p] = t;
                    ++p;
                }
            }
            int t = nums[p];
            nums[p] = nums[r];
            nums[r] = t;

            if (p == k) return nums[p];
            if (p > k) return quickSelect(nums, l, p - 1, k);
            else return quickSelect(nums, p + 1, r, k);
        }
    }
}