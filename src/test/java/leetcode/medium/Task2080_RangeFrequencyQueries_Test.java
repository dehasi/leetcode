package leetcode.medium;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2080_RangeFrequencyQueries_Test {

    @Test void test1() {
        RangeFreqQuery solution = new RangeFreqQuery($(12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56));

        assertThat(solution.query(1, 2, 4)).isEqualTo(1);
        assertThat(solution.query(0, 11, 33)).isEqualTo(2);
    }

    @Test void test2() {
        RangeFreqQuery solution = new RangeFreqQuery($(1, 1, 1, 2, 2));

        assertThat(solution.query(0, 1, 2)).isEqualTo(0);
        assertThat(solution.query(0, 2, 1)).isEqualTo(3);
        assertThat(solution.query(3, 3, 2)).isEqualTo(1);
        assertThat(solution.query(2, 2, 1)).isEqualTo(1);
    }

    @Test void test3() {
        RangeFreqQuery solution = new RangeFreqQuery($(3, 4, 5, 3, 3, 2, 2, 2, 5, 4));

        assertThat(solution.query(1, 6, 2)).isEqualTo(2);
        assertThat(solution.query(2, 6, 3)).isEqualTo(2);
        assertThat(solution.query(5, 6, 5)).isEqualTo(0);
        assertThat(solution.query(0, 2, 3)).isEqualTo(1);
        assertThat(solution.query(5, 6, 4)).isEqualTo(0);
    }

    private static int[] $(int... vals) {return vals;}

    // [x] Input boundaries: arr.len in [1..10^5] arr[i] in [1..10^4]
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class RangeFreqQuery {
        private final HashMap<Integer, Integer>[] three;
        private final int n;

        public RangeFreqQuery(int[] arr) {
            n = arr.length;
            int size = nextPowOfTwo(n);
            three = new HashMap[4 * size];

            buildTree(arr, 0, 0, n - 1);
        }

        public int query(int left, int right, int value) {
            return query(0, 0, n - 1, left, right).getOrDefault(value, 0);
        }

        private void buildTree(int[] arr, int index, int lo, int hi) {
            if (lo == hi) {
                three[index] = new HashMap<>() {{put(arr[lo], 1);}};
                return;
            }
            int mid = lo + (hi - lo) / 2;
            buildTree(arr, left(index), lo, mid);
            buildTree(arr, right(index), mid + 1, hi);

            three[index] = merge(three[left(index)], three[right(index)]);
        }

        private int left(int index) {return 2 * index + 1;}

        private int right(int index) {return 2 * index + 2;}

        private HashMap<Integer, Integer> query(int index, int lo, int hi, int from, int to) {
            if (lo > to || hi < from) return null;

            if (from <= lo && to >= hi) return three[index];

            int mid = lo + (hi - lo) / 2;
            if (from > mid)
                return query(right(index), mid + 1, hi, from, to);
            else if (hi <= mid)
                return query(left(index), lo, mid, from, to);

            HashMap<Integer, Integer> left = query(left(index), lo, mid, from, mid);
            HashMap<Integer, Integer> right = query(right(index), mid + 1, hi, mid + 1, to);
            return merge(left, right);
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
    }
}