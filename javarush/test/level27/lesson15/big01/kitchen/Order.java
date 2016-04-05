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
    private Tablet table;

    public Order(Tablet table) throws IOException {
        this.table = table;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty()) return "";
        return "Your order: " + dishes + " of Tablet{number=" + table.getNumber() + "}";
    }
}

