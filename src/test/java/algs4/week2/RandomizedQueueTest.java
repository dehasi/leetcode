package algs4.week2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomizedQueueTest {

    @Test void isEmpty() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue).isEmpty();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue).isNotEmpty();
    }

    @Test void size() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue).hasSize(0);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThat(queue.size()).isEqualTo(3);
        assertThat(queue).containsExactly(1, 2, 3);
    }

    @Test void enqueue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThat(queue).containsExactly(1, 2, 3);
    }

    @Test void sample() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);

        assertThat(queue.sample()).isEqualTo(1);
    }

    //    @Test void dequeue_firstElem() {
    //        algs4.week2.RandomizedQueue<Integer> queue = new algs4.week2.RandomizedQueue<>();
    //        queue.enqueue(1);
    //        queue.enqueue(2);
    //        queue.enqueue(3);
    //
    //        Integer val = queue.dequeue(0);
    //
    //        assertThat(val).isEqualTo(1);
    //        assertThat(queue).containsExactly(2, 3);
    //    }
    //
    //    @Test void dequeue_midElem() {
    //        algs4.week2.RandomizedQueue<Integer> queue = new algs4.week2.RandomizedQueue<>();
    //        queue.enqueue(1);
    //        queue.enqueue(2);
    //        queue.enqueue(3);
    //
    //        Integer val = queue.dequeue(1);
    //
    //        assertThat(val).isEqualTo(2);
    //        assertThat(queue).containsExactly(1, 3);
    //    }
    //
    //    @Test void dequeue_lastElem() {
    //        algs4.week2.RandomizedQueue<Integer> queue = new algs4.week2.RandomizedQueue<>();
    //        queue.enqueue(1);
    //        queue.enqueue(2);
    //        queue.enqueue(3);
    //
    //        Integer val = queue.dequeue(2);
    //
    //        assertThat(val).isEqualTo(3);
    //        assertThat(queue).containsExactly(1, 2);
    //    }
}