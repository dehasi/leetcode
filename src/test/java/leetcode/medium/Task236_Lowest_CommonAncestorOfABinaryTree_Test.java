package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task236_Lowest_CommonAncestorOfABinaryTree_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode p, q;
        TreeNode root = new TreeNode(3,
            p = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                    new TreeNode(7),
                    new TreeNode(4))),
            q = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8))
        );

        assertThat(solution.lowestCommonAncestor(root, p, q)).isEqualTo(root);
    }

    @Test void test2() {
        TreeNode p, q;
        TreeNode root = new TreeNode(3,
            p = new TreeNode(5,
                new TreeNode(6),
                q = new TreeNode(2,
                    new TreeNode(7),
                    new TreeNode(4))),
            new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8))
        );

        assertThat(solution.lowestCommonAncestor(root, p, q)).isEqualTo(p);
    }

    @Test void test3() {
        TreeNode p, q;
        TreeNode root = new TreeNode(3,
            p = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                    new TreeNode(7),
                    q = new TreeNode(4))),
            new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8))
        );

        assertThat(solution.lowestCommonAncestor(root, p, q)).isEqualTo(p);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}

        TreeNode(int x, TreeNode left, TreeNode right) {val = x; this.left = left; this.right = right;}
    }

    // [x] Input boundaries: node count in [2..10^5]
    // [x] Edge cases: p == q? is nodes val are unique? is p and q both exists in the tree
    // [x] Complexity (time, memory): TC = O(N) MC = O(log(N)), N = nodes count
    static
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            lca(root, p, q);
            return ans;
        }

        private TreeNode ans;

        private int lca(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return 0;

            int cnt = 0;
            if (root == p || root == q) ++cnt;

            int l = lca(root.left, p, q);
            if (l == 2) return l;

            int r = lca(root.right, p, q);
            if (r == 2) return r;

            int sum = cnt + l + r;
            if (sum == 2) ans = root;

            return sum;
        }
    }
}
