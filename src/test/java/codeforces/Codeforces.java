package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Codeforces {

    private final Solution solution = new Solution();

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static class Solution {

        public static void main(String[] args) {
            new Solution().run();
        }

        private void run() {
            FastScanner scanner = new FastScanner();
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                String s = scanner.next();

                HashSet<String> set = new HashSet<>(k);
                iterate(s, k, set);
                System.out.println(set.size());
            }
        }

        private void iterate(String s, int k, HashSet<String> set) {
            if (k <= 0) {
                set.add(s);
                return;
            }
            String rev = rev(s);
            if (rev.equals(s)) {
                set.add(rev);
                return;
            }
            iterate(s + rev, k - 1, set);
            iterate(rev + s, k - 1, set);
        }

        private String rev(String s) {
            return new StringBuilder().append(s).reverse().toString();
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