package leetcode.hard;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task315_CountOfSmallerNumbersAfterSelf_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.countSmaller($(5, 2, 6, 1))).containsExactly(2, 1, 1, 0);
    }

    @Test void test2() {
        assertThat(solution.countSmaller($(-1))).containsExactly(0);
    }

    @Test void test3() {
        assertThat(solution.countSmaller($(-1, -1))).containsExactly(0, 0);
    }

    private static int[] $(int... vars) {return vars;}

    // [x] Input boundaries: nums.len in [1..10^5], nums[i] in [-10^4..10^4]
    // [x] Edge cases: nums.len == 1; nums[i] == nums[i+1] forAll i;
    // [_] Complexity (time, memory):
    static
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            Integer[] counts = new Integer[n];
            counts[n - 1] = 0;

            TreeNode root = new TreeNode(nums[n - 1]);

            for (int i = n - 2; i >= 0; --i) {
                if (nums[i] == nums[i + 1]) {
                    counts[i] = counts[i + 1];
                } else {
                    counts[i] = root.findUnder(nums[i]);
                }
                root.add(nums[i]);
            }

            return Arrays.asList(counts);
        }

        class TreeNode {
            private int val;
            private int count;
            private int leftCount, rightCount;
            private TreeNode left, right;

            public TreeNode(int val) {this.val = val; count = 1;}

            void add(int val) {
                if (this.val == val) {
                    ++count; return;
                }
                if (this.val > val) {
                    if (left != null) left.add(val);
                    else left = new TreeNode(val);
                    ++leftCount;
                } else {
                    if (right != null) right.add(val);
                    else right = new TreeNode(val);
                    ++rightCount;
                }
            }

            int findUnder(int val) {
                if (this.val == val) return leftCount;
                if (this.val < val) return leftCount + count + (right != null ? right.findUnder(val) : 0);

                return left != null ? left.findUnder(val) : 0;
            }
        }
    }
}