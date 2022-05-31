package codeforces.ed123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskA {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.canOpen("rgbBRG")).isTrue();
        assertThat(solution.canOpen("RgbrBG")).isFalse();
        assertThat(solution.canOpen("bBrRgG")).isTrue();
        assertThat(solution.canOpen("rgRGBb")).isFalse();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static public class Solution {

        private void run() {
            FastScanner scanner = new FastScanner();
            int tests = scanner.nextInt();
            while (tests-- > 0) {
                if (canOpen(scanner.next())) System.out.println("YES");
                else System.out.println("NO");
            }
        }

        private boolean canOpen(String string) {
            boolean r = false, g = false, b = false;
            for (int i = 0; i < string.length(); ++i) {
                char ch = string.charAt(i);
                switch (ch) {
                    case 'r': {
                        r = true;
                        break;
                    }
                    case 'g': {
                        g = true;
                        break;
                    }
                    case 'b': {
                        b = true;
                        break;
                    }
                    case 'R': {
                        if (!r) return false;
                        break;
                    }
                    case 'G': {
                        if (!g) return false;
                        break;
                    }
                    case 'B': {
                        if (!b) return false;
                        break;
                    }
                }
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


/*

 * */