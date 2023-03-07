package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task2187_MinimumTimeToCompleteTrips_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        assertThat(solution.minimumTime($(1, 2, 3), 5)).isEqualTo(3);
    }

    private static int[] $(int... vals) {
        return vals;
    }

    // [x] Input boundaries: len(time) in [1..10^5], time[i] in [1..10^7]; totalTrips in [1..10^7]
    // [x] Edge cases: len(time) = 1;
    // [x] Complexity (time, memory):
    //     TC: log(min*totalTrips)* len(time) => log(LONG_MAX_VALUE)*O(n) => O(n).
    //     MC: O(const)
    static
    class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            long min = time[0];
            for (int i = 0; i < time.length; ++i)
                min = Math.min(min, time[i]);

            long ans = -1, l = min, r = min * totalTrips + 1;

            while (l < r) {
                long midTime = l + (r - l) / 2;
                long trips = tripsForTime(midTime, time);
                if (trips < totalTrips) l = midTime + 1;
                else {
                    ans = midTime;
                    r = midTime;
                }
            }

            return ans;
        }

        long tripsForTime(long midTime, int[] time) {
            long trips = 0;
            for (int it : time) trips += midTime / it;

            return trips;
        }
    }
}