package HW2.task1.list;

import HW2.task1.list.iterator.MyIterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node currentElem;
    private Node lastElem;
    private int size;

    @Override
    public void add(Object val) {
        Node current = new Node(null, val, null);
        if (currentElem == null){
            currentElem = current;
            lastElem = current;
            size++;
            return;
        }
        lastElem.next = current;
        current.prev = lastElem;
        lastElem = current;
        lastElem.next = null;
        size++;

    }

    @Override
    public void remove(T val) {

        if (currentElem.value.equals(val)) {
            Node node = currentElem;
            currentElem = node.next;
            currentElem.prev = null;
            size--;
            return;
        }

        Node prev = currentElem;
        Node current = currentElem.next;

        while(current != null) {
            if (current.value.equals(val)) {
                prev.setNext(current.next);
                Node last = lastElem;
                Node prevLast = lastElem.prev;
                if (last == current){
                    lastElem = lastElem.prev;
                    lastElem.next = null;
                }
                while (prevLast != null){
                    if (prevLast == current){
                        last.setPrev(prevLast.prev);
                    }
                    last = prevLast;
                    prevLast = prevLast.prev;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {

        Node node = currentElem;

        if (index == 0){
            return (T) node.value;
        }

        for (int i = 0; i < index; i++) {
            node = node.next;
            if (i == index - 1){
                return (T) node.value;
            }
        }

        return null;
    }

    @Override
    public String toString() {

        return "MyLinkedList{" +
                "first=" + currentElem + "\n" +
                "last=" + lastElem +
                '}';
    }

    @Override
    public ListIterator iterator() {
        return new ListIterator(currentElem, lastElem);
    }

    private static class Node<T> {
        private Node prev;
        private T value;
        private Node next;

        private Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val = '" + value + '\'' +
                    ", next = " + next +
                    '}';
        }
    }


    private static class ListIterator implements MyIterator {

        private Node first;
        private Node last;

        private ListIterator(Node first, Node last) {
            this.first = first;
            this.last = last;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public boolean hasPrevious() {
            return last != null;
        }

        @Override
        public Object next() {
            Object val = first.value;
            first = first.next;
            return val;
        }

        @Override
        public Object previous() {
            Object val = last.value;
            last = last.prev;
            return val;
        }
    }
}
