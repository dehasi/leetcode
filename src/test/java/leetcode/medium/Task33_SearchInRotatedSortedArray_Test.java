package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task33_SearchInRotatedSortedArray_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2)).isEqualTo(6);
    }

    @Test void tes2() {
        assertThat(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0)).isEqualTo(4);
    }

    @Test void test3() {
        assertThat(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 4)).isEqualTo(0);
    }

    @Test void test4() {
        assertThat(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 10)).isEqualTo(-1);
    }

    @Test void test5() {
        assertThat(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2)).isEqualTo(6);
    }

    @Test void test6() {
        assertThat(solution.search(new int[] {1}, 0)).isEqualTo(-1);
    }

    @Test void test7() {
        assertThat(solution.search(new int[] {1,3}, 0)).isEqualTo(-1);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            if (nums.length == 1) return (nums[0] == target) ? 0 : -1;
            int l = 0, r = nums.length;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[l] < nums[mid]) l = mid;
                else r = mid;
            }

            int start = r+1;
            l = 0; r = nums.length;
            if (nums[start] <= target && target <= nums[r - 1])
                l = start;
            else r = start;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) l = mid + 1;
                else r = mid;
            }

            return -1;
        }
    }
}

/*

[4, 5, 6, 7, 0, 1, 2]
 l    < m           _ r
 l         > m           _ r

[abcc]
*/