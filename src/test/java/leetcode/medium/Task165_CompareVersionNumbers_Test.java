package leetcode.medium;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task165_CompareVersionNumbers_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.compareVersion("1.01", "1.001")).isEqualTo(0);
    }

    @Test void test2() {
        assertThat(solution.compareVersion("1.01", "2.001")).isEqualTo(-1);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public int compareVersion(String version1, String version2) {
            var v1 = parse(version1);
            var v2 = parse(version2);

            while (v1.size() < v2.size()) v1.add(0);
            while (v2.size() < v1.size()) v2.add(0);
            int n = v2.size();
            for (int i = 0; i < n; ++i) {
                int res = Integer.compare(v1.get(i), v2.get(i));
                if (res != 0) return res;
            }
            return 0;
        }

        private List<Integer> parse(String version) {
            return Arrays.stream(version.split("\\."))
                .map(Integer::valueOf)
                .collect(toList());
        }
    }
}