package com;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class IteratorTest {
    public void testGet() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.pushBack(i);
        }

        IteratorFace<Integer> it = doubleLinkedList.iterator();

        it.first();
        try {
            int firstData = it.get();
            System.out.println("first data: " + firstData);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        it.next();
        try {
            int nextData = it.get();
            System.out.println("next data: " + nextData);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        it.last();
        try {
            int lastData = it.get();
            System.out.println("last data: " + lastData);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        it.prev();
        try {
            int prevData = it.get();
            System.out.println("previous data: " + prevData);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        it.toIndex(20);
        try {
            int outOfBoundsData = it.get();
            System.out.println("out of bounds data: " + outOfBoundsData);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        it.last();
        try {
            it.next();
            int outOfBoundsData = it.get();
            System.out.println("out of bounds data: " + outOfBoundsData);
        } catch (NullPointerException | NoSuchElementException e) {
            System.out.println("No such element");
        }

        it.first();
        try {
            it.prev();
            int outOfBoundsData = it.get();
            System.out.println("out of bounds data: " + outOfBoundsData);
        } catch (NullPointerException | NoSuchElementException e) {
            System.out.println("No such element");
        }

    }

    public void testSet() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.pushBack(i);
        }

        IteratorFace<Integer> it = doubleLinkedList.iterator();
        it.toIndex(4);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        it.set(32);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

    }

    public void testAdd() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.pushBack(i);
        }

        IteratorFace<Integer> it = list.iterator();

        System.out.println(list);
        it.toIndex(6);
        it.add(95);
        System.out.println(list);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
    }

    public void testRemove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.pushBack(i);
        }

        IteratorFace<Integer> it = list.iterator();


        System.out.println(list);
        it.toIndex(5);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        it.remove();
        System.out.println(list);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
    }

    public void testSeveralIterators() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.pushBack(i);
        }
        Vector<IteratorFace<Integer>> itVector = new Vector<>();
        for (int i = 0; i < 3; i++) {
            IteratorFace<Integer> it = doubleLinkedList.iterator();
            itVector.add(it);
        }

        for (IteratorFace<Integer> it : itVector) {
            it.toIndex(3);
        }

        itVector.get(0).remove();

        for (IteratorFace<Integer> it : itVector) {
            try {
                int data = it.get();
                System.out.println("Data: " + data);
            } catch (NoSuchElementException e) {
                System.out.println("No such element");
            }
        }


    }
}
