package com.javarush.test.level27.lesson15.big01.kitchen;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 05.04.2016.
 */
public class CookTest {

    @Test
    public void testToString() throws Exception {
        String expected = "Amigo";
        String actual = new Cook(expected).toString();

        assertEquals(expected, actual);
    }
}