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

    @Test void test3() {
        NumArray numArray = new NumArray($(0, 9, 5, 7, 3));

        assertThat(numArray.sumRange(4, 4)).isEqualTo(3);
        assertThat(numArray.sumRange(2, 4)).isEqualTo(15);
        assertThat(numArray.sumRange(3, 3)).isEqualTo(7);
    }

    @Test void test4() {
        NumArray numArray = new NumArray($(7, 2, 7, 2, 0));

        numArray.update(4, 6);
        numArray.update(0, 2);
        numArray.update(0, 9);
        assertThat(numArray.sumRange(4, 4)).isEqualTo(6);
        numArray.update(3, 8);

        assertThat(numArray.sumRange(0, 4)).isEqualTo(32);
        numArray.update(4, 1);
        assertThat(numArray.sumRange(0, 3)).isEqualTo(26);
        assertThat(numArray.sumRange(0, 4)).isEqualTo(27);
        numArray.update(0, 1);
    }

    @Test void test_tree_is_built_correctly() {
        NumArray numArray = new NumArray($(1, 2, 3));

        assertThat(numArray.tree).isEqualTo($(0, 6, 3, 3, 1, 2, 3, 0));
    }

    @Test void test_one_range_request() {
        NumArray numArray = new NumArray($(1, 2, 3));

        assertThat(numArray.sumRange(0, 0)).isEqualTo(1);
        assertThat(numArray.sumRange(0, 1)).isEqualTo(3);
        assertThat(numArray.sumRange(1, 1)).isEqualTo(2);
        assertThat(numArray.sumRange(0, 2)).isEqualTo(6);
        assertThat(numArray.sumRange(1, 2)).isEqualTo(5);
        assertThat(numArray.sumRange(2, 2)).isEqualTo(3);

        numArray = new NumArray($(1, 2, 3, 4));

        assertThat(numArray.sumRange(0, 0)).isEqualTo(1);
        assertThat(numArray.sumRange(1, 1)).isEqualTo(2);
        assertThat(numArray.sumRange(2, 2)).isEqualTo(3);
        assertThat(numArray.sumRange(3, 3)).isEqualTo(4);
    }

    @Test void test_tree_is_updated_correctly() {
        NumArray numArray = new NumArray($(1, 2, 3));

        numArray.update(2, 5);
        assertThat(numArray.tree).isEqualTo($(0, 8, 3, 5, 1, 2, 5, 0));
    }

    private static int[] $(int... vals) {return vals;}

    // [x] Input boundaries: nums_len in [1..3*10^4], nums_i in [-100..100] => max sum forall_i 3*10^6 < INT_MAX_VAL
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class NumArray {
        private final int[] tree;
        private final int pow;

        public NumArray(int[] nums) {
            int n = nums.length;
            pow = nextPowOfTwo(n);
            tree = new int[2 * pow];

            buildTreeBottomUp(nums);
        }

        private void buildTreeBottomUp(int[] nums) {
            System.arraycopy(nums, 0, tree, pow, nums.length);
            for (int p = pow; p > 1; p /= 2)
                for (int i = p; i < 2 * p; i += 2)
                    tree[i / 2] = tree[i] + tree[i + 1];
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

        static int left(int index) {return 2 * index;}

        static int right(int index) {return 2 * index + 1;}

        static int nextPowOfTwo(int val) {
            int pow = 1;
            while (pow < val) pow *= 2;
            return pow;
        }

        public void update(int index, int val) {
            int idx = index + pow;
            tree[idx] = val;
            for (int p = pow; p > 1; p /= 2) {
                idx -= (idx % 2);
                tree[idx / 2] = tree[idx] + tree[idx + 1];
                idx = idx / 2;
            }
        }

        public int sumRange(int left, int right) {
            return query(1, 0, pow - 1, left, right);
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
                  24            [0, pow]
            21          3     [0, pow/2] [pow/2, pow]
         9     12     3      0
       0  9    5 7   3 0    0 0
       0  1    2 3    4

*/