package codeforces.ed123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskB {

    private final Solution solution = new Solution();

    @Test void test1() {
        int n = 4;
        ArrayList<String> result = new ArrayList<>();

        solution.antiFib(n, 0, new int[n], new HashSet<>(n), result);

        assertThat(result).containsExactlyInAnyOrder(
            "4 1 3 2",
            "1 2 4 3",
            "3 4 1 2",
            "2 4 1 3");
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
            }
        }

        void antiFib(int n, int index, int[] cur, Set<Integer> used, List<String> result) {
            if (index == n) {
                StringBuilder sb = new StringBuilder(n);
                for (int c : cur) sb.append(c).append(' ');
                sb.setLength(sb.length() - 1);
                result.add(sb.toString());
            }
            for (int i = 1; i <= n; ++i) {
                if (used.contains(i)) continue;
                if (index < 2) {
                    used.add(i);
                    cur[index] = i;
                    antiFib(n, index + 1, cur, used, result);
                    used.remove(i);
                } else {
                    int sum = cur[index - 1] + cur[index - 2];
                    if (sum != i) {
                        cur[index] = i;
                        used.add(i);
                        antiFib(n, index + 1, cur, used, result);
                        used.remove(i);
                    }
                }
            }
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


/*

 * */