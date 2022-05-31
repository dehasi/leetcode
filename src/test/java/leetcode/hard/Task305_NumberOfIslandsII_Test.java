package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task305_NumberOfIslandsII_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        assertThat(solution.numIslands2(3, 3, positions)).containsExactly(1, 1, 2, 3);
    }

    @Test void test2() {
        int[][] positions = {{0, 0}};
        assertThat(solution.numIslands2(1, 1, positions)).containsExactly(1);
    }

    @Test void test3() {
        int[][] positions = {{0, 1}, {0, 0}};
        assertThat(solution.numIslands2(1, 2, positions)).containsExactly(1, 1);
    }

    @Test void test4() {
        int[][] positions = {{0, 0}, {1, 1}, {0, 1}};
        assertThat(solution.numIslands2(2, 2, positions)).containsExactly(1, 2, 1);
    }

    @Test void test5() {
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};
        assertThat(solution.numIslands2(3, 3, positions)).containsExactly(1, 1, 2, 2);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            int[][] land = new int[m][n];
            List<Integer> result = new ArrayList<>(positions.length);

            int numOfIslands = 0, color = 1;
            UF uf = new UF(positions.length + 1);

            for (int i = 0; i < positions.length; ++i) {
                int r = positions[i][0];
                int c = positions[i][1];

                if (land[r][c] == 0) {
                    List<Integer> neighbors = neighbors(land, r, c);
                    if (neighbors.size() == 0) {
                        land[r][c] = color;
                        ++color;
                        ++numOfIslands;
                    } else {
                        int parentsCount = parentsCount(uf, neighbors);
                        int commonParent = unite(uf, neighbors);
                        land[r][c] = commonParent;
                        numOfIslands -= (parentsCount - 1);
                    }
                }
                result.add(numOfIslands);
            }
            return result;
        }

        private List<Integer> neighbors(int[][] land, int r, int c) {
            HashSet<Integer> result = new HashSet<>(4);

            if (r - 1 >= 0) result.add(land[r - 1][c]);
            if (r + 1 <= land.length - 1) result.add(land[r + 1][c]);

            if (c - 1 >= 0) result.add(land[r][c - 1]);
            if (c + 1 <= land[r].length - 1) result.add(land[r][c + 1]);
            result.remove(0);
            return new ArrayList<>(result);
        }

        int parentsCount(UF uf, List<Integer> neighbors) {
            HashSet<Integer> result = new HashSet<>(4);
            for (int n : neighbors)
                result.add(uf.parent(n));

            return result.size();
        }

        int unite(UF uf, List<Integer> neighbors) {
            int nb = neighbors.get(0);
            for (int n : neighbors) uf.unite(n, nb);
            return uf.parent(nb);
        }

        class UF {
            int[] id;

            UF(int n) {
                id = new int[n];
                for (int i = 0; i < n; ++i) id[i] = i;
            }

            int parent(int k) {
                int init = k;
                while (id[k] != k) k = id[k];
                id[init] = k;
                return id[init] = k;
            }

            void unite(int k1, int k2) {
                id[parent(k1)] = parent(k2);
            }
        }
    }
}