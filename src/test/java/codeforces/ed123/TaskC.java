package codeforces.ed123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskC {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat("arr").isEqualTo("");
    }


    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static public class Solution {

        private void run() {
            FastScanner scanner = new FastScanner();
            int tests = scanner.nextInt();
            while (tests-- > 0) {

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