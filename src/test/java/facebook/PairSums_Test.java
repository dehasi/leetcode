package facebook;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PairSums_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        assertThat(solution.numberOfWays(arr_1, k_1 )).isEqualTo(2);
    }

    @Test void test2() {
        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3}; // 1 3 3 3 5
        assertThat(solution.numberOfWays(arr_2, k_2 )).isEqualTo(4);
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        int numberOfWays(int[] arr, int k) {
            // Write your code here
            Arrays.sort(arr);
            int l = 0, r = arr.length - 1, result = 0;
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (arr[l] == arr[r]) {++l; continue;}
                if (sum == k) {
                    ++result;
                    if (arr[l] == arr[l + 1]) {
                        ++l;
                    } else {
                        ++l; --r;
                    }
                    continue;
                }
                if (sum < k) ++l;
                if (sum > k) --r;
            }

            if (k % 2 == 0) {
                int w = 0;
                for (int i = 0; i < arr.length; ++i)
                    if (arr[i] == k / 2) ++w;
                result += w * (w - 1) / 2;
            }
            return result;
        }
    }
}