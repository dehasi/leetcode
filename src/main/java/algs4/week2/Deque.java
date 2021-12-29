package algs4.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first, last;
    private int size;

    // is the deque empty?
    public boolean isEmpty() {
        return first == last && last == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        assertNonNull(item);
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
        } else {
            Node<Item> newNode = new Node<>(item);
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        ++size;
    }

    // add the item to the back
    public void addLast(Item item) {
        assertNonNull(item);
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node<Item> newNode = new Node<>(item);
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
            ++size;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        assertNotEmpty();

        --size;
        Node<Item> oldFirst = first;
        if (size == 0) {
            first = null;
            last = null;
            return oldFirst.item;
        }
        first = first.next;
        if (first != null)
            first.prev = null;
        return oldFirst.item;
    }

    // remove and return the item from the back

    public Item removeLast() {
        assertNotEmpty();

        --size;
        Node<Item> oldLast = last;
        if (size == 0) {
            last = null;
            first = null;
            return oldLast.item;
        }
        last = last.prev;
        if (last != null) {
            if (last.next != null)
                last.next.prev = null;
            last.next = null;
        }
        return oldLast.item;
    }

    // return an iterator over items in order from front to back

    public Iterator<Item> iterator() {
        return new NodeIterator<>(first);
    }

    private void assertNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException("algs4.week2.Deque is empty");
    }

    private static <Item> void assertNonNull(Item obj) {
        if (obj == null) throw new IllegalArgumentException();
    }

    private static class NodeIterator<Item> implements Iterator<Item> {

        private Node<Item> first;

        public NodeIterator(Node<Item> first) {
            this.first = first;
        }

        @Override public boolean hasNext() {
            return first != null;
        }

        @Override public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = first.item;
            first = first.next;
            return item;
        }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next, prev;

        Node(Item item) {
            this.item = item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        // need for testing
    }
}