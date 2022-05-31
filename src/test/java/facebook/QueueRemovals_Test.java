package facebook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueRemovals_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2};
        assertThat(solution.findPositions(arr_1, x_1)).isEqualTo(expected_1);
    }

    @Test void test2() {
        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        assertThat(solution.findPositions(arr_2, x_2)).isEqualTo(expected_2);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        class Val {
            final int index;
            int val;

            Val(int index, int val) {
                this.index = index; this.val = val;
            }
        }

        int[] findPositions(int[] arr, int x) {
            // Write your code here
            Queue<Val> queue = new ArrayDeque<>();
            for (int i = 0; i < arr.length; ++i) queue.add(new Val(i, arr[i]));

            int[] result = new int[x];
            int rindex = 0;

            while (!queue.isEmpty() && rindex < x) {
                List<Val> vals = new ArrayList<>(x);
                for (int i = 0; i < x && !queue.isEmpty(); ++i)
                    vals.add(queue.poll());

                if (vals.isEmpty()) break; // is it possible?
                Val max = firstMax(vals);
                for (Val v : vals) {
                    if (v.index == max.index) {
                        result[rindex] = v.index + 1;
                        ++rindex;
                    } else {
                        if (v.val > 0) --v.val;
                        queue.add(v);
                    }
                }
            }
            return result;
        }

        Val firstMax(List<Val> vals) {
            Val result = vals.get(0);
            for (Val v : vals)
                if (v.val > result.val) result = v;
            return result;
        }
    }
}