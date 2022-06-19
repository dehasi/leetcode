package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task1268_SearchSuggestionsSystem_Test {

    private final Solution solution = new Solution();

    @Test void test1() {

        List<List<String>> expected = List.of(
            List.of("mobile", "moneypot", "monitor"),
            List.of("mobile", "moneypot", "monitor"),
            List.of("mouse", "mousepad"),
            List.of("mouse", "mousepad"),
            List.of("mouse", "mousepad")
        );

        List<List<String>> actual = solution.suggestedProducts($("mobile", "mouse", "moneypot", "monitor", "mousepad"), "mouse");

        assertThat(actual).isEqualTo(expected);
    }

    static String[] $(String... vals) {return vals;}

    class Solution {

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Trie trie = new Trie();
            for (String product : products)
                if (product.charAt(0) == searchWord.charAt(0))
                    trie.add(product);

            List<List<String>> result = new ArrayList<>(searchWord.length());
            for (int i = 0; i < searchWord.length(); ++i) {
                Queue<String> queue = new PriorityQueue<>(String::compareTo);
                queue.addAll(trie.find(searchWord, i + 1));
                List<String> res = new ArrayList<>();
                for (int j = 0; j < 3 && !queue.isEmpty(); ++j)
                    res.add(queue.poll());
                result.add(res);
            }
            return result;
        }

        class Trie {
            Trie[] nodes = new Trie[26];
            Set<String> words = new HashSet<>();

            void add(String word) {
                Trie cur = this;
                for (int i = 0; i < word.length(); ++i) {
                    char letter = word.charAt(i);
                    if (cur.nodes[letter - 'a'] == null)
                        cur.nodes[letter - 'a'] = new Trie();
                    cur = cur.nodes[letter - 'a'];
                    cur.words.add(word);
                }
            }

            Set<String> find(String word, int n) {
                Trie cur = this;
                for (int i = 0; i < n; ++i) {
                    char letter = word.charAt(i);
                    if (cur.nodes[letter - 'a'] == null) return Collections.emptySet();
                    cur = cur.nodes[letter - 'a'];
                }
                return cur.words;
            }
        }
    }
}
