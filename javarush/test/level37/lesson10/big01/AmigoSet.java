package com.javarush.test.level37.lesson10.big01;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Alexey on 11.04.2016.
 */
public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set{
    private final Object PRESENT = new Object();

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
