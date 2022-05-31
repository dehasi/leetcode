package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1011_CapacityToShipPackagesWithinDDays_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)).isEqualTo(15);
    }

    @Test void test2() {
        assertThat(solution.shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4)).isEqualTo(3);
    }

    @Test void test3() {
        assertThat(solution.shipWithinDays(new int[] {3, 2, 2, 4, 1, 4}, 3)).isEqualTo(6);
    }

    @Test void test4() {
        assertThat(solution.shipWithinDays(new int[] {10, 50, 100, 100, 50, 100, 100, 100}, 5)).isEqualTo(160);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int l = max(weights), r = sum(weights), ans = r;
            if (daysLeft(weights, l, days) == 0) return l;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int daysLeft = daysLeft(weights, mid, days);
                if (daysLeft >= 0) {
                    ans = mid;
                    r = mid - 1;
                } else l = mid + 1;
            }
            return ans;
        }

        int daysLeft(int[] weights, int minWeight, int days) {
            int cur = 0;
            for (int i = 0; i < weights.length; ++i) {
                int w = weights[i];
                if (cur + w < minWeight) cur += w;
                else {
                    cur = (cur + w == minWeight) ? 0 : w;
                    --days;
                }
            }
            if (cur > 0) --days;
            return days;
        }

        static int max(int[] w) {
            int r = w[0];
            for (int i : w) r = Math.max(r, i);
            return r;
        }

        static int sum(int[] w) {
            int r = 0;
            for (int i : w) r += i;
            return r;
        }
    }
}