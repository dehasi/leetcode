package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task21_MergeTwoSortedLists_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat("").isEqualTo("");
    }

    @Test void test2() {
        assertThat("").isEqualTo("");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // [_] Input boundaries:
    // [x] Edge cases: both nulls, one null
    // [x] Complexity (time, memory): TC = O(n+m), MC = O(1)
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            var dummyHead = new ListNode();
            var p = dummyHead;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
                p = p.next;
            }

            p.next = (list1 != null) ? list1 : list2;
            return dummyHead.next;
        }
    }
}