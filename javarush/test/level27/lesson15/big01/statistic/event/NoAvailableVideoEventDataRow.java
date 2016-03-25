package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Alexey on 13.03.2016.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow{
    private int totalDuration;  //totalDuration - время приготовления заказа в секундах
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }
}
