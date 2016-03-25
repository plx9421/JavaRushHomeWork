package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by Alexey on 25.03.2016.
 */
public interface EventListener {
    //    передвинуть объект в определенном направлении.
    public void move(Direction direction);

    //    начать заново текущий уровень.
    public void restart();

    //    начать следующий уровень
    public void startNextLevel();

    //    уровень с номером level завершён.
    public void levelCompleted(int level);


}
