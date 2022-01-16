package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1026_MaximDifferenceBetweenNodeAndAncestor_Task {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode root = new TreeNode(8,
            new TreeNode(3,
                new TreeNode(1),
                new TreeNode(6,
                    new TreeNode(4),
                    new TreeNode(7))),
            new TreeNode(10,
                null,
                new TreeNode(14,
                    new TreeNode(13),
                    null))
        );
        assertThat(solution.maxAncestorDiff(root)).isEqualTo(7);
    }

    @Test void test2() {
        TreeNode root = new TreeNode(1,
            null,
            new TreeNode(2,
                null,
                new TreeNode(0,
                    new TreeNode(3),
                    null))
        );
        assertThat(solution.maxAncestorDiff(root)).isEqualTo(3);
    }

    @Test void test3() {
        TreeNode root = new TreeNode(1,
            null,
            new TreeNode(2)
        );
        assertThat(solution.maxAncestorDiff(root)).isEqualTo(1);
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

    // [x] Input boundaries: node count in [2..5000], 5*10^3 = 5*2^10 ~ 2^13, tree height = log2(2^13) ~ 13; node.val in [0..5000]
    // [x] Edge cases: one child in null
    // [x] Complexity (time, memory): O(root count), (height(root))
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            // max_diff, min, max
            int[] res1 = calculate(root);
            return res1[0];
        }

        private int[] calculate(TreeNode root) {
            if (root == null) return null;
            int[] result = {Integer.MIN_VALUE, root.val, root.val};

            int[] resL = calculate(root.left);
            if (resL != null) {
                result[0] = max(result[0], resL[0], Math.abs(root.val - resL[1]), Math.abs(root.val - resL[2]));
                result[1] = Math.min(root.val, resL[1]);
                result[2] = Math.max(root.val, resL[2]);
            }

            int[] resR = calculate(root.right);
            if (resR != null) {
                result[0] = max(result[0], resR[0], Math.abs(root.val - resR[1]), Math.abs(root.val - resR[2]));

                result[1] = Math.min(result[1], resR[1]);
                result[2] = Math.max(result[2], resR[2]);
            }
            return result;
        }

        private int max(int a, int a1, int b, int c) {
            return Math.max(Math.max(a, a1), Math.max(b, c));
        }
    }
}