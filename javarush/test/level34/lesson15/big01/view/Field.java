package com.javarush.test.level34.lesson15.big01.view;


import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.GameObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexey on 23.03.2016.
 */
public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics graphics) {
//        new com.javarush.test.level34.lesson15.big01.model.Box(100, 100).draw(g);
//        new com.javarush.test.level34.lesson15.big01.model.Player(200, 200).draw(g);
//        new com.javarush.test.level34.lesson15.big01.model.Home(300, 300).draw(g);

        graphics.setColor(Color.BLACK);
        graphics.fillRect(1, 1, view.getWidth(), view.getHeight());

        for (GameObject g : view.getGameObjects().getAll())
            g.draw(graphics);


    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

}
