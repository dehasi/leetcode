package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task876_MiddleOfLinkedList_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        ListNode result = solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        assertThat(result.val).isEqualTo(3);
    }

    @Test void test2() {
        ListNode result = solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        assertThat(result.val).isEqualTo(3);
    }

    @Test void test3() {
        ListNode result = solution.middleNode(new ListNode(1));
        assertThat(result.val).isEqualTo(1);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    // [x] Input boundaries are clarified: list length [1..100]
    // [x] Edge cases are covered: list length = 1; list size even & odd
    // [x] Complexity is calculated (time, memory): O(n), memory O(1)
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head, slow = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}