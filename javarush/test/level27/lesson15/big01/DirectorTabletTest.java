package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 07.04.2016.
 */
public class DirectorTabletTest {

    @Test
        public void testWPrintAdvertisementProfit() throws Exception {
            StatisticManager manager = StatisticManager.getInstance();

            GregorianCalendar date = new GregorianCalendar();
            date.setTime(new Date("march 1 2015"));

            date.add(Calendar.DAY_OF_MONTH, -1);
            manager.register(new VideoSelectedEventDataRow(null, 1, 100, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 2, 200, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 3, 300, date.getTime()));

            date.add(Calendar.DAY_OF_MONTH, -1);
            manager.register(new VideoSelectedEventDataRow(null, 4, 400, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 5, 500, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 6, 900, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 7, 800, date.getTime()));

            date.add(Calendar.DAY_OF_MONTH, -1);
            manager.register(new VideoSelectedEventDataRow(null, 8, 700, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 9, 600, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 10, 500, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 11, 400, date.getTime()));
            manager.register(new VideoSelectedEventDataRow(null, 12, 300, date.getTime()));

            List<String> list = new DirectorTablet().wPrintAdvertisementProfit();

            String actual = list.toString();
            String expected = "[28-Feb-2015 - 0.06, 27-Feb-2015 - 0.22, 26-Feb-2015 - 0.50, Total - 0.78\r\n]";
            assertEquals(expected, actual);
        }

        @Test
        public void testWPrintCookWorkloading() throws Exception {

            StatisticManager manager = StatisticManager.getInstance();

            GregorianCalendar date = new GregorianCalendar();
            date.setTime(new Date("march 1 2015"));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Amigo", 10 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Petrov", 20 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Ivanov", 30 * 60, null, date.getTime()));

            date.add(Calendar.DAY_OF_MONTH, -1);
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Amigo", 90 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Petrov", 80 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Ivanov", 70 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Amigo", 60 * 60, null, date.getTime()));

            date.add(Calendar.DAY_OF_MONTH, -1);
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Amigo", 50 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Petrov", 40 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Ivanov", 30 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Amigo", 20 * 60, null, date.getTime()));
            manager.register(new CookedOrderEventDataRow("Tablet{number=4}", "Petrov", 10 * 60, null, date.getTime()));

            List<String> list = new DirectorTablet().wPrintCookWorkloading();

            String actual = list.toString();
            String expected = "[01-Mar-2015, Amigo - 10 min, Ivanov - 30 min, Petrov - 20 min, 28-Feb-2015, Amigo - 150 min, Ivanov - 70 min, Petrov - 80 min, 27-Feb-2015, Amigo - 70 min, Ivanov - 30 min, Petrov - 50 min]";
            assertEquals(expected, actual);
        }
}