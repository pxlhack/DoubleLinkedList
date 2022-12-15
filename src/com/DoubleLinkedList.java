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
            size = 1;
        } else {
            Node tmp = this.head;
            head = new Node<>(data);
            head.next = tmp;
            tmp.prev = head;
            size++;
        }
    }

    public void add(int index, E data) {


        if (index == 0) {
            pushFront(data);
            return;
        }
        if (index == size) {
            pushBack(data);
            return;
        }

        if (index > 0 && index < size) {

            Node prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }


            Node newNode = new Node<>(data);
            Node nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            size++;

        }
    }

    public E remove(int index) {
        if (index == 0) {
            return popFront();
        }
        if (index == size - 1) {
            return popBack();
        }

        if (index > 0 && index < size - 1) {

            Node removedNode = head;
            for (int i = 0; i < index; i++) {
                removedNode = removedNode.next;
            }
            E data = (E) removedNode.data;
            unlink(removedNode);
            return data;
        }
        return null;
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
