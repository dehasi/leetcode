package leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task437_PathSumIII_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        assertThat(solution.pathSum(root, 3)).isEqualTo(2);
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    static class TreeNode {
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

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        int count = 0;
        int target;
        Set<TreeNode> visited = new HashSet<>();

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            target = targetSum;
            dfs(root, target);
            return count;
        }

        void dfs(TreeNode root, int targetSum) {
            if (root == null) return;
            if (root.val == targetSum) ++count;
            dfs(root.left, targetSum - root.val);
            dfs(root.right, targetSum - root.val);

            if (root.left != null && !visited.contains(root.left)) {
                visited.add(root.left);
                dfs(root.left, target);
            }

            if (root.right != null && !visited.contains(root.right)) {
                visited.add(root.right);
                dfs(root.right, target);
            }
        }
    }
}
