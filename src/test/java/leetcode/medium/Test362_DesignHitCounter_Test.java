package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
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
    // [_] Complexity (time, memory): TC = O(logN), MC = O(hits).
    static
    class HitCounter {
        private final Map<Integer, Integer> map = new HashMap<>();
        private final TreeSet<Integer> set = new TreeSet<>();

        public void hit(int timestamp) { // logN
            map.put(timestamp, map.getOrDefault(timestamp, 0) + 1); // // const
            set.add(timestamp); // logN
        }

        public int getHits(int timestamp) { // logN
            int fiveMinAgo = subtract5minFrom(timestamp);

            Integer from = set.ceiling(fiveMinAgo); // logN
            if (from == null) return 0;

            Integer to = set.floor(timestamp); // logN
            if (to == null || to < fiveMinAgo) return 0;

            int result = 0;
            for (int key = from; key <= to; ++key) // max 300 => const
                result += map.getOrDefault(key, 0); // const
            return result;
        }

        private int subtract5minFrom(int timestamp) {
            final int fiveMin = 60 * 5;
            return fiveMin > timestamp ? 0 : timestamp - fiveMin + 1;
        }
    }
}