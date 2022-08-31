package leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task871_MinimumNumberOfRefuelingStops_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.minRefuelStops(1, 1, $$())).isEqualTo(0);
    }

    @Test void test2() {
        assertThat(solution.minRefuelStops(100, 1, $$($(10, 100)))).isEqualTo(-1);
    }

    @Test void test3() {
        assertThat(solution.minRefuelStops(100, 10, $$($(10, 60), $(20, 30), $(30, 30), $(60, 40)))).isEqualTo(2);
    }

    @Test void test4() {
        assertThat(solution.minRefuelStops(100, 50, $$($(25, 50), $(50, 25)))).isEqualTo(1);
    }

    private static int[] $(int... vals) {return vals;}

    private static int[][] $$(int[]... rows) {return rows;}

    // [_] Input boundaries: target & startFuel, fuel in [1..10^9] station len in [0..500]
    // [_] Edge cases: target = 0, target = startFuel
    // [_] Complexity (time, memory):
    static
    class Solution {
        final int position = 0, fuel = 1;

        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            if (target == 0 || target <= startFuel) return 0;
            return findMin(0, target, startFuel, stations, 0);
        }

        private int findMin(int index, int target, int fuelInCar, int[][] stations, int lastPosition) {
            if (index == stations.length) return fuelInCar + lastPosition >= target ? 0 : -1; // ??

            int curPosition = stations[index][position];
            int fuelInGasStation = stations[index][fuel];
            fuelInCar -= (curPosition - lastPosition);

            if (fuelInCar < 0) return -1; //no fuel to reach
            if (curPosition <= target) return 0;

            int noTank = findMin(index + 1, target, fuelInCar, stations, curPosition);
            int tank = 1 + findMin(index + 1, target, fuelInCar + fuelInGasStation, stations, curPosition);
            if (noTank == -1) return tank;
            if (tank == -1) return noTank;
            return Math.min(noTank, tank);
        }
    }
}