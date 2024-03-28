import java.util.NoSuchElementException;

interface Queue<T> {
    T remove();
    void add(T obj);
    T first();
    int getSize();
}

public class LinkedListQueue<T> implements Queue<T> {
    private int size = 0;
    private Node<T> head = new Node<>(null);

    @Override
    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T temp = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return temp;
    }

    @Override
    public void add(T obj) {
        if (size == 0) {
            head.prev = new Node<>(obj, head, head);
            head.next = head.prev;
        } else {
            head.prev.next = new Node<>(obj, head.prev, head);
            head.prev = head.prev.next;
        }
        size++;
    }

    @Override
    public T first() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return head.next.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    public T last() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return head.prev.data;
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}



