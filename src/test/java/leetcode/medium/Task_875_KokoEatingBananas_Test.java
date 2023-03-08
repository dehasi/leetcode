package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task_875_KokoEatingBananas_Test {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        assertThat(solution.minEatingSpeed($(3, 6, 7, 11), 8)).isEqualTo(4);
    }

    @Test
    void test2() {
        assertThat(solution.minEatingSpeed($(30, 11, 23, 4, 20), 5)).isEqualTo(30);
    }

    @Test
    void test3() {
        assertThat(solution.minEatingSpeed($(805306368, 805306368, 805306368), 1000000000)).isEqualTo(3);
    }

    private static int[] $(int... vars) {
        return vars;
    }

    // [x] Input boundaries: len(piles) in [1..10^4], len(piles) <= h; piles[i] in [1..10^9], h in [1..10^9]
    // [x] Edge cases: len(piles) = 1, integer overflow.
    // integer overflow example:
    // len(piles) = 10^4 piles[i] = 10^9. Speed = 1, => hoursToEat = len(piles) *pile[i]/speed =>
    //  10^4 * 10^9/1 = 10^13
    // int = 2^31 = 2*2^10^3= 2*10^3^3 = 2*10^9
    // [x] Complexity (time, memory): TC: O(Nlog(INT_MAX_VALUE)); MC: O(const)

    static
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int l = 1, r = piles[0], ans = -1;
            for (int pile : piles)
                r = Math.max(r, pile); // we eat one pile per our, no sense to have bigger value

            while (l <= r) {
                int speed = l + (r - l) / 2;
                if (hoursToEat(piles, speed) > h) {
                    l = speed + 1;
                } else {
                    ans = speed;
                    r = speed-1;
                }
            }
            return ans;
        }

        private long hoursToEat(int[] piles, int speed) {
            long result = 0;
            for (int pile : piles)
                result += pile / speed + ((pile % speed) == 0 ? 0 : 1);
            // result += (pile+speed-1) / speed; // equal to Math.ceil (pile/speed) but much faster
            return result;
        }

    }
}