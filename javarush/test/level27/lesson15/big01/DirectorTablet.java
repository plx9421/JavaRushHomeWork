package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Alexey on 04.04.2016.
 */
public class DirectorTablet {
    private DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    //    1) какую сумму заработали на рекламе, сгруппировать по дням
    public void printAdvertisementProfit() {
        double total = 0d;

        for (Map.Entry<Date, Double> entry : StatisticManager.getInstance().amountPerDay().entrySet()) {
            double profit = entry.getValue() * 1.0 / 100f;
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", df.format(entry.getKey()), profit));
            total += profit;
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
    }

    //    2) загрузка (рабочее время) повара, сгруппировать по дням
    public void printCookWorkloading() {
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticManager.getInstance().getCookWorkloading().entrySet()) {
            ConsoleHelper.writeMessage(df.format(entry.getKey()));
            for (Map.Entry<String, Integer> cooksEntry : entry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %d min", cooksEntry.getKey(), cooksEntry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }

    }

    //    3) список активных роликов и оставшееся количество показов по каждому
    public void printActiveVideoSet() {
    }

    //    4) список НЕактивных роликов (с оставшемся количеством показов равным нулю)
    public void printArchivedVideoSet() {
    }


}
