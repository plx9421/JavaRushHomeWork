package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;

/**
 * Created by Alexey on 14.02.2016.
 */
public class Tablet extends Observable
{
    public final int number;

    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        Order order = null;
        try
        {
            order = new Order(this);
            if (!order.isEmpty())
            {
                ConsoleHelper.writeMessage(order.toString());
                setChanged();
                notifyObservers(order);
                AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                manager.processVideos();
            }

        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()));
        }
    }

    @Override
    public String toString()
    {
        return "Tablet{number=" + number + '}';
    }
}

