package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task235_LCAinBinaryTreeTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode result = solution.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        assertThat(result.val).isEqualTo(6);
        assertThat(solution.path(root, 8)).containsExactly(6, 8);
        assertThat(solution.path(root, 2)).containsExactly(6, 2);
        assertThat(solution.path(root, 3)).containsExactly(6, 2, 4, 3);
    }

    @Test void test2() {

    }

    @Test void test3() {

    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 6 2 4 3
            // 6 8 7
            List<Integer> path1 = path(root, p.val);
            List<Integer> path2 = path(root, q.val);

            int n = Math.min(path1.size(), path2.size());
            for (int i = 0; i < n; ++i) {
                if (!path1.get(i).equals(path2.get(i))) {
                    return new TreeNode(path1.get(i - 1));
                }
            }
            return new TreeNode(path1.get(n - 1));
        }

        List<Integer> path(TreeNode from, int val) {
            if (from == null) return Collections.emptyList();

            if (from.val == val) return Collections.singletonList(val);

            List<Integer> tail = path(from.left, val);
            List<Integer> head = new ArrayList<>();
            head.add(from.val);
            if (!tail.isEmpty()) {
                head.addAll(tail);
                return head;
            }
            tail = path(from.right, val);
            if (!tail.isEmpty()) {
                head.addAll(tail);
                return head;
            }
            return Collections.emptyList();
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}