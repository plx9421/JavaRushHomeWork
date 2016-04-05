package com.javarush.test.level27.lesson15.big01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 05.04.2016.
 */
public class TabletTest {

    @Test
    public void testGetNumber() throws Exception {

    }

    @Test
    public void testToString() throws Exception {
        int expected = 5;
        String actual = new Tablet(expected).toString();

        assertEquals(expected, actual);

    }
}