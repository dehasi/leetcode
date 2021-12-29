package algs4.week2;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> first, last;
    private int size;

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        requireNonNull(item);
        if (isEmpty()) {
            last = new Node<>(item);
            first = last;
        } else {
            last.next = new Node<>(item);
            last = last.next;
        }
        ++size;
    }

    // remove and return a random item
    public Item dequeue() {
        assertNotEmpty();
        int elem = StdRandom.uniform(size);
        if (elem == 0) {
            Item item = first.item;
            first = first.next;
            --size;
            return item;
        } else {
            Node<Item> node = getItem(elem - 1);
            Item item = node.next.item;
            node.next = node.next.next;
            if (elem == size() - 1)
                last = node.next == null ? node : node.next;
            --size;
            return item;
        }
    }

    // return a random item (but do not remove it)
    public Item sample() {
        assertNotEmpty();
        int elem = StdRandom.uniform(size);
        return getItem(elem).item;
    }

    private Node<Item> getItem(int position) {
        int i = 0;
        for (Node<Item> p = first; p != null; p = p.next) {
            if (i == position) return p;
            ++i;
        }
        throw new IllegalStateException("Proebali item");
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new NodeIterator<>(first);
    }

    private void assertNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
    }

    private static <Item> void requireNonNull(Item item) {
        if (item == null) throw new IllegalArgumentException();
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
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        // need for testing
    }
}
