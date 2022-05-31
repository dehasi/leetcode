package array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearch {

    private final Solution solution = new Solution();

    @Test void testL() {
        assertThat(solution.lsearch(3, 1, 2, 3, 3, 4, 5, 6)).isEqualTo(2);
        assertThat(solution.lsearch(3, 1, 2, 2, 3, 3, 4, 5, 6)).isEqualTo(3);
        assertThat(solution.lsearch(3, 1, 2, 3, 3, 3, 4, 5, 6)).isEqualTo(2);
        assertThat(solution.lsearch(4, 1, 2, 3, 3, 3, 4, 5, 6)).isEqualTo(5);
        assertThat(solution.lsearch(4, 1, 2, 4, 4, 5, 6)).isEqualTo(2);
        assertThat(solution.lsearch(1, 1, 2, 3, 3, 3, 4, 5, 6)).isEqualTo(0);
    }

    @Test void testR() {
        assertThat(solution.rsearch(3, 1, 2, 3, 3, 4, 5, 6)).isEqualTo(3);
        assertThat(solution.rsearch(3, 1, 2, 2, 3, 3, 4, 5, 6)).isEqualTo(4);
        assertThat(solution.rsearch(3, 1, 2, 3, 3, 3, 4, 5, 6)).isEqualTo(4);
        assertThat(solution.rsearch(4, 1, 2, 3, 3, 3, 4, 5, 6)).isEqualTo(5);
        assertThat(solution.rsearch(4, 1, 2, 4, 4, 5, 6)).isEqualTo(3);
        assertThat(solution.rsearch(1, 1, 2, 3, 3, 3, 4, 5, 6)).isEqualTo(0);
    }

    class Solution {
        int lsearch(int x, int... a) {
            int l = 0, r = a.length - 1, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (a[mid] >= x) {
                    ans = mid;
                    r = mid - 1;
                } else l = mid + 1;
            }
            return ans;
        }

        int rsearch(int x, int... a) {
            int l = 0, r = a.length - 1, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (a[mid] <= x) {
                    ans = mid;
                    l = mid + 1;
                } else r = mid - 1;
            }
            return ans;
        }
    }
}
