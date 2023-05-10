package nium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestTest {

    @Test
    void run() {
        Assertions.assertEquals(1, count(1));
        Assertions.assertEquals(2, count(2));
        Assertions.assertEquals(5, count(3));
    }

    int count_memo(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return count_memo(0, 0, n, memo);
    }

    private int count_memo(int open, int closed, int n, int[][] memo) {
        if (open == closed && closed == n) return 1;
        if (memo[open][closed] > 0) return memo[open][closed];
        int result = 0;

        if (open < n) {
            result += count_memo(open + 1, closed, n, memo);
        }
        if (closed < open) {
            result += count_memo(open, closed + 1, n, memo);
        }
        return memo[open][closed] = result;
    }

    static int count(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }


    public static int count1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int result = 0;

        // Calculate count by considering each possible split
        for (int i = 0; i < n; i++) {
            int leftCount = count(i);
            int rightCount = count(n - i - 1);

            result += leftCount * rightCount;
        }

        // Return the total count of bracket strings
        return result;
    }
}
