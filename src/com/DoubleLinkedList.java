package com;


//add
// remove


import java.util.LinkedList;

public class DoubleLinkedList<E> {
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        size = 0;
    }

    public void pushBack(E data) {

        if (head == null) {
            head = new Node<>(data);
            size = 1;
        } else {
            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = new Node<>(data);
            tmp.next.prev = tmp;
            size++;
        }

    }

    public void pushFront(E data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node tmp = this.head;
            head = new Node<>(data);
            head.next = tmp;
            tmp.prev = head;
        }
    }

    public E popBack() {
        Node tmp = head;
        E data = null;
        if (tmp != null) {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            data = (E) tmp.data;
            unlink(tmp);
        }
        return data;
    }

    public E popFront() {
        Node tmp = head;
        E data = null;
        if (tmp != null) {
            data = (E) tmp.data;
            unlink(tmp);
        }
        return data;
    }

    private void unlink(Node x) {
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next != null) {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
    }

    private class Node<E> {
        private Node prev;
        private Node next;
        private E data;

        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    private Node<E> head;

    @Override
    public String toString() {
        String listString = "[";
        Node tmp = head;
        if (tmp != null) {
            while (tmp.next != null) {
                listString += tmp.data + ", ";
                tmp = tmp.next;
            }
            listString += tmp.data;
        }
        listString += "]";
        return listString;
    }
}
