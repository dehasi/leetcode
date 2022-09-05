package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task987_VerticalOrderTraversalOfBinaryTree_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        var root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertThat(solution.verticalTraversal(root))
            .containsExactly(List.of(9), List.of(3, 15), List.of(20), List.of(7));
    }

    @Test void test2() {
        var root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        assertThat(solution.verticalTraversal(root))
            .containsExactly(List.of(4), List.of(2), List.of(1, 5, 6), List.of(3), List.of(7));
    }

    @Test void test3() {
        var root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(6)),
            new TreeNode(3, new TreeNode(5), new TreeNode(7)));

        assertThat(solution.verticalTraversal(root))
            .containsExactly(List.of(4), List.of(2), List.of(1, 5, 6), List.of(3), List.of(7));
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

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Map<Integer, List<Pair>> levels = new HashMap<>();

            dfs(root, 0, 0, levels);

            return levels.keySet().stream()
                .sorted().map(key ->
                    levels.get(key).stream()
                        .sorted()
                        .map(p -> p.val)
                        .collect(Collectors.toList())
                ).collect(Collectors.toList());
        }

        private void dfs(TreeNode root, int x, int y, Map<Integer, List<Pair>> levels) {
            if (root == null) return;
            levels.putIfAbsent(x, new ArrayList<>());

            levels.get(x).add(new Pair(y, root.val));

            dfs(root.left, x - 1, y + 1, levels);
            dfs(root.right, x + 1, y + 1, levels);
        }

        class Pair implements Comparable<Pair> {
            final int y, val;

            Pair(int y, int val) {
                this.y = y; this.val = val;
            }

            @Override public int compareTo(Pair that) {
                int result = Integer.compare(this.y, that.y);
                if (result == 0) return Integer.compare(this.val, that.val);
                else return result;
            }

            @Override public boolean equals(Object o) {
                if (!(o instanceof Pair that)) return false;
                return this.compareTo(that) == 0;
            }

            @Override public int hashCode() {
                return Objects.hash(y, val);
            }
        }
    }
}