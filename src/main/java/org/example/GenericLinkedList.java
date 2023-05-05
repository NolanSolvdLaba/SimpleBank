package org.example;

public class GenericLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public GenericLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            // next node of tail becomes new
            tail.next = newNode;
        }
        // update tail to new node
        tail = newNode;
        size++;
    }

    public void remove(T data) {
        if (isEmpty()) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) { // update tail if head is null after removing the first node
                tail = null;
            }
            size--;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                // update tail if current.next == null after removing node
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> current = head;
        while (current != null) {
            str += current.data;
            if (current.next != null) {
                str += " -> ";
            }
            current = current.next;
        }
        return str;
    }
    public Node<T> getTail() {
        return tail;
    }
}
