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

    static int count(int n){
        if(n == 1) return 1;

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
        if (n == 0)  return 0;
        if (n == 1)  return 1;

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
