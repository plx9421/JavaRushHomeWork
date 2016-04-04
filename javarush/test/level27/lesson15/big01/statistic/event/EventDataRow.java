package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Alexey on 13.03.2016.
 */
public interface EventDataRow {

    EventType getType();

    //    реализация которого вернет дату создания записи
    Date getDate();

    //    реализация которого вернет время - продолжительность
    int getTime();
}
