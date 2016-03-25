package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Alexey on 16.02.2016.
 */
public class Advertisement implements Comparable
{
    private final Object content;
    private final String name;
    private long initialAmount; // - начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits; // - количество оплаченных показов
    private int duration; // - продолжительность в секундах
    private long amountPerOneDisplaying; //Оно должно равняться стоимости одного показа рекламного объявления в копейках.

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;  // - начальная сумма, стоимость рекламы в копейках.
        this.hits = hits; // - количество оплаченных показов
        this.duration = duration; // - продолжительность в секундах
        this.amountPerOneDisplaying = initialAmount / hits; //стоимость одного показа рекламного объявления в копейках.
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }


    public void revalidate()
    {
        if (hits - 1 < 0) throw new UnsupportedOperationException();
        hits--;
    }

    @Override
    public int compareTo(Object o)
    {
        Advertisement a = (Advertisement) o;
        return (int) (amountPerOneDisplaying * 1000 / duration - a.getAmountPerOneDisplaying() * 1000 / a.getDuration());
    }

    public int getHits() {
        return hits;
    }
}
