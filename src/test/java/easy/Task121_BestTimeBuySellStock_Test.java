package easy;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.max;
import static org.assertj.core.api.Assertions.assertThat;

public class Task121_BestTimeBuySellStock_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.maxProfit(new int[] {7, 1, 5, 3, 6, 4})).isEqualTo(5);
    }

    @Test void test2() {
        assertThat(solution.maxProfit(new int[] {7, 6, 4, 3, 1})).isEqualTo(0);
    }

    @Test void test3_oneElement() {
        assertThat(solution.maxProfit(new int[] {7})).isEqualTo(0);
    }

    @Test void test3_maxElements() {
        int[] input = new int[100_000];
        assertThat(solution.maxProfit(input)).isEqualTo(0);
    }

    // [x] Input boundaries are clarified: prices in [1..10^5]; price_i in [0..10^4], sum(prices) <=10^9 fits integer.
    // [x] Edge cases are covered: SINGLE day to buy one stock
    // [x] Complexity is calculated (time, memory) O(n)
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0, minPrice = MAX_VALUE;
            for (int i = 0; i < prices.length; ++i)
                if (prices[i] < minPrice)
                    minPrice = prices[i];
                else
                    profit = max(profit, prices[i] - minPrice);

            return profit;
        }
    }
}
