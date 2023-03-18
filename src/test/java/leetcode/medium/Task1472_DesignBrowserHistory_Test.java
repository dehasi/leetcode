package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task1472_DesignBrowserHistory_Test {

    @Test
    void test1() {
        BrowserHistory history = new BrowserHistory("aa");

        assertThat(history.back(30)).isEqualTo("aa");
        assertThat(history.forward(30)).isEqualTo("aa");
    }

    @Test
    void test2() {
        BrowserHistory history = new BrowserHistory("aa");
        history.visit("b");
        history.visit("c");
        history.visit("d");
        assertThat(history.back(1)).isEqualTo("c");
        assertThat(history.forward(1)).isEqualTo("d");
    }

    // [x] Input boundaries: steps [1..100] url -> [.a-z], 5k calls
    // [x] Edge cases: back || forward > history_size
    // [x] Complexity (time, memory): TC: O(history_size), MC: O(history_size)
    static
    class BrowserHistory {

        private Node begin, cur;

        public BrowserHistory(String homepage) {
            begin = new Node(homepage);
            cur = begin;
        }

        public void visit(String url) {
            cur.next = new Node(url);
            cur.next.prev = cur;
            cur = cur.next;
        }

        public String back(int steps) {
            while (steps-- > 0 && cur.prev != null)
                cur = cur.prev;
            return cur.val;
        }

        public String forward(int steps) {
            while (steps-- > 0 && cur.next != null)
                cur = cur.next;
            return cur.val;
        }

        static class Node {
            final String val;
            Node prev, next;

            Node(String val) {
                this.val = val;
            }
        }
    }
}