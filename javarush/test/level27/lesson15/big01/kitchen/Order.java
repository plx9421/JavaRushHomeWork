package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexey on 05.04.2016.
 */
public class Order {
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Order(List<Dish> dishes, Tablet table) {
        this.dishes = dishes;
        this.tablet = table;
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty()) return "";
        return "Your order: " + dishes + " of " + tablet;
    }
}

