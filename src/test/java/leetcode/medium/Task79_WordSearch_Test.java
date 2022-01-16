package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task79_WordSearch_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat("").isEqualTo("");
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            char[] path = word.toCharArray();
            visited = new boolean[board.length][board[0].length];
            int l = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (dfs(board, i, j, path, 1))
                            return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(char[][] board, int x, int y, char[] path, int pos) {
            if (visited[x][y])
                return false;
            visited[x][y] = true;

            if (pos >= path.length)
                return true;

            boolean res = false;
            if (x - 1 >= 0 && board[x - 1][y] == path[pos])
                res = dfs(board, x - 1, y, path, pos + 1);
            if (res)
                return true;

            if (x + 1 < board.length && board[x + 1][y] == path[pos])
                res = dfs(board, x + 1, y, path, pos + 1);
            if (res)
                return true;

            if (y - 1 >= 0 && board[x][y - 1] == path[pos])
                res = dfs(board, x, y - 1, path, pos + 1);
            if (res)
                return true;
            if (y + 1 < board[0].length && board[x][y + 1] == path[pos])
                res = dfs(board, x, y + 1, path, pos + 1);
            visited[x][y] = false;
            return res;
        }
    }
}