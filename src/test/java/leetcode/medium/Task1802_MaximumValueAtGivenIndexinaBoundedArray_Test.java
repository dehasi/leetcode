package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task1802_MaximumValueAtGivenIndexinaBoundedArray_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.maxValue(4, 2, 6)).isEqualTo(2);
        assertThat(solution.maxValue(6, 1, 10)).isEqualTo(3);
    }

    @Test void test2() {
        assertThat(solution.maxValue(4, 0, 4)).isEqualTo(1);
    }

    @Test void test3() {
        assertThat(solution.maxValue(8519779, 8354405, 133242446)).isEqualTo(11168);
    }

    // [x] Input boundaries: 1 <= n <= maxSum <= 10^9, 0 <= index < n.
    // [x] Edge cases: n = 1, maxSum == n, big numbers
    // [x] Complexity (time, memory): Time: log(N), Memory: O(1)
    static
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int l = 1, r = maxSum + 1, ans = -1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (canFit(mid, n, index, maxSum)) {
                    ans = mid;
                    l = mid + 1;
                } else r = mid;
            }
            return ans;
        }

        private boolean canFit(int val, int n, int index, int maxSum) {
            long sum = 0;
            if (val > index)
                sum += (long) (val + val - index) * (index + 1) / 2;
            else
                sum += (long) (val + 1) * val / 2 + index - val + 1;


            if (val >= n - index) {
                sum += (long) (val + val - n + 1 + index) * (n - index) / 2;
            } else {
                sum += (long) (val + 1) * val / 2 + n - index - val;
            }
            sum -= val;

            return sum <= maxSum;
        }

        private boolean canFit1(int val, int n, int index, int maxSum) {
            int sum = val, l = index - 1, r = index + 1;
            while (sum <= maxSum && (r < n || l >= 0)) {
                --val;
                if (val == 0) val = 1;
                if (l >= 0) sum += val;
                if (r < n) sum += val;
                --l; ++r;
            }
            return (sum <= maxSum);
        }
    }

}