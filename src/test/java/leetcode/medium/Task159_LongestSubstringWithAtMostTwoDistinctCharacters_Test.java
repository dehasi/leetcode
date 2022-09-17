package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task159_LongestSubstringWithAtMostTwoDistinctCharacters_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("eceba")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("ccaabbb")).isEqualTo(5);
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("CCAABBB")).isEqualTo(5);
    }

    // [x] Input boundaries: s.len in [1..10^5], s[i] in [a-zA-Z].
    // [x] Edge cases: All the same, 1 symbol.
    // [x] Complexity (time, memory): TC = O(n), MC = O(len(alphabet)) ~ const
    static
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int[] charCount = new int[128];

            int result = 0, size = 0;
            for (int l = 0, r = 0; r < s.length(); ) {
                int right = s.charAt(r);
                if (charCount[right] > 0 || size < 2) {
                    if (charCount[right] == 0) ++size;
                    ++charCount[right];
                    result = Math.max(result, r - l + 1);
                    ++r;
                } else {
                    int left = s.charAt(l);
                    if (charCount[left] > 0) {
                        --charCount[left];
                        if (charCount[left] == 0) --size;
                    }
                    ++l;
                }
            }
            return result;
        }
    }
}