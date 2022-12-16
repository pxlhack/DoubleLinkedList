package com;

import java.util.LinkedList;
import java.util.ListIterator;

public class Test2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        ListIterator it = list.listIterator();
        it.next();
        it.next();
        it.next();
        System.out.println(it.next());
        it.remove();
        System.out.println(list);
        System.out.println(it.next());

    }
}
