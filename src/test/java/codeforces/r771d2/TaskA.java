package codeforces.r771d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskA {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[] arr = {1};
        solution.transform(arr);
        assertThat(arr).isEqualTo(new int[] {1});
    }

    @Test void test2() {
        int[] arr = {2, 1, 3};
        solution.transform(arr);
        assertThat(arr).isEqualTo(new int[] {1, 2, 3});
    }

    @Test void test3() {
        int[] arr = {1, 4, 2, 3};
        solution.transform(arr);
        assertThat(arr).isEqualTo(new int[] {1, 2, 4, 3});
    }

    @Test void test4() {
        int[] arr = {1, 2, 3, 4, 5};
        solution.transform(arr);
        assertThat(arr).isEqualTo(new int[] {1, 2, 3, 4, 5});
    }

    @Test void test5() {
        int[] arr = {2, 1};
        solution.transform(arr);
        assertThat(arr).isEqualTo(new int[] {1, 2});
    }

    @Test void test6() {
        int[] arr = {1, 5, 4, 2, 3};
        solution.transform(arr);
        assertThat(arr).isEqualTo(new int[] {1, 2, 4, 5, 3});
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
                transform(arr);
                StringBuilder sb = new StringBuilder();
                sb.append(arr[0]);
                for (int i = 1; i < n; ++i)
                    sb.append(' ').append(arr[i]);
                System.out.println(sb);
            }
        }

        private void transform(int[] arr) {
            if (arr.length < 2) return;
            int search = -1, start = -1, end = -1;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] != i + 1) {
                    search = i + 1;
                    start = i;
                    break;
                }
            }
            if (search == -1) return;
            for (int i = start + 1; i < arr.length; ++i) {
                if (arr[i] == search) {
                    end = i;
                    break;
                }
            }

            while (start < end) {
                int t = arr[start];
                arr[start] = arr[end];
                arr[end] = t;
                ++start; --end;
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
1 -> 1
2 1 -> 1 2
2 1 3 -> 1 2 3
3 2 1 -> 1 2 3

1 4 2 3 -> 1 2 4 3
1 4 3 2 -> 1 2 3 4
1 3 4 2 -> 1 2 3 4
*****

0 1 2 3
1 4 2 3 -> 1 2 4 3
i = 1
end = 2 => end/2 = 1;
end - i = 2 -1 = 1
* */