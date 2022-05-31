package codeforces.r771d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskC {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[] arr = {1, 2, 3};
        assertThat(solution.components(arr)).isEqualTo(3);
    }

    @Test void test2() {
        int[] arr = {2, 1, 4, 3, 5};
        assertThat(solution.components(arr)).isEqualTo(3);
    }

    @Test void test3() {
        int[] arr = {6, 1, 4, 2, 5, 3};
        assertThat(solution.components(arr)).isEqualTo(1);
    }

    @Test void test4() {
        int[] arr = {1};
        assertThat(solution.components(arr)).isEqualTo(1);
    }

    @Test void test5() {
        int[] arr = {3, 2, 1, 6, 5, 4};
        assertThat(solution.components(arr)).isEqualTo(2);
    }

    @Test void test6() {
        int[] arr = {3, 1, 5, 2, 4};
        assertThat(solution.components(arr)).isEqualTo(1);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static public class Solution {

        private void run() {
            FastScanner scanner = new FastScanner();
            int tests = scanner.nextInt();
            while (tests-- > 0) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; ++i)
                    arr[i] = scanner.nextInt();
                System.out.println(components(arr));
            }
        }

        int components(int[] p) {
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            int n = p.length;
            for (int i = 0; i < n; ++i)
                graph.put(p[i], new ArrayList<>(n));
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (p[i] > p[j]) {
                        graph.get(p[i]).add(p[j]);
                        graph.get(p[j]).add(p[i]);
                    }
                }
            }
            boolean[] visited = new boolean[n + 1];
            int components = 0;
            for (int i = 0; i < n; ++i) {
                if (!visited[p[i]]) {
                    dfs(p[i], graph, visited);
                    ++components;
                }
            }

            return components;
        }

        private void dfs(int vertex, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited) {
            visited[vertex] = true;
            ArrayList<Integer> v = graph.get(vertex);
            for (int i = 0; i < v.size(); ++i)
                if (!visited[v.get(i)])
                    dfs(v.get(i), graph, visited);
        }

        ///
        public static void main(String[] args) {
            new Solution().run();
        }

        // ----- Input scanner
        static class FastScanner {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer("");

            String next() {
                while (!st.hasMoreTokens())
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {}
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }

            long nextLong() {
                return Long.parseLong(next());
            }
        }
    }
}
