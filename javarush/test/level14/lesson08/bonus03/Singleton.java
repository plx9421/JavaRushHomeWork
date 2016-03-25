package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Alexey on 01.11.2015.
 */
final public class Singleton {
    private static Singleton owner = null;
    private Singleton(){
        owner = this;
    }
    static public Singleton getInstance(){
        if (owner == null) new Singleton();
        return owner;
    }
}
