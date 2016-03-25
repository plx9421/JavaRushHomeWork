package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexey on 13.03.2016.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

//    private static StatisticManager.StatisticStorage statisticStorage = getInstance().new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }


    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> hashMap = new HashMap<>();

        public StatisticStorage() {
            for (EventType e : EventType.values()){
                hashMap.put(e, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            if (data == null) return;
            hashMap.get(data.getType()).add(data);
        }
    }
}
