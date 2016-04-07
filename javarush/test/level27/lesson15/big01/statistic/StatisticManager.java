package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.*;

/**
 * Created by Alexey on 06.04.2016.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

//For Test. Begin
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
    public void register(Cook cook){
        cooks.add(cook);
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
