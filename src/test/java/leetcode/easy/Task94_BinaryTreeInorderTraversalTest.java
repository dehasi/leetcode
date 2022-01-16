package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task94_BinaryTreeInorderTraversalTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        List<Integer> result = solution.inorderTraversal(root);
        assertThat(result).containsExactly(1, 3, 2);
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
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

    // [x] Input boundaries are clarified : val in [-100..100]
    // [_] Edge cases are covered: root can be null
    // [_] Complexity is calculated (time, memory)
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return  new ArrayList<>();

            List<Integer> left = inorderTraversal(root.left);
            left.add(root.val);
            left.addAll(inorderTraversal(root.right));

            return left;
        }
    }
}