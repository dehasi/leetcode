package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1457_PseudoPalindromicPathsInBinaryTree_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode root = new TreeNode(
            2,
            new TreeNode(3, new TreeNode(3), new TreeNode(1)),
            new TreeNode(1, null, new TreeNode(1)));
        assertThat(solution.pseudoPalindromicPaths(root)).isEqualTo(2);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // [x] Input boundaries:  node count in [1..10^5], node val in [1..9]
    // [_] Edge cases:
    // [x] Complexity (time, memory): TC = O(n), MC = O(1)
    static
    class Solution {
        public int pseudoPalindromicPaths(TreeNode root) {
            return pathCount(root, new int[10]);
        }

        private int pathCount(TreeNode root, int[] frequencies) {
            if (root == null) return 0;
            ++frequencies[root.val];

            int result = 0;
            if (root.left == null && root.right == null)
                result = isPalindrome(frequencies) ? 1 : 0;
            else
                result = pathCount(root.left, frequencies) + pathCount(root.right, frequencies);

            --frequencies[root.val]; // back tracking
            return result;
        }

        private boolean isPalindrome(int[] frequencies) {
            int oddCount = 0;
            for (int val : frequencies)
                if (val % 2 == 1)
                    ++oddCount;
            return oddCount <= 1;
        }
    }
}