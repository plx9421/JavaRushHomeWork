package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexey on 13.03.2016.
 */
public class CookedOrderEventDataRow implements EventDataRow{
    private String tabletName;  //где - tabletName - имя планшета, используйте tablet.toString()
    private String cookName;    //cookName - имя повара
    private int cookingTimeSeconds; //cookingTimeSeconds - время приготовления заказа в секундах
    private List<Dish> cookingDishs; //cookingDishs - список блюд для приготовления
    private Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        this.currentDate = new Date();
    }

    public String getTabletName() {
        return tabletName;
    }

    public String getCookName() {
        return cookName;
    }

    public int getCookingTimeSeconds() {
        return cookingTimeSeconds;
    }

    public List<Dish> getCookingDishs() {
        return cookingDishs;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }
}
