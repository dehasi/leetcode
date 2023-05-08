package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;


public class Task863_AllNodesDistanceKInBinaryTree_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        var root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7), new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0), new TreeNode(8)));

        assertThat(solution.distanceK(root, new TreeNode(5), 2)).containsOnly(7, 4, 1);
        assertThat(solution.distanceK(root, new TreeNode(5), 1)).containsOnly(6, 2, 3);
        assertThat(solution.distanceK(root, new TreeNode(5), 0)).containsOnly(5);

        assertThat(solution.distanceK(root, new TreeNode(0), 1)).containsOnly(1);
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // [x] Input boundaries: node val in [0..500], all nodes are unique, k in [0..1000], target in nodes
    // [x] Edge cases: k = 0
    // [x] Complexity (time, memory): TC = O(N), MC = O(N)
    static
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if (k == 0) return singletonList(target.val);

            Map<Integer, List<Integer>> graph = new HashMap<>();
            buildGraph(root, -1, graph);

            var visited = new HashSet<Integer>();

            Queue<Integer> queue = new LinkedList<>();
            queue.add(target.val);

            int level = 0;
            while (!queue.isEmpty()) {
                if (level == k) return new ArrayList<>(queue);
                int n = queue.size();
                while (n-- > 0) {
                    int node = queue.poll();
                    if (visited.contains(node)) continue;
                    visited.add(node);
                    graph.getOrDefault(node, emptyList()).stream()
                         .filter(child -> !visited.contains(child))
                         .forEach(queue::add);
                }
                ++level;
            }
            return emptyList();
        }

        private void buildGraph(TreeNode root, int parent, Map<Integer, List<Integer>> graph) {
            if (root == null) return;

            if (parent >= 0) {
                graph.putIfAbsent(root.val, new ArrayList<>());
                graph.putIfAbsent(parent, new ArrayList<>());

                graph.get(root.val).add(parent);
                graph.get(parent).add(root.val);
            }

            buildGraph(root.left, root.val, graph);
            buildGraph(root.right, root.val, graph);
        }
    }
}
