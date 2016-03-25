package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Alexey on 23.03.2016.
 */
public class Model {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    LevelLoader levelLoader = new LevelLoader(Paths.get("\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));


    public static final int FIELD_SELL_SIZE = 20;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){
        return gameObjects;
    }

    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }

    //TODO over ingeneering???
    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {

    }
}
