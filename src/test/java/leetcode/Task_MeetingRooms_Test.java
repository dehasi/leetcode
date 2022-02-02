package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task_MeetingRooms_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.canAttendMeetings(
            new Interval[] {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)}
        )).isFalse();
    }

    @Test void test2() {
        assertThat(solution.canAttendMeetings(
            new Interval[] {new Interval(7, 10), new Interval(2, 4)}
        )).isTrue();
    }

    class Interval {
        final int start, end;

        Interval() {
            this(0, 0);
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // [x] Input boundaries: [[s1,e2]] si < ei
    // [x] Edge cases: one interval
    // [x] Complexity (time, memory): O(nlogn) O(c)
    class Solution {
        public boolean canAttendMeetings(Interval[] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
            for (int i = 1; i < intervals.length; ++i)
                if (intervals[i - 1].end > intervals[i].start) return false;
            return true;
        }
    }
}