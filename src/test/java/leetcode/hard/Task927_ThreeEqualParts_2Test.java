package leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task927_ThreeEqualParts_2Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int[] result = solution.threeEqualParts(new int[] {1, 0, 1, 0, 1});

        assertThat(result).containsExactly(0, 3);
    }

    @Test void test2() {
        int[] result = solution.threeEqualParts(new int[] {1, 1, 0, 1, 1});

        assertThat(result).containsExactly(-1, -1);
    }

    @Test void test3() {
        int[] result = solution.threeEqualParts(new int[] {1, 1, 0, 0, 1});

        assertThat(result).containsExactly(0, 2);
    }

    @Test void test4() {
        int[] result = solution.threeEqualParts(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0});

        assertThat(result).containsExactly(33, 67);
    }

    @Test void test5() {
        int[] result = solution.threeEqualParts(new int[] {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        assertThat(result).containsExactly(179, 341);
    }

    @Test void toInt() {
        solution.threeEqualParts(new int[] {0, 0, 0, 1, 0, 1});
        assertThat(solution.check(new int[] {0, 0, 0, 1, 0, 1}, 0, 4, 6)).isTrue();

        solution.threeEqualParts(new int[] {1, 0, 0, 0, 0, 1});
        assertThat(solution.check(new int[] {1, 0, 0, 0, 0, 1}, 0, 1, 6)).isTrue();

        solution.threeEqualParts(new int[] {0, 0, 0, 1, 0, 1});
        assertThat(solution.check(new int[] {0, 0, 0, 1, 0, 1}, 0, 5, 6)).isFalse();

        solution.threeEqualParts(new int[] {1, 0, 0, 0, 0, 1});
        assertThat(solution.check(new int[] {1, 0, 0, 0, 0, 1}, 0, 1, 6)).isTrue();
    }

    class Solution {

        int[] ones;

        public int[] threeEqualParts(int[] arr) {
            int length = arr.length;
            ones = new int[length];
            ones[0] = arr[0];
            for (int i = 1; i < length; ++i) {
                ones[i] = ones[i - 1] + arr[i];
            }
            if (ones[ones.length - 1] % 3 != 0)
                return new int[] {-1, -1};
            if (ones[ones.length - 1] == 0)
                return new int[] {0, length - 1};

            int last = arr[length - 1];
            for (int i = 0; i < length - 1; ++i) {
                if (arr[i] == last && ones[i] == ((ones[length - 1] - ones[i]) / 2)) {
                    for (int j = i + 2; j < length; ++j) {
                        if (arr[j - 1] == last
                            && (ones[j - 1] - ones[i]) == (ones[length - 1] - ones[j - 1])
                            && check(arr, 0, i + 1, j)
                            && check(arr, i + 1, j, length)) //[0, i] [i+1,j] [j+1, len]
                            return new int[] {i, j};
                    }
                }
            }
            return new int[] {-1, -1};
        }

        private boolean check(int[] arr, int from, int mid, int toEx) {
            int i = mid - 1, j = toEx - 1;
            while (i >= from && j >= mid)
                if (arr[i--] != arr[j--]) return false;

            if (i < from)
                return j < mid || ones[mid] == ones[j];
            return ones[i] == ones[from];
        }
    }
}
