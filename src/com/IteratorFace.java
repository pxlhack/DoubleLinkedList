package com;

public interface IteratorFace<E extends Comparable> {
    public void first();

    public void last();

    public boolean valid();

    public E get();

    public boolean next();

    public boolean prev();

    public boolean equals(IteratorFace two);

}
