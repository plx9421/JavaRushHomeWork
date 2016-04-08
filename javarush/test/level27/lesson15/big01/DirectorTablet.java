package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alexey on 07.04.2016.
 */
public class DirectorTablet {
    private DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    //    Для модуля тестов - Начало
    private List<String> outPutList = new ArrayList<>();

    public List<String> wPrintAdvertisementProfit() {
        outPutList = new ArrayList<>();
        printAdvertisementProfit();
        return outPutList;
    }

    public List<String> wPrintCookWorkloading() {
        outPutList = new ArrayList<>();
        printCookWorkloading();
        return outPutList;
    }
    //Для модуля тестов - Конец


    //    1) какую сумму заработали на рекламе, сгруппировать по дням
    public void printAdvertisementProfit() {
        double total = 0d;

        Map<Date, Double> mapAmount = StatisticManager.getInstance().getAmount();
        for (Map.Entry<Date, Double> entry : mapAmount.entrySet()) {
            double profit = entry.getValue();
            String message = String.format(Locale.ENGLISH, "%s - %.2f", df.format(entry.getKey()), profit);
            ConsoleHelper.writeMessage(message);
            outPutList.add(message);
            total += profit;
        }
        String message = String.format(Locale.ENGLISH, "Total - %.2f%n", total);
        ConsoleHelper.writeMessage(message);
        outPutList.add(message);
    }

    //    2) загрузка (рабочее время) повара, сгруппировать по дням
    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> mapCookWorkLoading = StatisticManager.getInstance().getCookWorkloading();
        for (Map.Entry<Date, Map<String, Integer>> entry : mapCookWorkLoading.entrySet()) {
            String message = df.format(entry.getKey());
            ConsoleHelper.writeMessage(message);
            outPutList.add(message);

            Map<String, Integer> mapCooksForDay =  entry.getValue();
            for (Map.Entry<String, Integer> cooksEntry : mapCooksForDay.entrySet()) {
                message = String.format(Locale.ENGLISH, "%s - %d min", cooksEntry.getKey(), cooksEntry.getValue());
                ConsoleHelper.writeMessage(message);
                outPutList.add(message);
            }

            ConsoleHelper.writeMessage("");
        }

    }

    public void printActiveVideoSet() {
    }

    public void printArchivedVideoSet() {
    }
}
