package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2080_RangeFrequencyQueries_Test {

    //    private final RangeFreqQuery solution = new RangeFreqQuery();

    @Test void test1() {
        assertThat("").isEqualTo("");
    }

    private static int[] $(int... vals) {return vals;}

    // [_] Input boundaries: arr.len in [1..10^5] arr[i] in [1..10^4]
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class RangeFreqQuery {

        public RangeFreqQuery(int[] arr) {
            int size = nextPowOfTwo(arr.length);
        }

        private int nextPowOfTwo(int n) {
            int powOfTwo = 1;
            while (powOfTwo < n) powOfTwo *= 2;
            return powOfTwo;
        }

        public int query(int left, int right, int value) {
            return -1;
        }
    }
}