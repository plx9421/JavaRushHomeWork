package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexey on 14.02.2016.
 */
public class Order
{
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString()
    {
        if (dishes.size() == 0) return "";
        return "Your order: " + dishes.toString() + " of " + tablet;
    }

    public int getTotalCookingTime()
    {
        int time = 0;
        for (Dish dish : dishes) {
            time += dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty(){
        return dishes == null || dishes.isEmpty();
    }

    public Tablet getTablet() {
        return tablet;
    }
}
