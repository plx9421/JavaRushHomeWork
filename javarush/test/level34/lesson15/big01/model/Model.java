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
    LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\Users\\Alexey\\OneDrive\\Documents\\workspace.java\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));


    public static final int FIELD_SELL_SIZE = 20;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    //TODO over ingeneering???
    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollision(direction)) return;

        moving(player, direction);
        checkCompletion();
    }

//    метод проверяет столкновение со стеной. Он должен вернуть true, если при движении
//    объекта gameObject в направлении direction произойдет столкновение со стеной,
//    иначе false. Для определения столкновения используй метод isCollision() у игрового
//    объекта.

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (GameObject g : gameObjects.getWalls()) {
            if (gameObject.isCollision(g, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {
        Player player = gameObjects.getPlayer();

        for (Box box : gameObjects.getBoxes()) {
            if (player.isCollision(box, direction)) {

                if (checkWallCollision(box, direction)) return true;

                for (Box box1 : gameObjects.getBoxes()) {
                    if (box.equals(box1)) continue;
                    if (box.isCollision(box1, direction)) return true;
                }

                moving(box, direction);
            }
        }

        return false;
    }

    private void moving(Movable movable, Direction direction) {
        switch (direction) {
            case UP:
                movable.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                movable.move(0, FIELD_SELL_SIZE);
                break;
            case LEFT:
                movable.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                movable.move(FIELD_SELL_SIZE, 0);
                break;
        }
    }

    public void checkCompletion() {
        for (Home home : gameObjects.getHomes()) {
            boolean isHomeEmpty = true;
            for (Box box : gameObjects.getBoxes()) {
                if (box.getX() == home.getX() && box.getY() == home.getY()) {
                    isHomeEmpty = false;
                    break;
                }
            }
            if (isHomeEmpty) return;
        }
        eventListener.levelCompleted(currentLevel);
    }

}
