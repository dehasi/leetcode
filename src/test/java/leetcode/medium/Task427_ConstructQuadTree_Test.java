package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task427_ConstructQuadTree_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[][] grid = {
            {0, 1},
            {1, 0}
        };
        Node root = solution.construct(grid);

        assertThat(root.isLeaf).isFalse();

        assertThat(root.topLeft.isLeaf).isTrue();
        assertThat(root.topLeft.val).isFalse();

        assertThat(root.topRight.isLeaf).isTrue();
        assertThat(root.topRight.val).isTrue();

        assertThat(root.bottomLeft.isLeaf).isTrue();
        assertThat(root.bottomLeft.val).isTrue();

        assertThat(root.bottomRight.isLeaf).isTrue();
        assertThat(root.bottomRight.val).isFalse();
    }

    @Test void test2() {
        int[][] grid = {
            {1, 1, 1, 1,/**/ 0, 0, 0, 0},
            {1, 1, 1, 1,/**/ 0, 0, 0, 0},
            {1, 1, 1, 1,/**/ 1, 1, 1, 1},
            {1, 1, 1, 1,/**/ 1, 1, 1, 1},
            /* ********************** */
            {1, 1, 1, 1,/**/ 0, 0, 0, 0},
            {1, 1, 1, 1,/**/ 0, 0, 0, 0},
            {1, 1, 1, 1,/**/ 0, 0, 0, 0},
            {1, 1, 1, 1,/**/ 0, 0, 0, 0}
        };

        Node root = solution.construct(grid);

        assertThat(root.isLeaf).isFalse();

        assertThat(root.topLeft.isLeaf).isTrue();
        assertThat(root.topLeft.val).isTrue();

        assertThat(root.topRight.isLeaf).isFalse();
        assertThat(root.topRight.topLeft.isLeaf).isTrue();
        assertThat(root.topRight.topLeft.val).isFalse();
        assertThat(root.topRight.topRight.isLeaf).isTrue();
        assertThat(root.topRight.topRight.val).isFalse();
        assertThat(root.topRight.bottomLeft.isLeaf).isTrue();
        assertThat(root.topRight.bottomLeft.val).isTrue();
        assertThat(root.topRight.bottomRight.isLeaf).isTrue();
        assertThat(root.topRight.bottomRight.val).isTrue();

        assertThat(root.bottomLeft.isLeaf).isTrue();
        assertThat(root.bottomLeft.val).isTrue();

        assertThat(root.bottomRight.isLeaf).isTrue();
        assertThat(root.bottomRight.val).isFalse();
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    // [x] Input boundaries: grid.len = 2^x, x in [0..6]
    // [x] Edge cases: x = 0
    // [x] Complexity (time, memory): TC = O(grid)  MC = O(log(2^x)) = O(x)
    class Solution {
        public Node construct(int[][] grid) {
            if (grid.length == 1) return new Node(grid[0][0] == 1, true);

            return construct(grid, 0, 0, grid.length);
        }

        public Node construct(int[][] grid, int i, int j, int n) {
            if (n == 1) return new Node(grid[i][j] == 1, true);

            int nn = n / 2;
            Node topLeft = construct(grid, i, j, nn);
            Node topRight = construct(grid, i, j + nn, nn);
            Node bottomLeft = construct(grid, i + nn, j, nn);
            Node bottomRight = construct(grid, i + nn, j + nn, nn);

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                if (topLeft.val == topRight.val
                    && topRight.val == bottomLeft.val
                    && bottomLeft.val == bottomRight.val) {
                    return new Node(bottomLeft.val, true);
                }
            }
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}