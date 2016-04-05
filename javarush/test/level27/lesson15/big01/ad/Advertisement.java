package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Alexey on 05.04.2016.
 */
public class Advertisement {
    private Object content;// - видео
    private String name;// - имя/название
    private long initialAmount;// - начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits;// - количество оплаченных показов
    private int duration;// - продолжительность в секундах

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
    }


}
