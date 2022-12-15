package com;


//add
// remove


public class DoubleLinkedList<E> {
    public DoubleLinkedList() {
        this.head = null;
    }

    public void pushBack(E data) {

        if (head == null) {
            head = new Node<>(data);
        } else {
            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = new Node<>(data);
            tmp.next.prev = tmp;
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
        return null;
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
        while (tmp.next != null) {
            listString += tmp.data + ", ";
            tmp = tmp.next;
        }
        listString += tmp.data + "]";
        return listString;
    }
}
