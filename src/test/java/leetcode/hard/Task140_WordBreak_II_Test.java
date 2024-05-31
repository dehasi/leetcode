package leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class Task140_WordBreak_II_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        List<String> result = solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
        assertThat(new HashSet<>(result)).containsExactlyInAnyOrder("cats and dog", "cat sand dog");
    }

    @Test void test2() {
        List<String> result = solution.wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"));
        assertThat(new HashSet<>(result)).containsExactlyInAnyOrder("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
    }

    @Test void test3() {
        List<String> result = solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"));
        assertThat(result).isEmpty();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> result = new ArrayList<>();

            Trie trie = new Trie();
            for (var word : wordDict)
                trie.put(word);

            backtrack(0, s, trie,  new Stack<>(), result);
            return result;
        }

        private void backtrack(int i, String s, Trie trie,  Stack<Integer> spaces, List<String> result) {
            if (i >= s.length()) {
                result.add(addSpaces(s, spaces));
            }
            List<String> words = trie.findAllWords(i, s);

            for (var word : words) {
                int last_index = i + word.length();
                spaces.push(last_index);
                backtrack(last_index, s, trie, spaces, result);
                spaces.pop();
            }
        }

        private String addSpaces(String s, Stack<Integer> spaces) {
            var result = new StringBuilder();
            int start = 0;
            for (int end : spaces) {
                result.append(s, start, end).append(' ');
                start = end;
            }
            result.setLength(result.length()-1);
            return result.toString();
        }

        static class Trie {
            private static final int alphabet_size = 26;
            private final Trie[] childs = new Trie[alphabet_size];
            private String word;

            void put(String s) {
                Trie cur = this;
                for (int i = 0; i < s.length(); ++i) {
                    int idx = s.charAt(i) - 'a';
                    if (cur.childs[idx] == null)
                        cur.childs[idx] = new Trie();
                    cur = cur.childs[idx];
                }
                cur.word = s;
            }

            List<String> findAllWords(int start, String s) {
                List<String> result = new ArrayList<>();
                Trie cur = this;
                for (int i = start; i < s.length(); ++i) {
                    int idx = s.charAt(i) - 'a';
                    if (cur.childs[idx] == null) break;

                    if (cur.childs[idx].word != null)
                        result.add(cur.childs[idx].word);

                    cur = cur.childs[idx];
                }
                return result;
            }

        }
    }
}
