package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.*;

/**
 * Created by Alexey on 13.03.2016.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {}

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> hashMap = new HashMap<>();
        private StatisticStorage() {
            for (EventType e : EventType.values()){
                hashMap.put(e, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data){
            hashMap.get(data.getType()).add(data);
        }
    }
}
