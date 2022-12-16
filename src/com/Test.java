package com;

import java.util.ListIterator;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        ListIterator it = list.listIterator();
        ListIterator it2 = list.listIterator();
        System.out.println(it.next());
        System.out.println(it2.next());
        it.remove();
        it2.previous();
        System.out.println(it2.next());


        System.out.println(list);
    }

}
