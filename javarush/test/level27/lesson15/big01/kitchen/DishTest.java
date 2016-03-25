package com.javarush.test.level27.lesson15.big01.kitchen;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 14.02.2016.
 */
public class DishTest
{

    @Test
    public void testAllDishesToString() throws Exception
    {

        String expect = "Fish, Steak, Soup, Juice, Water";
        String actual = Dish.allDishesToString();
        assertEquals(expect, actual);

    }
}