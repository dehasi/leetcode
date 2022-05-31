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
        assertThat(solution.search(new int[] {1, 3}, 0)).isEqualTo(-1);
    }

    @Test void test8() {
        assertThat(solution.search(new int[] {1, 3}, 1)).isEqualTo(0);
    }

    @Test void test9() {
        assertThat(solution.search(new int[] {5, 1, 3}, 1)).isEqualTo(1);
    }

    @Test void test10() {
        assertThat(solution.search(new int[] {3, 1}, 1)).isEqualTo(1);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            if (nums.length == 1) return (nums[0] == target) ? 0 : -1;
            int l = 0, r = nums.length - 1, min = 0;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mid != 0 && nums[mid - 1] > nums[mid]) {
                    min = mid; break;
                }
                if (nums[0] < nums[mid]) {
                    min = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (min == -1 || target < nums[min]) return -1;

            if (min != 0 && nums[0] <= target && target <= nums[min - 1]) {
                l = 0; r = min - 1;
            } else {
                l = min; r = nums.length - 1;
            }

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) l = mid + 1;
                else r = mid - 1;
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