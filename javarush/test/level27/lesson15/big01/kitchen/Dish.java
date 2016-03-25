package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Alexey on 14.02.2016.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) { this.duration = duration; }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString()
    {
        Dish[] t = Dish.values();
        StringBuilder result = new StringBuilder(t.length);
        for (int i = 0; i < t.length; i++)
        {
            if (i == t.length - 1) result.append(t[i].name());
            else result.append(t[i].name() + ", ");
        }
        return result.toString();
    }
}
