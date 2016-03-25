package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alexey on 26.10.2015.
 */
class MoldovanHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " +
                getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}