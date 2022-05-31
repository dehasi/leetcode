package facebook;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RevenueMilestones_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int revenues[] = {100, 200, 300, 400, 500};
        int milestones[] = {300, 800, 1000, 1400, 100500};
        int expected[] = {2, 4, 4, 5, -1};
        assertThat(solution.getMilestoneDays(revenues, milestones)).isEqualTo(expected);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        int[] getMilestoneDays(int[] revenues, int[] milestones) {
            // Write your code here
            int[] total = new int[revenues.length];
            total[0] = revenues[0];
            for (int i = 1; i < revenues.length; ++i)
                total[i] = total[i - 1] + revenues[i];

            int[] result = new int[milestones.length];

            for (int i = 0; i < milestones.length; ++i) {
                int index = bs(total, milestones[i]);
                result[i] = index == -1 ? -1 : index + 1;
            }
            return result;
        }

        int bs(int[] arr, int k) {
            int l = 0, r = arr.length - 1;
            if (arr[l] > k) return l;
            if (arr[r] < k) return -1;

            int ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] >= k) {
                    ans = mid; r = mid - 1;
                } else l = mid + 1;
            }

            return ans;
        }
    }
}