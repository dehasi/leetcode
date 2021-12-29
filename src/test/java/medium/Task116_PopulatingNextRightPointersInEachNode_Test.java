package medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task116_PopulatingNextRightPointersInEachNode_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        Node result = solution.connect(new Node(1, new Node(2), new Node(3), null));

        assertThat(result.val).isEqualTo(1);
        assertThat(result.left.next).isEqualTo(result.right);
    }

    @Test void test2() {
        Node result = solution.connect(new Node(1,
            new Node(2, new Node(4), new Node(5), null),
            new Node(3, new Node(6), new Node(7), null), null));

        assertThat(result.val).isEqualTo(1);
        assertThat(result.left.right.val).isEqualTo(5);
        assertThat(result.left.right.next.val).isEqualTo(6);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // [x] Input boundaries are clarified: can be null, can be a single root node
    // [x] Edge cases are covered:  perfect binary tree; tree size [0..2^12-1]
    // [x] Complexity is calculated (time, memory) O(n) and O(n)
    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;

            if (root.left != null)
                root.left.next = root.right;

            if (root.right != null)
                root.right.next = root.next != null ? root.next.left : null;

            connect(root.left);
            connect(root.right);
            return root;
        }
    }
}