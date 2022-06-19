package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;

public class Task745_PrefixAndSuffixSearch_Test {

    @Test void test1() {
        WordFilter wordFilter = new WordFilter($("apple", "pear"));
        assertThat(wordFilter.f("a", "e")).isEqualTo(0);
        assertThat(wordFilter.f("ap", "le")).isEqualTo(0);
        assertThat(wordFilter.f("app", "ple")).isEqualTo(0);
        assertThat(wordFilter.f("appl", "pple")).isEqualTo(0);
        assertThat(wordFilter.f("apple", "apple")).isEqualTo(0);

        assertThat(wordFilter.f("a", "e")).isEqualTo(0);
        assertThat(wordFilter.f("ap", "le")).isEqualTo(0);
        assertThat(wordFilter.f("app", "ple")).isEqualTo(0);
        assertThat(wordFilter.f("appl", "pple")).isEqualTo(0);
        assertThat(wordFilter.f("apple", "apple")).isEqualTo(0);
    }

    static String[] $(String... ags) {return ags;}

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class WordFilter {
        private final Trie pref = new Trie(), suff = new Trie();
        private final HashMap<String, HashMap<String, Integer>> cache = new HashMap<>();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; ++i) {
                char[] word = words[i].toCharArray();
                pref.add(word, i);
                suff.add(reversed(word), i);
            }
        }

        char[] reversed(char[] word) {
            int l = 0, r = word.length - 1;
            while (l < r) {
                char t = word[r];
                word[r] = word[l];
                word[l] = t;
                ++l; --r;
            }
            return word;
        }

        public int f(String prefix, String suffix) {
            cache.computeIfAbsent(prefix, p -> new HashMap<>());
            cache.get(prefix).computeIfAbsent(suffix, s -> find(prefix, suffix));

            return cache.get(prefix).get(suffix);
        }

        private int find(String prefix, String suffix) {
            Set<Integer> pfx = pref.find(prefix.toCharArray());
            if (pfx.isEmpty()) return -1;

            Set<Integer> sfx = suff.find(reversed(suffix.toCharArray()));
            if (sfx.isEmpty()) return -1;

            int result = -1;
            for (int w : pfx)
                if (w > result && sfx.contains(w))
                    result = w;

            return result;
        }

        static class Trie {
            private final Trie[] nodes = new Trie[26];
            private final HashSet<Integer> weights = new HashSet<>();

            void add(char[] word, int weight) {
                Trie cur = this;
                for (char l : word) {
                    if (cur.nodes[l - 'a'] == null)
                        cur.nodes[l - 'a'] = new Trie();
                    cur = cur.nodes[l - 'a'];
                    cur.weights.add(weight);
                }
            }

            Set<Integer> find(char[] word) {
                Trie cur = this;
                for (char l : word) {
                    if (cur.nodes[l - 'a'] == null) return emptySet();
                    cur = cur.nodes[l - 'a'];
                }
                return cur.weights;
            }
        }
    }
}