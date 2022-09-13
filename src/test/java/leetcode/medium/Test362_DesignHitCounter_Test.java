package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test362_DesignHitCounter_Test {

    @Test void test1() {
        HitCounter hitCounter = new HitCounter();

        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        assertThat(hitCounter.getHits(4)).isEqualTo(3);
        hitCounter.hit(300);
        assertThat(hitCounter.getHits(300)).isEqualTo(4);
        assertThat(hitCounter.getHits(301)).isEqualTo(3);
    }

    // [x] Input boundaries: timestamp in [1..2*10^9] => whole positive int.
    // [x] Edge cases: Several hits may happen at the same timestamp.
    // [x] Complexity (time, memory): TC = O*(1), MC = O(hits).
    static
    class HitCounter {
        private final Queue<Integer> queue = new LinkedList<>(); // faster than ArrayDeque according to leetcode

        public void hit(int timestamp) {
            queue.add(timestamp);
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty()) {
                if (timestamp - queue.peek() >= 300) queue.poll();
                else break;
            }
            return queue.size();
        }
    }
}