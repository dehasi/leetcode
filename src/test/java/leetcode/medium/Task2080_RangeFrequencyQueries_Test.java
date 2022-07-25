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

            three[index] = merge(three[2 * index + 1], three[2 * index + 1]);
        }

        HashMap<Integer, Integer> query(int index, int lo, int hi, int from, int to) {
            if (lo > to || hi < from) return null;
            return null;
        }

        private HashMap<Integer, Integer> merge(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
            if (map1 == null) return map2;
            if (map2 == null) return map1;

            var result = new HashMap<>(map1);
            map2.forEach((k, v) -> result.merge(k, v, Integer::sum));
            return result;
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