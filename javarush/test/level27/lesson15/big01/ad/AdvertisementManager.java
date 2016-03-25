package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Alexey on 16.02.2016.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {

        if (storage.list() == null || storage.list().isEmpty()) throw new NoVideoAvailableException();

        List<Advertisement> selected = getOptimalAdvList(new ArrayList<>(storage.list()), timeSeconds);
        if (selected == null || selected.isEmpty()) throw new NoVideoAvailableException();

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
            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(selected, amount, totalDuration));

            advertisement.revalidate();
        }
    }

    private List<Advertisement> getOptimalAdvList(List<Advertisement> srcList, int timeSeconds) {

        List<List<Advertisement>> combineAdv = combineAdv(srcList, new boolean[srcList.size()], 0, timeSeconds);
        if (combineAdv == null || combineAdv.isEmpty()) return null;

        Collections.sort(combineAdv, new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                long sumCost1 = getSumAdvCost(o1);
                long sumCost2 = getSumAdvCost(o2);
                if (sumCost1 != sumCost2)
                    return Long.compare(sumCost2, sumCost1);
                long sumDur1 = getSumAdvDur(o1);
                long sumDur2 = getSumAdvDur(o2);
                if (sumDur1 != sumDur2)
                    return Long.compare(sumDur2, sumDur1);
                return Long.compare(o1.size(), o2.size());
            }
        });
        return combineAdv.get(0);
    }

    private long getSumAdvDur(List<Advertisement> advList) {
        long res = 0;
        for (Advertisement adv : advList) {
            res += adv.getDuration();
        }
        return res;
    }

    private long getSumAdvCost(List<Advertisement> advList) {
        long res = 0;
        for (Advertisement adv : advList) {
            res += adv.getAmountPerOneDisplaying();
        }
        return res;
    }

    private List<List<Advertisement>> combineAdv(List<Advertisement> srcList, boolean[] takeMask, int startFrom, int timeSeconds) {
        List<List<Advertisement>> resList = new ArrayList<>();
        for (int i = startFrom; i < srcList.size(); i++) {
            Advertisement adv = srcList.get(i);
            if (takeMask[i] || adv.getHits() <= 0 || adv.getDuration() > timeSeconds)
                continue;
            takeMask[i] = true;
            resList.addAll(combineAdv(srcList, takeMask, i + 1, timeSeconds - adv.getDuration()));
            takeMask[i] = false;
        }
        List<Advertisement> tmpList = new ArrayList<>();
        for (int i = 0; i < srcList.size(); i++) {
            if (takeMask[i])
                tmpList.add(srcList.get(i));
        }
        if (tmpList.size() > 0)
            resList.add(tmpList);
        return resList;
    }

}
