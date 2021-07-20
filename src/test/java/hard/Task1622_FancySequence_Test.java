package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1622_FancySequence_Test {

    @Test void test1() {
        assertTrue(false);
    }

    @Test void test2() {

    }

    @Test void test3() {

    }

    class Fancy {

        private final int module = 1000_000_007;
        List<Integer> list = new ArrayList<>(10000);
        List<Integer> start = new ArrayList<>(10000);
        List<Function<Integer, Integer>> seq = new ArrayList<>(10000);

        public Fancy() {}

        public void append(int val) {
            list.add(val % module);
            start.add(seq.size());
        }

        public void addAll(int inc) {
            seq.add(x -> (x % module + inc % module) % module);
        }

        public void multAll(int m) {
            seq.add(x -> ((x % module) * (m % module)) % module);
        }

        public int getIndex(int idx) {
            if (idx >= list.size())
                return -1;
            int ans = list.get(idx) % module;
            for (int i = start.get(idx); i < seq.size(); i++) {
                System.err.println("ans was =" + ans);
                ans = seq.get(i).apply(ans % module) % module;
                System.err.println("ans now =" + ans);
            }
            return ans % module;
        }
    }
}