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

        public NumArray(int[] nums) {

        }

        public void update(int index, int val) {

        }

        public int sumRange(int left, int right) {
            return -42;
        }
    }
}