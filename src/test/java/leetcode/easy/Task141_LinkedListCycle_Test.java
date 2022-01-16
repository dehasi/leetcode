package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task141_LinkedListCycle_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.hasCycle(null)).isFalse();
    }

    @Test void test2() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        assertThat(solution.hasCycle(list)).isFalse();
    }

    @Test void test3() {
        ListNode list = new ListNode(1);
        list.next = list;
        assertThat(solution.hasCycle(list)).isTrue();
    }

    @Test void test4() {
        ListNode list = new ListNode(1);
        ListNode node = new ListNode(2);
        list.next = node;
        node.next = list;
        assertThat(solution.hasCycle(list)).isTrue();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // [x] Input boundaries are clarified: list size [0..10_000]. list.val in |10^5|
    // [x] Edge cases are covered, list is null
    // [x] Complexity is calculated (time, memory), O(n)
    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;

            ListNode slow = head, fast = head.next;
            while (slow != null && fast != null && fast.next != null) {
                if (slow == fast) return true;
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }
}