package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task_1143LongestCommonSubsequence_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
        assertThat(solution.longestCommonSubsequence("abc", "abc")).isEqualTo(3);
        assertThat(solution.longestCommonSubsequence("abc", "def")).isEqualTo(0);
        assertThat(solution.longestCommonSubsequence("bsbininm", "jmjkbkjkv")).isEqualTo(1);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length(), m = text2.length();
            int[][] dp = new int[n][m];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    dp[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : 0;

            int longest = 0;
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j < m; ++j) {
                    int max = Math.max(dp[i][j - 1], dp[i - 1][j - 1]);
                    max = Math.max(max, dp[i - 1][j]);
                    dp[i][j] += max;
                    longest = Math.max(longest, dp[i][j]);
                }
            }

            return longest;
        }
    }
}