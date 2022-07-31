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

    @Test void test2() {
        NumArray numArray = new NumArray($(9, -8));

        numArray.update(0, 3);
        assertThat(numArray.sumRange(1, 1)).isEqualTo(-8);
        assertThat(numArray.sumRange(0, 1)).isEqualTo(-5);
        numArray.update(1, -3);
        assertThat(numArray.sumRange(0, 1)).isEqualTo(0);
    }

    @Test void test_tree_is_done_correctly() {
        NumArray numArray = new NumArray($(1, 2, 3));

        assertThat(numArray.sumRange(0, 0)).isEqualTo(1);
        assertThat(numArray.sumRange(1, 1)).isEqualTo(2);
        assertThat(numArray.sumRange(2, 2)).isEqualTo(3);
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
            int pow = nextPowOfTwo(n);
            tree = new int[2 * pow];

            System.arraycopy(nums, 0, tree, pow / 2, n);
            for (int p = pow / 2; p > 0; p /= 2)
                for (int i = p; i < 2 * p; i += 2)
                    tree[i / 2] = tree[i] + tree[i + 1];
        }

        void buildTree(int index, int lo, int hi, int[] nums) {
            if (lo == hi) {
                tree[index] = nums[lo];
                return;
            }
            int mid = lo + (hi - lo) / 2;
            buildTree(left(index), lo, mid, nums);
            buildTree(right(index), mid + 1, hi, nums);

            tree[index] = tree[left(index)] + tree[right(index)];
        }

        int query(int index, int lo, int hi, int from, int to) {
            if (lo > to || hi < from) return 0;
            if (from <= lo && hi <= to) return tree[index];

            int mid = lo + (hi - lo) / 2;
            if (from > mid)
                return query(right(index), mid + 1, hi, from, to);
            else if (to <= mid)
                return query(left(index), lo, mid, from, to);

            int left = query(left(index), lo, mid, from, mid);
            int right = query(right(index), mid + 1, hi, mid + 1, to);
            return left + right;
        }

        void update(int index, int lo, int hi, int i, int val) {
            if (lo == hi) {
                if (lo == i) tree[index] = val;
                return;
            }

            int mid = lo + (hi - lo) / 2;
            update(left(index), lo, mid, i, val);
            update(right(index), mid + 1, hi, i, val);

            tree[index] = tree[left(index)] + tree[right(index)];
        }

        static int left(int index) {return 2 * index + 1;}

        static int right(int index) {return 2 * index + 2;}

        static int nextPowOfTwo(int val) {
            int pow = 1;
            while (pow < val) pow *= 2;
            return pow;
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        public int sumRange(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }
    }
}

/*

l = 2*i =>
    (l-1)/2=i
r = 2*i+1
    (r-2)/2=i


         1
      2     3
    4 5     6 7

1 2 3 4   5 6 7 8
0 1 2 3 | 4 5 6 7
(4-1)/2 = 1
(5-2)/2 = 1

(6-1)/2 = 2
(6-2)/2 = 2
*/