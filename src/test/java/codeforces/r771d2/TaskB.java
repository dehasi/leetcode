package codeforces.r771d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskB {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[] arr = {1, 6, 31, 14};
        assertThat(solution.canSort(arr)).isTrue();
    }

    @Test void test2() {
        int[] arr = {4, 2};
        assertThat(solution.canSort(arr)).isFalse();
    }

    @Test void test3() {
        int[] arr = {2, 9, 6, 7, 10};
        assertThat(solution.canSort(arr)).isFalse();
    }

    @Test void test4() {
        int[] arr = {6, 6, 6};
        assertThat(solution.canSort(arr)).isTrue();
    }

    @Test void test5() {
        int[] arr = {6, 7, 6};
        assertThat(solution.canSort(arr)).isTrue();
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
                if (canSort(arr)) System.out.println("Yes");
                else System.out.println("No");
            }
        }

        private boolean canSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (arr[j] > arr[j + 1]) {
                        if ((arr[j] + arr[j + 1]) % 2 == 0) return false;
                        int t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
            return true;
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
