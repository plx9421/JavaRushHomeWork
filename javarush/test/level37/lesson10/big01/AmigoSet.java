package com.javarush.test.level37.lesson10.big01;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Alexey on 11.04.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = ((16 > collection.size() / .75f) ? 16 : (int) (collection.size() / .75f));
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
