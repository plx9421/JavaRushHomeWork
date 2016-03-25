package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Alexey on 23.03.2016.
 */
public abstract class CollisionObject extends GameObject {

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case UP:
                if (getX() == gameObject.getX() && getY() - Model.FIELD_SELL_SIZE == gameObject.getY()) return true;
                else return false;
            case DOWN:
                if (getX() == gameObject.getX() && getY() + Model.FIELD_SELL_SIZE == gameObject.getY()) return true;
                else return false;
            case LEFT:
                if (getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) return true;
                else return false;
            case RIGHT:
                if (getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) return true;
                else return false;
        }
        return false;
    }

}
