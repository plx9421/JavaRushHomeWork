package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

/**
 * Created by Alexey on 05.04.2016.
 */
public class Cook extends Observable {
    private String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        int cookingTime = order.getTotalCookingTime();
        try {
            Thread.sleep(cookingTime * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + cookingTime + "min");
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, cookingTime * 60, order.getDishes()));
        setChanged();
        notifyObservers(order);
        busy = false;
    }
}
