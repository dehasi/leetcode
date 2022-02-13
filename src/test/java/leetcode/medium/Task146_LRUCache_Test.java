package leetcode.medium;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task146_LRUCache_Test {

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

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class LRUCache {

        LinkedList<Value> list = new LinkedList<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int index = -1;
            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i).key == key) {
                    index = i; break;
                }
            }
            if (index == -1) return -1;
            Value value = list.get(index);
            list.removeIf(v -> v.key == key);
            list.offerFirst(value);
            return value.val;
        }

        public void put(int key, int value) {
            int index = -1;
            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i).key == key) {
                    index = i; break;
                }
            }
            if (index == -1) {
                if (list.size() >= capacity)
                    list.removeLast();
                list.addFirst(new Value(key, value));
            }
            list.removeIf(v -> v.key == key);
            list.addFirst(new Value(key, value));
        }

        class Value {
            final int key, val;

            Value(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}