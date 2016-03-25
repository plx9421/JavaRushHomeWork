package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexey on 13.03.2016.
 */
public class VideoSelectedEventDataRow implements EventDataRow{
    private List<Advertisement> optimalVideoSet; //optimalVideoSet - список видео-роликов, отобранных для показа
    private long amount;    //amount - сумма денег в копейках
    private int totalDuration;  //totalDuration - общая продолжительность показа отобранных рекламных роликов
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public List<Advertisement> getOptimalVideoSet() {
        return optimalVideoSet;
    }

    public long getAmount() {
        return amount;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
