package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list() == null || storage.list().isEmpty()) throw new NoVideoAvailableException();

        List<Advertisement> selected = new ArrayList<>();
        selected.addAll(storage.list());

        Collections.sort(selected, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long amount1 = o1.getAmountPerOneDisplaying();
                long amount2 = o2.getAmountPerOneDisplaying();
                if (amount1 != amount2)
                    return Long.compare(amount2, amount1);
                return Long.compare(1000 * amount1 / o1.getDuration(), 1000 * amount2 / o2.getDuration());
            }
        });

        long amount = 0;
        int totalDuration = 0;

        for (Advertisement advertisement : selected) {
            amount += advertisement.getAmountPerOneDisplaying();
            totalDuration += advertisement.getDuration();

            ConsoleHelper.writeMessage(String.format("%s  is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()
            ));
            advertisement.revalidate();
        }
    }
}
