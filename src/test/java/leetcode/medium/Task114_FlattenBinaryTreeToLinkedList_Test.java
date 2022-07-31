package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task114_FlattenBinaryTreeToLinkedList_Test {

    private final Solution solution = new Solution();

    @Test void test_null() {
        TreeNode root = null;

        solution.flatten(root);

        assertThat(rightLeavesListFrom(root)).isEmpty();
    }

    @Test void test_oneElem() {
        TreeNode root = new TreeNode(1);

        solution.flatten(root);

        assertThat(rightLeavesListFrom(root)).containsExactly(1);
    }

    @Test void test_onlyLeftChild() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        solution.flatten(root);

        assertThat(rightLeavesListFrom(root)).containsExactly(1, 2);
    }

    @Test void test_onlyRightChild() {
        TreeNode root = new TreeNode(1, null, new TreeNode(3));

        solution.flatten(root);

        assertThat(rightLeavesListFrom(root)).containsExactly(1, 3);
    }

    @Test void test_fullTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        solution.flatten(root);

        assertThat(rightLeavesListFrom(root)).containsExactly(1, 2, 3);
    }

    private static List<Integer> rightLeavesListFrom(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        for (; root != null; root = root.right) {
            assert root.left == null;
            result.add(root.val);
        }
        return result;
    }

    public class TreeNode {
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

    // [x] Input boundaries: count(TreeNode) in [0..2k] TreeNode.val in [-100..100]
    // [x] Edge cases: null, skewed left or right
    // [x] Complexity (time, memory): O(N), N = nodes count
    static
    class Solution {
        public void flatten(TreeNode root) {
            ftn(root);
        }

        private TreeNode ftn(TreeNode root) {
            if (root == null) return null;
            if (root.left == null && root.right == null) return root;

            var rEnd = ftn(root.right);
            if(root.left == null) return rEnd;

            var lEnd = ftn(root.left);

            lEnd.right = root.right;
            root.right = root.left;
            root.left = null;

            return rEnd != null ? rEnd : lEnd;
        }
    }
}