package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alexey on 26.10.2015.
 */
public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 1;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " +
                getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}