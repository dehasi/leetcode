package medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task815_BinaryTreePruning_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = null;
        root.right = new TreeNode();
        root.right.val = 0;
        root.right.left = new TreeNode();
        root.right.left.val = 0;
        root.right.right = new TreeNode();
        root.right.right.val = 1;

        TreeNode result = solution.pruneTree(root);

        assertThat(result.left).isNull();
        assertThat(result.right.val).isEqualTo(0);
        assertThat(result.right.right.val).isEqualTo(1);
        assertThat(result.right.left).isNull();
    }

    @Test void test2() {
        TreeNode root = new TreeNode();
        root.val = 0;
        root.left = new TreeNode();
        root.left.val = 0;
        root.right = new TreeNode();
        root.right.val = 0;

        TreeNode result = solution.pruneTree(root);

        assertThat(result).isNull();
    }

    @Test void test3() {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override public String toString() {
            return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }

    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) return null;

            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);

            return root.val == 0
                && root.left == null
                && root.right == null ? null : root;
        }
    }
}