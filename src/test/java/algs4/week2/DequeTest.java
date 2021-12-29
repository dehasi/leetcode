package algs4.week2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DequeTest {

    @Test void isEmpty() {
        Deque<Integer> deque = new Deque<>();
        assertThat(deque.isEmpty()).isTrue();

        deque.addFirst(1);
        deque.addLast(2);
        assertThat(deque).hasSize(2);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test void size() {
        Deque<Integer> deque = new Deque<>();
        assertThat(deque.size()).isEqualTo(0);

        deque.addFirst(1);
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(2);
        assertThat(deque.size()).isEqualTo(4);
        assertThat(deque).containsExactly(1, 1, 2, 2);

        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(3);
        assertThat(deque).containsExactly(1, 2, 2);
        deque.removeLast();
        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque).containsExactly(1, 2);
    }

    @Test void addFirst_oneElem() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeFirst();
        assertThat(deque).isEmpty();

        deque = new Deque<>();
        deque.addFirst(1);
        deque.removeLast();
        assertThat(deque).isEmpty();

        deque = new Deque<>();
        deque.addLast(1);
        deque.removeFirst();
        assertThat(deque).isEmpty();

        deque = new Deque<>();
        deque.addLast(1);
        deque.removeLast();
        assertThat(deque).isEmpty();
    }

    @Test void addFirst() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertThat(deque).containsExactly(3, 2, 1);
    }

    @Test void addLast() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(7);
        deque.addLast(1);
        deque.addFirst(8);
        deque.addLast(2);
        deque.addLast(3);

        assertThat(deque).containsExactly(8, 7, 1, 2, 3);
    }

    @Test void removeFirst() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        assertThat(deque.removeFirst()).isEqualTo(2);
        assertThat(deque).containsExactly(1, 3, 4);
    }

    @Test void removeLast() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        assertThat(deque.removeLast()).isEqualTo(4);
        assertThat(deque.size()).isEqualTo(3);
        assertThat(deque).hasSize(3);
        assertThat(deque).containsExactly(2, 1, 3);
    }
}