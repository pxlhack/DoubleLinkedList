package com.list;

public interface IteratorFace<E extends Comparable> {
    public void first();

    public void last();

    public boolean valid();

    public E get();

    public void set(E newData);

    public boolean toIndex(int index);

    public boolean next();

    public boolean prev();

    public boolean equals(IteratorFace two);

    public boolean add(E data);

    public void remove() throws Throwable;

}
