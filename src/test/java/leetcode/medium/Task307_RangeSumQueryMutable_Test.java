package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task307_RangeSumQueryMutable_Test {

    @Test void test1() {
        NumArray numArray = new NumArray($(1, 3, 5));

        assertThat(numArray.sumRange(0, 2)).isEqualTo(9);
        numArray.update(1, 2);
        assertThat(numArray.sumRange(0, 2)).isEqualTo(8);
    }

    private static int[] $(int... vals) {return vals;}

    // [_] Input boundaries: nums_len in [1..3*10^4], nums_i in [-100..100] => max sum forall_i 3*10^6 < INT_MAX_VAL
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class NumArray {
        private final int n;
        private final int[] tree;

        public NumArray(int[] nums) {
            n = nums.length;
            tree = new int[4 * n];
            buildTree(0, 0, n - 1, nums);
        }

        void buildTree(int index, int lo, int hi, int[] nums) {
            if (lo == hi) {
                tree[index] = nums[lo];
                return;
            }
            int mid = lo + (hi - lo) / 2;
            buildTree(left(index), lo, mid, nums);
            buildTree(right(index), mid + 1, hi, nums);

            tree[index] = merge(tree[left(index)], tree[right(index)]);
        }

        int query(int index, int lo, int hi, int from, int to) {
            if (lo > to || hi < from) return 0;
            if (from <= lo && hi <= to) return tree[index];

            int mid = lo + (hi - lo) / 2;
            if (from > mid)
                return query(index, mid + 1, hi, from, to);
            else if (to <= mid)
                return query(index, lo, mid, from, to);

            int left = query(left(index), lo, mid, from, mid);
            int right = query(right(index), mid + 1, hi, mid + 1, to);
            return merge(left, right);
        }

        void update(int index, int lo, int hi, int i, int val) {
            if (hi > i && lo < i) return;
            if (lo == hi && lo == i) {
                tree[index] = val;
                return;
            }

            int mid = lo + (hi - lo) / 2;
            update(left(index), lo, mid, i, val);
            update(right(index), mid + 1, hi, i, val);

            tree[index] = merge(tree[left(index)], tree[right(index)]);
        }

        private int merge(int left, int right) {return left + right;}

        static int left(int index) {return 2 * index + 1;}

        static int right(int index) {return 2 * index + 2;}

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        public int sumRange(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }
    }
}