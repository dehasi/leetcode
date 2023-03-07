package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class Task2187_MinimumTimeToCompleteTrips_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        assertThat(solution.minimumTime($(1,2,3), 5)).isEqualTo(3);
    }

    private static int[] $(int... vals) {
        return vals;
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class Solution {
        public long minimumTime(int[] time, int totalTrips) {

            Map<Integer, Integer> map = new HashMap<>();
            int min = time[0], max = time[0];
            for (int i = 0; i < time.length; ++i) {
                map.put(time[i], map.getOrDefault(time[i], 0) + 1);
                min = Math.min(min, time[i]);
                max = Math.max(max, time[i]);
            }

            long ans = -1, l = min, r = min * totalTrips;

            while (l <= r) {
                long midTime = l + (r - l) / 2;
                long trips = tripsForTime(midTime, map);
                if (trips < totalTrips) l = midTime + 1;
                else {
                    ans = midTime;
                    r = midTime - 1;
                }
            }

            return ans;
        }

        long tripsForTime(long time, Map<Integer, Integer> map) {
            long trips = 0;
            for (int key : map.keySet()) {
                trips += map.get(key) * (time / key);
            }
            return trips;
        }
    }
}