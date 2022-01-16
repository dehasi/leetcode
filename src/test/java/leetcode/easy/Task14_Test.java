package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task14_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        String result = solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"});
        assertThat(result).isEqualTo("fl");
    }

    @Test void test2() {
        String result = solution.longestCommonPrefix(new String[] {"dog", "racecar", "car"});
        assertThat(result).isEqualTo("");
    }

    @Test void test3() {
        String result = solution.longestCommonPrefix(new String[] {"dog", "", "car"});
        assertThat(result).isEqualTo("");
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) { // O(n*N), n - strs[i].len, N - strs.len
            if (strs.length == 1) return strs[0];

            int till = strs[0].length();
            for (int i = 1; i < strs.length; ++i) { // O(N)
                till = prefix(till, strs[i - 1], strs[i]); // O(n)
            }
            return strs[0].substring(0, till);
        }

        private int prefix(int n, String str1, String str2) {
            int result = 0;
            n = Math.min(n, str2.length());
            for (int i = 0; i < n; ++i) { // O(n)
                if (str1.charAt(i) == str2.charAt(i)) ++result;
                else break;
            }
            return result;
        }
    }
}