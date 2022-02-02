package leetcode.medium;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task211_Design_AddAndSearchWordsDataStructure_Test {

    @Test void test1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        assertThat(wordDictionary.search(".")).isTrue();
        assertThat(wordDictionary.search("a")).isTrue();
        assertThat(wordDictionary.search("aa")).isFalse();
        assertThat(wordDictionary.search(".")).isTrue();
        assertThat(wordDictionary.search("a.")).isFalse();
        assertThat(wordDictionary.search(".a")).isFalse();
    }

    @Test void test2() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertThat(wordDictionary.search("pad")).isFalse();
        assertThat(wordDictionary.search("bad")).isTrue();
        assertThat(wordDictionary.search(".ad")).isTrue();
        assertThat(wordDictionary.search("b..")).isTrue();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class WordDictionary {

        HashMap<Character, WordDictionary> childs;

        public WordDictionary() {
            childs = new HashMap<>();
        }

        public void addWord(String word) {
            if (word == null || word.isEmpty()) return;
            addW("^" + word + "$");
        }

        private void addW(String word) {
            if (word == null || word.isEmpty()) return;
            char ch = word.charAt(0);
            childs.putIfAbsent(ch, new WordDictionary());
            childs.get(ch).addW(word.substring(1));
        }

        public boolean search(String word) {
            if (word == null || word.isEmpty()) return false;
            return searchW("^" + word + "$");
        }

        private boolean searchW(String word) {
            if (word == null || word.isEmpty()) return false;
            char ch = word.charAt(0);
            if (word.length() == 1) return ch == '$' && childs.containsKey('$');
            if (ch != '.')
                return childs.containsKey(ch) && childs.get(ch).searchW(word.substring(1));
            else {
                for (WordDictionary wd : childs.values())
                    if (wd.searchW(word.substring(1)))
                        return true;
                return false;
            }
        }
    }
}