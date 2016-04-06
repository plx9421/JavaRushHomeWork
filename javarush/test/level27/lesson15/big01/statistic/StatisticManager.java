package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alexey on 06.04.2016.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

//For Test. Begin
    public StatisticStorage getStorage() {
        return storage;
    }

    public Map<EventType, List<EventDataRow>> getEvents() {
        return storage.events;
    }

//For Test. End


    private StatisticManager() {
    }

    public void register(EventDataRow data){
        if (data == null) return;
        storage.put(data);
    }

    private class StatisticStorage{
        Map<EventType, List<EventDataRow>> events = new TreeMap<>();


        public StatisticStorage() {
            for (EventType event : EventType.values()) {
                events.put(event, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            if (data == null) return;
            events.get(data.getType()).add(data);
        }
    }
}
