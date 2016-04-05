package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 05.04.2016.
 */
public class OrderTest {

    @Test
    public void testToString() throws Exception {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(Dish.valueOf("Juice"));
        dishes.add(Dish.valueOf("Fish"));
        Order order = new Order(dishes, new Tablet(5));
        String expected = "Your order: [Juice, Fish] of Tablet{number=5}";
        String actual = order.toString();

        assertEquals(expected, actual);

    }
}