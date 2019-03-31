package util;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * 维护链表的背包
 * Created by fifi on 2017/4/26.
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first; // 链表的首结点
    private int N;

    private class Node{
        Item item;
        Node next;
    }




    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++ ;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
