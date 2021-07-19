package hard;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task927_ThreeEqualParts_Test {

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
        assertThat(solution.toInt(new int[] {0, 0, 0, 1, 0, 1}, 0, 6)).isEqualTo(BigInteger.valueOf(5));
        assertThat(solution.toInt(new int[] {0, 0, 0, 1, 0, 1}, 3, 6)).isEqualTo(BigInteger.valueOf(5));
        solution.threeEqualParts(new int[] {0, 0, 0, 1, 1, 0});
        assertThat(solution.toInt(new int[] {0, 0, 0, 1, 1, 0}, 3, 5)).isEqualTo(BigInteger.valueOf(3));
    }

    class Solution {

        public int[] threeEqualParts(int[] arr) {

            int length = arr.length;
            int[] ones = new int[length];
            ones[0] = arr[0];
            for (int i = 1; i < length; ++i) {
                ones[i] = ones[i - 1] + arr[i];
            }
            if (ones[ones.length - 1] % 3 != 0)
                return new int[] {-1, -1};
            if (ones[ones.length - 1] == 0)
                return new int[] {0, length - 1};
            cache = new BigInteger[length];
            int last = arr[length - 1];
            cache[length - 1] = BigInteger.valueOf(last);
            for (int i = length - 2, pow = 1; i >= 0; --i, ++pow) {
                if (arr[i] == 1) {
                    cache[i] = cache[i + 1].add(BigInteger.ONE.shiftLeft(pow)); //* 1
                } else {
                    cache[i] = cache[i + 1];
                }
            }

            BigInteger first = BigInteger.ZERO;
            for (int i = 0; i < length; ++i) {
                first = first.shiftLeft(1).add(BigInteger.valueOf(arr[i]));
                if (arr[i] == last && ones[i] == ((ones[length - 1] - ones[i]) / 2)) {
                    for (int j = i + 2; j < length; ++j) {
                        if (arr[j - 1] == last && first.equals(cache[j]) && first.equals(toInt(arr, i + 1, j)))
                            return new int[] {i, j};
                    }
                }
            }
            return new int[] {-1, -1};
        }

        BigInteger[] cache;

        BigInteger toInt(int[] bits, int from, int toExcluded) {
            BigInteger result = BigInteger.ZERO;
            for (int i = from; i < toExcluded; ++i) {
                result = result.shiftLeft(1);
                result = result.add(BigInteger.valueOf(bits[i]));
            }
            return result;
        }
    }
}