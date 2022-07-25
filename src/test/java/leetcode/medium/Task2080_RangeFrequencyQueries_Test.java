package leetcode.medium;

import java.util.HashMap;
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
        private final int size;
        private final HashMap<Integer, Integer>[] three;

        public RangeFreqQuery(int[] arr) {
            size = nextPowOfTwo(arr.length);
            three = new HashMap[size];

            buildTree(arr, 0, 0, arr.length - 1);
        }

        private void buildTree(int[] arr, int index, int lo, int hi) {
            if (lo == hi) {
                three[index] = new HashMap<>() {{put(arr[lo], 1);}};
                return;
            }
            int mid = lo + (hi - lo) / 2;
            buildTree(arr, 2 * index + 1, lo, mid);
            buildTree(arr, 2 * index + 2, mid + 1, hi);

            // merge three[2 * index + 1] and three[2 * index + 2]
            three[index] = new HashMap<>(three[2 * index + 1]);
            three[2 * index + 1].forEach((k, v) -> three[index].merge(k, v, Integer::sum));
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