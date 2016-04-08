package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 05.04.2016.
 */
public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {


        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Petrov");

        StatisticEventManager.getInstance().register(cook1);
        StatisticEventManager.getInstance().register(cook2);

        cook1.addObserver(new Waitor());
        cook2.addObserver(new Waitor());

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(cook1);
            tablet.addObserver(cook2);
            tablets.add(tablet);
        }

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();

        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();



    }
}
