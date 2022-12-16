package com;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E extends Comparable> {
    private int size;
    private Node<E> head;

    public DoubleLinkedList() {
        this.head = null;
        size = 0;
    }

    public void pushBack(Comparable data) {

        if (head == null) {
            head = new Node(data);
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

    public void pushFront(Comparable data) {
        if (head == null) {
            head = new Node(data);
            size = 1;
        } else {
            Node tmp = this.head;
            head = new Node(data);
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

    public void set(int index, Comparable newData) {
        if (index == 0) {
            head.data = (E) newData;
        } else {
            if (index > 0 && index < size) {
                Node tmp = head;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.next;
                }
                tmp.data = newData;
            }
        }
    }

    public Itr<E> iterator() {
        return new Itr<>();
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

    private class Itr<E extends Comparable> implements IteratorFace {
        private Node current;

        public Itr() {
            current = head;
        }

        @Override
        public void first() {
            current = head;
        }

        @Override
        public void last() {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            current = tmp;
        }

        @Override
        public boolean valid() {
            return current != null;
        }

        @Override
        public boolean next() {
            if (current == null) {
                return false;
            }
            current = current.next;
            return current != null;
        }

        @Override
        public boolean prev() {
            if (current == null) {
                return false;
            }
            current = current.prev;
            return current != null;
        }

        @Override
        public boolean equals(IteratorFace two) {
            return current == ((Itr) two).current;
        }

        @Override
        public boolean add(Comparable data) {
            if (current == null) {
                return false;
            }

            if (current.next == null) {
                pushBack(data);
                current = current.next;
                return true;
            }
            if (current.prev == null) {
                current = current.prev;
                pushFront(data);
                return true;
            }

            if (current.prev != null) {
                Node newNode = new Node(data);
                Node nextNode = current.next;
                current.next = newNode;
                newNode.prev = current;
                newNode.next = nextNode;
                nextNode.prev = newNode;

                current = current.next;
                return true;
            }
            return false;
        }

        @Override
        public void remove() {
            current.data = null;
            if (current.prev != null) current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;

            if (current.next != null) {
                current = current.next;
            } else if (current.prev != null) {
                current = current.prev;
            }

        }

        @Override
        public E get() {
            if (current != null) {
                if (current.data != null) {
                    return (E) current.data;
                }
            }

            throw new NoSuchElementException();

        }


        @Override
        public void set(Comparable newData) {
            current.data = newData;
        }

        @Override
        public boolean toIndex(int index) {
            if (index == 0) {
                first();
                return true;
            }
            if (index == size - 1) {
                last();
                return true;
            }

            if (index > 0 && index < size - 1) {
                Node tmp = head;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.next;
                }
                current = tmp;
                return true;
            }
            current = null;
            return false;
        }

    }

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
