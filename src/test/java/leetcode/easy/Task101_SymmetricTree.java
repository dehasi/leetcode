package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task101_SymmetricTree {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        assertThat(solution.isSymmetric(root)).isTrue();
    }

    @Test void test2() {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3)));

        assertThat(solution.isSymmetric(root)).isFalse();
    }

    @Test void test3() {
        TreeNode root = new TreeNode(1,
            new TreeNode(2), new TreeNode(3));

        assertThat(solution.isSymmetric(root)).isFalse();
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

    // [x] Input boundaries are clarified: node count [1..1000] => not so much
    // [x] Edge cases are covered: root is null, one of children is null;
    // [x] Complexity is calculated (time, memory); O(n), mem - O(n) -> recursion.
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSymmetric(root.left, root.right);
        }

        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null || right == null) return left == right;
            if (left.val != right.val) return false;

            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}