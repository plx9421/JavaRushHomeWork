package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.Tablet;
import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 06.04.2016.
 */
public class StatisticManagerTest {

    @Test
    public void testGetInstance() throws Exception {
        StatisticManager manager = StatisticManager.getInstance();
        String actual = manager.getEvents().toString();
        String expected = "{COOKED_ORDER=[], SELECTED_VIDEOS=[], NO_AVAILABLE_VIDEO=[]}";
        assertEquals(expected, actual);
    }

    @Test
    public void testRegister() throws Exception {

        List<Dish> dishes = new ArrayList<>();
        dishes.add(Dish.valueOf("Fish"));
        dishes.add(Dish.valueOf("Steak"));
        dishes.add(Dish.valueOf("Soup"));
        dishes.add(Dish.valueOf("Juice"));
        dishes.add(Dish.valueOf("Water"));
        Order order = new Order(dishes, new Tablet(5));
        StatisticManager manager = StatisticManager.getInstance();

        int expected = manager.getEvents().get(EventType.COOKED_ORDER).size();
        manager.register(new CookedOrderEventDataRow(order.getTablet().toString(), "Amigo", order.getTotalCookingTime() * 60, order.getDishes()));
        int actual = manager.getEvents().get(EventType.COOKED_ORDER).size();
        assertEquals(expected + 1, actual);

        expected = manager.getEvents().get(EventType.SELECTED_VIDEOS).size();
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1, 100));
        actual = manager.getEvents().get(EventType.SELECTED_VIDEOS).size();
        assertEquals(expected + 1, actual);
    }
}