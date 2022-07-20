package leetcode.medium;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task792_NumberOfMatchingSubsequences_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.numMatchingSubseq("abcde", $("a", "bb", "acd", "ace"))).isEqualTo(3);
    }

    @Test void test2() {
        assertThat(solution.numMatchingSubseq("dsahjpjauf", $("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"))).isEqualTo(2);
    }

    @Test void test3() {
        assertThat(solution.numMatchingSubseq("abcdezzz", $("a", "bb", "acd", "ace"))).isEqualTo(3);
    }

    private static String[] $(String... args) {return args;}

    // [_] Input boundaries: s in [1..50_000]; words in [1..5_000] words[i].len in [1..50]
    // [_] Edge cases: words[i] == words[i + j]: counts as two matching
    // [_] Complexity (time, memory): TC = O(words.len * words[i].len * log(s)); MC = O(s.len)
    static
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            ArrayList<Integer>[] charIndexes = new ArrayList[26];
            for (int i = 0; i < 26; ++i)
                charIndexes[i] = new ArrayList<>(50); // M = O(s.len) we keep all indexes
            for (int i = 0; i < s.length(); ++i) // O(s.len)
                charIndexes[s.charAt(i) - 'a'].add(i);

            int result = 0;
            for (int i = 0; i < words.length; ++i) // O(words.len); total: O(words.len * word.len * log(s))
                if (subseq(words[i], charIndexes)) //O(word.len * log(s))
                    ++result;

            return result; // O(s.len) + O(words.len * words[i].len * log(s))
            // lets calculate numbers
            // 50*10^3 + 5*10^3 * 50 * log(50*10^3)
            // 50*10^3 + 25*10^4  * log(50) * log(10^3)
            // 50*10^3 + 25*10^4  * log(50) * log(2^10) | 2^10 ~ 10^3
            // 50*10^3 + 25*10^4  * log(50) * 10        | 50 ~ 2^6 (~64) => log(50) <= log(64) <= log(2^6) <= 6
            // 50*10^3 + 25*10^4  * 6 * 10              |
            // 50*10^3 + 150*10^5 =  5*10^4 + 15*10^6 ~ 15*10^6
            // O(s.len) << O(words.len * words[i].len * log(s))
            // O(words.len * words[i].len * log(s)) | words.len * words[i].len = sum_i(words[i].len)
            // O(sum_i(words[i].len) * log(s)) | words.len * words[i].len = sum_i(words[i].len)
        }

        private boolean subseq(String word, ArrayList<Integer>[] charIndexes) { //total: O(word.len * log(s))
            for (int i = 0, startIndex = -1; i < word.length(); ++i) { // O(word.len)
                int chi = word.charAt(i) - 'a';
                int firstIndex = firstIndex(startIndex, charIndexes[chi]); // O(log(S))
                if (firstIndex == -1) return false;
                else startIndex = firstIndex;
            }
            return true;
        }

        private int firstIndex(int after, ArrayList<Integer> indexes) {
            int l = 0, r = indexes.size(), ans = -1;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (indexes.get(mid) > after) {
                    ans = indexes.get(mid);
                    r = mid;
                } else l = mid + 1;
            }

            return ans;
        }
    }
}