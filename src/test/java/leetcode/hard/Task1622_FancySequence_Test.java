package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1622_FancySequence_Test {

    @Test void test1() {

        Fancy fancy = new Fancy();
        fancy.append(12);
        fancy.append(8);
        assertThat(fancy.getIndex(1)).isEqualTo(8);
        fancy.append(12);
        assertThat(fancy.getIndex(0)).isEqualTo(12);
        fancy.addAll(12);
        fancy.append(8);
        assertThat(fancy.getIndex(2)).isEqualTo(24);
        assertThat(fancy.getIndex(2)).isEqualTo(24);
        fancy.append(4);
        fancy.append(13);
        assertThat(fancy.getIndex(4)).isEqualTo(4);
        fancy.append(12);
        assertThat(fancy.getIndex(6)).isEqualTo(12);
        fancy.append(11);
        assertThat(fancy.getIndex(1)).isEqualTo(20);
        fancy.append(10);
        assertThat(fancy.getIndex(2)).isEqualTo(24);
        fancy.multAll(3);
        fancy.addAll(1);
        assertThat(fancy.getIndex(6)).isEqualTo(37);
        fancy.append(14);
        fancy.addAll(5);
        assertThat(fancy.getIndex(6)).isEqualTo(42);
        fancy.multAll(12);
        assertThat(fancy.getIndex(3)).isEqualTo(360);
        fancy.multAll(12);
        fancy.addAll(15);
        fancy.addAll(6);
        fancy.append(7);
        fancy.multAll(8);
        fancy.append(13);
        fancy.append(15);
        fancy.append(15);
        fancy.multAll(10);
        assertThat(fancy.getIndex(9)).isEqualTo(220560);
        fancy.multAll(12);
        fancy.multAll(12);
        fancy.multAll(9);
        assertThat(fancy.getIndex(9)).isEqualTo(285845760);
        fancy.addAll(9);
        fancy.append(9);
        fancy.multAll(4);
        fancy.addAll(8);
        fancy.addAll(11);
        fancy.multAll(15);
        fancy.addAll(9);
        fancy.addAll(1);
        fancy.append(4);
        fancy.append(10);
        assertThat(fancy.getIndex(9)).isEqualTo(150746316);
    }

    @Test void test3() {

    }

    class Fancy {

        private final int module = 1000_000_000 + 7;
        List<Integer> list = new ArrayList<>(10000);
        List<Integer> start = new ArrayList<>(10000);
        List<Function<Long, Long>> seq = new ArrayList<>(10000);

        public Fancy() {}

        public void append(int val) {
            list.add(val % module);
            start.add(seq.size());
        }

        public void addAll(int inc) {
            seq.add(x -> (x + inc) % module);
        }

        public void multAll(int m) {
            seq.add(x -> (x * m) % module);
        }

        public int getIndex(int idx) {
            if (idx >= list.size())
                return -1;
            long ans = list.get(idx) % module;
            for (int i = start.get(idx); i < seq.size(); ++i)
                ans = seq.get(i).apply(ans) % module;

            return (int)ans;
        }
    }
}