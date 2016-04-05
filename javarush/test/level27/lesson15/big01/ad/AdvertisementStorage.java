package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Alexey on 05.04.2016.
 */
public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
    }
}
