package com;

import com.list.DoubleLinkedList;
import com.list.IteratorFace;

import java.util.NoSuchElementException;
import java.util.Vector;

public class IteratorTest {
    public void testSet() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.pushBack(i);
        }
        System.out.println("List:");
        System.out.println(list);

        IteratorFace<Integer> it = list.iterator();
        it.toIndex(4);
        System.out.println("Iterator on 4 index");
        try {
            int data = it.get();
            System.out.println("Data from 4 index: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        it.set(32);
        System.out.println("set data = 32 for 4 index");
        System.out.println("List:");
        System.out.println(list);

        try {
            int data = it.get();
            System.out.println("Data from 4 index: " + data);
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

        System.out.println("List before insert");
        System.out.println(list);

        it.toIndex(6);
        System.out.println("iterator on index 6:");
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println("insert 95 to list");
        it.add(95);

        System.out.println("List after insert to index 6");
        System.out.println(list);

        try {
            int data = it.get();
            System.out.println("Data from iterator: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println();

        it.first();

        System.out.println("List before insert");
        System.out.println(list);

        System.out.println("iterator on first element:");
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println("insert 23 to list");
        it.add(23);

        System.out.println("List after insert to first element");
        System.out.println(list);

        try {
            int data = it.get();
            System.out.println("Data from iterator: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println();

        it.last();

        System.out.println("List before insert");
        System.out.println(list);

        System.out.println("iterator on last element:");
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println("insert 67 to list");
        it.add(67);

        System.out.println("List after insert to last element");
        System.out.println(list);

        try {
            int data = it.get();
            System.out.println("Data from iterator: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println();
        System.out.println("List before insert");
        System.out.println(list);


        it.toIndex(-3);
        System.out.println("iterator on index -3:");
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println("insert 30 to list");
        it.add(30);

        System.out.println("List after insert to index -3");
        System.out.println(list);


    }

    public void testGet() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.pushBack(i);
        }

        System.out.println("List:");
        System.out.println(list);
        IteratorFace<Integer> it = list.iterator();

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
        System.out.print("Data from 20 index: ");
        try {
            int outOfBoundsData = it.get();
            System.out.println("out of bounds data: " + outOfBoundsData);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        System.out.print("Data from next for last element: ");
        it.last();
        try {
            it.next();
            int outOfBoundsData = it.get();
            System.out.println("out of bounds data: " + outOfBoundsData);
        } catch (NullPointerException | NoSuchElementException e) {
            System.out.println("No such element");
        }

        System.out.print("Data from previous for first element: ");
        it.first();
        try {
            it.prev();
            int outOfBoundsData = it.get();
            System.out.println("out of bounds data: " + outOfBoundsData);
        } catch (NullPointerException | NoSuchElementException e) {
            System.out.println("No such element");
        }

    }

    public void testRemove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.pushBack(i);
        }

        IteratorFace<Integer> it = list.iterator();

        System.out.println("List:");
        System.out.println(list);

        System.out.println("Iterator on index 5");
        it.toIndex(5);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        it.remove();
        System.out.println("Remove on index 5");
        System.out.println(list);
        try {
            int data = it.get();
            System.out.println("Data from index 5: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        System.out.println();

        System.out.println("Iterator on first element");
        it.first();
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        it.remove();
        System.out.println("Remove first element");
        System.out.println(list);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        System.out.println("Iterator on last element");
        it.last();
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }
        it.remove();
        System.out.println("Remove last element");
        System.out.println(list);
        try {
            int data = it.get();
            System.out.println("Data: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }


    }

    public void testSeveralIterators() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.pushBack(i);
        }

        System.out.println("List:");
        System.out.println(list);

        Vector<IteratorFace<Integer>> itVector = new Vector<>();
        for (int i = 0; i < 3; i++) {
            IteratorFace<Integer> it = list.iterator();
            itVector.add(it);
        }

        System.out.println("set all iterators to 3 index");
        for (IteratorFace<Integer> it : itVector) {
            it.toIndex(3);
        }
        System.out.println("Delete element with first iterator");
        itVector.get(0).remove();
        System.out.println("List:");
        System.out.println(list);

        System.out.println("Call the get method from iterators");

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
