package contest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCombinationsPhoneNumberSolution {

    private final Solution solution = new Solution();

    @Test void test1() {
        List<String> result = solution.letterCombinations("23");

        assertEquals(asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result);
    }

    @Test void test2() {
        List<String> result = solution.letterCombinations("");

        assertEquals(asList(), result);
    }

    @Test void test3() {
        List<String> result = solution.letterCombinations("2");

        assertEquals(asList("a", "b", "c"), result);
    }

    class Solution {

        final String[][] chars = new String[][] {
            {"0"},
            {}, {"a", "b", "c"}, {"d", "e", "f"},
            {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
            {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}
        };

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) return emptyList();

            int digit = digits.charAt(0) - '0';
            if (digits.length() == 1) return asList(chars[digit]);

            List<String> result = new ArrayList<>();
            List<String> prev = letterCombinations(digits.substring(1));
            for (int i = 0; i < chars[digit].length; ++i) {
                for (String s : prev) {
                    result.add(chars[digit][i] + s);
                }
            }
            return result;
        }
    }
}