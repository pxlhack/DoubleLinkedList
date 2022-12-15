package com;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.function.Consumer;

public class Array<E> {
    Array() {
        elementData = new Vector<>();
    }

    public synchronized Iterator<E> iterator() {
        return new ArrayIterator();
    }

    public int size() {
        return elementData.size();
    }


    E elementData(int index) {
        return elementData.get(index);
    }

    public void add(E element) {
        elementData.add(element);
    }

    public void add(int index, E element) {
        elementData.add(index, element);
    }

    public void remove(int index) {
        elementData.remove(index);
    }


    private final Vector<E> elementData;

    private class ArrayIterator implements ListIterator<E> {
        int cursor;
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != elementData.size();
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= elementData.size())
                throw new NoSuchElementException();
            cursor = i + 1;
            return elementData(lastRet = i);
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            cursor = i;
            return elementData(lastRet = i);
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            if (lastRet == -1)
                throw new IllegalStateException();

            Array.this.remove(lastRet);

            cursor = lastRet;
            lastRet = -1;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            ListIterator.super.forEachRemaining(action);
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }

    }

    @Override
    public String toString() {
        return elementData.toString();
    }
}
