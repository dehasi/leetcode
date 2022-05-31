package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
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

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> used = new HashMap<>();
        HashMap<Integer, Integer> cache = new HashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;
            queue.add(key);
            used.put(key, used.getOrDefault(key, 0) + 1);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key) || cache.size() < capacity) {
                cache.put(key, value);
                queue.add(key);
                used.put(key, used.getOrDefault(key, 0) + 1);
            } else {
                while (!queue.isEmpty()) {
                    int candidate = queue.poll();
                    int usedTimes = used.get(candidate) - 1;
                    if (usedTimes > 0) used.put(candidate, usedTimes);
                    else {
                        used.remove(candidate);
                        cache.remove(candidate);
                        break;
                    }
                }
                put(key, value);
            }
        }
    }
}