package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task146_LRUCacheUber_Test {

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

    // ["LRUCache","put","put","put","put","get","get"]
    // [[2],       [2,1],[1,1],[2,3],[4,1],[1],[2]]
    @Test void test3() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertThat(lruCache.get(2)).isEqualTo(3);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    // TLE
    class LRUCache {
        private static final int MAX = 100_000 + 1;
        private static final int NIL = -1;

        private final Set<Integer> keys;
        private final int[] cache;
        private final int[] used;
        private final int capacity;

        private int timeStamp = 0;
        private int size = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keys = new HashSet<>(capacity);

            cache = new int[MAX];
            Arrays.fill(cache, NIL);

            used = new int[MAX];
            Arrays.fill(used, NIL);
        }

        public int get(int key) {
            if (cache[key] == -1) return -1;

            used[key] = ++timeStamp;
            return cache[key];
        }

        public void put(int key, int value) {
            if (cache[key] != NIL || size < capacity) {
                boolean increaseSize = cache[key] == NIL;
                cache[key] = value;
                used[key] = ++timeStamp;
                if (increaseSize) ++size;
                keys.add(key);
                return;
            }

            int lruKey = -1;
            for (int i : keys) {
                if (lruKey == -1 || used[i] < used[lruKey]) lruKey = i;
            }

            cache[lruKey] = NIL;
            used[lruKey] = NIL;
            keys.remove(lruKey);
            --size;
            put(key, value);
        }
    }
}