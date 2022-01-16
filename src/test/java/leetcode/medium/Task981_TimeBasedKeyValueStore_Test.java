package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task981_TimeBasedKeyValueStore_Test {

    private final TimeMap timeMap = new TimeMap();

    @Test void test1() {
        timeMap.set("foo", "bar", 1);
        assertThat(timeMap.get("foo", 1)).isEqualTo("bar");
    }

    @Test void test2() {
        timeMap.set("foo", "bar1", 1);
        timeMap.set("foo", "bar2", 2);
        timeMap.set("foo", "bar3", 3);

        assertThat(timeMap.get("foo", 1)).isEqualTo("bar1");
        assertThat(timeMap.get("foo", 2)).isEqualTo("bar2");
        assertThat(timeMap.get("foo", 3)).isEqualTo("bar3");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class TimeMap {

        HashMap<String, ArrayList<Value>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            ArrayList<Value> values = map.getOrDefault(key, new ArrayList<>());
            values.add(new Value(value, timestamp));
            map.put(key, values);
        }

        public String get(String key, int timestamp) {
            ArrayList<Value> values = map.get(key);
            if (values == null) return "";
            int l = 0, r = values.size() - 1;
            if (values.get(l).timestamp > timestamp) return "";
            if (values.get(r).timestamp <= timestamp) return values.get(r).value;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (values.get(mid).timestamp == timestamp) return values.get(mid).value;
                if (values.get(mid).timestamp < timestamp) l = mid + 1;
                else r = mid;
            }
            return values.get(l - 1).value;
        }

        private class Value {
            int timestamp;
            String value;

            Value(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    }
}