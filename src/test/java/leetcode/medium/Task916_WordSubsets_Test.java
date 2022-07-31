package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task916_WordSubsets_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.wordSubsets(
            $("amazon", "apple", "facebook", "google", "leetcode"),
            $("e", "o"))).containsExactlyInAnyOrder("facebook", "google", "leetcode");
    }

    @Test void test2() {
        assertThat(solution.wordSubsets(
            $("amazon", "apple", "facebook", "google", "leetcode"),
            $("l", "e"))).containsExactlyInAnyOrder("apple", "google", "leetcode");
    }

    private static String[] $(String... vals) {return vals;}

    // [x] Input boundaries: words[1-2].length in [1..10^4], words[1-2][i] in [a-z] len in [1..10]; word1 is unique
    // [x] Edge cases: word1[i].len > word2[i].len
    // [_] Complexity (time, memory):
    static
    class Solution {
        public List<String> wordSubsets(String[] words1, String[] words2) {
            int[] reduced = new int[26];

            for (String word : words2) {
                int[] charsCount = toCharsMap(word);
                for (int i = 0; i < reduced.length; ++i)
                    reduced[i] = Math.max(reduced[i], charsCount[i]);
            }

            List<String> result = new ArrayList<>(words1.length);
            for (String word : words1) {
                int[] charsCount = toCharsMap(word);
                boolean universal = true;
                for (int i = 0; i < reduced.length; ++i) {
                    if (reduced[i] > charsCount[i]) {
                        universal = false;
                        break;
                    }
                }
                if (universal) result.add(word);
            }
            return result;
        }

        private int[] toCharsMap(String word) {
            int[] result = new int[26];
            for (int i = 0; i < word.length(); ++i)
                ++result[word.charAt(i) - 'a'];
            return result;
        }
    }
}