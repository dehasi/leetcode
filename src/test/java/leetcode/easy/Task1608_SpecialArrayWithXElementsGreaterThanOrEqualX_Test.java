package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task1608_SpecialArrayWithXElementsGreaterThanOrEqualX_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.specialArray($(3, 5))).isEqualTo(2);
    }
    
    @Test void test3() {
        assertThat(solution.specialArray($(0,4,3,0,4))).isEqualTo(3);
    }

    private static int[] $(int... vals) {
        return vals;
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {

        public int specialArray(int[] nums) {
            final int n = nums.length;
            sort(nums, 0, nums.length - 1);

            for (int x = 1; x <= n; ++x) {
                int idx = findFirstGreaterOrEqual(nums, x);
                if (x == n - idx) // if idx-1, n - (-idx) = n+idx, will never satisfy condition
                    return x;
            }
            return -1;
        }

        private void sort(int[] nums, int lo, int hi) {
            int l = lo, r = hi;
            if (l >= r) return;

            int x = nums[hi];

            while (l < r) {
                while (l<r && nums[l] <= x) ++l;
                while (l<r && nums[r] >= x) --r;
                if (l < r) {
                    int t = nums[l];
                    nums[l] = nums[r];
                    nums[r] = t;
                }
            }

            //set pivot into "center"
            int t = nums[l];
            nums[l] = nums[hi];
            nums[hi] = t;

            sort(nums, lo, l-1);
            sort(nums, l + 1, hi);
        }

        private int findFirstGreaterOrEqual(int[] nums, int x) {
            int ans = nums.length, l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= x) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return ans;
        }
    }
}