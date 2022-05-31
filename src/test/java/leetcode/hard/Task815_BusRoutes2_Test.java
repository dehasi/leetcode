package leetcode.hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task815_BusRoutes2_Test {

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
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            int busCount = 0;
            if (source == target) return busCount;
            Map<Integer, Set<Integer>> busStopToRoutes = new HashMap<>(routes[0].length);
            Map<Integer, Set<Integer>> routesToBusStop = new HashMap<>(routes.length);
            for (int i = 0; i < routes.length; ++i) {
                routesToBusStop.put(i, new HashSet<>());
                for (int j = 0; j < routes[i].length; ++j) {
                    int busStop = routes[i][j];
                    busStopToRoutes.putIfAbsent(busStop, new HashSet<>());
                    busStopToRoutes.get(busStop).add(i);

                    routesToBusStop.get(i).add(busStop);
                }
            }

            Set<Integer> visitedRoutes = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>(busStopToRoutes.get(source));
            while (!queue.isEmpty()) {
                ++busCount;
                int qsize = queue.size();
                while (qsize-- > 0) {
                    int route = queue.poll();
                    if (visitedRoutes.contains(route)) continue;
                    visitedRoutes.add(route);
                    if (routesToBusStop.get(route).contains(target)) return busCount;
                    for (int busStop : routesToBusStop.get(route))
                        queue.addAll(busStopToRoutes.get(busStop));
                }
            }
            return -1;
        }
    }
}

/*
1 -> 6
0:1 2 7
1:3 6 7

queue = [start]

while queue is not empty
    ++reoutesCOunte;
    get all routes = Rs.
    check if Rs contais target => return reoutesCOunte
    put bus stops to que
retuen -1;


 */