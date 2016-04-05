package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Alexey on 05.04.2016.
 */
public enum Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString(){
        Dish[] dishs = Dish.values();
        String result = "";
        for (int i = 0; i < dishs.length; i++) {
            if (i != (dishs.length - 1)) {
                result += dishs[i].toString() + ", ";
            } else {
                result += dishs[i].toString();
            }
        }
        return result;
    }
}
