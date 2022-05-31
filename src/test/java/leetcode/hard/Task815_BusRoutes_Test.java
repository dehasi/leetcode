package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task815_BusRoutes_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        assertThat(solution.numBusesToDestination(routes, 1, 6)).isEqualTo(2);
    }

    @Test void test2() {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        assertThat(solution.numBusesToDestination(routes, 1, 2)).isEqualTo(1);
    }

    @Test void test3() {
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        assertThat(solution.numBusesToDestination(routes, 15, 12)).isEqualTo(-1);
    }

    // [_] Input boundaries:
    // [_] Edge cases: source = target, bu stop without route
    // [_] Complexity (time, memory): mlogm*n n*n*n O(V+E)
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) return 0;
            int n = routes.length;
            HashMap<Integer, List<Integer>> graph = new HashMap<>(n);
            for (int i = 0; i < n; ++i) {
                Arrays.sort(routes[i]);
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < n; ++i)
                for (int j = i + 1; j < n; ++j)
                    if (intersect(routes[i], routes[j])) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }

            Queue<Integer> queue = new ArrayDeque<>();
            HashSet<Integer> visited = new HashSet<>(n);
            HashSet<Integer> targets = new HashSet<>(n);
            for (int i = 0; i < n; ++i) {
                if (Arrays.binarySearch(routes[i], source) >= 0) {
                    queue.add(i); visited.add(i);
                }
                if (Arrays.binarySearch(routes[i], target) >= 0) targets.add(i);
            }
            int busCount = 0;
            while (!queue.isEmpty()) {
                ++busCount;
                int qSize = queue.size();
                while (qSize-- > 0) {
                    Integer candidate = queue.poll();
                    if (targets.contains(candidate)) return busCount;

                    for (int route : graph.get(candidate))
                        if (visited.add(route)) queue.add(route);
                }
            }
            return -1;
        }

        private static boolean intersect(int[] a, int[] b) {
            int i = 0, j = 0;
            while (i < a.length && j < b.length) {
                if (a[i] == b[j]) return true;
                if (a[i] < b[j]) ++i;
                else ++j;
            }
            return false;
        }
    }
}