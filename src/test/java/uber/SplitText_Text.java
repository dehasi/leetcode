package uber;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitText_Text {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.splitText("Hi your Uber is here!", 15)).containsExactly("Hi your (1/3)", "Uber is (2/3)", "here! (3/3)");
    }

    @Test void test2() {
        assertThat(solution.splitText("12345 12345", 5)).containsExactly("12345(1/2)", "12345(2/2)");
    }

    // [_] Input boundaries:
    // [_] Edge cases: a word is bigger than messageSize
    // [_] Complexity (time, memory):
    static class Solution {

        List<String> splitText(String text, int messageSize) {
            int chunkCount = text.length() / messageSize + text.length() % messageSize > 0 ? 1 : 0;
            String[] words = text.split("\\s+");
            List<StringBuilder> resultBuilder = new ArrayList<>();
            StringBuilder chunk = new StringBuilder(messageSize).append(words[0]);
            for (int i = 1, chunkNum = 1; i < words.length; ++i) {
                String word = words[i];
                if (canAdd(word, chunk, chunkNum, chunkCount, messageSize)) {
                    chunk.append(' ').append(word);
                } else {
                    resultBuilder.add(chunk);
                    chunk = new StringBuilder(messageSize).append(word);
                    ++chunkNum;
                }
            }
            resultBuilder.add(chunk);
            List<String> result = new ArrayList<>(resultBuilder.size());
            for (int i = 0; i < resultBuilder.size(); ++i) {
                String suffix = String.format("(%s/%s)", i + 1, resultBuilder.size());
                if (resultBuilder.get(i).length() + suffix.length() < messageSize) resultBuilder.get(i).append(' ');
                result.add(resultBuilder.get(i).append(suffix).toString());
            }
            return result;
        }

        private boolean canAdd(String word, StringBuilder chunk, int chunkNum, int chunkCount, int messageSize) {
            int space = 1;
            int end = String.valueOf(chunkNum).length() + String.valueOf(chunkCount).length() + "(/)".length();
            int resultMessageLen = chunk.length() + space + word.length() + end;
            return resultMessageLen <= messageSize;
        }
    }
}