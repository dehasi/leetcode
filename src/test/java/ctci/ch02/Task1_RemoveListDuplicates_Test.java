package ctci.ch02;

import java.util.Objects;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1_RemoveListDuplicates_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        Node<Integer> list = new Node<>(1, new Node<>(1, new Node<>(1, new Node<>(2))));

        list = solution.deleteDuplicates(list);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(1)).isTrue();
        assertThat(list.contains(2)).isTrue();
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    static class Node<Type> {

        private final Type value;

        private Node<Type> next;

        Node(Type value, Node<Type> next) {
            this.value = value;
            this.next = next;
        }

        Node(Type value) {
            this(value, null);
        }

        boolean contains(Type value) {
            for (var p = this; p != null; p = p.next)
                if (Objects.equals(p.value, value))
                    return true;
            return false;
        }

        int size() {
            int result = 0;
            var p = this;
            while (p != null) {
                ++result;
                p = p.next;
            }
            return result;
        }
    }

    // [x] Input boundaries: I assume
    // [x] Edge cases: null, no dupliates
    // [x] Complexity (time, memory): O(n^2), O(n)
    class Solution {
        Node<Integer> deleteDuplicates(Node<Integer> list) {
            var dummyHead = new Node<Integer>(null);
            var p = dummyHead;

            while (list != null) { // O(n)
                if (dummyHead.contains(list.value)) // O(n)
                    list = list.next;
                else {
                    p.next = new Node<>(list.value);
                    p = p.next;
                }
            }
            return dummyHead.next;
        }
    }
}