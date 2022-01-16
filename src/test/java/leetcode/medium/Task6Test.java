package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {

    private Solution solution = new Solution();

    @Test void example1() {
        String result = solution.convert("PAYPALISHIRING", 3);

        assertEquals(result, "PAHNAPLSIIGYIR");
    }

    @Test void example2() {
        String result = solution.convert("PAYPALISHIRING", 4);

        assertEquals(result, "PINALSIGYAHRPI");
    }

    @Test void example3() {
        String result = solution.convert("A", 1);

        assertEquals(result, "A");
    }

    @Test void example4() {
        String result = solution.convert("AB", 1);

        assertEquals(result, "AB");
    }

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            class Pair {
                int i, j;

                Pair(int i, int j) {
                    this.i = i;
                    this.j = j;
                }

                @Override public boolean equals(Object o) {
                    Pair pair = (Pair)o;
                    return i == pair.i && j == pair.j;
                }

                @Override public int hashCode() {
                    return 31 * i + j;
                }
            }

            Map<Pair, Character> matrix = new HashMap<>();
            int row = 0, col = 0;
            boolean down = true;
            for (int k = 0; k < s.length(); ++k) {
                if (row == numRows - 1) down = false;
                else if (row == 0) down = true;

                matrix.put(new Pair(row, col), s.charAt(k));

                if (down) { ++row; } else { --row; ++col; }
            }

            int n = col;
            StringBuilder result = new StringBuilder();
            for (row = 0; row < numRows; ++row)
                for (col = 0; col <= n; ++col)
                    if (matrix.containsKey(new Pair(row, col)))
                        result.append(matrix.get(new Pair(row, col)));
            return result.toString();
        }
    }
}
