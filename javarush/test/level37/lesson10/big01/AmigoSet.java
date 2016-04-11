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
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() throws InternalError {
        AmigoSet<E> amigoSet = new AmigoSet<>();
        amigoSet.map = new HashMap<>(map);
        return amigoSet;
    }
}
