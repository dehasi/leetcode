package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task146_LRUCacheLinkedList_Test {

    @Test void test1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertThat(lruCache.get(1)).isEqualTo(1);
        lruCache.put(3, 3);
        assertThat(lruCache.get(2)).isEqualTo(-1);
        lruCache.put(4, 4);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertThat(lruCache.get(3)).isEqualTo(3);
        assertThat(lruCache.get(4)).isEqualTo(4);
    }

    // ["LRUCache","get","put","get","put","put","get","get"]
    // [[2],        [2], [2,6], [1], [1,5], [1,2], [1], [2]]
    @Test void test2() {
        LRUCache lruCache = new LRUCache(2);
        assertThat(lruCache.get(6)).isEqualTo(-1);
        lruCache.put(2, 6);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        assertThat(lruCache.get(1)).isEqualTo(2);
        assertThat(lruCache.get(2)).isEqualTo(6);
    }

    // [x] Input boundaries: capacity [1..3k], key in [1..10k] value in [1..100k]
    // [x] Edge cases: one element, no elements, key exists -> update only value
    // [x] Complexity (time, memory): TC: O(const) MC: O(capacity)
    class LRUCache {

        private final int capacity;
        private final Map<Integer, Node> cache;
        private Node begin, end;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;

            moveToBegin(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveToBegin(node);
            } else {
                cache.put(key, createNewNode(key, value));
                if (cache.size() > capacity) {
                    cache.remove(end.key);
                    removeEnd();
                }
            }
        }

        private Node createNewNode(int key, int value) {
            Node node = new Node(key, value);
            if (begin == null) {
                begin = end = node;
            } else {
                node.next = begin;
                begin.prev = node;
                begin = node;
            }
            return node;
        }

        private void moveToBegin(Node node) {
            if (node == begin) return;

            if (node == end) {
                end = node.prev;
                end.next = null;
            } else {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }
            node.next = begin;
            node.prev = null;
            begin.prev = node;
            begin = node;
        }

        private void removeEnd() {
            if (begin == end) {
                begin = end = null;
            } else {
                end = end.prev;
                end.next = null;
            }
        }

        static class Node {
            int key;
            int value;
            Node prev, next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}