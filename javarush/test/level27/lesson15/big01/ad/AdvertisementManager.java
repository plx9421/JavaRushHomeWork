package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

/**
 * Created by Alexey on 05.04.2016.
 */
// - у каждого планшета будет свой объект менеджера,
//который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
//        Он также будет взаимодействовать с плеером и отображать ролики

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        ConsoleHelper.writeMessage("processVideos method calling");
    }
}
