package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Alexey on 13.03.2016.
 */
public class StatisticManager {
    private StatisticStorage storage = new StatisticStorage();
    private static StatisticManager ourInstance = new StatisticManager();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public Map<Date, Double> amountPerDay() {
        Map<Date, Double> resultMap = new TreeMap<>(Collections.reverseOrder());

        List<EventDataRow> list = storage.get(EventType.SELECTED_VIDEOS);
        if (list != null && !list.isEmpty()) {
            for (EventDataRow eventData : list) {
                VideoSelectedEventDataRow videoSelected = (VideoSelectedEventDataRow) eventData;
                Date videoDate = zeroTimeOnDate(eventData.getDate());

                if (resultMap.containsKey(videoDate)) {
                    resultMap.put(videoDate, resultMap.get(videoDate) + (0.01d * (double) videoSelected.getAmount()));
                } else {
                    resultMap.put(videoDate, (0.01d * (double) videoSelected.getAmount()));
                }
            }
        }
        return resultMap;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        Map<Date, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> list = storage.get(EventType.COOKED_ORDER);
        if (list != null && !list.isEmpty()) {
            for (EventDataRow c : list) {
                CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) c;
                Date date = zeroTimeOnDate(c.getDate());
                int time = cookedOrder.getTime();

                if (time == 0) continue;
                if (time % 60 == 0) time = time / 60;
                else time = time / 60 + 1;

                if (result.containsKey(date)) {
                    Map<String, Integer> cookInfo = result.get(date);
                    if (cookInfo.containsKey(cookedOrder.getCookName()))
                        cookInfo.put(cookedOrder.getCookName(), cookInfo.get(cookedOrder.getCookName()) + time);
                    else cookInfo.put(cookedOrder.getCookName(), time);
                } else {
                    TreeMap<String, Integer> cookInfo = new TreeMap<>();
                    cookInfo.put(cookedOrder.getCookName(), time);
                    result.put(date, cookInfo);
                }
            }
        }
        return result;
    }

    public void register(EventDataRow data) {
        if (data == null) return;
        storage.put(data);
    }

    public void register(Cook cook) {
        if (cook == null) return;
        cooks.add(cook);
    }

    private Date zeroTimeOnDate(Date date) {
        GregorianCalendar result = new GregorianCalendar();
        result.setTime(date);
        result.set(Calendar.HOUR_OF_DAY, 0);
        result.set(Calendar.MINUTE, 0);
        result.set(Calendar.SECOND, 0);
        result.set(Calendar.MILLISECOND, 0);
        return result.getTime();
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> hashMap = new HashMap<>();

        private StatisticStorage() {
            for (EventType e : EventType.values()) {
                hashMap.put(e, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            if (data == null) return;
            hashMap.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType eventType) {
            return hashMap.get(eventType);
        }

    }
}
