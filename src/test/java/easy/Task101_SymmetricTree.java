package easy;

import java.util.ArrayList;
import java.util.List;
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

    // [_] Input boundaries are clarified
    // [_] Edge cases are covered
    // [_] Complexity is calculated (time, memory)
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            if (root.left == null && root.right == null) return true;
            if (root.left == null || root.right == null) return false;
//            if (root.left == null && root.right != null) return false;
//            if (root.right == null && root.left != null) return false;

            return inorderTraversal(root).equals(outorderTraversal(root));
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();

            List<Integer> result = inorderTraversal(root.left);
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));

            return result;
        }

        public List<Integer> outorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();

            List<Integer> result = inorderTraversal(root.right);
            result.add(root.val);
            result.addAll(inorderTraversal(root.left));

            return result;
        }
    }
}