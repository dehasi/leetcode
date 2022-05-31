package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {

    private final Solution solution = new Solution();

    @Test void test1() {
        Queue<Integer> queue = new PriorityQueue<>(Integer::compare);
        queue.addAll(Arrays.asList(4, 2, 6));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            result.add(queue.poll());
        }
        assertThat(result).containsExactly(2, 4, 6);
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {

    }
}