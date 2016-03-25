package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alexey on 26.10.2015.
 */
abstract class Hen{
    abstract int getCountOfEggsPerMonth();
    public String getDescription()
    {
        return "Я курица.";
    }
}