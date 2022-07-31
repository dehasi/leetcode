package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.assertj.core.api.Assertions.assertThat;

public class Task322_CoinChange_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.coinChange($(1, 2, 5), 11)).isEqualTo(3);
    }

    @Test void test2() {
        assertThat(solution.coinChange($(186, 419, 83, 408), 6249)).isEqualTo(20);
    }

    @Timeout(120)
    @Test void test3_tle() {
        assertThat(solution.coinChange($(3, 7, 405, 436), 8839)).isEqualTo(20);// smth but TLE
    }

    private static int[] $(int... vals) {return vals;}

    // [x] Input boundaries: coins.len [1..12] coins[i] in [1..max_int] amount in [0..10^4]
    // [x] Edge cases: coins.len == 1, amount == 0, can't divide amount to coins
    // [_] Complexity (time, memory):
    static
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins.length == 1) return amount % coins[0] == 0 ? amount / coins[0] : -1;
            Arrays.sort(coins);
            reverse(coins);

            return min(coins, amount, new HashSet<>());
        }

        private void reverse(int[] coins) {
            for (int l = 0, r = coins.length - 1; l < r; ++l, --r) {
                int tmp = coins[l];
                coins[l] = coins[r];
                coins[r] = tmp;
            }
        }

        private int min(int[] coins, int amount, Set<Integer> taken) {
            if (amount == 0) return 0;
            if (taken.size() == coins.length) return -1;

            int min = -1;
            for (int i = 0; i < coins.length; ++i) {
                int coin = coins[i];
                if (taken.contains(coin)) continue;
                if (coin > amount) continue;

                taken.add(coin);

                for (int cur = coin; cur <= amount; cur += coin) {
                    int take = cur / coin;
                    int rest = min(coins, amount - cur, taken);
                    if (rest != -1)
                        min = (min == -1) ? take + rest : Math.min(min, take + rest);
                }

                taken.remove(coin);
            }

            return min;
        }
    }
}