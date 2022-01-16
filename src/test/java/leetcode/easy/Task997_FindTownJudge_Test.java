package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task997_FindTownJudge_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.findJudge(2, new int[][] {{1, 2}})).isEqualTo(2);
    }

    @Test void test2() {
        assertThat(solution.findJudge(3, new int[][] {{1, 3}, {2, 3}})).isEqualTo(3);
    }

    @Test void test3_noJudge() {
        assertThat(solution.findJudge(3, new int[][] {{1, 3}, {2, 3}, {3, 1}})).isEqualTo(-1);
    }

    @Test void test4_fewJundges() {
        assertThat(solution.findJudge(3, new int[][] {{1, 3}, {2, 3}, {1, 2}, {3, 2}})).isEqualTo(-1);
    }

    @Test void test5() {
        assertThat(solution.findJudge(3, new int[][] {{1, 3}, {2, 3}, {1, 2}, {3, 2}, {2, 1}})).isEqualTo(-1);
    }

    // [x] Input boundaries: n in [1..1000], edges [0..10_000], trust[i] in n
    // [x] Edge cases are covered: no edges, no judge, few judges
    // [x] Complexity is calculated (time, memory), O(E+V), O(V), V = vertex = n, E = edge trust.len
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] edgesCount = new int[n + 1];
            for (int i = 0; i < trust.length; ++i) {
                ++edgesCount[trust[i][1]]; // in
                --edgesCount[trust[i][0]]; // out
            }

            for (int i = 1; i < edgesCount.length; ++i)
                if (edgesCount[i] == n - 1) return i;
            return -1;
        }
    }
}