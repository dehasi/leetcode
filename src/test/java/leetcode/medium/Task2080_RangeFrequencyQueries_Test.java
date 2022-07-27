package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2080_RangeFrequencyQueries_Test {

    @Test void test1() {
        RangeFreqQuery solution = new RangeFreqQuery($(12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56));

        assertThat(solution.query(1, 2, 4)).isEqualTo(1);
        assertThat(solution.query(0, 11, 33)).isEqualTo(2);
    }

    @Test void test2() {
        RangeFreqQuery solution = new RangeFreqQuery($(1, 1, 1, 2, 2));

        assertThat(solution.query(0, 1, 2)).isEqualTo(0);
        assertThat(solution.query(0, 2, 1)).isEqualTo(3);
        assertThat(solution.query(3, 3, 2)).isEqualTo(1);
        assertThat(solution.query(2, 2, 1)).isEqualTo(1);
    }

    /*


    3, 4, 5, 3, 3, 2, 2, 2, 5, 4, _, _, _, _, _,
    0, 1, 2, 3, 4, 5, 6, 7, 8 ,9,
            0-9
         0-4,    5-9
    0-2,  3-4,  5-7,8-9
0-1,2-2,3-3,4-4, 5-6,7-7, 8-8, 9-9
   00,11,22,33,44,
     */
    @Test void test3() {
        RangeFreqQuery solution = new RangeFreqQuery($(3, 4, 5, 3, 3, 2, 2, 2, 5, 4));
        assertThat(solution.query(1, 6, 2)).isEqualTo(2);
        assertThat(solution.query(2, 6, 3)).isEqualTo(2);
        assertThat(solution.query(5, 6, 5)).isEqualTo(0);
        assertThat(solution.query(0, 2, 3)).isEqualTo(1);
        assertThat(solution.query(5, 6, 4)).isEqualTo(0);
    }

    private static int[] $(int... vals) {return vals;}

    // [x] Input boundaries: arr.len in [1..10^5] arr[i] in [1..10^4]
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    static
    class RangeFreqQuery {
        private final Node[] three;
        private final int n;

        public RangeFreqQuery(int[] arr) {
            n = arr.length;
            three = new Node[4 * n];

            buildTree(arr, 0, 0, n - 1);
        }

        public int query(int left, int right, int value) {
            Node node = query(0, 0, n - 1, left, right);
            int l = node.mostLeft(value);
            if (l == -1) return 0;
            else return node.mostRight(value) - l + 1;
        }

        private void buildTree(int[] arr, int index, int lo, int hi) {
            if (lo == hi) {
                three[index] = new Node(new int[] {arr[lo]});
                return;
            }
            int mid = lo + (hi - lo) / 2;
            buildTree(arr, left(index), lo, mid);
            buildTree(arr, right(index), mid + 1, hi);

            three[index] = merge(three[left(index)], three[right(index)]);
        }

        private int left(int index) {return 2 * index + 1;}

        private int right(int index) {return 2 * index + 2;}

        private Node merge(Node node1, Node node2) {
            if (node1 == null) return node2;
            if (node2 == null) return node1;

            int[] result = new int[node1.sorted.length + node2.sorted.length];
            int i = 0, j = 0, k = 0;
            while (i < node1.sorted.length && j < node2.sorted.length) {
                if (node1.sorted[i] < node2.sorted[j]) {
                    result[k] = node1.sorted[i];
                    ++k; ++i;
                } else {
                    result[k] = node2.sorted[j];
                    ++k; ++j;
                }
            }

            while (i < node1.sorted.length) {
                result[k] = node1.sorted[i];
                ++k; ++i;
            }

            while (j < node2.sorted.length) {
                result[k] = node2.sorted[j];
                ++k; ++j;
            }
            return new Node(result);
        }

        private Node query(int index, int lo, int hi, int from, int to) {
            if (lo > to || hi < from) return null;

            if (from <= lo && to >= hi) return three[index];

            int mid = lo + (hi - lo) / 2;
            if (from > mid)
                return query(right(index), mid + 1, hi, from, to);
            else if (to <= mid)
                return query(left(index), lo, mid, from, to);

            Node left = query(left(index), lo, mid, from, mid);
            Node right = query(right(index), mid + 1, hi, mid + 1, to);
            return merge(left, right);
        }

        class Node {
            int[] sorted;

            Node(int[] sorted) {this.sorted = sorted;}

            int mostRight(int target) {
                int ans = -1, l = 0, r = sorted.length;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (sorted[mid] <= target) {
                        ans = mid; l = mid + 1;
                    } else r = mid;
                }
                if (ans == -1 || sorted[ans] != target) return -1;
                else return ans;
            }

            int mostLeft(int target) {
                int ans = -1, l = 0, r = sorted.length;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (sorted[mid] >= target) {
                        ans = mid; r = mid;
                    } else l = mid + 1;
                }
                if (ans == -1 || sorted[ans] != target) return -1;
                else return ans;
            }
        }
    }
}