package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Alexey on 05.04.2016.
 */
// - у каждого планшета будет свой объект менеджера,
//который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
//        Он также будет взаимодействовать с плеером и отображать ролики

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
}
